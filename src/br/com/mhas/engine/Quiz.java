package br.com.mhas.engine;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import br.com.mhas.gui.GameGUI;
import br.com.mhas.gui.OptionGUI;
import br.com.mhas.gui.QuizGUI;
import br.com.mhas.model.Question;
import jdk.nashorn.internal.scripts.JO;

public class Quiz implements IQuestions {
	
	//attributes 
	
	private QuizGUI quizWindow;
	
	private EventListener event = new EventListener();
	
	private boolean select;
	
	private char [] answer = new char[SIZE_QUESTION];
	
	private int [] id_question = new int[SIZE_QUESTION];
	
	private Thread threadTimer = refreshTimer();
	
	private int index;
	
	private char current_answer;
	
	private Question all_question;
	
	private Question current_question;
	
	//constructor

	public Quiz(QuizGUI quizWindow) {
		
		this.quizWindow = quizWindow;
		
		all_question = new Question();
		
		select = false; 
		
		addListener();
		
		clearAnswer();
		
		index = 0;
		
		firstQuestion();
		
		this.quizWindow.getLblTimer().setText(""+TIMER);
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
		
		quizWindow.getLblClose().addMouseListener(event);
		
		quizWindow.addKeyListener(event);
		
		quizWindow.addWindowListener(event);
	}
	
	private void clearAnswer() {
		
		for(int i = 0 ; i < SIZE_QUESTION; i++) answer[i] = '\0';
	}
	
	private boolean finishQuestion() {
		
		threadTimer.interrupt();
		
		quizWindow.getLblNext().setEnabled(false);
		
		quizWindow.getLblTimer().setText("00");
		
		score();
		
		return true;
	}
	
	private void firstQuestion() {
		
		loadImageQuestion();
		
		threadTimer = refreshTimer();
		
		threadTimer.start();
		
		selectColorDefault();
	}
	
	private void loadImageQuestion() {
		
		current_question = all_question.onlyQuestion();
		
		if(current_question != null) {
			
			quizWindow.getLblImageFractal().setIcon(new ImageIcon(QuizGUI.class.getResource(current_question.getPathQuestion())));
			
			quizWindow.getLblAlternativeA().setIcon(new ImageIcon(QuizGUI.class.getResource(current_question.getPathAlternativeA())));
			
			quizWindow.getLblAlternativeB().setIcon(new ImageIcon(QuizGUI.class.getResource(current_question.getPathAlternativeB())));
			
			quizWindow.getLblAlternativeC().setIcon(new ImageIcon(QuizGUI.class.getResource(current_question.getPathAlternativeC())));
			
			quizWindow.getLblName().setText(current_question.getPathQuestion());
			
			id_question[index] = current_question.getId();
			
			 //JOptionPane.showMessageDialog(null,"INDICE: "+id_question[index]+ " ID:"+ current_question.getId());
		}
		
	}
	
	private void nextQuestion() {
			
		threadTimer.interrupt();
		
		//JOptionPane.showMessageDialog(null, current_question.getId());
		
		if (!select) answer[index] = '\0';
		
		else answer[index] = current_answer;	
		
		if (index+2 == 16) quizWindow.getLblCounter().setText(("15/15"));
			
		else if(index+2 >= 10) quizWindow.getLblCounter().setText((index+2)+"/15");
		
		else quizWindow.getLblCounter().setText("0"+(index+2)+"/15");
			
		index++;
		
		boolean result = false;
		
		if (index == 15) result = finishQuestion();
		
		selectColorDefault();
		
		if(!result) {
			
			threadTimer = refreshTimer();
		
			threadTimer.start();
		}
		
		select = false;
		
		current_answer = '\0';
	}
	
	private Thread refreshTimer() {
		
		Thread th = new Thread(new Runnable() {
			
			public void run() {
				
				try {
					
					for (int i = 0; i <= TIMER; i++) {
					 
						if(TIMER - i == TIMER) quizWindow.getLblTimer().setText(""+(TIMER-i)); 
						
						else if(TIMER - i < 10) quizWindow.getLblTimer().setText("0"+(TIMER-i)); 
						
						else quizWindow.getLblTimer().setText(""+(TIMER-i)); 
						
						Thread.sleep(1000);
						
						if (i == TIMER) {
							
							loadImageQuestion();
							
							nextQuestion(); 
						}

					}
					
				} catch (InterruptedException e) {
	
					//System.out.println("Thread interrupted: "+e.getMessage());
				}
			}
		});
		
		return th;
	}
	
	private int score() {
		
		quizWindow.getPanelChoice().setVisible(false);
		
		quizWindow.getPanelSight().setVisible(false);
		
		quizWindow.getPanelInfo().setVisible(false);
		
		quizWindow.getPanelTimer().setVisible(false);
		
		quizWindow.getLblImageFractal().setVisible(false);
		
		int counter = 0;
		
		for (int i = 0; i < SIZE_QUESTION; i++) {
			
			for (int j = 0 ; j < SIZE_QUESTION; j++) {
				
				if (id_question[i] == QUESTION_ARRAY[j].getId()) {
						
					if(answer[i] == QUESTION_ARRAY[j].getAnswer()) counter++;
					
					break;
				}
			}
		}
		
		quizWindow.getPanelScore().setVisible(true);
		
		if(counter < 10)quizWindow.getLblScore().setText("0"+counter+"/15");
		
		else quizWindow.getLblScore().setText(counter+"/15");
		
		if(counter >= 13) quizWindow.getLblStatus().setText("Excelente");
		
		else if (counter < 13 && counter >= 10) quizWindow.getLblStatus().setText("     Bom");
		
		else if (counter < 10 && counter >= 6) quizWindow.getLblStatus().setText("  Regular");
		
		else if (counter <= 5) quizWindow.getLblStatus().setText("  Péssimo");
		
		return counter;
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
	
	//internal class event mouse listener
	
	private class EventListener implements MouseListener, KeyListener, WindowListener {
		
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
				
				loadImageQuestion();
				
				select = false;
			
			} else if (e.getSource() ==  quizWindow.getLblClose()) {
				
				quizWindow.dispose();
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

		public void mousePressed(MouseEvent e) {
		
		}
		
		
		public void mouseReleased(MouseEvent e) {
	
		}

		public void keyReleased(KeyEvent e) {
		
		}
		
		
		public void keyPressed(KeyEvent e) {
			
			if (e.getKeyChar() == 'a'){
				
				ImageIcon icon = new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/education31(1).png"));
				
				JOptionPane.showMessageDialog(null, " Resposta >> "+current_question.getAnswer(), "Sistema", JOptionPane.INFORMATION_MESSAGE, icon);
			}
		}
		
		public void keyTyped(KeyEvent e) {
		
		}

		public void windowActivated(WindowEvent e) {
				
		}

		public void windowClosed(WindowEvent e) {
			
		}

		public void windowClosing(WindowEvent e) {
			
			threadTimer.interrupt();
			
			new OptionGUI().setVisible(true);
		}

		public void windowDeactivated(WindowEvent e) {
			
		}
		
		public void windowDeiconified(WindowEvent e) {
			
		}
		
		public void windowIconified(WindowEvent e) {

		}

		public void windowOpened(WindowEvent e) {
	
		}
	
	}
}
