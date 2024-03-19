package filas.src.AVL;


public class testeavl {
    public static void main(String[] args) {
            avl arvore = new avl(50);
            arvore.incluiravl(90);
            arvore.incluiravl(20);
            arvore.incluiravl(10);
            arvore.incluiravl(40);
            arvore.incluiravl(30);
            arvore.remover(90);
            arvore.mostraravl();
    }}