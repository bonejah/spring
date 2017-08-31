package br.com.springboot.bonejah.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.springboot.bonejah.models.Person;
import br.com.springboot.bonejah.services.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	private final AtomicLong counter = new AtomicLong();
	private ArrayList<Person> persons = new ArrayList<>();

	@Override
	public Person create(Person person) {
		return person;
	}

	@Override
	public Person findById(String personId) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Bruno");
		person.setLastName("Lima");
		person.setAddress("São Paulo - SP");
		return person;
	}

	@Override
	public Person update(Person person) {
		return person;
	}

	@Override
	public List<Person> findAll() {
		for (int i = 0; i < 7; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name " + i);
		person.setLastName("Last name " + i);
		person.setAddress("Some address in Brasil " + i);
		return person;
	}

	@Override
	public void delete(String personId) {

	}
}
