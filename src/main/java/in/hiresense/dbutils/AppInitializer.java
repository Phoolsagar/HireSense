package in.hiresense.dbutils;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppInitializer implements ServletContextListener {

	private String resolveConfig(String envKey, String fallbackValue) {
		String envValue = System.getenv(envKey);
		if (envValue != null && !envValue.isBlank()) {
			return envValue;
		}
		return fallbackValue;
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();

		//Database credentials
		String url = resolveConfig("HIRESENSE_DB_URL", sc.getInitParameter("url"));
		String username = resolveConfig("HIRESENSE_DB_USERNAME", sc.getInitParameter("username"));
		String password = resolveConfig("HIRESENSE_DB_PASSWORD", sc.getInitParameter("password"));

		//Connect with the database
		DBConnection.openConnection(url,username,password);
		sc.log("HireSense AppInitializer executed. DB URL=" + url + ", user=" + username);

		//Set application name
		String appName = resolveConfig("HIRESENSE_APP_NAME", sc.getInitParameter("appName"));
		sc.setAttribute("appName", appName);

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		DBConnection.closeConnection();
	}

}
