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
    public  void insertFirst(Object elemento);
    public  void insertLast(Object elemento);
    public  Object remove(Object o);
}
