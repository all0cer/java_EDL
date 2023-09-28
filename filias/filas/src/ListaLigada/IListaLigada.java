package filas.src.ListaLigada;

interface IListaLigada {
    public  boolean isEmpty();
    public  int size();
    public  Object first();
    public  Object last();
    public  Object before(node no);
    public  Object after(node no);
    public  void replaceElement(node no, Object elemento);
    public  void swapElements(node no, node no2);
    public  void insertBefore(node no, Object elemento);
    public  void insertAfter(node no, Object elemento);
    public  void insertFirst(node no);
    public  void insertLast(node no);
    public  Object remove(node o);
}
