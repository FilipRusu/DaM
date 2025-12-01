package dao;

import modelo.Empleado;

public interface EmpleadoDAOImpl {
	
	public void guardar(Empleado e);
	public Empleado buscarPorId(Long id);
	public void actualizar(Empleado e);
	public void eliminar(Long id);
}
