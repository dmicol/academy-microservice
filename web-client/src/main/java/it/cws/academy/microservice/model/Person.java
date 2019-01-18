package it.cws.academy.microservice.model;
/**
 * 
 */


import java.time.LocalDate;

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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	private Integer id;
	
	@NotBlank
	private String name;
	@NotNull
	private LocalDate birthDate;
	
}
