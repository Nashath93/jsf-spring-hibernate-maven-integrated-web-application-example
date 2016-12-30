package lk.inova.service.beans;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import lk.inova.dao.beans.PersonDao;
import lk.inova.dao.model.Person;

@Named
@Transactional(readOnly=true)
public class PersonServiceImpl implements PersonService{

	@Inject
	private PersonDao personDao;	
	
	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	@Override
	@Transactional(readOnly = false)
	public void addPerson(Person person) {
		getPersonDao().addPerson(person);
	}

	@Override
	@Transactional(readOnly = false)
	public List<Person> listAllPeople() {
		
		return personDao.listAllPeople();
	}

	@Override
	@Transactional(readOnly = false)
	public Person editPerson(int id) {
		return personDao.editPerson(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void deletePerson(int id) {
		personDao.deletePerson(id);
		
	}

	@Override
	public void updatePerson(Person person) {
		personDao.updatePerson(person);
		
	}

}
