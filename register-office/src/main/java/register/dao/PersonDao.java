package register.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import register.domain.Person;


public class PersonDao {
	@PersistenceContext
	private EntityManager em;

	
	
	public List<Person> findPersons(){

		Query query = em.createNamedQuery("Person.findPersons");
		
		query.setParameter("pId", 2L);
		
		
		return query.getResultList();
		
	}
	
	
	
	
}
