package filas.src.ArvoreRN;
import java.util.Iterator;

public interface Iarverepesquisa {

	comparadale getComparador();

	no pesquisar(Object key,no node);

	no incluir(Object key);

	Object remover(Object key);

	no getRaiz();

	void setRaiz(no p);

	void emOrdem(no no);

	void preOrdem(no no);

	void posOrdem(no no);

	int altura(no no);

	int profundidade(no no);

	void mostrar();

	Iterator nos();

	Iterator elements();

	int size();

	boolean isEmpty();

}