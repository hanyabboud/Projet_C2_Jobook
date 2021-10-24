package lb.cnam.c2.v1.apis.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lb.cnam.c2.v1.apis.entities.CommentEntity;
import lb.cnam.c2.v1.apis.entities.JobEntity;
import lb.cnam.c2.v1.apis.modals.responses.Response;
import lb.cnam.c2.v1.apis.modals.responses.web.JobModal;
import lb.cnam.c2.v1.apis.utils.JobUtils;
import lb.cnam.c2.v1.repositories.CommentEntityRepository;
import lb.cnam.c2.v1.repositories.JobEntityRepository;

@Service("jobService")
public class JobServiceImpl implements JobService {

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private CommentEntityRepository commentEntityRepository;

	@Autowired
	private JobEntityRepository jobEntityRepository;
	
	@PersistenceContext
    EntityManager entityManager;
	
	@Override
	public Response fetchJobsByEnum(String body, String search, int jobEnum) {
		Response response = null;
		
		// Check Job Enum
		if(jobEnum != 0 || jobEnum != 1 || jobEnum != 2) {
			response = new Response(false, "Invalid Job Enum.");
		}
		
		try {
			JSONObject bodyJO = new JSONObject(body);

			String filtersQuery = JobUtils.getFiltersQuery(bodyJO);
			
			String searchQuery = JobUtils.getSearchQuery(search);
			
			String sortsQuery = JobUtils.getSortsQuery(bodyJO);
			
			String enumQuery = jobEnum == 0?"":"AND j.job_enum = " + jobEnum + " ";
			
			String queryStr = 
				   "SELECT "
					
				 // user
				 + "	u.id as userId,"
				 + "	u.username as userUsername, "
				 + "	u.email as userEmail, "
				 + "	u.first_name as userFirstName, "
				 + "	u.last_name as userLastName, "
				 + "	u.title as userTitle, "
				 + "	u.creation_date as userCreationDate, "
				 
				 // job
				 + "	j.id as jobId, "
				 + "	j.job_enum as jobEnum, "
				 + "	j.title as jobTitle, "
				 + "	j.description as jobDescription, "
				 + "	j.salary_from as jobSalaryFrom, "
				 + "	j.salary_to as jobSalaryTo, "
				 + "	j.deadline as jobDeadline, "
				 + "	j.creation_date as jobCreationDate, "
				 
				 // job environment
				 + "	jenv.id as jenvId, "
				 + "	jenv.name as jenvName, "
				 
				 // job experience
				 + "	jexp.id as jexpId, "
				 + "	jexp.name as jexpName, "
				 
				 // job type
				 + "	jt.id as jtId, "
				 + "	jt.name as jtName, "
				 
				 // job enum
				 + "	je.name as jeName "
				 
				 + "FROM job as j "
				 + "INNER JOIN job_enum as je on je.id = j.job_enum "
				 + "INNER JOIN job_environment as jenv on jenv.id = j.environment "
				 + "INNER JOIN job_experience as jexp on jexp.id = j.experience "
				 + "INNER JOIN job_type as jt on jt.id = j.type "
				 + "INNER JOIN user as u on u.id = j.user_id "
				 + "WHERE 1=1 "
				 + enumQuery
				 + searchQuery
				 + filtersQuery
				 + sortsQuery;
			
			Query query = entityManager.createNativeQuery(queryStr);

	        ArrayList<JobModal> jobs = new ArrayList<JobModal>();
	        
	        Iterator<?> result = query.getResultList().iterator();
	        while(result.hasNext()) {
	        	Object[] obj = (Object[]) result.next();
	        	
	        	JobModal job = new JobModal(obj);
	        	
	        	List<CommentEntity> comments = commentEntityRepository.fetchByJobId(job.getJobId());
	        	job.setComments(comments);
	        	
	        	jobs.add(job);
	        }
	        
			response = new Response(true, "[Job] Fetched by Enum Successfully.", jobs);
		} catch (Exception e) {
			// Create Fail Response
			response = new Response(false, e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public Response fetchJobsByUser(int userId) {
		Response response = null;
		
		try {
			String filtersQuery = "AND u.id = " + userId + " ";
			
			String sortsQuery = "ORDER BY j.creation_date DESC";
			
			String queryStr = 
				   "SELECT "
					
				 // user
				 + "	u.id as userId,"
				 + "	u.username as userUsername, "
				 + "	u.email as userEmail, "
				 + "	u.first_name as userFirstName, "
				 + "	u.last_name as userLastName, "
				 + "	u.title as userTitle, "
				 + "	u.creation_date as userCreationDate, "
				 
				 // job
				 + "	j.id as jobId, "
				 + "	j.job_enum as jobEnum, "
				 + "	j.title as jobTitle, "
				 + "	j.description as jobDescription, "
				 + "	j.salary_from as jobSalaryFrom, "
				 + "	j.salary_to as jobSalaryTo, "
				 + "	j.deadline as jobDeadline, "
				 + "	j.creation_date as jobCreationDate, "
				 
				 // job environment
				 + "	jenv.id as jenvId, "
				 + "	jenv.name as jenvName, "
				 
				 // job experience
				 + "	jexp.id as jexpId, "
				 + "	jexp.name as jexpName, "
				 
				 // job type
				 + "	jt.id as jtId, "
				 + "	jt.name as jtName, "
				 
				 // job enum
				 + "	je.name as jeName "
				 
				 + "FROM job as j "
				 + "INNER JOIN job_enum as je on je.id = j.job_enum "
				 + "INNER JOIN job_environment as jenv on jenv.id = j.environment "
				 + "INNER JOIN job_experience as jexp on jexp.id = j.experience "
				 + "INNER JOIN job_type as jt on jt.id = j.type "
				 + "INNER JOIN user as u on u.id = j.user_id "
				 + "WHERE 1=1 "
				 + filtersQuery
				 + sortsQuery;
			
			Query query = entityManager.createNativeQuery(queryStr);

			HashMap<Integer, List<CommentEntity>> commentsMap = commentService.fetchCommentsMapByUserId(userId);
			
	        ArrayList<JobModal> jobs = new ArrayList<JobModal>();
	        
	        Iterator<?> result = query.getResultList().iterator();
	        while(result.hasNext()) {
	        	Object[] obj = (Object[]) result.next();
	        	
	        	JobModal job = new JobModal(obj);
	        	
	        	List<CommentEntity> comments = commentsMap.get(job.getJobId());
	        	if(comments == null) comments = new ArrayList<CommentEntity>();
	        	
	        	job.setComments(comments);
	        	
	        	jobs.add(job);
	        }
	        
			response = new Response(true, "[Job] Fetched by User Successfully.", jobs);
		} catch (Exception e) {
			// Create Fail Response
			response = new Response(false, e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public Response createJob(JobEntity job) {
		Response response = null;
		
		try {
			// Generate Current Date
			String creationDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
			
			// Add Date
			job.setCreationDate(creationDate);
			
			// Save
			job = jobEntityRepository.save(job);
			
			// Create Success Response
			response = new Response(true, "Job Created Successfully.", job);
		} catch(Exception e) {
			// Create Fail Response
			response = new Response(false, e.getMessage());
			e.printStackTrace();
		}
		
		return response;
	}

	@Override
	public Response deleteJob(int jobId) {
		Response response = null;
		
		try {
			// Delete Job
			jobEntityRepository.deleteById(jobId);
			
			// Create Success Response
			response = new Response(true, "Job Deleted Successfully.", true);
		} catch(Exception e) {
			// Create Fail Response
			response = new Response(false, e.getMessage());
			e.printStackTrace();
		}
		
		return response;
	}

}