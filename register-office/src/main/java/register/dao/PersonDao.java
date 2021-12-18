package register.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import register.domain.Person;

public class PersonDao {
	private EntityManager em;

	public PersonDao() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
		em = factory.createEntityManager();
	}
	
	public List<Person> findPersons(){

		Query query = em.createNamedQuery("Person.findPersons");
		
		query.setParameter("pId", 2L);
		
		
		return query.getResultList();
		
	}
	
	
	
	
}
