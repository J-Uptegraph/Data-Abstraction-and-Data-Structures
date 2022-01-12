import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Draw extends JPanel {
	JFrame window = new JFrame("Game Template");
	Timer tmr = null;
	Random rnd = new Random();
	
	Image imgMap = java.awt.Toolkit.getDefaultToolkit().getImage("FinalProjectGraph_Final_400x400.png");
	
	ArrayList<Point> pts = new ArrayList<Point>();
	Stroke s = new BasicStroke(4.0f,
					BasicStroke.CAP_ROUND,	
					BasicStroke.JOIN_MITER,
					10.0f,
					new float[] {20},
					0.0f);
				
	public Draw() {
		window.setBounds(50, 50, 500, 500);
		window.setAlwaysOnTop(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.getContentPane().add(this);
		window.setVisible(true);

		//============================================================ Events
		// Timer(time
		tmr = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Move everything behind the scenes
				// Then...
				repaint();
			}
		});

		//============================================================ Mouse Pressed
		addMouseListener(new MouseListener() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				// Takes arrayList pts
				// Draw a line from:
				// pts {
				// 5, 12
				// 20, 19 *
				// 100,103 *
				// }
				pts.add(e.getPoint());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		//============================================================ Mouse Moved, Dragged
		addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				window.setTitle(e.getPoint().toString());
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				mouseMoved(e);
			}
		});

		//============================================================ Key pressed
		window.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

		});

		tmr.start();
	}

	//============================================================ Drawing
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setStroke(s);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.drawImage(imgMap, 0, 0, window);
		
		g2.setColor(Color.red);
		if (pts.size() > 0) {
			g2.fillOval(pts.get(0).x-5,pts.get(0).y-5, 10, 10);
		
		// Think about assigning the values of edges	
			
		for(int i = 1; i < pts.size(); i++) {
			// This is the vertex like 20, 19
			g2.drawLine(pts.get(i-1).x,pts.get(i-1).y, pts.get(i).x,pts.get(i).y);
			g2.fillOval(pts.get(i).x-5,pts.get(i).y-5, 10, 10);	
		}
		
		}
		
	}

	//======================================================
	public static void main(String[] args) {
		new Draw();
		new Draw();
	}
	//======================================================
}
