package filas.src.Vector;

interface IListaLigada {
    public  boolean isEmpty();
    public  int size();
    public  Object first();
    public  Object last();
    public  Object before(int index);
    public  Object after(int index);
    public  void replaceElement(int index, Object elemento);
    public  void swapElements(int index, int index1);
    public  void insertBefore(int index, Object elemento);
    public  void insertAfter(int index, Object elemento);
    public  void insertFirst(Object elemento);
    public  void insertLast(Object elemento);
    public  Object remove(int o);
}
