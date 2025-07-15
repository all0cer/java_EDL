
package filas.src.DijkstraAestrela;

import java.util.*;

public class AEstrela {

    private final int[][] labirinto;
    private final int linhas;
    private final int colunas;
    private NoEstrela noInicial;
    private NoEstrela noFinal; 

    // Movimentos possíveis (cima, baixo, direita, esquerda)
    private static final int[] DX = {0, 0, 1, -1};
    private static final int[] DY = {1, -1, 0, 0};

    public AEstrela(int[][] labirinto) {
        this.labirinto = labirinto;
        this.linhas = labirinto.length;
        this.colunas = labirinto[0].length;
        encontrarPontosChave();
    }

    
    private void encontrarPontosChave() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (labirinto[i][j] == 2) {
                    this.noInicial = new NoEstrela(j, i);
                } else if (labirinto[i][j] == 3) {
                    this.noFinal = new NoEstrela(j, i); 
                    // considera apenas a primeira saída encontrada
                }
            }
        }
    }

    public int encontrarCaminho() {
        
        PriorityQueue<NoEstrela> listaAberta = new PriorityQueue<>(
            Comparator.comparingInt(NoEstrela::getF).thenComparingInt(NoEstrela::getH)
        );
        
        
        Set<NoEstrela> listaFechada = new HashSet<>();
        
        // Matriz para armazenar a menor distância (g) conhecida
        int[][] distanciasG = new int[linhas][colunas];
        for (int[] linha : distanciasG) {
            Arrays.fill(linha, Integer.MAX_VALUE);
        }

        // Configuração inicial
        noInicial.g = 0;
        noInicial.calcularCustos(noFinal); // Calcula h e f
        distanciasG[noInicial.y][noInicial.x] = 0;
        listaAberta.add(noInicial);

        while (!listaAberta.isEmpty()) {
            NoEstrela atual = listaAberta.poll();

            if (listaFechada.contains(atual)) {
                continue;
            }

            listaFechada.add(atual);

            // Se encontrar a saída, termina
            if (atual.equals(noFinal)) {
                return atual.g;
            }

            // Explorar vizinhos
            for (int i = 0; i < 4; i++) {
                int vizinhoX = atual.x + DX[i];
                int vizinhoY = atual.y + DY[i];

                NoEstrela vizinho = new NoEstrela(vizinhoX, vizinhoY);

                if (isPosicaoValida(vizinho) && !listaFechada.contains(vizinho)) {
                    int novoG = atual.g + 10;

                    if (novoG < distanciasG[vizinho.y][vizinho.x]) {
                        distanciasG[vizinho.y][vizinho.x] = novoG;
                        vizinho.g = novoG;
                        vizinho.calcularCustos(noFinal); 
                       
                        listaAberta.add(vizinho);
                        
                    }
                }
            }
        }

        return -1; 
    }

    private boolean isPosicaoValida(NoEstrela no) {
        return no.x >= 0 && no.x < colunas && no.y >= 0 && no.y < linhas && labirinto[no.y][no.x] != 1;
    }

}