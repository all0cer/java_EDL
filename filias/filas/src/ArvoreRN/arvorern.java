package filas.src.ArvoreRN;

import filas.src.AVL.nodeavl;

public class arvorern extends arverepesquisa {
    public arvorern(Object elemento){
        super(elemento);
        raiz = new NoRN(null, elemento);
        this.getRaiz().setCor(0);
    }


    public void inserir(Object element){
        
        NoRN novo_no = new NoRN(null, element);
        if (this.getRaiz() == null) {
            novo_no.setCor(0);
            this.setRaiz(novo_no);
        } else {
            novo_no = incluir(element);
            novo_no.setCor(1);
            verificarInserir(novo_no);
        }

    }
    
    public void verificarInserir(NoRN noParaInserir){
        NoRN pai = noParaInserir.getPai();
        NoRN tio, avo = null;
        if(pai.getPai() != null){
            avo = pai.getPai();
        }

        if(pai.getCor() == 0){ //CASO 1, SE O PAI DO NÓ A SER INSERIDO FOR NEGRO, NADA PRECISA SER FEITO
            return;
        }
        if(pai.getCor() == 1 && pai.getPai().getCor() == 0){ //CASO 2
            if(avo.getFilhodireita() == pai){
                tio = avo.getFilhoequerda();
            }else{
                tio = avo.getFilhodireita();
            } 
            if(tio != null && tio.getCor() == 1 ){
                recolorir(tio, pai, avo); //FIM CASO 2
            } else{
                verificarRotacoes(noParaInserir, pai, tio, avo);
            }

        }
    }

    public void verificarRotacoes(NoRN noParaInserir, NoRN pai, NoRN tio, NoRN avo){
        if((tio == null  || tio.getCor() == 0) && avo.getCor() == 0 && pai.getCor() == 1){
            if(avo.getFilhodireita() == tio){
                rds(avo);
            }else{
                res(avo);
            }
            
        }
    }


    public void rds(NoRN avo){
        NoRN pai = avo.getFilhoequerda();

    // Rotação à direita
        if(avo == raiz){
            avo.setFilhoequerda(pai.getFilhodireita());
            if (pai.getFilhodireita() != null) {
                pai.getFilhodireita().setPai(avo);
            }
            pai.setFilhodireita(avo);
            pai.setCor(0);
            avo.setCor(1);
            raiz = pai;
            return;
        }

        if (pai.getFilhodireita() != null) {
            pai.getFilhodireita().setPai(avo);
        }

        pai.setPai(avo.getPai());
        pai.setFilhodireita(avo);
        avo.setPai(pai);

        // Recoloração
        pai.setCor(0);  // pai vira preto
        avo.setCor(1);  // avo vira vermelho
    }

    public void res(NoRN avo) {
    NoRN pai = avo.getFilhodireita();

    // Rotação à esquerda
    if (avo == raiz) {
        avo.setFilhodireita(pai.getFilhoequerda());
        if (pai.getFilhoequerda() != null) {
            pai.getFilhoequerda().setPai(avo);
        }
        pai.setFilhoequerda(avo);
        avo.setPai(pai);
        pai.setCor(0);
        avo.setCor(1);
        raiz = pai;
        return;
    }

    if (pai.getFilhoequerda() != null) {
        pai.getFilhoequerda().setPai(avo);
    }

    pai.setPai(avo.getPai());

    if (avo.getPai() != null) {
        if (avo.getPai().getFilhoequerda() == avo) {
            avo.getPai().setFilhoequerda(pai);
        } else {
            avo.getPai().setFilhodireita(pai);
        }
    }

    pai.setFilhoequerda(avo);
    avo.setPai(pai);

    // Recoloração
    pai.setCor(0);
    }

    public void recolorir(NoRN tio, NoRN pai, NoRN avo){
        tio.setCor(0);
        pai.setCor(0);
        if(avo != raiz){
            avo.setCor(1);
        }
        
        if(avo != raiz && avo.getPai().getCor() != 0){
            verificarInserir(avo);
        }
    }

    public void preencheTabela(NoRN no, Object[][] tabela, int linha, int coluna) {
        if (no == null)
            return;

        tabela[linha][coluna] = no;

        int offset = (int) Math.pow(2, tabela.length - linha - 2);

        if (no.getFilhoequerda() != null) {
            preencheTabela(no.getFilhoequerda(), tabela, linha + 1, coluna - offset);
        }

        if (no.getFilhodireita() != null) {
            preencheTabela(no.getFilhodireita(), tabela, linha + 1, coluna + offset);
        }
    }

    public int alturaRN(NoRN node) {
        if(isExternal(node) || node == null){
            return 0;
        }
        else{
            int alturaesquerda = alturaRN((NoRN) filhodaesquerda(node));
            int alturadireita = alturaRN((NoRN) filhodadireita(node));

            return Math.max(alturaesquerda, alturadireita) + 1;
        }
    }

    public void mostrar() {
        int h = alturaRN(raiz);
        int nLinhas = h + 1;
        double nColunas = Math.pow(2, h + 1);

        Object[][] tabela = new Object[nLinhas][(int) nColunas];
        preencheTabela(raiz, tabela, 0, (int) nColunas / 2);

        for (int i = 0; i < nLinhas; i++) {
            for (int j = 0; j < (int) nColunas; j++) {
                if (tabela[i][j] == null)
                    System.out.print("   ");
                else {
                    NoRN no = (NoRN) tabela[i][j];
                    Object key =  no.getElemento();
                    String cor;
                    cor = (no.getCor() == 1) ? "R" : "N";
                    System.out.printf("%s[%s]", key, cor);
                    
                    // System.out.printf("%s", key);

                    // System.out.printf("%3d[%d]", no.getKey(), no.getFb());
                }
            }
            System.out.println();
        }
    }
}
