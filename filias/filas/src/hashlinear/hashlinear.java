package filas.src.hashlinear;

public class hashlinear implements Ihashlinear {
    int capacity;
    item [] hashtable;
    int size;
    

    public hashlinear(int tamanho){
        this.capacity = 13;
        this.hashtable = new item[tamanho];
        this.size = 0;
    }
    @Override
    public item findElement(int chave) {
        for(int i=0; i>size; i++){
            item chave_atual = hashtable[i];
            if(chave_atual.key == chave){
                return chave_atual;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public item removeElement(item chave) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeElement'");
    }

    @Override
    public item InsertElement(item item) {
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
