package filas.src.ArvoreComFHeap;

import java.util.Iterator;
import java.util.Stack;


public class ArvoreComFHeap implements IArvoreFilaH {
    node raiz;
    int tamanho;
    node ultimo;
    public comparadale compara = new comparadale();


    public ArvoreComFHeap(Object elemento){
        raiz = new node(null, elemento);
        node p1 = new node(raiz, 7);
        node p2 = new node(raiz, 5);
        raiz.setFilhodireita(p2);
        raiz.setFilhoequerda(p1);
        tamanho = 3;
        ultimo = p2;
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
             System.out.print("null, "); // Se o nó for nulo, retorna sem fazer mais nada
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
             System.out.print("null, ");
             return node;
            }
        return node.getPai();
    }

    public node filhodaesquerda(node node){
        if(node == null){
             System.out.print("null, ");
             return node;
            }
        return node.getFilhoequerda();
    }
    

    public node filhodadireita(node node){
        if(node == null){
             System.out.print("null, ");
             return node;
            }
        return node.getFilhodireita();
    }

    public boolean temesquerdo(node node){
        return node.getFilhoequerda() != null;
    }

    public boolean temdireito(node node){
        if(node == null){
             System.out.print("null, ");
            }
        return node.getFilhodireita() != null;
    }
    
    public boolean ehesquerdo(node node){
        if(node == null){
             System.out.print("null, ");
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
    public node Min() {
        return raiz;
    }

    @Override
    public void upheap() {
        node no_atual = ultimo;
        comparadale compara = new comparadale();
        while(no_atual != raiz && compara.compare(no_atual.getElemento(), parent(no_atual).getElemento()) == -1){
            if(no_atual != null && parent(no_atual) != null){
                Object temp = no_atual.getElemento();
                no_atual.setElemento(parent(no_atual).getElemento());
                parent(no_atual).setElemento(temp);
                no_atual = parent(no_atual);
            }else{
                break;
            }
        }
    }


    @Override
    public void Insert(Object valor) {
        
        node novo_no = new node(null, valor);
        node no_atual = ultimo; //APONTA PARA ULTIMO NO
       
        while(no_atual != raiz && !ehesquerdo(no_atual)){ //E
            no_atual = parent(no_atual); //ENQUANTO NÃO FOR FILHO DA ESQUERDA, PEGA O PAI
        }

        if(no_atual != raiz){
            no_atual = no_atual.getPai();
            if(!temdireito(no_atual)){
                no_atual.setFilhodireita(novo_no);
                novo_no.setPai(no_atual);
                ultimo = novo_no;
                tamanho++;
                upheap();
                return;
            }
            if(no_atual == raiz){
                no_atual = no_atual.getFilhodireita();
            }
            else if(ehesquerdo(no_atual)){
                no_atual =  no_atual.getFilhodireita();
            }else{
                no_atual =  no_atual.getFilhoequerda();
            }
        }

        while(!isExternal(no_atual)){
            no_atual = filhodaesquerda(no_atual); //ENQUANTO NÃO FOR FOLHA, DESCE PARA ESQUERDA
        }
        if(!temesquerdo(no_atual)){
            no_atual.setFilhoequerda(novo_no);
            novo_no.setPai(no_atual);
            ultimo = novo_no;
            tamanho++;
            upheap();
            return;
        }else{
            no_atual.setFilhodireita(novo_no);
            novo_no.setPai(no_atual);
            ultimo = novo_no;
            tamanho++;
            upheap();
            return;
        }
    }

    @Override
    public Object removeMin() {
        return null;
    }

    public void remove2(Object valor) {
        
        //swap(raiz, ultimo) 
        node no_atual = ultimo; //APONTA PARA ULTIMO NO
       
        while(no_atual != raiz && ehesquerdo(no_atual)){ //E
            no_atual = parent(no_atual); //ENQUANTO NÃO FOR FILHO DA ESQUERDA, PEGA O PAI
        }

            if(no_atual == raiz){
                while(!isExternal(no_atual)){
                    no_atual = filhodadireita(no_atual); //ENQUANTO NÃO FOR FOLHA, DESCE PARA DIREITA
                }
                if(ehesquerdo(ultimo)){
                    ultimo.getPai().setFilhoequerda(null);
                }else{
                    ultimo.getPai().setFilhodireita(null);
                }
                ultimo = no_atual;
                return;
            }
        
        no_atual = no_atual.getPai().getFilhoequerda(); //CASO FOR IRMAO DIREITO
        while(!isExternal(no_atual)){
                    no_atual = filhodadireita(no_atual); //ENQUANTO NÃO FOR FOLHA, DESCE PARA DIREITA
                }
        if(ehesquerdo(ultimo)){
            ultimo.getPai().setFilhoequerda(null);
        }else{
            ultimo.getPai().setFilhodireita(null);
        }
        ultimo = no_atual;
    }  
    public void insert2(Object valor) {
        
        node novo_no = new node(null, valor);
        node no_atual = ultimo; //APONTA PARA ULTIMO NO
       
        while(no_atual != raiz && !ehesquerdo(no_atual)){ //E
            no_atual = parent(no_atual); //ENQUANTO NÃO FOR FILHO DA ESQUERDA, PEGA O PAI
        }

            if(no_atual == raiz){
                while(!isExternal(no_atual)){
                    no_atual = filhodaesquerda(no_atual); //ENQUANTO NÃO FOR FOLHA, DESCE PARA esquerda
                }
                if(ehesquerdo(no_atual)){
                    no_atual.setFilhoequerda(novo_no);
                    novo_no.setPai(no_atual);
                    ultimo = novo_no;
                    return;
                }
            }
        
        if(no_atual.getPai().getFilhodireita() == null){
                    no_atual.getPai().setFilhodireita(novo_no);
                    novo_no.setPai(no_atual.getPai());
                    ultimo = novo_no;
                    return;
        }
        no_atual = no_atual.getPai().getFilhodireita();
        while(!isExternal(no_atual)){
                    no_atual = filhodaesquerda(no_atual); //ENQUANTO NÃO FOR FOLHA, DESCE PARA DIREITA
                }
            no_atual.getPai().setFilhodireita(novo_no);
            novo_no.setPai(no_atual.getPai());
            ultimo = novo_no;
            return;
        } 
}

