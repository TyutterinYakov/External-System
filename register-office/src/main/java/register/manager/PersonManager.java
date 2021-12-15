package register.manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import register.domain.Person;
import util.CreateSession;

public class PersonManager {
	public static void main(String[] args) {
		
		
		
		sessionExample();
		
		jpaExample();

		
	}

	private static void jpaExample() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Person p = new Person();
		p.setFirstName("Александр");
		p.setLastName("Макаров");
		em.persist(p);
		System.out.println(p.getPersonId());
		
		em.getTransaction().commit();
		
		em = emf.createEntityManager();
		System.out.println("JPA");
		List<Person> persons = em.createQuery("FROM Person", Person.class).getResultList();
		
		persons.forEach(pers->System.out.println(pers));
		
		em.close();
		
	}

	private static void sessionExample() {
		SessionFactory sf = CreateSession.getSessionFactory();
		
		Session session = sf.openSession();
		
		session.getTransaction().begin();
		
		
		Person p = new Person();
		p.setFirstName("Яков");
		p.setLastName("Тюттерин");
		Long id =(Long) session.save(p);
		session.getTransaction().commit();
		session.close();
		
		session = sf.openSession();
		p = session.get(Person.class, id);
		System.out.println(p);
		session.close();
		
		
		session = sf.openSession();
		
		
		List<Person> pr = session.createQuery("FROM Person", (Person.class)).list();
		
		pr.forEach(pes->System.out.println(pes)); 
		
		session.close();
	}
	
	

}
