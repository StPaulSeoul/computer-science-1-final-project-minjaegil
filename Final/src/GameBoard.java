
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class GameBoard extends JPanel implements KeyListener {
	
	Ball ball;
	Racket racket1;
	Racket racket2;

	public GameBoard() {
		ball = new Ball(this, Color.white);
		this.setBackground(Color.black);
		racket1 = new Racket(this, 10, 150, Color.blue);
		racket2 = new Racket(this, 560, 150, Color.yellow);
		setFocusable(true);
		addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		racket1.keyReleased(e);
		racket2.keyReleased(e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		racket1.keyPressed(e);
		racket2.keyPressed(e);
	}

	private void move() {
		ball.move();
		racket1.move();
		racket2.move();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		ball.draw(g2d);
		racket1.draw(g2d);
		racket2.draw(g2d);
	}

	public static void main(String[] args) {

		JFrame frame = new JFrame("Ping Pong");
		
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		

		GameBoard game = new GameBoard();
		frame.add(game);
		frame.setVisible(true);
		
		while (true) {
			
			game.move();
			game.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		} 

	}
}