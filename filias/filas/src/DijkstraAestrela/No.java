package filas.src.DijkstraAestrela;

import java.util.Objects;


public class No {
    int x;
    int y;
    int g;
    

    public No(int x, int y) {
        this.x = x;
        this.y = y;
        this.g = Integer.MAX_VALUE; //  "infinito"
        
    }

    public No(int x, int y, int g) {
        this.x = x;
        this.y = y;
        this.g = g;
        
    }

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        No no = (No) o;
        return x == no.x && y == no.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + y + ", " + x + ")"; // Formato (linha, coluna)
    }
}