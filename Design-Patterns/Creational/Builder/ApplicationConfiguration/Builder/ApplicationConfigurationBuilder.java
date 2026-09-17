package Creational.Builder.ApplicationConfiguration.Builder;

import Builder.ApplicationConfiguration.Product.ApplicationConfiguration;

public interface ApplicationConfigurationBuilder {
    void setApplicationName();
    void setDatabase();
    void setServerPort();
    void setJWTSecret();
    void setLoggingLevel();
    void setCacheEnabled();
    void setRedisUrl();
    ApplicationConfiguration build();
}
