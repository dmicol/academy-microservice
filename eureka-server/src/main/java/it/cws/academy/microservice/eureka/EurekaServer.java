/**
 * 
 */
package it.cws.academy.microservice.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Dmitrij.colautti
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer {
  public static void main(String[] args) {
      SpringApplication.run(EurekaServer.class, args);
  }
}
