package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

public class EconomiaJP extends JPanel {
	private JTable table;
	private JScrollPane scrollPaneFiltrado;
	
	
	/**
	 * Create the panel.
	 */
	public EconomiaJP() {
		setBounds(178, 0, 944, 700);
		setBackground(new Color(31, 33, 36));
		setLayout(null);
		
		JLabel label = new JLabel("Economia");
		label.setBounds(149, 41, 142, 41);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Segoe UI Semibold", Font.BOLD, 30));
		add(label);
		getTable();
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(421, 41, 32, 41);
		add(label_5);
		label_5.setIcon(new ImageIcon(Principal.class.getResource("/img/account.png")));

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
