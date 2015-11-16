package br.com.mhas.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import br.com.mhas.engine.*;
import br.com.mhas.structure.NodeStack;
import br.com.mhas.structure.Stack;

public class Question implements IQuestions {
	
	//atributes
	
	private int id;
	
	private String path_question;
	
	private String path_alternativeA;
	
	private String path_alternativeB;
	
	private String path_alternativeC;
	
	private char answer;
	
	private Stack stack_question;
	
	
	//constructor
	
	public Question() {
		
		this.id = 0;
		
		stack_question = new Stack();
		
		loadStackQuestion();
	}
	
	public Question(int id, String path_question, String path_alternativeA, String path_alternativeB,
					String path_alternativeC, char answer) {
		
		this.id = id;
		
		this.path_question = path_question;
		
		this.path_alternativeA = path_alternativeA;
		
		this.path_alternativeB = path_alternativeB;
		
		this.path_alternativeC = path_alternativeC;
		
		this.answer = answer;
	}
	
	//methods
	
	public void loadStackQuestion(){
		
		Random random = new Random();
		
		List<Question> listAll = new ArrayList<Question>() ;
		
		for (int i = 0; i < SIZE_QUESTION ; i++) listAll.add(QUESTION_ARRAY[i]);
		
		int index = 0;
		
		boolean condition = true;
		
		int size = SIZE_QUESTION;
		
		while(condition){
			
			index = random.nextInt(SIZE_QUESTION);
		
			if(listAll.get(index) != null){
				
				stack_question.push(listAll.get(index));
				
				listAll.set(index, null);
				
				size--;
			}
			
			if(size == 0) condition = false;
		}
	}
	
	public Question onlyQuestion() {
		
		NodeStack aux = stack_question.getTopStack();
		
		stack_question.pop();
		
		if (aux == null) return null;
		
		return (Question) aux.getObject();
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
