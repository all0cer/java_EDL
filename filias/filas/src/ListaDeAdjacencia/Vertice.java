package filas.src.ListaDeAdjacencia;

import java.util.ArrayList;

public class Vertice {
    private Object valor_vertice;
    private ArrayList arestas = new ArrayList();
    

    public Object getValor_vertice() {
        return valor_vertice;
    }

    public void setValor_vertice(Object valor_vertice) {
        this.valor_vertice = valor_vertice;
    }

    
}
