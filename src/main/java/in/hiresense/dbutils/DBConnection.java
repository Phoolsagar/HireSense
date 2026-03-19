package in.hiresense.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

	private static final Logger LOGGER = Logger.getLogger(DBConnection.class.getName());

	private static Connection conn;
	private static String dbUrl;
	private static String dbUsername;
	private static String dbPassword;

	public static void openConnection(String url, String username, String password) {
		dbUrl = url;
		dbUsername = username;
		dbPassword = password;

		try {
			loadMySqlDriver();
			conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			LOGGER.info("Connection opened successfully");
		} catch (SQLException ex) {
			LOGGER.log(Level.SEVERE,
					"Unable to open database connection. url=" + dbUrl + ", username=" + dbUsername, ex);
		} catch (ClassNotFoundException ex) {
			LOGGER.log(Level.SEVERE, "MySQL JDBC driver class not found in runtime classpath", ex);
		}

	}

	public static Connection getConnection() throws SQLException {
		if (conn == null || conn.isClosed()) {
			if (dbUrl == null || dbUsername == null) {
				throw new SQLException(
						"Connection is null because DB config is not initialized. Ensure AppInitializer ran and context params are set.");
			}

			try {
				loadMySqlDriver();
			} catch (ClassNotFoundException ex) {
				throw new SQLException("MySQL JDBC driver class not found in runtime classpath", ex);
			}

			conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			LOGGER.info("Database connection restored via lazy reconnect");
		}
		return conn;
	}

	private static void loadMySqlDriver() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}

	public static void closeConnection() {

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

	}

}
