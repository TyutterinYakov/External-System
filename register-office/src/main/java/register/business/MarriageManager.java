package register.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import register.dao.MarriageDao;
import register.dao.PersonDao;
import register.domain.MarriageCertificate;
import register.view.MarriageRequest;
import register.view.MarriageResponse;

@Service("marriageService")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MarriageManager {
	
	private static final Logger logger = LoggerFactory.getLogger(MarriageManager.class);
	@Autowired
	private MarriageDao marriageDao;
	@Autowired
	private PersonDao personDao;
	

	





	public MarriageResponse findMarriageCertificate(MarriageRequest request) {
		logger.info("MarriageManager findMarriageCertificate called");
		
		MarriageCertificate certificate = marriageDao.findMarriageCertificate(request);
		
		personDao.findPersons();
		return new MarriageResponse();
	}
}
