package projetoFinalEstruturaDados.implementacaoArvoreBinariaBusca;
import projetoFinalEstruturaDados.implementacaoComEncadeamento.*;

public class ArvoreBinariaComEncadeamento<T> {
	private NoArvore<?> raiz;
	public int counter;	
	private static String toStringPorNivel;
	public static Integer[] toStringPorNivelArray;
	private static int idx = 0;
	
	public ArvoreBinariaComEncadeamento() {
		this.raiz = null;
	}	

	public void insereEmOrdem(T info) {
		if(counter > 1) {
			inserirEmOrdem(this.raiz, info);
		}else {
			this.raiz = inserirEmOrdem(this.raiz, info);		
			
		}
		this.counter++;
	}
	public void removerElemento(Integer info) {
		if(removerElementoAux(info)) {
			this.counter--;
		}else {
			System.out.println("Elemento Não Encontrado");
		}
	}
	
	 private boolean removerElementoAux(Integer value) {
         if (raiz == null) {        	 
        	 return false;     
         }
         else {
        	 if (raiz.getInfo() == value) {
                     NoArvore auxRoot = new NoArvore(0, null, null);
                     auxRoot.setFilhoEsquerdaNo(raiz);
                     boolean result = raiz.remove(value, auxRoot);
                     raiz = auxRoot.getFilhoEsquerda();
                     return result;
               } else {
                     return raiz.remove(value, null);                     
               }
         }
         

   }
	private NoArvore inserirEmOrdem(NoArvore raiz, T info) {
     
	    NoArvore no = new NoArvore(info, null, null); 	   
	    NoArvore x = raiz;  	   
	    NoArvore y = null;  
	    
	    while (x != null) {  
	        y = x;  
	        if(info instanceof Integer) {	        	
	        	if ((Integer) info < (Integer) x.getInfo()) {
	        		x = x.getFilhoEsquerda();
	        	}
	        	else {
	        		x = x.getFilhoDireita();
	        	}	
	        }
	    } 
	    if (y == null) {
	    	y = no;
	    	
	    }	    
	    else if ((Integer) info < (Integer) y.getInfo()) {
	    	y.setFilhoEsquerdaNo(no);
	    	
	    }	    
	    else {
	    	y.setFilhoDireitaNo(no);
	    }
	    return y;  
	}
		
	public boolean vazia() {
		return raiz == null ? true : false;
	}
		
	public int altura() {
		return altura(this.raiz);
	}
	
	private int altura(NoArvore raiz){ 
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
		ArvoreBinariaComEncadeamento.toStringPorNivelArray = new Integer[this.counter];		
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
	
	public Integer[] toStringPosOrdemVetor() {
		Integer[] vet = new Integer[this.counter];
		PilhaLista<NoArvore<?>> pilha = new PilhaLista<>();      
        pilha.push(raiz); 
        NoArvore<?> anterior = null; 
        int index = 0;
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
                    if(atual.getInfo() != null) {
                    	vet[index] = (Integer) atual.getInfo();
                    	index++;                    	
                    }
                }    
            }  
            else if (atual.getFilhoEsquerda() == anterior)  
            { 
                if (atual.getFilhoDireita()!= null) {
                	pilha.push(atual.getFilhoDireita());                	
                }
                else { 
                    pilha.pop(); 
                    if(atual.getInfo() != null) {
                    	vet[index] = (Integer) atual.getInfo();
                    	index++;                    	
                    }
                }                   
            }  
            else if (atual.getFilhoDireita() == anterior){ 
                pilha.pop(); 
                if(atual.getInfo() != null) {
                	vet[index] = (Integer) atual.getInfo();
                	index++;                	
                }
            }    
            anterior = atual; 
        } 
		
		return vet;	
	}
	
	public Integer[] toStringPreOrdemVetor() {
		Integer[] vet = new Integer[this.counter];
		PilhaLista<NoArvore<?>> nodes = new PilhaLista<>();
		int idxAUX = 0;
		nodes.push(raiz);
		
		while (!nodes.isEmpty()) {
		 NoArvore<?> atual= nodes.pop();
		 if(atual.getInfo() instanceof Number) {
			 if(atual != null) {
				 vet[idxAUX] = (Integer) atual.getInfo();
				 idxAUX++;			 
			 }
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
		Integer[] vet = new Integer[this.counter];
        PilhaLista<NoArvore<?>> pilha = new PilhaLista<>(); 
        NoArvore<?> atual = raiz; 
        int idx = 0;
        while (atual != null || pilha.size() > 0) {   
            while (atual!=  null){ 
                pilha.push(atual); 
                atual = atual.getFilhoEsquerda(); 
            } 
            atual = pilha.pop();
            if(atual.getInfo() instanceof Number) {
            	if(atual.getInfo() != null) {
            		vet[idx] = (Integer) atual.getInfo();
            		idx++;           		
            	}
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

