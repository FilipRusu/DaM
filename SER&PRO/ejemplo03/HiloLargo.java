package ejemplo03;

//Hilo que hará la operación larga y mantendrá el lock
public class HiloLargo extends Thread {
 private Cuenta cuenta;

 public HiloLargo(Cuenta c) {
     super("Hilo-1");
     this.cuenta = c;
 }

 public void run() {
     cuenta.operacionLarga();
 }
}