// Clase Tesis hereda de Libro
public class Tesis extends Libro {

	private String Carrera;
	
	// Constructor de la clase
	public Tesis (String Anio, String Autor, String Carrera, String Id, String Institucion, String Titulo, String Tutor) {
	
		super(Anio, Autor, Tutor, Id, Institucion, Titulo);
		this.Carrera = Carrera;
	}
	
	// Funcion que dado una condicion, devuelve true si el reporte la cumple y false 
	// en otros casos
	public boolean cumpleCondicion (Condicion cond) { 
	
		String[]  tokensBuscar = cond.stringBuscar();
		boolean v = true;
		
		for (int i = 0; i<tokensBuscar.length-1; i=i+2) {
		
			if (tokensBuscar[i].equals("Anio")) { 
				v = (tokensBuscar[i+1].equals(this.Anio));
			} 
			else if (tokensBuscar[i].equals("Autor")) { 
				v = (tokensBuscar[i+1].equals(this.Autor));
			}
			else if (tokensBuscar[i].equals("Carrera")) {
				v = (tokensBuscar[i+1].equals(this.Carrera));
			}
			else if (tokensBuscar[i].equals("Id")) {
				v = (tokensBuscar[i+1].equals(this.Id));
			}
			else if (tokensBuscar[i].equals("Institucion")) {
				v = (tokensBuscar[i+1].equals(this.Institucion));
			} 
			else if (tokensBuscar[i].equals("Titulo")) {
				v = (tokensBuscar[i+1].equals(this.Titulo));
			}
			else if (tokensBuscar[i].equals("Tutor")) {
				v = (tokensBuscar[i+1].equals(this.Editor));
			}
			else if (tokensBuscar[i].equals("Tipo")) {
				v = (tokensBuscar[i+1].equals("Tesis"));
			}
			else { 
				v = false; 
			}
			
			if 	(!v) { 
				i = tokensBuscar.length-1;
			}
		}
		return v;
	}
	// Metodo para  recibir el parametro Carrera sin violar la etiqueta del mismo
	public String obtenerCarrera () {
		return this.Carrera;
	}
	// Implementacion del procedimiento actualizar ( llama a la clase madre)
	// Dado una campo valor C si this  cumple con el campo se modifican los valores
	public void actualizar (Condicion condicion) {
	
		String [] s = condicion.stringActualizar();
		super.actualizar(condicion);
		
		for (int i=0; i<s.length;i++) {
		
			if (s[i].equalsIgnoreCase("Carrera")) { 
				this.Carrera = s[i+1];
			} 
			else if (s[i].equalsIgnoreCase("Tutor")) { 
				this.Editor = s[i+1];
			}
		}
	}
}