package lk.inova.dao.beans;

import java.util.List;

import lk.inova.dao.model.Person;

public interface PersonDao {

	public void addPerson(Person person);
	public List<Person> listAllPeople();
	public Person editPerson(int id);
	public void deletePerson(int id);
	public void updatePerson(Person person);
	
}
