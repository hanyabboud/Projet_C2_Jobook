package lb.cnam.c2.v1.apis.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lb.cnam.c2.v1.apis.entities.CommentEntity;
import lb.cnam.c2.v1.apis.entities.JobEntity;
import lb.cnam.c2.v1.apis.entities.UserEntity;
import lb.cnam.c2.v1.apis.exceptions.custom.InvalidCommentException;
import lb.cnam.c2.v1.apis.exceptions.custom.InvalidJobException;
import lb.cnam.c2.v1.apis.exceptions.custom.InvalidUserException;
import lb.cnam.c2.v1.apis.modals.responses.Response;
import lb.cnam.c2.v1.repositories.CommentEntityRepository;
import lb.cnam.c2.v1.repositories.JobEntityRepository;
import lb.cnam.c2.v1.repositories.UserEntityRepository;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Autowired
	private JobEntityRepository jobEntityRepository;

	@Autowired
	private UserEntityRepository userEntityRepository;

	@Autowired
	private CommentEntityRepository commentEntityRepository;

	@Override
	public Response addComment(int jobId, int userId, CommentEntity comment) {
		Response response = null;
		
		try {
			// Check jobId
			Optional<JobEntity> optionalJobEntity = jobEntityRepository.findById(jobId);
			if(optionalJobEntity == null) {
				throw new InvalidJobException(userId);
			}
			
			// Check userId
			Optional<UserEntity> optionalUserEntity = userEntityRepository.findById(userId);
			if(optionalUserEntity == null) {
				throw new InvalidUserException(userId);
			}
			
			// Generate Current Date
			String creationDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
			
			// Add Date
			comment.setCreationDate(creationDate);
						
			// Set Comment Job ID
			comment.setJobId(jobId);
			
			// Set Comment User ID
			comment.setUser(optionalUserEntity.get());
			
			// Save
			commentEntityRepository.save(comment);
			
			// Fetch Comments
			List<CommentEntity> commentList = commentEntityRepository.findByJobIdAndUserId(jobId, userId);
			
			// Build Success Response
			response = new Response(true, "Comment Created Successfully.", commentList);
		} catch(Exception e) {
			// Create Fail Response
			response = new Response(false, e.getMessage());
			e.printStackTrace();
		}
		
		return response;
	}
	
	@Override
	public HashMap<Integer, List<CommentEntity>> fetchCommentsMapByUserId(int userId) {
		HashMap<Integer, List<CommentEntity>> commentsMap = new HashMap<Integer, List<CommentEntity>>();
		
		// Check userId
		Optional<UserEntity> optionalUserEntity = userEntityRepository.findById(userId);
		if(optionalUserEntity == null) {
			throw new InvalidUserException(userId);
		}
		
		try {
			List<CommentEntity> commentList = commentEntityRepository.findByUserId(userId);
			for(int i=0;i<commentList.size();i++) {
				CommentEntity comment = commentList.get(i);
				int jobId = comment.getJobId();
				
				List<CommentEntity> targetCommentList = null;
				if(commentsMap.containsKey(jobId)) {
					targetCommentList = commentsMap.get(jobId);
				} else {
					targetCommentList = new ArrayList<CommentEntity>();
				}
				targetCommentList.add(comment);
				commentsMap.put(jobId, targetCommentList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commentsMap;
	}

	@Override
	public Response deleteComment(int commentId) {
		Response response = null;
		
		try {
			// Check jobId
			Optional<CommentEntity> commentEntity = commentEntityRepository.findById(commentId);
			if(commentEntity == null) {
				throw new InvalidCommentException(commentId);
			}
			
			// Delete Comment By ID
			commentEntityRepository.deleteById(commentId);
			
			// Build Success Response
			response = new Response(true, "Comment Created Successfully.", "Success");
		} catch(Exception e) {
			// Create Fail Response
			response = new Response(false, e.getMessage());
			e.printStackTrace();
		}
		
		return response;
	}

}