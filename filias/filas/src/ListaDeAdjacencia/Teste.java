package filas.src.ListaDeAdjacencia;

public class Teste {
    public static void main(String[] args) throws Exception{
        Grafo grafo = new Grafo();
        grafo.inserirVertice(19);
        grafo.inserirVertice(20);
        Vertice um = new Vertice(21);
        Vertice dos = new Vertice(30);
        grafo.inserirAresta(um, dos, "Bernardo Vieira");
        grafo.inserirVertice(dos);
        grafo.inserirVertice(um);
        System.out.println(grafo.eAdjacente(um, dos));
        System.out.println();
        grafo.mostrar();
    }
}
