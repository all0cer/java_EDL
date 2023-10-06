package filas.src.ListaLigadaArray;


public class testeListaLigada {
    public static void main(String[] args){ 
        ListaLigadaArray lista = new ListaLigadaArray(10);
        System.out.println("Inserções:");
        lista.insertFirst(45);
        lista.insertLast(9);
        lista.insertBefore(9, 99);
        lista.insertAfter(5, 203);
        
        lista.PrintVector();

        System.out.println("Remoção:");
        lista.remove(9);
        lista.PrintVector();

         System.out.println("Troca de elementos:");
         lista.swapElements(9, 0);
         lista.PrintVector();

        System.out.println("Tamanho é? "+ lista.size());
        System.out.println("O primeiro é null? " + lista.first());
        System.out.println("O ultimo é 45? " + lista.last());


    }
}