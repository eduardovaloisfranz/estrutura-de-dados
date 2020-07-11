package projetoFinalEstruturaDados.implementacaoArvoreBinariaBusca;
import projetoFinalEstruturaDados.implementacaoComEncadeamento.*;

public class ArvoreBinariaComEncadeamento<T> {
	private NoArvore<?> raiz;
	private int counter;	
	private static String toStringPorNivel;
	public static Integer[] toStringPorNivelArray;
	private static int idx = 0;
	
	public ArvoreBinariaComEncadeamento() {
		this.raiz = null;
	}
	
	public NoArvore<T> insere(T info, NoArvore<T> filhoEsquerda, NoArvore<T> filhoDireita) {
		NoArvore<T> no = new NoArvore<T>(info, filhoEsquerda, filhoDireita);
		raiz = no;
		counter++;
		return no;	
	}
	public void insereEmOrdem(T info) {
		this.raiz = inserirEmOrdem(this.raiz, info);
	}
	private NoArvore inserirEmOrdem(NoArvore raiz, T info) {
        if (raiz == null) { 
            raiz = new NoArvore(info, null, null);
           // this.counter++;            
            return raiz; 
        }
  
        if(info instanceof Integer) {      	
        	if ((Integer) info < (Integer) raiz.getInfo()) {        		
        		raiz.setFilhoEsquerda(inserirEmOrdem(raiz.getFilhoEsquerda(), info).getInfo());       
        		//this.counter++;
        	}
        	else if ((Integer) info > (Integer) raiz.getInfo()) {        		
        		raiz.setFilhoDireita(inserirEmOrdem(raiz.getFilhoDireita(), info).getInfo());
        		//this.counter++;
        	}
        }
        this.counter++;
        return raiz; 
	}
	
	public T insere(T info){
		caminharNiveis(info);
		return info;
	}
	private void caminharNiveis(T info) {
		int altura = altura();
		for(int i = 0; i <= altura; i++) {
			try {
				caminharNiveis(raiz, i, info);				
			}catch(Exception ex) {
				break;
			}
		}
	}
	private void caminharNiveis(NoArvore _raiz, int nivel, T info) throws Exception{
		if (_raiz == null) {
			return;
		}		
	     if (nivel == 1) {
	    	 if(_raiz.getFilhoEsquerda() == null) {	    		 
	    		 _raiz.setFilhoEsquerda(info); 		     		 
	    		 throw new Exception();	    		 
	    	 }
	    	 else if(_raiz.getFilhoDireita() == null) {
	    		 _raiz.setFilhoDireita(info);
	    		 throw new Exception();	    		 
	    	 }	    	 
	    	
	     }	        
	     else if (nivel > 1)  {
	    	 caminharNiveis(raiz.getFilhoEsquerda(), nivel-1, info);	        
	    	 caminharNiveis(raiz.getFilhoDireita(), nivel-1, info); 
	     }		
		
	}
	
	
	public boolean vazia() {
		return raiz == null ? true : false;
	}
	
	private boolean pertenceex(T info) {
		//igual exemplo, mas nessa arvore se testar o El 4 da nullpointer exception
		return pertence(this.raiz, info);
	}
	
	private boolean pertence(NoArvore<?> no, T info) {
		if(raiz == null) {
			return false;
		}else {
			return((no.getInfo().equals(info) || pertence(no.getFilhoEsquerda(), info) || pertence(no.getFilhoDireita(), info)));
		}
	}	
	
	public int altura() {
		return altura(this.raiz);
	}
	
	private int altura(NoArvore raiz) 
	    { 
	        if (raiz == null) {
	        	return 0;	        	
	        }
	        else{ 	            
	            int alturaDireita = altura(raiz.getFilhoEsquerda()); 
	            int alturaEsquerda = altura(raiz.getFilhoDireita());
	              
	            
	            if (alturaEsquerda> alturaDireita) {
	            	return(alturaEsquerda+1);
	            	
	            }else{
	            	return(alturaDireita+1);	            	
	            }
	        } 
	    }	
		
	private String toStringPorNivel() {
		int altura = this.altura();		
		ArvoreBinariaComEncadeamento.toStringPorNivel = "";		
		ArvoreBinariaComEncadeamento.toStringPorNivelArray = new Integer[this.counter + 1];		
		ArvoreBinariaComEncadeamento.idx = 0;
		for(int i = 0; i <= altura; i++) {
			toStringPorNivel(raiz, i);			
		}	
		
		return ArvoreBinariaComEncadeamento.toStringPorNivel;
	}
	
	
	
	private void toStringPorNivel(NoArvore raiz, int nivel) {
		String texto = "<";  		
		if (raiz == null) {
			return;
		}
	     if (nivel == 1) {	    	
	    	 texto += raiz.getInfo();	
	    	 if(raiz.getInfo() instanceof Integer) {	    		 
	    		 if(raiz.getInfo() != null) {	    			 
	    			 ArvoreBinariaComEncadeamento.toStringPorNivelArray[idx] = (Integer) raiz.getInfo();	    		 
	    			 ArvoreBinariaComEncadeamento.idx++;	    			 
	    		 }
	    	 }
	     }	        
	     else if (nivel > 1)  {	    	 
	        toStringPorNivel(raiz.getFilhoEsquerda(), nivel-1);	        
	        toStringPorNivel(raiz.getFilhoDireita(), nivel-1); 
	     }
	    
	    texto +=">";
	    toStringPorNivel += texto;  
	    
	}
	private String toStringPreOrdem() {
		String inPreOrdem = "";
		PilhaLista<NoArvore<?>> nodes = new PilhaLista<>();
		//Funciona com a minha implementação da PilhaEncadeada!
		nodes.push(raiz);
		
		while (!nodes.isEmpty()) {
		 NoArvore<?> atual= nodes.pop();
		      inPreOrdem += "<" + atual.getInfo() + ">";	      

		      if (atual.getFilhoDireita()!= null) {
		        nodes.push(atual.getFilhoDireita());
		      }
		      if (atual.getFilhoEsquerda()!= null) {
		        nodes.push(atual.getFilhoEsquerda());
		      }
		    }		
		return inPreOrdem;	
	}	
	
