package br.com.mhas.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import br.com.mhas.engine.DrawFractal;
import br.com.mhas.model.Point;

public class PanelGUI extends JPanel {
	
	public final static int PXINICIAL = 20;
	
	public final static int PYINICIAL = 190;
	
	public final static int PXFINAL = 528;
	
	public final static int PYFINAL = 190;
	
	
	//methods
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		g.setColor(Color.WHITE);
		
		Point p0 = new Point(PXINICIAL, PYINICIAL);
		
		Point p4 = new Point(PXFINAL, PYFINAL);
		
		DrawFractal.curveKoch(g, p0, p4, DrawFractal.level);
	
	}
}
