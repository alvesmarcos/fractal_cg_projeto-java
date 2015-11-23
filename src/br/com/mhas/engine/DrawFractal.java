package br.com.mhas.engine;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import br.com.mhas.gui.KochGUI;
import br.com.mhas.gui.OptionGUI;
import br.com.mhas.gui.PanelGUI;
import br.com.mhas.model.Point;


public class DrawFractal {
	
	//attributs
	
	private KochGUI kochWindow;
	
	private static final double COS60 = Math.cos(Math.PI/3.);
	
	private static final double SEN60 = Math.sin(Math.PI/3.) ; 
	
	private static List<Point> point = new ArrayList();
	
	private EventListener event = new EventListener();
	
	public static int level = 1;
	
	private static DefaultTableModel model;
	
	
	//constructor
	
	public DrawFractal(KochGUI kochWindow) {
		
		this.kochWindow = kochWindow;
		
		addListener();
		
		Point init1 = new Point(PanelGUI.PXINICIAL, PanelGUI.PYINICIAL);
		
		Point init2 = new Point(PanelGUI.PXFINAL, PanelGUI.PYFINAL);
		
		point.add(init1);
		
		point.add(init2);
	
		model = (DefaultTableModel) kochWindow.getTablePoints().getModel();
		
		pointsTable();
	}
	
	
	//methods
	
	private void addListener(){
		
		kochWindow.getLblNext().addMouseListener(event);
		
		kochWindow.getLblPrevious().addMouseListener(event);
		
		kochWindow.getLblClose().addMouseListener(event);
		
		kochWindow.addWindowListener(event);
	}
	
	public static void curveKoch(Graphics g, Point p0, Point p4, int level) {
		
		if (level == 1) {
			
			//Composição Point (X,Y)
			
			g.drawLine((int) p0.X, (int) p0.Y, (int) p4.X, (int) p4.Y);
			
			boolean equalsP0 = false;
			
			boolean equalsP4 = false;
			
			for(int i = 0 ; i < point.size(); i++){
				
				if(point.get(i).X == p0.X && point.get(i).Y == p0.Y) equalsP0 = true;

				if(point.get(i).X == p4.X && point.get(i).Y == p4.Y) equalsP4 = true;
				
				if(equalsP0 && equalsP4) break;
			}
			
			if(!equalsP0)point.add(p0);
			
			if(!equalsP4)point.add(p4);
			
			pointsTable(); //para poder pre-visualizar o form KochGUI é necessário comentar essa linha
			
		} else {
			
			level--;
			
			Point p1 = new Point(p0.X + (p4.X - p0.X)/3. , p0.Y + (p4.Y - p0.Y)/3.);
			
			Point p3 = new Point(p4.X - (p4.X - p0.X)/3. , p4.Y - (p4.Y - p0.Y)/3.);
			
			Point p2 = new Point(p1.X + COS60 * (p3.X - p1.X) + SEN60 * (p3.Y - p1.Y), p1.Y - SEN60 * (p3.X - p1.X) + COS60 * (p3.Y - p1.Y));
			
			curveKoch(g, p0, p1, level);
			
			curveKoch(g, p1, p2, level);
			
			curveKoch(g, p2, p3, level);
			
			curveKoch(g, p3, p4, level);
		}
	}
	
	
	private static void pointsTable() {
		
		model.setRowCount(0);
		
		int size = point.size();
		
		for(int i = 0; i < size; i++)
			model.addRow(new Object[]{" P"+model.getRowCount(), point.get(i).X, point.get(i).Y});
	}
	
	
	private class EventListener implements MouseListener, WindowListener {

		
		public void mouseClicked(MouseEvent e) {
			
			if(e.getSource() == kochWindow.getLblNext()){
				
				if(level < 6) level++;
				
				else JOptionPane.showMessageDialog(null,"Você está na última iteração suportada !", "Sistema", JOptionPane.ERROR_MESSAGE);
				
				
			} else if (e.getSource() == kochWindow.getLblPrevious()){
				
				if(level > 1) level--;	
				
				else JOptionPane.showMessageDialog(null,"Você já está na primeira iteração !", "Sistema", JOptionPane.ERROR_MESSAGE);
				
			
			} else if (e.getSource() == kochWindow.getLblClose()){
				
				new OptionGUI().setVisible(true);
				
				level = 1;
				
				kochWindow.dispose();
			}
			
			if(!(level > 7 || level < 1)){
				
				kochWindow.getLblCounter().setText(""+level);
			
				kochWindow.getPanelFractal().repaint();
			
				point.clear();
			}
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}

		public void mousePressed(MouseEvent e) {
		
		}

		public void mouseReleased(MouseEvent e) {

		}

		public void windowActivated(WindowEvent e) {
		}

		public void windowClosed(WindowEvent e) {
			
		}
		public void windowClosing(WindowEvent e) {
			
			new OptionGUI().setVisible(true);
			
			kochWindow.dispose();
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
