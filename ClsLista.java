import java.util.Iterator;
import java.util.Random;

import javax.swing.DefaultListModel;

public class ClsLista {
	ClsNodo inicio;

	public ClsLista() {
		inicio = null;
	}

	public void agregar(int dato) {
		if (inicio == null) { // si la lista esta vacia
			inicio = new ClsNodo(dato, null);
		} else {
			ClsNodo aux = inicio;

			while (aux.getSig() != null) {

				aux = aux.getSig();

			}
			ClsNodo nuevodato = new ClsNodo(dato);
			aux.setSig(nuevodato);
		}
	}

	DefaultListModel modelo = new DefaultListModel();

	public DefaultListModel imprimir() {
		modelo.clear();
		ClsNodo aux = inicio;
		while (aux != null) {
			modelo.addElement(aux.getDato());
			aux = aux.getSig();
		}
		return modelo;
	}

	public void borrar(int indice) {
		if (inicio != null) {
			if (indice == 0) {
				inicio = inicio.getSig();
			} else {
				ClsNodo aux = inicio;
				indice--;
				for (int i = 0; i < indice; i++) {
					aux = aux.getSig();
				}
				ClsNodo otro = aux.getSig().getSig(); // 2 nodos adelante
				aux.setSig(otro);
			}
		}
	}

	public void intercambiar(int indice1, int indice2) {
		ClsNodo aux, aux1, aux2;
		aux = inicio;
		aux1 = inicio;
		aux2 = inicio;
		for (int i = 0; i <= modelo.getSize() - 1; i++) {
			if (i == indice1) {
				aux1 = aux;
			}
			if (i == indice2) {
				aux2 = aux;
			}
			aux = aux.getSig();
		}
		int valor1 = aux1.getDato();
		int valor2 = aux2.getDato();
		aux1.setDato(valor2);
		aux2.setDato(valor1);
	}

	DefaultListModel modelo1 = new DefaultListModel();
	DefaultListModel modelo2 = new DefaultListModel();
	DefaultListModel modelo1y2 = new DefaultListModel();
	Random numm = new Random();

	public DefaultListModel<Integer> combfacil() {
		for (int i = 0; i < 5; i++) {
			modelo1y2.addElement(modelo1.getElementAt(i));
			modelo1y2.addElement(modelo2.getElementAt(i));
		}
		return modelo1y2;
	}

	public int getelem(int indice) {
		ClsNodo aux = inicio;
		for (int i = 0; i < indice; i++) {
			aux = aux.getSig();
		}
		return aux.getDato();
	}

	public void agregainicio(int valor) {
		if (inicio == null) { // lista vacia
			inicio = new ClsNodo(valor); // primer dato
		} else { // no esta vacia
			inicio = new ClsNodo(valor, inicio); // nuevo primer dato
		}
	}

//	public void InsertarOrdenado()
//	{
//		boolean added = false;
//		if (inicio == null) 
//		{
//			//InsertarInicio(Dato);
//		}
//		else 
//		{
//			ClsNodo Aux0, Aux1, Aux2;
//			Aux0 = inicio;
//			Aux1 = inicio;
//			Aux2 = inicio;
//			
//			do 
//			{
//					if (Dato.compareTo(Aux1.getDato()) <= 0) 
//					{
//						if (Aux1 == Inicio && Aux2 == Inicio) 
//						{
//							InsertarInicio(Dato);
//							added = true;
//						}
//						else
//						{		
//							Aux2.setSig(new ClsNodo(Aux2.getSig(), Dato));	
//							added = true;
//						}
//					
//					}
//					
//					if (Dato.compareTo(Final.getDato()) >= 0) 
//					{
//						if (Aux1 == Final && Aux2 == Final) 
//						{
//							InsertarFinal(Dato);
//							added = true;
//						}
//						else
//						{		
//							Aux2.setSig(new ClsNodo(Aux1.getSig(), Dato));	
//							added = true;
//						}
//					
//					}
//					
//				Aux2 = Aux1;
//				Aux1 = Aux1.getSig();
//			} 
//			while (added == false);
//		}
//	}

}
