package filas.src.ArverePesquisa;

import java.util.Iterator;
import java.util.Stack;


public class arverepesquisa implements Iarverepesquisa {
    no raiz;
    int tamanho;
    comparadale compara = new comparadale();

    public arverepesquisa(Object elemento){
        raiz = new no(null, elemento);
        tamanho = 1;
    }

    @Override
    public comparadale getComparador() {
        comparadale compara = new comparadale();
        return compara;
    }

    @Override
    public no pesquisar(Object key, no node) {

        if (node == null){
            return null;
        }
        if(compara.compare(key, node.getElemento()) < 0){
            return pesquisar(key, node.getFilhoequerda());
        }

        else if(compara.compare(key, node.getElemento()) > 0){
                return pesquisar(key, node.getFilhodireita());
            }

        else{
            return node;
        }
        
    }

    @Override
    public no incluir(Object key) {
        no no_atual = getRaiz();
        no novoNo = new no(null, key);
        while (true) {
            int resultado = compara.compare(novoNo.getElemento(), no_atual.getElemento());

            if (resultado < 0) {
                if (filhodaesquerda(no_atual) == null) {
                    no_atual.setFilhoequerda(novoNo);
                    novoNo.setPai(no_atual);
                    tamanho++;
                    return novoNo;
                }
                else{
                    no_atual = filhodaesquerda(no_atual);
                }
            }

            else if (resultado > 0){
                if (filhodadireita(no_atual) == null) {
                    no_atual.setFilhodireita(novoNo);
                    novoNo.setPai(no_atual);
                    tamanho++;
                    return novoNo;
                }
                else{
                    no_atual = filhodadireita(no_atual);
                }
            }

            else{
                return no_atual;
            }
        }
    }
    @Override
    public Object remover(Object key) {
        no noexcluir = pesquisar(key, raiz);
        if (isExternal(noexcluir)){ //CASO DE NÓ SEM FILHOS
            if(parent(noexcluir).getFilhoequerda() == noexcluir){
                parent(noexcluir).setFilhoequerda(null);
                return noexcluir.getElemento();
            }
            else{
                parent(noexcluir).setFilhodireita(null);
                return noexcluir.getElemento();
            }
        }
        else if (noexcluir.getFilhodireita() != null && noexcluir.getFilhoequerda() != null){
                no substitui = sucessor(filhodadireita(noexcluir));
                noexcluir.setElemento(substitui.getElemento());
                remover(sucessor(substitui));
                return noexcluir.getElemento();
        }
        else{
            no filho = (noexcluir.getFilhoequerda() != null) ? noexcluir.getFilhoequerda(): noexcluir.getFilhodireita(); 
            filho.setPai(parent(noexcluir)); //VOU SER CRIADO POR VÓ
            if(parent(noexcluir).getFilhoequerda() == noexcluir){
                parent(noexcluir).setFilhoequerda(filho);
                return noexcluir.getElemento();
            }
            else{
                parent(noexcluir).setFilhodireita(filho);
                return noexcluir.getElemento();
            }
        }

    
    }

    private no sucessor(no node){
        while (node.getFilhoequerda() != null) {
            node = node.getFilhoequerda();
        }
        return node;
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
        if (node == null) {
             System.out.print("null"); // Se o nó for nulo, retorna sem fazer mais nada
             return;
        }

        if (isInternal(node)){
            emOrdem(filhodaesquerda(node));
        }

    System.out.print(node.getElemento() + ", ");

        if (isInternal(node)){
            emOrdem(filhodadireita(node));
        }
    }

    @Override
    public void preOrdem(no node) {
        if (node == null) {
             System.out.print("null"); // Se o nó for nulo, retorna sem fazer mais nada
             return;
        }
         System.out.println(node.getElemento());
         if (isInternal(node)){
            System.out.println(node.getElemento());
            posOrdem(filhodaesquerda(node));
            posOrdem(filhodadireita(node));
        }
    }

    @Override
    public void posOrdem(no node) {
        if (node == null) {
             System.out.print("null"); // Se o nó for nulo, retorna sem fazer mais nada
             return;
        }
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
            while (currentNode != null || !pilha.isEmpty()) {
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
         if (node == null) {
            return false;  // ou true, dependendo da sua lógica — mas geralmente false
        }
        return (node.getFilhodireita() == null && node.getFilhoequerda() == null);
    }

    public boolean isInternal(no node){
        return (node.getFilhodireita() != null || node.getFilhoequerda() != null);
    }

    
}
