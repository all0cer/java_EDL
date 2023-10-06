package filas.src.ListaLigadaArray;


public class testeListaLigada {
    public static void main(String[] args){ 
        ListaLigadaArray lista = new ListaLigadaArray(10);
        System.out.println("Inserções:");
        lista.insertFirst(45);
        lista.insertLast(9);
        
        lista.PrintVector();

        // System.out.println("Remoção:");
        // lista.remove(lista.find(32));
        // lista.PrintVector();

        // System.out.println("Troca de elementos:");
        // lista.swapElements(lista.find(89), lista.find(9));
        // lista.PrintVector();

        // System.out.println("Tamanho é 3? "+ lista.size());
        // System.out.println("O primeiro é 45? " + lista.first());
        // System.out.println("O ultimo é 89? " + lista.last());


    }
}