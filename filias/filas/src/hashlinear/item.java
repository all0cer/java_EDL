package filas.src.hashlinear;

public class item {
    Object key;
    Object valor;

    public item(Object chave, Object valor){
        this.key = chave;
        this.valor = valor;
    }
    public Object getKey() {
        return key;
    }
    public void setKey(Object key) {
        this.key = key;
    }
    public Object getValor() {
        return valor;
    }
    public void setValor(Object valor) {
        this.valor = valor;
    }
}
