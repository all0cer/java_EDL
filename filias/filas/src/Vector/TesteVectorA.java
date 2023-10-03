package filas.src.Vector;

public class TesteVectorA {
    public static void main(String[] args){ 
        VectorArray vetor = new VectorArray(5);
        System.out.println(vetor.isEmpty());
        vetor.insertAtRank(0, 5);
        System.out.println(vetor.isEmpty());
        vetor.insertAtRank(2, 3);
        vetor.insertAtRank(1, 6);
        vetor.insertAtRank(3, 7);
        vetor.insertAtRank(2, 9);
        System.out.println(vetor.size());
        vetor.replaceAtRank(0, 123);
        vetor.removeAtRank(4);
        vetor.PrintVector();
        System.out.println(vetor.elemAtRank(2));

    }
}
