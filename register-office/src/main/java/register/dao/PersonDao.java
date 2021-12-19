package register.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import register.domain.Person;


public class PersonDao {
	@PersistenceContext
	private EntityManager em;

	
	
	public List<Person> findPersons(){
		Query query = em.createNamedQuery("Person.findPersons");
		return query.getResultList();
	}
	
	public Long addPerson(Person person) {

		em.persist(person);
		em.flush();
			
		return person.getPersonId();
	}
	
	
	
	
}
