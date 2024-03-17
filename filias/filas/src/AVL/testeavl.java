package filas.src.AVL;


public class testeavl {
    public static void main(String[] args) {
            avl arvore = new avl(50);
            System.out.println(arvore.getRaiz().getElemento());
            arvore.incluiravl(20);
            arvore.incluiravl(80);
            arvore.incluiravl(90);
            arvore.incluiravl(70);
            arvore.incluiravl(60);
            System.out.println(arvore.getRaiz().getFilhodireita().getElemento());
            System.out.println(arvore.getRaiz().getFilhoequerda().getElemento());
            nodeavl noatual = arvore.getRaiz();
            for(int i=0; i<2; i++){
                System.out.println(noatual.getFator());
                noatual = (nodeavl) noatual.getFilhodireita();
            }

    
    }}