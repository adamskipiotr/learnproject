package com.pada.learnproject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@DirtiesContext
@ContextConfiguration(initializers = LearnprojectApplicationTests.TestEnvInitializer.class)
@TestPropertySource(properties = {
    "spring.datasource.driver-class-name="
})
public class LearnprojectApplicationTests {

    @Container
    private static final PostgreSQLContainer<?> POSTGRES_DB = new PostgreSQLContainer<>("postgres:12.8")
        .withDatabaseName("testdb")
        .withUsername("postgres")
        .withPassword("postgres");

    @Test
    void testFakeData() {
    }
    
    static class TestEnvInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            TestPropertyValues values = TestPropertyValues.of(
                "spring.datasource.url=" + POSTGRES_DB.getJdbcUrl(),
                "spring.datasource.password=" + POSTGRES_DB.getPassword(),
                "spring.datasource.username=" + POSTGRES_DB.getUsername()
            );
            values.applyTo(applicationContext);
        }
    }
}
