package filas.src.ArvoreRN;

import filas.src.AVL.nodeavl;
import filas.src.Sequencia.sequencia;

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

        else if(pai.getCor() == 1 && pai.getPai().getCor() == 0){ //CASO 2

            tio = pegaTio(pai, avo); 

            if(tio != null && tio.getCor() == 1 ){
                recolorir(tio, pai, avo); //FIM CASO 2
            } else{
                verificarRotacoes(noParaInserir, pai, tio, avo); //CASO 3
            }

        }
    }


    private NoRN pegaTio(NoRN pai, NoRN avo) {
        NoRN tio;
        if(avo.getFilhodireita() == pai){
            tio = avo.getFilhoequerda();
        }else{
            tio = avo.getFilhodireita();
        }
        return tio;
    }

    public void verificarRotacoes(NoRN noParaInserir, NoRN pai, NoRN tio, NoRN avo){
        if((tio == null  || tio.getCor() == 0) && avo.getCor() == 0 && pai.getCor() == 1){
            if(avo.getFilhodireita() == tio && pai.getFilhoequerda() == noParaInserir){ //CASO 3a
                rds(avo);
            }else if(avo.getFilhoequerda() == tio && pai.getFilhodireita() == noParaInserir){ //CASO 3b
                res(avo); 
            }
            else if(avo.getFilhoequerda() == tio && pai.getFilhoequerda() == noParaInserir ){//CASO 3c
                rds(avo.getFilhodireita());
                res(avo);
            } 
            else if(avo.getFilhodireita() == tio && pai.getFilhodireita() == noParaInserir){ //CASO 3d
                res(avo.getFilhoequerda());
                rds(avo);
            }
        }
       
    }


    public void rds(NoRN b){
        NoRN a = b.getFilhoequerda();
        
        System.out.println("deve ser 48: " + b.getFilhoequerda().getElemento());
        System.out.println("deve ser 50: " + a.getPai().getElemento());
    // Rotação à direita
        if(b == this.raiz){
            b.setFilhoequerda(a.getFilhodireita());
            if (a.getFilhodireita() != null) {
                a.getFilhodireita().setPai(b);
            }
            a.setFilhodireita(b);
            b.setPai(a);
            a.setCor(0);
            b.setCor(1);
            a.setPai(null);
            this.raiz = a;
            return;
        }

        if (a.getFilhodireita() != null) {
            a.getFilhodireita().setPai(b);
        }

        b.setFilhodireita(a.getFilhoequerda());
        a.setPai(b.getPai());
        a.setFilhodireita(b);
        if(b.getPai().getFilhoequerda() == b){
            b.getPai().setFilhoequerda(a);
        }else{
            (b.getPai()).setFilhodireita(a);
        }
        
        b.setPai(a);
       
        
       
        // Recoloração
        a.setCor(0);  // pai vira preto
        b.setCor(1);  // avo vira vermelho
        mostrar();
    }

    public void res(NoRN b) {
        NoRN a = b.getFilhodireita();
        
        // Rotação à esquerda
        if (b == this.raiz) {
            b.setFilhodireita(a.getFilhoequerda());
            if (a.getFilhoequerda() != null) {
                a.getFilhoequerda().setPai(b);
            }
            a.setFilhoequerda(b);
            b.setPai(a);
            a.setCor(0);
            b.setCor(1);
            this.raiz = a;
            return;
        }

        if (a.getFilhoequerda() != null) {
            a.getFilhoequerda().setPai(b);
        }

        a.setPai(b.getPai());

        if (b.getPai() != null) {
            if (b.getPai().getFilhoequerda() == b) {
                b.getPai().setFilhoequerda(a);
            } else {
                b.getPai().setFilhodireita(a);
            }
        }

        b.setFilhodireita(a.getFilhoequerda());
        a.setFilhoequerda(b);
        b.setPai(a);


        // Recoloração
        a.setCor(0);

        mostrar();
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

    
    public void removerrb(Object elemento){
        NoRN noParaRemover = pesquisar(elemento, raiz);
        NoRN sucessor;
        System.out.println(noParaRemover.getPai().getElemento());

        if(noParaRemover.getFilhodireita() == null){
            sucessor = noParaRemover.getFilhoequerda();
        }else{
            sucessor = encontraSucessor(noParaRemover);
        }

        if(isExternal(noParaRemover)){
            if(noParaRemover.getCor() == 1){
                remover(noParaRemover);
            } else{
                System.out.println("aqui é para ser pai de 50: " + noParaRemover.getPai().getElemento());
                remover(noParaRemover.getElemento());
                verificarRemocao();
            }
        }

        else if(noParaRemover.getCor() == 1 && sucessor.getCor() == 1){ //SITUAÇÃO 1
            remover(noParaRemover.getElemento());
        }
        
        else if(noParaRemover.getCor() == 0 && sucessor.getCor() == 1){//SITUAÇÃO 2
            sucessor.setCor(0);
            remover(noParaRemover.getElemento());
            
        }

        else if(noParaRemover.getCor() == 1 && sucessor.getCor() == 0){ // SITUAÇÃO 4
            sucessor.setCor(1);

            remover(noParaRemover.getElemento());
        }

        else if(noParaRemover.getCor() == 0 && sucessor.getCor() == 0){ //SITUAÇÃO 3
            remover(noParaRemover.getElemento());
            System.out.println(sucessor.getElemento());
            verificarRemocao(sucessor);
        }


        if(noParaRemover == raiz){
                this.raiz = sucessor;
        }
    }

    private void verificarRemocao(NoRN sucessor) {
        if(noParaRemover.getPai().getCor() == 0 && )
       
    }


    public NoRN encontraSucessor(NoRN no){
        NoRN atual = no.getFilhodireita();
        while(atual.getFilhoequerda() != null){
            atual = atual.getFilhoequerda();
        }
        return atual;
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

    public int contarNosPretosRecursivo(NoRN no) {
        if (no == null) {
            return 0; // Caso base: nó nulo não conta
        }

        int contador = 0;
        if (no.getCor() == 0) { // 0 representa a cor PRETA
            contador = 1;
        }

        // Soma recursivamente os nós pretos das subárvores esquerda e direita
        contador += contarNosPretosRecursivo(no.getFilhoequerda());
        contador += contarNosPretosRecursivo(no.getFilhodireita());

        return contador;
    }


    public boolean isRubroNegra(NoRN no){
        int is =  checkIsRubroNegra(no);
        return (is != -1);
    }

    private int checkIsRubroNegra(NoRN no) {
        if (no == null) {
            return 0; // Caso base: nó nulo não conta
        }


        int qtdNegroEsquerda = checkIsRubroNegra(no.getFilhoequerda());
        if(qtdNegroEsquerda == -1){
            return -1;
        }

        int qtdNegroDireita = checkIsRubroNegra(no.getFilhodireita());
        if(qtdNegroDireita == -1){
            return -1;
        }

        if(qtdNegroEsquerda != qtdNegroDireita){
            return -1;
        }

        
        return qtdNegroEsquerda + (no.getCor() == 0 ? 1 : 0);
    }



    public void mostrar() {
        int h = alturaRN(this.raiz);
        int nLinhas = h + 1;
        double nColunas = Math.pow(2, h + 1);

        Object[][] tabela = new Object[nLinhas][(int) nColunas];
        preencheTabela(this.raiz, tabela, 0, (int) nColunas / 2);

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
