/**
 * 
 */
package it.cws.academy.microservice.web_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Dmitrij.colautti
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class WebClientServiceMain {

	public static void main(String[] args) {
		SpringApplication.run(WebClientServiceMain.class, args);
	}
}
