import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class Formita extends JFrame {

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
					Formita frame = new Formita();
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
	public Formita() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1128, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(90, 76, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(279, 77, 187, 296);
		contentPane.add(scrollPane);

		JList list = new JList();
		scrollPane.setViewportView(list);

		JLabel lblNewLabel = new JLabel("tope");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(393, 455, 108, 56);
		contentPane.add(lblNewLabel);

		ClsPila pila = new ClsPila();

		JButton btnNewButton = new JButton("Push");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pila.push(Integer.parseInt(textField.getText()));
				pila.Lista.fininicio();
				list.setModel(pila.Lista.modelofin);
			}
		});
		btnNewButton.setBounds(279, 390, 85, 21);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Pop");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pila.pop();
				pila.Lista.fininicio();
				list.setModel(pila.Lista.modelofin);
			}
		});
		btnNewButton_1.setBounds(279, 432, 85, 21);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Tope");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText(Integer.toString(pila.tope()));
			}
		});
		btnNewButton_2.setBounds(279, 475, 85, 21);
		contentPane.add(btnNewButton_2);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(751, 76, 139, 420);
		contentPane.add(scrollPane_1);

		JList list_1 = new JList();
		scrollPane_1.setViewportView(list_1);

		textField_1 = new JTextField();
		textField_1.setBounds(716, 519, 187, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		Clstarea objtarea = new Clstarea();

		JButton btnNewButton_3 = new JButton("push ecuacion");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					objtarea.Lista.limpiar();
					objtarea.acomodar(textField_1.getText());
					objtarea.Lista.fininicio();
					list_1.setModel(objtarea.Lista.modelofin);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "debe terminar en simbolo jeje sorry");
				}

			}
		});
		btnNewButton_3.setBounds(767, 560, 136, 21);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("pop jeje");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					objtarea.pop();
					objtarea.Lista.fininicio();
					list_1.setModel(objtarea.Lista.modelofin);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "exactamente que intentas borrar?");
				}
			}
		});
		btnNewButton_4.setBounds(767, 599, 136, 21);
		contentPane.add(btnNewButton_4);

	}
}
