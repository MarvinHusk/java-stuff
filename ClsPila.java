
public class ClsPila {
	ClsLista Lista;
	int cantidad;

	public ClsPila() {
		Lista = new ClsLista();
		cantidad = 0;
	}

	public void push(int dato) {
		Lista.inserta(dato);
		cantidad++;
	}

	public int pop() {
		//int borrado = Lista.inicio.getDato();
		int borrado = Lista.getdato(cantidad-1);
		Lista.borrar(cantidad-1); // siempre borra el tope
		cantidad--;
		return borrado;
	}

	public int tope() {
		return Lista.getdato(cantidad-1);
	}
}
