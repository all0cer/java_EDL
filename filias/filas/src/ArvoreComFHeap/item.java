package filas.src.ArvoreComFHeap;

public class item {
    private Object key;
    Object valor;

    item(Object key, Object valor){
        this.key = key;
        this.valor = valor;
    }
    public Object getKey() {
        return key;
    }

    public Object getValor() {
        return valor;
    }

    public void setKey(Object key) {
        this.key = key;
    }
    public void setValor(item valor) {
        this.valor = valor;
    }
}
