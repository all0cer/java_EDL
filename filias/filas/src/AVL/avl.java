package filas.src.AVL;

import filas.src.ArverePesquisa.arverepesquisa;
import filas.src.ArverePesquisa.no;
import filas.src.ArvoreComFHeap.node;
import filas.src.ArverePesquisa.comparadale;
import java.math.*;
import java.util.ArrayList;

import org.w3c.dom.Node;

public class avl extends arverepesquisa {

    comparadale compara = new comparadale();
    int tamanho = 0;
    nodeavl raiz;

    public avl(Object elemento) {
        super(elemento);
        raiz = new nodeavl(null, elemento);
        this.tamanho = 1;
    }

    @Override
    public nodeavl getRaiz(){
        return this.raiz;
    }

    public nodeavl incluiravl(Object elemento){
        nodeavl no_atual = raiz;
        nodeavl novo_no = new nodeavl(null, elemento);
        while (true) {
            int resultado = compara.compare(novo_no.getElemento(), no_atual.getElemento());

            if (resultado < 0) {
                if ((nodeavl) filhodaesquerda(no_atual) == null) {
                    no_atual.setFilhoequerda(novo_no);
                    novo_no.setPai(no_atual);
                    tamanho++;
                    att(novo_no);
                    return novo_no;
                }
                else{
                    no_atual = (nodeavl) filhodaesquerda(no_atual);
                }
            }

            else if (resultado > 0){
                if ((nodeavl)filhodadireita(no_atual) == null) {
                    no_atual.setFilhodireita(novo_no);
                    novo_no.setPai(no_atual);
                    tamanho++;
                    att(novo_no);
                    return novo_no;
                }
                else{
                    no_atual = (nodeavl) filhodadireita(no_atual);
                }
            }

        }
    }

    public nodeavl pesquisaravl(Object key, nodeavl node) {

        if (node == null){
            return null;
        }
        if(compara.compare(key, node.getElemento()) < 0){
            return pesquisaravl(key, (nodeavl) node.getFilhoequerda());
        }

        else if(compara.compare(key, node.getElemento()) > 0){
                return pesquisaravl(key, (nodeavl) node.getFilhodireita());
            }

        else{
            return node;
        }
        
    }

    public Object remover(Object key) {
        nodeavl noexcluir = pesquisaravl(key, raiz);
        if (isExternal(noexcluir)){ //CASO DE NÓ SEM FILHOS
            if(noexcluir.getPai().getFilhoequerda() == noexcluir){
                noexcluir.getPai().setFilhoequerda(null);
                return noexcluir.getElemento();
            }
            else{
                noexcluir.getPai().setFilhodireita(null);
                return noexcluir.getElemento();
            }
        }
        else if (noexcluir.getFilhodireita() != null && noexcluir.getFilhoequerda() != null){ //NÓ COM DOIS FILHOS
                nodeavl substitui = sucessoravl((nodeavl) filhodadireita(noexcluir));
                noexcluir.setElemento(substitui.getElemento());
                remover(sucessoravl(substitui));
                return noexcluir.getElemento();
        }
        else{
            nodeavl filho = (noexcluir.getFilhoequerda() != null) ? (nodeavl) noexcluir.getFilhoequerda(): (nodeavl) noexcluir.getFilhodireita(); //NÓ COM UM FILHO
            filho.setPai(noexcluir.getPai()); //VOU SER CRIADO POR VÓ
            if(noexcluir.getPai().getFilhoequerda() == noexcluir){
                noexcluir.getPai().setFilhoequerda(filho);
                return noexcluir.getElemento();
            }
            else{
                noexcluir.getPai().setFilhodireita(filho);
                return noexcluir.getElemento();
            }
        }

    
    }

    private nodeavl sucessoravl(nodeavl node){
        while ((nodeavl) node.getFilhoequerda() != null) {
            node = (nodeavl) node.getFilhoequerda();
        }
        return node;
    }

    public int max(int fb, int zero){
        if(fb > zero){
            return fb;
        }
        else{
            return zero;
        }
    }
    
    public int min(int fb, int zero){
        if(fb < zero){
            return fb;
        }
        else{
            return zero;
        }
    }

