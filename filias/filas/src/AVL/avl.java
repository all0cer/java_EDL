package filas.src.AVL;

import filas.src.ArverePesquisa.arverepesquisa;
import filas.src.ArverePesquisa.no;
import filas.src.ArverePesquisa.comparadale;

public class avl extends arverepesquisa {

    comparadale compara = new comparadale();
    int tamanho = 0;
    nodeavl raiz;

    public avl(Object elemento) {
        super(elemento);
        raiz = new nodeavl(null, elemento);
        tamanho = 1;
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
    

    public boolean soudireito(nodeavl filho){
        nodeavl pai = (nodeavl) filho.getPai();
        if(pai.getFilhodireita() == null){
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
        if(filho == pai.getFilhoequerda()){
            return true;
        }
        else{
            return false;
        }
    }

    public void rds(nodeavl node){
        nodeavl filhoesquerdo = (nodeavl) node.getFilhoequerda();

        filhoesquerdo.setFilhodireita(node);
        filhoesquerdo.setPai(node.getPai()); //VAI SER CRIADO POR VÓ
        if(souesquerdo(node)){
            filhoesquerdo.getPai().setFilhoequerda(filhoesquerdo);
        }
        else{
            filhoesquerdo.getPai().setFilhodireita(filhoesquerdo);
        }

        node.setFilhoequerda(null);
        node.setPai(filhoesquerdo);

        
    }

    public void res(nodeavl node){
        nodeavl filhodireito = (nodeavl) node.getFilhodireita();

        filhodireito.setFilhoequerda(node);
        filhodireito.setPai(node.getPai()); //VAI SER CRIADO POR VÓ
        if(soudireito(node)){
            filhodireito.getPai().setFilhodireita(filhodireito);
        }
        else{
            filhodireito.getPai().setFilhoequerda(filhodireito);
        }

        node.setFilhodireita(null);
        node.setPai(filhodireito);
    }

    public void rotacao(nodeavl node){
        nodeavl filhoesquerdo = (nodeavl) node.getFilhoequerda();
        nodeavl filhodireito = (nodeavl) node.getFilhodireita();
        if(node.getFator() == -2 && filhodireito.getFator() > 0 ){
            //rotacao dupla direita
        }
        else if(node.getFator() == 2 && filhoesquerdo.getFator() < 0){
            //rotacao dupla esquerda
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
}

