package ej5;

public class App {

	public static void main(String[] args) {
		try {
			if (args.length < 1) {
				System.exit(1);	
			}
			int nr=Integer.parseInt(args[0]);
			if(nr<0) {
				System.exit(3);
			}
			if(nr>0) {
				System.exit(4);
			}
		}
		catch (NumberFormatException e) {
			System.exit(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

}
