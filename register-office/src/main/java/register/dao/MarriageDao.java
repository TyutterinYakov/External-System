package register.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import register.business.MarriageManager;
import register.domain.MarriageCertificate;
import register.view.MarriageRequest;

public class MarriageDao {

	private EntityManager em;
	private static final Logger logger = LoggerFactory.getLogger(MarriageDao.class);
	
	public MarriageDao() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
		em = factory.createEntityManager();
	}
	
	private EntityManager entity;
	public MarriageCertificate findMarriageCertificate(MarriageRequest request) {
		logger.info("findMarriageCertificate called");
		
		Query query = em.createQuery("Select m from MarriageCertificate m "
				+ "inner join m.husband "
				+ "inner join m.wife "
				+ "where m.marriageCertificateId=:mNum");
		query.setParameter("mNum", request.getMarriageCertificateNumber());
		
		
		return (MarriageCertificate)query;
	}
}
