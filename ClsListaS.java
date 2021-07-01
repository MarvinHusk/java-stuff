import javax.swing.DefaultListModel;

public class ClsListaS {
	ClsNodoS inicio, fin;

	public ClsListaS() {
		inicio = null;
		fin = null;
	}

	public void insertaS(String dato) {
		if (inicio == null && fin == null) { // vacia
			// inicio = fin = new ClsNodo(dato);
			inicio = new ClsNodoS(dato);
			fin = inicio;
		} else {
			fin.setSiguiente(new ClsNodoS(fin, dato, null));
			fin = fin.getSiguiente();
		}
	}

	DefaultListModel modeloinicio = new DefaultListModel();
	DefaultListModel modelofin = new DefaultListModel();

	public void iniciofin() {
		modeloinicio.clear();
		ClsNodoS aux = inicio;
		if (inicio != null) { // no este vacia
			while (aux.getSiguiente() != null) { // mientras haya elementos despues
				modeloinicio.addElement(aux.getDato()); // se agrega el dato
				aux = aux.getSiguiente(); // se recorre al siguiente dato
			}
			modeloinicio.addElement(aux.getDato());
		}
	}

	public void fininicio() {
		modelofin.clear();
		ClsNodoS aux = fin;
		if (fin != null) { // no este vacia

			while (aux.getAnterior() != null) { // mientras haya elementos antes
				modelofin.addElement(aux.getDato()); // se agrega el dato
				aux = aux.getAnterior(); // se recorre al dato anterior
			}
			modelofin.addElement(aux.getDato());
		}
	}

	public void limpiar() {
		modelofin.clear();
	}

	public String dato;

	public String borrar(int indice) {
		ClsNodoS aux = inicio;
		for (int i = 0; i < indice; i++) {
			aux = aux.getSiguiente();
		}
		dato = aux.getDato();

		if (inicio == null) {

		}

		// unico dato
		if (aux.getSiguiente() == null && aux.getAnterior() == null) {

			inicio = fin = null; // lista vacia

		}

		// primer dato
		else if (aux == inicio) {

			// cambiamos el inicio anterior por el del siguiente nodo
			inicio = inicio.getSiguiente();
			// ponemos nulo el inicio anterior
			inicio.setAnterior(null);

		}

		// ultimo dato
		else if (aux == fin) {
			// me situo en el anterior y pongo el siguiente nulo, lo que lo vuelve el final
			fin.getAnterior().setSiguiente(null);
			fin = fin.getAnterior();
		}

		// cualquier dato
		else if (aux.getSiguiente() != null && aux.getAnterior() != null) {

			aux.getAnterior().setSiguiente(aux.getSiguiente());

			aux.getSiguiente().setAnterior(aux.getAnterior());

		}
		return dato;
	}

	public String getdato(int indice) {
		ClsNodoS aux = inicio;
		for (int i = 0; i < indice; i++) {
			aux = aux.getSiguiente();
		}
		return aux.getDato();
	}
}
