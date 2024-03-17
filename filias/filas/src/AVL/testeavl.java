package filas.src.AVL;


public class testeavl {
    public static void main(String[] args) {
            avl arvore = new avl(8);
            System.out.println(arvore.getRaiz().getElemento());
            arvore.incluiravl(11);
            arvore.incluiravl(7);
            arvore.incluiravl(6);
            arvore.incluiravl(5);
            arvore.incluiravl(12);
            arvore.incluiravl(13);
            System.out.println(arvore.getRaiz().getFilhodireita().getElemento());
            System.out.println(arvore.getRaiz().getFilhoequerda().getElemento());
            System.out.println(arvore.getRaiz().getFator());

    
    }}