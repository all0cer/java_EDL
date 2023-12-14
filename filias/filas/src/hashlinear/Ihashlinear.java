package filas.src.hashlinear;

public interface Ihashlinear {
    item findElement(String valor);

    item removeElement(String valor);

    item removeKey(int chave);
    
    item InsertElement(int chave, String valor);

    void Keys();

    void Elements();
}
