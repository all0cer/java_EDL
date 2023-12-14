package filas.src.hashlinear;

public class item {
    int key;
    Object valor;

    public item(int chave, Object valor){
        this.key = chave;
        this.valor = valor;
    }
    public int getKey() {
        return key;
    }
    public void setKey(int key) {
        this.key = key;
    }
    public Object getValor() {
        return valor;
    }
    public void setValor(Object valor) {
        this.valor = valor;
    }
}
