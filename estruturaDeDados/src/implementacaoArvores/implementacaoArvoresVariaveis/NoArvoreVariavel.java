package implementacaoArvores.implementacaoArvoresVariaveis;

public class NoArvoreVariavel <T> {
	private T info;
	private NoArvoreVariavel filho;
	private NoArvoreVariavel irmao;
	
	public NoArvoreVariavel(T info) {
		this.info = info;
		this.filho = null;
		this.irmao = null;	
	}
	public NoArvoreVariavel(T info, NoArvoreVariavel<T> filho, NoArvoreVariavel<T> irmao) {
		this.info = info;
		this.filho = filho;
		this.irmao = irmao;
	}
	
	public boolean pertence(T info) {
		if(info.equals(this.info)) {
			return true;
		}else {
			NoArvoreVariavel<T> tempFilho = this.filho;
			//checa tods os irmãos
			while(tempFilho != null) {
				if(tempFilho.equals(info)) {
					return true;
				}
				tempFilho = tempFilho.filho;
				
			};
			
			NoArvoreVariavel<T> tempIrmao = this.irmao;
			while(tempIrmao != null) {
				if(tempIrmao.info.equals(info)) {
					return true;
				}				
				tempIrmao = tempIrmao.irmao;
			}
			
			return false;
		}
	}
	
	public T getInfo() {
		return this.info;
	}
	
	public NoArvoreVariavel<T> getIrmao() {
		return this.irmao;
	}
	public NoArvoreVariavel<T> getFilho() {
		return this.filho;
	}
	
	public T insere(T info) {
		this.filho.info = info;
		return info;
	}
	


}
