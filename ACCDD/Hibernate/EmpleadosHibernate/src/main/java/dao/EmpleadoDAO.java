package dao;

import org.hibernate.SessionFactory;

import modelo.Empleado;
import util.HibernateUtil;

public class EmpleadoDAO implements EmpleadoDAOImpl {
	SessionFactory ses; 
	
	public EmpleadoDAO(SessionFactory session) {
	ses=session;
	}
	
	
	@Override
	public void guardar(Empleado e) {
		
	}

	@Override
	public Empleado buscarPorId(Long id) {
		Empleado e = new Empleado();
		
		return e;
	}

	@Override
	public void actualizar(Empleado e) {
		
		
	}

	@Override
	public void eliminar(Long id) {
		
		
	}
	
}
