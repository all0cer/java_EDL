package filas.src.Sequencia;

public class testesequencia {
    public static void main(String[] args){ 
        sequencia sequencia = new sequencia();
        System.out.println("Inserções:");
        sequencia.insertFirst(45);
        sequencia.insertLast(9);
        sequencia.insertAfter(sequencia.find(45), 32);
        sequencia.insertBefore(sequencia.find(9), 89);
        sequencia.PrintVector();

        System.out.println("Remoção:");
        sequencia.remove(sequencia.find(32));
        sequencia.PrintVector();

        System.out.println("Troca de elementos:");
        sequencia.swapElements(sequencia.find(89), sequencia.find(9));
        sequencia.PrintVector();
    }
}
