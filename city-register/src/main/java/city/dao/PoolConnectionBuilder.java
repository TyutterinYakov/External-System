package city.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PoolConnectionBuilder implements ConnectionBuilder {
	private static final Logger logger = LoggerFactory.getLogger(PoolConnectionBuilder.class);
	
	private DataSource dataSource;
	
	
	public PoolConnectionBuilder() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/cityRegister"); //Индивидуально для каждого сервера
		} catch(NamingException e) {
			logger.error("", e);
		}
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
