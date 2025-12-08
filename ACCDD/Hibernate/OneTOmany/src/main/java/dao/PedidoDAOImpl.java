package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import modelo.Pedido;
import util.HibernateUtil;

public class PedidoDAOImpl implements PedidoDAO {
	private final SessionFactory sf=HibernateUtil.getSessionFactory();

	@Override
	public void crear(Pedido p) {
		try (Session ses=sf.openSession()){
		ses.beginTransaction();
		ses.persist(p);
		ses.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Pedido obtener(Long id) {
		try (Session ses=sf.openSession()){
		Pedido pedido=ses.get(Pedido.class, id);
		return pedido;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
	@Override
	public void actualizar(Pedido p) {
		try(Session ses=sf.openSession()) {
		Pedido pedido=obtener(p.getId());
		pedido.setDescription(p.getDescription());
		ses.beginTransaction();
		ses.merge(pedido);
		ses.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void eliminar(Long id) {
	try(Session ses=sf.openSession()){
	ses.beginTransaction();
	ses.remove(obtener(id));
	ses.getTransaction().commit();
	} catch (Exception e) {
		e.printStackTrace();
	}
		
	}

}
