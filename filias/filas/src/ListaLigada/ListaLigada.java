package filas.src.ListaLigada;

public class ListaLigada implements IListaLigada {
    private node inicio;
    private node fim;
    private int tamanho;

    

    public ListaLigada(){
        this.tamanho = 0;
        this.inicio = null;
        this.fim = null;

    }
    @Override
    public boolean isEmpty() {
        return tamanho == 0 ? true : false;
    }

    @Override
    public int size() {
        return tamanho;
    }

    @Override
    public Object first() {
        return inicio.getNext().getValor();
    }

    @Override
    public Object last() {
        return fim.getPrev().getValor();
    }

    @Override
    public Object before(int index) {
          node atual = inicio.getNext();
            for(int i=0; i < index; i++){
                atual = atual.getNext();
            }
        return atual.getPrev().getValor();
    }

    @Override
    public Object after(int index) {
       node atual = inicio.getNext();
            for(int i=0; i < index; i++){
                atual = atual.getNext();
            }
        return atual.getNext().getValor();
    }

    @Override
    public void replaceElement(int index, Object elemento) {
            node atual = inicio.getNext();
            for(int i=0; i < index; i++){
                atual = atual.getNext();
            }

            atual.setValor(elemento);
    }

    @Override
    public void swapElements(int index, int index1) {
        node atual = inicio.getNext();
        for(int i=0; i<index; i++){
            atual = atual.getNext();
        }
        Object tempo = atual.getValor();

        node atual1 = inicio.getNext();
        for(int i = 0; i < index1; i++){
             atual1 = atual1.getNext();
        }
        
        atual.setValor(atual1.getValor());
        atual1.setValor(tempo);
    }

    @Override
    public void insertBefore(int index, Object elemento) {
        node new_node = new node(elemento);
        if(inicio == null){
                inicio =  new node(null);
                fim =  new node(null);
                inicio.setNext(new_node);
                fim.setPrev(new_node);
                new_node.setPrev(inicio);
                new_node.setNext(fim);
            }
        node atual = inicio.getNext();
        for (int i = 0; i < index; i++) {
                atual = atual.getNext();
            }
        new_node.setPrev(atual.getPrev());
        new_node.setNext(atual);
        (atual.getPrev()).setNext(new_node);
        atual.setPrev(new_node);
        ++tamanho;
    }

    @Override
    public void insertAfter(int index, Object elemento) {
        
        node new_node = new node(elemento);
        if(inicio == null){
                inicio =  new node(null);
                fim =  new node(null);
                inicio.setNext(new_node);
                fim.setPrev(new_node);
                new_node.setPrev(inicio);
                new_node.setNext(fim);
            }
        node atual = inicio.getNext();
        for (int i = 0; i < index; i++) {
                atual = atual.getNext();
            }
        new_node.setPrev(atual);
        new_node.setNext(atual.getNext());
        (atual.getNext()).setPrev(new_node);
        atual.setNext(new_node);
        ++tamanho;
    }

    @Override
    public void insertFirst(Object elemento) {
            node primeiro_no = new node(elemento);
            if(inicio == null){
                inicio =  new node(null);
                fim =  new node(null);
                inicio.setNext(primeiro_no);
                fim.setPrev(primeiro_no);
                primeiro_no.setPrev(inicio);
                primeiro_no.setNext(fim);
            }
            primeiro_no.setNext(inicio.getNext());
            primeiro_no.setPrev(inicio);
            inicio.setNext(primeiro_no);
            ++tamanho;
    }

    @Override
    public void insertLast(Object elemento) {
        node no = new node(elemento);
        no.setNext(fim);
        no.setPrev(fim.getPrev());
        fim.getPrev().setNext(no);
        fim.setPrev(no);
         ++tamanho;
    }

    @Override
    public Object remove(int index) {
        node atual = inicio.getNext();
        for (int i = 0; i < index; i++) {
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
    
    public Object elemAtRank(int r) {
        node atual = inicio.getNext();
        for(int i=0; i < r; i++){
            atual = atual.getNext();
        }
        return atual.getValor();
    }
    
    public void PrintVector() {
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



