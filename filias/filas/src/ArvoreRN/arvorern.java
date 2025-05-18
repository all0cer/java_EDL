package filas.src.ArvoreRN;

import filas.src.AVL.nodeavl;

public class arvorern extends arverepesquisa {
    public arvorern(Object elemento){
        super(elemento);
        raiz = new NoRN(null, elemento);
        this.getRaiz().setCor(0);
    }


    public void inserir(NoRN novo_no){
        incluir(novo_no);
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


    public void mostrar() {
        int h = altura(raiz);
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
                    System.out.printf("%s[%d]", key, cor);
                    
                    // System.out.printf("%s", key);

                    // System.out.printf("%3d[%d]", no.getKey(), no.getFb());
                }
            }
            System.out.println();
        }
    }
}
