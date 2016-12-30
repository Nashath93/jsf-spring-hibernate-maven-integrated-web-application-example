package lk.inova.service.beans;

import java.util.List;

import lk.inova.dao.model.Person;

public interface PersonService {

	public void addPerson(Person person);
	public List<Person> listAllPeople();
	public Person editPerson(int id);
	public void deletePerson(int id);
	public void updatePerson(Person person);
	
}
