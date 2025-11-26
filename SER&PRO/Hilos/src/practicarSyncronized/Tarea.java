package practicarSyncronized;

public class Tarea implements Runnable{
private	Controlador cn;
private int id;	
	
	

public Tarea(Controlador cn, int id) {
	this.cn = cn;
	this.id = id;
}

@Override
	public void run() {
	cn.preparar(id);
	}

}
