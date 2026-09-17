package Creational.Builder.ApplicationConfiguration.Product;

public class ApplicationConfiguration {
    private final String applicationName;
    private final String databaseUrl;
    private final String databaseUsername;
    private final String databasePassword;
    private final int serverPort;
    private final String JWTSecret;
    private final String loggingLevel;
    private final boolean cacheEnabled;
    private final String redisUrl;

    public ApplicationConfiguration(String applicationName, String databaseUrl, String databaseUsername, String databasePassword, int serverPort, String JWTSecret, String loggingLevel, boolean cacheEnabled, String redisUrl) {
        this.applicationName = applicationName;
        this.databaseUrl = databaseUrl;
        this.databaseUsername = databaseUsername;
        this.databasePassword = databasePassword;
        this.serverPort = serverPort;
        this.JWTSecret = JWTSecret;
        this.loggingLevel = loggingLevel;
        this.cacheEnabled = cacheEnabled;
        this.redisUrl = redisUrl;
    }

    public void show(){
        System.out.println("================================");
        System.out.println("Application Configuration");
        System.out.println("================================");

        System.out.println("Application Name: " + applicationName);
        System.out.println("Database URL: " + databaseUrl);
        System.out.println("Database Username: " + databaseUsername);
        System.out.println("Database Password: " + databasePassword);
        System.out.println("Server Port: " + serverPort);
        System.out.println("JWT Secret: " + JWTSecret);
        System.out.println("Logging Level: " + loggingLevel);
        System.out.println("Cache Enabled: " + cacheEnabled);
        System.out.println("Redis URL: " + redisUrl);

        System.out.println("================================");
    }
}
