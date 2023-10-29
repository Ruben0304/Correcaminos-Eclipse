package vistas.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelos.entidades.Persona;

import javax.swing.JTable;
import javax.swing.JButton;

public class Secretaria_Rhumanos2 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton button;
	private JButton button_1;
    private Object[][] data;

	public Secretaria_Rhumanos2(final ArrayList<Persona> usuariosPendientes) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 868, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTable());
		contentPane.add(getButton());
		contentPane.add(getButton_1());

		data = new Object[usuariosPendientes.size()][3];
        int i = 0;
        for (Persona p : usuariosPendientes) {
            data[i][0] = p.getCi();
            data[i][1] = p.getNombre();
            data[i][2] = p.getApellidos();
            i++;
        }
	}
	

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(
                data,
                new String[] {
                        "Carnet", "Nombre", "Apellidos"
                }));
			table.setBounds(12, 13, 826, 476);
		}
		return table;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("Ir a login");
			button.setBounds(504, 497, 97, 25);
		}
		return button;
	}
	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("Confirmar Entrega");
			button_1.setBounds(636, 497, 137, 25);
		}
		return button_1;
	}
}
