package br.com.springboot.bonejah.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import br.com.springboot.bonejah.models.Person;
import br.com.springboot.bonejah.services.PersonService;

@Api(value="person") // Tell Swagger that this is an endpoint and REST should be documented 
@RestController
@RequestMapping("/person/") //Map requests to localhost: 8080 / person /
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@ApiOperation(value = "Find person by ID" )
	@ResponseStatus(HttpStatus.OK) //Status code 200 = success
	@RequestMapping(value = "/{personId}",
		method = RequestMethod.GET, //Method GET to localhost:8080/person
		produces = MediaType.APPLICATION_JSON_VALUE) //Return JSON
	public Person get(@PathVariable(value="personId") String personId) {
		return personService.findById(personId);
	}
	
	@ApiOperation(value = "Find all persons" )
	@ResponseStatus(HttpStatus.OK) //Status code 200 = success
    @RequestMapping(value = "/findAll",
        method = RequestMethod.GET, //Map request GET to localhost:8080/person/findAll
        produces = MediaType.APPLICATION_JSON_VALUE) //Return JSON
    public List<Person> findAll(){
        return personService.findAll();
    }
     
	@ApiOperation(value = "Create a new person" )
    @ResponseStatus(HttpStatus.OK) //Status code 200 = success
    @RequestMapping(method = RequestMethod.POST, //Map request POST to localhost:8080/person/
        consumes = MediaType.APPLICATION_JSON_VALUE, //Consume JSON sended in the body of request
        produces = MediaType.APPLICATION_JSON_VALUE)
     public Person create(@RequestBody Person person){
        return personService.create(person);
    }
     
	@ApiOperation(value = "Update an existing person")
    @ResponseStatus(HttpStatus.OK) //Status code 200 = success
    @RequestMapping(method = RequestMethod.PUT, //Map request PUT to localhost:8080/person/
        consumes = MediaType.APPLICATION_JSON_VALUE) //Consume JSON sended in the body of request         
    public Person update(@RequestBody Person person){ //Produces json as a return
        return personService.update(person);
    }
 
	@ApiOperation(value = "Delete person by ID" )
    @ResponseStatus(HttpStatus.OK) //Status code 200 = success 
    @RequestMapping(value = "/{personId}",
        method = RequestMethod.DELETE) //Map request DELETE to localhost:8080/person/   
    public void delete(@PathVariable(value = "personId") String personId){ //Receive id as PathVariable
        personService.delete(personId);
    }
}
