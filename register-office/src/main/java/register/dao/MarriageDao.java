package register.dao;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import register.business.MarriageManager;
import register.domain.MarriageCertificate;
import register.view.MarriageRequest;

public class MarriageDao {

	//TODO todooooooooooo
	
	private static final Logger logger = LoggerFactory.getLogger(MarriageDao.class);
	
	private EntityManager entity;
	public MarriageCertificate findMarriageCertificate(MarriageRequest request) {
		logger.info("findMarriageCertificate called");
		
		
		return null;
	}
}
