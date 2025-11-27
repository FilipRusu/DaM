package servicio;

import dao.EmpleadoDAO;
import modelo.Empleado;

public class EmpleadoService {

    private final EmpleadoDAO empleadoDAO;

    // Se inyecta la interfaz DAO
    public EmpleadoService(EmpleadoDAO empleadoDAO) {
        this.empleadoDAO = empleadoDAO;
    }

    public void registrarEmpleado(Empleado e) {
        // Lógica de Negocio: Ejemplo de validación
        if (e.getSalario() <= 0) {
            throw new IllegalArgumentException("El salario debe ser mayor que cero.");
        }
        if (e.getNombre() == null || e.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del empleado es obligatorio.");
        }
        
        // Delegación de la persistencia
        empleadoDAO.guardar(e);
    }

    public Empleado obtenerEmpleado(Long id) {
        return empleadoDAO.buscarPorId(id);
    }

    public void modificarEmpleado(Empleado e) {
        // Podríamos añadir lógica para comprobar que el ID existe antes de actualizar, 
        // o delegar la responsabilidad de manejo de excepción al DAO.
        empleadoDAO.actualizar(e);
    }

    public void eliminarEmpleado(Long id) {
        empleadoDAO.eliminar(id);
    }
}