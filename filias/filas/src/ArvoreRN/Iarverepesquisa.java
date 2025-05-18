package filas.src.ArvoreRN;
import java.util.Iterator;

public interface Iarverepesquisa {

	comparadale getComparador();

	NoRN pesquisar(Object key,NoRN node);

	NoRN incluir(Object key);

	Object remover(Object key);

	NoRN getRaiz();

	void setRaiz(NoRN p);

	void emOrdem(NoRN no);

	void preOrdem(NoRN no);

	void posOrdem(NoRN no);

	int altura(NoRN no);

	int profundidade(NoRN no);

	void mostrar();

	Iterator nos();

	Iterator elements();

	int size();

	boolean isEmpty();

}