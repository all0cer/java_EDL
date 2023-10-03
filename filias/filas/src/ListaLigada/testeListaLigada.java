package filas.src.ListaLigada;


public class testeListaLigada {
    public static void main(String[] args){ 
    ListaLigada lista = new ListaLigada();
    lista.insertFirst(3);
    lista.insertFirst(4);
    lista.remove(3);
    System.out.println("Tamanho:" + lista.size());
    System.out.println("O primeiro  número é 4? " + lista.first()); 
    System.out.println("O ultimo número é 5? " + lista.last());

    }

}
