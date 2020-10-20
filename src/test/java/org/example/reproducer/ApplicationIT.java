package org.example.reproducer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(initializers = RabbitMQContainerApplicationInitializer.class)
public class ApplicationIT {

  @Test
  public void contextLoads() {
    //nothing to do
  }
}
