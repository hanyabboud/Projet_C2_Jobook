package lb.cnam.c2.v1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import lb.cnam.c2.v1.apis.entities.CommentEntity;

@RepositoryRestResource
public interface CommentEntityRepository extends JpaRepository<CommentEntity, Integer>, JpaSpecificationExecutor<CommentEntity> {

	@Query(value = "SELECT * FROM comment as c where c.job_id = :jobId and c.user_id = :userId", nativeQuery = true)
	public List<CommentEntity> findByJobIdAndUserId(@Param("jobId") int jobId, @Param("userId") int userId);

	@Query(value = "SELECT * FROM comment as c where c.user_id = :userId", nativeQuery = true)
	public List<CommentEntity> findByUserId(@Param("userId") int userId);

	@Query(value = "SELECT * FROM comment as c where c.job_id = :jobId", nativeQuery = true)
	public List<CommentEntity> fetchByJobId(@Param("jobId") int jobId);
	
}