package filas.src.ArverePesquisa;
import java.util.Comparator;

public class comparadale implements Comparator<no>{

    @Override
    public int compare(no primeiro, no segundo) {
        if((Integer)primeiro.getElemento() < (Integer)segundo.getElemento()){
            return 1;
        }
        else if((Integer)primeiro.getElemento() == (Integer)segundo.getElemento()){
            return 0;
        }
        else{
            return -1;
        }
    }
}
