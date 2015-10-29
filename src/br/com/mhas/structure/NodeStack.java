package br.com.mhas.structure;

import br.com.mhas.model.Card;

/** 
 * 	Função: Nó da pilha
 * 
 *  Data Criação: 22/06/2015
 *  
 *  Data Modificação: 22/06/2015
 *  
 * **/


public class NodeStack {
	
	//attributes
	
	private NodeStack next;
	
	private Card type;
	
	//constructor
	
	public NodeStack(Card type){
		
		this.type = type;
	}
	
	//methods getters and setters

	public NodeStack getNext() {
			
		return next;
	}

	public void setNext(NodeStack next) {
			
		this.next = next;
	}

	public Card getType() {
		
		return type;
	}

	public void setType(Card type) {
		
		this.type = type;
	}	
}
