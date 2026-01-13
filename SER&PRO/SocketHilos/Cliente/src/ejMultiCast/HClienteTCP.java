package ejMultiCast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HClienteTCP extends Thread{
	private  Socket socket;
	private  DataInputStream dis;
	private  DataOutputStream dos;
	private	 static final int puerto=9000;
	private static final String ip="localhost";
	private String id;
	
	
	
	
	public HClienteTCP(String id) {
		this.id = id;
	}

	@Override
	public void run() {
	try {
	iniciar();
	enviarConsulta();
	recibirconsulta();
	parrar();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	}
	
	public void iniciar(){
		try {
			socket=new Socket(ip,puerto);
			dis=new DataInputStream(socket.getInputStream());
			dos=new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void parrar() throws IOException {
		dis.close();
		dos.close();
		socket.close();	
	}
	
	public void enviarConsulta() throws IOException {
		System.out.println("Consulta enviada");
		dos.writeUTF(id);
		dos.flush();
		new HClienteUDP().start();
	}
	public void recibirconsulta() throws IOException {
	
		System.out.println("Consulta recibida TCP:"+dis.readUTF());
	}
	
	
}
