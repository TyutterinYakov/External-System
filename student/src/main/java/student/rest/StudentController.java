package student.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import student.service.StudentService;
import student.view.StudentRequest;
import student.view.StudentResponse;



@Component
@Path("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@POST
	@Consumes(value = MediaType.APPLICATION_JSON)
	@Produces(value = MediaType.APPLICATION_JSON)
	public List<StudentResponse> getStudentInfo(StudentRequest request) {
		
		return studentService.getStudentInfo(request);
	}
	
}
