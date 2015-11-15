package br.com.mhas.engine;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;

import br.com.mhas.gui.QuizGUI;

public class Quiz {
	
	//attributes 
	
	private QuizGUI quizWindow;
	
	private EventListener event = new EventListener();
	
	private boolean select;
	
	private char [] answer = new char[10];
	
	private static final int TIMER = 10;
	
	private Thread threadTimer = refreshTimer();
	
	private int index;
	
	private char current_answer;
	
	//constructor

	public Quiz(QuizGUI quizWindow) {
		
		this.quizWindow = quizWindow;
		
		select = false; 
		
		addListener();
		
		clearAnswer();
		
		index = 0;
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
		
		for(int i = 0 ; i < 10; i++) answer[i] = '\0';
	}
	
	private void nextQuestion() {
		
		threadTimer.interrupt();
		
		if (!select) answer[index] = '\0';
		
		else answer[index] = current_answer;
		
		System.out.printf("%c",current_answer);
	
		if (index == 9) {
			
			for (int i = 0; i < 10; i++) System.out.println("Answer "+i+":"+answer[i]);
		}
		
		index++;
		
		threadTimer = refreshTimer();
		
		threadTimer.start();
		
		selectColorDefault();
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
