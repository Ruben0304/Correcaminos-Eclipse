package interfaz_grafica;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.table.TableModel;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;


public class DepartamentosModel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	protected JPanel panelContenedor;
	protected JPanel panelNombreDept;
	protected JTable table;
	protected TableModel tableModel;
	protected JLabel lNombreDepartamento;
	protected JButton btnCerrar;
	protected JButton btnMinimizar;
	protected JMenuBar menuBar;
	protected JMenuItem mntmCerrarSesin;
	protected JLabel lblCasosPendientes;
	protected JScrollPane scrollPane;
	protected JButton btnConfirmarEntrega;
	protected ImageIcon iDimAux, iMinimizar, iCerrar;
	protected JMenu mnNewMenu;
	protected JMenu mnReportes;
	protected JMenuItem mntmVerReportes;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartamentosModel frame = new DepartamentosModel("Economía");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the panel.
	 */
	public DepartamentosModel(String nombreDept) {
		
		FlatLaf.registerCustomDefaultsSource("app.themes");
		FlatMacDarkLaf.setup();
		crearImagenes();
		
		panelContenedor = new JPanel();
		panelContenedor.setBounds(0, 0, 600, 400);
		add(panelContenedor);
		panelContenedor.setLayout(null);
		
		panelNombreDept = new JPanel();
		panelNombreDept.setBounds(0, 0, 600, 27);
		panelContenedor.add(panelNombreDept);
		panelNombreDept.setLayout(null);
		
		lNombreDepartamento = new JLabel(nombreDept);
		lNombreDepartamento.setFont(new Font(FlatRobotoFont.FAMILY,Font.PLAIN,17));
		lNombreDepartamento.setBounds(10, 8, 185, 14);
		panelNombreDept.add(lNombreDepartamento);
		
		iDimAux = new ImageIcon(
				iCerrar.getImage()
		        .getScaledInstance(25, 25, Image.SCALE_AREA_AVERAGING)
		    );
		btnCerrar = new JButton("");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnCerrar.setBounds(551, -1, 52, 28);
		btnCerrar.setFocusable(false);
		btnCerrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCerrar.setIcon(iDimAux);
		btnCerrar.setContentAreaFilled(false);
		panelNombreDept.add(btnCerrar);
		
		iDimAux = new ImageIcon(
				iMinimizar.getImage()
		        .getScaledInstance(21, 21, Image.SCALE_AREA_AVERAGING)
		    );
		btnMinimizar = new JButton("");
		btnMinimizar.setBounds(538, 0, 33, 27);
		btnMinimizar.setFocusable(false);
		btnMinimizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnMinimizar.setIcon(iDimAux);
		btnMinimizar.setContentAreaFilled(false);
		panelNombreDept.add(btnMinimizar);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 27, 600, 21);
		panelContenedor.add(menuBar);
		
		mnNewMenu = new JMenu("Opciones");
		menuBar.add(mnNewMenu);
		
		mntmCerrarSesin = new JMenuItem("Cerrar sesi\u00F3n");
		mntmCerrarSesin.setHorizontalTextPosition(SwingConstants.LEFT);
		mntmCerrarSesin.setHorizontalAlignment(SwingConstants.LEFT);
		mntmCerrarSesin.setFont(new Font(FlatRobotoFont.FAMILY,Font.PLAIN,13));
		mnNewMenu.add(mntmCerrarSesin);
		
		mnReportes = new JMenu("Reportes");
		mnReportes.setVisible(false);
		menuBar.add(mnReportes);
		
		mntmVerReportes = new JMenuItem("Ver Reportes");
		mnReportes.add(mntmVerReportes);
		
		lblCasosPendientes = new JLabel("Listado de Casos Pendientes");
		lblCasosPendientes.setFont(new Font(FlatRobotoFont.FAMILY,Font.PLAIN,17));
		lblCasosPendientes.setBorder(new MatteBorder(0,0,1,0, new Color(0,255,0)));
		lblCasosPendientes.setBounds(28, 77, 537, 30);
		panelContenedor.add(lblCasosPendientes);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 111, 537, 228);
		panelContenedor.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font(FlatRobotoFont.FAMILY,Font.PLAIN,13));
		table.setFocusable(false);
		scrollPane.setViewportView(table);
		
		btnConfirmarEntrega = new JButton("Confirmar entrega");
		btnConfirmarEntrega.setBounds(388, 350, 177, 23);
		btnConfirmarEntrega.setFont(new Font(FlatRobotoFont.FAMILY,Font.PLAIN,14));
		btnConfirmarEntrega.setBackground(new Color(72, 189, 133));
		btnConfirmarEntrega.setForeground(Color.BLACK);
		panelContenedor.add(btnConfirmarEntrega);
		
		setBounds(0, 0, 600, 400);
		this.setLayout(null);
	}
	
	private void crearImagenes() {
	    iCerrar = new ImageIcon("./src/img/cerrar_sin_relleno.png");
	    iMinimizar = new ImageIcon("./src/img/min_blanco.png");
	}
}
