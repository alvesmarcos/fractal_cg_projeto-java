package br.com.mhas.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.UIManager;

public class OptionGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panelOption;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OptionGUI frame = new OptionGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public OptionGUI() {
		
		initOptionGUI();
	}
	
	
	private void initOptionGUI(){
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelOption = new JPanel();
		panelOption.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelOption.setBackground(Color.WHITE);
		panelOption.setBounds(0, 0, 600, 600);
		contentPane.add(panelOption);
		panelOption.setLayout(null);
		
		
		setUndecorated(true);
		
		setLocationRelativeTo(null); 
		
		setResizable(false);
	}
}
