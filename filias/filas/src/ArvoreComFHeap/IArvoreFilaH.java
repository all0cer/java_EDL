package filas.src.ArvoreComFHeap;

import java.util.Iterator;
import filas.src.ArvoreComFHeap.node;

public interface IArvoreFilaH {
    comparadale getComparador();

	node pesquisar(Object key,node node );

	Object remover(Object key);

	node getRaiz();

	void setRaiz(node p);

	void emOrdem(node node);

	void preOrdem(node node);

	void posOrdem(node node);

	int altura(node node);

	int profundidade(node node);

	void mostrar();

	Iterator nos();

	Iterator elements();

	int size();

	boolean isEmpty();

    void Insert(Object valor); // REFERENCIA ULTIMO NO, WHILE (É filho esquerda?) se for pega o irmao, desce para esquerda

    Object removeMin();

    Object Min();

    void upheap();

    void downheap();
}
