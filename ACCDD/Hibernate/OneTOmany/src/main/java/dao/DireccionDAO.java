package dao;

import modelo.Direccion;

public interface DireccionDAO {
	
	public void crear(Direccion d);
	public void actualizar(Direccion d);
	public Direccion obtener(Long id);
	public void eliminar(Long id);
	
}
