package student.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import student.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	@Query("select st FROM Student st where st.lastName =:lastName AND "
			+ "st.firstName =:firstName AND st.middleName = :middleName "
			+ "AND st.dateOfBirth=:dateOfBirth AND st.passportSeria =:passportSeria "
			+ "AND st.passportNumber =:passportNumber AND st.passportDate = :passportDate")
	
	List<Student> findStudent(@Param("lastName")String lastName,
			@Param("firstName")String firstName,
			@Param("middleName")String middleName,
			@Param("dateOfBirth")LocalDate dateOfBirth,
			@Param("passportNumber")String passportNumber,
			@Param("passportSeria")String passportSeria,
			@Param("passportDate")LocalDate passportDate
			);
}
