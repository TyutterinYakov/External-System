package city.web;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

@Path("/check")
public class CheckPersonService 
{
	@GET
	@Path("/{id}")
	public String checkPerson(@PathParam("id") int simpleId, 
			@QueryParam("name") String simpleName) {
		
		
		
		return simpleId+": "+simpleName;
	}
}
