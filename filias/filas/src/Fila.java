public class Fila implements IFila{
    public int N = 6; 
    public int inicio = 0;
    public int fim = 0;
    public Object [] filinha = new Object[6];

    @Override
    public void enqueue(Object num) {
        if(size()==N-1){
            FilaCheia(filinha);
        }
        filinha[fim] = num;
        fim = (fim+1)%N;
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

    public void PrintFila(){
        System.out.print("[");
            for (Object object : filinha) {
                System.out.print(object);
                System.out.print(", ");
            }
            System.out.println("]");
    }

    public void FilaCheia(Object [] fila){
         Object [] nova_filinha = new Object[N*2];
         int cont = inicio;
         for(int i=0; i<N; i++){
                nova_filinha[i] = fila[cont];
                cont = (cont+1)%N;
         }
         fim = size();
         inicio = 0;
         N *= 2;
         filinha = nova_filinha;
    }
    
}