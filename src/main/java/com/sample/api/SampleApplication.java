package com.sample.api;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ComponentScan(basePackages="com.sample.api")
public class SampleApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(SampleApplication.class);

  public static void main(String[] args) throws UnknownHostException {
    SpringApplication app = new SpringApplication(SampleApplication.class);
    String protocol = "http";
    Environment env = app.run(args).getEnvironment();
    LOGGER.info(
        "\n----------------------------------------------------------\n\t"
            + "Application '{}' up. URLs:\n\t"
            + "Local: \t\t{}://localhost:{}\n\t" + "Extern: \t{}://{}:{}\n\t"
            + "Profile(s): \t{}\n----------------------------------------------------------",
        env.getProperty("spring.application.name"), protocol, env.getProperty("server.port"),
        protocol, InetAddress.getLocalHost().getHostAddress(), env.getProperty("server.port"),
        Arrays.asList(env.getActiveProfiles()));
  }

}
