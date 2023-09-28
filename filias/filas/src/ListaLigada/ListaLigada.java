package filas.src.ListaLigada;

public class ListaLigada implements IListaLigada {
    node inicio = new node();
    node fim = new node();
    int tamanho = -1;


    @Override
    public boolean isEmpty() {
        return inicio.getNext() == fim;
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
    public Object before(node no) {
          return no.getPrev().getValor();
    }

    @Override
    public Object after(node no) {
       return no.getNext().getValor();
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
        
    }

    @Override
    public void insertAfter(node no, Object elemento) {
        node new_node = new node();
        new_node.setValor(elemento);
        
    }

    @Override
    public void insertFirst(node no) {

    }

    @Override
    public void insertLast(node no) {
       
    }

    @Override
    public Object remove(node no) {
        Object temp = no.getValor();
        return temp;
    }

    

}
