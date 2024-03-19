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



    @Override
    public no incluir(Object key) {
        no novo_no =  super.incluir(key);
        no avo = novo_no.getPai().getPai();
        if(novo_no.getPai().getCor() == 0){ //se o pai for negro CASO 1
            novo_no.setCor(1); //pinta nó de rubro para não alterar os negros da árvore
            return novo_no;
        }
        else if(avo != null){ //CHECAR CASO 2
            if(novo_no.getPai().getCor() == 1 && avo.getCor() == 2){//Se o pai do novo nó é rubro e avô é negro
                if(soudireito(novo_no.getPai())){//Se o pai for filho direito, checar cor do tio (esquerda ou direita) se é rubro
                    if(avo.getFilhoequerda().getCor() == 1){ //se o tio for rubro
                        //verificar casos nulos e com filhos
                        caso2(novo_no.getPai(), avo, avo.getFilhoequerda()); 
                    }
                }
                else{
                    if(avo.getFilhodireita().getCor() == 1){
                        caso2(novo_no.getPai(), avo, avo.getFilhodireita());
                    }
                }
            }
        }    

    }
}
