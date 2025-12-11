package app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import clases.Customer;
import jakarta.persistence.Query;
import jakarta.transaction.Transaction;

public class EjerciciosConsultas {
	SessionFactory sf;

	public EjerciciosConsultas() {
		this.sf = HibernateUtil.getSessionFactory();
	}

	public void consulta1() {

		try (Session ses = sf.openSession()) {
			Query query = ses.createQuery("select c from Customers c", Customer.class);
			List<Customer> listacustomers = (List<Customer>) query.getResultList();

			for (Customer customer : listacustomers) {
				System.out.println(customer.getContactFirstName());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void consulta2() {
		try (Session ses=sf.openSession()){
		Query query= ses.createQuery("from Customer c where c.country = :pais", Customer.class);
		query.setParameter("pais", "USA");
		List<Customer> listacustomer = (List<Customer>) query.getResultList();
		
		for (Customer customer : listacustomer) {
			System.out.println(customer.getContactFirstName()+"\t   Pais:"+customer.getCountry());
		}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void consulta4() {
		try (Session ses=sf.openSession()){
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		EjerciciosConsultas consultas = new EjerciciosConsultas();
		consultas.consulta2();
	}

}
