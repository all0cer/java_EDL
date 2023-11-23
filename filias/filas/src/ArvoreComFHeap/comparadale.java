package filas.src.ArvoreComFHeap;
import java.util.Comparator;

public class comparadale implements Comparator{

    @Override
    public int compare(Object primeiro, Object segundo) {
        if((Integer)primeiro  < (Integer)segundo){
            return -1;
        }
        else if((Integer)primeiro == (Integer)segundo){
            return 0;
        }
        else{
            return 1;
        }
    }
}
