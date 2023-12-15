package filas.src.hashlinear;

public class testehash {
    public static void main(String[] args){
        hashlinear dicionario = new hashlinear();
        System.out.println(dicionario.isEmpty());
        dicionario.InsertElement(14, "Santana"); //LINEAR
        dicionario.InsertElement(14, "Thiago"); //LINEAR
        dicionario.removeElement(14);
        dicionario.InsertElementDuplo(14, "Macarrao"); //HASHDUPLO
        dicionario.InsertElementDuplo(14, "Soco");
        dicionario.InsertElementDuplo(14, "Murro");
        dicionario.InsertElementDuplo(2, "Surto");
        dicionario.InsertElementDuplo(40, "Misterio");
        dicionario.InsertElementDuplo(22, "Douglas");
        dicionario.InsertElementDuplo(30, "Marta");
        dicionario.InsertElementDuplo(37, "Marta");
        dicionario.Elements();
        dicionario.Keys();
        System.out.println(dicionario.isEmpty());
    }
}
