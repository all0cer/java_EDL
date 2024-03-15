package filas.src.hashlinear;

public class hashlinear implements Ihashlinear {
    int capacity;
    item [] hashtable;
    int size;
    item AVAILABLE;

    

    public hashlinear(){
        this.capacity = 13;
        this.hashtable = new item[capacity];
        this.size = 0;
        this.AVAILABLE = new item(-99, "AVAILABLE");
    }

    @Override
    public item findElement(String valor) {
        for(int i=0; i<size; i++){
            item item_atual = hashtable[i];
            if(item_atual != null && item_atual.valor == valor){
                return item_atual;
            }
        }
        throw new IllegalArgumentException("Não Há elemento com esse valor");
    }

    private int FindIndex(int valor){
            return valor%13;
    }

    @Override
    public item removeElement(int chave) {
        for(int i=0; i<size; i++){
            item item_atual = hashtable[i];
            if(item_atual != null && item_atual.key == chave){
                size--;
                return hashtable[i] = AVAILABLE;
            }
        }
        throw new IllegalArgumentException("Não Há elemento com esse valor");
    }

    @Override
    public item InsertElement(int chave, String valor) {
        if((capacity/2)<size){
            DuplicarArray();
        }
        item novo_item = new item(chave, valor);
        int index = FindIndex(chave);
        if(hashtable[index] == null){
            hashtable[index] = novo_item;
            size++;
            return novo_item;
        }else{
            while(hashtable[index] != null){
                index = (index+1)%capacity;
                novo_item.key += 1;
            } 
        }
        hashtable[index] = novo_item;
        size++;
        return novo_item;
    }

    public item InsertElementDuplo(int chave, String valor) {
        if((capacity/2)<size){
            DuplicarArray();
        }
        int j = 1;
        item novo_item = new item(chave, valor);
        int index = FindIndex(chave);
        if(hashtable[index] == null){
            hashtable[index] = novo_item;
            size++;
            return novo_item;
        }else{
            while(hashtable[index] != null){
                index = (index+(j * index))%capacity;
                j++;
                novo_item.key += 1;
            } 
        }
        hashtable[index] = novo_item;
        size++;
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

    public boolean isEmpty(){
        return size==0;
    }
    
    public static boolean ehPrimo(int numero) {
        if (numero <= 1) {
            return false; // Números menores ou iguais a 1 não são primos
        }

        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false; // Se for divisível por algum número entre 2 e a raiz quadrada, não é primo
            }
        }

        return true; // Se não foi divisível por nenhum número, é primo
    }

    public void DuplicarArray(){
        int new_capacity = (capacity*2);
        while(!ehPrimo(new_capacity)){
            new_capacity++;
        }
        item [] new_hashtable = new item[new_capacity];
        for(int i=0; i<capacity; i++){
            new_hashtable[i] = hashtable[i];
        }
        hashtable = new_hashtable;
        capacity = new_capacity;
    }
    
}
