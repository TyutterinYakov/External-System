package student.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import student.dao.StudentRepository;
import student.domain.Student;
import student.domain.StudentDocument;
import student.view.StudentRequest;
import student.view.StudentResponse;




@Service
public class StudentService {
	 private static final Logger logger = LoggerFactory.getLogger(StudentService.class);
	 
	 	@Autowired
	 	private StudentRepository studentRepo;
	 	
	 
	 	@Transactional
		public List<StudentResponse> getStudentInfo(StudentRequest request) {
			List<Student> student = studentRepo.findStudent(request.getLastName(), 
					request.getFirstName(),
					request.getMiddleName(),
					request.getDateOfBirth(),
					request.getPassportNumber(),
					request.getPassportSeria(),
					request.getPassportDate());
			if(student.isEmpty()) {
				return Collections.EMPTY_LIST;
			}
			List<StudentDocument> docs = student.get(0).getDocuments();
			
			List<StudentResponse> result = docs.stream().map(d->getResponse(d)).collect(Collectors.toList());
			
			return result;
		}
		
		
		private StudentResponse getResponse(StudentDocument doc) {
			StudentResponse sr = new StudentResponse();
			sr.setDocumentNumber(doc.getDocumentNumber());
			sr.setDocumentDate(doc.getDocumentDate());
			sr.setExpiredDate(doc.getExpiredDate());
			sr.setFacultyName(doc.getFaculty().getFacultyName());
			sr.setStudentForm(doc.getStudentForm().toString());
			sr.setUniversityName(doc.getFaculty().getUniversity().getIniversityName());
			
			return sr;
		}
	 
}
