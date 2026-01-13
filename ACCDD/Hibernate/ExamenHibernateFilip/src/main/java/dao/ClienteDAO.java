package dao;

import modelo.Cliente;

public interface ClienteDAO {

	public void crear(Cliente c);
	public Cliente obtener(Long id);
	public void actualizar(Cliente c);
	public void eliminar(Long id);	
}
