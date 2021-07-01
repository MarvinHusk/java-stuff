import java.util.Stack;
import javax.swing.DefaultListModel;

public class claseproyecto {

	// -----EXPRESION

	public String expresion(String ecuacion) {

		ecuacion = "(" + ecuacion.replaceAll("\\s+", "") + ")";
		String Simbolos = "+-*/()^";

		String nuevaexpresion = "";

		for (int i = 0; i < ecuacion.length(); i++) {

			if (Simbolos.contains("" + ecuacion.charAt(i))) {

				nuevaexpresion += " " + ecuacion.charAt(i) + " ";
			}

			else {
				nuevaexpresion += ecuacion.charAt(i);
			}

		}
		return nuevaexpresion.replaceAll("\\s+", " ").trim();
	}

	// -------POSTFIJO

	public String Postfijo(String nuevaexpresion) {
		nuevaexpresion = expresion(nuevaexpresion);
		String[] arreglo = nuevaexpresion.split(" ");
		ClsPila Entrada = new ClsPila();
		ClsPila Operators = new ClsPila();
		Stack<String> Salida = new Stack<String>();

		for (int i = arreglo.length - 1; i >= 0; i--) {
			Entrada.Push(arreglo[i]);
		}

		while (!Entrada.estavacia()) {

			if (preferencia(Entrada.Peek()) == 1) {

				Operators.Push(Entrada.Pop());

			} else if (preferencia(Entrada.Peek()) == 2) {

				while (!Operators.Peek().equals("(")) {

					Salida.push(Operators.Pop());

				}

				Operators.Pop();
				Entrada.Pop();

			} else if (preferencia(Entrada.Peek()) == 3 || preferencia(Entrada.Peek()) == 4) {

				while (preferencia(Operators.Peek()) >= preferencia(Entrada.Peek())) {

					Salida.push(Operators.Pop());

				}

				Operators.Push(Entrada.Pop());

			} else if (preferencia(Entrada.Peek()) == 5) {

				Operators.Push(Entrada.Pop());
			} else {

				Salida.push(Entrada.Pop());
			}

		}

		return Salida.toString().replaceAll("[\\]\\[,]", "");

	}

	// VALOR DE PRIORIDAD
	public int preferencia(String Expression) {
		int prioridad = 6;
		if (Expression.equals("^")) {
			prioridad = 5;
		} else if (Expression.equals("*") || Expression.equals("/")) {
			prioridad = 4;
		} else if (Expression.equals("+") || Expression.equals("-")) {
			prioridad = 3;
		} else if (Expression.equals(")")) {
			prioridad = 2;
		} else if (Expression.equals("(")) {
			prioridad = 1;
		}
		return prioridad;
	}

	// ----------------------------------------------------------------

	// SOLUCION A LA EXPRESION
	public String CalcularExpresion(String expresion) {

		String[] arrOperacion = expresion.split(" ");

		ClsPila pilaOperacion = new ClsPila();

		ClsPila pilaResultado = new ClsPila();

		String Operator = "+-*/^";

		for (int i = arrOperacion.length - 1; i >= 0; i--) {
			pilaOperacion.Push(arrOperacion[i]);
		}

		while (!pilaOperacion.estavacia()) {

			if (Operator.contains(pilaOperacion.Peek())) {
				pilaResultado
						.Push(evaluarOperacion(pilaResultado.Pop(), pilaResultado.Pop(), pilaOperacion.Pop()) + "");
			}

			else {
				pilaResultado.Push(pilaOperacion.Pop());
			}
		}
		return pilaResultado.Peek();
	}

	// EVALUAR NUMEROS RESPECTO AL OPERADOR
	public double evaluarOperacion(String n2, String n1, String op) {

		switch (op) {
		case "+":
			return Double.parseDouble(n1) + Double.parseDouble(n2);
		case "-":
			return Double.parseDouble(n1) - Double.parseDouble(n2);
		case "*":
			return Double.parseDouble(n1) * Double.parseDouble(n2);
		case "/":
			return Double.parseDouble(n1) / Double.parseDouble(n2);
		case "^":
			return Math.pow(Double.parseDouble(n1), Double.parseDouble(n2));
		default:
			return 0;
		}
	}

	//// IMPRIMIR EXPRESION/POSTFIJO/SOLUCION
	private DefaultListModel<String> listafinal = new DefaultListModel<String>();

	public DefaultListModel<String> respuesta(String Expression) {
		listafinal.clear();
		listafinal.addElement("Proyecto Pilas");

		listafinal.addElement("Expresion: " + expresion(Expression));

		listafinal.addElement("Jerarquia: " + Postfijo(Expression));

		listafinal.addElement("Solucion: " + CalcularExpresion(Postfijo(Expression)));

		listafinal.addElement("---------");
		return listafinal;
	}

}