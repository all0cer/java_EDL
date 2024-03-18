package filas.src.AVL;


public class testeavl {
    public static void main(String[] args) {
            avl arvore = new avl(8);
            arvore.incluiravl(10);
            arvore.incluiravl(11);
            arvore.incluiravl(12);
            arvore.incluiravl(13);
            System.out.println(arvore.getRaiz().getElemento());
            System.out.println(arvore.getRaiz().getFilhodireita().getElemento());
            System.out.println(arvore.getRaiz().getFilhoequerda().getElemento());
            // nodeavl noatual = arvore.getRaiz();
            // for(int i=0; i<2; i++){
            //     System.out.println(noatual.getFator());
            //     noatual = (nodeavl) noatual.getFilhodireita();
            // }

    
    }}