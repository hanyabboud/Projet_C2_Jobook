package lb.cnam.c2.v1.apis.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class CommentEntity {

	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private UserEntity user;
	
//	@Column(name="user_id")
//	private int userId;
	
	@Column(name="job_id")
	private int jobId;
	
	@Column(name="content")
	private String content;
	
	@Column(name="creation_date")
	private String creationDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

}