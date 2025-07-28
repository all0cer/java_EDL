package filas.src.ListaDeAdjacencia;

public class Aresta {

    private Object valor_aresta;
    private Vertice vertice_inicio;
    private Vertice vertice_destino;
    private boolean direcionada;
    
    public Aresta(Vertice inicio, Vertice fim, Object valor){
        this.valor_aresta = valor;
        this.vertice_inicio = inicio;
        this.vertice_destino = fim;
        this.direcionada = false;
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

    public boolean eDirecionada(){
        return direcionada;
    }

    public void setDirecionada(){
        this.direcionada = true;
    }

    @Override
    public String toString() {
        
        String inicioStr = (this.vertice_inicio != null) ? this.vertice_inicio.toString() : "N/A";
        String fimStr = (this.vertice_destino != null) ? this.vertice_destino.toString() : "N/A";
        String valorStr = (this.valor_aresta != null) ? this.valor_aresta.toString() : "";

        if (this.direcionada) {
            
            return String.format("%s --(%s)--> %s", inicioStr, valorStr, fimStr);
        } else {
            return String.format("%s --(%s)-- %s", inicioStr, valorStr, fimStr);
        }
    }
}
