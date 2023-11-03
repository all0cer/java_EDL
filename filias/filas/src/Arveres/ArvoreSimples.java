package filas.src.Arveres;

import java.util.Iterator;
import java.util.List;

import javax.management.InvalidAttributeValueException;


import java.util.ArrayList;


public class ArvoreSimples
{
	//Atributos da �rvore
	No raiz;
	int tamanho;
	//Construtor
	public  ArvoreSimples(Object o)
	{
		raiz = new No(null, o);
		tamanho = 1;
	}
	/** Retorna a raiz da �rvore */
	public No root()
	{
		return raiz;
	}
	/** Retorna o No pai de um No */
	public No parent(No v)
	{
		return (v.parent());
	}

	/** retorna os filhos de um No */
	public Iterator<No> children(No v)
	{
		return v.children();
	}
	/** Testa se um No � interno */
	public boolean isInternal(No v)
	{
		return (v.childrenNumber() > 0);
	}
	/** Testa se um No � externo*/
	public boolean isExternal(No v)
	{
		return (v.childrenNumber() == 0);
	}
	/** Testa se um No � a raiz */
	public boolean isRoot(No v)
	{
		return v == raiz;
	}
	/** Adiciona um filho a um No 
	
	/** Remove um No
	 *  S� pode remover Nos externos e que tenham um pai (n�o seja raiz)
	*/
	public Object remove(No v) throws InvalidAttributeValueException
	{
		No pai = v.parent();
		if (pai != null || isExternal(v))
			pai.removeChild(v);
		else
			throw new InvalidAttributeValueException();
		Object o = v.element();
		tamanho--;
		return o;
	}
	/** Troca dois elementos de posi��o */
	public void swapElements(No v, No w)
	{		
		   Object temp = v.element();
	       v.setElement(w.element());
		   w.setElement(temp);
	}
	/** Retorna a profundidade de um No */
	public int depth(No v)
	{
		int profundidade = profundidade(v);
		return profundidade;
	}

	private int profundidade(No v)
	{
		if (v == raiz)
			return 0;
		else
			return 1 + profundidade(v.parent());
	}

	public int height(No v)
	{
		if(isExternal(v)){
			return 0;
		}
		else{
			int altura = 0;
			Iterator<No> w = v.children();
			while(w.hasNext()) {
				altura = Math.max(altura, height(w.next()));
			}
			return 1+altura;
		}
	}
	/** Retorna um iterator com os elementos armazenados na �rvore */
	public void preOrdena(No v, List<Object> elementsList) {
        if (v != null) {
            elementsList.add(v.element()); // Adiciona o elemento do nó atual à lista
            Iterator<No> children = v.children();
            while (children.hasNext()) {
                preOrdena(children.next(), elementsList); // Recursivamente visita os filhos
            }
		}
	}

	public Iterator<Object> elements()
	{
		List<Object> elementsList = new ArrayList<Object>();
    	preOrdena(root(), elementsList);
    	return elementsList.iterator();
	}
	
	

	private void preOrdernaNos(No v, List<Object> elemList) {
        if (v != null) {
            elemList.add(v); // Adiciona o nó atual à lista
            Iterator<No> children = v.children();
            while (children.hasNext()) {
                preOrdernaNos(children.next(), elemList); // Recursivamente visita os filhos
            }
        }
    }
	/** Retorna um iterator com as posi��es (Nos) da �rvore */
	public Iterator<Object> Nos()
	{
		List<Object> elemList = new ArrayList<Object>();
		preOrdernaNos(root(), elemList);
		return elemList.iterator();
	}
	/** Retorna o n�mero de Nos da �rvore
	 */
	public int size()
	{
		return tamanho;
	}
	/** Retorna se a �vore est� vazia. Sempre vai ser falso, pois n�o permitimos remover a raiz
	 */
	public boolean isEmpty()
	{
		return false;
	}
	public Object replace(No v, Object o)
	{
	    Object temp = v.element();
		v.setElement(o);
		return temp;
	}
	/* In�cio da classe aninhada para armazenar o No*/
	public class No 
	{
		private Object o;
		private No pai;
		private ArrayList<No> filhos = new ArrayList<>();
		public No(No pai, Object o)
		{
			this.pai = pai;
			this.o = o;
		}

		public Object element()
		{
			return o;
		}

		public No parent()
		{
			return pai;
		}

		public void setElement(Object o)
		{
			this.o = o;
		}

		public void addChild(No o)
		{
			filhos.add(o);
		}

		public void removeChild(No o)
		{
			filhos.remove(o);
		}

		public int childrenNumber()
		{
			return filhos.size();
		}

		public Iterator<No> children()
		{
			return filhos.iterator();
		}
	}
	/* Fim da classe aninhada para armazenar o No */
}
