public class App {

	public static void main(String[] args) throws Exception{
		Fila f= new Fila(); //criando fila tamnho 1 e duplicação
		try{
            System.out.println(f.isEmpty());
			f.enqueue(3);
            f.enqueue(4);
            f.enqueue(5);
            f.enqueue(6);
            f.enqueue(7);
            f.enqueue(5);
            f.enqueue(8);
			System.out.println(f.first());
			System.out.println(f.size());
            f.PrintFila();
		
		}catch(FilaVaziaException erro){
			System.out.println(erro.getMessage());
			
		}
	}

}
