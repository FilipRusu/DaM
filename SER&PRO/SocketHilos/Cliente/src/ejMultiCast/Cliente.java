package ejMultiCast;

import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) {
		Scanner src = new Scanner(System.in);
		System.out.print("Product id:");
		String id =src.nextLine();
		
		
		HClienteTCP h1=new HClienteTCP(id);
		h1.start();
	}
}
