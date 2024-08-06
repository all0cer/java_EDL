package filas.src.ListaDeAdjacencia;

public class Aresta {

    private Object valor_aresta;
    private Vertice vertice_inicio;
    private Vertice vertice_destino;
    
    public Aresta(Vertice inicio, Vertice fim, Object valor){
        this.valor_aresta = valor;
        this.vertice_inicio = inicio;
        this.vertice_destino = fim;
    }
    
    public Vertice getVertice_destino() {
        return vertice_destino;
    }

    public void setVertice_destino(Vertice vertice_destino) {
        this.vertice_destino = vertice_destino;
    }

    public Vertice getVertice_inicio() {
        return vertice_inicio;
    }

    public void setVertice_inicio(Vertice vertice_inicio) {
        this.vertice_inicio = vertice_inicio;
    }

    public Object getValor_aresta() {
        return valor_aresta;
    }

    public void setValor_aresta(Object valor_aresta) {
        this.valor_aresta = valor_aresta;
    }

}
