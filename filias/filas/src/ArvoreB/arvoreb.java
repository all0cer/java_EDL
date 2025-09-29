package filas.src.ArvoreB;

import filas.src.Arveres.ArvoreSimples.No;

public class arvoreb {
    private no raiz; 
    private int ordem; 
    private int qtdElementos; 

    
    public arvoreb(int ordem) {
        this.raiz = new no(ordem);
        this.ordem = ordem;
        qtdElementos = 0;
    }
    
    public int insert(int valor){
        if(Buscar(raiz, valor) != null){//Se o valor inserido ainda não existir na árvore
            no no_atual = raiz;
            if(no_atual.getQuantidade() < (ordem*2)-1){//Inserir se não for estourar o tamanho
                no_atual.getElementos().set(no_atual.getQuantidade()+1, valor); //Coloca o valor na posição livre
                no_atual.setQuantidade(no_atual.getQuantidade() + 1); //Atualiza nova quantidade
                return no_atual.getQuantidade();
            }
            if(no_atual.getQuantidade() == (ordem*2)-1){
                DividirArrays(no_atual);
            }

        }return valor;
    }


    public no Buscar(no no_atual, int valor){
        int i = 0;
        //Enquanto novo valor for maior, vai percorrendo o array, se o valor estiver no nó, retorna o nó.
        while(i <= no_atual.getQuantidade() && valor > no_atual.getElementos().get(i)){
            //Se o valor for igual um dos elementos do array de elementos, retorna o nó.
            if(valor == no_atual.getElementos().get(i)){
                return no_atual;
            }
            else{
                i++;
            }
        }
        //Se o valor não estiver naquele nó, procura no array de filhos
        if(!no_atual.ehfolha()){
            Buscar(no_atual.getFilhos().get(i), valor);
        }
        //Se for folha e ainda não tiver encontrado, retorna null.
        return null;
    }

    public void DividirArrays(no no_dividir){

    }
}
