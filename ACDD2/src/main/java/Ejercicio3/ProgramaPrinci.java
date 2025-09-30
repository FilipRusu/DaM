package Ejercicio3;

import java.io.FileWriter;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class ProgramaPrinci {

	public static void main(String[] args)	throws Exception {
		
		JAXBContext contexto = JAXBContext.newInstance(Album.class);

		Marshaller m =contexto.createMarshaller();
		
		Album album=new Album();
		Canciones miscanciones= new Canciones();
		ArrayList<Cancion> canciones = new ArrayList<Cancion>();
		Cancion cancion= new Cancion();
		cancion.setTitulo("X5");	
		cancion.setDuracion(45);
		cancion.setExtra(true);
		canciones.add(cancion);
		
		
		cancion= new Cancion();
		cancion.setTitulo("2AM");	
		cancion.setDuracion(34);
		cancion.setExtra(false);
		canciones.add(cancion);
		
		miscanciones.setCanciones(canciones);
		
		album.setAnio("2010");
		album.setArtista("Don Toliver");
		album.setCanciones(miscanciones);
		album.setNombre("Life of a DON");
		
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(album, System.out);
		
		FileWriter fw = new FileWriter("album.xml");
		m.marshal(album,fw);
	}

}
