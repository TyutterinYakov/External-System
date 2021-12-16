package register.view;

import java.io.Serializable;
import java.time.LocalDate;


public class MarriageResponse implements Serializable {
	
	private String surName;
	private String givenName;
	private String patronymic;
	private LocalDate dateOfBirth;
	private String passportSeria;
	private String passportNumber;
	private LocalDate PassportIssueDate;
	
	private String marriageCertificateNumber;
	private LocalDate marriageCertificateDate;
}
