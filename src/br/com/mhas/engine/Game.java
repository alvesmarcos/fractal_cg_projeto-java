package br.com.mhas.engine;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import br.com.mhas.gui.*;
import br.com.mhas.model.*;


public class Game {
	
	//attributes
	
	private GameGUI gameWindow;
	
	private EventListener event = new EventListener();
	
	private Player player;
	
	private Machine machine;
	
	private Card [] list_card;
	
	private Card card_inBattle_player = null;
	
	private Card card_inBattle_machine = null;
	
	private String kingdom = "air";
	
	//private static boolean multiplayer = false;
	
	private boolean orderMachine = true;
	
	//constructor
	
	public Game(GameGUI gameWindow){
		
		this.gameWindow = gameWindow;
		
		player = new Player();
		
		machine = new Machine();
		
		card_inBattle_machine = new Card();
		
		card_inBattle_player = new Card();
		
		loadCard();
		
		gameWindow.getLblLifeplayer().setText(""+player.getLife());
		
		gameWindow.getLblLifemachine().setText(""+machine.getLife());
		
		addListener();
	}
	
	//methods
	
	private void addListener() {
		
		gameWindow.getLblCard1().addMouseListener(event);
		
		gameWindow.getLblCard2().addMouseListener(event);
		
		gameWindow.getLblCard3().addMouseListener(event);
		
		gameWindow.getLblCard4().addMouseListener(event);
		
		gameWindow.getLblCardPlayer().addMouseListener(event);
		
		gameWindow.getLblCardMachine().addMouseListener(event);
		
		gameWindow.getLblBackgroundListCard().addMouseListener(event);
		
		gameWindow.getLblBackgroundMaster().addMouseListener(event);
		
		gameWindow.getLblAt().addMouseListener(event);
		
		gameWindow.getLblDf().addMouseListener(event);
		
		gameWindow.getLblModePlayer().addMouseListener(event);
		
		gameWindow.getLblModeMachine().addMouseListener(event);
		
		gameWindow.getLblAirsmall().addMouseListener(event);
		
		gameWindow.getLblEarthsmall().addMouseListener(event);
		
		gameWindow.getLblWatersmall().addMouseListener(event);
		
		gameWindow.getLblMark().addMouseListener(event);
		
		gameWindow.getLblState().addMouseListener(event);
		
		gameWindow.addWindowListener(event);
		
		gameWindow.getPanelGame().addMouseListener(event);
	}
	
	private void air(){
		
		gameWindow.getLblMark().setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/Air-Big.png")));
		
		gameWindow.getLblMark().setBounds(361, 16, 69, 69);
		
		gameWindow.getLblBackgroundMaster().setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/FundoAr.jpg")));
		
		gameWindow.getLblBackgroundListCard().setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/fundo-carta-onda-gray.png")));
		
		kingdom = "air";
	}
	
	private void circle(){ 
		
		if(card_inBattle_machine.getId() != 0 && card_inBattle_player.getId() != 0){ 	
			
			if(card_inBattle_machine.getMode().equals("attack") && card_inBattle_player.getMode().equals("attack")){
				
				if(card_inBattle_player.getAttack() > card_inBattle_machine.getAttack()){
				
					machine.setLife(card_inBattle_player.getAttack());
				
				} else if (card_inBattle_player.getAttack() < card_inBattle_machine.getAttack()){
				
					player.setLife(card_inBattle_machine.getAttack());
				
				} else if (card_inBattle_player.getAttack() == card_inBattle_machine.getAttack()){
					
					player.setLife(card_inBattle_machine.getAttack());
					
					machine.setLife(card_inBattle_player.getAttack());
				}
				
			} else if (card_inBattle_machine.getMode().equals("defense") && card_inBattle_player.getMode().equals("defense")){
				
				machine.setLife(50);
					
				player.setLife(50); 
				
			} else if (card_inBattle_machine.getMode().equals("attack") && card_inBattle_player.getMode().equals("defense")){
					
				int reduce = card_inBattle_machine.getAttack() - card_inBattle_player.getDefense();
					
				if(reduce > 0) player.setLife(reduce);
				
			} else if (card_inBattle_machine.getMode().equals("defense") && card_inBattle_player.getMode().equals("attack")){
					
				int reduce = card_inBattle_player.getAttack() - card_inBattle_machine.getDefense();
					
				if(reduce > 0) machine.setLife(reduce);
			} 
			
			gameWindow.getLblLifeplayer().setText(""+player.getLife());
			
			gameWindow.getLblLifemachine().setText(" "+machine.getLife());
			
			card_inBattle_machine.setId(0);
			
			card_inBattle_player.setId(0);
		}
		
		if(orderMachine == true && card_inBattle_machine.getId() == 0) {
			
			playMachine("first");
			
			orderMachine = false;
		
		} 
		
	}
	
