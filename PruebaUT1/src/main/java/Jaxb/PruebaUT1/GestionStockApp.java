package Jaxb.PruebaUT1;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class GestionStockApp {

	// --- Rutas de Ficheros ---
	private static final String RUTA_CSV = "recursos/stock_catalogo.csv";
	private static final String RUTA_PRECIOS_BIN = "recursos/precios.dat";
	private static final String RUTA_STOCK_OBJ = "recursos/stock.dat";
	private static final String RUTA_XML = "recursos/catalogo.xml";
	private static final String RUTA_RESUMEN = "recursos/resumen.txt";

	public static void main(String[] args) {
		// 1. Datos de prueba
		List<Articulo> stockInicial = new ArrayList<>();
		stockInicial.add(new Articulo("P001", "Monitor Curvo 27", 15, 299.99));
		stockInicial.add(new Articulo("P002", "Teclado Mecánico", 0, 75.50)); // Precio a modificar en Tarea 5
		stockInicial.add(new Articulo("P003", "Disco SSD 1TB", 30, 89.90));
		stockInicial.add(new Articulo("P004", "Webcam 4K", 5, 120.00));

		// Crear directorio de recursos si no existe
		new File("recursos").mkdirs();

		System.out.println("--- INICIANDO FLUJO DE PRUEBA COMPLETO ---\n");
		try {
			// --- I. Ficheros de Texto ---
			exportarA_CSV(stockInicial, RUTA_CSV); // Tarea 1
			System.out.println("[T.2] Artículos con stock 0: " + contarLineasNoVacias(RUTA_CSV) + "\n"); // Tarea 2

			// --- II. Ficheros Binarios Primitivos y Aleatorio ---
			guardarID_Precio(stockInicial, RUTA_PRECIOS_BIN); // Tarea 3 (Ahora con RandomAccessFile)

			System.out.println("--- [T.4] VERIFICACIÓN BINARIO (ANTES DE MODIFICAR) ---");
			leerFicheroPreciosBinario(RUTA_PRECIOS_BIN); // Tarea 4 (Con RandomAccessFile)

			modificarPrecioPorPosicion(RUTA_PRECIOS_BIN, 2, 85.00); // Tarea 5
			System.out.println("\n[T.5] Precio del artículo 2 modificado a 85.00€ con RandomAccessFile.");

			System.out.println("--- [T.4] VERIFICACIÓN BINARIO (DESPUÉS DE MODIFICAR) ---");
			leerFicheroPreciosBinario(RUTA_PRECIOS_BIN); // Tarea 4 (Verificación pos-modificación)

			// --- III. Serialización y JAXB ---
			System.out.println("\n--- INICIANDO SERIALIZACIÓN (T.6) ---");
			// Primero, creamos el fichero
			guardarSerializado(stockInicial, RUTA_STOCK_OBJ); // Tarea 6
			// Luego, añadimos un nuevo artículo
			List<Articulo> nuevoArticulo = new ArrayList<>();
			nuevoArticulo.add(new Articulo("P005", "Ratón Inalámbrico", 12, 25.00));
			guardarSerializado(nuevoArticulo, RUTA_STOCK_OBJ);

			System.out.println("--- [T.7] VERIFICACIÓN DE OBJETOS SERIALIZADOS ---");
			leerFicheroObjetos(RUTA_STOCK_OBJ); // Tarea 7

			convertirBinarioA_XML(RUTA_STOCK_OBJ, RUTA_XML); // Tarea 8

			generarResumen(RUTA_XML, RUTA_RESUMEN); // Tarea 9
			System.out.println("[T.9] Reporte final generado en: " + RUTA_RESUMEN);
			System.out.println("\n--- FIN DEL EXAMEN ---");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// =========================================================================
	// I. FICHEROS DE TEXTO
	// =========================================================================

	// Tarea 1: Exportación a Fichero de Texto (CSV)
	public static void exportarA_CSV(List<Articulo> lista, String ruta) throws IOException {
		File f = new File(ruta);
		BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
		for (Articulo articulo : lista) {
			bw.write(articulo.toString());
			bw.newLine();
		}
		bw.close();
	}

	// Tarea 2: Recuperación de Texto y Documentación (Contar Stock 0)
	public static int contarLineasNoVacias(String rutaFichero) throws IOException {
		// Creamos variables las cuales vamos a utilizar mas tarde
		File f = new File(rutaFichero);
		int contador = 0;
		// Usando un bufferReader recuperamos todas las lineas de texto
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			String linea;
			// Consumimos 1 linea con el br para evitar un error
			int aux = 0;
			br.readLine();
			// Hacemos el bucle para ir leyendo linea por linea
			while ((linea = br.readLine()) != null) {
				// Separamos por ;
				String[] result = linea.split(";");
				// Aqui hacemos la condicion
				aux = Integer.parseInt(result[2]);
				if (aux == 0) {
					contador++;
				}

			}

			return contador;
		} catch (IOException e) {
			e.printStackTrace();
			return contador;
		}

	}

	// =========================================================================
	// II. FICHEROS BINARIOS PRIMITIVOS Y ACCESO ALEATORIO (TODO RandomAccessFile)
	// =========================================================================

	// Tarea 3: Almacenamiento de Datos Primitivos
	public static void guardarID_Precio(List<Articulo> lista, String rutaFichero) throws IOException {
		File f = new File(rutaFichero);
		if (!f.exists()) {
			f.createNewFile();
		}
		long posicion = 0;
		try (RandomAccessFile rf = new RandomAccessFile(f, "rw")) {
			rf.seek(posicion);
			for (Articulo articulo : lista) {
				StringBuilder sb = new StringBuilder(articulo.getCodigo());
				sb.setLength(10);
				rf.writeUTF(sb.toString());
				posicion = posicion + 20;
				rf.writeDouble(articulo.getPrecio());
				posicion = rf.length();
				rf.seek(posicion);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Tarea 4: Verificación de Fichero Binario
	public static void leerFicheroPreciosBinario(String rutaFichero) {
//Creamos fichero y variables las cuales vamos a utilizar	
		File f = new File(rutaFichero);
		String codigo;
		double precio;
		long posicion = 0;
	//Creamos el random acces file solo para de tipo lectura
		try (RandomAccessFile rf = new RandomAccessFile(f, "r")) {
	//agregamos la posicion 0 al puntero
			rf.seek(posicion);
	//usando el bucle while vamos sacando la informacion del fichero guardandola en las variables	
			while (rf.getFilePointer() < rf.length()) {
				codigo = rf.readUTF();
				posicion = posicion + 20;
				precio = rf.readDouble();
				posicion = posicion + 8;
	//imprimimos las dos variables en las cuales se encuentran nuestra informacion			
				System.out.println("Codigo: " + codigo.trim() + " precio: " + precio);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Tarea 5: Modificación con Posicionamiento Aleatorio
	public static void modificarPrecioPorPosicion(String rutaFichero, int posicion, double nuevoPrecio) {
	//Creacion del fichero
		File f = new File(rutaFichero);
	
		long pos=0;
	//Formula para cambiar cualquier posicion
		int aux=(int) (pos+(28+(posicion-1)+20-(4+(posicion-1))));
		try (RandomAccessFile rf = new RandomAccessFile(f, "rw")) {	
		//Situamos el puntero	
			rf.seek(pos);
			pos=aux;
		//Le agregamos la posicion y cambiamos	
			rf.seek(pos);
			rf.writeDouble(nuevoPrecio);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// =========================================================================
	// III. SERIALIZACIÓN DE OBJETOS Y CONVERSIÓN JAXB
	// =========================================================================

	// Tarea 6: Almacenamiento y Añadido de Objetos
	public static void guardarSerializado(List<Articulo> articulos, String ruta) {
		File f = new File(ruta);
		ObjectOutputStream oos;
		FileOutputStream fos;
		try {
			if (!f.exists()) {
				fos = new FileOutputStream(f);
				oos = new ObjectOutputStream(fos);
			} else {
				fos = new FileOutputStream(f, true);
				oos = new ObjectStreamAppender(fos);
			}
			for (Articulo articulo : articulos) {
				oos.writeObject(articulos);
			}
			oos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Tarea 7: Verificación de Serialización
	public static void leerFicheroObjetos(String rutaFichero) {
		File f = new File(rutaFichero);
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
			while (true) {
				Articulo articulo = (Articulo) ois.readObject();
				System.out.println(articulo);
			}

		} catch (Exception e) {
			System.out.println("------------------");
			System.out.println("Fichero cerrado");
		}
	}

	// Método auxiliar para Tarea 8 (reutiliza lógica de Tarea 7)
	private static List<Articulo> leerTodosLosObjetos(String rutaFichero) {
		File f = new File(rutaFichero);
		ArrayList<Articulo> lista = new ArrayList<Articulo>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
			while (true) {
				Articulo articulo = (Articulo) ois.readObject();
				lista.add(articulo);
			}
		} catch (Exception e) {
			System.out.println("------------------");
			System.out.println("Fichero cerrado");
			return lista;
		}
	}

	// Tarea 8: Conversión Objeto Serializado a XML
	public static void convertirBinarioA_XML(String rutaBinario, String rutaXML) {
		try {
			JAXBContext contecto = JAXBContext.newInstance(Almacen.class);
			Marshaller m = contecto.createMarshaller();
			Almacen almacen = new Almacen();
			almacen.setArticulos(leerTodosLosObjetos(rutaBinario));

			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			FileWriter fw = new FileWriter(rutaXML);
			m.marshal(almacen, fw);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Tarea 9: Conversión XML a Reporte Final
	public static void generarResumen(String rutaXML, String rutaSalida) {
		File f = new File(rutaXML);

		int contador = 0;
		double acumulador = 0;
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(rutaSalida));
			JAXBContext contexto = JAXBContext.newInstance(Almacen.class);
			Unmarshaller um = contexto.createUnmarshaller();
			Almacen almacen = (Almacen) um.unmarshal(f);
			List<Articulo> articulos = almacen.getArticulos();
			for (Articulo articulo : articulos) {
				contador++;
				acumulador += articulo.getPrecio();
			}
			double suma = acumulador / contador;
			bw.write("--REPORTE DE ARTICULOS CON PRECIO SUPERIOR AL PROMEDIO--");
			bw.newLine();
			bw.write("Precio promedio: " + suma + "€");
			bw.newLine();
			bw.newLine();
			for (Articulo articulo : articulos) {
				if (articulo.getPrecio() > suma) {
					bw.write("[" + articulo.getCodigo() + "] " + articulo.getNombre() + ": " + articulo.getPrecio()
							+ "€");
					bw.newLine();
				}

			}
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}