package filas.src.ArvoreRN;

public class NoRN {
    private Object elemento;
    private NoRN pai;
    private NoRN filhoequerda;
    private NoRN filhodireita;
    private int cor; //1 = vermelho, 0 = negro

    public NoRN(NoRN pai, Object element){
        this.pai = pai;
        this.cor = 1;
        this.elemento = element;
        this.filhodireita = null;
        this.filhoequerda = null;
    }
    
    public Object getElemento() {
        return elemento;
    }
    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
    public NoRN getPai() {
        return pai;
    }
    public void setPai(NoRN pai) {
        this.pai = pai;
    }
    public NoRN getFilhoequerda() {
        if(filhoequerda == null){
            return null;
        }
        return filhoequerda;
    }
    public void setFilhoequerda(NoRN filhoequerda) {
        this.filhoequerda = filhoequerda;
    }
    public NoRN getFilhodireita() {
        if(filhodireita == null){
            return null;
        }
        return filhodireita;
    }
    public void setFilhodireita(NoRN filhodireita) {
        this.filhodireita = filhodireita;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }

    public int getCor() {
        return cor;
    }
}
