package Creational.Builder.ApplicationConfiguration.ConcretBuilder;

import Builder.ApplicationConfiguration.Builder.ApplicationConfigurationBuilder;
import Builder.ApplicationConfiguration.Product.ApplicationConfiguration;

public class ProductionBuilder implements ApplicationConfigurationBuilder {
    private String applicationName;
    private String databaseUrl;
    private String databaseUsername;
    private String databasePassword;
    private int serverPort;
    private String JWTSecret;
    private String loggingLevel;
    private boolean cacheEnabled;
    private String redisUrl;

    @Override
    public void setApplicationName() {
        applicationName = "MyApp-Production";
    }

    @Override
    public void setDatabase() {
        databaseUrl = "jdbc:postgresql://localhost:5432/myapp_dev";
        databaseUsername = "postgres";
        databasePassword = "dev123";
    }

    @Override
    public void setServerPort() {
        serverPort = 8080;
    }

    @Override
    public void setJWTSecret() {
        JWTSecret = "Production-secret-key";
    }

    @Override
    public void setLoggingLevel() {
        loggingLevel = "INFO";
    }

    @Override
    public void setCacheEnabled() {
        cacheEnabled = true;
    }

    @Override
    public void setRedisUrl() {
        redisUrl = "redis://redis-cluster:6379";
    }

    @Override
    public ApplicationConfiguration build() {
        return new ApplicationConfiguration(
                applicationName,
                databaseUrl,
                databaseUsername,
                databasePassword,
                serverPort,
                JWTSecret,
                loggingLevel,
                cacheEnabled,
                redisUrl
        );
    }
}
