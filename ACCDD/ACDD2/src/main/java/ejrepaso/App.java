package ejrepaso;



import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class App  {
	
	public static void main(String[] args) throws Exception{
		JAXBContext contexto = JAXBContext.newInstance(Concesionario.class);
		
		Marshaller m = contexto.createMarshaller();
		Concesionario concesionario = new Concesionario();
		Vehiculos misvehiculos= new Vehiculos();
		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setPrecio(4000);
		vehiculo.setAnio(2002);
		vehiculo.setMarca("SEAT");
		vehiculo.setModelo("Leon");
		vehiculo.setVendedor("Andres");
		vehiculos.add(vehiculo);
		vehiculo = new Vehiculo();
		vehiculo.setPrecio(4000);
		vehiculo.setAnio(2002);
		vehiculo.setMarca("AAAAA");
		vehiculo.setModelo("AAAA");
		vehiculo.setVendedor("AAAAAA");
		vehiculos.add(vehiculo);
		
		misvehiculos.setVehiculos(vehiculos);
		
		concesionario.setNombre("FILIPS COCHES");
		concesionario.setVehiculos(misvehiculos);
		concesionario.setUbicacion("calle de benimamet 26");
		
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(concesionario, System.out);
		
		File f = new File("concesionario.xml");
		FileWriter fw = new FileWriter(f);
		
		m.marshal(concesionario, fw);
	}
	
	
}
