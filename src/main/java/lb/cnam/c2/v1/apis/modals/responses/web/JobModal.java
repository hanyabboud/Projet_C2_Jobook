package lb.cnam.c2.v1.apis.modals.responses.web;

import java.util.ArrayList;
import java.util.List;

import lb.cnam.c2.v1.apis.entities.CommentEntity;

public class JobModal {

	// user
	
	private int userId;

	private String userUsername;

	private String userEmail;

	private String userFirstName;

	private String userLastName;

	private String userTitle;

	private String userCreationDate;
	
	 // job

	private int jobId;

	private int jobEnum;

	private String jobTitle;

	private String jobDescription;

	private double jobSalaryFrom;

	private double jobSalaryTo;

	private String jobDeadline;

	private String jobCreationDate;
	
	// job environment

	private int jenvId;
	
	private String jenvName;
	 
	 // job experience

	private int jexpId;
	
	private String jexpName;
	 
	 // job type

	private int jtId;
	
	private String jtName;
	 
	 // job enum

	private String jeName;
	
	// Comments
	private List<CommentEntity> comments;

	public JobModal() {
		super();
	}
	
	public JobModal(Object[] obj) {
		userId = Integer.parseInt(String.valueOf(obj[0]));
		userUsername = String.valueOf(obj[1]);
		userEmail = String.valueOf(obj[2]);
		userFirstName = String.valueOf(obj[3]);
		userLastName = String.valueOf(obj[4]);
		userTitle = String.valueOf(obj[5]);
		userCreationDate = String.valueOf(obj[6]);
		jobId = Integer.parseInt(String.valueOf(obj[7]));
		jobEnum = Integer.parseInt(String.valueOf(obj[8]));
		jobTitle = String.valueOf(obj[9]);
		jobDescription = String.valueOf(obj[10]);
		jobSalaryFrom = Double.parseDouble(String.valueOf(obj[11]));
		jobSalaryTo = Double.parseDouble(String.valueOf(obj[12]));
		jobDeadline = String.valueOf(obj[13]);
		jobCreationDate = String.valueOf(obj[14]);
		jenvId = Integer.parseInt(String.valueOf(obj[15]));
		jenvName = String.valueOf(obj[16]);
		jexpId = Integer.parseInt(String.valueOf(obj[17]));
		jexpName = String.valueOf(obj[18]);
		jtId = Integer.parseInt(String.valueOf(obj[19]));
		jtName = String.valueOf(obj[20]);
		jeName = String.valueOf(obj[21]);
		
		comments = new ArrayList<CommentEntity>();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserUsername() {
		return userUsername;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserTitle() {
		return userTitle;
	}

	public void setUserTitle(String userTitle) {
		this.userTitle = userTitle;
	}

	public String getUserCreationDate() {
		return userCreationDate;
	}

	public void setUserCreationDate(String userCreationDate) {
		this.userCreationDate = userCreationDate;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public int getJobEnum() {
		return jobEnum;
	}

	public void setJobEnum(int jobEnum) {
		this.jobEnum = jobEnum;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public double getJobSalaryFrom() {
		return jobSalaryFrom;
	}

	public void setJobSalaryFrom(double jobSalaryFrom) {
		this.jobSalaryFrom = jobSalaryFrom;
	}

	public double getJobSalaryTo() {
		return jobSalaryTo;
	}

	public void setJobSalaryTo(double jobSalaryTo) {
		this.jobSalaryTo = jobSalaryTo;
	}

	public String getJobDeadline() {
		return jobDeadline;
	}

	public void setJobDeadline(String jobDeadline) {
		this.jobDeadline = jobDeadline;
	}

	public String getJobCreationDate() {
		return jobCreationDate;
	}

	public void setJobCreationDate(String jobCreationDate) {
		this.jobCreationDate = jobCreationDate;
	}

	public int getJenvId() {
		return jenvId;
	}

	public void setJenvId(int jenvId) {
		this.jenvId = jenvId;
	}

	public String getJenvName() {
		return jenvName;
	}

	public void setJenvName(String jenvName) {
		this.jenvName = jenvName;
	}

	public int getJexpId() {
		return jexpId;
	}

	public void setJexpId(int jexpId) {
		this.jexpId = jexpId;
	}

	public String getJexpName() {
		return jexpName;
	}

	public void setJexpName(String jexpName) {
		this.jexpName = jexpName;
	}

	public int getJtId() {
		return jtId;
	}

	public void setJtId(int jtId) {
		this.jtId = jtId;
	}

	public String getJtName() {
		return jtName;
	}

	public void setJtName(String jtName) {
		this.jtName = jtName;
	}

	public String getJeName() {
		return jeName;
	}

	public void setJeName(String jeName) {
		this.jeName = jeName;
	}

	public List<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}

}