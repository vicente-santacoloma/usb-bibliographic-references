// La clase libro hereda de refencia contiene informacion del tipo
// String almacenando Año, Autor, Editor, Id, Institucion, Titulo
public class Libro extends Referencia

{
	// Atributos
	protected String Editor, Institucion;
	
	// Constructor de la clase
	public Libro (String Anio, String Autor, String Editor, String Id, String Institucion, String Titulo) {

		super(Anio, Autor, Id, Titulo); 
		this.Editor = Editor;
		this.Institucion = Institucion;
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
			else if (tokensBuscar[i].equals("Editor")) { 
				v = (tokensBuscar[i+1].equals(this.Editor));
			}
			else if (tokensBuscar[i].equals("Institucion")) { 
				v = (tokensBuscar[i+1].equals(this.Institucion));
			}
			else if (tokensBuscar[i].equals("Id")) {
				v = (tokensBuscar[i+1].equals(this.Id));
			}
			else if (tokensBuscar[i].equals("Titulo")) {
				v = (tokensBuscar[i+1].equals(this.Titulo));
			}
			else if (tokensBuscar[i].equals("Tipo")) {
				v = (tokensBuscar[i+1].equals("Libro"));
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
	
	// Metodo para  recibir el parametro Editor sin violar la etiqueta del mismo
	public String obtenerEditor () {
		return this.Editor;
	}
	
	// Metodo para  recibir el parametro Institucion sin violar la etiqueta del mismo
	public String obtenerInstitucion () {
		return this.Institucion;
	}	
	
	// Implementacion del procedimiento actualizar ( llama a la clase madre)
	// Dado una campo valor C si this  cumple con el campo se modifican los valores
	public void actualizar (Condicion condicion) {
	
		String [] s = condicion.stringActualizar();
		super.actualizar(condicion);
		
		for (int i=0; i<s.length;i++) {
		
			if (s[i].equalsIgnoreCase("Editor")) { 
				this.Editor = s[i+1];
			} 
			else if (s[i].equalsIgnoreCase("Institucion")) { 
				this.Institucion = s[i+1];
			}
		}
	}
	
	
}