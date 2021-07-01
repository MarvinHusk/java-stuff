import java.util.Iterator;
import java.util.Random;
import javax.management.relation.InvalidRelationTypeException;

public class ClsComb {

	public ClsLista llena(ClsLista milista, int cantidad) {
		Random numRandom = new Random();
		for (int i = 0; i < cantidad; i++) {
			milista.agregar(numRandom.nextInt(10));
		}
		return milista;
	}

	ClsNodo auxA, auxB, auxC, auxO;

	public ClsLista combina(ClsLista milistaA, ClsLista milistaB, ClsLista milistaC, int cantidad) {
		auxA = milistaA.inicio;
		auxB = milistaB.inicio;
		auxC = milistaC.inicio;
		for (int i = 0; i < cantidad; i++) {
			milistaC.agregar(auxA.getDato());
			milistaC.agregar(auxB.getDato());
			auxA = auxA.getSig();
			auxB = auxB.getSig();
			// milistaC.agregar((int)milistaA.modelo.getElementAt(i));
			// milistaC.agregar((int)milistaB.modelo.getElementAt(i));
		}
		return milistaC;
	}

	public ClsLista concatena(ClsLista milistaA, ClsLista milistaB, ClsLista milistaC, int cantidad) {
		Integer cant = cantidad * 2;
		auxA = milistaA.inicio;
		auxB = milistaB.inicio;
		auxC = milistaC.inicio;
		for (int i = 0; i < cant; i++) {
			if (milistaC.inicio == null) { // si la listaC esta vacia

				milistaC.inicio = new ClsNodo(auxA.getDato()); // se agrega el primer dato de la listaA
				auxA = auxA.getSig();

			} else {
				if (auxA.getSig() != null) { // se agrega la listaA mientras el siguiente de auxA no sea nulo
					while (auxA.getSig() != null) {
						milistaC.agregar(auxA.getDato());
						auxA = auxA.getSig();
						if (auxA.getSig() == null) {
							milistaC.agregar(auxA.getDato());
						}
					}
				} else { // si el sig de auxA es nulo se empieza a agregar la listaB
					if (auxB.getSig() != null) {
						while (auxB.getSig() != null) {
							milistaC.agregar(auxB.getDato());
							auxB = auxB.getSig();
							if (auxB.getSig() == null) {
								milistaC.agregar(auxB.getDato());
							}
						}
					}
				}
			}
		}
		return milistaC;
	}

	public ClsLista ordenachafa1(ClsLista Ordenada, ClsLista milistaC, int cantidad) {
		Integer cant = cantidad * 2; // el tam de las 2 listas juntas
		Ordenada.inicio = milistaC.inicio;
		auxO = Ordenada.inicio;
		ClsNodo aux1;
		ClsNodo aux2;
		for (int i = 0; i < cant; i++) {

			if (Ordenada.inicio != null) { // mientras no este vacia

				// -----------
				if (auxO.getSig() != null) {
					while (auxO.getSig() != null) {
						
						if (auxO.getDato() > auxO.getSig().getDato()) {
							aux1 = auxO;
							aux2 = auxO.getSig();
							auxO.setDato(aux2.getDato());
							auxO.getSig().setDato(aux1.getDato());
							auxO = auxO.getSig();
							
						} else {
							auxO = auxO.getSig();
						}
					}
				} else {
					auxO = Ordenada.inicio;
				}

			}
		}
		return Ordenada;
	}

//	public ClsLista ordenachafa2(ClsLista Ordenada, ClsLista milistaC) {
//		//ClsNodo aux1 = auxC.getSig();
//		//ClsNodo aux2 = auxC;
//		// ClsNodo aux2;
//		ClsNodo empiezo = milistaC.inicio ;
//		if (Ordenada.inicio == null) {
//			auxC = milistaC.inicio;
//			Ordenada.inicio = empiezo;
//			auxO = Ordenada.inicio;
//			//auxC = auxC.getSig();
//		} else {
//
//			//ClsNodo aux = milistaC.inicio;
//			while (auxC.getSig() != null) {
//				
//				if (auxC.getDato() > auxC.getSig().getDato()) {
//					
//					if(auxO.getSig()==null) {
//						Ordenada.agregainicio(auxC.getSig().getDato());
//					}
//					
//					else {
//						auxO.setDato(auxO.getSig().getDato());
//						auxO.getSig().setDato(auxC.getDato());
//					}	
//					
//				}
//				auxC = auxC.getSig();
//			}
//			if (auxC == null) {
//				auxC = milistaC.inicio;
//				ordenachafa2(Ordenada, milistaC);
//			}
//		}
//		return Ordenada;
//	}

