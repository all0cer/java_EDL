package filas.src.FilaComPilha;

public interface IPilha {
	public int Size();
	public boolean isEmpty();
	public Object Top() throws EPilhaVazia;
	public void Push(Object o);
	public Object Pop() throws EPilhaVazia;
	public void PrintPilha();
    public void DuplicateTamanho();
}
