package br.com.mhas.structure;

import br.com.mhas.model.Card;


public class NodeStack {
	
	//attributes
	
	private NodeStack next;
	
	private Object object;
	
	//constructor
	
	public NodeStack(Object type){
		
		this.object = type;
	}
	
	//methods getters and setters

	public NodeStack getNext() {
			
		return next;
	}

	public void setNext(NodeStack next) {
			
		this.next = next;
	}

	public Object getObject() {
		
		return object;
	}

	public void setObject(Card type) {
		
		this.object = type;
	}	
}
