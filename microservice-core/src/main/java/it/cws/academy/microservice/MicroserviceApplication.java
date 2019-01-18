package it.cws.academy.microservice;

import java.time.LocalDate;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import it.cws.academy.microservice.model.Person;
import it.cws.academy.microservice.service.PersonRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceApplication.class, args);
	}

	private String[] arr = {"Dmitirj","Mario","Marta","Cristina","Luisa","Giovanni"};
	
	@Bean
	public CommandLineRunner initializeDB(PersonRepository repo) {
		return (args) -> {
			if (repo.count()<=1) {
				IntStream.range(0, arr.length).forEach(i-> {
					Person p =Person.builder().id(i).name(arr[i]).birthDate(LocalDate.now().minusDays(i)).build();
					repo.save(p);
				});
			}
			
		};
		
	}
}

