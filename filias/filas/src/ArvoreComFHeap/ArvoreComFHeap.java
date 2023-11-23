package filas.src.ArvoreComFHeap;

import java.util.Iterator;
import java.util.Stack;


public class ArvoreComFHeap implements IArvoreFilaH {
    node raiz;
    int tamanho;
    node ultimo;
    comparadale compara = new comparadale();


    @Override
    public comparadale getComparador() {
        comparadale compara = new comparadale();
        return compara;
    }

    @Override
    public node pesquisar(Object key, node node) {

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
    public node incluir(Object key) {
        node no_atual = getRaiz();
        node novoNo = new node(null, key);
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
        node noexcluir = pesquisar(key, raiz);
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
                node substitui = sucessor(filhodadireita(noexcluir));
                noexcluir.setElemento(substitui.getElemento());
                remover(sucessor(substitui));
                return noexcluir.getElemento();
        }
        else{
            node filho = (noexcluir.getFilhoequerda() != null) ? noexcluir.getFilhoequerda(): noexcluir.getFilhodireita(); 
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

    private node sucessor(node node){
        while (node.getFilhoequerda() != null) {
            node = node.getFilhoequerda();
        }
        return node;
    }
    
    @Override
    public node getRaiz() {
        return raiz;
    }

    @Override
    public void setRaiz(node p) {
        
    }

    @Override
    public void emOrdem(node node) {
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
    public void preOrdem(node node) {
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
    public void posOrdem(node node) {
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
    public int altura(node node) {
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
    public int profundidade(node node) {
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
        private node currentNode = raiz;
        private Stack<node> pilha = new Stack<>();

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

            node node = pilha.pop();
            currentNode = filhodadireita(currentNode);

            return node;
        }
    };
    }

    @Override
    public Iterator elements() {
       return new Iterator<Object>() {
        private node currentNode = raiz;
        private Stack<node> pilha = new Stack<>();

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

            node node = pilha.pop();
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

    public node parent(node node){
        return node.getPai();
    }

    public node filhodaesquerda(node node){
        return node.getFilhoequerda();
    }

    public node filhodadireita(node node){
        return node.getFilhodireita();
    }

    public node temesquerdo(node node){
        return node.getFilhoequerda();
    }

    public node temdireito(node node){
        return node.getFilhodireita();
    }
    
    public boolean isExternal(node node){
        return (node.getFilhodireita() == null && node.getFilhoequerda() == null);
    }

    public boolean isInternal(node node){
        return (node.getFilhodireita() != null || node.getFilhoequerda() != null);
    }

    @Override
    public void Insert(int key, Object valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Insert'");
    }

    @Override
    public item removeMin() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeMin'");
    }

    @Override
    public item Min() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Min'");
    }

    @Override
    public void upheap() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'upheap'");
    }

    @Override
    public void downheap() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'downheap'");
    }
}

