package br.com.mhas.engine;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import br.com.mhas.gui.GameGUI;
import br.com.mhas.gui.KochGUI;
import br.com.mhas.gui.OptionGUI;
import br.com.mhas.gui.QuizGUI;

public class Option {
	
	//attributes
	
	private OptionGUI optionWindow;
	
	private EventListener event = new EventListener();
	
	//constructor
	
	public Option(OptionGUI optionWindow) {
		
		this.optionWindow = optionWindow;
		
		addListener();
	}
	
	
	//methods
	
	private void addListener() {
		
		optionWindow.getPanelCardBattle().addMouseListener(event);
		
		optionWindow.getPanelAbout().addMouseListener(event);
		
		optionWindow.getPanelExit().addMouseListener(event);
		
		optionWindow.getPanelKochCurve().addMouseListener(event);
		
		optionWindow.getPanelQuestion().addMouseListener(event);
	}
	
	
	//internal class event mouse listener
	
	private class EventListener implements MouseListener {

		
		public void mouseClicked(MouseEvent e) {
			
			if(e.getSource() == optionWindow.getPanelCardBattle()){
				
				new GameGUI().setVisible(true);
				
				optionWindow.dispose();
			
			} else if(e.getSource() == optionWindow.getPanelAbout()){
				
				ImageIcon icon = new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/webdevelopment-icon.png"));
				
				String about = "   Sistema: Fractal Project\n"
							  + "   Versão: Beta\n"
							  + "   Disciplina: Introdução a Computação Gáfica\n"
							  + "   Docente: Liliane dos Santos\n"
							  + "   Desenvolvedor: Marcos Alves";
				
				JOptionPane.showMessageDialog(null, about, "Sistema", JOptionPane.PLAIN_MESSAGE, icon);
			
			} else if(e.getSource() == optionWindow.getPanelExit()){
				
				optionWindow.dispose();
			
			} else if(e.getSource() == optionWindow.getPanelKochCurve()){
				
				new KochGUI().setVisible(true);
				
				optionWindow.dispose();
			
			} else if(e.getSource() == optionWindow.getPanelQuestion()){
				
				new QuizGUI().setVisible(true);
				
				optionWindow.dispose();
			}
		}
		
		public void mouseEntered(MouseEvent e) {
			
		}

	
		public void mouseExited(MouseEvent e) {
		
		}

		public void mousePressed(MouseEvent e) {
		
		}

		public void mouseReleased(MouseEvent e) {
	
		}
		
		
	}
}
