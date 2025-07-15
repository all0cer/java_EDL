package filas.src.DijkstraAestrela;

import java.util.Objects;

public class NoEstrela {
    int x, y;
    int g; // Custo do início até este nó (passado)
    int h; // Custo estimado deste nó até a saída (futuro)
    int f; // Custo total (g + h)
   

    public NoEstrela(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getF() {
        return f;
    }

    public int getH() {
        return h;
    }
    
    // Método para calcular todos os custos de uma vez usando Manhatan
    public void calcularCustos(NoEstrela noFinal) {
        // g é definido externamente pelo algoritmo
        this.h = Math.abs(this.x - noFinal.x) + Math.abs(this.y - noFinal.y);
        this.f = this.g + this.h;
    }

    @Override
    public String toString() {
        return "(" + y + ", " + x + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoEstrela no = (NoEstrela) o;
        return x == no.x && y == no.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}