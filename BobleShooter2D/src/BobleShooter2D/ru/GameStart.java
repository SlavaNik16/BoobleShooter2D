package BobleShooter2D.ru;

import javax.swing.*;

public class GameStart {
	public static void main(String[] args) {
		JFrame frame = new JFrame("BoobleShooter2D");
		
		frame.setContentPane(new GamePanel());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.pack();
		frame.setVisible(true);
		
		
	}

}
