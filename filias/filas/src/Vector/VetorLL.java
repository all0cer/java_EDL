package filas.src.Vector;


public class VetorLL implements Ivector{
    private node fim;
    private node inicio;
    private int tamanho;

    public VetorLL(){
        this.inicio = new node(null);
        this.fim = new node(null);
        tamanho = 0;
        this.inicio.setNext(fim);
        this.fim.setPrev(inicio);
    }

    @Override
    public Object elemAtRank(int r) {
        if(r > tamanho){
            new RuntimeException("Não existe este index, tente pelo tamanho atual: " + size());
        }
        node atual = inicio.getNext();
        for(int i=0; i < r; i++){
            atual = atual.getNext();
        }
        return atual.getValor();
    }


    @Override
    public Object replaceAtRank(int r, Object o) {
        if(r > tamanho){
            new RuntimeException("Não existe este index, tente pelo tamanho atual: " + size());
        }
        node atual = inicio.getNext();
            for(int i=0; i < r; i++){
                atual = atual.getNext();
            }

            atual.setValor(o);
            return atual.getValor();
    }


    @Override
    public void insertAtRank(int r, Object o) {
        if(r > tamanho){
            new RuntimeException("Não existe este index, tente pelo tamanho atual: " + size());
        }
        node new_node = new node(o);
        if(inicio == null){
                inicio =  new node(null);
                fim =  new node(null);
                inicio.setNext(new_node);
                fim.setPrev(new_node);
                new_node.setPrev(inicio);
                new_node.setNext(fim);
            }
        node atual = inicio.getNext();
        for (int i = 0; i < r; i++) {
                atual = atual.getNext();
            }
        new_node.setPrev(atual.getPrev());
        new_node.setNext(atual);
        atual.getPrev().setNext(new_node);
        atual.setPrev(new_node);
        
        ++tamanho;
    }

    @Override
    public Object removeAtRank(int r) {
        if(r > tamanho){
            new RuntimeException("Não existe este index");
        }
        node atual = inicio.getNext();
        for (int i = 0; i < r; i++) {
                atual = atual.getNext();
            }
            Object temp = atual.getValor();
            (atual.getPrev()).setNext(atual.getNext());
            (atual.getNext()).setPrev(atual.getPrev());
            --tamanho;

             atual.setNext(null);
             atual.setPrev(null);
             atual.setValor(null);
            return temp;
    }

    @Override
    public int size() {
        return tamanho;
    }

    @Override
    public boolean isEmpty() {
        return tamanho == 0 ? true : false;
    }



    public void PrintVectorLL() {
		node atual = inicio.getNext();
		System.out.print("[ ");
		for(int i = 0; i < size(); i++) {
            if(atual.getValor() == null) {
				break;
			}
			System.out.print(atual.getValor()+ ", ");
			atual = atual.getNext();
		}
		System.out.print("]");
}
}
