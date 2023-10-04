package filas.src.Vector;

public class VetorLL implements Ivector{
    private node fim;
    private node inicio;
    private int tamanho = -1;

    public VetorLL(){
        this.inicio = null;
        this.fim = null;
    }

    @Override
    public Object elemAtRank(int r) {
        node atual = inicio.getNext();
        for(int i=0; i < r; i++){
            atual = atual.getNext();
        }
        return atual.getValor();
    }

    @Override
    public Object replaceAtRank(int r, Object o) {
        return dados[r] = o;
    }

    @Override
    public void insertAtRank(int r, Object o) {
        

    @Override
    public Object removeAtRank(int r) {
        Object tempo = dados[r];
        for(int i = r; i < dados.length-1; i++){
            dados[i] = dados[i+1];
        }

        --quantidade;
        return tempo;
    }

    @Override
    public int size() {
        return quantidade;
    }

    @Override
    public boolean isEmpty() {
        return quantidade == 0 ? true : false;
    }

    public void DobrarTamanho(){ 
			Object novos_dados[] = new Object[capacidade*2];
			for(int i = 0; i < capacidade; i++) {
				novos_dados[i] = dados[i];
			} 
        dados = novos_dados;   
        capacidade *= 2;
        }


    public void PrintVector() {
		System.out.print("[ ");
		for(int i = 0; i < capacidade ; i++) {
			System.out.print(dados[i] + ",");
		}
		System.out.println("]");
    }
}
