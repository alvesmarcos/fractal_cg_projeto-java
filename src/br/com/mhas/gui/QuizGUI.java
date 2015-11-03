package br.com.mhas.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
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

public class QuizGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblImageFundo;
	private JPanel panelPrincipal;
	private JLabel lblImagefractal;
	private JPanel panelCronometro;
	private JLabel lblLblfundovisor;
	private JPanel panelContagem;
	private JLabel lblFundocontagem;
	private JLabel lblIcoquadrado;
	private JPanel panel_1;
	private JLabel lblTringulo;
	private JPanel panel_2;
	private JLabel lblReta;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel lblInteracoesfundo;
	
	//controlador
	
	//private QuizControl quizControl;
	
	
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
		
	//	quizControl = new QuizControl(this);
	}
	
	
	private void iniciaComponentes(){
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	//	setResizable(false);
		
		setBounds(325,45, 1024, 600);
		
		setLocationRelativeTo(null);
		
		setUndecorated(true);
	
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelCronometro = new JPanel();
		panelCronometro.setBorder(new LineBorder(new Color(119, 136, 153)));
		panelCronometro.setBounds(632, 29, 238, 64);
		contentPane.add(panelCronometro);
		panelCronometro.setLayout(null);
		
		label = new JLabel("1");
		label.setBounds(22, 11, 37, 48);
		panelCronometro.add(label);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Trajan Pro", Font.PLAIN, 47));
		
		label_1 = new JLabel("2");
		label_1.setBounds(69, 11, 37, 48);
		panelCronometro.add(label_1);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Trajan Pro", Font.PLAIN, 47));
		
		label_2 = new JLabel("3");
		label_2.setBounds(127, 11, 45, 48);
		panelCronometro.add(label_2);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Trajan Pro", Font.PLAIN, 47));
		
		label_3 = new JLabel("4");
		label_3.setBounds(183, 11, 34, 48);
		panelCronometro.add(label_3);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Trajan Pro", Font.PLAIN, 47));
		
		lblInteracoesfundo = new JLabel("");
		lblInteracoesfundo.setIcon(new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/texture-texture-blue-color-abrasion.jpg")));
		lblInteracoesfundo.setBounds(0, 0, 238, 64);
		panelCronometro.add(lblInteracoesfundo);
		lblInteracoesfundo.setBorder(new LineBorder(new Color(119, 136, 153)));

		
		lblLblfundovisor = new JLabel("");
		lblLblfundovisor.setForeground(Color.DARK_GRAY);
		lblLblfundovisor.setBounds(154, 29, 330, 312);
		contentPane.add(lblLblfundovisor);
		lblLblfundovisor.setBackground(new Color(192, 192, 192));
		lblLblfundovisor.setBorder(new LineBorder(new Color(119, 136, 153)));
		
		lblImagefractal = new JLabel("");
		lblImagefractal.setIcon(new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/box3.jpg")));
		lblImagefractal.setBounds(173, 47, 291, 276);
		contentPane.add(lblImagefractal);
		lblImagefractal.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		panelContagem = new JPanel();
		panelContagem.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelContagem.setBounds(0, 0, 78, 600);
		contentPane.add(panelContagem);
		panelContagem.setLayout(null);
		
		lblFundocontagem = new JLabel("");
		lblFundocontagem.setIcon(new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/original.jpg")));
		lblFundocontagem.setBounds(0, 0, 78, 600);
		panelContagem.add(lblFundocontagem);
		lblFundocontagem.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel panel = new JPanel();
		panel.setBounds(549, 104, 412, 219);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 393, 59);
		panel.add(panel_2);
		panel_2.setBackground(Color.WHITE);
		panel_2.setLayout(null);
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		lblReta = new JLabel("| | - Reta");
		lblReta.setFont(new Font("Trajan Pro", Font.PLAIN, 23));
		lblReta.setBounds(10, 11, 235, 37);
		panel_2.add(lblReta);
		
		panel_1 = new JPanel();
		panel_1.setBounds(10, 81, 393, 59);
		panel.add(panel_1);
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setLayout(null);
		
		lblTringulo = new JLabel(" - Tri\u00E2ngulo");
		lblTringulo.setIcon(new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/triangulo-button.png")));
		lblTringulo.setFont(new Font("Trajan Pro", Font.PLAIN, 23));
		lblTringulo.setBounds(10, 11, 235, 37);
		panel_1.add(lblTringulo);
		
		panelPrincipal = new JPanel();
		panelPrincipal.setBounds(10, 151, 393, 59);
		panel.add(panelPrincipal);
		panelPrincipal.setBackground(Color.WHITE);
		panelPrincipal.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelPrincipal.setLayout(null);
		
		lblIcoquadrado = new JLabel(" - Quadrado");
		lblIcoquadrado.setFont(new Font("Trajan Pro", Font.PLAIN, 23));
		lblIcoquadrado.setIcon(new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/quadrado-button.png")));
		lblIcoquadrado.setBounds(10, 11, 235, 37);
		panelPrincipal.add(lblIcoquadrado);
		
	JLabel lblFundoresposta = new JLabel("");
		lblFundoresposta.setIcon(new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/texture-texture-blue-color-abrasion.jpg")));
		lblFundoresposta.setBounds(0, 0, 412, 220);
		panel.add(lblFundoresposta);
		lblFundoresposta.setBorder(new LineBorder(new Color(119, 136, 153))); 
		
		lblImageFundo = new JLabel("");
		lblImageFundo.setIcon(new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/texture-texture-blue-color-abrasion.jpg")));
		lblImageFundo.setBounds(10, 0, 1024, 600);
		lblImageFundo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(lblImageFundo);  
	}	
}
