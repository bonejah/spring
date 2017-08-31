package br.com.springboot.bonejah.services;

import java.util.List;

import br.com.springboot.bonejah.models.Person;

public interface PersonService {	
	Person create(final Person person);
	Person findById(final String personId);
	Person update(Person person);
	List<Person> findAll();
	void delete(final String personId);
}
