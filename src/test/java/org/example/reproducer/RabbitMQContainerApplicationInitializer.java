package org.example.reproducer;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.RabbitMQContainer;

public class RabbitMQContainerApplicationInitializer implements
    ApplicationContextInitializer<ConfigurableApplicationContext> {

    private static RabbitMQContainer rabbitMQContainer = new RabbitMQContainer("rabbitmq:management")
        .withReuse(true);

    @Override
    public void initialize(ConfigurableApplicationContext context) {

        if (!rabbitMQContainer.isRunning()) {
            rabbitMQContainer.start();
        }

        TestPropertyValues.of(
            "spring.rabbitmq.host=" + rabbitMQContainer.getContainerIpAddress(),
            "spring.rabbitmq.port=" + rabbitMQContainer.getAmqpPort()
        ).applyTo(context.getEnvironment());

    }
}
