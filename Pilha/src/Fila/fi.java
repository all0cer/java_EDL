public class testeFila {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fila f=new Fila(1,0); //criando fila tamnho 1 e duplicação
		f.enqueue(1);
		f.enqueue(2);
		f.enqueue(3);
		f.enqueue(4);
		try{
			System.out.println(f.first());
			f.dequeue();
			System.out.println(f.first());
			f.dequeue();
			System.out.println(f.first());
			f.dequeue();
			System.out.println(f.first());
			f.dequeue();
			System.out.println(f.first());
			f.dequeue();
		
		}catch(FilaVaziaException erro){
			System.out.println(erro.getMessage());
			
		}
	}

}


class FilaVaziaException extends RuntimeException {
	    public FilaVaziaException(String err){
	       super(err); 
	    }   
}


interface IFila {
	    public abstract void enqueue(Object o);
	    public abstract Object dequeue();
	    public Object first();
	    public abstract int size();
	    public abstract boolean isEmpty();
}

class Fila implements IFila{

    @Override
    public void enqueue(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enqueue'");
    }

    @Override
    public Object dequeue() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dequeue'");
    }

    @Override
    public Object first() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'first'");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    
}

