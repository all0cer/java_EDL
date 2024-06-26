package filas.src.ArvoreRN;


public class arvorern extends arverepesquisa {
    public arvorern(Object elemento){
        super(elemento);
        raiz = new no(null, elemento);
        this.getRaiz().setCor(0);
    }

    public boolean soudireito(no filho){
        no pai = (no) filho.getPai();
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

    public boolean souesquerdo(no filho){
        no pai = (no) filho.getPai();
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

    public void caso2(no pai, no avo, no tio){
        if(avo != raiz){
            if(isExternal(tio) && avo.getPai().getCor() == 0){ //pinta o tio e o pai de negro, e o avo de rubro se o pai do avo for negro
                tio.setCor(0);
                pai.setCor(0);
                avo.setCor(1);
            }
            else if(isExternal(tio) && avo.getPai().getCor() == 1){ // se o pai do avo é rubro, repete passando o avo
                if(soudireito(tio)){ //checa se o tio passado é filho direito ou esquerdo para repetir o processo do lado certo
                    caso2(pai.getPai(), avo.getPai(), avo.getPai().getFilhoequerda());
                }
                else{
                    caso2(pai.getPai(), avo.getPai(), avo.getPai().getFilhodireita());
                }
            }
        }

    }

    @Override
    public no incluir(Object key) {
        no novo_no =  super.incluir(key);
        no avo = novo_no.getPai().getPai();
        if(novo_no.getPai().getCor() == 0){ //se o pai for negro CASO 1
            novo_no.setCor(1); //pinta nó de rubro para não alterar os negros da árvore
            return novo_no;
        }
        else if(avo != null){ //CHECAR CASO 2 SEM NÓ RAIZ E COM TIO DIFERENTE DE NULL
            if(novo_no.getPai().getCor() == 1 && avo.getCor() == 2){//Se o pai do novo nó é rubro e avô é negro
                if(soudireito(novo_no.getPai())){//Se o pai for filho direito, checar cor do tio (esquerda ou direita) se é rubro
                    if(avo.getFilhoequerda() != null || avo.getFilhoequerda().getCor() == 1){ //se o tio for rubro
                        //verificar casos nulos e com filhos
                        caso2(novo_no.getPai(), avo, avo.getFilhoequerda()); 
                    }
                    else{
                        if(avo.getFilhodireita() != null || avo.getFilhodireita().getCor() == 1){
                            caso2(novo_no.getPai(), avo, avo.getFilhodireita());
                        }
                    }
                }
                
            }
        }    

    }
}
