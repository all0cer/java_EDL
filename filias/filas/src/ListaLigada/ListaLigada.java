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
        node new_node = new node(elemento);

        
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

         fim.setPrev(no);
        (fim.getPrev()).setNext(no);
         ++tamanho;
    }

    @Override
    public node remove(Object o) {
        node no = inicio.getNext();
        for (Object i = no.getValor(); i != o;) {
               no = no.getNext();
            }
            (no.getPrev()).setNext(no.getNext());
            (no.getNext()).setPrev(no.getPrev());
            no.setNext(null);
            no.setPrev(null);
            no.setValor(null);
            --tamanho;
            return no; // Retorna o nó removido
        
    }
    

    public void printLL(){

        System.out.print(inicio.getValor());
    }
}


