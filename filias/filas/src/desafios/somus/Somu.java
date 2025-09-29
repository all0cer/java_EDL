package filas.src.desafios.somus;

public class Somu {
    public static void main(String[] args){
        Balde balde8litros = new Balde(8, 8);
        Balde balde5litros = new Balde(5, 0);
        Balde balde3litros = new Balde(3, 0);



        balde8litros.despejar(balde5litros, 5);
        balde5litros.despejar(balde3litros, 3);
        balde5litros.despejar(balde8litros, 2);
        balde3litros.despejar(balde5litros, 3);
        balde8litros.despejar(balde5litros, 1);

        System.out.println(balde8litros.qtd);
        System.out.println(balde5litros.qtd);
        System.out.println(balde3litros.qtd);


        //CHECAR CONSTRUTOR

        //Criar balde com litros maior que capacidade
        Balde balde2litros = new Balde(2, 4);
        //Criar Balde com valores Negativos
        Balde baldexlitros = new Balde(-1, 0);
        Balde balde1litros = new Balde(1, -1);

        //CHECAR DESPEJAR
        //Encher balde com mais que a capacidade
        Balde balde4litros = new Balde(4, 4);
        Balde balde6litros = new Balde(6, 2);
        balde6litros.despejar(balde4litros, 2);

        //Encher balde com valor que não é possível retirar
        Balde balde10litros = new Balde(10, 2);
        Balde balde12litros = new Balde(12, 2);
        balde10litros.despejar(balde12litros, 3);




    }
}
