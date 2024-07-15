import java.awt.Color;
import java.awt.Graphics;

public class Bird {

	private double x;
	private double y;
	private int width;
	private int height;
	Color color;
	
	Bird(int x, int y, int w){
		this.x = x;
		this.y = y;
		width = w;
		height = w;
		color = Color.RED;
	}
	
	public void draw(Graphics g) {
		//tail feathers
		g.setColor(Color.black);
		g.fillArc((int)x-10, (int)y+7, 30, 30, 150, 60);
		
		//big head feather
		g.setColor(Color.red);
		g.fillOval((int)x+5,(int)y-5,20,15);
		g.setColor(Color.black);
		g.drawOval((int)x+5,(int)y-5,20,15);
		
		//body
		g.setColor(color);
		g.fillOval((int)x, (int)y, width, height);
		g.setColor(Color.black);
		g.drawOval((int)x, (int)y, width, height);
		
		//small head feather
		g.setColor(color);
		g.fillOval((int)x+2,(int)y,10,7);
		g.setColor(Color.black);
		g.drawOval((int)x+2,(int)y,10,7);
		
		//eye one
		g.setColor(Color.white);
		g.fillOval((int)x+25, (int)y+15, 10, 10);
		g.setColor(Color.black);
		g.drawOval((int)x+25, (int)y+15, 10, 10);
		
		//eye two
		g.setColor(Color.white);
		g.fillOval((int)x+15, (int)y+15, 10, 10);
		g.setColor(Color.black);
		g.drawOval((int)x+15, (int)y+15, 10, 10);
		
		//pupils
		g.fillOval((int)x+19, (int)y+18, 4, 4);
		g.fillOval((int)x+27, (int)y+18, 4, 4);
		
		//eyebrow
		int[] eyebrowX = new int[]{(int) (x+17),(int) (x+25),(int) (x+33),(int) (x+35),(int) (x+25),(int) (x+14)};
		int[] eyebrowY = new int[] {(int) (y+12),(int) (y+16),(int) (y+12),(int) (y+15),(int) (y+18),(int) (y+15)};
		g.fillPolygon(eyebrowX,eyebrowY,6);
		
		//beak
		g.setColor(Color.yellow);
		int[] beakX = new int[] {(int) (x+24),(int) (x+37),(int) (x+22)};
		int[] beakY = new int[] {(int) (y+22),(int) (y+30),(int) (y+33)};
		g.fillPolygon(beakX,beakY,3);
		g.setColor(Color.black);
		g.drawPolygon(beakX,beakY,3);
	
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	
}
