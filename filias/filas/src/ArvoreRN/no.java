package filas.src.ArvoreRN;

public class no {
    private Object elemento;
    private no pai;
    private no filhoequerda;
    private no filhodireita;
    private int cor; //1 = vermelho, 0 = negro

    public no(no pai, Object element){
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
    public no getPai() {
        return pai;
    }
    public void setPai(no pai) {
        this.pai = pai;
    }
    public no getFilhoequerda() {
        return filhoequerda;
    }
    public void setFilhoequerda(no filhoequerda) {
        this.filhoequerda = filhoequerda;
    }
    public no getFilhodireita() {
        return filhodireita;
    }
    public void setFilhodireita(no filhodireita) {
        this.filhodireita = filhodireita;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }

    public int getCor() {
        return cor;
    }
}
