package filas.src.hashlinear;

public interface Ihashlinear {
    item findElement(int chave);

    item removeElement(item chave);
    
    item InsertElement(item item);

    void Keys();

    void Elements();
}
