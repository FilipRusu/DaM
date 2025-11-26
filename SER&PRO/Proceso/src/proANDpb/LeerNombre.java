package proANDpb;

public class LeerNombre {

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Introduzca nombres");
			// System.exit(2);
			return;

		}
		String nombre = args[0] + " " + args[1];
		
		System.out.println(nombre);

	}

}
