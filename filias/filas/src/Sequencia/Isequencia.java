package filas.src.Sequencia;

interface Isequencia {
    public Object elemAtRank(int index);
    public void replaceAtRank(int index, Object o);
    public void insertAfter(int index, Object o);
    public void removeAtRank(int index);
    public void replaceElement(node no, Object o);
    public void swapElements(node no, node no1);
    public void insertBefore(node no, Object o);
    public void insertAfter(node no, Object o);
    public void insertFirst(Object o);
    public void insertLast(Object o);
    public void remove(node no);
    public node find(Object o);
    public Object atRank(int index);
    public Object rankOf(node no);
    public boolean isEmpty();
    public long size();
}
