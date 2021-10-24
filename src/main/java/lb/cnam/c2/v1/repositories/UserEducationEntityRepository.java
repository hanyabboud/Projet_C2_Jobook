package lb.cnam.c2.v1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import lb.cnam.c2.v1.apis.entities.UserEducationEntity;

@RepositoryRestResource
public interface UserEducationEntityRepository extends JpaRepository<UserEducationEntity, Integer>, JpaSpecificationExecutor<UserEducationEntity> {
	
    @Query(value = "SELECT * FROM user_education as ue where ue.user_id = :userId", nativeQuery = true)
	List<UserEducationEntity> findByUserId(@Param("userId") int userId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM user_education where user_id = :userId", nativeQuery = true)
	void deleteByUserId(@Param("userId") int userId);
    
}