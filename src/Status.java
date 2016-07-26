// La Clase Status permite construir los datos que seras escritos en el archivo de salida

public class Status extends Exception {

	//Atributos
	private boolean error;
	public int x = -1;
	private String mensaje;
	private int contador;

    // En caso de AG exitoso "OK"
    // En caso de AG NO exitoso "ERROR"
    // En caso de CO La informacion de las referencias que cumplen la condicion,
    // una por linea y en el formato establecido
    // Si en una Consulta, no se genere ninguna Referencia,
    // el Status se considera como el String vacio
    
    // En caso de AC, el numero de referencias actualizadas por ejemplo
    // 3
	
	// Constructor para el outFile de AG
	public Status (boolean error) {
	
		this.error = error;
		this.x = 0;
	}
	
	// Constructor para el outFile de CO 
	public Status (String mensaje) {
	
		this.mensaje = mensaje;
		this.x = 2;
	}
	
	// Constructor para el outFile AC
	public Status (int contador) {
	
		this.contador = contador;
		this.x = 1;
	}
	
	// Devuelve el String a ser escrito en el archivo de salida de acuerdo al comando
	// y a la operaciones llevadas a cabo
	public String toString() {
   
		String s = "";
		
		if (x == 0) {
			if (this.error) 
			{
			s = "Error";
			} else {
			s = "Ok";
			}	
		}
		else if (x == 1) {
			s = Integer.toString(this.contador);
		}
		else if (x == 2) {
			s = this.mensaje;
		}
		return s;
    }
}
