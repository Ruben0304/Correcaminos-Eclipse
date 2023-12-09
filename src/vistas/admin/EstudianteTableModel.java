package vistas.admin;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import modelos.usuarios.Estudiante;


 
public class EstudianteTableModel extends DefaultTableModel {   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EstudianteTableModel() {    
		// Definir las columnas de la tabla  
		super(new Object[]{"Nombre", "Primer Apellido", "Segundo Apellido", "Carrera"}, 0);  
		}          
	
	
	public EstudianteTableModel(ArrayList<Estudiante> estudiantes){
		String[] columnNames = {
				"Nombre", "Primer Apellido", "Segundo Apellido", "Carrera"};
		this.setColumnIdentifiers(columnNames);
		for (Estudiante e : estudiantes) {
			Object[] newRow = new Object[]{e.getNombre(), e.getPrimer_apellido(),e.getSegundo_apellido(), e.getCarrera()};
			addRow(newRow);
		}
		
	}
		
	// M�todo para agregar un estudiante a la tabla    
	public void agregarEstudiante(String nombre, String primerApellido, String segundoApellido,  String carrera) {  
		// Crear un vector con los datos del estudiante      
		Object[] fila = {nombre, primerApellido, segundoApellido, carrera};      
		// Agregar la fila a la tabla     
		addRow(fila); 
		}       
	
	// M�todo para eliminar un estudiante de la tabla  
	public void eliminarEstudiante(int rowIndex) {    
		// Eliminar la fila de la tabla       
		removeRow(rowIndex);     
		}        
	
	// M�todo para obtener los datos de un estudiante en una fila espec�fica  
	public Object[] obtenerEstudiante(int rowIndex) {       
		Object[] estudiante = new Object[4];        
		for (int i = 0; i < 4; i++) {          
			estudiante[i] = getValueAt(rowIndex, i);   
			} 
		return estudiante;    
			} 
	
	

}