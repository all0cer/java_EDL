package filas.src.hashlinear;

public class testehash {
    public static void main(String[] args){
        hashlinear dicionario = new hashlinear();
        dicionario.InsertElement(14, "Santana");
        dicionario.InsertElement(14, "Thiago");
        dicionario.Elements();
        dicionario.Keys();
    }
}
