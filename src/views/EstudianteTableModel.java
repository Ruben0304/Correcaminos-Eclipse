package views;
import javax.swing.table.DefaultTableModel; 


 
public class EstudianteTableModel extends DefaultTableModel {   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EstudianteTableModel() {    
		// Definir las columnas de la tabla  
		super(new Object[]{"Nombre", "Primer Apellido", "Segundo Apellido", "Facultad"}, 0);  
		}          
	
	
	public EstudianteTableModel(Estudiante [] estudiantes){
		String[] columnNames = {
				"No. Cliente", "Nombre", "Direcci\u00F3n", "Tel\u00E9fono"};
		this.setColumnIdentifiers(columnNames);
		for (int i = 0; i < estudiantes.length; i++) {
			Object[] newRow = new Object[]{estudiantes[i].getNombre(), estudiantes[i].getPrimer_apellido(), estudiantes[i].getSegundo_apellido(), estudiantes[i].getFacultad()};
			addRow(newRow);
		}
	}
		
	// Método para agregar un estudiante a la tabla    
	public void agregarEstudiante(String nombre, String primerApellido, String segundoApellido, String facultad) {  
		// Crear un vector con los datos del estudiante      
		Object[] fila = {nombre, primerApellido, segundoApellido, facultad};      
		// Agregar la fila a la tabla     
		addRow(fila); 
		}       
	
	// Método para eliminar un estudiante de la tabla  
	public void eliminarEstudiante(int rowIndex) {    
		// Eliminar la fila de la tabla       
		removeRow(rowIndex);     
		}        
	
	// Método para obtener los datos de un estudiante en una fila específica  
	public Object[] obtenerEstudiante(int rowIndex) {       
		Object[] estudiante = new Object[4];        
		for (int i = 0; i < 4; i++) {          
			estudiante[i] = getValueAt(rowIndex, i);   
			} 
		return estudiante;    
			} 
	
	

}