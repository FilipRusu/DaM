package dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import modelo.Cliente;
import modelo.Pedido;
import util.HibernateUtil;

public class ClienteDAOImpl implements ClienteDAO {
	private SessionFactory sf;

	public ClienteDAOImpl() {
		this.sf = HibernateUtil.getSessionFactory();
	}

	@Override
	public void crear(Cliente c) {
		try (Session ses = sf.openSession()) {
			ses.beginTransaction();
			ses.persist(c);
			ses.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Cliente obtenerClienteConInicializacion(Long id) {
		try (Session ses = sf.openSession()) {
			Cliente c = ses.get(Cliente.class, id);
			Hibernate.initialize(c.getPedidos());
			return c;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public void actualizar(Cliente c) {
		try (Session ses = sf.openSession()) {
			Cliente cliente = ses.get(Cliente.class, c.getId());
			cliente.setNombre(c.getNombre());
			ses.beginTransaction();
			ses.merge(c);
			ses.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Cliente obtener(Long id) {
		try (Session ses = sf.openSession()) {
			Cliente cliente = ses.get(Cliente.class, id);
			return cliente;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public void eliminar(Long id) {
		try (Session ses = sf.openSession()) {
			ses.beginTransaction();
			ses.remove(obtener(id));
			ses.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
