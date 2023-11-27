package filas.src.ArvoreComFHeap;

import java.util.Iterator;
import java.util.Stack;


public class ArvoreComFHeap implements IArvoreFilaH {
    node raiz;
    int tamanho;
    node ultimo;
    comparadale compara = new comparadale();


    public ArvoreComFHeap(Object elemento){
        raiz = new node(null, elemento);
        tamanho = 1;
        ultimo = raiz;
    }

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
        if(node == null){
             System.out.print("null");
             return node;
            }
        return node.getPai();
    }

    public node filhodaesquerda(node node){
        if(node == null){
             System.out.print("null");
             return node;
            }
        return node.getFilhoequerda();
    }
    

    public node filhodadireita(node node){
        if(node == null){
             System.out.print("null");
             return node;
            }
        return node.getFilhodireita();
    }

    public boolean temesquerdo(node node){
        return node.getFilhoequerda() != null;
    }

    public boolean temdireito(node node){
        if(node == null){
             System.out.print("null");
            }
        return node.getFilhodireita() != null;
    }
    
    public boolean ehesquerdo(node node){
        if(node == null){
             System.out.print("null");
            }
        return parent(node).getFilhoequerda() == node;
    }
    public boolean isExternal(node node){
        return (node.getFilhodireita() == null && node.getFilhoequerda() == null);
    }

    public boolean isInternal(node node){
        return (node.getFilhodireita() != null || node.getFilhoequerda() != null);
    }

    public node brodi(node node){
        if (ehesquerdo(node)){
            return parent(node).getFilhodireita();
        }
        return parent(node).getFilhoequerda();
    }

    @Override
    public node removeMin() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeMin'");
    }

    @Override
    public node Min() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Min'");
    }

    @Override
    public void upheap() {
    }

    @Override
    public void Insert(Object valor) {
        
        node novo_no = new node(null, valor);
        node no_atual = ultimo; //APONTA PARA ULTIMO NO
       
        while(no_atual != raiz && !ehesquerdo(no_atual)){
            no_atual = parent(no_atual); //ENQUANTO NÃO FOR FILHO DA ESQUERDA, PEGA O PAI
        }

        if(no_atual != raiz){
            no_atual = brodi(no_atual); //QUANDO ENCONTRAR FILHO DA ESQUERDA, PEGA O IRMÃO
        }
        else{
            if(temdireito(raiz)){
            no_atual = filhodadireita(raiz);
            }else{
                raiz.setFilhodireita(novo_no);
                novo_no.setPai(raiz);
                ultimo = novo_no;
                return;
            } //SE FOR A RAIZ VAI PARA DIREITA
        }

        while(!isExternal(no_atual)){
            no_atual = filhodaesquerda(no_atual); //ENQUANTO NÃO FOR FOLHA, DESCE PARA ESQUERDA
        }

        ultimo = no_atual; //ESTA BAGAÇA VAI SER REALMENTE O ULTIMO NO???
    }
}

