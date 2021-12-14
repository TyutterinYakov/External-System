package city.web;

import java.io.IOException;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import city.dao.PersonCheckDao;
import city.dao.PoolConnectionBuilder;
import city.domain.PersonRequest;
import city.domain.PersonResponse;
import city.exception.PersonCheckException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet(name ="CheckPersonServlet", urlPatterns = {"/checkPerson", "/check"})
public class CheckPersonServlet extends HttpServlet{
	private PersonCheckDao pcd;
	
	private static final Logger logger = LoggerFactory.getLogger(CheckPersonServlet.class);
	
	
	@Override
	public void init() throws ServletException { //Создание DAO только один раз вместе с созданием сервлета
		logger.info("SERVLET is created");
		pcd =new PersonCheckDao();
		pcd.setConnectionBuilder(new PoolConnectionBuilder());
	}



	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String surName = req.getParameter("surname");
		
		PersonRequest pr = new PersonRequest();
		pr.setSurName(surName);
		pr.setGivenName("Александр");
		pr.setPatronymic("Витальевич");
		pr.setStreetCode(1);
		pr.setDateOfBirth(LocalDate.of(2001, 6, 8));
		pr.setStreetCode(1);
		pr.setBuilding("10");
		pr.setExtension("2");
		pr.setApartment("222");
		
		try {
			PersonResponse ps = pcd.checkPerson(pr);
			if(ps.isRegistered()){
				resp.getWriter().write("Registered");
			} else {
				resp.getWriter().write("Not registered");
			}
		} catch (PersonCheckException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
