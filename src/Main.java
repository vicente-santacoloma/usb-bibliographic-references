import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.File;
import java.util.*;

//Integrantes: Andreth Salazar
//             Vicente Santacoloma

// Clase Principal
public class Main {

    private String inFile;
    private String outFile;
    private Catalogo catalog;

    public Main(String inF, String outF) {
        catalog = new Catalogo();
        inFile = inF;
        outFile = outF;
    }

	//LLeva a cabo los procedimiento de lectura del archivo de 
	//entrada, procesamiento de la informacion alli contenida
	//y	su posterior escritura en el archivo de salida
	private int procesar() {
        String linea = "";
        BufferedReader in = null;
        PrintStream   out = null;
        try {
            in = new BufferedReader(new FileReader(inFile));
            out = new PrintStream(outFile);
        
            while ((linea = in.readLine()) != null) {
                Comando c = crearComando(linea);
                Status s = catalog.ejecutar(c);
                out.println(s.toString());
                out.flush();
            }
        } catch (Exception ioe) {

            return -1;
        }

        return 0;
    }
	
	// Crea el objeto Comando de acuerdo al codigo y a la informacion
    //de campo-valor presente en el archivo de entrada
	private Comando crearComando(String linea) {
	
        String [] tokens = linea.split("[{]");
		String [] tokensBuscar = null;
		String [] tokensActualizar = null;
        String tipoOperacion = tokens[0].replaceAll(" ", "");
		Comando comando = null;

		if (tipoOperacion.equals("AG")) {
			tokens = splitAGCO(tokens);
			Condicion condicion = new Condicion(tokens);
			comando = new AG (condicion, catalog);
		}
		else if (tipoOperacion.equals("CO")) {
			tokens = splitAGCO (tokens);
			Condicion condicion = new Condicion(tokens);
			comando = new CO (condicion, catalog);
		}
		else if (tipoOperacion.equals("AC")) {
			tokensBuscar = splitACBuscar (tokens);
			tokensActualizar = splitACActualizar (tokens);
			Condicion condicion = new Condicion(tokensBuscar, tokensActualizar);
			comando = new AC (condicion, catalog);
		}
		return comando;
    }
	
	// Devuelve el arreglo de string con la informacion 
	// campo-valor a ser utilizada en los comandos AG y CO
	private String [] splitAGCO (String [] tokens) {
		
		tokens[1] = tokens[1].replaceAll("}","");
		tokens[1] = tokens[1].replaceAll(" ", "");
		tokens = tokens[1].split(",");
		String [] aux1= new String [2];
		String [] aux2= new String [2*tokens.length];
		String lineaux = "";
		int k=0;
		int l=1;
		
		for (int i=0; i<tokens.length; i++) {
			aux1 = tokens[i].split("=");
			aux2[k] = aux1[0];
			lineaux = aux1[1].replaceAll("\"","");
			aux2[l] = lineaux;
			k=k+2;
			l=l+2;
		}
		return aux2;

	}
	
	// Devuelve el arreglo de string con la informacion 
	// campo-valor referentes a la busqueda dentro del
	// catalago, para ser utilizada en el comando AC                                           
	private String [] splitACBuscar (String [] tokens) {
	
		tokens[1] = tokens[1].replaceAll(" ","");
		tokens[1] = tokens[1].replaceAll("}","");
		tokens = tokens[1].split(",");
		String [] aux21 = new String [2*tokens.length];
		int k = 0;
		int l = 1;

		for (int i=0; i<tokens.length; i++) {
			String [] aux11 = new String [2];
			aux11 = tokens[i].split("=");
			aux21[k] = aux11[0];
			String linea = aux11[1].replaceAll("\"","");
			aux21[l] = linea;
			k=k+2;
			l=l+2;
		}
		return aux21;
	}
	
	// Devuelve el arreglo de string con la informacion
	// campo-valor referentes a la actualizacion del
	// catalogo, para ser utilizada en el comando AC
	private String [] splitACActualizar (String [] tokens) {
	
		tokens[2] = tokens[2].replaceAll(" ","");
		tokens[2] = tokens[2].replaceAll("}","");
		tokens = tokens[2].split(",");
		String [] aux22 = new String [2*tokens.length];
		int m = 0;
		int n = 1;
		
		for (int j=0;j<tokens.length; j++) {
			String [] aux12 = new String [2];
			aux12 = tokens[j].split("=");
			aux22[m] = aux12[0];
			String linea = aux12[1].replaceAll("\"","");
			aux22[n] = linea;
			m = m+2;
			n = n+2;
		}
		return aux22;
	}
	
	// Cuerpo Principal
    public static void main(String[] args) {
        if (args.length != 2) {
            System.exit(-1);
        }

        String fileIn = args[0];
        String fileOut = args[1];

        Main m = new Main(fileIn, fileOut);

        System.exit(m.procesar());
    }

    

}
