public class Articulo extends Referencia{

	private String Conferencia;
	
	// Constructor de la clase
	public Articulo (String Anio, String Autor, String Conferencia, String Id, String Titulo) {
	
		super(Anio,Autor,Id,Titulo);
		this.Conferencia = Conferencia;
	}
	
	// Funcion que dado una condicion, devuelve true si el reporte la cumple y false 
	// en otros casos
	public boolean cumpleCondicion (Condicion cond) { 
	
		String[] tokensBuscar = cond.stringBuscar();
		boolean v = true;
		
		for (int i = 0; i<tokensBuscar.length-1; i=i+2) {
		
			if (tokensBuscar[i].equals("Anio")) { 
				v = (tokensBuscar[i+1].equals(this.Anio));
			} 
			else if (tokensBuscar[i].equals("Autor")) { 
				v = (tokensBuscar[i+1].equals(this.Autor));
			}
			else if (tokensBuscar[i].equals("Conferencia")) {
				v = (tokensBuscar[i+1].equals(this.Conferencia));
			}
			else if (tokensBuscar[i].equals("Id")) {
				v = (tokensBuscar[i+1].equals(this.Id));
			}
			else if (tokensBuscar[i].equals("Titulo")) {
				v = (tokensBuscar[i+1].equals(this.Titulo));
			} 
			else if (tokensBuscar[i].equals("Tipo")) {
				v = (tokensBuscar[i+1].equals("Articulo"));
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

	// Metodo para  recibir el parametro Conferencia sin violar la etiqueta del mismo
	public String obtenerConferencia () {
		return this.Conferencia;
	}
	
	// Implementacion del procedimiento actualizar ( llama a la clase madre)
	// Dado una campo valor C si this  cumple con el campo se modifican los valores
	public void actualizar (Condicion condicion) {
	
		String [] s = condicion.stringActualizar();
		super.actualizar(condicion);
		
		for (int i=0; i<s.length;i++) {
		
			if (s[i].equalsIgnoreCase("Conferencia")) { 
				this.Conferencia = s[i+1];
			} 
		}
	}
	
}
	
