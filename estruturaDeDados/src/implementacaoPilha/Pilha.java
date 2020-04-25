package implementacaoPilha;

public interface Pilha <T>{
	public void push(T el);
	public T pop();
	public boolean isEmpty();
	public void clear();
	public T top();
}
