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
	private JLabel lblIcoquadrado;
	private JPanel panelAlternativeB;
	private JLabel lblTringulo;
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
	
	//controlador
	
	private Quiz quizWindow;
	private JLabel lblIcoinfo;
	private JLabel label_2;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizGUI frame = new QuizGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public QuizGUI() {
		
		iniciaComponentes();
		
		quizWindow = new Quiz(this);
	}
	
	
	private void iniciaComponentes(){
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	//	setResizable(false);
		
		setBounds(325,45, 874, 600);
		
		setLocationRelativeTo(null);
		
		setUndecorated(true);
	
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblImageFractal = new JLabel("");
		lblImageFractal.setIcon(new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/lines-white.png")));
		lblImageFractal.setBounds(95, 32, 383, 341);
		contentPane.add(lblImageFractal);
		lblImageFractal.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				
		panelChoice = new JPanel();
		panelChoice.setBorder(new LineBorder(Color.WHITE));
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
		
		JLabel label = new JLabel("______");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
		label.setBounds(45, 61, 92, 37);
		panelAlternativeA.add(label);
		
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
		
		lblTringulo = new JLabel("");
		lblTringulo.setIcon(new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/fractal_461_fig.gif")));
		lblTringulo.setFont(new Font("Trajan Pro", Font.PLAIN, 23));
		lblTringulo.setBounds(33, 26, 100, 100);
		panelAlternativeB.add(lblTringulo);
		
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
		
		lblIcoquadrado = new JLabel("");
		lblIcoquadrado.setFont(new Font("Trajan Pro", Font.PLAIN, 23));
		lblIcoquadrado.setIcon(new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/quadrado.png")));
		lblIcoquadrado.setBounds(36, 26, 100, 100);
		panelAlternativeC.add(lblIcoquadrado);
		
		panelColorC = new JPanel();
		panelColorC.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelColorC.setBackground(new Color(245, 245, 220));
		panelColorC.setBounds(0, 0, 28, 158);
		panelAlternativeC.add(panelColorC);
		
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
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/timer.png")));
		label_2.setBounds(20, 11, 64, 64);
		panelTimer.add(label_2);
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
		lblBackgroundTimer.setBorder(new LineBorder(Color.WHITE));
		
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
		lblBackgroundInfo.setBorder(new LineBorder(Color.WHITE));
	
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/dark-steel-full-hd-wallpaper-1zq.jpg")));
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
}