    public boolean soudireito(nodeavl filho){
        nodeavl pai = (nodeavl) filho.getPai();
        if(pai == null){
            return false;
        }
        else if(pai.getFilhodireita() == null){
            return false;
        }
        else if(filho == pai.getFilhodireita()){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean souesquerdo(nodeavl filho){
        nodeavl pai = (nodeavl) filho.getPai();
        if(pai == null){
            return false;
        }
        else if(filho == pai.getFilhoequerda()){
            return true;
        }
        else{
            return false;
        }
    }

    public void rds(nodeavl node){
        nodeavl filhoesquerdo = (nodeavl) node.getFilhoequerda();

        int novo_fb = node.getFator() + 1 - min(filhoesquerdo.getFator(), 0);
        int novo_fa = filhoesquerdo.getFator() + 1 + max(novo_fb, 0);

        node.setFator(novo_fb);
        filhoesquerdo.setFator(novo_fa);

        
        if(node.getPai() == null){    
            filhoesquerdo.setPai(null);
            node.setFilhoequerda(filhoesquerdo.getFilhodireita());
            if(filhoesquerdo.getFilhodireita() != null){
                filhoesquerdo.getFilhodireita().setPai(node);
            }
            filhoesquerdo.setFilhodireita(node);
            node.setPai(filhoesquerdo);
            this.raiz = filhoesquerdo;
        } 
        else{
            filhoesquerdo.setPai(node.getPai());
            node.setFilhoequerda(filhoesquerdo.getFilhodireita());
            node.setPai(filhoesquerdo);
            filhoesquerdo.setFilhodireita(node);
            if(soudireito(node)){
                filhoesquerdo.getPai().setFilhodireita(filhoesquerdo);   
            }
            else{
            filhoesquerdo.getPai().setFilhoequerda(filhoesquerdo);
            }    
        }
        
    }

    public void res(nodeavl node){
        nodeavl filhodireito = (nodeavl) node.getFilhodireita();

        int novo_fb = node.getFator() + 1 - min(filhodireito.getFator(), 0);
        int novo_fa = filhodireito.getFator() + 1 + max(novo_fb, 0);

        node.setFator(novo_fb);
        filhodireito.setFator(novo_fa);

        
        if(node.getPai() == null){    
            filhodireito.setPai(null);
            node.setFilhodireita(filhodireito.getFilhoequerda());
            if(filhodireito.getFilhoequerda() != null){
                filhodireito.getFilhoequerda().setPai(node);
            }
            filhodireito.setFilhoequerda(node);
            node.setPai(filhodireito);
            this.raiz = filhodireito;
        } 
        else{
            filhodireito.setPai(node.getPai());
            node.setFilhodireita(filhodireito.getFilhoequerda());
            node.setPai(filhodireito);
            filhodireito.setFilhoequerda(node);
            if(soudireito(node)){
                filhodireito.getPai().setFilhodireita(filhodireito);
            }
            else{
                filhodireito.getPai().setFilhoequerda(filhodireito);
            }

        }
        

        
    }

    public void rdd(nodeavl node){
        res((nodeavl) node.getFilhoequerda());
        rds(node);

    }

    public void rde(nodeavl node){
        rds((nodeavl) node.getFilhodireita());
        res(node);
    }

    public void rotacao(nodeavl node){
        nodeavl filhoesquerdo = (nodeavl) node.getFilhoequerda();
        nodeavl filhodireito = (nodeavl) node.getFilhodireita();
        if(node.getFator() == -2 && filhodireito.getFator() > 0 ){
            //rotacao dupla esquerda
            rde(node);
        }
        else if(node.getFator() == 2 && filhoesquerdo.getFator() < 0){
            //rotacao dupla direita
            rdd(node);
        }
        else if(node.getFator() == -2){
            //rotacao esquerda simples
            res(node);
        }
        else if(node.getFator() == 2){
            //rotacao direita simples
            rds(node);
        }
    }

    public void att(nodeavl novo){
        while(true){
           nodeavl no_pai = (nodeavl)novo.getPai();
            if(soudireito(novo)){
                no_pai.setFator(no_pai.getFator()-1);
                if(no_pai.getFator() == 2 || no_pai.getFator() == -2){
                    rotacao(no_pai);
                    break;
                }
                if(no_pai.getFator() == 0 || no_pai == (nodeavl) getRaiz()){
                    break;
                }
                novo = (nodeavl) novo.getPai();
            }
            else if(souesquerdo(novo)){
                no_pai.setFator(no_pai.getFator()+1);
                if(no_pai.getFator() == 2 || no_pai.getFator() == -2){
                    rotacao(no_pai);
                    break;
                }
                if(no_pai.getFator() == 0 || no_pai == (nodeavl) getRaiz()){
                    break;
                }
                novo = (nodeavl) novo.getPai();
            }
            else if(no_pai == (nodeavl) getRaiz()){
                int resultado = compara.compare(novo, no_pai);

                if(resultado == 1){
                    no_pai.setFator(no_pai.getFator()-1);
                    break;
                }
                else if (resultado == -1){
                    no_pai.setFator(no_pai.getFator()+1);
                    break;
                }
            }
        }
    }

    public int alturaavl(nodeavl node) {
        if(isExternal(node)){
            return 0;
        }
        else{
            int alturaesquerda = alturaavl((nodeavl) filhodaesquerda(node));
            int alturadireita = alturaavl((nodeavl) filhodadireita(node));

            return Math.max(alturaesquerda, alturadireita) + 1;
        }
    }

    public void emOrdemavl(nodeavl node) {
        if (node == null) {
             System.out.print("null, "); // Se o nó for nulo, retorna sem fazer mais nada
             return;
        }

        if (isInternal(node)){
            emOrdemavl((nodeavl)filhodaesquerda(node));
        }

    System.out.print(node.getElemento() + ", ");
    

        if (isInternal(node)){
            emOrdemavl((nodeavl)filhodadireita(node));
        }
    }


    public int profundidadeavl(nodeavl node) {
        if(node == raiz){
            return 0;
        }
        else{
            return 1+profundidade(node.getPai());
        }
    }

    public int getTamanho(){
        return this.tamanho;
    }

    public void mostraravl() {
        mostraravl(raiz, "");
    }
    
    private void mostraravl(nodeavl node, String espaco) {
        if (node == null) {
            return;
        }
        System.out.println(espaco + node.getElemento());
    
        if (node.getFilhoequerda() != null || node.getFilhodireita() != null) {
            mostraravl((nodeavl) node.getFilhoequerda(), espaco + "    ");
            mostraravl((nodeavl) node.getFilhodireita(), espaco + "    ");
        }
    }
}

