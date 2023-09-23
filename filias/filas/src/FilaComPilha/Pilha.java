package filas.src.FilaComPilha;


public class Pilha implements IPilha{
    public int tamanho = -1;
    public Object dados[]; 

    public Pilha(int tam){
        dados = new Object[tam];
    }

    @Override
    public void Push(Object dado){
        if(tamanho == dados.length-1){
            DuplicateTamanho();
        }
    tamanho++;
    dados[tamanho] = dado;
    }

    @Override
    public Object Pop() throws EPilhaVazia{
        if(isEmpty()){
            throw new EPilhaVazia("A pilha não possui Elementos");
        }
    tamanho--;
    return dados[++tamanho];
    }

    @Override
    public int Size(){
        return tamanho;
    }

    @Override
    public Object Top() throws EPilhaVazia{
        if(isEmpty()){        throw new EPilhaVazia("A pilha não possui elementos");        }
        return dados[tamanho];
    }

    @Override
    public boolean isEmpty(){
        return tamanho==-1;
    }
    
    @Override
    public void DuplicateTamanho(){
        Object [] novos_dados = new Object[dados.length*2];
        int cont = 0;
        for (Object dado : dados) {
            novos_dados[cont] = dado;
            cont++;
        }
        dados = novos_dados;
    }

    @Override
    public void PrintPilha(){
        System.out.print("[");
        for (Object dado : dados) {
            System.out.print(dado + " ");            
        }
        System.out.println("]");
    }

}

