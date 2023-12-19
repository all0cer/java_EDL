package filas.src.skiplistx;


public interface Iskiplist {

    node find(Object valor);

    void insert(node no);

    void remove(Object valor);

}