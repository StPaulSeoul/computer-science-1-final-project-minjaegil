
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	private static final int RADIUS = 20;
	int x = 0;
	int y = 0;
	int xspeed = 3;
	int yspeed = 3;
	private GameBoard game;
	Color color;
 
	public Ball(GameBoard game, Color color) {
		this.game = game;
		this.color = color;
 }
	
	void move() {
		if (x + xspeed < 0)
			xspeed = 3;
		if (x + xspeed > game.getWidth() - 2 * RADIUS)
			xspeed = -3;
		if (y + yspeed < 0)
			yspeed = 3;
		if (y + yspeed > game.getHeight() - 2 * RADIUS)
			yspeed = -3;
		if (collision()) {
			xspeed = -xspeed;
  }
		x = x + xspeed;
		y = y + yspeed;
 }
	
	private boolean collision() {
		return game.racket1.getBounds().intersects(getBounds())
				|| game.racket2.getBounds().intersects(getBounds());
 }
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fillOval(x, y, 2 * RADIUS, 2 * RADIUS);
 }
	public Rectangle getBounds() {
		return new Rectangle(x, y, 2 * RADIUS, 2 * RADIUS);
 }
} 