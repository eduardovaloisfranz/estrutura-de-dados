package implementacaoTorreHanoi.Pilha;

public class ObjetoTorre {
	private String info = "";
	public ObjetoTorre(int qtd) {
		for(int i = 0; i < qtd; i++) {
			this.info += "-";
		}
		this.info += "Quantidade: " +qtd;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.info;
	}
	
	public int getLengthOfInfo() {
		return this.info.length();
	}
}
