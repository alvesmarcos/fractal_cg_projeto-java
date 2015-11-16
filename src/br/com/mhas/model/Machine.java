package br.com.mhas.model;


public class Machine extends Player {
	
	//constructor
	
	public Machine(){
		
		super();
		
		nickname = "MACHINE";
		
		firstLoadCards();
	}
	
	//methods
	
	public Card playMachineFirst(){
		
		Card card_select = null;
		
		int index = 0;
		
		card_select = pre_card[0];
		
		for(int i = 0 ; i < 5; i++){
			
			if(card_select.getAttack() <= pre_card[i].getAttack()){
				
				card_select = pre_card[i];
				
				index = i;
			}
		}
		
		pre_card[index] = onlyCard();
		
		card_select.setMode("attack");
		
		return card_select;
	}
	
	public Card playMachineSecond(Card card_player, String kingdom){
		
		Card card_select = null;
		
		int index = -1;
		
		card_select = pre_card[0];
		
		for(int i = 0 ; i < 5; i++){
			
			if(pre_card[i].getKingdom().equals(kingdom)){
				
				if(card_player.getAttack() <= pre_card[i].getAttack()){
					
					card_select = pre_card[i];
					
					card_select.setMode("attack");
					
					pre_card[i] = onlyCard();
					
					return card_select;
				
				} else {
					
					if(card_select.getDefense() <= pre_card[i].getDefense()){
						
						card_select = pre_card[i];
						
						index = i;
					}
				}
			} 
		}
		
		if(index == -1){
			
			for(int i = 0 ; i < 5; i++){

				if(card_select.getDefense() <= pre_card[i].getDefense()){
					
					card_select = pre_card[i];
					
					index = i;
				}
			}
		}
		
		card_select.setMode("defense");
		
		pre_card[index] = onlyCard();
				
		return card_select;
	}
}
