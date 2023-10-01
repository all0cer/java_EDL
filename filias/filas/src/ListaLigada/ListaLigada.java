package filas.src.ListaLigada;

public class ListaLigada implements IListaLigada {
    public inicio = new node();
    public node fim = new node();
    public int tamanho = -1;


    @Override
    public boolean isEmpty() {
        return inicio.getNext() == fim;
    }

    @Override
    public int size() {
        if(isEmpty()){
            return tamanho+1;
        }
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
    public Object before(node no) {
          return (no.getPrev()).getValor();
    }

    @Override
    public Object after(node no) {
       return (no.getNext()).getValor();
    }

    @Override
    public void replaceElement(node no, Object elemento) {
            no.setValor(elemento);
    }

    @Override
    public void swapElements(node no1, node no2) {
            Object valor_no_2 = no1.getValor();
            Object valor_no_1 = no2.getValor();
            no1.setValor(valor_no_2);
            no2.setValor(valor_no_1);
    }

    @Override
    public void insertBefore(node no, Object elemento) {
        node new_node = new node();
        new_node.setValor(elemento);
        
        new_node.setNext(no);
        new_node.setPrev(no.getPrev());
        
        (no.getPrev()).setNext(new_node);
        no.setPrev(new_node);
        ++tamanho;
    }

    @Override
    public void insertAfter(node no, Object elemento) {
        node new_node = new node();
        new_node.setValor(elemento);
        new_node.setPrev(no);
        new_node.setNext(no.getNext());

        (no.getNext()).setPrev(new_node);
        no.setNext(new_node);
        ++tamanho;
        
    }

    @Override
    public void insertFirst(Object elemento) {
            node no = new node();
            no.setValor(elemento)
            no.setPrev(inicio);
            no.setNext(inicio.getNext());
            (inicio.getNext()).setPrev(no);
            inicio.setNext(no);
            ++tamanho;
    }

    @Override
    public void insertLast(Object elemento) {
        node no = new node();
        no.setValor(elemento);
        no.setNext(fim);

        (fim.getPrev()).setNext(no);
         fim.setPrev(no);
         ++tamanho;
    }

    @Override
    public Object remove(node no) {
        Object temp = no.getValor();

        (no.getNext()).setPrev(no.getPrev());
        (no.getPrev()).setNext(no.getNext());

        no.setNext(null);
        no.setPrev(null);
        no.setValor(null);
        return temp;
        --tamanho;
    }

}
