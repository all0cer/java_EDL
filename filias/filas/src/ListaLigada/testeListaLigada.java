package filas.src.ListaLigada;


public class testeListaLigada {
    public static void main(String[] args){ 
        ListaLigada lista = new ListaLigada();
        node no1 = new node(45);
        node no2 = new node(89);
        node no3 = new node(100);
        node no4 = new node(23);
        node no5 = new node(76);
        node no6 = new node(80);
        node no7 = new node(32);
        node no8 = new node(64);
        node no9 = new node(99);
        node no10 = new node(14);
        lista.insertFirst(76);
        lista.PrintVector();
    }
}