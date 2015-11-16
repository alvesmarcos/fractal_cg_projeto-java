package br.com.mhas.engine;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import br.com.mhas.gui.GameGUI;
import br.com.mhas.gui.QuizGUI;
import br.com.mhas.model.Question;

public class Quiz implements IQuestions {
	
	//attributes 
	
	private QuizGUI quizWindow;
	
	private EventListener event = new EventListener();
	
	private boolean select;
	
	private char [] answer = new char[SIZE_QUESTION];
	
	private static final int TIMER = 10;
	
	private Thread threadTimer = refreshTimer();
	
	private int index;
	
	private char current_answer;
	
	private Question all_question;
	
	private Question current_question;
	
	private boolean time_over = false;
	
	//constructor

	public Quiz(QuizGUI quizWindow) {
		
		this.quizWindow = quizWindow;
		
		all_question = new Question();
		
		select = false; 
		
		addListener();
		
		clearAnswer();
		
		index = 0;
		
		firstQuestion();
	}
	
	//methods
	
	private void addListener() {
		
		quizWindow.getPanelAlternativeA().addMouseListener(event);
		
		quizWindow.getPanelAlternativeB().addMouseListener(event);
		
		quizWindow.getPanelAlternativeC().addMouseListener(event);
		
		quizWindow.getPanelColorA().addMouseListener(event);
		
		quizWindow.getPanelColorB().addMouseListener(event);
		
		quizWindow.getPanelColorC().addMouseListener(event);
		
		quizWindow.getLblNext().addMouseListener(event);
	}
	
	private void clearAnswer() {
		
		for(int i = 0 ; i < SIZE_QUESTION; i++) answer[i] = '\0';
	}
	
	public void circle() {
		
		if(time_over) {
			
			//threadTimer.destroy();
			
			
		}
	}
	
	private void finishQuestion() {
		
		threadTimer.interrupt();
		
		quizWindow.getLblNext().setEnabled(false);
		
		quizWindow.getLblTimer().setText("00");
		
		for (int i = 0; i < 15; i++) JOptionPane.showMessageDialog(null, (i+1)+") "+answer[i]);
	}
	
	private void firstQuestion() {
		
		loadImageQuestion();
		
		threadTimer = refreshTimer();
		
		threadTimer.start();
		
		selectColorDefault();
	}
	
	private void loadImageQuestion() {
		
		current_question = all_question.onlyQuestion();
		
		if(current_question != null) quizWindow.getLblImageFractal().setIcon(new ImageIcon(QuizGUI.class.getResource(current_question.getPathQuestion())));
		
	}
	
	private void nextQuestion() {
			
		threadTimer.interrupt();
		
		if (!select) answer[index] = '\0';
		
		else answer[index] = current_answer;
		
		if (index+2 == 16) quizWindow.getLblCounter().setText(("15/15"));
			
		else if(index+2 >= 10) quizWindow.getLblCounter().setText((index+2)+"/15");
		
		else quizWindow.getLblCounter().setText("0"+(index+2)+"/15");
		
		index++;
		
		if (index == 15) finishQuestion();
		
		selectColorDefault();
		
		threadTimer = refreshTimer();
		
		threadTimer.start();
	}
	
	private void selectAnswerA() {
		
		quizWindow.getPanelColorA().setBackground(new Color(51, 204, 255));
		
		quizWindow.getPanelColorB().setBackground(new Color(245, 245, 220));
		
		quizWindow.getPanelColorC().setBackground(new Color(245, 245, 220));
	}
	
	private void selectAnswerB() {
		
		quizWindow.getPanelColorB().setBackground(new Color(51, 204, 255));
		
		quizWindow.getPanelColorA().setBackground(new Color(245, 245, 220));
		
		quizWindow.getPanelColorC().setBackground(new Color(245, 245, 220));
	}

	private void selectAnswerC() {
	
		quizWindow.getPanelColorC().setBackground(new Color(51, 204, 255));
	
		quizWindow.getPanelColorA().setBackground(new Color(245, 245, 220));
	
		quizWindow.getPanelColorB().setBackground(new Color(245, 245, 220));
	}
	
	private void selectColorDefault() {
		
		quizWindow.getPanelColorA().setBackground(new Color(245, 245, 220));
		
		quizWindow.getPanelColorB().setBackground(new Color(245, 245, 220));
		
		quizWindow.getPanelColorC().setBackground(new Color(245, 245, 220));
		
		current_answer = '\0';
	}
	
	private Thread refreshTimer() {
		
		Thread th = new Thread(new Runnable() {
			
			public void run() {
				
				try {
					
					for (int i = 0; i <= TIMER; i++) {
					 
						if(TIMER - i == 10) quizWindow.getLblTimer().setText(""+(TIMER-i)); 
						
						else quizWindow.getLblTimer().setText("0"+(TIMER-i)); 
						
						Thread.sleep(1000);
						
						if (i == TIMER) {
							
							loadImageQuestion();
							
							nextQuestion(); 
						}

					}
					
				} catch (InterruptedException e) {
	
					System.out.println("Thread interrupted: "+e.getMessage());
				}
			}
		});
		
		return th;
	}
	
	//internal class event mouse listener
	
	private class EventListener implements MouseListener{
		
		//methods interface mouselistener
	
		public void mouseClicked(MouseEvent e) {
			
			if (e.getSource() == quizWindow.getPanelAlternativeA()) {
				
				selectAnswerA();
				
				select = true;
				
				current_answer = 'a';
				
			} else if (e.getSource() == quizWindow.getPanelAlternativeB()) {
				
				selectAnswerB();
				
				select = true;
				
				current_answer = 'b';
			
			} else if (e.getSource() == quizWindow.getPanelAlternativeC()){
				
				selectAnswerC();
				
				select = true;
				
				current_answer = 'c';
			
			} else if (e.getSource() == quizWindow.getLblNext()) {
				
				loadImageQuestion();
				
				nextQuestion();
				
				select = false;
			}
		}

		
		public void mouseEntered(MouseEvent e) {
			
			if (e.getSource() == quizWindow.getPanelAlternativeA()) {
				
				if (!select) selectAnswerA();
			
			} else if (e.getSource() == quizWindow.getPanelAlternativeB()) {
				
				if (!select) selectAnswerB();
			
			} else if (e.getSource() == quizWindow.getPanelAlternativeC()){
				
				if (!select) selectAnswerC();
			}
		}

		
		public void mouseExited(MouseEvent e) {
			
			if (e.getSource() == quizWindow.getPanelAlternativeA() && !select) selectColorDefault();
		 
			else if (e.getSource() == quizWindow.getPanelAlternativeB() && !select) selectColorDefault();
				
			else if (e.getSource() == quizWindow.getPanelAlternativeC() && !select) selectColorDefault();
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	
	}
}
