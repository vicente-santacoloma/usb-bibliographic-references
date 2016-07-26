// La clase abstracta referencia es el objeto funcional del Catalogo
// Esta diseñada para generar caracteristicas comunes entre referencias especializadas
public abstract class Referencia {
	
	//Atributos de la clase , modificables solo por los "herederos"
	protected String Anio, Autor, Editor, Id, Titulo;
	
	// Constructor que dado una serie de parametros pasa los valores a los atriibutos de this
	protected Referencia (String Anio, String Autor, String Id, String Titulo) {
	
	this.Anio = Anio;
	this.Autor = Autor;
	this.Id = Id;
	this.Titulo = Titulo;
	}
	
	// Metodo abstracto que , dependiendo de el heredero de referencia , expresara si el mismo 
	// Cumple con una condicion dada
	public abstract boolean cumpleCondicion(Condicion cond);
	
	//Metodo para obtener el parametro anio
	public String obtenerAnio () {
		return this.Anio;
	}
	
	//Metodo para obtener el parametro autor
	public String obtenerAutor () {
		return this.Autor;
	}
	
	//Metodo para obtener el parametro id
	public String obtenerId () {
		return this.Id;
	}
	
	//Metodo para obtener el parametro a titulo
	public String obtenerTitulo() {
		return this.Titulo;
	}

	// Dada una condicion Condicion y una referencia (this),
	// el metodo actualizar itera sobre el string que contiene condicion
	// y actualiza las referencias que posean campos similares a los de condicion.
	public void actualizar (Condicion condicion) {
	
		String [] s = condicion.stringActualizar();
		
		for (int i=0; i<s.length;i++) {
		
			if (s[i].equalsIgnoreCase("Anio")) { 
				this.Anio = s[i+1];
			} 
			else if (s[i].equalsIgnoreCase("Autor")) { 
				this.Autor = s[i+1];
			}

			else if (s[i].equalsIgnoreCase("Id")) {
				this.Id = s[i+1];
			}
			else if (s[i].equalsIgnoreCase("Titulo")) {
				this.Titulo = s[i+1];
			}
		}
	}	
	
}
