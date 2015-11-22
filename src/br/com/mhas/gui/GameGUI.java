package br.com.mhas.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import br.com.mhas.engine.Game;
import java.awt.Font;
import java.awt.Cursor;



public class GameGUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;	
	private JPanel panelGame;
	private JLabel lblCard1;
	private JLabel lblCard2;
	private JLabel lblCard3;
	private JLabel lblCard4 ;
	private JLabel lblCardPlayer;
	private JLabel lblCardMachine ;
	private JLabel lblVersus;
	private JLabel lblBara;
	private JLabel lblBara1;
	private JLabel lblBackgroundListCard;
	private JLabel lblBackgroundMaster;
	private JLabel lblBevelCard1;
	private JLabel lblBevelcard;
	private JLabel lblModePlayer;
	private JLabel lblModeMachine;
	private JLabel lblAttack;
	private JLabel lblDefense;
	private JLabel lblAt;
	private JLabel lblDf;
	private JLabel lblFundopointplayer;
	private JLabel lblAirsmall;
	private JLabel lblEarthsmall;
	private JLabel lblWatersmall;
	private JLabel lblFundopointmachine;
	private JLabel lblMark;
	private JLabel lblScoreplayer;
	private JLabel lblState;
	private JLabel lblPerson;
	private JLabel lblMachine;
	private JLabel lblScoremachine;
	private JLabel lblNameplayer;
	private JLabel lblHeartplayer;
	private JLabel lblHeartmachine;
	private JLabel lblNamemachine;
	private JLabel lblLifeplayer;
	private JLabel lblLifemachine;
	private JPanel panelDistraction;
	private JLabel lblLifeP;
	private JLabel lblLifeM;
	private JLabel lblElement;
	private JLabel lblArrowplayer;
	private JLabel lblArrowmachine;
	private JLabel lblBackground;
	private JLabel lblHandmachine;
	private JLabel lblHandplayer;
	private JLabel lblPreviewattack;
	private JLabel lblPreviewdefense;
	private JLabel lblPreviewscoreatk;
	private JLabel lblPreviewscoredef;
	private JLabel lblBackgroundOver;
	
	//controller
	
	protected Game game;

	
	//constructor
	
	public GameGUI() {
		
		initGameGUI();
		
		game = new Game(this);
	}
	
	
	private void initGameGUI(){
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1024, 640);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setUndecorated(true);
		
		setLocationRelativeTo(null); 
		
		setResizable(false);
		
		panelGame = new JPanel();
		panelGame.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelGame.setBounds(0, 0, 1024, 640);
		contentPane.add(panelGame);
		panelGame.setLayout(null);

		lblBackgroundOver = new JLabel("");
		lblBackgroundOver.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/g-o.png")));
		lblBackgroundOver.setBounds(0, 0, 1024, 640);
		panelGame.add(lblBackgroundOver); 
		lblBackgroundOver.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null)); 
		lblBackgroundOver.setVisible(false);
		
		panelDistraction = new JPanel();
		panelDistraction.setBackground(Color.PINK);
		panelDistraction.setBounds(205, 102, 617, 232);
		panelGame.add(panelDistraction);
		panelDistraction.setLayout(null);
		panelDistraction.setVisible(false);
		
		lblLifeP = new JLabel("  0");
		lblLifeP.setForeground(Color.BLACK);
		lblLifeP.setFont(new Font("Vijaya", Font.PLAIN, 150));
		lblLifeP.setBounds(42, 43, 194, 100);
		panelDistraction.add(lblLifeP);
		
		lblArrowplayer = new JLabel("");
		lblArrowplayer.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/Arrow_point_to_down_128.png")));
		lblArrowplayer.setBounds(86, 141, 80, 80);
		panelDistraction.add(lblArrowplayer);
		
		lblElement = new JLabel("");
		lblElement.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/element-air.png")));
		lblElement.setBounds(251, 68, 124, 100);
		panelDistraction.add(lblElement);
		
		lblLifeM = new JLabel("  0");
		lblLifeM.setForeground(Color.BLACK);
		lblLifeM.setFont(new Font("Vijaya", Font.PLAIN, 150));
		lblLifeM.setBounds(385, 43, 194, 100);
		panelDistraction.add(lblLifeM);
		
		lblArrowmachine = new JLabel("");
		lblArrowmachine.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/Arrow_point_to_down_128.png")));
		lblArrowmachine.setBounds(437, 141, 80, 80);
		panelDistraction.add(lblArrowmachine);
		
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/FundoAr.jpg")));
		lblBackground.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblBackground.setBounds(0, 0, 617, 232);
		panelDistraction.add(lblBackground); 
		
		lblCard1 = new JLabel("");
		lblCard1.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/card-earth-test.png")));
		lblCard1.setBounds(86, 375, 160, 198);
		panelGame.add(lblCard1);
		lblCard1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblCard2 = new JLabel("");
		lblCard2.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/card-water-test.png")));
		lblCard2.setBounds(258, 375, 160, 198);
		panelGame.add(lblCard2);
		lblCard2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblCard3 = new JLabel("");
		lblCard3.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/card-air-test.png")));
		lblCard3.setBounds(430, 375, 160, 198);
		panelGame.add(lblCard3);
		lblCard3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblCard4 = new JLabel("");
		lblCard4.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/card-earth-test.png")));
		lblCard4.setBounds(602, 375, 160, 198);
		panelGame.add(lblCard4);
		lblCard4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblCardPlayer = new JLabel("");
		lblCardPlayer.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/please-wait.gif")));
		lblCardPlayer.setBounds(261, 120, 160, 198);
		panelGame.add(lblCardPlayer);
	
		lblCardMachine = new JLabel("");
		lblCardMachine.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/please-wait.gif")));
		lblCardMachine.setBounds(607, 120, 160, 198);
		panelGame.add(lblCardMachine); 
		
		lblVersus = new JLabel("");
		lblVersus.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/vs-logo.png")));
		lblVersus.setBounds(455, 158, 123, 116);
		panelGame.add(lblVersus);
		
		lblBara = new JLabel("");
		lblBara.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/mmmk.png")));
		lblBara.setBounds(776, 375, 160, 198);
		panelGame.add(lblBara);
		
		lblBara1 = new JLabel("");
		lblBara1.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/versocarta.jpeg")));
		lblBara1.setBounds(765, 375, 160, 198);
		panelGame.add(lblBara1);
		
		
		lblBevelcard = new JLabel("");
		lblBevelcard.setIcon(null);
		lblBevelcard.setBounds(238, 103, 205, 231);
		lblBevelcard.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelGame.add(lblBevelcard);
		
		lblBevelCard1 = new JLabel("");
		lblBevelCard1.setIcon(null);
		lblBevelCard1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblBevelCard1.setBounds(584, 103, 205, 231);
		panelGame.add(lblBevelCard1);
		
		lblModePlayer = new JLabel("<html>A<br>T<br>T<br>A<br>C<br>K<br></html>");
		lblModePlayer.setForeground(Color.BLACK);
		lblModePlayer.setFont(new Font("Loma", Font.BOLD, 24));
		lblModePlayer.setBounds(205, 103, 21, 231);
		panelGame.add(lblModePlayer);
		lblModePlayer.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblModePlayer.setVisible(false);
		
		lblModeMachine = new JLabel("<html>D<br>E<br>F<br>E<br>N<br>S<br>E<br></html>");
		lblModeMachine.setForeground(Color.BLACK);
		lblModeMachine.setFont(new Font("Loma", Font.BOLD, 24));
		lblModeMachine.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblModeMachine.setBounds(801, 103, 21, 231);
		panelGame.add(lblModeMachine);
		lblModeMachine.setVisible(false);
		
		lblAt = new JLabel(" AT");
		lblAt.setFont(new Font("Ubuntu", Font.PLAIN, 30));
		lblAt.setForeground(Color.RED);
		lblAt.setBounds(31, 293, 59, 59);
		panelGame.add(lblAt);
		lblAt.setVisible(false);
		lblAt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblDf = new JLabel(" DF");
		lblDf.setForeground(Color.GREEN);
		lblDf.setFont(new Font("Ubuntu", Font.PLAIN, 30));
		lblDf.setBounds(112, 293, 59, 59);
		panelGame.add(lblDf);
		lblDf.setVisible(false);
		lblDf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblAttack = new JLabel("");
		lblAttack.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/black-ball.png")));
		lblAttack.setBounds(29, 294, 59, 59);
		panelGame.add(lblAttack);
		lblAttack.setVisible(false);
		
		lblDefense = new JLabel("");
		lblDefense.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/green-ball.png")));
		lblDefense.setBounds(110, 294, 59, 59);
		panelGame.add(lblDefense);
		lblDefense.setVisible(false);
		
		lblBackgroundListCard = new JLabel("");
		lblBackgroundListCard.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/fundo-carta-onda-gray.png")));
		lblBackgroundListCard.setBounds(69, 345, 881, 260);
		panelGame.add(lblBackgroundListCard);
 	
		lblScoreplayer = new JLabel("  0");
		lblScoreplayer.setFont(new Font("Vijaya", Font.PLAIN, 70));
		lblScoreplayer.setForeground(Color.WHITE);
		lblScoreplayer.setBounds(54, 157, 92, 76);
		panelGame.add(lblScoreplayer);
		lblScoreplayer.setVisible(false);
		
		lblScoremachine = new JLabel("  0");
		lblScoremachine.setFont(new Font("Vijaya", Font.PLAIN, 70));
		lblScoremachine.setForeground(Color.WHITE);
		lblScoremachine.setBounds(885, 158, 92, 76);
		panelGame.add(lblScoremachine);
		lblScoremachine.setVisible(false);
	 
		
		lblFundopointplayer = new JLabel("");
		lblFundopointplayer.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/green-ball-point.png")));
		lblFundopointplayer.setBounds(45, 139, 109, 107);
		panelGame.add(lblFundopointplayer);
		lblFundopointplayer.setVisible(false); 
		
		lblFundopointmachine = new JLabel("");
		lblFundopointmachine.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/red-ball-point.png")));
		lblFundopointmachine.setBounds(876, 139, 109, 107);
		panelGame.add(lblFundopointmachine);
		lblFundopointmachine.setVisible(false);
		
		lblAirsmall = new JLabel("");
		lblAirsmall.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/Air-Small.png")));
		lblAirsmall.setBounds(366, 22, 59, 59);
		panelGame.add(lblAirsmall);
		lblAirsmall.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblEarthsmall = new JLabel("");
		lblEarthsmall.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/Earth-Small.png")));
		lblEarthsmall.setBounds(487, 22, 59, 59);
		panelGame.add(lblEarthsmall);
		lblEarthsmall.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblWatersmall = new JLabel("");
		lblWatersmall.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/Water-Small.png")));
		lblWatersmall.setBounds(597, 22, 59, 59);
		panelGame.add(lblWatersmall);
		lblWatersmall.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblMark = new JLabel("");
		lblMark.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/Air-Big.png")));
		lblMark.setBounds(361, 16, 69, 69);
		panelGame.add(lblMark);
		
		lblState = new JLabel("");
		lblState.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/Hourglass_64.png")));
		lblState.setBounds(482, 285, 67, 67);
		panelGame.add(lblState);
		
		lblPerson = new JLabel("");
		lblPerson.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/User_male_black_shape_128.png")));
		lblPerson.setBounds(21, 12, 69, 69);
		panelGame.add(lblPerson);
		
		lblMachine = new JLabel("Machine");
		lblMachine.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/Electronic_visualization_monitor_tool_for_tv_or_computer_128.png")));
		lblMachine.setBounds(931, 12, 69, 69);
		panelGame.add(lblMachine);
		
		lblNameplayer = new JLabel("You");
		lblNameplayer.setForeground(Color.BLACK);
		lblNameplayer.setFont(new Font("Impact", Font.PLAIN, 18));
		lblNameplayer.setBounds(86, 12, 99, 21);
		panelGame.add(lblNameplayer);
		
		lblHeartplayer = new JLabel("");
		lblHeartplayer.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/Heart_Care_32.png")));
		lblHeartplayer.setBounds(69, 44, 37, 32);
		panelGame.add(lblHeartplayer);
		
		lblHeartmachine = new JLabel("");
		lblHeartmachine.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/Heart_Care_32.png")));
		lblHeartmachine.setBounds(914, 44, 37, 32);
		panelGame.add(lblHeartmachine);
		
		lblNamemachine = new JLabel("Machine");
		lblNamemachine.setForeground(Color.BLACK);
		lblNamemachine.setFont(new Font("Impact", Font.PLAIN, 18));
		lblNamemachine.setBounds(835, 12, 140, 21);
		panelGame.add(lblNamemachine);
		
		lblLifeplayer = new JLabel("1000");
		lblLifeplayer.setFont(new Font("Vijaya", Font.PLAIN, 55));
		lblLifeplayer.setBounds(103, 44, 123, 44);
		panelGame.add(lblLifeplayer);
		
		lblLifemachine = new JLabel("1000");
		lblLifemachine.setFont(new Font("Vijaya", Font.PLAIN, 60));
		lblLifemachine.setBounds(807, 44, 123, 44);
		panelGame.add(lblLifemachine);
		
		lblHandmachine = new JLabel("");
		lblHandmachine.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/Finger_up_32.png")));
		lblHandmachine.setBounds(790, 0, 43, 51);
		panelGame.add(lblHandmachine);
		lblHandmachine.setVisible(false);
		
		lblHandplayer = new JLabel("");
		lblHandplayer.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/Finger_up_3289.png")));
		lblHandplayer.setBounds(126, 0, 43, 51);
		panelGame.add(lblHandplayer);
		
		lblPreviewattack = new JLabel("ATK: ");
		lblPreviewattack.setForeground(Color.BLACK);
		lblPreviewattack.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/swords3.png")));
		lblPreviewattack.setFont(new Font("Impact", Font.PLAIN, 18));
		lblPreviewattack.setBounds(55, 173, 75, 32);
		panelGame.add(lblPreviewattack);
		lblPreviewattack.setVisible(false);
		
		lblPreviewdefense = new JLabel("DEF: ");
		lblPreviewdefense.setForeground(Color.BLACK);
		lblPreviewdefense.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/shield54.png")));
		lblPreviewdefense.setFont(new Font("Impact", Font.PLAIN, 18));
		lblPreviewdefense.setBounds(55, 239, 69, 32);
		panelGame.add(lblPreviewdefense);
		lblPreviewdefense.setVisible(false);
		
		lblPreviewscoreatk = new JLabel("100");
		lblPreviewscoreatk.setForeground(Color.BLACK);
		lblPreviewscoreatk.setFont(new Font("Vijaya", Font.PLAIN, 40));
		lblPreviewscoreatk.setBounds(126, 176, 69, 33);
		panelGame.add(lblPreviewscoreatk);
		lblPreviewscoreatk.setVisible(false);
		
		lblPreviewscoredef = new JLabel("100");
		lblPreviewscoredef.setForeground(Color.BLACK);
		lblPreviewscoredef.setFont(new Font("Vijaya", Font.PLAIN, 40));
		lblPreviewscoredef.setBounds(126, 241, 69, 33);
		panelGame.add(lblPreviewscoredef);
		lblState.setVisible(false);
		lblHandplayer.setVisible(false); 
		lblPreviewscoredef.setVisible(false);
		
			
		lblBackgroundMaster = new JLabel("");
		lblBackgroundMaster.setIcon(new ImageIcon(GameGUI.class.getResource("/br/com/mhas/image/FundoAr.jpg")));
		lblBackgroundMaster.setBounds(0, 0, 1024, 640);
		panelGame.add(lblBackgroundMaster); 
		lblBackgroundMaster.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null)); 
	}
	
	
	//methods getters and setters 

	public JPanel getContentPane() {
		return contentPane;
	}


	public JPanel getPanelGame() {
		return panelGame;
	}


	public JLabel getLblCard1() {
		return lblCard1;
	}


	public JLabel getLblCard2() {
		return lblCard2;
	}


	public JLabel getLblCard3() {
		return lblCard3;
	}


	public JLabel getLblCard4() {
		return lblCard4;
	}


	public JLabel getLblCardPlayer() {
		return lblCardPlayer;
	}


	public JLabel getLblCardMachine() {
		return lblCardMachine;
	}


	public JLabel getLblVersus() {
		return lblVersus;
	}


	public JLabel getLblBara() {
		return lblBara;
	}


	public JLabel getLblBara1() {
		return lblBara1;
	}


	public JLabel getLblBackgroundListCard() {
		return lblBackgroundListCard;
	}


	public JLabel getLblBackgroundMaster() {
		return lblBackgroundMaster;
	}


	public JLabel getLblBevelCard1() {
		return lblBevelCard1;
	}


	public JLabel getLblBevelcard() {
		return lblBevelcard;
	}


	public JLabel getLblModePlayer() {
		return lblModePlayer;
	}


	public JLabel getLblModeMachine() {
		return lblModeMachine;
	}


	public JLabel getLblAttack() {
		return lblAttack;
	}


	public JLabel getLabel() {
		return lblDefense;
	}


	public JLabel getLblAt() {
		return lblAt;
	}


	public JLabel getLblDf() {
		return lblDf;
	}


	public JLabel getLblFundopointplayer() {
		return lblFundopointplayer;
	}


	public JLabel getLblAirsmall() {
		return lblAirsmall;
	}


	public JLabel getLblEarthsmall() {
		return lblEarthsmall;
	}


	public JLabel getLblWatersmall() {
		return lblWatersmall;
	}


	public JLabel getLblDefense() {
		return lblDefense;
	}


	public JLabel getLblFundopointmachine() {
		return lblFundopointmachine;
	}


	public JLabel getLblMark() {
		return lblMark;
	}


	public JLabel getLblScoreplayer() {
		return lblScoreplayer;
	}


	public JLabel getLblState() {
		return lblState;
	}


	public JLabel getLblScoremachine() {
		return lblScoremachine;
	}


	public JLabel getLblNameplayer() {
		return lblNameplayer;
	}


	public JLabel getLblLifeplayer() {
		return lblLifeplayer;
	}


	public JLabel getLblLifemachine() {
		return lblLifemachine;
	}


	public JLabel getLblHandmachine() {
		return lblHandmachine;
	}


	public JLabel getLblHandplayer() {
		return lblHandplayer;
	}


	public JPanel getPanelDistraction() {
		return panelDistraction;
	}


	public JLabel getLblLifeP() {
		return lblLifeP;
	}


	public JLabel getLblLifeM() {
		return lblLifeM;
	}


	public JLabel getLblElement() {
		return lblElement;
	}


	public JLabel getLblArrowplayer() {
		return lblArrowplayer;
	}


	public JLabel getLblArrowmachine() {
		return lblArrowmachine;
	}


	public JLabel getLblBackground() {
		return lblBackground;
	}
	
	public JLabel getLblPreviewattack() {
		return lblPreviewattack;
	}


	public JLabel getLblPreviewdefense() {
		return lblPreviewdefense;
	}


	public JLabel getLblPreviewscoreatk() {
		return lblPreviewscoreatk;
	}


	public JLabel getLblPreviewscoredef() {
		return lblPreviewscoredef;
	}


	public JLabel getLblBackgroundOver() {
		return lblBackgroundOver;
	}
	
	
}
