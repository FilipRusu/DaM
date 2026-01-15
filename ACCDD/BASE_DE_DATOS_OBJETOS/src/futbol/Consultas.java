package futbol;

import java.util.zip.Inflater;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Consultas {

	public void informacionJugadores() {
		ODB odb =ODBFactory.open("EQUIPOS.DB");

	IQuery query= new CriteriaQuery(Jugador.class);
	
	Objects<Jugador> jugadores= odb.getObjects(query);
	System.out.println("Query 1");
	
	while(jugadores.hasNext()) {
		Jugador jugador= jugadores.next();
		System.out.println(jugador);
		

	}
	odb.close();
	}
	
	
	public static void main(String[] args) {
		Consultas c=new Consultas();
		c.informacionJugadores();
	}
}
