package ejemplo03;

//Hilo que espera a poder entrar en otro método sincronizado
public class HiloCorto extends Thread {
 private Cuenta cuenta;

 public HiloCorto(Cuenta c) {
     super("Hilo-2");
     this.cuenta = c;
 }

 public void run() {
     cuenta.operacionCorta();
 }
}