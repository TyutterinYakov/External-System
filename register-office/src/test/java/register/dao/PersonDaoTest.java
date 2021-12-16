package register.dao;

import java.util.List;

import org.junit.Test;

import register.domain.Person;
import register.domain.PersonFemale;
import register.domain.PersonMale;

public class PersonDaoTest {
	
	@Test
	public void findPerson()
	{
		PersonDao dao = new PersonDao();
		List<Person> persons = dao.findPersons();
		
		persons.forEach(p ->{
		System.out.println("Name: "+p.getFirstName());
		System.out.println("Class: "+p.getClass().getName());
		System.out.println("Birth: "+p.getBirthCertificate());
//		if(p instanceof PersonMale) {
//			System.out.println("************Male");
//			System.out.println("Birth CERT: "+((PersonMale)p).getBirthCertificates().size());
//			System.out.println("Marriage CERT: "+((PersonMale)p).getMarriageCertificates().size());
//			System.out.println("************Male-------------------");
//		} else if(p instanceof PersonFemale) {
//			System.out.println("************Female");
//			System.out.println("Birth CERT: "+((PersonFemale)p).getBirthCertificates().size());
//			System.out.println("Marriage CERT: "+((PersonFemale)p).getMarriageCertificates().size());
//			System.out.println("************Female-----------------");
//		}
		});
		
		
	}
}
