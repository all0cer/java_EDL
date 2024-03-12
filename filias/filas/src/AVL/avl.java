package filas.src.AVL;

import filas.src.ArverePesquisa.arverepesquisa;
import filas.src.ArverePesquisa.no;
import filas.src.ArverePesquisa.comparadale;

public class avl extends arverepesquisa {

    comparadale compara = new comparadale();

    public avl(Object elemento) {
        super(elemento);
    }

    @Override
    public no incluir(Object key) {
        return super.incluir(key);
    }

    public boolean soudireito(nodeavl filho){
        nodeavl pai = (nodeavl) filho.getPai();
        if(filho == pai.getFilhodireita()){
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
        
    }

    public void res(nodeavl node){
        nodeavl filhodireito = (nodeavl) node.getFilhodireita();

        filhodireito.setFilhoequerda(node);
        filhodireito.setPai(node.getPai()); //VAI SER CRIADO POR VÓ

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
           nodeavl no_pai = (nodeavl )novo.getPai();
            if(soudireito(novo)){
                no_pai.setFator(no_pai.getFator()-1);
                if(no_pai.getFator() == 2 || no_pai.getFator() == -2){
                    rotacao(no_pai);
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
                }
                else if (resultado == -1){
                    no_pai.setFator(no_pai.getFator()+1);
                }
            }
        }
    }
    
}
