package implementacaoFila;

public interface Fila < T >{
	public void Insere(T obj);
	public T Retira();
	public boolean listaIsVazia();
	public void libera();	
	
}
