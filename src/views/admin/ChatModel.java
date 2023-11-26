package views.admin;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel; 

import models.usuarios.Estudiante;
import models.usuarios.Persona;


 
public class ChatModel extends DefaultTableModel {   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 
	
	
	public ChatModel(ArrayList<Persona> personas){
		String[] columnNames = {
				"Nombre", "DNI"};
		this.setColumnIdentifiers(columnNames);
		for (Persona p : personas) {
			Object[] newRow = new Object[]{p.getNombre(), p.getCi()};
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