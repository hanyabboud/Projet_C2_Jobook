package lb.cnam.c2.v1.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class CustomRoutingDataSource extends AbstractRoutingDataSource {

//	@Autowired
//    private RequestContext requestContext;
	 
    @Override
    public Object determineCurrentLookupKey() {
//    	JSONObject jsonBody = requestContext.getJsonBody();
//        if(jsonBody	!= null && jsonBody.has("customerId")) {
//	        final String customerId = jsonBody.getString("customerId");
//            return customerId;
//        }
        return ApplicationCredentials.getDatabaseId(); 
    }
}