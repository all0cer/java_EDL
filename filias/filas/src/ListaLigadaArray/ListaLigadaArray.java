package filas.src.ListaLigadaArray;

public class ListaLigadaArray implements IListaLigada {
    private int tamanho;
    private int capacidade;
    private Object[] dados;
    


    public ListaLigadaArray(int capac){
        this.capacidade = capac;
        this.tamanho = 0;
        this.dados = new Object[capac];
    }

    @Override
    public boolean isEmpty() {
        return tamanho == 0 ? true : false;
    }

    @Override
    public int size() {
       return tamanho;
    }

    @Override
    public Object first() {
       return dados[0];
    }

    @Override
    public Object last() {
        return dados[capacidade-1];
    }

    @Override
    public Object before(Object n) {
        for(int i = 0; i < dados.length; i++){
            if(dados[i] == n){
                return dados[i-1];
            }
        }
        return RuntimeException("Não está na lista");
    }
        

    @Override
    public Object after(Object n) {
        for(int i = 0; i < dados.length; i++){
            if(dados[i] == n){
                return dados[i+1];
            }
        }
        return RuntimeException("Não está na lista");
    }

    @Override
    public void replaceElement(int index1, Object elemento) {
        dados[index1] = elemento;
    }

    @Override
    public void swapElements(int index1, int index2) {
        Object temp = dados[index1];
        dados[index1] = dados[index2];
        dados[index2] = temp;
    }

    @Override
    public void insertBefore(int index, Object elemento) {
        if(tamanho == capacidade-1){
            DobrarTamanho();
        }
        for(int i = tamanho; i > index-1; i--){
            dados[i] = dados[i-1];
        }

        dados[index-1] = elemento;
        ++tamanho;
    }

    @Override
    public void insertAfter(int index, Object elemento) {
        if(tamanho == capacidade-1){
            DobrarTamanho();
        }
        for(int i = tamanho; i > index+1; i--){
            dados[i] = dados[i-1];
        }

        dados[index+1] = elemento;
        ++tamanho;
    }

    @Override
    public void insertFirst(Object elemento) {
        if(tamanho == capacidade-1){
            DobrarTamanho();
        }
        for(int i = tamanho; i > 0; i--){
            dados[i] = dados[i-1];
        }

        dados[0] = elemento;
        ++tamanho;
    }

    @Override
    public void insertLast(Object elemento) {
        if(tamanho == capacidade-1){
            DobrarTamanho();
        }
        dados[capacidade-1] = elemento;
        ++tamanho;
    }

    @Override
    public void remove(int index) {
        dados[index] = null;

        --tamanho;
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

    private Object RuntimeException(String string) {
        return null;
    }
}
