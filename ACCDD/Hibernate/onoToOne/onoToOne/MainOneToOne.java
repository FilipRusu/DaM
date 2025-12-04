package onoToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MainOneToOne {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

//		Profesor p = new Profesor();
//		FichaTecnica ft = new FichaTecnica();
//
//		p.setNombre("Luis");
//
//		ft.setProfesor(p);
//		p.setFichaTecnica(ft);
//
//		try (Session session = sf.openSession()) {
//
//			session.beginTransaction();
//
//			session.persist(ft); // dueña = FichaTecnica es donde está la FK en la tabla
//
//			session.getTransaction().commit();
//		}
//
//		// --------------- 2ª sesión -----------------
//
//		p.setNombre("Manoli"); // el objeto p aquí está DETACHED
//
//		try (Session session = sf.openSession()) {
//			session.beginTransaction();
//
//			/*
//			 * El método session.contains(obj) (en JPA: entityManager.contains(obj)) sirve
//			 * para saber si una entidad está gestionada por la sesión actual, es decir:
//			 * 
//			 * ¿Está este objeto en estado “MANAGED” dentro del contexto de persistencia?
//			 * True: El objeto está managed por la sesión. 
//			 * False: El objeto está detached o es transient (nuevo)
//			 */
//			System.out.println("is persistent? antes de persist/merge Manoli: " + session.contains(p));
//			session.persist(p); // persistir NO sirve para detached
////			session.merge(p);	// merge sí actualiza estado separado
//
//			session.getTransaction().commit();
//		}
//
//		/*
//		 * Aunque parezca que funciona, llamar persist() a un objeto detached es
//		 * incorrecto. En JPA es ilegal y en Hibernate a veces funciona, a veces falla y
//		 * es peligroso. Para detached siempre usad merge().
//		 */
//
//		// --------------- 3ª sesión -----------------
//
//		// Ejemplos donde falla
//		/*
//		 * Situación:
//		 * 
//		 * Cargas la entidad Profesor
//		 * 
//		 * Cerras la sesión → ahora está detached
//		 * 
//		 * Creas otra sesión
//		 * 
//		 * Cargas OTRA VEZ el mismo profesor (misma clave primaria)
//		 * 
//		 * Y luego intentas persist() sobre el objeto detached original
//		 * 
//		 * Por qué falla? Hibernate ya tiene p2 dentro de la sesión, y tú intentas meter
//		 * p1 (misma PK). merge() sí actualiza correctamente.
//		 */
//		Profesor p1;
//
//		try (Session s1 = sf.openSession()) {
//			p1 = s1.get(Profesor.class, 1L); // s1 crea el objeto
//		}
//
//		p1.setNombre("Pepe"); // DETACHED
//
//		try (Session s2 = sf.openSession()) {
//			s2.beginTransaction();
//
//			Profesor p2 = s2.get(Profesor.class, 1L); // s2 crea OTRO objeto con la misma PK
//
//			System.out.println("is persistent? antes de persist Pepe: " + s2.contains(p2));
//
//			s2.persist(p1); // ERROR: dos instancias con misma PK dentro del mismo Session
////			s2.merge(p1); //Probemos con mege y veamos que sí actualiza y no falla
//
//			System.out.println("is persistent? después de persist Pepe: " + s2.contains(p2));
//
//			s2.getTransaction().commit();
//		}
//
//		/*
//		 * Situación
//		 * 
//		 * Recuperas un Profesor con LAZY
//		 * 
//		 * Cerrar sesión
//		 * 
//		 * Cambias relaciones en detached
//		 * 
//		 * persist() parece funcionar… pero no actualiza las relaciones
//		 * 
//		 * 
//		 * RESULTADO:
//		 * 
//		 * El nombre del profesor sí se actualiza
//		 * 
//		 * PERO la FichaTecnica sigue apuntando al profesor anterior
//		 * 
//		 * Hibernate no sincroniza la relación, porque para él el profesor “ya existía”.
//		 * 
//		 * Resultado final: base de datos inconsistente.
//		 */
//
//		Profesor p11;
//
//		try (Session s1 = sf.openSession()) {
//			p11 = s1.get(Profesor.class, 1L); // LAZY fichaTecnica
//		}
//
//		// fuera de sesión LAZY = no inicializado
//		// cambiamos la relación detached
//		p11.setFichaTecnica(null);
//		p11.setNombre("Miguel");
//
//		try (Session s2 = sf.openSession()) {
//			s2.beginTransaction();
//			System.out.println("is persistent? antes de persist Miguel: " + s2.contains(p11));
//
//			s2.persist(p11); // NO actualiza la FK de FICHA_TECNICA
//
//			System.out.println("is persistent? después de persist Miguel: " + s2.contains(p11));
//
//			s2.getTransaction().commit();
//		}

		/*
		 * Conclusión: 1️- persist(objeto NUEVO) → OK 2️- persist(objeto DETACHED) →
		 * ERROR 3️- merge(objeto DETACHED) → OK y UPDATE
		 */

		// Ejemplo borro ficha, borro todo en cascada con el owner
//		FichaTecnica f;
//		try (Session s1 = sf.openSession()) {
//			s1.beginTransaction();
//			f = s1.get(FichaTecnica.class, 2L); 
//			s1.remove(f);
//			s1.getTransaction().commit();
//		}

		//Borro con el NO owner, tengo que borrar la relación explícitamente
		//al borrar un lado de una relación bidireccional, siempre hay que asegurarse de que la referencia en el otro lado se anule explícitamente.
		Profesor p6;
		try (Session s1 = sf.openSession()) {
			s1.beginTransaction();
			// 1. Cargar el Profesor
			p6 = s1.get(Profesor.class, 7L);

			if (p6 != null && p6.getFichaTecnica() != null) {
				// 2. Romper la relación en el DUEÑO (FichaTecnica)
				// Esto es necesario para que orphanRemoval=true se dispare
				p6.getFichaTecnica().setProfesor(null);

			}

			s1.remove(p6);
			s1.getTransaction().commit();
		}

		sf.close();
	}
}
