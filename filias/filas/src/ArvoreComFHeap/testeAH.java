package filas.src.ArvoreComFHeap;


public class testeAH {
    public static void main(String[] args){
    ArvoreComFHeap arvore = new ArvoreComFHeap(2);
    arvore.Insert(8);
    arvore.Insert(10);
    arvore.Insert(12);
    arvore.emOrdem(arvore.getRaiz());
}
}
