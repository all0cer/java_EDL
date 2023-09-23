package filas.src.FilaComPilha;

public class App {
    public static void main(String[] args) throws Exception{
        Pilha pp= new Pilha(10);
		System.out.println("inserindo");
		for(int f=0;f<11;f++){
			  System.out.println(f);		  
			  pp.Push(f);
			}
		pp.PrintPilha();
        System.out.println("retirando");
		for(int f=0;f<1;f++){
			  System.out.print(f);
			  System.out.println(" - "+pp.Pop());
		}
		
		pp.PrintPilha();
		pp.isEmpty();
		pp.PrintPilha();
    }
}
