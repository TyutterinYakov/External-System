package city.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import city.dao.PersonCheckDao;
import city.dao.PoolConnectionBuilder;
import city.domain.PersonRequest;
import city.domain.PersonResponse;
import city.exception.PersonCheckException;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Singleton;
import jakarta.ws.rs.Consumes;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/check")
@Singleton
public class CheckPersonService 
{
	private static final Logger logger = LoggerFactory.getLogger(CheckPersonService.class);
	
	private PersonCheckDao pcd;
	
	@PostConstruct //Запуск при первом запросе (@PreDestroy -при завершении)
	public void init() {
		logger.info("SERVICE is created");
		pcd =new PersonCheckDao();
		pcd.setConnectionBuilder(new PoolConnectionBuilder());
	}
	

	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON) //Вход
	@Produces(MediaType.APPLICATION_JSON) //Выход
	public PersonResponse checkPerson(PersonRequest request) throws PersonCheckException {
		logger.info(request.toString());
		
		return pcd.checkPerson(request);
	}
}
