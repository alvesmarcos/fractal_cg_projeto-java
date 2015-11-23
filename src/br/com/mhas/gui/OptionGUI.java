package br.com.mhas.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

import br.com.mhas.engine.Option;

import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

public class OptionGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panelOption;
	private JLabel lblBackground;
	private JPanel panelQuestion;
	private JLabel lblQuestion;
	private JPanel panelKochCurve;
	private JLabel lblIconKoch;
	private JPanel panelAbout;
	private JLabel lblAboutIcon;
	private JPanel panelExit;
	private JLabel lblCurvaDeKoch;
	private JLabel lblExitIcon;
	private JLabel lblRespostas;
	private JLabel lblSair;
	private JPanel panelCardBattle;
	private JLabel lblCardbattle;
	private JLabel lblBatalhaDeCartas;
	private JLabel lblPerguntas;
	
	private Option option;
	
	
	public OptionGUI() {
		
		initOptionGUI();
		
		option = new Option(this);
	}
	
	
	private void initOptionGUI(){
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setUndecorated(true);
		
		setLocationRelativeTo(null); 
		
		setResizable(false);
		
		panelOption = new JPanel();
		panelOption.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelOption.setBackground(Color.WHITE);
		panelOption.setBounds(0, 0, 600, 600);
		contentPane.add(panelOption);
		panelOption.setLayout(null);
		
		panelCardBattle = new JPanel();
		panelCardBattle.setBackground(new Color(51, 204, 255));
		panelCardBattle.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
		panelCardBattle.setBounds(10, 10, 285, 285);
		panelOption.add(panelCardBattle);
		panelCardBattle.setLayout(null);
		panelCardBattle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblCardbattle = new JLabel("");
		lblCardbattle.setIcon(new ImageIcon(OptionGUI.class.getResource("/br/com/mhas/image/bridge1.png")));
		lblCardbattle.setBounds(50, 28, 185, 185);
		panelCardBattle.add(lblCardbattle);
		
		lblBatalhaDeCartas = new JLabel("Batalha de Cartas");
		lblBatalhaDeCartas.setForeground(Color.WHITE);
		lblBatalhaDeCartas.setFont(new Font("Trajan Pro", Font.BOLD, 22));
		lblBatalhaDeCartas.setBounds(22, 226, 253, 43);
		panelCardBattle.add(lblBatalhaDeCartas);
		
		panelQuestion = new JPanel();
		panelQuestion.setBackground(new Color(51, 255, 153));
		panelQuestion.setLayout(null);
		panelQuestion.setBorder(new LineBorder(new Color(192, 192, 192), 3));
		panelQuestion.setBounds(305, 10, 285, 285);
		panelOption.add(panelQuestion);
		panelQuestion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblQuestion = new JLabel("");
		lblQuestion.setIcon(new ImageIcon(OptionGUI.class.getResource("/br/com/mhas/image/bald.png")));
		lblQuestion.setBounds(56, 27, 185, 189);
		panelQuestion.add(lblQuestion);
		
		lblPerguntas = new JLabel("Perguntas");
		lblPerguntas.setForeground(Color.WHITE);
		lblPerguntas.setFont(new Font("Trajan Pro", Font.BOLD, 22));
		lblPerguntas.setBounds(22, 227, 136, 43);
		panelQuestion.add(lblPerguntas);
		
		panelKochCurve = new JPanel();
		panelKochCurve.setBackground(Color.ORANGE);
		panelKochCurve.setLayout(null);
		panelKochCurve.setBorder(new LineBorder(new Color(192, 192, 192), 3));
		panelKochCurve.setBounds(10, 304, 285, 285);
		panelOption.add(panelKochCurve);
		panelKochCurve.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblIconKoch = new JLabel("");
		lblIconKoch.setIcon(new ImageIcon(OptionGUI.class.getResource("/br/com/mhas/image/ice89.png")));
		lblIconKoch.setBounds(56, 27, 186, 185);
		panelKochCurve.add(lblIconKoch);
		
		lblCurvaDeKoch = new JLabel("Curva de Koch");
		lblCurvaDeKoch.setForeground(Color.WHITE);
		lblCurvaDeKoch.setFont(new Font("Trajan Pro", Font.BOLD, 22));
		lblCurvaDeKoch.setBounds(22, 226, 200, 43);
		panelKochCurve.add(lblCurvaDeKoch);
		
		panelAbout = new JPanel();
		panelAbout.setBackground(new Color(255, 0, 153));
		panelAbout.setLayout(null);
		panelAbout.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
		panelAbout.setBounds(305, 304, 285, 140);
		panelOption.add(panelAbout);
		panelAbout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblAboutIcon = new JLabel("");
		lblAboutIcon.setIcon(new ImageIcon(OptionGUI.class.getResource("/br/com/mhas/image/data12.png")));
		lblAboutIcon.setBounds(152, 11, 118, 118);
		panelAbout.add(lblAboutIcon);
		
		lblRespostas = new JLabel("Sobre");
		lblRespostas.setForeground(Color.WHITE);
		lblRespostas.setFont(new Font("Trajan Pro", Font.BOLD, 22));
		lblRespostas.setBounds(43, 55, 75, 43);
		panelAbout.add(lblRespostas);
		
		panelExit = new JPanel();
		panelExit.setBackground(new Color(102, 102, 102));
		panelExit.setLayout(null);
		panelExit.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
		panelExit.setBounds(305, 449, 285, 140);
		panelOption.add(panelExit);
		panelExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblExitIcon = new JLabel("");
		lblExitIcon.setIcon(new ImageIcon(OptionGUI.class.getResource("/br/com/mhas/image/bad7.png")));
		lblExitIcon.setBounds(150, 11, 118, 118);
		panelExit.add(lblExitIcon);
		
		lblSair = new JLabel("Sair");
		lblSair.setForeground(Color.WHITE);
		lblSair.setFont(new Font("Trajan Pro", Font.BOLD, 22));
		lblSair.setBounds(49, 53, 66, 43);
		panelExit.add(lblSair);

		lblBackground = new JLabel("Background");
		lblBackground.setBounds(0, 0, 600, 600);
		panelOption.add(lblBackground);
		lblBackground.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblBackground.setIcon(new ImageIcon(OptionGUI.class.getResource("/br/com/mhas/image/dark-steel-full-hd-wallpaper-1zq.jpg")));
	}


	public JPanel getPanelOption() {
		return panelOption;
	}


	public JPanel getPanelQuestion() {
		return panelQuestion;
	}


	public JPanel getPanelKochCurve() {
		return panelKochCurve;
	}


	public JPanel getPanelAbout() {
		return panelAbout;
	}


	public JPanel getPanelExit() {
		return panelExit;
	}


	public JPanel getPanelCardBattle() {
		return panelCardBattle;
	}
	
	
	
}
