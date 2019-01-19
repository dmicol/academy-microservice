package it.cws.academy.microservice.zuul;
/**
 * 
 */


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author Dmitrij.colautti
 *
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ZuulServer {
  public static void main(String[] args) {
      SpringApplication.run(ZuulServer.class, args);
  }
}
