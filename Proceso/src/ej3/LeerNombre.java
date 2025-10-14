package ej3;

public class LeerNombre {

	public static void main(String[] args) {
	
		try {
			if(args.length>0) {
				System.out.println(args[0]);
				System.exit(1);
			}
			else {
				System.exit(2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
