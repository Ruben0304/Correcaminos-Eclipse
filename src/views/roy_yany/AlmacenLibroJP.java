package views.roy_yany;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class AlmacenLibroJP extends JPanel {
	private JTable table;
	private JScrollPane scrollPaneFiltrado;
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	public AlmacenLibroJP() {
		setBounds(178, 0, 944, 700);
		setBackground(new Color(31, 33, 36));
		setLayout(null);
		
		JLabel label = new JLabel("Almacen de Libros");
		label.setBounds(149, 41, 252, 41);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		add(label);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(421, 41, 32, 41);
		add(label_5);
		label_5.setIcon(new ImageIcon(Principal.class.getResource("/img/libro.png")));
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(Color.WHITE));
		panel.setBackground(new Color(31, 33, 36));
		panel.setBounds(23, 106, 719, 528);
		add(panel);
		
		table_1 = new JTable();
		table_1.setForeground(Color.WHITE);
		table_1.setFont(new Font("Arial Narrow", Font.BOLD, 16));
		table_1.setBackground(new Color(31, 33, 36));
		table_1.setBounds(10, 11, 663, 483);
		panel.add(table_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 499, 698, 18);
		panel.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(683, 11, 25, 483);
		panel.add(scrollPane_1);
		
	}
	public JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			table.setBorder(null);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			// scrollPane.setViewportView(table);

			//table.setModel(new PendientesEstudiantes(ControladorFiltrado.obtenerSolicitudesBajaEstudiantesFiltradas(getMap()), 8));

			table.setBounds(112, 33, 587, 476);
			table.setBackground(new Color(31, 33, 36));
			table.setRowHeight(50);
			table.setGridColor(new Color(31, 33, 36));
			table.setForeground(Color.WHITE);
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment(JLabel.CENTER);

			// table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
			// table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
			// table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
			// table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

		}
		return table;
	}
	
	private JScrollPane getScrollPaneFiltrado() {
		if (scrollPaneFiltrado == null) {
			scrollPaneFiltrado = new JScrollPane();
			scrollPaneFiltrado.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
			scrollPaneFiltrado.setOpaque(false);
			scrollPaneFiltrado.setBackground(new Color(40, 42, 46));
			scrollPaneFiltrado.setBounds(0, 100, 590, 574);
			scrollPaneFiltrado.setAutoscrolls(true);
			scrollPaneFiltrado.getViewport().setBackground(new Color(40, 42, 46));
			scrollPaneFiltrado.setViewportView(getTable());
		}
		return scrollPaneFiltrado;
	}
}
