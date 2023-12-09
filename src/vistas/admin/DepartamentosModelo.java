package vistas.admin;

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

import autenticacion.Auth;
import modelos.usuarios.Admin;
import modelos.usuarios.Persona;
import util.modelos.DepartamentoVerificadorLibrosTableModel;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;


public class DepartamentosModelo extends JPanel {

	private static final long serialVersionUID = 1L;
	
	protected JPanel panelContenedor;
	protected JPanel panelNombreDept;
	protected JTable table;
	protected TableModel tableModel;
	protected JLabel lNombreDepartamento;
	protected JLabel lblCasosPendientes;
	protected JScrollPane scrollPane;
	protected JButton btnConfirmarEntrega;
	protected ImageIcon iDimAux, iMinimizar, iCerrar;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartamentosModel frame = new DepartamentosModel("Econom�a");
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
	public DepartamentosModelo(TableModel modelo) {
		
		FlatLaf.registerCustomDefaultsSource("app.themes");
		FlatMacDarkLaf.setup();
		crearImagenes();
		
		panelContenedor = new JPanel();
		panelContenedor.setBounds(0, 0, 944, 700);;
		add(panelContenedor);
		panelContenedor.setLayout(null);
		
		panelNombreDept = new JPanel();
		panelNombreDept.setBounds(28, 0, 572, 43);
		panelContenedor.add(panelNombreDept);
		panelNombreDept.setLayout(null);
		
		lNombreDepartamento = new JLabel(Auth.getNombreUsuario());
		lNombreDepartamento.setFont(new Font("Segoe UI", Font.BOLD, 23));
		lNombreDepartamento.setBounds(0, 8, 271, 35);
		panelNombreDept.add(lNombreDepartamento);
		
		iDimAux = new ImageIcon(
				iCerrar.getImage()
		        .getScaledInstance(25, 25, Image.SCALE_AREA_AVERAGING)
		    );
		
		iDimAux = new ImageIcon(
				iMinimizar.getImage()
		        .getScaledInstance(21, 21, Image.SCALE_AREA_AVERAGING)
		    );
		
		lblCasosPendientes = new JLabel("Listado de Casos Pendientes");
		lblCasosPendientes.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblCasosPendientes.setBorder(new MatteBorder(0,0,1,0, new Color(0,255,0)));
		lblCasosPendientes.setBounds(28, 77, 840, 30);
		panelContenedor.add(lblCasosPendientes);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 111, 840, 424);
		panelContenedor.add(scrollPane);
		
		table = new JTable();
		this.table.setModel(modelo);
		table.setFont(new Font(FlatRobotoFont.FAMILY,Font.PLAIN,13));
		table.setFocusable(false);
		scrollPane.setViewportView(table);
		
		btnConfirmarEntrega = new JButton("Confirmar entrega");
		btnConfirmarEntrega.setBounds(687, 609, 196, 43);
		btnConfirmarEntrega.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnConfirmarEntrega.setBackground(new Color(72, 189, 133));
		btnConfirmarEntrega.setForeground(Color.WHITE);
		panelContenedor.add(btnConfirmarEntrega);
		
		setBounds(178, 0, 944, 700);
		this.setLayout(null);
	}
	
	private void crearImagenes() {
	    iCerrar = new ImageIcon("./src/img/cerrar_sin_relleno.png");
	    iMinimizar = new ImageIcon("./src/img/min_blanco.png");
	}
}
