package filas.src.DijkstraAestrela;


import java.util.*;

public class Dijkstra {

    private final int[][] labirinto;
    private final int linhas;
    private final int colunas;
    private No noInicial;

    // Movimentos possíveis (cima, baixo, direita, esquerda)
    private static final int[] DX = {0, 0, 1, -1};
    private static final int[] DY = {1, -1, 0, 0};

    public Dijkstra(int[][] labirinto) {
        this.labirinto = labirinto;
        this.linhas = labirinto.length;
        this.colunas = labirinto[0].length;
        encontrarPontosChave();
    }

    private void encontrarPontosChave() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (labirinto[i][j] == 2) {
                    this.noInicial = new No(j, i);
                }
                // Se houver múltiplos '3', ele encontrará o caminho para o primeiro que alcançar.
            }
        }
    }

    public int encontrarCustoMinimo() {
   
    PriorityQueue<No> listaAberta = new PriorityQueue<>(Comparator.comparingInt(no -> no.g));
    

    // Matriz para armazenar a menor distância conhecida 
    int[][] distancias = new int[linhas][colunas];
    for (int[] linha : distancias) {
        Arrays.fill(linha, Integer.MAX_VALUE);
    }


    noInicial.g = 0;
    distancias[noInicial.y][noInicial.x] = 0;
    
    listaAberta.add(new No(noInicial.x, noInicial.y, 0)); 

    while (!listaAberta.isEmpty()) {
        No atual = listaAberta.poll();

        
        if (atual.g > distancias[atual.y][atual.x]) {
            continue;
        }

        if (labirinto[atual.y][atual.x] == 3) {
            return atual.g; 
        }

        // Explorar vizinhos
        for (int i = 0; i < 4; i++) {
            int vizinhoX = atual.x + DX[i];
            int vizinhoY = atual.y + DY[i];

            // Verifica se o vizinho é válido
            if (isPosicaoValida(vizinhoX, vizinhoY)) {
                
                
                int novaDistancia = atual.g + 10; 

                
                if (novaDistancia < distancias[vizinhoY][vizinhoX]) {
                    distancias[vizinhoY][vizinhoX] = novaDistancia;
                    
                    listaAberta.add(new No(vizinhoX, vizinhoY, novaDistancia)); 
                }
            }
        }
    }

    
    return -1; 
}

    private boolean isPosicaoValida(int x, int y) {
        return x >= 0 && x < colunas && y >= 0 && y < linhas && labirinto[y][x] != 1; // Não é parede
    }

}
