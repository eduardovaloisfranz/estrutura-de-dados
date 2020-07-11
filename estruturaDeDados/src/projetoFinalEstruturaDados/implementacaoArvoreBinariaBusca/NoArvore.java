package projetoFinalEstruturaDados.implementacaoArvoreBinariaBusca;

public class NoArvore<T> {
	private T info;
	private NoArvore<?> filhoEsquerda;
	private NoArvore<?> filhoDireita;
	
	public NoArvore(T info) {		
		this.info = info;
		this.filhoEsquerda = null;
		this.filhoDireita = null;
	}
	
	public NoArvore(T info, NoArvore<?> filhoEsquerda, NoArvore<?> filhoDireita) {
		this.info = info;
		this.filhoEsquerda = filhoEsquerda;
		this.filhoDireita = filhoDireita;
	}
	
	public NoArvore<?> getFilhoEsquerda() {
		return this.filhoEsquerda;
	}
	
	public void setFilhoEsquerda(T info) {
		NoArvore<T> no = new NoArvore<T>(info, null, null);
		this.filhoEsquerda = no;
	}
	
	public void setFilhoDireita(T info) {
		this.filhoDireita = new NoArvore<T>(info, null, null);
	}
	
	public void setFilhoEsquerdaNo(NoArvore no) {
		this.filhoEsquerda = no;
	}
	public void setFilhoDireitaNo(NoArvore no) {
		this.filhoDireita = no;
	}
	
	public void setInfo(T info) {
		this.info = info;
	}
	
	
	public NoArvore<?> getFilhoDireita(){
		return this.filhoDireita;
	}
	
	public T getInfo() {
		return this.info;
	}
	
	public boolean remove(Integer value, NoArvore no) {
        if (value < (Integer) this.info) {
              if (filhoEsquerda != null) {
            	  return filhoEsquerda.remove(value, this);            	  
              }else {
            	  return false;           	  
              }
        }else if (value > (Integer) this.info) {
              if (filhoDireita != null) {
            	  return filhoDireita.remove(value, this);           	  
              }else {
            	  return false;           	  
              }
      } else {
              if (filhoEsquerda != null && filhoDireita!= null) {
                    this.info = (T) filhoDireita.minValue();
                    filhoDireita.remove((Integer) this.info, this);

              } else if (no.filhoEsquerda == this) {
                    no.filhoEsquerda= (filhoEsquerda!= null) ? filhoEsquerda: filhoDireita;
              } else if (no.filhoDireita == this) {
                    no.filhoDireita= (filhoEsquerda!= null) ? filhoEsquerda: filhoDireita;
              }

              return true;

        }

  }
  public Integer minValue() {
        if (filhoEsquerda == null) {
        	return (Integer) info;        	
        }
        else {
        	return filhoEsquerda.minValue();        	
        }

  }
	


}
