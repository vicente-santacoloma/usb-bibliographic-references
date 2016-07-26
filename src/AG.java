// Clase mediante la cual se agregara al catalogo la referencia asociada
public class AG extends Comando {
	
	// Atributos de la clase AG
	private String [] tokensAux;
	private Catalogo catalogo;
	private String Anio;
	private String Autor;
	private String Carrera;
	private String Conferencia;
	private String Editor;
	private String Id;
	private String Institucion;
	private String Libro;
	private String Paginas;
	private String Tipo;
	private String Titulo;
	private String Tutor;
	private String Url;

	// Constructor de la clase AG
	public AG (Condicion condicion , Catalogo catalogo) {
	
		this.tokensAux = condicion.stringBuscar ();
		this.catalogo = catalogo;
		obtenerInfo();

	}
	
	// Ejecuta el procedimiento de agregarcatalogo de la clase Catalogo
	public void ejecutar (Catalogo catalog) throws Status {
       
	   catalog.agregarCatalogo(this);

    }

	// Asigna a los atributos de la presente clase los valores de la referencia 
	// asociada
	private void obtenerInfo () {
	
		for (int i=0; i<this.tokensAux.length-1; i=i+2) {
	
			if (tokensAux[i].equals("Anio")) {
			Anio = tokensAux[i+1];
			}
			else if (tokensAux[i].equals("Autor")) {
			Autor = tokensAux[i+1];
			}
			else if (tokensAux[i].equals("Carrera")) {
			Carrera = tokensAux[i+1];
			}
			else if (tokensAux[i].equals("Conferencia")) {
			Conferencia = tokensAux[i+1];
			}
			else if (tokensAux[i].equals("Editor")) {
			Editor = tokensAux[i+1];
			}
			else if (tokensAux[i].equals("Id")) {
			Id = tokensAux[i+1];
			}
			else if (tokensAux[i].equals("Institucion")) {
			Institucion = tokensAux[i+1];
			}
			else if (tokensAux[i].equals("Libro")) {
			Libro = tokensAux[i+1];
			}
			else if (tokensAux[i].equals("Paginas")) {
			Paginas = tokensAux[i+1];
			}	
			else if (tokensAux[i].equals("Tipo")) {
			Tipo = tokensAux[i+1];
			}
			else if (tokensAux[i].equals("Titulo")) {
			Titulo = tokensAux[i+1];
			}
			else if (tokensAux[i].equals("Tutor")) {
			Tutor = tokensAux[i+1];
			}
			else if (tokensAux[i].equals("Url")) {
			Url = tokensAux[i+1];
			}
		}
	}
	
	// Devuelve la referencia asociada que sera agregada al catalogo 
	public Referencia crearReferencia () {
	
		Referencia ref = null;
		
		if (Tipo.equals("Articulo")) {
		ref = new Articulo (Anio, Autor, Conferencia, Id, Titulo);
		}
		else if (Tipo.equals("Capitulo")) {
		ref = new Capitulo (Anio, Autor, Editor, Id, Institucion, Libro, Paginas, Titulo);
		}
		else if (Tipo.equals("Manual")) {
		ref = new Manual (Anio, Autor, Id, Titulo);
		}
		else if (Tipo.equals("Libro")) {
		ref = new Libro (Anio, Autor, Editor, Id, Institucion, Titulo);
		}
		else if (Tipo.equals("Reporte")) {
		ref = new Reporte (Anio, Autor, Id, Titulo);
		}
		else if (Tipo.equals("Tesis")) {
		ref = new Tesis (Anio, Autor, Carrera, Id, Institucion, Titulo, Tutor);
		}
		else if (Tipo.equals("Web")) {
		ref = new Web (Anio, Autor, Id, Titulo, Url);
		}
		return ref;
	}
}