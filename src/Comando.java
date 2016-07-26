// Clase abstracta a partir de la cual se instancian los comandos AG, CO, AC
abstract public class Comando {

	abstract public void ejecutar (Catalogo catalog) throws Status;
	
}
