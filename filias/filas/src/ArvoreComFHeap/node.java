package filas.src.ArvoreComFHeap;

public class node {
    private Object elemento;

    private node pai;
    private node filhoequerda;
    private node filhodireita;

    public node(node pai, Object element){
        this.pai = pai;
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
    public node getPai() {
        return pai;
    }
    public void setPai(node pai) {
        this.pai = pai;
    }
    public node getFilhoequerda() {
        return filhoequerda;
    }
    public void setFilhoequerda(node filhoequerda) {
        this.filhoequerda = filhoequerda;
    }
    public node getFilhodireita() {
        return filhodireita;
    }
    public void setFilhodireita(node filhodireita) {
        this.filhodireita = filhodireita;
    }
}

