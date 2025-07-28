package filas.src.ListaDeAdjacencia;

import java.util.ArrayList;

public class Vertice {
    private Object valor_vertice;
    private ArrayList<Vertice> verticesAdjacentes;
    


    public Vertice(Object valor){
        this.valor_vertice = valor;
        verticesAdjacentes = new ArrayList<Vertice>();
    }

    public void addVerticeAdj(Object valor){
        Vertice novo_vertice = new Vertice(valor);
        if(!verticesAdjacentes.contains(novo_vertice)){
            verticesAdjacentes.add(novo_vertice);
        }
    }

    public void addVerticeAdj(Vertice vertice){
        if(!verticesAdjacentes.contains(vertice)){
            verticesAdjacentes.add(vertice);
        }
    }

    public Object getValor_vertice() {
        return valor_vertice;
    }

    public void setValor_vertice(Object valor_vertice) {
        this.valor_vertice = valor_vertice;
    }

    public ArrayList<Vertice> getVerticesAdjacentes(){
        return verticesAdjacentes;
    }

    
    
}
