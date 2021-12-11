package city.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import city.domain.PersonRequest;
import city.domain.PersonResponse;
import city.exception.PersonCheckException;

public class PersonCheckDao {
	
	private static final String SQL_REQUEST ="select temporal from cr_address_person ap"
			+ "inner join cr_person p on p.person_id = ap.person_id"
			+ "inner join cr_address a on a.address_id = ap.address_id"
			+ "where"
			+ "upper(p.sur_name COLLATE \"en_US.UTF-8\") =upper(? COLLATE \"en_US.UTF-8\")  "
			+ "and upper(p.given_name COLLATE \"en_US.UTF-8\")=upper(? COLLATE \"en_US.UTF-8\") "
			+ "and upper(patronymic COLLATE \"en_US.UTF-8\")=upper(? COLLATE \"en_US.UTF-8\") "
			+ "and p.date_of_birth=? and a.street_code = ?"
			+ "and upper(a.building COLLATE \"en_US.UTF-8\") = upper(? COLLATE \"en_US.UTF-8\")"
			+ "and upper(a.extension COLLATE \"en_US.UTF-8\")=upper(? COLLATE \"en_US.UTF-8\")"
			+ "and upper(a.apartment COLLATE \"en_US.UTF-8\")=upper(? COLLATE \"en_US.UTF-8\")";
	
	private Connection getConnection() {
		
		return null;
	}
	
	public PersonResponse checkPerson(PersonRequest request) throws PersonCheckException {
		PersonResponse response = new PersonResponse();
		
		try(Connection con = getConnection()){
			PreparedStatement prt = con.prepareStatement(SQL_REQUEST);
			
			ResultSet rs = prt.executeQuery();
			if(rs.next()) {
			response.setRegistered(true);
			response.setTemporal(rs.getBoolean("temporal"));
			}
			
		} catch(SQLException ex) {
			throw new PersonCheckException(ex);
		}
		
		
		return response;
	}


}
