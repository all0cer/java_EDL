package filas.src.hashlinear;

public interface Ihashlinear {
    item findElement(int chave);

    item removeElement(item chave);
    
    item InsertElement(int chave, Object valor);

    void Keys();

    void Elements();
}
