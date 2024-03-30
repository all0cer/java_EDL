package filas.src.ArvoreB;

import java.util.Vector;

import filas.src.Arveres.ArvoreSimples.No;

public class no {
    private int quantidade;
    private Vector<Integer> elementos;
    private Vector<no> filhos;
    private boolean ehfolha;

    // faz um nó com Ordem-1 de tamanho e array de filhos com Ordem tamanho ex: ordem = 3, cria array de elementos com até 2 de tamanho, e podendo ter 3 filhos ambos com valores nulos
    public no(int quantidade) {
        this.elementos = new Vector<Integer>(quantidade - 1);
        for (int i = 0; i < quantidade - 1; i++) {
            this.elementos.add(null);
        }
        this.filhos = new Vector<no>(quantidade);
        for (int i = 0; i < quantidade; i++) {
            this.filhos.add(null);
        }
        this.ehfolha = true;
        this.quantidade = 0;
    }

    public Vector<Integer> getElementos() {
        return elementos;
    }

    public void setElementos(Vector<Integer> elementos) {
        this.elementos = elementos;
    }

    public Vector<no> getFilhos() {
        return filhos;
    }
    
    public void setFilhos(Vector<no> filhos) {
        this.filhos = filhos;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean ehfolha(){
        return ehfolha;
    }

    public void setEhfolha(boolean ehfolha) {
        this.ehfolha = ehfolha;
    }
}
