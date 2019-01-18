/**
 * 
 */
package it.cws.academy.microservice.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dmitrij.colautti
 *
 */

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	@Id
	private Integer id;
	
	@NotBlank
	private String name;
	@NotNull
	private LocalDate birthDate;
	
}
