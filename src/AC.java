// Clase mediante la cual se actualizar una determinada
// informacion en las referencias del catalogo
public class AC extends Comando{

	// Atributos de la clase AC
	private Condicion condicion;
	private Catalogo catalogo;
	
	// Constructor de la clase AC
	public AC (Condicion condicion, Catalogo catalogo) {
	
		this.condicion = condicion;
		this.catalogo = catalogo;
	
	}

	// Ejecuta el procedimiento de actualizarcatalogo de la clase Catalogo
	public void ejecutar (Catalogo catalog) throws Status {
       
		catalog.actualizarCatalogo(this);

    }
	
	// Devuelve el atributo condicion
	public Condicion obtenerCondicion () {
	
		return this.condicion;
	
	}
	
	// Devuelve un arreglo de enteros donde en cada csilla estara la posicion
	//de las referencia a actualizar
	public int [] actualizarReferencia () {
	
		Condicion cond = new Condicion (this.condicion.stringBuscar());
		Referencia [] refes = catalogo.obtenerReferencia(); 
		int [] s = new int [catalogo.obtenerTam()];
		int k = 0;
		
		for (int i=0; i<catalogo.obtenerTam(); i++) {
		
			if (refes[i].cumpleCondicion(cond)) {
				s[k] = i;
				k++;
			}
		}
		
		int [] a = new int [k];
		for (int i = 0 ; i< k ; i++) {
			a[i] = s[i];
		}
		
		return a;
	}
}