package filas.src.skiplistx;

public class node{
    private Object valor;
    private node right;
    private node left;
    private node up;
    private node down;

    public node(Object valor){
        this.valor = valor;
    }

    public Object getDown() {
        return down;
    }

    public Object getLeft() {
        return left;
    }

    public Object getRight() {
        return right;
    }

    public Object getUp() {
        return up;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(node valor) {
        this.valor = valor;
    }

    public void setDown(node down) {
        this.down = down;
    }

    public void setLeft(node left) {
        this.left = left;
    }

    public void setRight(node right) {
        this.right = right;
    }

    public void setUp(node up) {
        this.up = up;
    }

}