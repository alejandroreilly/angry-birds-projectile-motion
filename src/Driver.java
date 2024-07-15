import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1300, 600);
		
		int cliffHeight = Integer.valueOf(JOptionPane.showInputDialog("How Tall Would You Like the Cliff to Be?:"));
		int angle = Integer.valueOf(JOptionPane.showInputDialog("What Angle Would You Like to Launch the Bird At? (0 - 90): "));
		int Vo = Integer.valueOf(JOptionPane.showInputDialog("What Will Be the Initial Velocity of the Bird?: "));
		
		ColorPanel background = new ColorPanel(cliffHeight,angle,Vo); //xScale);
		
		frame.getContentPane().add(background);
		frame.setVisible(true);
		

		
		double time2 = 0.0;
		
		while(background.getHuttHutt().getY() < 460) {
			
			background.move(time2);

			try {
				Thread.sleep(10);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			frame.repaint();
			
			time2+=.01;
		}

		System.out.println("touched");
	
		
	}
}
