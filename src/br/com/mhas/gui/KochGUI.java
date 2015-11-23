package br.com.mhas.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import br.com.mhas.engine.DrawFractal;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;

public class KochGUI extends JFrame {

	private JPanel contentPane;
	private JTable tablePoints;
	private PanelGUI panelFractal;
	private JPanel panelTable;
	private JScrollPane scrollPane;
	private JLabel lblNext;
	private JLabel lblPrevious;
	private JLabel lblNvel ;
	private JLabel lblCounter;
	private JLabel lblBackgroundframe;
	
	private DrawFractal drawFractal;
	private JLabel lblClose;
	
	
	
	public KochGUI() {
		
		initKochGUI();
		
		drawFractal = new DrawFractal(this);
	}
	
	
	private void initKochGUI() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setUndecorated(true);
		
		setLocationRelativeTo(null); 
		
		setResizable(false);
		
		panelTable = new JPanel();
		panelTable.setBackground(Color.DARK_GRAY);
		panelTable.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		panelTable.setBounds(26, 362, 548, 221);
		contentPane.add(panelTable);
		panelTable.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 528, 198);
		panelTable.add(scrollPane);
		
		tablePoints = new JTable();
		tablePoints.setFont(new Font("Trajan Pro", Font.BOLD, 14));
		tablePoints.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"PONTO", "COORDENADA (X)", "COORDENADA (Y)"
				}
			));
		scrollPane.setViewportView(tablePoints);
		
		panelFractal = new PanelGUI();
		panelFractal.setBackground(Color.DARK_GRAY);
		panelFractal.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		panelFractal.setBounds(26, 32, 548, 229);
		contentPane.add(panelFractal);
		panelFractal.setLayout(null);
		
		
		
		lblNext = new JLabel("");
		lblNext.setIcon(new ImageIcon(KochGUI.class.getResource("/br/com/mhas/image/play128.png")));
		lblNext.setBounds(334, 272, 64, 64);
		contentPane.add(lblNext);
		lblNext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblPrevious = new JLabel("");
		lblPrevious.setIcon(new ImageIcon(KochGUI.class.getResource("/br/com/mhas/image/previous-ico.png")));
		lblPrevious.setBounds(201, 272, 64, 64);
		lblPrevious.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(lblPrevious);
		
		lblNvel = new JLabel("N\u00EDvel");
		lblNvel.setFont(new Font("Trajan Pro", Font.PLAIN, 15));
		lblNvel.setBounds(275, 331, 49, 20);
		contentPane.add(lblNvel);
		
		lblCounter = new JLabel("1");
		lblCounter.setFont(new Font("Trajan Pro", Font.PLAIN, 70));
		lblCounter.setBounds(278, 272, 46, 64);
		contentPane.add(lblCounter);
		
		lblClose = new JLabel("");
		lblClose.setToolTipText("FECHAR");
		lblClose.setIcon(new ImageIcon(KochGUI.class.getResource("/br/com/mhas/image/cross-27156_640.png")));
		lblClose.setBounds(498, 272, 76, 75);
		contentPane.add(lblClose);
		lblClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	
		
		lblBackgroundframe = new JLabel("");
		lblBackgroundframe.setIcon(new ImageIcon(KochGUI.class.getResource("/br/com/mhas/image/fundo1.jpg")));
		lblBackgroundframe.setBounds(0, 0, 600, 600);
		contentPane.add(lblBackgroundframe);
		lblBackgroundframe.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null)); 
	}


	public JTable getTablePoints() {
		return tablePoints;
	}


	public JLabel getLblNext() {
		return lblNext;
	}


	public JLabel getLblPrevious() {
		return lblPrevious;
	}

	public JLabel getLblCounter() {
		return lblCounter;
	}
	
	public JPanel getPanelFractal() {
		
		return panelFractal;
	}


	public JLabel getLblClose() {
		return lblClose;
	}
	
	
}
