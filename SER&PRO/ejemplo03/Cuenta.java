package ejemplo03;

//Clase que tiene métodos sincronizados
public class Cuenta {

 public synchronized void operacionLarga() {
     System.out.println(Thread.currentThread().getName() + " entra y BLOQUEA el monitor.");
     try {
         Thread.sleep(4000); // duerme PERO NO SUELTA EL LOCK
     } catch (InterruptedException e) {
         System.out.println(Thread.currentThread().getName() + " fue interrumpido pero no suelta el lock");
     }
     System.out.println(Thread.currentThread().getName() + " sale y LIBERA el monitor.");
 }

 public synchronized void operacionCorta() {
     System.out.println(Thread.currentThread().getName() + " entra (solo podrá entrar cuando el lock se libere y al revés)");

	 //no esperamos casi nada porque es corta y así simulamos que tarda poco
	 try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
        System.out.println(Thread.currentThread().getName() + " fue interrumpido pero no suelta el lock");
	}
 }
}