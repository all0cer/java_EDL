package filas.src.Sequencia;

public class sequencia implements Isequencia {
    private node inicio;
    private node fim;
    private int tamanho;

    

    public sequencia(){
        this.tamanho = 0;
        this.inicio = new node(null);
        this.fim = new node(null);
        this.inicio.setNext(fim);
        this.fim.setPrev(inicio);
    }

    @Override
    public Object elemAtRank(int index) {
    node atual = inicio.getNext();
    for(int i=0; i<index; i++){
        atual.getNext();
    }
    return atual.getValor();
}

    @Override
    public void replaceAtRank(int index, Object elemento) {
    node atual = inicio.getNext();
    for(int i=0; i<index; i++){
        atual.getNext();
    }
    atual.setValor(elemento);
}

    @Override
    public void insertAfter(int index, Object elemento) {
        node new_node = new node(elemento);
        node atual = inicio.getNext();
        for(int i=0; i<index; i++){
            atual.getNext();
    }
        new_node.setPrev(atual);
        new_node.setNext(atual.getNext());
        

        (atual.getNext()).setPrev(new_node);
        atual.setNext(new_node);
        ++tamanho;
    }

    @Override
    public void removeAtRank(int index) {
    node atual = inicio.getNext();
    for(int i=0; i<index; i++){
        atual.getNext();
    }
    (atual.getNext()).setPrev(atual.getPrev());
    (atual.getPrev()).setNext(atual.getNext());

    atual.setNext(null);
    atual.setPrev(null);
    atual.setValor(null);
    --tamanho;
}

    @Override
    public void replaceElement(node no, Object elemento) {
       no.setValor(elemento);
    }

    @Override
    public void swapElements(node no1, node no2) {
        Object valor_no_2 = no2.getValor();
        Object valor_no_1 = no1.getValor();
        no1.setValor(valor_no_2);
        no2.setValor(valor_no_1);
    }

    @Override
    public void insertBefore(node no, Object elemento) {
        node new_node = new node(elemento);
        new_node.setValor(elemento);
        

        new_node.setNext(no);
        new_node.setPrev(no.getPrev());

        (no.getPrev()).setNext(new_node);
        no.setPrev(new_node);
        ++tamanho;
    }

    @Override
    public void insertAfter(node no, Object elemento) {
        node new_node = new node(elemento);
        new_node.setPrev(no);
        new_node.setNext(no.getNext());
        

        (no.getNext()).setPrev(new_node);
        no.setNext(new_node);
        ++tamanho;
    }

    @Override
    public void insertFirst(Object elemento) {
        node no = new node(elemento);
            no.setPrev(inicio);
            no.setNext(inicio.getNext());

            (inicio.getNext()).setPrev(no);
            inicio.setNext(no);
            ++tamanho;
    }

    @Override
    public void insertLast(Object elemento) {
        node no = new node(elemento);
        no.setValor(elemento);
        no.setNext(fim);

        (fim.getPrev()).setNext(no);
         fim.setPrev(no);
         ++tamanho;
    }

    @Override
    public void remove(node no) {
        (no.getNext()).setPrev(no.getPrev());
        (no.getPrev()).setNext(no.getNext());

        no.setNext(null);
        no.setPrev(null);
        no.setValor(null);
        --tamanho;
    }

    @Override
    public boolean isEmpty(){
        return inicio.getNext() == fim;
    }

    @Override
    public long size(){
        return tamanho;
    }

    @Override
    public node find(Object valor) {
        node atual = inicio.getNext();
        while(atual.getValor() != valor){
            atual = atual.getNext();
        }
        
        return atual;
    }

    @Override
    public Object atRank(int index) {
    node atual = inicio.getNext();
    for(int i=0; i<index; i++){
        atual.getNext();
    }
    return atual.getValor();
    }

    @Override
    public Object rankOf(node no) {
       node atual = inicio.getNext();
       long rank = 0;
        while(atual != no){
            atual = atual.getNext();
            rank++;
        }
        
        return rank;
    }

    public void PrintVector() {
		node atual = inicio.getNext();
		System.out.print("[ ");
		for(int i = 0; i < size(); i++) {
            if(atual.getNext() == fim) {
				break;
			}
			System.out.print(atual.getValor()+ ", ");
			atual = atual.getNext();
		}
		System.out.println("]");
	}
    
}
