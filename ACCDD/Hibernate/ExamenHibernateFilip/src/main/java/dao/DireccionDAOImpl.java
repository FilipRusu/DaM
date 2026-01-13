package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import modelo.Direccion;
import util.HibernateUtil;

public class DireccionDAOImpl implements DireccionDAO {
	private final SessionFactory sf=HibernateUtil.getSessionFactory();

	@Override
	public void crear(Direccion d) {
		try(Session ses=sf.openSession()){
		ses.beginTransaction();
			ses.persist(d);
		
		ses.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void actualizar(Direccion d) {
		try (Session ses=sf.openSession()){
		Direccion dir=ses.get(Direccion.class, d.getId());
		dir.setCalle(d.getCalle());
		dir.setCiudad(d.getCiudad());
		ses.beginTransaction();
		ses.merge(dir);
		ses.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Direccion obtener(Long id) {
		try (Session ses=sf.openSession()){
		Direccion dir=ses.get(Direccion.class, id);
		return dir;	
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public void eliminar(Long id) {
		try (Session ses=sf.openSession()){
		obtener(id);
		ses.beginTransaction();	
		ses.remove(obtener(id));
		ses.getTransaction().commit();
	} catch (Exception e) {
		e.printStackTrace();
	}
		
	}

	
}
