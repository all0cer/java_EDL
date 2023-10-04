package filas.src.Vector;

public class testeVectorLL {
    public static void main(String[] args){
        VetorLL vetor = new VetorLL();
        System.out.println("ESSA BAGAÇA ESTÁ VAZIA? " + vetor.isEmpty());
        vetor.insertAtRank(0, 31);
        vetor.insertAtRank(1, 7);
        vetor.insertAtRank(4, 9);
        vetor.removeAtRank(1);
        vetor.replaceAtRank(1, 89);
        System.out.println(vetor.elemAtRank(0));
        System.out.println("ESSA BAGAÇA ESTÁ VAZIA? " + vetor.isEmpty());
        System.out.println("Tamanho: " + vetor.size());
        vetor.PrintVectorLL();
    }
}
