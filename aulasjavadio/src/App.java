public class App {
     public static void main(String[] args) throws Exception {
        PilhaRN pilha = new PilhaRN();
        System.out.println(pilha.isEmptyP(pilha));
        System.out.println(pilha.isEmptyV(pilha));
        pilha.PushP(pilha, 3);
        pilha.PushP(pilha, 8);
        pilha.PushP(pilha, 9);
        pilha.PushV(pilha, 5);
        pilha.PushV(pilha, 6);
        pilha.PushV(pilha, 7);
        pilha.PushV(pilha, 11);
        pilha.PushV(pilha, 22);
       

        
        pilha.PrintPilha(pilha);
        System.out.println(pilha.getTpreto());

    }
}

class PilhaRN {
        private int tamanho = 5;
        private int tvermelho = 0;
        private int tpreto = 0;
        private int tgeral = 6;
        private int [] lista = new int[6];

        public int getTamanho() {
            return tamanho;
        }

        public int[] getLista() {
            return lista;
        }

        public int getTpreto() {
            return tpreto;
        }

        public int getTvermelho() {
            return tvermelho;
        }

        public void setTamanho(int tamanho) {
            this.tamanho = tamanho;
        }

        public void setTpreto(int tpreto) {
            this.tpreto = tpreto;
        }

        public void setTvermelho(int tvermelho) {
            this.tvermelho = tvermelho;
        }

        public void setLista(int[] lista) {
            this.lista = lista;
        }

        public void setTgeral(int tgeral) {
            this.tgeral = tgeral;
        }

        public int getTgeral() {
            return tgeral;
        }

    public int SizeP(PilhaRN lista){
        return lista.getTpreto();
    }

    public int SizeV(PilhaRN lista){
        return lista.getTvermelho(); //retorna tamanho da lista vermelha
    }

    public void PushV(PilhaRN lista, int num){
        if ((tvermelho + tpreto) == tgeral){
            DuplicateCapacity(lista);
        } 
        lista.lista[tvermelho] = num; //coloca na sequencia da lista preta
        lista.tvermelho++;
    }

    public void PushP(PilhaRN lista, int num){
        if ((tvermelho + tpreto) == tgeral){
            DuplicateCapacity(lista);
        } 
        lista.lista[tamanho] = num; //coloca na sequencia da lista preta
        tamanho--;
        lista.tpreto++;
    }

    public int TopV(PilhaRN lista){
        return lista.lista[tvermelho-1]; //ultimo item adcionado na lista vermelha
    }

    public int TopP(PilhaRN lista){
        return lista.lista[tamanho]; //ultimo item adcionado na lista vermelha
    }

    public int PopV(PilhaRN lista){
        lista.tvermelho--;
        return lista.lista[tvermelho];  //retira ultimo item e retorna o ultimo que ficou
    }

    public int PopP(PilhaRN lista){
        lista.tpreto--;
        return lista.lista[tamanho];  //retira ultimo item e retorna o ultimo que ficou
    }

    public boolean isEmptyV(PilhaRN lista){
        if (lista.tvermelho == 0){
            return true;
        }
        else return false;
    }

    public boolean isEmptyP(PilhaRN lista){
        if (lista.tpreto == 0){
            return true;
        }
        else return false;
    }

    public void PrintPilha(PilhaRN lista) {
		System.out.print("[");
		for(int i = 0; i < (lista.lista.length); i++) {
			System.out.print(" " + lista.lista[i]);
		}
		System.out.println(" ]");
	}
    
    public void DuplicateCapacity(PilhaRN lista){
        int new_itens[] = new int[lista.lista.length*2];
        int novo_tamanho = new_itens.length-1; // aponta para posição 11
        for(int i=0; i<tvermelho; i++){
            new_itens[i] = lista.lista[i];
        }

        for(int j=lista.lista.length-1; j>=tpreto; j--){
            new_itens[novo_tamanho] = lista.lista[j];
            novo_tamanho--;
        }
        tgeral *= 2;
        lista.tamanho = novo_tamanho;
        lista.lista = new_itens;
    }
}