import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ColorPanel extends JPanel{
	private Bird HuttHutt;
	private int cliffHeight;
	private double VoX;
	private double VoY;
	private double aY;
	private double launchAngle;
	private double totalV;
	private int initialY;
	private int initialX;
	private int yValueForCalcs; //essentially height from ground.
	private double time;
	private double maxHeight;
	private double xDistance;
	
	public ColorPanel(int cH, double angle, int v) {
		setBackground(new Color(117,190,217));
		setSize(1300,600);
		
		//xScale = x;
		launchAngle = -1*(angle) * Math.PI / 180.0;
		cliffHeight = cH;
		initialY = 600-cliffHeight-100-75; // EQUALS 125
		
		yValueForCalcs = cH;
		initialX = 85;
		
		HuttHutt = new Bird(initialX,initialY,40);
		aY = -9.8;
		VoX = v*Math.cos(launchAngle);
		VoY = v*Math.sin(launchAngle);
		totalV = v;
		
		time = (-1*getTotalV() * Math.sin(getLaunchAngle())+ 
				(Math.sqrt((getVoY()*getVoY())+(2*getyValueForCalcs()*9.8)))) / 9.8;
		
		maxHeight = cliffHeight+75+ ((getTotalV()*getTotalV()) * 
				Math.sin(getLaunchAngle())*Math.sin(getLaunchAngle())  / (2*9.8));
		
		xDistance = getVoX()*time;
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		drawGround(g);
		drawSun(g);
		drawCliff(g);
		drawSlingShot(g);
		HuttHutt.draw(g);
		//words below here
		
		g.drawString("Time Taken: "+(-1*getTotalV() * Math.sin(getLaunchAngle())+ 
				(Math.sqrt((getVoY()*getVoY())+(2*getyValueForCalcs()*9.8)))) / 9.8 + " seconds. ", 100, 550);
		g.drawString("Max Height: "+ maxHeight+ " meters. ", 400, 550);
		
		g.drawString("Distance Traveled: "+xDistance+" meters.", 700, 550);
		
	}
	public void drawGround(Graphics g) {
		g.setColor(new Color(30,115,31));
		g.fillRect(0, 500, 1300, 100);
	}
	
	public void drawSun(Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval(1200, 50, 40, 40);
	}
	
	public void drawCliff(Graphics g) {
		g.setColor(new Color(30,115,31));
		g.fillRect(0, (500-cliffHeight), 120, cliffHeight);
	}
	
	public void drawSlingShot(Graphics g) {
		int[] slingShotXValues1 = new int[] {80,115,115,90};
		int[] slingShotYValues1 = new int[] {450-cliffHeight, 480-cliffHeight, 470-cliffHeight, 450-cliffHeight};
		
		int[] slingShotXValues2 = new int[] {115, 140, 150, 115};
		int[] slingShotYValues2 = new int[] {470-cliffHeight, 450-cliffHeight, 450-cliffHeight, 480-cliffHeight};
				
		g.setColor(new Color(120,70,56));
		
		g.fillRect(110, (470-cliffHeight), 10, 30); //base
		g.fillPolygon(slingShotXValues1, slingShotYValues1, 4); //left
		g.fillPolygon(slingShotXValues2, slingShotYValues2, 4); //right
	}
	
	public void moveX(double time) {
		HuttHutt.setX(initialX + ((VoX*time)));
	}
	
	public void moveY(double time) {
		HuttHutt.setY(initialY+((VoY*time)-(.5*aY*time*time)));
	}
	
	
	public void move(double time) {
		moveX(time);
		moveY(time);
	}
	
	public Bird getHuttHutt() {
		return HuttHutt;
	}
	public void setHuttHutt(Bird huttHutt) {
		HuttHutt = huttHutt;
	}
	public int getCliffHeight() {
		return cliffHeight;
	}
	public void setCliffHeight(int cliffHeight) {
		this.cliffHeight = cliffHeight;
	}
	public double getVoX() {
		return VoX;
	}
	public void setVoX(double voX) {
		VoX = voX;
	}
	public double getVoY() {
		return VoY;
	}
	public void setVoY(double voY) {
		VoY = voY;
	}
	public double getaY() {
		return aY;
	}
	public void setaY(double aY) {
		this.aY = aY;
	}
	public double getLaunchAngle() {
		return launchAngle;
	}
	public void setLaunchAngle(double launchAngle) {
		this.launchAngle = launchAngle;
	}

	public double getTotalV() {
		return totalV;
	}

	public void setTotalV(double totalV) {
		this.totalV = totalV;
	}

	public int getInitialY() {
		return initialY;
	}

	public void setInitialY(int initialY) {
		this.initialY = initialY;
	}

	public int getInitialX() {
		return initialX;
	}

	public void setInitialX(int initialX) {
		this.initialX = initialX;
	}

	public int getyValueForCalcs() {
		return yValueForCalcs;
	}

	public void setyValueForCalcs(int yValueForCalcs) {
		this.yValueForCalcs = yValueForCalcs;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}
	
	
	
}
