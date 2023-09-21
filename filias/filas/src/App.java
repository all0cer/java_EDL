package filas.src;
public class App {

	public static void main(String[] args) throws Exception{
		Fila f= new Fila(); 
		try{
          System.out.println("Inserção: ");
			f.enqueue(5);
			f.enqueue(6);
			System.out.println("Tamanho: " + f.size());
			System.out.println("Início: " + f.first());
			f.enqueue(7);
			f.dequeue();
			System.out.println("Tamanho: " + f.size());
			System.out.println("Início: " + f.first());
			f.PrintFila();
		
		}catch(FilaVaziaException erro){
			System.out.println(erro.getMessage());
			
		}
	}

}
