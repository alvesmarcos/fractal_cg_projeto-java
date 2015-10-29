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

public class QuizGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblImageFundo;
	private JPanel panelPrincipal;
	private JPanel panelReta;
	private JLabel lblReta;
	private JLabel lblReta1;
	private JLabel lblReta2;
	private JPanel panelTriangulo;
	private JLabel lblTriangulo;
	private JPanel panelQuadrado;
	private JLabel lblQuadrado;
	private JLabel lblFundopanelprincipal;
	private JLabel lblImagefractal;
	private JPanel panelCronometro;
	private JLabel lblLblfundovisor;
	
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
		
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelPrincipal.setBounds(23, 350, 435, 158);
		contentPane.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		//panelPrincipal.setVisible(false);
		
		panelReta = new JPanel();
		panelReta.setBorder(new LineBorder(new Color(153, 153, 153)));
		panelReta.setBackground(Color.WHITE);
		panelReta.setBounds(12, 15, 129, 131);
		panelPrincipal.add(panelReta);
		panelReta.setLayout(null);
		panelReta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		lblReta = new JLabel("____________________");
		lblReta.setFont(new Font("Corbel", Font.PLAIN, 11));
		lblReta.setBounds(12, 57, 117, 15);
		panelReta.add(lblReta);
		
		lblReta1 = new JLabel("____________________");
		lblReta1.setFont(new Font("Corbel", Font.PLAIN, 11));
		lblReta1.setBounds(12, 58, 105, 15);
		panelReta.add(lblReta1);
		
		lblReta2 = new JLabel("____________________");
		lblReta2.setFont(new Font("Corbel", Font.PLAIN, 11));
		lblReta2.setBounds(12, 59, 105, 15);
		panelReta.add(lblReta2);
		
		panelTriangulo = new JPanel();
		panelTriangulo.setBorder(new LineBorder(new Color(153, 153, 153)));
		panelTriangulo.setBackground(Color.WHITE);
		panelTriangulo.setBounds(153, 15, 129, 131);
		panelPrincipal.add(panelTriangulo);
		panelTriangulo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panelTriangulo.setLayout(null);
		
		lblTriangulo = new JLabel("");
		lblTriangulo.setIcon(new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/triangulo2.png")));
		lblTriangulo.setBounds(12, 12, 105, 107);
		panelTriangulo.add(lblTriangulo);
		
		panelQuadrado = new JPanel();
		panelQuadrado.setBorder(new LineBorder(new Color(153, 153, 153)));
		panelQuadrado.setBackground(Color.WHITE);
		panelQuadrado.setBounds(294, 15, 129, 131);
		panelPrincipal.add(panelQuadrado);
		panelQuadrado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panelQuadrado.setLayout(null);
		
		lblQuadrado = new JLabel("");
		lblQuadrado.setIcon(new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/quadrado.png")));
		lblQuadrado.setBounds(0, 12, 129, 107);
		panelQuadrado.add(lblQuadrado);
		
		lblFundopanelprincipal = new JLabel("");
		lblFundopanelprincipal.setBackground(new Color(112, 128, 144));
		lblFundopanelprincipal.setIcon(new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/FundoAr.jpg")));
		lblFundopanelprincipal.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblFundopanelprincipal.setBounds(0, 0, 435, 158);
		panelPrincipal.add(lblFundopanelprincipal);
		
		panelCronometro = new JPanel();
		panelCronometro.setBorder(new LineBorder(new Color(119, 136, 153)));
		panelCronometro.setBounds(597, 28, 172, 103);
		contentPane.add(panelCronometro);
		panelCronometro.setLayout(null);

		
		lblLblfundovisor = new JLabel("");
		lblLblfundovisor.setForeground(Color.DARK_GRAY);
		lblLblfundovisor.setBounds(70, 12, 330, 312);
		contentPane.add(lblLblfundovisor);
		lblLblfundovisor.setBackground(new Color(192, 192, 192));
		lblLblfundovisor.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		lblImagefractal = new JLabel("");
		lblImagefractal.setIcon(new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/box3.jpg")));
		lblImagefractal.setBounds(89, 30, 291, 276);
		contentPane.add(lblImagefractal);
		lblImagefractal.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
	/*	
		lblImageFundo = new JLabel("");
		lblImageFundo.setIcon(new ImageIcon(QuizGUI.class.getResource("/br/com/mhas/image/0000000002999.jpg")));
		lblImageFundo.setBounds(0, 0, 670, 524);
		lblImageFundo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(lblImageFundo);  */
	}	
}
