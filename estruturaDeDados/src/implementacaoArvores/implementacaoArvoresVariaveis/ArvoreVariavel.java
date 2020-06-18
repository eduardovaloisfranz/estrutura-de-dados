package implementacaoArvores.implementacaoArvoresVariaveis;

public class ArvoreVariavel <T>{
	private NoArvoreVariavel<T> raiz;
	private static String perLevel = "";
	
	public NoArvoreVariavel<T> insere(T info, NoArvoreVariavel<T> filho, NoArvoreVariavel<T> irmao) {
		NoArvoreVariavel<T> no = new NoArvoreVariavel(info, filho, irmao);
		this.raiz = no;
		return no;
	}
	
	private String toStringPorNivel() {
		toStringPorNivel(raiz);
		return perLevel;
	}
	
	
	private void toStringPorNivel(NoArvoreVariavel no) {
		
		if(no== null) {
			return;		
		}
			
        while(no != null){           
        	
        	perLevel +="[ " + no.getInfo() + " ]";        	
            
            if(no.getFilho() != null) {
            	toStringPorNivel(no.getFilho());            	
            }    
            no = no.getIrmao();
        } 
		
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Arvore Por Nível: " + toStringPorNivel();
	}
	
	public boolean pertence(T info) {
		return this.raiz.pertence(info);
	}
	
	public boolean vazia() {
		return raiz == null ? true : false;
	}
	
	public void libera() {
		this.raiz = null;
	}
}
