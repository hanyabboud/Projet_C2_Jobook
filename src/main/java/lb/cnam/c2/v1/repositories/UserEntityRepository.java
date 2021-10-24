package lb.cnam.c2.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import lb.cnam.c2.v1.apis.entities.UserEntity;

@RepositoryRestResource
public interface UserEntityRepository extends JpaRepository<UserEntity, Integer>, JpaSpecificationExecutor<UserEntity> {
	
    @Query(value = "SELECT * FROM user as u where u.username = :username", nativeQuery = true)
    UserEntity findByUsername(@Param("username") String username);

    @Query(value = "SELECT * FROM user as u where u.id = :userId", nativeQuery = true)
	UserEntity findByUserId(@Param("userId") int userId);
    
}