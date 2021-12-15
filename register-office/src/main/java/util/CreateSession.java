package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class CreateSession {
	private static SessionFactory buildSessionFactory() {
		try {
			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.configure("hibernate.cfg.xml").build();
			
			Metadata mt = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
			
			return mt.getSessionFactoryBuilder().build();
		} catch(Throwable ex) {
			System.err.println("Initial SessionFactory creation failed. "+ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		
		return buildSessionFactory();
	}
	
	
	
}
