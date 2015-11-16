package br.com.mhas.structure;

import br.com.mhas.model.Card;


public class Stack {
	
	//attributes
	
	private int size_stack;
	
	private NodeStack top_stack;
	
	//constructor
	
	public Stack(){
		
		top_stack = null;
		
		size_stack = 0;
	}
	
	//methods	
	
	public boolean pop(){
		
		if(size_stack == 0) return false;
		
		top_stack = top_stack.getNext();
		
		size_stack--;
		
		return true;
	}
	
	public boolean push(Object object){
		
		NodeStack node_stack = new NodeStack(object);
		
		node_stack.setNext(top_stack);
		
		top_stack = node_stack;
		
		size_stack++;
		
		return true;
	}
	
	//methods getters and setters

	public int getSizeStack() {
		
		return size_stack;
	}

	public void setSizeStack(int size_stack) {
		
		this.size_stack = size_stack;
	}
	
	public NodeStack getTopStack() {
		
		return top_stack;
	}

	public void setTopStack(NodeStack top_stack) {
			
		this.top_stack = top_stack;
	}
}