	public ClsLista Ordenar(ClsLista Ordenada, ClsLista MilistaC, int cantidad) {
		Integer cant = cantidad * 2; // tam lista

		if (cant > 1) { // mientras el tam sea mayor a 1
			boolean cambio; // variable que comprueba si hay un cambio
			do {
				Ordenada.inicio = MilistaC.inicio;

				ClsNodo actual = Ordenada.inicio;
				ClsNodo anterior = null;
				ClsNodo siguiente = Ordenada.inicio.getSig();
				cambio = false;

				while (siguiente != null) {
					if (actual.getDato() > siguiente.getDato()) { // si el dato actual es mayor al siguiente

						cambio = true; // se efectuara un cambio

						if (anterior != null) { // si no es el primer dato

							ClsNodo sig = siguiente.getSig();

							anterior.setSig(siguiente); // sig de anterior se establece como el siguiente
							siguiente.setSig(actual); // sig de siguiente se establece como el actual

							actual.setSig(sig); // sig de actual se establece como el siguiente del siguiente

						} else { // si es el primer dato

							ClsNodo sig = siguiente.getSig();

							MilistaC.inicio = siguiente; // el primer dato es el siguiente
							siguiente.setSig(actual);

							actual.setSig(sig);
						}

						anterior = siguiente; // anterior se guarda como el siguiente
						siguiente = actual.getSig(); // siguiente se guarda como el siguiente al actual

					} // se cierra primer if

					else {// si el dato actual no es mayor

						anterior = actual; // el dato anterior es el actual
						actual = siguiente; // el dato actual es el siguiente
						siguiente = siguiente.getSig(); // el dato siguiente es el siguiente al siguiente
					}

				}
			} while (cambio);
		}
		return Ordenada;
	}

//	public ClsLista ordenamartin(ClsLista Ordenada, ClsLista milistaC, int cantidad) {
//		Integer cant = cantidad * 2;
//		auxC = milistaC.inicio;
//		for (int i = 0; i < cant; i++) { // for
//
//			if (Ordenada.inicio == null) { //si la lista esta vacia
//				Ordenada.agregar(auxC.getDato());
//				auxO = Ordenada.inicio;
//			}
//
//			else { //si no esta vacia
//				ClsNodo aux1;
//				if(auxC.getSig()!= null) {
//					if(auxC.getDato() <= auxC.getSig().getDato()) {
//						auxC = auxC.getSig();
//					}
//					else {
//						
//						if(auxO.getSig()==null) { //primera vez que se compara
//							//Ordenada.agregar(auxC.getSig().getDato());
//							auxO = Ordenada.inicio;
//						}
//						
//						else {
//							while(auxO.getSig()!=null) {
//							aux1 = auxO;
//							auxO.setDato(auxC.getSig().getDato());
//							auxO.getSig().setDato(auxC.getDato());
//							auxO = auxO.getSig();
//							Ordenada.agregar(auxC.getDato());
//							//.setDato(aux1.getDato());
//							}
//						}
//						
//					}
//				}
//				
//				else {
//					auxO = Ordenada.inicio;
//				}
//
//			}
//
//		} // for
//		return Ordenada;
//	}
}
