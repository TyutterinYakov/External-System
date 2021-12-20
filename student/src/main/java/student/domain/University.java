package student.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="sr_university")
@Entity
public class University {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="university_id")
	private Long universityId;
	@Column(name="university_name")
	private String iniversityName;
	@OneToMany(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY, mappedBy="university")
	private List<Faculty> faculties;
	public Long getUniversityId() {
		return universityId;
	}
	public void setUniversityId(Long universityId) {
		this.universityId = universityId;
	}
	public String getIniversityName() {
		return iniversityName;
	}
	public void setIniversityName(String iniversityName) {
		this.iniversityName = iniversityName;
	}
	public List<Faculty> getFaculties() {
		return faculties;
	}
	public void setFaculties(List<Faculty> faculties) {
		this.faculties = faculties;
	}
	
}
