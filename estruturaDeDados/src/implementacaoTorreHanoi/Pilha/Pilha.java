package implementacaoTorreHanoi.Pilha;

public interface Pilha <T>{
	public void push(T el);
	public T pop();
	public boolean isEmpty();
	public void clear();
	public T top();
	public void showStack();
	public boolean elementIsBiggerThanActualElement(T obj);
	public boolean isFull();
	public int getTam();
	public void push();
}
