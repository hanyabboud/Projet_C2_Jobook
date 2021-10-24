package lb.cnam.c2.v1.config;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
public class TenantDataSource implements Serializable { 
  
	private static final long serialVersionUID = 1L;

	@PostConstruct
    public static Map<Object, Object> getDataSourceHashMap() {
		Map<Object, Object> result = new HashMap<>();
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(ApplicationCredentials.getDatabaseDriver());
		dataSource.setUrl(ApplicationCredentials.getDatabaseUrl());
		dataSource.setUsername(ApplicationCredentials.getDatabaseUser());
		dataSource.setPassword(ApplicationCredentials.getDatabasePassword());
		
      result.put(ApplicationCredentials.getDatabaseId(), dataSource);
		
      return result;
    } 

}