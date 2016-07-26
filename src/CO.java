// Clase mediante la cual se consultara una determinada 
// informacion en las referencias del catalogo
public class CO extends Comando {

	// Atributos de la clase CO
	private Condicion condicion;
	private Catalogo catalogo;

	// Constructor de la clase CO
	public CO (Condicion condicion, Catalogo catalogo) {
	
		this.condicion = condicion;
		this.catalogo = catalogo;

	}
	
	// Ejecuta el procedimiento de consultarcatalogo de la clase Catalogo
	public void ejecutar (Catalogo catalog) throws Status {
	
		catalog.consultarCatalogo(this);

    }
	
	// Devuelve un arreglo con las referencias que seran consultadas 
	public Referencia [] consultarReferencia () {
	
		Referencia [] consultar = new Referencia [catalogo.obtenerTam()];
		Referencia [] refes = catalogo.obtenerReferencia(); 
		int k = 0;
		
		for (int i=0; i<catalogo.obtenerTam(); i++) {
		
			if (refes[i].cumpleCondicion(condicion)) {
				consultar[k] = refes[i];
				k++;
			}
		}
		
		Referencia [] Fin = new Referencia[k];
		for (int i = 0 ; i< k ; i++) {
			Fin[i] = consultar[i];
		}
		
		return Fin;
	}
	
}
	
