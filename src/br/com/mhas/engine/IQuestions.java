package br.com.mhas.engine;

import br.com.mhas.model.Question;

public interface IQuestions {
	
	public static final int SIZE_QUESTION = 15;
	
	public static final Question [] QUESTION_ARRAY = { new Question(1, "/question1.png", "/q1-alternativeA", "/q1-alternativeB", "/q1-alternativeC", '#'), 
															
														   new Question(2, "/question2.png", "/q2-alternativeA", "/q2-alternativeB", "/q2-alternativeC", '#'),
														   
														   new Question(3, "/question3.png", "/q3-alternativeA", "/q3-alternativeB", "/q3-alternativeC", '#'), 
														   
														   new Question(4, "/question4.png", "/q4-alternativeA", "/q4-alternativeB", "/q4-alternativeC", '#'),
														   
														   new Question(5, "/question5.png", "/q5-alternativeA", "/q5-alternativeB", "/q5-alternativeC", '#'), 
														   
														   new Question(6, "/question6.png", "/q6-alternativeA", "/q6-alternativeB", "/q6-alternativeC", '#'),
														   
														   new Question(7, "/question7.png", "/q7-alternativeA", "/q7-alternativeB", "/q7-alternativeC", '#'),
														   
														   new Question(8, "/question8.png", "/q8-alternativeA", "/q8-alternativeB", "/q8-alternativeC", '#'),
														   
														   new Question(9, "/question9.png", "/q9-alternativeA", "/q9-alternativeB", "/q9-alternativeC", '#'),
														   
														   new Question(10, "/question10.png", "/q10-alternativeA", "/q10-alternativeB", "/q10-alternativeC", '#'), 
														   
														   new Question(11, "/question11.png", "/q11-alternativeA", "/q11-alternativeB", "/q11-alternativeC", '#'),
														   
														   new Question(12, "/question12.png", "/q12-alternativeA", "/q12-alternativeB", "/q12-alternativeC", '#'),
														   
														   new Question(13, "/question13.png", "/q13-alternativeA", "/q13-alternativeB", "/q13-alternativeC", '#'),
														   
														   new Question(14, "/question14.png", "/q14-alternativeA", "/q14-alternativeB", "/q14-alternativeC", '#'),
														   
														   new Question(15, "/question15.png", "/q15-alternativeA", "/q15-alternativeB", "/q15-alternativeC", '#')};
}
