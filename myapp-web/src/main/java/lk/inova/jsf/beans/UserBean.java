package lk.inova.jsf.beans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import lk.inova.dao.model.Person;
import lk.inova.service.beans.PersonService;

import org.springframework.context.annotation.Scope;

@Named("userBean")
@Scope("session")
public class UserBean implements Serializable{

	@Inject
	private PersonService personService;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String country;
	
	private List<Person> listPeople;
	
	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public List<Person> getListPeople() {
		return listPeople;
	}

	public void setListPeople(List<Person> listPeople) {
		this.listPeople = listPeople;
	}

	public void addPerson(){
		
		Person person = new Person();
		person.setName(getName());
		person.setCountry(getCountry());
		getPersonService().addPerson(person);
		clear();
		
	}
	
	public void clear(){
		this.setName(null);
		this.setCountry(null);
	}
	
	public List<Person> listAllPeople(){
		
		listPeople = personService.listAllPeople();
		return getListPeople();
	
	}
	
	public void editPerson(int personId){
		//Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		//String idString = params.get("editAction");
		//int personId = Integer.parseInt(idString);
		Person person = personService.editPerson(personId);
		this.setName(person.getName());
		this.setCountry(person.getCountry());
	}
	
	public void deletePerson(int personId){
		personService.deletePerson(personId);
	}
	
	public void updatePerson(int personid){
		
		Person person = personService.editPerson(personid);
		person.setName(this.getName());
		person.setCountry(this.getCountry());
		personService.updatePerson(person);
		clear();
		
	}
	
	public String goToLoginPage(){
		return "login";
	}
	
}
