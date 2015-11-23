package br.com.mhas.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import br.com.mhas.engine.Quiz;

public class QuizGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblBackground;
	private JPanel panelAlternativeC;
	private JLabel lblImageFractal;
	private JLabel lblAlternativeC;
	private JPanel panelAlternativeB;
	private JLabel lblAlternativeB;
	private JPanel panelAlternativeA;
	private JLabel lblTimer;
	private JLabel lblTempoRestante;
	private JLabel lblNext;
	private JLabel lblBackgroundTimer;
	private JLabel lblBackgroundSight;
	private JPanel panelSight;
	private JPanel panelColorA;
	private JLabel lblProximo;
	private JPanel panelChoice;
	private JPanel panelColorB;
	private JPanel panelColorC;
	private JPanel panelTimer;
	private JPanel panelInfo;
	private JLabel lblBackgroundInfo;
	private JLabel lblFractal;
	private JLabel lblCounter;
	private JLabel lblName;
	private JLabel lblAlternativeA;
	private JLabel lblIcoinfo;
	private JLabel lblIconTimer;
	private JLabel lblIconChoice;
	private JPanel panelScore;
	private JLabel lblResult;
	private JLabel lblIconResult;
	private JLabel lblScore;
	private JLabel lblIconScore;
	private JLabel lblStatus;
	private JLabel lblClose;
	private JLabel lblBackgroundPanel;
	
	//controlador
	
	private Quiz quiz;
	
	
	public QuizGUI() {
		
		initQuizGUI();
		
		quiz = new Quiz(this);
	}
	
	
	private void initQuizGUI(){
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setResizable(false);
		
		setBounds(325,45, 874, 600);
		
		setLocationRelativeTo(null);
		
		setUndecorated(true);
	
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*** ===================================================================================================
		
											BEGIN PANEL SCORE

		 **  ===================================================================================================== **/

	
		panelScore = new JPanel();
		panelScore.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelScore.setBounds(223, 130, 429, 300);
		contentPane.add(panelScore);
		panelScore.setLayout(null);
		panelScore.setVisible(false);
		
		lblResult = new JLabel("Resultado");
		lblResult.setForeground(Color.DARK_GRAY);
		lblResult.setFont(new Font("Trajan Pro", Font.PLAIN, 30));
		lblResult.setBounds(144, 11, 220, 82);
		panelScore.add(lblResult);
		
		lblIconResult = new JLabel("IconResult");
		lblIconResult.setIcon(new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/done2(4).png")));
		lblIconResult.setBounds(33, 17, 66, 72);
		panelScore.add(lblIconResult);
		
		lblScore = new JLabel("00/15");
		lblScore.setForeground(Color.DARK_GRAY);
		lblScore.setFont(new Font("Trajan Pro", Font.PLAIN, 120));
		lblScore.setBounds(69, 90, 348, 149);
		panelScore.add(lblScore);
	
		lblIconScore = new JLabel("");
		lblIconScore.setIcon(new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/position5(1).png")));
		lblIconScore.setBounds(33, 219, 83, 70);
		panelScore.add(lblIconScore);
	
		lblStatus = new JLabel("  Regular");
		lblStatus.setForeground(Color.DARK_GRAY);
		lblStatus.setFont(new Font("Trajan Pro", Font.PLAIN, 25));
		lblStatus.setBounds(160, 218, 141, 82);
		panelScore.add(lblStatus);
	
		lblClose = new JLabel("");
		lblClose.setIcon(new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/close20.png")));
		lblClose.setBounds(383, 11, 34, 32);
		panelScore.add(lblClose);
		lblClose.setBorder(new LineBorder(Color.DARK_GRAY));
		lblClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	
		lblBackgroundPanel = new JLabel("");
		lblBackgroundPanel.setIcon(new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/gray-120.jpg")));
		lblBackgroundPanel.setBounds(0, 0, 429, 300);
		panelScore.add(lblBackgroundPanel);
		lblBackgroundPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));


	/*** ===================================================================================================

												END PANEL SCORE

	 **  ===================================================================================================== **/
			
		
		lblImageFractal = new JLabel("");
		lblImageFractal.setBounds(95, 32, 383, 341);
		contentPane.add(lblImageFractal);
		lblImageFractal.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				
		panelChoice = new JPanel();
		panelChoice.setBorder(new LineBorder(Color.BLACK));
		panelChoice.setBackground(Color.DARK_GRAY);
		panelChoice.setBounds(22, 405, 538, 177);
		contentPane.add(panelChoice);
		panelChoice.setLayout(null);
		
		panelAlternativeA = new JPanel();
		panelAlternativeA.setBounds(10, 11, 165, 158);
		panelChoice.add(panelAlternativeA);
		panelAlternativeA.setBackground(Color.WHITE);
		panelAlternativeA.setLayout(null);
		panelAlternativeA.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelAlternativeA.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblAlternativeA = new JLabel("");
		lblAlternativeA.setIcon(new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/q7-alternativeB.BMP")));
		lblAlternativeA.setForeground(Color.BLACK);
		lblAlternativeA.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
		lblAlternativeA.setBounds(44, 26, 100, 100);
		panelAlternativeA.add(lblAlternativeA);
		
		panelColorA = new JPanel();
		panelColorA.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelColorA.setBackground(new Color(245, 245, 220));
		panelColorA.setBounds(0, 0, 28, 158);
		panelAlternativeA.add(panelColorA);
	
		
		panelAlternativeB = new JPanel();
		panelAlternativeB.setBounds(187, 11, 165, 158);
		panelChoice.add(panelAlternativeB);
		panelAlternativeB.setBackground(Color.WHITE);
		panelAlternativeB.setLayout(null);
		panelAlternativeB.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelAlternativeB.setLayout(null);
		panelAlternativeB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblAlternativeB = new JLabel("");
		lblAlternativeB.setIcon(new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/fractal_461_fig.gif")));
		lblAlternativeB.setFont(new Font("Trajan Pro", Font.PLAIN, 23));
		lblAlternativeB.setBounds(44, 26, 100, 100);
		panelAlternativeB.add(lblAlternativeB);
		
		panelColorB = new JPanel();
		panelColorB.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelColorB.setBackground(new Color(245, 245, 220));
		panelColorB.setBounds(0, 0, 28, 158);
		panelAlternativeB.add(panelColorB);
		
		panelAlternativeC = new JPanel();
		panelAlternativeC.setBounds(362, 11, 165, 158);
		panelChoice.add(panelAlternativeC);
		panelAlternativeC.setBackground(Color.WHITE);
		panelAlternativeC.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelAlternativeC.setLayout(null);
		panelAlternativeC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblAlternativeC = new JLabel("");
		lblAlternativeC.setFont(new Font("Trajan Pro", Font.PLAIN, 23));
		lblAlternativeC.setIcon(new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/quadrado.png")));
		lblAlternativeC.setBounds(44, 26, 100, 100);
		panelAlternativeC.add(lblAlternativeC);
		
		panelColorC = new JPanel();
		panelColorC.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelColorC.setBackground(new Color(245, 245, 220));
		panelColorC.setBounds(0, 0, 28, 158);
		panelAlternativeC.add(panelColorC);
		
		lblIconChoice = new JLabel("");
		lblIconChoice.setIcon(new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/deriner-gris-degrade1.jpg")));
		lblIconChoice.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblIconChoice.setBounds(0,0, 538, 177);
		panelChoice.add(lblIconChoice);
		
		panelTimer = new JPanel();
		panelTimer.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTimer.setBackground(Color.DARK_GRAY);
		panelTimer.setBounds(582, 22, 257, 363);
		contentPane.add(panelTimer);
		panelTimer.setLayout(null);
		
		lblNext = new JLabel("");
		lblNext.setBounds(105, 254, 141, 98);
		panelTimer.add(lblNext);
		lblNext.setIcon(new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/right-arrow7.png")));
		lblNext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblTempoRestante = new JLabel("Tempo restante: ");
		lblTempoRestante.setBounds(93, 32, 181, 14);
		panelTimer.add(lblTempoRestante);
		lblTempoRestante.setForeground(Color.WHITE);
		lblTempoRestante.setFont(new Font("Trajan Pro", Font.PLAIN, 14));
		
		lblProximo = new JLabel("Pr\u00F3ximo");
		lblProximo.setForeground(Color.WHITE);
		lblProximo.setFont(new Font("Trajan Pro", Font.PLAIN, 15));
		lblProximo.setBounds(31, 285, 84, 14);
		panelTimer.add(lblProximo);
		
		lblIconTimer = new JLabel("");
		lblIconTimer.setIcon(new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/timer.png")));
		lblIconTimer.setBounds(20, 11, 64, 64);
		panelTimer.add(lblIconTimer);
		
		lblTimer = new JLabel("10");
		lblTimer.setBounds(23, 57, 226, 238);
		panelTimer.add(lblTimer);
		lblTimer.setForeground(Color.WHITE);
		lblTimer.setFont(new Font("Trajan Pro", Font.PLAIN, 180));
		
		lblBackgroundTimer = new JLabel("Pr\u00F3ximo");
		lblBackgroundTimer.setIcon(new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/FundoVectorWater.jpg")));
		lblBackgroundTimer.setBounds(0, 0, 257, 363);
		panelTimer.add(lblBackgroundTimer);
		lblBackgroundTimer.setForeground(Color.WHITE);
		lblBackgroundTimer.setFont(new Font("Trajan Pro", Font.PLAIN, 15));
		lblBackgroundTimer.setBorder(new LineBorder(Color.BLACK));
		
		panelSight = new JPanel();
		panelSight.setBackground(Color.DARK_GRAY);
		panelSight.setForeground(Color.DARK_GRAY);
		panelSight.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelSight.setBounds(84, 22, 405, 363);
		contentPane.add(panelSight);
		panelSight.setLayout(null);
		
		lblBackgroundSight = new JLabel("1/1");
		lblBackgroundSight.setBounds(0, 0, 405, 363);
		panelSight.add(lblBackgroundSight);
		lblBackgroundSight.setIcon(new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/FundoVectorWater.jpg")));
		lblBackgroundSight.setForeground(Color.WHITE);
		lblBackgroundSight.setFont(new Font("Trajan Pro", Font.PLAIN, 24));
		lblBackgroundSight.setBorder(new LineBorder(Color.WHITE));
		
		panelInfo = new JPanel();
		panelInfo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelInfo.setBackground(Color.DARK_GRAY);
		panelInfo.setBounds(582, 405, 257, 177);
		contentPane.add(panelInfo);
		panelInfo.setLayout(null);
		
		lblFractal = new JLabel(" Fractal:");
		lblFractal.setForeground(Color.WHITE);
		lblFractal.setFont(new Font("Trajan Pro", Font.PLAIN, 15));
		lblFractal.setBounds(10, 113, 84, 19);
		panelInfo.add(lblFractal);
		
		lblCounter = new JLabel("01/15");
		lblCounter.setForeground(Color.WHITE);
		lblCounter.setFont(new Font("Trajan Pro", Font.PLAIN, 45));
		lblCounter.setBounds(99, 13, 143, 89);
		panelInfo.add(lblCounter);
		
		lblName = new JLabel("N\u00E3o Especificado");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Trajan Pro", Font.PLAIN, 15));
		lblName.setBounds(99, 113, 171, 19);
		panelInfo.add(lblName);
		
		lblIcoinfo = new JLabel("");
		lblIcoinfo.setIcon(new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/information79.png")));
		lblIcoinfo.setBounds(10, 29, 64, 64);
		panelInfo.add(lblIcoinfo);
		
		lblBackgroundInfo = new JLabel("");
		lblBackgroundInfo.setBounds(0, 0, 257, 177);
		panelInfo.add(lblBackgroundInfo);
		lblBackgroundInfo.setIcon(new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/FundoVectorWater.jpg")));
		lblBackgroundInfo.setForeground(Color.WHITE);
		lblBackgroundInfo.setFont(new Font("Trajan Pro", Font.PLAIN, 15));
		lblBackgroundInfo.setBorder(new LineBorder(Color.BLACK));
		
		
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/fundo1.jpg")));
		lblBackground.setBounds(0, 0, 874, 600);
		lblBackground.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(lblBackground);  
		
	}


	public JPanel getPanelAlternativeC() {
		return panelAlternativeC;
	}


	public JLabel getLblImageFractal() {
		return lblImageFractal;
	}


	public JPanel getPanelAlternativeB() {
		return panelAlternativeB;
	}


	public JPanel getPanelAlternativeA() {
		return panelAlternativeA;
	}


	public JPanel getPanelColorA() {
		return panelColorA;
	}


	public JPanel getPanelColorB() {
		return panelColorB;
	}


	public JPanel getPanelColorC() {
		return panelColorC;
	}


	public JLabel getLblTimer() {
		return lblTimer;
	}	
	
	public JLabel getLblNext() {
		return lblNext;
	}
	
	public JLabel getLblCounter() {
		return lblCounter;
	}
	
	public JLabel getLblName() {
		return lblName;
	}
	
	public JPanel getPanelChoice() {
		return panelChoice;
	}
	
	public JPanel getPanelSight() {
		return panelSight;
	}
	
	public JPanel getPanelTimer() {
		return panelTimer;
	}
	
	public JPanel getPanelInfo() {
		return panelInfo;
	}


	public JLabel getLblAlternativeC() {
		return lblAlternativeC;
	}


	public JLabel getLblAlternativeB() {
		return lblAlternativeB;
	}


	public JLabel getLblAlternativeA() {
		return lblAlternativeA;
	}


	public JPanel getPanelScore() {
		return panelScore;
	}


	public JLabel getLblScore() {
		return lblScore;
	}


	public JLabel getLblStatus() {
		return lblStatus;
	}
	
	public JLabel getLblClose() {
		return lblClose;
	}
}
