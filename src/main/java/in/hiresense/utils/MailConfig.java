package in.hiresense.utils;

import java.util.Properties;

import javax.mail.Session;


public class MailConfig {

    private static final String USERNAME = getConfig("HIRESENSE_MAIL_USERNAME", "");
    private static final String PASSWORD = getConfig("HIRESENSE_MAIL_PASSWORD", "");

    private static String getConfig(String envKey, String defaultValue) {
        String value = System.getenv(envKey);
        if (value == null || value.isBlank()) {
            return defaultValue;
        }
        return value;
    }

	public static Session getSession() {
	   Properties prop = new Properties();
	   prop.put("mail.smtp.host", "smtp.gmail.com");
	   prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
       prop.put("mail.smtp.port", "465");
       prop.put("mail.smtp.auth", "true");
       prop.put("mail.smtp.socketFactory.port", "465");
       prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
       MyAuthenticator auth=new MyAuthenticator(USERNAME,PASSWORD);
       return Session.getInstance(prop, auth);
       
	}
}
