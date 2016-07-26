/**
 * Arc es una clase que permite almancenar la informacion de los arcos de un
 * grafo
 *
 * @author Les profs
 * @version 1.0
 * @since 1.6
 */

public class Arc {
    private String id = "";

    /**
     * Crea un arco entre los nodos src y dst
     *
     * @param src nodo origen del arco
     * @param dst nodo destino del arco
     */
    public Arc(Vertice src, Vertice dst) {
    }

    /**
     * retorna el nodo inicialdel arco
     *
     */
    public Vertice getSrc() {
        return null;
    }
    /**
     * retorna el nodo inicialdel arco
     *
     */
    public Vertice getDst() {
        return null;
    }

    /**
     * Retorna un nuevo {@code Arc} con el mismo fuente y el mismo destino que
     * este Arc.
     *
     * @return una lista con los mismos elementosque esta lista
     * @see java.lang.Cloneable
     */
    @Override
    public Object clone() {
        Arc c =  null;
       return c;
    }

    /**
     * Indica si el Arc a es igual a este Arc
     *
     * @param a Arc con el que se desea comparar.
     * @return true si los fuentes y destinos de los dos arcos son iguales.
     */
    public boolean equals(Object a) {
        if (!(a instanceof Arc))
            return false;

        // completar

       return false;
    }

    /**
     * Retorna la representacion en String del Arc
     *
     * @return la representacion en String de este Arc
     */
    @Override
    public String toString() {
       return "por definir";
    }

    /**
     * Retorna la representacion en String del Arc
     *
     */
    public void reverse() {
       
    }
}
