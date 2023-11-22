package filas.src.ArverePesquisa;

public class testearverep {
    public static void main(String[] args) {
        arverepesquisa arvore = new arverepesquisa(4);
        arvore.incluir(5);
        arvore.incluir(1);
        System.out.println(arvore.getRaiz().getElemento());
        System.out.println(arvore.getRaiz().getFilhoequerda().getElemento());
        no teste = arvore.pesquisar(5, arvore.getRaiz());
        arvore.remover(5);
        System.out.println(teste.getElemento());
        System.out.println(arvore.size());
        arvore.emOrdem(arvore.getRaiz());
        arvore.preOrdem(arvore.getRaiz());
    }
}
