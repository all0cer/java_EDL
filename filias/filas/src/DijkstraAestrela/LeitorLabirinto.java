package filas.src.DijkstraAestrela;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class LeitorLabirinto {

    public static int[][] ler(String caminhoArquivo) {
        try {
            Path path = Paths.get(caminhoArquivo);
            List<String> linhas = Files.readAllLines(path);

            int numLinhas = linhas.size();
            int numColunas = linhas.get(0).length();
            int[][] labirinto = new int[numLinhas][numColunas];

            for (int i = 0; i < numLinhas; i++) {
                String linha = linhas.get(i);
                if (linha.length() != numColunas) {
                    throw new IllegalArgumentException("linhas com tamanho diferente");
                }
                for (int j = 0; j < numColunas; j++) {
                    labirinto[i][j] = Character.getNumericValue(linha.charAt(j));
                }
            }
            return labirinto;

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo do labirinto: " + e.getMessage());
            return null;
        }
    }
}