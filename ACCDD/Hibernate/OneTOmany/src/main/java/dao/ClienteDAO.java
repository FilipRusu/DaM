package dao;

import org.hibernate.SessionFactory;

import modelo.Cliente;
import modelo.Pedido;

public interface ClienteDAO {
	public static final SessionFactory sf = null;
	
	public void crear(Cliente c);
	public Cliente obtenerClienteConInicializacion(Long id);
	public void actualizar(Cliente c);
	public Cliente obtener(Long id);
	public void eliminar(Long id);
}
