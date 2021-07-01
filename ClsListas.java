import java.util.Random;

public class ClsListas {

	public ClsLista llena(ClsLista milista, int cantidad) {
		Random numRandom = new Random();
		for (int i = 0; i < cantidad; i++) {
			milista.inserta(numRandom.nextInt(10));
		}
		return milista;
	}

	public ClsLista suma(ClsLista listaA, ClsLista listaB, ClsLista listaC, int cantidad) {
		for (int i = 0; i < cantidad; i++) {
			listaC.inserta(listaA.getdato(i) + listaB.getdato(i));
		}
		return listaC;
	}
	
	public ClsLista multiplic(ClsLista listaA, ClsLista listaB, int cantidad, int multiplo) {
		for (int i = 0; i < cantidad; i++) {
			listaB.inserta(listaA.getdato(i) * multiplo);
		}
		return listaB;
	}

}
