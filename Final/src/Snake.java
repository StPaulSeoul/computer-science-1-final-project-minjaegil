import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Snake extends JPanel implements ActionListener{
	private int width = 300;
	private int height = 300;
	private int dotsize = 10;
	private int alldots = 100;
	private int delay = 140;
	
	private int x[] = new int [alldots];
	private int y[] = new int [alldots];
	
	private int dots;
	private int apple_x;
	private int apple_y;
	
	private boolean leftDirection = false;
	private boolean rightDirection = true;
	private boolean upDirection = false;
	private boolean inGame = true;
	
	private Timer timer;
	private Image ball;
	private Image apple;
	private Image head;
	
	public Board() {
		addKeyListener( new TAdapter());
		setBackground(Color.black);
		setFocusable(true);
		
		setPreferredSize(new Dimension(width, height));
		loadImages();
		initGame();
		
	}
	
	private void loadImages() {
		ImageIcon iid = new ImageIcon("dot.png");
		ball = iid.getImage();
		ImageIcon iia = new ImageIcon("apple.png");
		apple = iia.getImage();
		ImageIcon iih = new ImageIcon("head.png");
		head = iih.getImage();
	}
	
	private void initGame() {
		dots = 3;
		
		for(int i=0; i<dots; i++) {
			x[i] = 50 - i* 10;
			y[i] = 50;
		}
		locateApple();
		
	}
	

}
