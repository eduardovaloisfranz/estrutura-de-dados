package implementacaoArvores.implementacaoArvoreBinariaComEncadeamento;

import implementacaoPilha.implementacaoComEncadeamento.*;

public class ArvoreBinariaComEncadeamento<T> {
	private NoArvore<?> raiz;
	private int counter;
	private static String toStringPorNivel;
	
	public ArvoreBinariaComEncadeamento() {
		this.raiz = null;
	}
	
	public NoArvore<T> insere(T info, NoArvore<T> filhoEsquerda, NoArvore<T> filhoDireita) {
		NoArvore<T> no = new NoArvore<T>(info, filhoEsquerda, filhoDireita);
		raiz = no;
		counter++;
		return no;
	}
	
	public boolean vazia() {
		return raiz == null ? true : false;
	}
	
	public boolean pertence(T info) {
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
	        if (raiz == null) 
	           return 0; 
	        else
	        { 	            
	            int alturaDireita = altura(raiz.getFilhoEsquerda()); 
	            int alturaEsquerda = altura(raiz.getFilhoDireita());
	              
	            
	            if (alturaEsquerda> alturaDireita) {
	            	return(alturaEsquerda+1);
	            	
	            }else
	            {
	            return(alturaDireita+1); 
	            	
	            }
	        } 
	    }	
		
	private String toStringPorNivel() {
		String texto = "";
		int altura = this.altura();

		if(ArvoreBinariaComEncadeamento.toStringPorNivel != null) {
			ArvoreBinariaComEncadeamento.toStringPorNivel = "";			
		}
		for(int i = 0; i <= altura; i++) {
			toStringPorNivel(raiz, i);			
		}		
		//System.out.println(ArvoreBinariaComEncadeamento.toStringPorNivel);
		return ArvoreBinariaComEncadeamento.toStringPorNivel;
	}
	
	private void toStringPorNivel(NoArvore raiz, int nivel) {
		String texto = "<";  		
		if (raiz == null) {
			return;
		}
	     if (nivel == 1) {        	
	    	 
	    	 texto += raiz.getInfo();	    	
	    	 
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
        
        // Check for empty tree 
        //if (raiz == null) 
             
        pilha.push(raiz); 
        NoArvore<?> anterior = null; 
        while (!pilha.isEmpty())  
        { 
            NoArvore<?> atual = pilha.top(); 
   
            /* go down the tree in search of a leaf an if so process it  
            and pop stack otherwise move down */
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
                    //list.add(current.data);
                    posOrdem +="<" + atual.getInfo() + ">";
                } 
   
                /* go up the tree from left node, if the child is right  
                   push it onto stack otherwise process parent and pop  
                   stack */
            }  
            else if (atual.getFilhoEsquerda() == anterior)  
            { 
                if (atual.getFilhoDireita()!= null) {
                	pilha.push(atual.getFilhoDireita());                	
                }
                else { 
                    pilha.pop(); 
                    //list.add(current.data);
                    posOrdem +="<" + atual.getInfo() + ">";
                } 
                   
                /* go up the tree from right node and after coming back 
                 from right node process parent and pop stack */
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
	
	@Override
	public String toString() {
		return "\nArvore Por nível: " + toStringPorNivel() + "\nPré Ordem: " + toStringPreOrdem() + "\nEm Ordem " + toStringEmOrdem() + "\nPos Ordem: " + toStringPosOrdem();
	}	
	
}

