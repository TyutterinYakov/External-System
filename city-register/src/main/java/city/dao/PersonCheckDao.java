package city.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import city.domain.PersonRequest;
import city.domain.PersonResponse;
import city.exception.PersonCheckException;

public class PersonCheckDao {
	
	private static final String SQL_REQUEST ="select temporal from cr_address_person ap "
			+ "inner join cr_person p on p.person_id = ap.person_id "
			+ "inner join cr_address a on a.address_id = ap.address_id "
			+ "where "
			+ "CURRENT_DATE >= ap.start_date and (CURRENT_DATE <= ap.end_date or ap.end_date is null) "
			+ "and upper(p.sur_name COLLATE \"en_US.UTF-8\") =upper(? COLLATE \"en_US.UTF-8\")  "
			+ "and upper(p.given_name COLLATE \"en_US.UTF-8\")=upper(? COLLATE \"en_US.UTF-8\") "
			+ "and upper(patronymic COLLATE \"en_US.UTF-8\")=upper(? COLLATE \"en_US.UTF-8\") "
			+ "and p.date_of_birth=? and a.street_code = ?"
			+ "and upper(a.building COLLATE \"en_US.UTF-8\") = upper(? COLLATE \"en_US.UTF-8\") ";
	
	private Connection getConnection() throws SQLException {
		
		return DriverManager.getConnection("jdbc:postgresql://localhost/city_register",
				"postgres", "login456456");
	}
	
	public PersonResponse checkPerson(PersonRequest rq) throws PersonCheckException {
		PersonResponse response = new PersonResponse();
		
		String sql = SQL_REQUEST;
		boolean extension = false;
		boolean appartment = false;
		if(rq.getExtension()!=null) {
			sql+="and upper(a.extension COLLATE \"en_US.UTF-8\")=upper(? COLLATE \"en_US.UTF-8\") ";
		} else {
			sql+=" and a.extension is null ";
			
		}
		if(rq.getApartment()!=null) {
			sql+="and upper(a.apartment COLLATE \"en_US.UTF-8\")=upper(? COLLATE \"en_US.UTF-8\") ";
		} else {
			sql+=" and a.apartment is null";
		}
		
		try(Connection con = getConnection();
				PreparedStatement prt = con.prepareStatement(sql);
			){
			
			int count=1;
			prt.setString(count++, rq.getSurName());
			prt.setString(count++, rq.getGivenName());
			prt.setString(count++,  rq.getPatronymic());
			prt.setDate(count++, java.sql.Date.valueOf(rq.getDateOfBirth()));
			prt.setInt(count++, rq.getStreetCode());
			prt.setString(count++,  rq.getBuilding());
			if(rq.getExtension()!=null) {
				prt.setString(count++, rq.getExtension());
			}
			if(rq.getApartment()!=null) {
				prt.setString(count++, rq.getApartment());
			}
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
