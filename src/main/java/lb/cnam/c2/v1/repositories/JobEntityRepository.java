package lb.cnam.c2.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import lb.cnam.c2.v1.apis.entities.JobEntity;

@RepositoryRestResource
public interface JobEntityRepository extends JpaRepository<JobEntity, Integer>, JpaSpecificationExecutor<JobEntity> {
	
}