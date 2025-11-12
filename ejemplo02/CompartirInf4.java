package ejemplo02;

public class CompartirInf4 {
	public static void main(String[] fer) {
		Cuenta2 c = new Cuenta2(40);
		SacarDinero2 h1 = new SacarDinero2("Ana", c);
		SacarDinero2 h2 = new SacarDinero2("Juan", c);

		h1.start();
		h2.start();
	}
}