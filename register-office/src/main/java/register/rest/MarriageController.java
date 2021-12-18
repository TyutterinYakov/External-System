package register.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import register.business.MarriageManager;
import register.view.MarriageRequest;
import register.view.MarriageResponse;

public class MarriageController {
	private MarriageManager marMg;
	private static final Logger logger = LoggerFactory.getLogger(MarriageController.class);
	
	
	
	public void setMarriageManager(MarriageManager marMg) {
		this.marMg = marMg;
	}
	
	
	public MarriageResponse findMarriageCertificate(MarriageRequest request) {
		logger.info("findMarriageCertificate called");
		return marMg.findMarriageCertificate(request);
	}
}
