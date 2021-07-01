import java.util.Random;
import java.util.PrimitiveIterator.OfDouble;

import javax.swing.DefaultListModel;

public class ClsMetodosOrdenamiento {
	long tiempoInicial, tiempoFinal;
	int[] arregloNormal;

	public int[] generarNumeros(int cantidad) {
		arregloNormal = new int[cantidad];
		Random alea = new Random();
		for (int i = 0; i < cantidad; i++) {
			arregloNormal[i] = alea.nextInt(100000);
		}
		return arregloNormal;
	}

	public int[] BubbleSort(int[] arreglo) {
		tiempoInicial = System.currentTimeMillis();
		// Tamaño del arreglo
		int tam = arreglo.length;
		boolean cambio;
		for (int i = 0; i < tam; i++) {
			cambio = false;
			for (int j = 0; j < tam - 1; j++) {
				if (arreglo[j] > arreglo[j + 1]) {
					int aux = arreglo[j];
					arreglo[j] = arreglo[j + 1];
					arreglo[j + 1] = aux;
					cambio = true;
				}
			}
			if (!cambio) {
				break;
			}
		}
		tiempoFinal = System.currentTimeMillis();
		return arreglo;
	}

	public int[] ShellSort(int[] arreglo) {
		int tam = arreglo.length;
		tiempoInicial = System.currentTimeMillis();

		for (int intervalo = tam / 2; intervalo > 0; intervalo /= 2) {

			for (int i = intervalo; i < arreglo.length; i++) {

				int aux = arreglo[i];
				int j = i;

				while (j >= intervalo && arreglo[j - intervalo] > aux) {

					arreglo[j] = arreglo[j - intervalo];
					j -= intervalo;

				}

				arreglo[j] = aux;

			}

		}

		tiempoFinal = System.currentTimeMillis();
		return arreglo;
	}

	public int[] quicksort(int Arreglo[], int izquierdo, int derecho) {

		int pivote = Arreglo[izquierdo];
		int indiceizq = izquierdo;
		int indiceder = derecho;
		int aux;

		while (indiceizq < indiceder) {
			while (Arreglo[indiceizq] <= pivote && indiceizq < indiceder) {
				indiceizq++;
			}

			while (Arreglo[indiceder] > pivote) {
				indiceder--;
			}

			if (indiceizq < indiceder) {
				aux = Arreglo[indiceizq];
				Arreglo[indiceizq] = Arreglo[indiceder];
				Arreglo[indiceder] = aux;
			}
		}

		Arreglo[izquierdo] = Arreglo[indiceder];
		Arreglo[indiceder] = pivote;

		if (izquierdo < indiceder - 1)
			quicksort(Arreglo, izquierdo, indiceder - 1); // recursividad: ordenamos arreglo izquierdo
		if (indiceder + 1 < derecho)
			quicksort(Arreglo, indiceder + 1, derecho); // recursividad: ordenamos arreglo derecho

		tiempoFinal = System.currentTimeMillis();
		return Arreglo;
	}

	// tiempo QuickSort
	public String obtenerTiempo(long inicio, long fin) {
		return "Tiempo: " + (fin - inicio) + " milisegundos";
	}

	// tiempo BubbleSort y ShellSort
	public String obtenerTiempo() {
		return "Tiempo: " + (tiempoFinal - tiempoInicial) + " milisegundos";
	}

	public DefaultListModel<Integer> imprimir(int[] arr) {
		DefaultListModel<Integer> lista = new DefaultListModel<>();
		lista.clear();
		for (int num : arr) {
			lista.addElement(num);
		}
		return lista;
	}

	// arreglo para el form
	public int[] obtenerArreglo() {
		int[] arregloform = new int[arregloNormal.length];

		for (int i = 0; i < arregloform.length; i++) {
			arregloform[i] = arregloNormal[i];
		}
		return arregloform;
	}

}
