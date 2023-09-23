package filas.src.FilaComPilha;

public class FilaDupla implements IFila{
    public int tamanho = -1;
    public Pilha pilha1;

    @Override
    public void enqueue(Object o) {
        
    }

    @Override
    public Object dequeue() {
    
    }

    @Override
    public Object first() {

    }

    @Override
    public int size() {
        return pilha1.Size();
    }

    @Override
    public boolean Empty() {
        return pilha1.isEmpty();
    }

    

}
