package filas.src.hashlinear;

public class hashlinear implements Ihashlinear {
    int capacity;
    Object [] hashtable;
    int size;
    

    public hashlinear(int tamanho){
        this.capacity = 13;
        this.hashtable = new Object[tamanho];
        this.size = 0;
    }
    @Override
    public Object findElement(Object chave) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findElement'");
    }

    @Override
    public Object removeElement(Object chave) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeElement'");
    }

    @Override
    public Object InsertElement(Object item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'InsertElement'");
    }

    @Override
    public void Keys() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Keys'");
    }

    @Override
    public void Elements() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Elements'");
    }
    
}
