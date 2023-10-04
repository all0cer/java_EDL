package filas.src.ListaLigada;


public class testeListaLigada {
    public static void main(String[] args){ 
    ListaLigada lista = new ListaLigada();
    lista.insertFirst(3);
    lista.insertFirst(4);
    lista.insertFirst(9);
    lista.insertFirst(11);
    lista.insertLast(14);
    lista.insertLast(17);
    lista.insertAfter(2, 50);
    lista.insertBefore(2, 55);
    System.out.println("Tamanho:" + lista.size());
    System.out.println("O primeiro  número é? " + lista.first()); 
    System.out.println("O ultimo número é? " + lista.last());
    System.out.println(lista.elemAtRank(0));
    lista.PrintVector();
    }
}