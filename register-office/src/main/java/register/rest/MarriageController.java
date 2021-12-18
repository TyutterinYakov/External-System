package register.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import register.business.MarriageManager;
import register.view.MarriageRequest;
import register.view.MarriageResponse;

@Service("controller")
public class MarriageController {
	private static final Logger logger = LoggerFactory.getLogger(MarriageController.class);
	


	@Autowired
	@Qualifier(value = "marriageService")
	private MarriageManager marriageManager;
	
	
	

	
	
	public MarriageResponse findMarriageCertificate(MarriageRequest request) {
		logger.info("findMarriageCertificate called");
		return marriageManager.findMarriageCertificate(request);
	}
}
