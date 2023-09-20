public class App {

	public static void main(String[] args) throws Exception{
		Fila f= new Fila(); //criando fila tamnho 1 e duplicação
		try{
            System.out.println(f.isEmpty());
			f.enqueue(3);
			System.out.println(f.first());
			System.out.println(f.size());
		
		}catch(FilaVaziaException erro){
			System.out.println(erro.getMessage());
			
		}
	}

}