	private void copy(Card card, Card card_copy){
		
		card_copy.setName(card.getName());
		
		card_copy.setId(card.getId());
		
		card_copy.setKingdom(card.getKingdom());
		
		card_copy.setAttack(card.getAttack());
	
		card_copy.setDefense(card.getDefense());
		
		card_copy.setMode(card.getMode());
		
		card_copy.setPathCard(card.getPathCard());
	}
	
	private void distractionAnime(){
		
		Thread t = new Thread(new Runnable(){
			
			public void run(){
				
				try {
					
					if(orderMachine) Thread.sleep(5000);
					
					else Thread.sleep(3000);
					
					int numberPlayer = 0, numberMachine = 0;
					
					if(card_inBattle_machine.getMode().equals("attack") && card_inBattle_player.getMode().equals("attack")){	
						
						if(card_inBattle_player.getAttack() > card_inBattle_machine.getAttack()){
							
							numberMachine = card_inBattle_player.getAttack();
						
						} else if (card_inBattle_player.getAttack() < card_inBattle_machine.getAttack()){
						
							numberPlayer = card_inBattle_machine.getAttack();
						
						} else if (card_inBattle_player.getAttack() == card_inBattle_machine.getAttack()){
							
							numberPlayer = card_inBattle_machine.getAttack();
							
							numberMachine = card_inBattle_player.getAttack();
						}	
						
					} else if (card_inBattle_machine.getMode().equals("defense") && card_inBattle_player.getMode().equals("defense")){
						
						numberMachine = 50;
						
						numberPlayer = 50;
							
					} else if (card_inBattle_machine.getMode().equals("attack") && card_inBattle_player.getMode().equals("defense")){
							
						int reduce = card_inBattle_machine.getAttack() - card_inBattle_player.getDefense();
							
						if(reduce > 0) numberPlayer = reduce;
						
					} else if (card_inBattle_machine.getMode().equals("defense") && card_inBattle_player.getMode().equals("attack")){
							
						int reduce = card_inBattle_player.getAttack() - card_inBattle_machine.getDefense();
							
						if(reduce > 0) numberMachine = reduce;
					}
						
					gameWindow.getPanelDistraction().setVisible(true);
					
					setBackground(kingdom, numberPlayer, numberMachine);
					
					gameWindow.getLblCardMachine().setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/please-wait.gif")));
					
					gameWindow.getLblCardPlayer().setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/please-wait.gif")));
						
					visibleOff(); 
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		});
		
		t.start();
	}
	
	private void earth(){
		
		gameWindow.getLblMark().setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/Earth-Big.png")));
		
		gameWindow.getLblMark().setBounds(482, 16, 69, 69);
		
		gameWindow.getLblBackgroundMaster().setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/FundoEarth.jpg")));
		
		gameWindow.getLblBackgroundListCard().setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/fundo-carta-onda-brown.png")));
		
		kingdom = "earth";
	}
	
	private Thread lifePlayer(final int numberPlayer){
		
		Thread t = new Thread(new Runnable() {

			public void run() {
				
				try {
					
					for(int p = 0; p <= numberPlayer ; p++){
					
						if(p < 10) gameWindow.getLblLifeP().setText("  "+p);
						
						else if(p < 100) gameWindow.getLblLifeP().setText(" "+p);
						
						else if(p >= 100) gameWindow.getLblLifeP().setText(""+p);
						
						Thread.sleep(10);
					} 
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		});
		
		return t;
	}
	
	private Thread lifeMachine(final int numberMachine){
		
		Thread t = new Thread(new Runnable() {

			public void run() {
				
				try {
					
					for(int p = 0; p <= numberMachine ; p++){
					
						if(p < 10) gameWindow.getLblLifeM().setText("  "+p);
						
						else if(p < 100) gameWindow.getLblLifeM().setText(" "+p);
						
						else if(p >= 100) gameWindow.getLblLifeM().setText(""+p);
						
						Thread.sleep(10);
					} 
					
					Thread.sleep(3000);
					
					gameWindow.getPanelDistraction().setVisible(false);
					
					JFrame window = new JFrame("");
					
					window.setUndecorated(true);
					
					window.setVisible(true);
				
					window.dispose();
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		});
		
		return t;
	}
	
	private void loadCard(){
	
		list_card = player.firstLoadCards();
			
		if(!list_card[0].getPathCard().equals("-")) gameWindow.getLblCard1().setIcon(new ImageIcon(GameGUI.class.getResource(list_card[0].getPathCard())));
		
		else gameWindow.getLblCard1().setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/please-wait.gif")));
		
		if(!list_card[1].getPathCard().equals("-")) gameWindow.getLblCard2().setIcon(new ImageIcon(GameGUI.class.getResource(list_card[1].getPathCard())));
		
		else gameWindow.getLblCard2().setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/please-wait.gif")));
			
		if(!list_card[2].getPathCard().equals("-")) gameWindow.getLblCard3().setIcon(new ImageIcon(GameGUI.class.getResource(list_card[2].getPathCard())));
		
		else gameWindow.getLblCard3().setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/please-wait.gif")));

		if(!list_card[3].getPathCard().equals("-")) gameWindow.getLblCard4().setIcon(new ImageIcon(GameGUI.class.getResource(list_card[3].getPathCard())));

		else gameWindow.getLblCard4().setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/please-wait.gif")));
	
	}
	
	private void modeAttack(){
		
		gameWindow.getLblModePlayer().setVisible(true);
		
		gameWindow.getLblModePlayer().setText("<html>A<br>T<br>T<br>A<br>C<br>K<br></html>");
		
		gameWindow.getLblFundopointplayer().setVisible(true);
		
		gameWindow.getLblFundopointplayer().setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/red-ball-point.png")));
		
		gameWindow.getLblScoreplayer().setVisible(true);
		
		if(!card_inBattle_player.getKingdom().equals(kingdom)){
			
			int reduce = (int) (card_inBattle_player.getAttack() * 70)/100;
			
			card_inBattle_player.setAttack(card_inBattle_player.getAttack() - reduce);
		}
		
		card_inBattle_player.setMode("attack");
		
		Thread t = new Thread(new Runnable() {

			public void run() {
				
				try {
					
					for(int p = 0; p <= card_inBattle_player.getAttack(); p++){
					
						if(p < 10) gameWindow.getLblScoreplayer().setText("  "+p);
						
						else if(p < 100) gameWindow.getLblScoreplayer().setText(" "+p);
						
						else if(p >= 100) gameWindow.getLblScoreplayer().setText(""+p);
						
						Thread.sleep(10);
					} 
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		});
			
		t.start();
		
		if(orderMachine == false && card_inBattle_machine.getId() == 0){
			
			playMachine("second");
			
			orderMachine = true;
		}
		
		distractionAnime();
	}
	
	private void modeDefense(){
		
		gameWindow.getLblModePlayer().setVisible(true);
		
		gameWindow.getLblModePlayer().setText("<html>D<br>E<br>F<br>E<br>N<br>S<br>E<br></html>");
		
		gameWindow.getLblFundopointplayer().setVisible(true);
		
		gameWindow.getLblFundopointplayer().setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/green-ball-point.png")));
		
		gameWindow.getLblScoreplayer().setVisible(true);
		
		if(!card_inBattle_player.getKingdom().equals(kingdom)){
			
			int reduce = (int) (card_inBattle_player.getDefense() * 80)/100;
			
			card_inBattle_player.setDefense(card_inBattle_player.getDefense() - reduce);
		}
				
		card_inBattle_player.setMode("defense");
		
		Thread t = new Thread(new Runnable() {

			public void run() {
				
				try {
					
					for(int p = 0; p <= card_inBattle_player.getDefense(); p++){
					
						if(p < 10) gameWindow.getLblScoreplayer().setText("  "+p);
						
						else if(p < 100) gameWindow.getLblScoreplayer().setText(" "+p);
						
						else if(p >= 100) gameWindow.getLblScoreplayer().setText(""+p);
						
						Thread.sleep(10);
					} 
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		});
		
		t.start();	
		
		if(orderMachine == false && card_inBattle_machine.getId() == 0){
			
			playMachine("second");
			
			orderMachine = true;
		}
		
		distractionAnime();
	}
	
	private void playMachine(final String order){
		
		gameWindow.getLblHandmachine().setVisible(true);
		
		gameWindow.getLblHandplayer().setVisible(false);
		
		Thread t = new Thread(new Runnable(){

			public void run() {
				
				try {
					
					gameWindow.getLblState().setVisible(true);
					
					Thread.sleep(2000);
					
					gameWindow.getLblState().setVisible(false);
					
					if(order.equals("first")){
						
						Card card = machine.playMachineFirst();
						
						copy(card, card_inBattle_machine);
						
						kingdom = card_inBattle_machine.getKingdom();
						
						if(kingdom.equals("air")) air();
						
						else if(kingdom.equals("earth")) earth();
						
						else if(kingdom.equals("water")) water();
						
						gameWindow.getLblHandmachine().setVisible(false);
						
						gameWindow.getLblHandplayer().setVisible(true);
					}
					
					else if (order.equals("second")){
						
						Card card = machine.playMachineSecond(card_inBattle_player, kingdom);
						
						copy(card, card_inBattle_machine);
						
						gameWindow.getLblHandmachine().setVisible(true);
						
						gameWindow.getLblHandplayer().setVisible(false);
					}
					
					gameWindow.getLblCardMachine().setIcon(new ImageIcon(GameGUI.class.getResource(card_inBattle_machine.getPathCard())));
					
					gameWindow.getLblScoremachine().setVisible(true);
					
					if(card_inBattle_machine.getMode().equals("attack")) {
						
						gameWindow.getLblModeMachine().setVisible(true);
						
						gameWindow.getLblModeMachine().setText("<html>A<br>T<br>T<br>A<br>C<br>K<br></html>");
						
						gameWindow.getLblFundopointmachine().setVisible(true);
						
						gameWindow.getLblFundopointmachine().setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/red-ball-point.png")));
						
						if(!card_inBattle_machine.getKingdom().equals(kingdom)){
							
							int reduce = (int) (card_inBattle_machine.getAttack() * 70)/100;
							
							card_inBattle_machine.setAttack(card_inBattle_machine.getAttack() - reduce);
						}
						
						for(int p = 0; p <= card_inBattle_machine.getAttack(); p++){
							
							if(p < 10) gameWindow.getLblScoremachine().setText("  "+p);
							
							else if(p < 100) gameWindow.getLblScoremachine().setText(" "+p);
							
							else if(p >= 100) gameWindow.getLblScoremachine().setText(""+p);
							
							Thread.sleep(10);
						} 
						
					} else if (card_inBattle_machine.getMode().equals("defense")) {
						
						gameWindow.getLblModeMachine().setVisible(true);
						
						gameWindow.getLblModeMachine().setText("<html>D<br>E<br>F<br>E<br>N<br>S<br>E<br></html>");
						
						gameWindow.getLblFundopointmachine().setVisible(true);
						
						gameWindow.getLblFundopointmachine().setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/green-ball-point.png")));	
						
						if(!card_inBattle_machine.getKingdom().equals(kingdom)){
							
							int reduce = (int) (card_inBattle_machine.getDefense() * 80)/100;
							
							card_inBattle_machine.setDefense(card_inBattle_machine.getDefense() - reduce);
						}
						
						for(int p = 0; p <= card_inBattle_machine.getDefense(); p++){
							
							if(p < 10) gameWindow.getLblScoremachine().setText("  "+p);
							
							else if(p < 100) gameWindow.getLblScoremachine().setText(" "+p);
							
							else if(p >= 100) gameWindow.getLblScoremachine().setText(""+p);
							
							Thread.sleep(10);
						} 
					}
					
					
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				}
			}
		});
		
		t.start();
	}
	
	private void previewForceCardOn(int atk, int def) {
		
		gameWindow.getLblPreviewattack().setVisible(true);
		
		gameWindow.getLblPreviewdefense().setVisible(true);
		
		gameWindow.getLblPreviewscoreatk().setVisible(true);
		
		gameWindow.getLblPreviewscoredef().setVisible(true);
		
		gameWindow.getLblPreviewscoreatk().setText(""+atk);
		
		gameWindow.getLblPreviewscoredef().setText(""+def);
	}
	
	private void previewForceCardOff() {
		
		gameWindow.getLblPreviewattack().setVisible(false);
		
		gameWindow.getLblPreviewdefense().setVisible(false);
		
		gameWindow.getLblPreviewscoreatk().setVisible(false);
		
		gameWindow.getLblPreviewscoredef().setVisible(false);

	}
	
	private void selectCard1(){
		
		Card card_load = player.onlyCard();
		
		if(!list_card[0].getPathCard().equals("-")) gameWindow.getLblCardPlayer().setIcon(new ImageIcon(GameGUI.class.getResource(list_card[0].getPathCard())));
		
		copy(list_card[0], card_inBattle_player);
		
		list_card[0] = card_load;
		
		if(!card_load.getPathCard().equals("-")) gameWindow.getLblCard1().setIcon(new ImageIcon(GameGUI.class.getResource(card_load.getPathCard())));
		
		else gameWindow.getLblCard1().setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/please-wait.gif")));
		
		visibleOn();
	}
	
	private void selectCard2(){
		
		Card card_load = player.onlyCard();
		
		if(!list_card[1].getPathCard().equals("-")) gameWindow.getLblCardPlayer().setIcon(new ImageIcon(GameGUI.class.getResource(list_card[1].getPathCard())));
		
		copy(list_card[1], card_inBattle_player);
		
		list_card[1] = card_load;
		
		if(!card_load.getPathCard().equals("-")) gameWindow.getLblCard2().setIcon(new ImageIcon(GameGUI.class.getResource(card_load.getPathCard())));
		
		else gameWindow.getLblCard2().setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/please-wait.gif")));
	
		visibleOn();
	}
	
	private void selectCard3(){
		
		Card card_load = player.onlyCard();
		
		if(!list_card[2].getPathCard().equals("-")) gameWindow.getLblCardPlayer().setIcon(new ImageIcon(GameGUI.class.getResource(list_card[2].getPathCard())));
		
		copy(list_card[2], card_inBattle_player);
		
		list_card[2] = card_load;
		
		if(!card_load.getPathCard().equals("-")) gameWindow.getLblCard3().setIcon(new ImageIcon(GameGUI.class.getResource(card_load.getPathCard())));
		
		else gameWindow.getLblCard3().setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/please-wait.gif")));
		
		visibleOn();
	}
	
	private void selectCard4(){
		
		Card card_load = player.onlyCard();
		
		if(!list_card[3].getPathCard().equals("-")) gameWindow.getLblCardPlayer().setIcon(new ImageIcon(GameGUI.class.getResource(list_card[3].getPathCard())));
		
		copy(list_card[3], card_inBattle_player);
		
		list_card[3] = card_load;
		
		if(!card_load.getPathCard().equals("-")) gameWindow.getLblCard4().setIcon(new ImageIcon(GameGUI.class.getResource(card_load.getPathCard())));
		
		else gameWindow.getLblCard4().setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/please-wait.gif")));
		
		visibleOn();
	}
	
	
	private void setBackground(String kingdom, int numberPlayer, int numberMachine){
		
		if(kingdom.equals("air")) {
			
			gameWindow.getLblBackground().setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/FundoAr.jpg")));
			
			gameWindow.getLblElement().setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/element-air.png")));
		
		} else if (kingdom.equals("earth")) {
			
			gameWindow.getLblBackground().setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/FundoEarth.jpg")));
			
			gameWindow.getLblElement().setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/element-earth.png")));
		
		} else if (kingdom.equals("water")){
		                                  
			gameWindow.getLblBackground().setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/FundoWater.jpg")));
			
			gameWindow.getLblElement().setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/element-water.png")));
		}
		
		lifePlayer(numberPlayer).start();
		
		lifeMachine(numberMachine).start();
	}
	
	private void visibleOff(){
		
		gameWindow.getLblAt().setVisible(false);
		
		gameWindow.getLblAttack().setVisible(false);
		
		gameWindow.getLblDf().setVisible(false);
		
		gameWindow.getLblDefense().setVisible(false);
		
		gameWindow.getLblModeMachine().setVisible(false);
		
		gameWindow.getLblModePlayer().setVisible(false);
		
		gameWindow.getLblScoremachine().setVisible(false);
		
		gameWindow.getLblScoreplayer().setVisible(false);
		
		gameWindow.getLblFundopointmachine().setVisible(false);
		
		gameWindow.getLblFundopointplayer().setVisible(false);
	}

	private void visibleOn(){
		
		gameWindow.getLblAt().setVisible(true);
		
		gameWindow.getLblAttack().setVisible(true);
		
		gameWindow.getLblDf().setVisible(true);
		
		gameWindow.getLblDefense().setVisible(true);
	}
	
	private void water(){
		
		gameWindow.getLblMark().setBounds(592, 16, 69, 69);
		
		gameWindow.getLblMark().setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/Water-Big.png")));
		
		gameWindow.getLblBackgroundMaster().setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/FundoWater.jpg")));
		
		gameWindow.getLblBackgroundListCard().setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/fundo-carta-onda-blue.png")));
	
		kingdom = "water";
	}
	
	//internal class event mouse listener
	
	private class EventListener implements MouseListener, WindowListener {
		
		//methods interface mouselistener
		
		public void mouseClicked(MouseEvent e) {
			
			if(e.getSource() == gameWindow.getLblAirsmall()){
				
				if(card_inBattle_machine.getId() == 0 && card_inBattle_player.getId() == 0 && orderMachine == false) air();
				
			} else if (e.getSource() == gameWindow.getLblEarthsmall()){
				
				if(card_inBattle_machine.getId() == 0 && card_inBattle_player.getId() == 0 && orderMachine == false) earth();
				
			} else if (e.getSource() == gameWindow.getLblWatersmall()){
				
				if(card_inBattle_machine.getId() == 0 && card_inBattle_player.getId() == 0 && orderMachine == false) water();
				
			} else if (e.getSource() == gameWindow.getLblCard1()){
				
				if(card_inBattle_player.getId() == 0) selectCard1();
				
				previewForceCardOff();
			
			} else if (e.getSource() == gameWindow.getLblCard2()){
				
				if(card_inBattle_player.getId() == 0) selectCard2();
				
				previewForceCardOff();
			
			} else if (e.getSource() == gameWindow.getLblCard3()){
				
				if(card_inBattle_player.getId() == 0) selectCard3();
				
				previewForceCardOff();
			
			} else if (e.getSource() == gameWindow.getLblCard4()){
				
				if(card_inBattle_player.getId() == 0) selectCard4();
				
				previewForceCardOff();
			
			} else if (e.getSource() == gameWindow.getLblAt()){
				
				if(!gameWindow.getLblScoreplayer().isVisible()) modeAttack();
			
			} else if (e.getSource() == gameWindow.getLblDf()){
				
				if(!gameWindow.getLblScoreplayer().isVisible()) modeDefense();
			}
		}

		public void mouseEntered(MouseEvent e) {
			
			if (e.getSource() == gameWindow.getLblCard1()) {
				
				if (list_card[0] != null && !gameWindow.getLblDf().isVisible()) previewForceCardOn(list_card[0].getAttack(), list_card[0].getDefense());
				
			} else if (e.getSource() == gameWindow.getLblCard2()) {
				
				if (list_card[1] != null && !gameWindow.getLblDf().isVisible()) previewForceCardOn(list_card[1].getAttack(), list_card[1].getDefense());
				
			} else if (e.getSource() == gameWindow.getLblCard3()) {
				
				if (list_card[2] != null && !gameWindow.getLblDf().isVisible()) previewForceCardOn(list_card[2].getAttack(), list_card[2].getDefense());
				
			} else if (e.getSource() == gameWindow.getLblCard4()) {
				
				if (list_card[3] != null && !gameWindow.getLblDf().isVisible()) previewForceCardOn(list_card[3].getAttack(), list_card[3].getDefense());
				
			}
		}

		public void mouseExited(MouseEvent e) {
			
			if (e.getSource() == gameWindow.getLblCard1()) {
				
				previewForceCardOff();
				
			} else if (e.getSource() == gameWindow.getLblCard2()) {
				
				previewForceCardOff();
				
			} else if (e.getSource() == gameWindow.getLblCard3()) {
				
				previewForceCardOff();
				
			} else if (e.getSource() == gameWindow.getLblCard4()) {
				
				previewForceCardOff();
			}
		}

		public void mousePressed(MouseEvent e) {
		
		}

		public void mouseReleased(MouseEvent e) {
		
		}

		//methods interface windowListener
		
		public void windowActivated(WindowEvent e) {
			
			circle();
		}

		public void windowClosed(WindowEvent e) {
			
		}

		public void windowClosing(WindowEvent e) {
			
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
