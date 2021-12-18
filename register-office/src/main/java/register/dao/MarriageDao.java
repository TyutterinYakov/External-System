package register.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import register.business.MarriageManager;
import register.domain.MarriageCertificate;
import register.view.MarriageRequest;

@Component
public class MarriageDao {
	private static final Logger logger = LoggerFactory.getLogger(MarriageDao.class);
	
	public MarriageDao() {
		
	}


	
	private EntityManager entityManager;
	
	@Value("${test.value}")
	private String test;
	
	
//	public MarriageDao() {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
//		em = factory.createEntityManager();
//	}
	


	public void setTest(String test) {
		this.test = test;
	}


	public MarriageCertificate findMarriageCertificate(MarriageRequest request) {
		logger.info("findMarriageCertificate called:{}", test);
//		
//		Query query = em.createQuery("Select m from MarriageCertificate m "
//				+ "inner join m.husband "
//				+ "inner join m.wife "
//				+ "where m.marriageCertificateId=:mNum");
//		query.setParameter("mNum", request.getMarriageCertificateNumber());
//		
		
		return null;
	}
}
