package filas.src.desafios.somus;

import org.w3c.dom.ranges.RangeException;

public class Balde {
    int qtd;
    int capacidade;

    public Balde(int capacidade, int qtd) {
        if(capacidade < 0 || qtd < 0){
            System.out.println("Capacidade ou qtd invalido");
            //throw new IllegalArgumentException("Apenas valores positivos");
        } else if(qtd > capacidade){
            System.out.println("Quantidade maior que a capacidade");
            //throw new RuntimeException("Capacidade menor que a quantidade");
        }

        this.qtd = qtd;
        this.capacidade = capacidade;
    }
    public int getQtd() {
        return qtd;
    }
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    private void encher(int valor){
        if((this.qtd+valor) > capacidade && valor > 0){
            //throw new RuntimeException("Este valor passa do vaolr máximo permitido para este balde ou valor passado negativo");
            System.out.println("Valor menor que 0 ou ultrapasse a capacidade");
        }
        this.qtd += valor;
    }

    public void despejar(Balde outro, int litros){
        if((this.qtd - litros) < 0 && litros > 0){
            //throw new RuntimeException("Não há essa quantidade disponível para retirar do balde ou valor passado foi negativo");
            System.out.println("Quantidade indisponível para a retirada ou passagem de valor negativo");
        }
        try {
            outro.encher(litros);
            this.qtd = this.qtd - litros;
        } catch (RuntimeException e){
            System.out.println("Não foi possível despejar: " + e.getMessage());
            //throw new RuntimeException("O balde que será preenchido já está cheio");
        }
    }
}
