
public class Clstarea {
//+,-,*,(,),/,^
//0,1,2,3,4,5,6,7,8,9
	ClsListaS Lista;
	int cantidad;

	public Clstarea() {
		Lista = new ClsListaS();
		cantidad = 0;
	}

	public void acomodar(String eq) {
		String numerito = "";
		String aritmetico = "";
		for (int j = 0; j < eq.length(); j++) {
			if (eq.charAt(j) == '+' || eq.charAt(j) == '-' || eq.charAt(j) == '*' || eq.charAt(j) == '/'
					|| eq.charAt(j) == '=' || eq.charAt(j) == '(' || eq.charAt(j) == ')' || eq.charAt(j) == '^') {
				aritmetico = Character.toString(eq.charAt(j));
				Lista.insertaS(aritmetico);
			} else {
				for (int i = j; i < eq.length(); i++) {
					//character.isdigit
					if (eq.charAt(i) == '0' || eq.charAt(i) == '1' || eq.charAt(i) == '2' || eq.charAt(i) == '3'
							|| eq.charAt(i) == '4' || eq.charAt(i) == '5' || eq.charAt(i) == '6' || eq.charAt(i) == '7'
							|| eq.charAt(i) == '8' || eq.charAt(i) == '9' || eq.charAt(i) == '.') {
						numerito = numerito + eq.charAt(i);
					}
					if (eq.charAt(i + 1) == '+' || eq.charAt(i + 1) == '-' || eq.charAt(i + 1) == '*'
							|| eq.charAt(i + 1) == '/' || eq.charAt(i + 1) == '=' || eq.charAt(i + 1) == '('
							|| eq.charAt(i + 1) == ')' || eq.charAt(i + 1) == '^') {
						// arit = numerito;
						// numerito = numerito + eq.charAt(i);
						Lista.insertaS(numerito);
						numerito = "";
						// break;
					}
					break;
				}
			}
			cantidad++;
		}
	}
	
	public void pop() {
		Lista.borrar(cantidad-1); // siempre borra el tope
		cantidad--;
	}
	
	/*
	 * public DefaultListModel Desgloce(String Model) { Character Caracter; String
	 * Funcion = ""; DefaultListModel list = new DefaultListModel(); for(int i = 0;
	 * i < Model.length(); i++) { Caracter = Model.charAt(i);
	 * if(Character.isDigit(Caracter)) { Funcion += Caracter; } else {
	 * list.addElement(Funcion); list.addElement(Caracter); Funcion = ""; } } return
	 * list; }
	 */
}