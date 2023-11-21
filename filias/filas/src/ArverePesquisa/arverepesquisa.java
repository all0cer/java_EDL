package filas.src.ArverePesquisa;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;

public class arverepesquisa implements Iarverepesquisa, Comparator {
    no raiz;
    int tamanho;

    public arverepesquisa(Object elemento){
        raiz = new no(null, elemento);
        tamanho = 1;
    }

    @Override
    public comparadale getComparador() {
        comparadale compara = new comparadale();
        return compara;
    }

    // @Override
    // public void setComparator(comparator c) {
        
    // }

    @Override
    public no pesquisar(Object key, no node) {
        if (isExternal(node)){
            return node;
        }
        if((Integer)key < (Integer) node.getElemento()){
            return pesquisar(key, filhodaesquerda(node));
        }

        else if(key ==  node.getElemento()){
                return node;
            }

        else{
            return pesquisar(key, filhodadireita(node));
        }
        
    }

    @Override
    public no incluir(Object key) {
        no no_atual = getRaiz();
        comparadale compara = new comparadale();
        int resultado = compara.compare(no_atual, no_atual);

    }

    @Override
    public Object remover(Object key) {
        
    }

    @Override
    public no getRaiz() {
        return raiz;
    }

    @Override
    public void setRaiz(no p) {
        
    }

    @Override
    public void emOrdem(no node) {
        if (isInternal(node)){
            emOrdem(filhodaesquerda(node));
        }
        System.out.print(node.getElemento());
        if (isInternal(node)){
            emOrdem(filhodadireita(node));
        }
    }

    @Override
    public void preOrdem(no node) {
         System.out.println(node.getElemento());
         if (isInternal(node)){
            System.out.println(node.getElemento());
            posOrdem(filhodaesquerda(node));
            posOrdem(filhodadireita(node));
        }
    }

    @Override
    public void posOrdem(no node) {
        if (isInternal(node)){
            posOrdem(filhodaesquerda(node));
            posOrdem(filhodadireita(node));
        }
        System.out.println(node.getElemento());
    }

    @Override
    public int altura(no node) {
        if(isExternal(node)){
            return 0;
        }
        else{
            int alturaesquerda = altura(filhodaesquerda(node));
            int alturadireita = altura(filhodadireita(node));

            return Math.max(alturaesquerda, alturadireita) + 1;
        }
    }

    @Override
    public int profundidade(no node) {
        if(node == raiz){
            return 0;
        }
        else{
            return 1+profundidade(parent(node));
        }
    }

    @Override
    public void mostrar() {
        
    }

    @Override
    public Iterator nos() {
        return new Iterator<Object>() {
        private no currentNode = raiz;
        private Stack<no> pilha = new Stack<>();

        @Override
        public boolean hasNext() {
            return currentNode != null || !pilha.isEmpty();
        }

        @Override
        public Object next() {
            while (currentNode != null) {
                pilha.push(currentNode);
                currentNode = filhodaesquerda(currentNode);
            }

            no node = pilha.pop();
            currentNode = filhodadireita(currentNode);

            return node;
        }
    };
    }

    @Override
    public Iterator elements() {
       return new Iterator<Object>() {
        private no currentNode = raiz;
        private Stack<no> pilha = new Stack<>();

        @Override
        public boolean hasNext() {
            return currentNode != null || !pilha.isEmpty();
        }

        @Override
        public Object next() {
            while (currentNode != null) {
                pilha.push(currentNode);
                currentNode = filhodaesquerda(currentNode);
            }

            no node = pilha.pop();
            currentNode = filhodadireita(currentNode);

            return node.getElemento();
        }
    };
    }

    @Override
    public int size() {
       return tamanho;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    // #### adicionais #####

    public no parent(no node){
        return node.getPai();
    }

    public no filhodaesquerda(no node){
        return node.getFilhoequerda();
    }

    public no filhodadireita(no node){
        return node.getFilhodireita();
    }

    public no temesquerdo(no node){
        return node.getFilhoequerda();
    }

    public no temdireito(no node){
        return node.getFilhodireita();
    }
    
    public boolean isExternal(no node){
        return (node.getFilhodireita() == null && node.getFilhoequerda() == null);
    }

    public boolean isInternal(no node){
        return (node.getFilhodireita() != null && node.getFilhoequerda() != null);
    }
}
