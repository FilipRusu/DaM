package personal;

import java.sql.Date;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoPeriod;
import java.time.chrono.Chronology;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import modelo.Departamento;
import modelo.Empleado;

public class DBPersonal {

	public static void main(String[] args) {
		DBPersonal db = new DBPersonal();
		ODB odb = ODBFactory.open("personal.db");
		db.ventas(odb);
		odb.close();
	}

	public void empleadosSalariomil(ODB odb) {
		ICriterion criterio = Where.gt("salario", 1000);
		IQuery query = new CriteriaQuery(Empleado.class, criterio);

		Objects<Empleado> empleados = odb.getObjects(query);

		while (empleados.hasNext()) {
			Empleado e = empleados.next();
			System.out.println(e);

		}

	}

	public void dep10(ODB odb) {
		ICriterion criterio = Where.equal("departamento.id_dep", 10);
		IQuery query = new CriteriaQuery(Empleado.class, criterio);

		Objects<Empleado> empleados = odb.getObjects(query);

		while (empleados.hasNext()) {
			Empleado e = empleados.next();
		
			System.out.println(e.getApellido());

		}

	}
	public void jefes(ODB odb) {
		ICriterion criterio = Where.equal("jefe.apellido", "Lopez");
		IQuery query = new CriteriaQuery(Empleado.class, criterio);

		Objects<Empleado> empleados = odb.getObjects(query);

		while (empleados.hasNext()) {
			Empleado e = empleados.next();
		
			System.out.println(e.getApellido());

		}

	}
	public void ventas(ODB odb) {
		ICriterion criterio = Where.equal("departamento.nombre", "RRHH");
		IQuery query = new CriteriaQuery(Empleado.class, criterio);

		Objects<Empleado> empleados = odb.getObjects(query);

		while (empleados.hasNext()) {
			Empleado e = empleados.next();
			System.out.println(e.getApellido());

		}

	}
	

}
