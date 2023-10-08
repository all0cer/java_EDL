package filas.src.Sequencia;

public class testesequencia {
    public static void main(String[] args){ 
        sequencia sequencia = new sequencia();
        System.out.println("Inserções:");
        sequencia.insertFirst(45);
        sequencia.insertLast(9);
        sequencia.insertAfter(sequencia.find(45), 32);
        sequencia.insertBefore(sequencia.find(9), 89);
        System.out.println("Elemento no index 1 é 32? "+ sequencia.elemAtRank(1));
        sequencia.PrintVector();

        System.out.println("Remoção:");
        sequencia.remove(sequencia.find(32));
        sequencia.PrintVector();

        System.out.println("Troca de elementos:");
        sequencia.swapElements(sequencia.find(89), sequencia.find(9));
        sequencia.PrintVector();
        sequencia.replaceAtRank(0, 200);
        sequencia.replaceElement(sequencia.find(9), 55);
        sequencia.PrintVector();

        System.out.println("Exibindo no index 0: " + sequencia.atRank(0));
        System.out.println("Exibindo o index do valor 55: " + sequencia.rankOf(sequencia.find(55)));
        sequencia.removeAtRank(1);
        sequencia.PrintVector();

    }
}
