/**
 * 
 */
package it.cws.academy.microservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import it.cws.academy.microservice.model.Person;

/**
 * @author Dmitrij.colautti
 *
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {

	Page<Person> findByNameContaining(String name, Pageable page);
}
