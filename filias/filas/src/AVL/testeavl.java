package filas.src.AVL;


public class testeavl {
    public static void main(String[] args) {
            avl arvore = new avl(50);
            arvore.incluiravl(90);
            arvore.incluiravl(20);
            arvore.incluiravl(10);
            arvore.incluiravl(40);
            arvore.incluiravl(30);
            arvore.removeravl(90);
            // arvore.removeravl(50);
            // arvore.removeravl(10);
            arvore.removeravl(20);
            // arvore.removeravl(30);
            arvore.emOrdemavl(arvore.getRaiz());
    }}