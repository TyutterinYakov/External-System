package register.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import register.dao.MarriageDao;
import register.domain.MarriageCertificate;
import register.view.MarriageRequest;
import register.view.MarriageResponse;

public class MarriageManager {
	
	private static final Logger logger = LoggerFactory.getLogger(MarriageManager.class);
	
	private MarriageDao marriageDao;
	
	public MarriageResponse findMarriageCertificate(MarriageRequest request) {
		logger.info("MarriageManager findMarriageCertificate called");
		
		MarriageCertificate certificate = marriageDao.findMarriageCertificate(request);
		
		return new MarriageResponse();
	}
}
