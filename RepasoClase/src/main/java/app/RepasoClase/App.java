package app.RepasoClase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

	

public class App {
	
	public static void metodoEscribir(JAXBContext contexto) throws JAXBException, IOException {
		Marshaller m=contexto.createMarshaller();
	Vehiculos misehiculos = new Vehiculos();
	Concesionario concesionario = new Concesionario();
	
	ArrayList<Vehiculo> listavehiculos= new ArrayList<Vehiculo>();
	Vehiculo v= new Vehiculo();
	v.setAño("2999");
	v.setmarca("Leon");
	v.setMarca("Seat");
	v.setVendedor("Adrian Cerejido");
	listavehiculos.add(v);
	
	v.setAño("2000");
	v.setmarca("Urus");
	v.setMarca("Lamborghini");
	v.setVendedor("Nixon");	
	listavehiculos.add(v);
	
	misehiculos.setPrecio(20000);	
	misehiculos.setVehiculos(listavehiculos);

	concesionario.setVehiculos(misehiculos);
	
	m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	
	m.marshal(concesionario, System.out);

	FileWriter fw= new FileWriter("concesionario.xml");
	m.marshal(concesionario, fw);
	
	}
	
	private static void metodoLeer(JAXBContext contexto) throws JAXBException {
		 Unmarshaller um=contexto.createUnmarshaller();
	File f = new File("concesionario.xml");
	
	Concesionario concesionario = (Concesionario) um.unmarshal(f);
	
	Vehiculos vehiculos = concesionario.getVehiculos();
	
	ArrayList<Vehiculo> misVehiculos = vehiculos.getVehiculos();
		
	System.out.println("Concesionarios:");
	System.out.println("Vehiculos"+vehiculos.getPrecio());
	for (Vehiculo vehiculo : misVehiculos) {
		System.out.println(vehiculo);
	}
	
	}
	
	
	
    public static void main(String[] args) {
    try {
    	JAXBContext contexto = JAXBContext.newInstance(Concesionario.class);
    	metodoEscribir(contexto);
    	metodoLeer(contexto);
    } catch (Exception e) {
		// TODO: handle exception
	}
    	
    
    
    
    	
    }



}
