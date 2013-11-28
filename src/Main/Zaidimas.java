package Main;

import javax.swing.JFrame;

public class Zaidimas  {
	
	public static void main(String[] args) {
		
		JFrame window = new JFrame("PLAT");
		
		window.add(new ZaidimoPanele());
		
		window.setResizable(false);
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
