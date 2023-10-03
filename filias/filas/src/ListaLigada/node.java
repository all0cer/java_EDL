package filas.src.ListaLigada;


public class node {
   private Object valor = null;
   private node next = null;
   private node prev = null;

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
}