package app;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import modelo.DetalleLibro;
import modelo.Libro;
import util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
	
		SessionFactory sf= HibernateUtil.getSessionFactory();
		
		Libro p=new Libro();
		DetalleLibro dl= new DetalleLibro();
		
		try(Session session = sf.openSession()) {
			dl =session.get(DetalleLibro.class,3L);
			session.beginTransaction();
			session.remove(dl);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
