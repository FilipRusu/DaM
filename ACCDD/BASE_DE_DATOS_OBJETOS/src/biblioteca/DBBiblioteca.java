package biblioteca;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import modelo.Autor;
import modelo.Libro;

public class DBBiblioteca {

	
	public static void main(String[] args) {
try {
	
	DBBiblioteca biblio= new DBBiblioteca();
	ODB odb= ODBFactory.open("biblioteca.db");	

//ArrayList<Autor> listaautores =new ArrayList<Autor>();
//ArrayList<Libro> listalibros = new ArrayList<Libro>();	
//Libro l1= new Libro("Hola", 2000, "AAAA", 20, listaautores);
//Libro l2= new Libro("Hola", 2000, "AAA", 20, listaautores);
//Libro l3= new Libro("Hola", 2000, "AA", 40, listaautores);
//Libro l4= new Libro("Hola", 2000, "A", 20, listaautores);
//Autor autor1= new Autor("Alex", "Rusu", "Rumano", 19, listalibros);
//Autor autor2= new Autor("Ionut", "Rusu", "Rumano", 19, listalibros);
//Autor autor3= new Autor("Stefania", "Rusu", "Rumano", 19, listalibros);
//listaautores.add(autor1);
//listaautores.add(autor2);
//listaautores.add(autor3);
//listalibros.add(l4);
//listalibros.add(l3);
//listalibros.add(l2);
//listalibros.add(l1);
//
//odb.store(autor1);
//odb.store(autor2);
//odb.store(autor3);
//odb.store(l1);
//odb.store(l2);
//odb.store(l3);
//odb.store(l4);


biblio.españoles(odb);
odb.close();
} catch (Exception e) {
	e.printStackTrace();
}

	}
	
	public void paginas(ODB odb) {
		ICriterion criterio=Where.gt("paginas", 40);
		IQuery query =new CriteriaQuery(Libro.class,criterio);
		
		Objects<Libro> libros=odb.getObjects(query);
	
		while(libros.hasNext()) {
			Libro libro=libros.next();
		
		System.out.println(libro);
			
		}
	}

	public void españoles(ODB odb) {
		ICriterion criterio=Where.like("nacionalidad", "Rumana");
		IQuery query= new CriteriaQuery(Autor.class,criterio);
		
		Objects<Autor> autores=odb.getObjects(query);
		
		while(autores.hasNext()) {
			Autor autor=autores.next();
			System.out.println(autor);
			
		}
		
	}
	
	
	
}
