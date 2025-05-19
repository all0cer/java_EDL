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

        arvore.inserir(60);
        arvore.inserir(70);
        arvore.inserir(40);
        arvore.mostrar();
        // agora você pode usar os métodos da arvore
        // por exemplo, arvore.algumMetodo();
    }
}
