package filas.src.AVL;

import filas.src.ArverePesquisa.no;

public class nodeavl extends no{

    private int fator;

    public nodeavl(no pai, Object element) {
        super(pai, element);
    }

    public int getFator() {
        return fator;
    }

    public void setFator(int fator) {
        this.fator = fator;
    }

}