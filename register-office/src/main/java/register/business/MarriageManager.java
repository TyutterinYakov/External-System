package register.business;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import register.dao.MarriageDao;
import register.dao.PersonDao;
import register.domain.MarriageCertificate;
import register.domain.Person;
import register.domain.PersonFemale;
import register.domain.PersonMale;
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
	

	@Transactional
	public MarriageResponse findMarriageCertificate(MarriageRequest request) {
		logger.info("MarriageManager findMarriageCertificate called");
		
//		MarriageCertificate certificate = marriageDao.findMarriageCertificate(request);
		
		personDao.addPerson(getPerson(1));
		personDao.addPerson(getPerson(2));
		
		MarriageCertificate mc = getMarriageCertificate();
		marriageDao.saveAndFlush(mc);
		
	//	marriageDao.findAll();
//		marriageDao.findById(1L);
		
		List<MarriageCertificate> list = marriageDao.findByNumber("323223");
		list.forEach(m-> logger.info("MC:{}", m.getMarriageCertificateId()));
		logger.info("---------------------->>>>>");
		List<MarriageCertificate> list2 = marriageDao.findByNum("777777777");
		list2.forEach(n-> logger.info("NC:{}", n.getMarriageCertificateId()));
		logger.info("---------------------->>>>>");
		List<MarriageCertificate> list3 = marriageDao.findSomething("11111");
		list3.forEach(n-> logger.info("NC:{}", n.getMarriageCertificateId()));
		return new MarriageResponse();
	}
	
	public MarriageCertificate getMarriageCertificate() {
		
		MarriageCertificate mc = new MarriageCertificate();
		mc.setIssueDate(LocalDate.now());
		mc.setNumber("11111");
		mc.setActive(true);
	
		List<Person> persons = personDao.findPersons();
		for(Person p: persons) {
			if(p instanceof PersonMale) {
				mc.setHusband((PersonMale)p);
			} else {
				mc.setWife((PersonFemale)p);
			}
		}
		return mc;
		
	}
	
	public Person getPerson(int sex) {
		Person pr = sex ==1 ? new PersonMale() : new PersonFemale();
		pr.setFirstName("1_"+sex);
		pr.setLasName("2_"+sex);
		pr.setPatronymic("3_"+sex);
		pr.setDateOfBirth(LocalDate.of(2000, 11, 13));
		
		return pr;
	}
}
