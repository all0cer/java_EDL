package filas.src.ListaDeAdjacencia;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Grafo {

    private ArrayList<Vertice> vertices;

    public Grafo(){
        this.vertices = new ArrayList<Vertice>();
    }

    public Object inserirAresta(Vertice inicio, Vertice fim, Object valor){
        Aresta nova_aresta = new Aresta(inicio, fim, valor);
        inicio.addVerticeAdj(fim);
        fim.addVerticeAdj(inicio);
        return nova_aresta.getValor_aresta();
    }


    public Object inserirArestaDirecionada(Vertice inicio, Vertice fim, Object valor){
        Aresta nova_aresta = new Aresta(inicio, fim, valor);
        inicio.addVerticeAdj(fim);
        fim.addVerticeAdj(inicio);
        nova_aresta.setDirecionada();
        return nova_aresta.getValor_aresta();
    }

    public Object inserirVertice(Object valor) throws Exception{
        Vertice novoVertice = new Vertice(valor);
        if(!vertices.contains(novoVertice)){
            vertices.add(novoVertice);
            return valor;
        }

        throw new Exception("Já existe este vértice no grafo");
    }

    public Object inserirVertice(Vertice novoVertice) throws Exception{
        if(!vertices.contains(novoVertice)){
            vertices.add(novoVertice);
            return novoVertice.getValor_vertice();
        }

        throw new Exception("Já existe este vértice no grafo");
    }

    public void mostrar(){
        for(Vertice vertice: vertices){
            System.out.print(vertice.getValor_vertice() + " ");
        }
    }

    public ArrayList<Vertice> finalVertice(Aresta e){
        ArrayList<Vertice> verticesDaAresta = new ArrayList<Vertice>();
        verticesDaAresta.add(e.getVertice_destino());
        verticesDaAresta.add(e.getVertice_inicio());
        return verticesDaAresta; 
    }

    public Vertice oposto(Vertice v, Aresta e) throws Exception{
        ArrayList<Vertice> verticesDaAresta = finalVertice(e);
        if(verticesDaAresta.contains(v)){
            if(e.getVertice_inicio() == v){
                return e.getVertice_destino();
            }else{
                return e.getVertice_inicio();
            }
        }
        throw new Exception("a aresta não é incidente ao vértice");
    }

    public boolean eAdjacente(Vertice v, Vertice w){
        if(v.getVerticesAdjacentes().contains(w) && w.getVerticesAdjacentes().contains(v)){
            return true;
        }

        return false;
    }

    public Object substituir(Vertice v, Object o){
            v.setValor_vertice(o);
            return v.getValor_vertice();
    }

    public Object substituir(Aresta a, Object o){
            a.setValor_aresta(o);
            return a.getValor_aresta();
    }

    public Object removerVertice(Vertice v){
            Object valorRemovido = v.getValor_vertice();

            ArrayList<Vertice> vizinhos = v.getVerticesAdjacentes();
            for(Vertice vizinho: vizinhos){
                vizinho.getVerticesAdjacentes().remove(v);
            }

            vertices.remove(v);
            return valorRemovido;
    }
    
    public Object removerAresta(Aresta e){
        Vertice inicio = e.getVertice_inicio();
        Vertice fim = e.getVertice_destino();

        Object valorRemovido = e.getValor_aresta();

        inicio.getVerticesAdjacentes().remove(fim);
        fim.getVerticesAdjacentes().remove(inicio);

        return valorRemovido;
    }

    public ArrayList<Vertice> vertices(){
        return vertices;
    }

    public ArrayList<Aresta> arestas() { //PERGUNTAR NOVAMENTE SOBRE O ARMAZENAMENTO DAS ARESTAS
        ArrayList<Aresta> todasAsArestas = new ArrayList<>();
        Set<Vertice> verticesProcessados = new HashSet<>();

    
        for (Vertice verticeAtual : this.vertices) {
            for (Vertice vizinho : verticeAtual.getVerticesAdjacentes()) {
                
                if (!verticesProcessados.contains(vizinho)) {
                    
                    Aresta arestaReconstruida = new Aresta(verticeAtual, vizinho, null);
                    todasAsArestas.add(arestaReconstruida);
                }
            }
            verticesProcessados.add(verticeAtual);
        }

        return todasAsArestas;
    }

    //public ArrayList<Vertice> arestasIncidentes(Vertice v){
        //PERGUNTAR COMO FAZER JÁ QUE AS ARESTAS NÃO SÃO ARMAZENADAS
    //}

}
