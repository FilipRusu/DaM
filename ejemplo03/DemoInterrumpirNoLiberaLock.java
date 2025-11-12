package ejemplo03;

public class DemoInterrumpirNoLiberaLock {

    public static void main(String[] args) throws InterruptedException {
        Cuenta cuenta = new Cuenta();

        HiloLargo t1 = new HiloLargo(cuenta);
        HiloCorto t2 = new HiloCorto(cuenta);

        t1.start();
        Thread.sleep(500); // esperamos a que t1 tome el lock
        t2.start();//antes de interrumpir al hilo 1 lanzo el hilo 2

        Thread.sleep(500); // dejamos que t2 quede bloqueado esperando
        System.out.println(">>> Interrumpiendo al Hilo-1 desde main y no han pasado los segundos del sleep que tiene");
        t1.interrupt();   // Interrumpimos el hilo que está en sleep
        

    }
}






