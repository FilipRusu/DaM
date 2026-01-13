package ej1;


public class LanzadorContador {
    private static final String HOST = "localhost";
    private static final int PUERTO = 49171;

    public static void main(String[] args) {
        System.out.println("--- LANZADOR: PRUEBA EJERCICIO 1 (2 HILOS) ---");
        
        // Hilo Cliente 1
        ClienteContador cliente1 = new ClienteContador(HOST, PUERTO);
        
        // Hilo Cliente 2
        ClienteContador cliente2 = new ClienteContador(HOST, PUERTO);
        
        // Iniciamos la ejecución de forma concurrente
        cliente1.start();
        cliente2.start();

        try {
            cliente1.join();
            cliente2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("--- LANZADOR FINALIZADO. ---");
    }
}
