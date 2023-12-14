package filas.src.hashlinear;

public class item {
    int key;
    String valor;

    public item(int chave, String valor){
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
    public void setValor(String valor) {
        this.valor = valor;
    }
}
