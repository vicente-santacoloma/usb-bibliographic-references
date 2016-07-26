// El catalogo debe almacenar las referecias conservando el orden
// en que fueron insertadas

// Al devolver la información de un sub conjunto de referencias
// se debe devolver en el mismo orden en que estan almacenadas.

public class Catalogo {

    // Puede asumir que no se manejaran mas de maxRefes referencias.
    private final int maxRefes = 10000;

    // Aqui debe almacenar las referencias del catalogo
    private Referencia refes[] ;
	
	// Entero que almacena la cantidad de objetos relevantes dentro del catalogo
	private int tam = 0;
	
	//Constructor que inicaliza el arreglo de referencias refes en el tamaño maximo maxRefes
    public Catalogo()  {
        refes = new Referencia[maxRefes];
    }
	
	// Procedimiento que recibe un comando C lo ejecuta y arroja su Status
    public Status ejecutar (Comando c) {
	
		try {
		c.ejecutar(this);
		} catch (Status s) {
			return s;
		}
		Status s = null;
		return s;
    }
	
	// Procedimiento para obtener el parametro tamaño sin violar la etiqueta private
	public int obtenerTam () {
	
		return this.tam;
	}
	
	// Procedimiento para obtener el parametro refes sin violar la etiqueta private
	public Referencia [] obtenerReferencia() {
	
		return this.refes;
	}
	
	// Funcion que recibe un ID y arroja true si existe una referencia dentro del catalogo
	// tal que, su id es igual al inicial  y falso si para todas las refencias dentro del
	// catalogo el id  es  diferente del inicial
	public boolean buscarId (String Id) {
	
		boolean v = false ;
	
		for(int i=0 ;i<this.tam;i++){
		
			if (refes[i].obtenerId().equals(Id)) {
				v = true;
				i = tam;
			}
		}	
		return v;
	}

	// Procedimiento que ejecuta el comando AG  y arroja un Status
	public void agregarCatalogo (AG c) throws Status {
	
		Referencia r = c.crearReferencia();
		boolean v = buscarId(r.obtenerId());
		
		if (v || tam > 10000) {
			throw new Status(true);
		}
		else if (!v) {
			refes[tam] = r;
			this.tam++;
			throw new Status(false);
		}
	}
	
	// Procedimiento que ejecuta el comando CO  y arroja un Status
	public void consultarCatalogo (CO c) throws Status {
	
		Referencia [] r = c.consultarReferencia ();
		String s = "";
		boolean v = true;
		
		for (int i=0; i<r.length; i++) {
		
			if (v) {
				s = escritorCatalogo(r[i]);
				v = false;
			}
			else if (!v) {
				s = s+"\r\n"+escritorCatalogo(r[i]);		
			}
		}
		
		throw new Status(s);
	}
	
	// Procedimiento que ejecuta el comando AC y arroja un Status
	public void actualizarCatalogo (AC c) throws Status {
	
		int [] r = c.actualizarReferencia();
		Condicion cond = c.obtenerCondicion();
		
		for (int i=0; i<r.length; i++) {
			this.refes[r[i]].actualizar(cond);
		}
		throw new Status(r.length);
	}
	
	// Procedimiento que dado una referencia convierte a esta y a sus parametros en un String
	// que contiene toda la informacion ordenada en orden alfabetico de la referencia de entrada
	private String escritorCatalogo (Referencia r) {
	
		String E = "";
		if (r instanceof Articulo) {
			String A = "{"+"Anio = \""+r.obtenerAnio()+"\", Autor = \""+r.obtenerAutor();
			String B = A+"\", Conferencia = \""+((Articulo)r).obtenerConferencia()+"\", Id = \"";
			String C = B+r.obtenerId()+"\", Tipo = \"Articulo\", Titulo = \""+r.obtenerTitulo()+"\"}";
			E = C;
		} 
		else if (r instanceof Capitulo) {
			String A = "{"+"Anio = \""+r.obtenerAnio()+"\", Autor = \""+r.obtenerAutor();
			String B = A+"\", Id = \""+r.obtenerId()+"\", Libro = \""+((Capitulo)r).obtenerLibro();
			String C = B+"\", Paginas = \""+((Capitulo)r).obtenerPaginas()+"\", Tipo = \"Capitulo\"";
			String D = C+", Titulo = \""+r.obtenerTitulo()+"\"}";
			E = D;
		}
		else if (r instanceof Libro) {
			String A = "{"+"Anio = \""+r.obtenerAnio()+"\", Autor = \""+r.obtenerAutor();
			String B = A+"\", Editor = \""+((Libro)r).obtenerEditor()+"\", Id = \"";
			String C = B+r.obtenerId()+"\", Institucion = \""+((Libro)r).obtenerInstitucion();
			String D = C+"\", Tipo = \"Libro\", Titulo = \""+r.obtenerTitulo()+"\"}";
			E = D;
		}
		else if (r instanceof Tesis) {
			String A = "{"+"Anio = \""+r.obtenerAnio()+"\", Autor = \""+r.obtenerAutor();
			String B = A+"\", Id = \""+r.obtenerId()+"\", Intitucion = \"";
			String C = B+((Libro)r).obtenerInstitucion()+"\", Titulo = \""+r.obtenerTitulo();
			String D = C+"\", Tipo = \"Tesis\", Tutor = \""+((Libro)r).obtenerEditor()+"\"}";
			E = D;
		}
		else if (r instanceof Manual) {
			String A = "{"+"Anio = \""+r.obtenerAnio()+"\", Autor = \""+r.obtenerAutor();
			String B = A+"\", Id = \""+r.obtenerId()+"\", Tipo = \"Manual\"";
			String C = B+", Titulo = \""+r.obtenerTitulo()+"\"}";
			E = C;
		}
		else if (r instanceof Reporte) {
			String A = "{"+"Anio = \""+r.obtenerAnio()+"\", Autor = \""+r.obtenerAutor();
			String B = A+"\", Id = \""+r.obtenerId()+"\", Tipo = \"Reporte\"";
			String C = B+", Titulo = \""+r.obtenerTitulo()+"\"}";
			E = C;
		}
		else if (r instanceof Web) {
			String A = "{"+"Anio = \""+r.obtenerAnio()+"\", Autor = \""+r.obtenerAutor();
			String B = A+"\", Id = \""+r.obtenerId()+"\", Tipo = \"Web\"" ;
			String C = B+", Titulo = \""+r.obtenerTitulo()+"\", Url = \""+((Web)r).obtenerUrl()+"\"}";
			E = C;
		}
		
		return E;
	}
}
