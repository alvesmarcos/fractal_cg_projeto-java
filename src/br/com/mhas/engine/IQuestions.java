package br.com.mhas.engine;

import br.com.mhas.model.Question;

public interface IQuestions {
	
	public static final int SIZE_QUESTION = 15;
	
	public static final int TIMER = 10;
	
	public static final Question [] QUESTION_ARRAY = { new Question(1, "/question1.png", "/q1-alternativeA.png", "/q1-alternativeB.png", "/q1-alternativeC.png", 'c'), 
															
														   new Question(2, "/question2.png", "/q2-alternativeA.png", "/q2-alternativeB.png", "/q2-alternativeC.png", 'a'),
														   
														   new Question(3, "/question3.png", "/q3-alternativeA.png", "/q3-alternativeB.png", "/q3-alternativeC.png", 'b'), 
														   
														   new Question(4, "/question4.png", "/q4-alternativeA.png", "/q4-alternativeB.png", "/q4-alternativeC.png", 'b'),
														   
														   new Question(5, "/question5.png", "/q5-alternativeA.png", "/q5-alternativeB.png", "/q5-alternativeC.png", 'c'), 
														   
														   new Question(6, "/question6.png", "/q6-alternativeA.png", "/q6-alternativeB.png", "/q6-alternativeC.png", 'a'),
														   
														   new Question(7, "/question7.png", "/q7-alternativeA.png", "/q7-alternativeB.png", "/q7-alternativeC.png", 'c'),
														   
														   new Question(8, "/question8.png", "/q8-alternativeA.png", "/q8-alternativeB.png", "/q8-alternativeC.png", 'a'),
														   
														   new Question(9, "/question9.png", "/q9-alternativeA.png", "/q9-alternativeB.png", "/q9-alternativeC.png", 'b'),
														   
														   new Question(10, "/question10.png", "/q10-alternativeA.png", "/q10-alternativeB.png", "/q10-alternativeC.png", 'a'), 
														   
														   new Question(11, "/question11.png", "/q11-alternativeA.png", "/q11-alternativeB.png", "/q11-alternativeC.png", 'c'),
														   
														   new Question(12, "/question12.png", "/q12-alternativeA.png", "/q12-alternativeB.png", "/q12-alternativeC.png", 'a'),
														   
														   new Question(13, "/question13.png", "/q13-alternativeA.png", "/q13-alternativeB.png", "/q13-alternativeC.png", 'a'),
														   
														   new Question(14, "/question14.png", "/q14-alternativeA.png", "/q14-alternativeB.png", "/q14-alternativeC.png", 'b'),
														   
														   new Question(15, "/question15.png", "/q15-alternativeA.png", "/q15-alternativeB.png", "/q15-alternativeC.png", 'b')};
}
