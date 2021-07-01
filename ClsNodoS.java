
public class ClsNodoS {
	private ClsNodoS anterior;
	private String dato;
	private ClsNodoS siguiente;

	public ClsNodoS(String valor) {
		this.dato = valor;
		this.anterior = null;
		this.siguiente = null;
	}

	public ClsNodoS(ClsNodoS ant, String valor, ClsNodoS sig) {
		this.dato = valor;
		this.anterior = ant;
		this.siguiente = sig;
	}

	public String getDato() {
		return dato;
	}

	public void setDato(String valor) {
		this.dato = valor;
	}

	public ClsNodoS getAnterior() {
		return anterior;
	}

	public void setAnterior(ClsNodoS ant) {
		this.anterior = ant;
	}

	public ClsNodoS getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(ClsNodoS sig) {
		this.siguiente = sig;
	}
}
