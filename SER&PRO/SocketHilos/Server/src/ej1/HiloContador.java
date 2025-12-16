package ej1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class HiloContador extends Thread {
	Socket socket;
	ServidorContador server;
	
	
	
	public HiloContador(Socket socket,ServidorContador server) {
	this.socket = socket;
	this.server =server;
	}

	
	@Override
	public void run() {
		try (
				OutputStreamWriter out= new OutputStreamWriter(socket.getOutputStream(),"UTF-8");
				BufferedWriter escritor= new BufferedWriter(out);
				){
			String aux="Eres el hilo:"+server.sumar();
			escritor.write(aux);
			escritor.flush();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
	
		}
	}
}
