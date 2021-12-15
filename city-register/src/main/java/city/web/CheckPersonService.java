package city.web;


import city.domain.PersonRequest;
import city.domain.PersonResponse;
import jakarta.ws.rs.Consumes;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/check")
public class CheckPersonService 
{
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON) //Вход
	@Produces(MediaType.APPLICATION_JSON) //Выход
	public PersonResponse checkPerson(PersonRequest request) {
		System.out.println(request.toString());
		
		return new PersonResponse();
	}
}
