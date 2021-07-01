import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Forma extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forma frame = new Forma();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Forma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1033, 749);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 41, 136, 294);
		contentPane.add(scrollPane);

		JList list = new JList();
		scrollPane.setViewportView(list);

		textField = new JTextField();
		textField.setBounds(257, 40, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		ClsLista objetoLista = new ClsLista();

		JButton btnNewButton = new JButton("agrega");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int num = Integer.parseInt(textField.getText());
				objetoLista.agregar(num);
				list.setModel(objetoLista.imprimir());
			}
		});
		btnNewButton.setBounds(257, 80, 85, 21);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("borrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				objetoLista.borrar(list.getSelectedIndex());
				list.setModel(objetoLista.imprimir());
			}
		});
		btnNewButton_1.setBounds(257, 126, 85, 21);
		contentPane.add(btnNewButton_1);

		int indice1, indice2;

		JButton btnNewButton_2 = new JButton("selec 1");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// indice1=list.getSelectedIndex();
			}
		});
		btnNewButton_2.setBounds(352, 80, 85, 21);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("selec/inter");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// indice2=list.getSelectedIndex();
				int[] arreglo;
				arreglo = list.getSelectedIndices();
				objetoLista.intercambiar(arreglo[0], arreglo[1]);
				list.setModel(objetoLista.imprimir());

			}
		});
		btnNewButton_3.setBounds(352, 126, 85, 21);
		contentPane.add(btnNewButton_3);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(540, 80, 142, 265);
		contentPane.add(scrollPane_1);

		JList list_1 = new JList();
		scrollPane_1.setViewportView(list_1);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(709, 76, 136, 269);
		contentPane.add(scrollPane_2);

		JList list_2 = new JList();
		scrollPane_2.setViewportView(list_2);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(865, 80, 145, 265);
		contentPane.add(scrollPane_3);

		JList list_3 = new JList();
		scrollPane_3.setViewportView(list_3);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(295, 429, 129, 200);
		contentPane.add(scrollPane_4);

		JList list_4 = new JList();
		scrollPane_4.setViewportView(list_4);

		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(448, 429, 136, 200);
		contentPane.add(scrollPane_5);

		JList list_5 = new JList();
		scrollPane_5.setViewportView(list_5);

		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(608, 429, 136, 200);
		contentPane.add(scrollPane_6);

		JList list_6 = new JList();
		scrollPane_6.setViewportView(list_6);

		JLabel lblNewLabel = new JLabel("PROYECTO");
		lblNewLabel.setBounds(330, 406, 94, 13);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(754, 429, 142, 200);
		contentPane.add(scrollPane_7);

		JList list_7 = new JList();
		scrollPane_7.setViewportView(list_7);

		ClsComb comb = new ClsComb();

		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// objetoLista.generar1(Integer.parseInt(textField.getText()));
				// objetoLista.generar2(Integer.parseInt(textField.getText()));
				// list_1.setModel(objetoLista.imprimir1());
				// list_2.setModel(objetoLista.imprimir2());
				ClsLista listaA = new ClsLista();
				ClsLista listaB = new ClsLista();
				ClsLista listaC = new ClsLista();

				listaA = comb.llena(listaA, Integer.parseInt(textField.getText()));
				list_1.setModel(listaA.imprimir());

				listaB = comb.llena(listaB, Integer.parseInt(textField.getText()));
				list_2.setModel(listaB.imprimir());

				listaC = comb.combina(listaA, listaB, listaC, Integer.parseInt(textField.getText()));
				list_3.setModel(listaC.imprimir());
			}
		});

		textField_1 = new JTextField();
		textField_1.setBounds(415, 643, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		btnNewButton_4.setBounds(568, 360, 85, 21);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("genera");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClsLista listaA = new ClsLista();
				ClsLista listaB = new ClsLista();
				ClsLista milistaC = new ClsLista();
				ClsLista milistaCo = new ClsLista();
				Integer cantidad = Integer.parseInt(textField_1.getText());
				listaA = comb.llena(listaA, cantidad);
				list_4.setModel(listaA.imprimir());

				listaB = comb.llena(listaB, cantidad);
				list_5.setModel(listaB.imprimir());

				milistaC = comb.concatena(listaA, listaB, milistaC, cantidad);
				list_6.setModel(milistaC.imprimir());

				milistaCo = comb.ordenachafa1(milistaCo, milistaC, cantidad);
				list_7.setModel(milistaCo.imprimir());
			}
		});
		btnNewButton_5.setBounds(320, 642, 85, 21);
		contentPane.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("ordena");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnNewButton_6.setBounds(776, 639, 85, 21);
		contentPane.add(btnNewButton_6);

	}
}
