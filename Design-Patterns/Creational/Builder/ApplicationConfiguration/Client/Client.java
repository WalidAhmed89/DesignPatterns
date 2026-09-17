package Creational.Builder.ApplicationConfiguration.Client;

import Builder.ApplicationConfiguration.Builder.ApplicationConfigurationBuilder;
import Builder.ApplicationConfiguration.ConcretBuilder.DevelopmentBuilder;
import Builder.ApplicationConfiguration.ConcretBuilder.ProductionBuilder;
import Builder.ApplicationConfiguration.ConcretBuilder.TestingBuilder;
import Builder.ApplicationConfiguration.Director.ApplicationConfigurationDirector;

public class Client {
    public static void main(String[] args) {
        ApplicationConfigurationBuilder developmentBuilder = new DevelopmentBuilder();
        ApplicationConfigurationDirector developmentDirector = new ApplicationConfigurationDirector();

        developmentDirector.construct(developmentBuilder);
        developmentBuilder.build().show();

        ApplicationConfigurationBuilder productionBuilder = new ProductionBuilder();
        ApplicationConfigurationDirector productionDirector = new ApplicationConfigurationDirector();

        productionDirector.construct(productionBuilder);
        productionBuilder.build().show();

        ApplicationConfigurationBuilder testingBuilder = new TestingBuilder();
        ApplicationConfigurationDirector testingDirector = new ApplicationConfigurationDirector();
        testingDirector.construct(testingBuilder);
        testingBuilder.build().show();

    }
}
