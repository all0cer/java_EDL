package filas.src.AVL;


public class testeavl {
    public static void main(String[] args) {
            avl arvore = new avl(7);
            System.out.println(arvore.getRaiz().getElemento());
            arvore.incluiravl(11);
            arvore.incluiravl(6);
            arvore.incluiravl(10);
            arvore.incluiravl(9);
            System.out.println(arvore.getRaiz().getFilhodireita().getElemento());
            System.out.println(arvore.getRaiz().getFilhoequerda().getElemento());
            System.out.println(arvore.getRaiz().getFator());

    
    }}