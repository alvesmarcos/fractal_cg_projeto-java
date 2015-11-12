package br.com.mhas.model;

public class Question {
	
	//atributes
	
	private int id;
	
	private String path_question;
	
	private String path_alternativeA;
	
	private String path_alternativeB;
	
	private String path_alternativeC;
	
	private char answer;
	
	//constructor
	
	public Question(int id, String path_question, String path_alternativeA, String path_alternativeB,
					String path_alternativeC, char answer) {
		
		this.id = id;
		
		this.path_question = path_question;
		
		this.path_alternativeA = path_alternativeA;
		
		this.path_alternativeB = path_alternativeB;
		
		this.path_alternativeC = path_alternativeC;
		
		this.answer = answer;
	}

	//methods getters and setters
	
	public int getId() {
		
		return id;
	}

	public String getPathQuestion() {
		
		return path_question;
	}

	public String getPathAlternativeA() {
		
		return path_alternativeA;
	}

	public String getPathAlternativeB() {
		
		return path_alternativeB;
	}

	public String getPathAlternativeC() {
		
		return path_alternativeC;
	}

	public char getAnswer() {
		
		return answer;
	}	
}
