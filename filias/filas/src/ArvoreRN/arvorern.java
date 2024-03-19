package filas.src.ArvoreRN;


public class arvorern extends arverepesquisa {
    public arvorern(Object elemento){
        super(elemento);
        raiz = new no(null, elemento);
        this.getRaiz().setCor(0);
    }

    @Override
    public no incluir(Object key) {
        no novo_no =  super.incluir(key);
        novo_no.setCor(1);
        return novo_no;

    }
}
