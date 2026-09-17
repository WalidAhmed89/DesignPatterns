package Creational.Builder.ApplicationConfiguration.Director;

import Builder.ApplicationConfiguration.Builder.ApplicationConfigurationBuilder;
import Builder.ApplicationConfiguration.Product.ApplicationConfiguration;

public class ApplicationConfigurationDirector {
    public ApplicationConfiguration construct(ApplicationConfigurationBuilder builder){
        builder.setApplicationName();
        builder.setDatabase();
        builder.setServerPort();
        builder.setJWTSecret();
        builder.setLoggingLevel();
        builder.setCacheEnabled();
        builder.setRedisUrl();

        return builder.build();
    }
}
