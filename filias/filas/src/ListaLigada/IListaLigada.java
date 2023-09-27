package filas.src.ListaLigada;

interface IListaLigada {
    public  boolean isEmpty();
    public  int size();
    public  node first();
    public  node last();
    public  node before(Object node);
    public  node after(Object node);
    public  void replaceElement(n, o);
    public  void swapElements(n, q);
    public  void insertBefore(n, o);
    public  void insertAfter(n, o);
    public  void insertFirst(o);
    public  void insertLast(o);
    public  node remove(n);
}
