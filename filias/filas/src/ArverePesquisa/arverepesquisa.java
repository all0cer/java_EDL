package filas.src.ArverePesquisa;

import java.util.Comparator;
import java.util.Iterator;

public class arverepesquisa implements Iarverepesquisa {
    no raiz;
    int tamanho;

    public arverepesquisa(Object elemento){
        raiz = new no(null, elemento);
        tamanho = 1;
    }

    @Override
    public Comparador getComparador() {
        
    }

    @Override
    public void setComparator(Comparator c) {
        
    }

    @Override
    public no pesquisar(no no, Object key) {
        
    }

    @Override
    public no incluir(Object key) {
        
    }

    @Override
    public Object remover(Object key) {
        
    }

    @Override
    public no getRaiz() {
        
    }

    @Override
    public void setRaiz(no p) {
        
    }

    @Override
    public void emOrdem(no node) {
        if (isInternal(node)){
            emOrdem(filhodaesquerda(node));
        }
        System.out.print(node.getElemento());
        if (isInternal(node)){
            emOrdem(filhodadireita(node));
        }
    }

    @Override
    public void preOrdem(no node) {
         System.out.println(node.getElemento());
         if (isInternal(node)){
            System.out.println(node.getElemento());
            posOrdem(filhodaesquerda(node));
            posOrdem(filhodadireita(node));
        }
    }

    @Override
    public void posOrdem(no node) {
        if (isInternal(node)){
            posOrdem(filhodaesquerda(node));
            posOrdem(filhodadireita(node));
        }
        System.out.println(node.getElemento());
    }

    @Override
    public int altura(no no) {
        
    }

    @Override
    public int profundidade(no no) {
        
    }

    @Override
    public void mostrar() {
        
    }

    @Override
    public Iterator nos() {
        
    }

    @Override
    public Iterator elements() {
       
    }

    @Override
    public int size() {
       
    }

    @Override
    public boolean isEmpty() {
        
    }

    // #### adicionais #####
    public no filhodaesquerda(no node){
        return node.getFilhoequerda();
    }

    public no filhodadireita(no node){
        return node.getFilhodireita();
    }

    public no temesquerdo(no node){
        return node.getFilhoequerda();
    }

    public no temdireito(no node){
        return node.getFilhodireita();
    }
    
    public boolean isExternal(no node){
        return (node.getFilhodireita() == null && node.getFilhoequerda() == null);
    }

    public boolean isInternal(no node){
        return (node.getFilhodireita() != null && node.getFilhoequerda() != null);
    }
}
