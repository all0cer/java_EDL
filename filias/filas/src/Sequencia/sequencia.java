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
        
    }

    @Override
    public void replaceAtRank(int index, Object o) {
        
    }

    @Override
    public void insertAfter(int index, Object o) {
        
    }

    @Override
    public void removeAtRank(int index) {
        
    }

    @Override
    public void replaceElement(node no, Object o) {
       
    }

    @Override
    public void swapElements(node no, node no1) {
       
    }

    @Override
    public void insertBefore(node no, Object o) {
        
    }

    @Override
    public void insertAfter(node no, Object o) {
       
    }

    @Override
    public void insertFirst(Object o) {
       
    }

    @Override
    public void insertLast(Object o) {
       
    }

    @Override
    public void remove(node no) {
       
    }

    @Override
    public boolean isEmpty(){

    }

    @Override
    public long size(){
        
    }

    @Override
    public node find(Object o) {
       
    }

    @Override
    public Object atRank(int index) {
       
    }

    @Override
    public Object rankOf(node no) {
       
    }
    
}
