package filas.src.ArvoreRN;


public class testeRN {
      public static void main(String[] args) {
        arvorern arvore = new arvorern(50);
        // arvore.inserir(40);
        // arvore.inserir(60);
        // arvore.inserir(65); // TESTA CASO 2

        // arvore.inserir(40);
        // arvore.inserir(60);
        // arvore.inserir(35); //TESTA CASO 2 ESQUERDA
        // arvore.inserir(41);
        // arvore.inserir(32); //TESTA CASO 2 RECURSIVO

        // arvore.inserir(40); //TESTE CASO 3a 
        // arvore.inserir(30);

        // arvore.inserir(60);
        // arvore.inserir(70);
        // arvore.inserir(40);
        // arvore.inserir(51);
        // arvore.inserir(39);
        // arvore.inserir(42);
        // arvore.inserir(38);

       //TESTA CASO 3c
        // arvore.inserir(60);
        // arvore.inserir(55);

        //TESTA CASO 3d
        arvore.inserir(45);
        arvore.inserir(48);
        arvore.mostrar();
        System.out.println("Quantidade nós negros:" + arvore.contarNosPretosRecursivo(arvore.getRaiz()));
        System.out.println("É rubro negra? " + arvore.isRubroNegra(arvore.getRaiz()));
        // agora você pode usar os métodos da arvore
        // por exemplo, arvore.algumMetodo();
    }
}
