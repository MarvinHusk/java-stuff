
public class ClsNodo {
	private ClsNodo anterior;
	private Integer dato;
	private ClsNodo siguiente;

	public ClsNodo(int valor) {
		this.dato = valor;
		this.anterior = null;
		this.siguiente = null;
	}

	public ClsNodo(ClsNodo ant, int valor, ClsNodo sig) {
		this.dato = valor;
		this.anterior = ant;
		this.siguiente = sig;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int valor) {
		this.dato = valor;
	}

	public ClsNodo getAnterior() {
		return anterior;
	}

	public void setAnterior(ClsNodo ant) {
		this.anterior = ant;
	}

	public ClsNodo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(ClsNodo sig) {
		this.siguiente = sig;
	}

}
