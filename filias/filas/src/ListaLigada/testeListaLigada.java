package filas.src.ListaLigada;


public class testeListaLigada {
    public static void main(String[] args){ 
    ListaLigada lista = new ListaLigada();
    System.out.println("TA VAZIA ESSA DESGRAÇA? " + lista.isEmpty());
    lista.insertFirst(3);
    lista.insertFirst(4);
    lista.insertFirst(9);
    lista.insertFirst(11);
    lista.insertLast(14);
    lista.insertLast(17);
    lista.insertAfter(2, 39);
    lista.remove(3);
    lista.swapElements(2, 4);
    lista.replaceElement(4, 67);
    System.out.println("TA VAZIA ESSA DESGRAÇA? " + lista.isEmpty());
    lista.PrintVector();
    System.out.println();

    }
}