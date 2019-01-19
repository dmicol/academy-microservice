/**
 * 
 */
package it.cws.academy.microservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.ipc.http.HttpSender.Method;
import it.cws.academy.microservice.model.Person;
import it.cws.academy.microservice.service.PersonRepository;

/**
 * @author Dmitrij.colautti
 *
 */
@RestController
public class PersonController {
	private static final Logger log = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	private PersonRepository repo;

	@GetMapping(path="/pers")
	public Person pers(@RequestParam(value="id") int id) {
		log.info("called pers:"+id);
		return repo.findById(id).get();
		
	}
}
