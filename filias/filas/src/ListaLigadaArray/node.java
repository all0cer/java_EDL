package filas.src.ListaLigadaArray;


public class node {
   private Object valor;
   private node next;
   private node prev;

   public node(Object valor){
        this.valor = valor;
    }
    
   public Object getValor() {
       return valor;
   }

   public node getNext() {
       return next;
   }

   public node getPrev() {
       return prev;
   }

   public void setNext(node next) {
       this.next = next;
   }

   public void setPrev(node prev) {
       this.prev = prev;
   }

   public void setValor(Object valor) {
       this.valor = valor;
   }

   @Override
    public String toString() {
        return "" +  valor;
    }
}