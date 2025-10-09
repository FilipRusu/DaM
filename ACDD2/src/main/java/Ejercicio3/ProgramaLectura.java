package Ejercicio3;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class ProgramaLectura {
	public static void main(String[] args) throws Exception {
		
		JAXBContext contexto = JAXBContext.newInstance(Album.class);
		Unmarshaller andres=contexto.createUnmarshaller();
		
		File f = new File("album.xml");
		Album album = (Album) andres.unmarshal(f);
		
		Canciones canciones= album.getCanciones();
		
		ArrayList<Cancion> cancion= canciones.getCanciones();
		
		System.out.println("Album: "+album.getNombre());
		System.out.println("Artista:"+album.getArtista()+" Año album:"+album.getAnio()+" Nombre:"+album.getNombre());
		for (Cancion cancion2 : cancion) {
			System.out.println(cancion2);
		
		}
		
		
		
	}
}
