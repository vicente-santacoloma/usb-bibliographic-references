/**
 * DiGraphHash es una clase comcreta que ud debe implementar
 * Los arcos son almacenados como una lista y son almacenados en un
 * arreglo donde la posicion i
 *
 * @author Les profs
 * @version 1.0
 * @since 1.6
**/

import java.io.IOException;

public class DiGraphHash extends DiGraph {

   private MyHashTable<Vertice> nodes;
   private MyHashTable<Arc> arcs;

    /**
     * Crea un DiGraphHash a partir de un DiGraph
     */
   public DiGraphHash (DiGraph d)  {

   }

    @Override
    public Arc addArc(Arc a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Arc addArc(Vertice src, Vertice dst) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Arc addArc(Vertice src, Vertice dst, double costo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Arc delArc(Vertice nodeIniId, Vertice nodeFinId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object clone() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean equals(Object g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Arc getArc(Vertice nodoSrc, Vertice nodoDst) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getDegree(Vertice node) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getInDegree(Vertice node) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Arc> getInEdges(Vertice node) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getNumberOfArcs() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getNumberOfNodes() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getOutDegree(Vertice node) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Arc> getOutEdges(Vertice node) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Vertice> getPredecesors(Vertice node) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Vertice> getSucesors(Vertice node) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isArc(Vertice src, Vertice dst) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void read(String fileName) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Arc> removeAllArcs() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Arc> getAllArcs() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean reverseArc(Vertice nodeIniId, Vertice nodeFinId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean reverseArcs() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void write(String fileName) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
