package Ejercicio4;

import java.io.FileWriter;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class ProgramaPrinici2 {

	public static void main(String[] args) throws Exception{
		
		JAXBContext contexto = JAXBContext.newInstance(Empresa.class);
		
		Marshaller m = contexto.createMarshaller();
		Empresa empresa = new Empresa();
		Empleados misempleados = new Empleados();
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		
		Cargo cargo = new Cargo();
		cargo.setNivel(2);
		cargo.setValor("Ingeniero");
		Empleado empleado = new Empleado();
		
		empleado.setCargo(cargo);
		empleado.setDni("Y543988B");
		empleado.setEdad(20);
		empleado.setNombre("Andres");
		empleados.add(empleado);
		
		empleado = new Empleado();
		
		empleado.setDni("43988B");
		empleado.setEdad(20);
		empleado.setNombre("AAAAAndres");
		empleados.add(empleado);
		
		misempleados.setEmpleados(empleados);
		
		empresa.setCif("222222");
		empresa.setEmpleados(misempleados);
		empresa.setNombre("Filip.SL");
		
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(empresa, System.out);
		
		FileWriter fw = new FileWriter("empleados.xml");
		m.marshal(empresa,fw);
		
	}

}
