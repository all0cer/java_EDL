package filas.src.hashlinear;

public class hashlinear implements Ihashlinear {
    int capacity;
    item [] hashtable;
    int size;
    item AVALIABLE;
    

    public hashlinear(){
        this.capacity = 13;
        this.hashtable = new item[capacity];
        this.size = 0;
    }
    @Override
    public item findElement(String valor) {
        for(int i=0; i>size; i++){
            item item_atual = hashtable[i];
            if(item_atual.valor == valor){
                return item_atual;
            }
        }
        throw new IllegalArgumentException();
    }

    public item findKey(int chave) {
        for(int i=0; i>size; i++){
            item item_atual = hashtable[i];
            if(item_atual.key == chave){
                return item_atual;
            }
        }
        throw new IllegalArgumentException();
    }


    private int FindIndex(int valor){
            return valor%13;
    }

    @Override
    public item removeElement(String valor) {
        findElement(valor)
    }

    @Override
    public item InsertElement(int chave, String valor) {
        item novo_item = new item(chave, valor);
        int index = FindIndex(chave);
        if(hashtable[index] == null){
            hashtable[index] = novo_item;
            return novo_item;
        }else{
            while(hashtable[index] != null || hashtable[index] ==  ){
                index = (index+1)%capacity;
                novo_item.key += 1;
            } 
        }
        hashtable[index] = novo_item;
        return novo_item;
    }

    @Override
    public void Keys() {
        System.out.print("[");
            for (item object : hashtable) {
                if(object == null){
                    System.out.print("NULL");
                    System.out.print(", ");
                }else{
                System.out.print(object.key);
                System.out.print(", ");
                }
            }
            System.out.println("]");
    }

    @Override
    public void Elements() {
        System.out.print("[");
            for (item object : hashtable) {
                if(object == null){
                    System.out.print("NULL");
                    System.out.print(", ");
                }else{
                System.out.print(object.valor);
                System.out.print(", ");
                }
            }
            System.out.println("]");
    }
    @Override
    public item removeKey(int chave) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeKey'");
    }
    
}
