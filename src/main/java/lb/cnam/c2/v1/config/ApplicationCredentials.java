package lb.cnam.c2.v1.config;

import java.util.Properties;

public class ApplicationCredentials {
	
	static Properties properties = PropertiesManager.load("/application.properties");
	
	public static String getDatabaseUrl() {
		return properties.getProperty("spring.datasource.url");
	}

	public static String getDatabaseCatalog() {
		return properties.getProperty("jobook");
	}

	public static String getDatabaseUser() {
		return properties.getProperty("spring.datasource.username");
	}

	public static String getDatabasePassword() {
		return properties.getProperty("spring.datasource.password");
	}
	
	public static String getDatabaseDriver() {
		return properties.getProperty("spring.datasource.driver-class-name");
	}

	/** Custom **/
	
	public static Object getDatabaseId() {
		return properties.getProperty("jobook.database.id");
	}

}