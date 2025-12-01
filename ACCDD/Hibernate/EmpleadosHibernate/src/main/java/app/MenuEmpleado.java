package app;

import java.util.Scanner;

import dao.EmpleadoDAO;
import dao.EmpleadoDAOImpl;
import modelo.Empleado;
import servicio.EmpleadoService;
import util.HibernateUtil;

public class MenuEmpleado {

	private static EmpleadoService empleadoService;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
	
		// 1. Inicializar el Servicio, inyectando el DAO y la SessionFactory
		empleadoService = new EmpleadoService(new EmpleadoDAO(HibernateUtil.getSessionFactory()));

		mostrarMenu();

		// 2. Cerrar la SessionFactory al finalizar la aplicación
		HibernateUtil.shutdown();
	}

	public static void mostrarMenu() {
		int opcion = -1;

		while (opcion != 0) {
			System.out.println("\n--- Gestión de Empleados ---");
			System.out.println("1. Crear Empleado");
			System.out.println("2. Leer Empleado");
			System.out.println("3. Actualizar Empleado");
			System.out.println("4. Eliminar Empleado");
			System.out.println("0. Salir");
			System.out.print("Opción: ");

			try {
				opcion = sc.nextInt();
				sc.nextLine(); // Limpiar buffer después de nextInt()

				switch (opcion) {
				case 1:
					crear();
					break;
				case 2:
					leer();
					break;
				case 3:
					actualizar();
					break;
				case 4:
					eliminar();
					break;
				case 0:
					System.out.println("Saliendo del sistema...");
					break;
				default:
					System.out.println("Opción no válida.");
				}
			} catch (Exception e) {
				System.out.println("Error de entrada. Por favor, introduzca un número válido para la opción.");
				sc.nextLine(); // Limpiar la línea de error
				opcion = -1;
			}
		}
	}

	private static void crear() {
		Empleado e = new Empleado();

		System.out.print("Nombre: ");
		e.setNombre(sc.nextLine());
		System.out.print("Departamento: ");
		e.setDepartamento(sc.nextLine());
		System.out.print("Salario: ");
		// Usamos nextDouble y envolvemos en try-catch para evitar errores de formato
		try {
			e.setSalario(sc.nextDouble());
			sc.nextLine();
		} catch (Exception ex) {
			System.out.println("Salario inválido. Intente de nuevo.");
			sc.nextLine(); // Limpiar buffer
			return;
		}

		try {
			empleadoService.registrarEmpleado(e);
			System.out.println("Empleado creado con ID: " + e.getIdempleado());
		} catch (Exception ex) {
			System.out.println("Error al crear empleado: " + ex.getMessage());
		}
	}

	private static void leer() {
		System.out.print("ID del Empleado a buscar: ");
		Long id = sc.nextLong();
		sc.nextLine();

		Empleado e = empleadoService.obtenerEmpleado(id);

		if (e != null) {
			System.out.println(e);
		} else {
			System.out.println("No existe el empleado con ID " + id);
		}
	}

	private static void actualizar() {
		System.out.print("ID del Empleado a modificar: ");
		Long id = sc.nextLong();
		sc.nextLine();

		Empleado e = empleadoService.obtenerEmpleado(id);

		if (e == null) {
			System.out.println("No existe el empleado.");
			return;
		}

		System.out.println("--- Editando Empleado " + id + " ---");
		System.out.println("Nombre actual: " + e.getNombre() + ". Ingrese nuevo nombre (o Enter para mantener):");
		String nuevoNombre = sc.nextLine();
		if (!nuevoNombre.isEmpty())
			e.setNombre(nuevoNombre);

		System.out.println("Departamento actual: " + e.getDepartamento()
				+ ". Ingrese nuevo departamento (o Enter para mantener):");
		String nuevoDpto = sc.nextLine();
		if (!nuevoDpto.isEmpty())
			e.setDepartamento(nuevoDpto);

		System.out.print("Salario actual: " + String.format("%.2f", e.getSalario())
				+ ". Ingrese nuevo salario (o 0 para mantener): ");
		double nuevoSalario = sc.nextDouble();
		sc.nextLine();
		if (nuevoSalario != 0.0)
			e.setSalario(nuevoSalario);

		try {
			empleadoService.modificarEmpleado(e);
			System.out.println("Empleado ID " + id + " actualizado.");
		} catch (Exception ex) {
			System.out.println("Error al actualizar: " + ex.getMessage());
		}
	}

	private static void eliminar() {
		System.out.print("ID del Empleado a eliminar: ");
		Long id = sc.nextLong();
		sc.nextLine();

		try {
			empleadoService.eliminarEmpleado(id);
			System.out.println("Empleado ID " + id + " eliminado.");
		} catch (Exception e) {
			System.out.println("Error al eliminar: " + e.getMessage());
		}
	}
}