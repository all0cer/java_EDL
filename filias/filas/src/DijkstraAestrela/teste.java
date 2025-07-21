package filas.src.DijkstraAestrela;

import java.time.Duration;
import java.time.Instant;

public class teste {
    public static void main(String[] args) {
        String caminhoArquivo = "filias\\filas\\src\\DijkstraAestrela\\labirinto.dat";
        int[][] labirinto = LeitorLabirinto.ler(caminhoArquivo);
        System.out.println();
        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[0].length; j++) {
                System.out.print(labirinto[i][j]);
            }
            System.out.println();
        }
        
        Dijkstra dijkstra = new Dijkstra(labirinto);
        Instant inicioDijkstra = Instant.now();
        int custoMinimo = dijkstra.encontrarCustoMinimo();
        Instant fim = Instant.now();

        Duration duracaoDijskstra = Duration.between(inicioDijkstra, fim);
        System.out.println("Tempo decorrido com Dijkstra: " + duracaoDijskstra.toMillis() + "ms");
        System.out.println("Custo mínimo para encontrar a saída com Dijkstra: " + custoMinimo);

        AEstrela aEstrela = new AEstrela(labirinto);
        Instant inicioAestrela = Instant.now();
        int custoMinimoEstrela = aEstrela.encontrarMenorCustoGeral();
        Instant fimAestrela = Instant.now();

        Duration duracaoAestrela = Duration.between(inicioAestrela, fimAestrela);
        System.out.println("Tempo decorrido com AEstrela: " + duracaoAestrela.toMillis() + "ms");
        System.out.println("Custo mínimo para encontrar a saída com AEstrela: " + custoMinimoEstrela);

        
    }
}
