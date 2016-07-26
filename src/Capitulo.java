// Clase Capitulo hereda de Libro
public class Capitulo extends Libro{

	// Atributos
	private  String Paginas, Libro;
	
	// Constructor de la clase
	public Capitulo (String Anio, String Autor, String Editor, String Id, String Institucion, String Libro, String Paginas, String Titulo) {
	
		super(Anio,Autor,Editor,Id,Institucion,Titulo);
		this.Libro = Libro;
		this.Paginas = Paginas;
	}
	
	// Funcion que dado una condicion, devuelve true si el reporte la cumple y false 
	// en otros casos
	public boolean cumpleCondicion (Condicion cond) { 
	
		String [] tokensBuscar = cond.stringBuscar();
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
			else if (tokensBuscar[i].equals("Id")) {
				v = (tokensBuscar[i+1].equals(this.Id));
			}
			else if (tokensBuscar[i].equals("Institucion")) {
				v = (tokensBuscar[i+1].equals(this.Institucion));
			} 
			else if (tokensBuscar[i].equals("Libro")) {
				v = (tokensBuscar[i+1].equals(this.Libro));
			}
			else if (tokensBuscar[i].equals("Paginas")) {
				v = (tokensBuscar[i+1].equals(this.Paginas));
			}
			else if (tokensBuscar[i].equals("Titulo")) {
				v = (tokensBuscar[i+1].equals(this.Titulo));
			}
			else if (tokensBuscar[i].equals("Tipo")) {
				v = (tokensBuscar[i+1].equals("Capitulo"));
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

	// Metodo para  recibir el parametro Paginas sin violar la etiqueta del mismo
	public String obtenerPaginas(){
		return this.Paginas;
	}
		
	// Metodo para  recibir el parametro Libro sin violar la etiqueta del mismo
	public String obtenerLibro(){
		return this.Libro;
	}
	
	// Implementacion del procedimiento actualizar ( llama a la clase madre)
	// Dado una campo valor C si this  cumple con el campo se modifican los valores	
	public void actualizar (Condicion condicion) {
	
		String [] s = condicion.stringActualizar();
		super.actualizar(condicion);
		
		for (int i=0; i<s.length;i++) {
		
			if (s[i].equalsIgnoreCase("Paginas")) { 
				this.Paginas = s[i+1];
			} 
			else if (s[i].equalsIgnoreCase("Libro")) { 
				this.Libro = s[i+1];
			}
		}
	}
		
}