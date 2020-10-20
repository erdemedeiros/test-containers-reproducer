package org.example.reproducer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
public class ApplicationTest {

  @Container
  private static RabbitMQContainer rabbitMQContainer = new RabbitMQContainer("rabbitmq:management");


  @DynamicPropertySource
  static void rabbitMQProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.rabbitmq.host", rabbitMQContainer::getContainerIpAddress);
    registry.add("spring.rabbitmq.port", rabbitMQContainer::getAmqpPort);
  }

  @Test
  public void contextLoads() {
    //nothing to do
  }
}
