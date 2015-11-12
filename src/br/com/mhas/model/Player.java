package br.com.mhas.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.mhas.engine.ICardType;
import br.com.mhas.structure.NodeStack;
import br.com.mhas.structure.Stack;


public class Player implements ICardType {
	
	//attributes
	
	protected Card[] pre_card = new Card[5];
	
	private static final int MAX_LIFE = 500;
	
	protected String nickname;
	
	protected int life;
	
	protected Stack stack_card;
	
	protected List<Card> listAll;
	
	//constructor
	
	public Player() {
		
		this.nickname = "";
		
		life = MAX_LIFE;
		
		listAll = new ArrayList<Card>();
		
		stack_card = new Stack();
		
		loadListCard();
	}
	
	//methods
	
	public Card [] firstLoadCards() {
		
		loadStackCard();
		
		NodeStack aux = stack_card.getTopStack();
		
		for(int i = 0 ; i < 5; i++) {
			
			pre_card[i] = new Card();
			
			pre_card[i] = aux.getType();
				
			aux = aux.getNext();
			
			stack_card.pop();
		}
		
		return pre_card;
	}
	
	private void loadListCard(){
		
		for(int i = 0 ; i < SIZE_CARD; i++) listAll.add(CARD_ARRAY[i]);
	}
	
	protected void loadStackCard(){
		
		Random random = new Random();
		
		int index = 0;
		
		boolean condition = true;
		
		int size = SIZE_CARD;
		
		while(condition){
			
			index = random.nextInt(SIZE_CARD);
		
			if(listAll.get(index) != null){
				
				stack_card.push(listAll.get(index));
				
				listAll.set(index, null);
				
				size--;
			}
			
			if(size == 0) condition = false;
		}
	}
	
	public Card onlyCard(){
		
		NodeStack aux = stack_card.getTopStack();
		
		stack_card.pop();
		
		return aux.getType();
	}

	//methods getters and setters
	
	public String getNickname() {
		
		return nickname;
	}

	public void setNickname(String nickname) {
		
		this.nickname = nickname;
	}

	public int getLife() {
		
		return life;
	}

	public void setLife(int life) {
		
		this.life -= life;
	}	
}