	public boolean pertence(T info) {
		  PilhaLista<NoArvore<?>> pilha = new PilhaLista<>(); 
	        NoArvore<?> atual = raiz; 
	  
	        while (atual != null || pilha.size() > 0) {   
	            while (atual!=  null){ 
	                pilha.push(atual); 
	                atual = atual.getFilhoEsquerda(); 
	            }         
	            
	            atual = pilha.pop();	            
	            if(info.equals(atual.getInfo())) {
	            	return true;
	            }
	            atual = atual.getFilhoDireita(); 
	        }
	    return false;
	       
	}
	
	private String toStringEmOrdem() {
		String inOrdem = "";
        PilhaLista<NoArvore<?>> pilha = new PilhaLista<>(); 
        NoArvore<?> atual = raiz; 
  
        while (atual != null || pilha.size() > 0) {   
            while (atual!=  null){ 
                pilha.push(atual); 
                atual = atual.getFilhoEsquerda(); 
            } 
            atual = pilha.pop();
            inOrdem += "<" + atual.getInfo() + ">";
            atual = atual.getFilhoDireita(); 
        } 
        return inOrdem;
		
	}
	
	private String toStringPosOrdem() {
		String posOrdem = "";
		PilhaLista<NoArvore<?>> pilha = new PilhaLista<>();      
        pilha.push(raiz); 
        NoArvore<?> anterior = null; 
        while (!pilha.isEmpty())  
        { 
            NoArvore<?> atual = pilha.top();    
            if (anterior == null || anterior.getFilhoEsquerda() == atual||  
                                        anterior.getFilhoDireita() == atual)  
            { 
                if (atual.getFilhoEsquerda()!= null) {
                	pilha.push(atual.getFilhoEsquerda());                	
                }
                else if (atual.getFilhoDireita()!= null) {
                	pilha.push(atual.getFilhoDireita());                	
                }
                else{ 
                    pilha.pop();                     
                    posOrdem +="<" + atual.getInfo() + ">";
                }    
            }  
            else if (atual.getFilhoEsquerda() == anterior)  
            { 
                if (atual.getFilhoDireita()!= null) {
                	pilha.push(atual.getFilhoDireita());                	
                }
                else { 
                    pilha.pop(); 
                    posOrdem +="<" + atual.getInfo() + ">";
                }                   
            }  
            else if (atual.getFilhoDireita() == anterior)  
            { 
                pilha.pop(); 
                posOrdem +="<" + atual.getInfo() + ">"; 
            }    
            anterior = atual; 
        } 
		
		return posOrdem;
	}
	
	public Integer[] toStringPorNivelVetor() {
		toStringPorNivel();		
		return toStringPorNivelArray;
	}
	
	public Integer[] toStringPreOrdemVetor() {
		Integer[] vet = new Integer[this.counter + 1];
		PilhaLista<NoArvore<?>> nodes = new PilhaLista<>();
		int idx = 0;
		nodes.push(raiz);
		
		while (!nodes.isEmpty()) {
		 NoArvore<?> atual= nodes.pop();
		      //inPreOrdem += "<" + atual.getInfo() + ">";	      
		 if(atual.getInfo() instanceof Number) {
			 vet[idx] = (Integer) atual.getInfo();
			 
		 }
		      if (atual.getFilhoDireita()!= null) {
		        nodes.push(atual.getFilhoDireita());
		      }
		      if (atual.getFilhoEsquerda()!= null) {
		        nodes.push(atual.getFilhoEsquerda());
		      }
		    }			
		
		return vet;
	}
	
	public Integer[] toStringEmOrdemVetor() {
		Integer[] vet = new Integer[this.counter + 1];
        PilhaLista<NoArvore<?>> pilha = new PilhaLista<>(); 
        NoArvore<?> atual = raiz; 
        int idx = 0;
        while (atual != null || pilha.size() > 0) {   
            while (atual!=  null){ 
                pilha.push(atual); 
                atual = atual.getFilhoEsquerda(); 
            } 
            atual = pilha.pop();
            //inOrdem += "<" + atual.getInfo() + ">";
            if(atual.getInfo() instanceof Number) {
            	vet[idx] = (Integer) atual.getInfo();
            	idx++;
            }
            atual = atual.getFilhoDireita(); 
        }       
		return vet;
	}
	
	
	@Override
	public String toString() {
		return "\nArvore Por nível: " + toStringPorNivel() + "\nPré Ordem: " + toStringPreOrdem() + "\nEm Ordem " + toStringEmOrdem() + "\nPos Ordem: " + toStringPosOrdem();
	}

	public void liberaRecursos() {
		this.counter = 0;
		this.raiz = null;
		
	}	
	
}

