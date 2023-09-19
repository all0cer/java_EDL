public class Fila implements IFila{
    public int N = 6; 
    public int inicio = 0;
    public int fim = 0;
    public Object [] filinha = new Object[6];

    @Override
    public void enqueue(Object num) {
        filinha[fim] = num;
        fim = (fim+1)%size();
    }

    @Override
    public Object dequeue() {
          return 1+1;
    }

    @Override
    public Object first() {
        return filinha[inicio];
    }

    @Override
    public int size() {
        return (N - inicio + fim )% N;
    }

    @Override
    public boolean isEmpty() {
        return (inicio==fim);
    }

    
}