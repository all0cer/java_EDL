
package filas.src.DijkstraAestrela;

import java.util.*;

public class AEstrela {

    private final int[][] labirinto;
    private final int linhas;
    private final int colunas;
    private NoEstrela noInicial;
    private List<NoEstrela> nosDeSaida; // Armazena todas as saídas

    private static final int[] DX = {0, 0, 1, -1};
    private static final int[] DY = {1, -1, 0, 0};

    public AEstrela(int[][] labirinto) {
        this.labirinto = labirinto;
        this.linhas = labirinto.length;
        this.colunas = labirinto[0].length;
        encontrarPontosChave();
    }

    private void encontrarPontosChave() {
        this.nosDeSaida = new ArrayList<>();
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (labirinto[i][j] == 2) {
                    this.noInicial = new NoEstrela(j, i);
                } else if (labirinto[i][j] == 3) {
                    this.nosDeSaida.add(new NoEstrela(j, i));
                }
            }
        }
    }
    
    public int encontrarMenorCustoGeral() {
        if (nosDeSaida.isEmpty()) {
            System.out.println("leitura do labirinto deu errado");
            return -1;
        }

        List<Integer> custosEncontrados = new ArrayList<>();
        System.out.println("Número de saídas é 3? " + nosDeSaida.size());

        // Loop para executar o algoritmo para cada saída
        for (NoEstrela saidaAlvo : nosDeSaida) {
            System.out.println(" A siada está em: " + saidaAlvo);
            int custo = encontrarCustoParaUmAlvo(saidaAlvo);
            if (custo != -1) {
                System.out.println("custo: " + custo);
                custosEncontrados.add(custo);
            } else {
                System.out.println("Não tem como chegar");
            }
        }


        return Collections.min(custosEncontrados);
    }

 
   
    private int encontrarCustoParaUmAlvo(NoEstrela alvo) {
    
        PriorityQueue<NoEstrela> listaAberta = new PriorityQueue<>(
            Comparator.comparingInt(NoEstrela::getF).thenComparingInt(NoEstrela::getH)
        );
        Set<NoEstrela> listaFechada = new HashSet<>();
        int[][] distanciasG = new int[linhas][colunas];
        for (int[] linha : distanciasG) {
            Arrays.fill(linha, Integer.MAX_VALUE);
        }

        noInicial.g = 0;
        noInicial.calcularCustos(alvo); // Heurística 
        distanciasG[noInicial.y][noInicial.x] = 0;
        listaAberta.add(noInicial);

        while (!listaAberta.isEmpty()) {
            NoEstrela atual = listaAberta.poll();

            if (listaFechada.contains(atual)) {
                continue;
            }
            listaFechada.add(atual);

            // A condição de parada é encontrar o ALVO ATUAL
            if (atual.equals(alvo)) {
                return atual.g; 
            }

            for (int i = 0; i < 4; i++) {
                int vizinhoX = atual.x + DX[i];
                int vizinhoY = atual.y + DY[i];
                NoEstrela vizinho = new NoEstrela(vizinhoX, vizinhoY);

                if (isPosicaoValida(vizinho) && !listaFechada.contains(vizinho)) {
                    int novoG = atual.g + 10; 

                    if (novoG < distanciasG[vizinho.y][vizinho.x]) {
                        distanciasG[vizinho.y][vizinho.x] = novoG;
                        vizinho.g = novoG;
                        vizinho.calcularCustos(alvo); // Heurística do vizinho 
                        listaAberta.add(vizinho);
                    }
                }
            }
        }
        return -1; // Falha em encontrar um caminh
    }

    private boolean isPosicaoValida(NoEstrela no) {
        return no.x >= 0 && no.x < colunas && no.y >= 0 && no.y < linhas && labirinto[no.y][no.x] != 1;
    }
}