package br.com.mhas.model;


public class Card {
	
	//attributes
	
	private int id;
	
	private String name;
	
	private int attack;
	
	private int defense;
	
	private String path_card;
	
	private String kingdom;
	
	private String mode;
	
	//constructor
	
	public Card(){
		
		this.id = 0;
	}
	
	public Card (int id, String name, int attack, int defense, String kingdom, String path_card) {
		
		this.id = id;
		
		this.name = name;
		
		this.attack = attack;
		
		this.defense = defense;
		
		this.kingdom = kingdom;
		
		this.path_card = path_card;
		
		this.mode = "";
	}

	//methods getters and setters
	
	public String getName() {
		
		return name;
	}

	public void setName(String name) {
		
		this.name = name;
	}

	public int getAttack() {
		
		return attack;
	}

	public void setAttack(int attack) {
		
		this.attack = attack;
	}

	public int getDefense() {
		
		return defense;
	}

	public void setDefense(int defense) {
		
		this.defense = defense;
	}
	
	public int getId(){
		
		return id;
	}
	
	public void setId(int id){
		
		this.id = id;
	}
	
	public String getPathCard(){
		
		return path_card;
	}
	
	public void setPathCard(String path_card){
		
		this.path_card = path_card;
	}
	
	public String getKingdom(){
		
		return kingdom;
	}
	
	public void setKingdom(String kingdom){
		
		this.kingdom = kingdom;
	}
	
	public String getMode(){
		
		return mode;
	}
	
	public void setMode(String mode){
		
		this.mode = mode;
	}
}
