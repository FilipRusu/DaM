package app;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jakarta.persistence.Query;
import modelo.DetalleLibro;
import modelo.Libro;
import util.HibernateUtil;

public class Main {
	SessionFactory sf= HibernateUtil.getSessionFactory();
	 
	
	public void recuperarDatos() {
		try(Session session = sf.openSession()) {
			Query query=session.createQuery("select d.libro.titulo from DetalleLibro d where editorial=:pais",Object.class);
		query.setParameter("pais", "AAAA");	
			
		String nombre = (String) query.getSingleResult();
		
		
			System.out.println(nombre);
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		
		
	}
	
	
	public static void main(String[] args) {
		Main main = new Main();
		main.recuperarDatos();
	}
}
