
public class ClsNodo {
	
	private int dato;
	private ClsNodo sig;
	
	public ClsNodo(int valor) {
		dato = valor;
		sig = null;
	}

	public ClsNodo(int valor, ClsNodo valor2) {
		dato = valor;
		sig = valor2;
	}
	
	public int getDato() {
		return dato;
	}

	public ClsNodo getSig() {
		return sig;
	}

	public void setDato(int valor) {
		dato = valor;
	}

	public void setSig(ClsNodo valor) {
		sig = valor;
	}
	
	

}
