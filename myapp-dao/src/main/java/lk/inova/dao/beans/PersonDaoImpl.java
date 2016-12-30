package lk.inova.dao.beans;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import lk.inova.dao.model.Person;

@Named
public class PersonDaoImpl implements PersonDao {

	@Inject
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addPerson(Person person) {

		Session session = getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(person);
		transaction.commit();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> listAllPeople() {
		Session session = getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<Person> peopleList = session.createQuery("from Person").list();
		transaction.commit();
		return peopleList;
	}

	@Override
	public Person editPerson(int id) {
		
		Person person = null;
		Transaction transaction;
		
		try {
			Session session = getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			person = (Person) session.get(Person.class, id);
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return person;
	}

	@Override
	public void deletePerson(int id) {
		
		Transaction trans;
		Session session = getSessionFactory().getCurrentSession();
		
		try {
			
			trans = session.beginTransaction();
			Person person = (Person) session.get(Person.class, id);
			session.delete(person);
			trans.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updatePerson(Person person) {
		
		Transaction trans = null;
		Session session = null;
		
		try {
			session = getSessionFactory().getCurrentSession();
			trans = session.beginTransaction();
			session.update(person);
			trans.commit();
		} catch (Exception e) {
			if(trans != null){
				trans.rollback();
			}
			System.out.println(e.getMessage());
		}
		
		
		
		System.out.println(person.getId());
		System.out.println(person.getName());
		System.out.println(person.getCountry());
		
		
	}
}
