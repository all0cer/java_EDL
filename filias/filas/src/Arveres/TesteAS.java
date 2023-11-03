package filas.src.Arveres;
import java.util.Iterator;

import filas.src.Arveres.ArvoreSimples.No;
public class TesteAS {
    public static void main(String[] args) {
        ArvoreSimples arvore = new ArvoreSimples(4);

        ArvoreSimples.No raiz = arvore.root();
       

        // Testando os métodos
         System.out.println("Profundidade da raiz: " + arvore.depth(raiz));
         System.out.println("Altura da árvore: " + arvore.height(raiz));

         System.out.println("Elementos da árvore:");
         Iterator<Object> elementos = arvore.elements();
        while (elementos.hasNext()) {
        Object no = elementos.next();
        System.out.println(no);
        }

        System.out.println("Nós da árvore:");
        Iterator<Object> nos = arvore.Nos();
        while (nos.hasNext()) {
            ArvoreSimples.No no = (No) nos.next();
            System.out.println(no.element());
        }
    }
};

