package filas.src.ListaDeAdjacencia;

import java.util.ArrayList;

public class Grafo {

    private ArrayList vertices = new ArrayList();

    public Object inserirAresta(Vertice inicio, Vertice fim, Object valor){
        Aresta nova_aresta = new Aresta(inicio, fim, valor);
        return nova_aresta.getValor_aresta();
    }

    public Object inserirVertice(Object valor){
        
    }

}
