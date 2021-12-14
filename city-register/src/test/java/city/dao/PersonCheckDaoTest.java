package city.dao;
import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import city.dao.PersonCheckDao;
import city.domain.PersonRequest;
import city.domain.PersonResponse;
import city.exception.PersonCheckException;

public class PersonCheckDaoTest {

	@Test
	public void checkPerson() throws PersonCheckException {
		PersonRequest pr = new PersonRequest();
		pr.setSurName("Кротов");
		pr.setGivenName("Александр");
		pr.setPatronymic("Витальевич");
		pr.setStreetCode(1);
		pr.setDateOfBirth(LocalDate.of(2001, 6, 8));
		pr.setStreetCode(1);
		pr.setBuilding("10");
		pr.setExtension("2");
		pr.setApartment("222");
		
		PersonCheckDao pcd = new PersonCheckDao();
		PersonResponse ps = pcd.checkPerson(pr);
		
		Assert.assertTrue(ps.isRegistered());
		Assert.assertFalse(ps.isTemporal());
	}
	@Test
	public void checkPerson2() throws PersonCheckException {
		
		PersonRequest pr = new PersonRequest();
		pr.setSurName("Кротова");
		pr.setGivenName("Василиса");
		pr.setPatronymic("Николаевна");
		pr.setStreetCode(1);
		pr.setDateOfBirth(LocalDate.of(2000, 1, 3));
		pr.setStreetCode(1);
		pr.setBuilding("34");
//		pr.setExtension("");
		pr.setApartment("18");
		
		PersonCheckDao pcd = new PersonCheckDao();
		PersonResponse ps = pcd.checkPerson(pr);
		
		Assert.assertTrue(ps.isRegistered());
		Assert.assertFalse(ps.isTemporal());
	}

}
