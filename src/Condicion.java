// Clase que maneja los arreglos de string que contendran la informacion
// de busqueda y actualizacion 
public class Condicion {

	// Atributos de la clase
	private String [] buscar;
	private String [] actualizar;

	// Constructor para los comando AG y CO
	public Condicion (String [] buscar) {
	
		this.buscar = buscar;
	}
	
	// Constructor para el comando AC
	public Condicion (String [] buscar, String [] actualizar) {
	
		this.buscar = buscar;
		this.actualizar = actualizar;
	}
	
	// Devuelve el arreglo con la informacion de buscar
	public String [] stringBuscar () {
	
		return this.buscar;
	}
	
	// Devuelve el arreglo con la informacion de actualizar
	public String [] stringActualizar () {
	
		return this.actualizar;
	}
	
}
