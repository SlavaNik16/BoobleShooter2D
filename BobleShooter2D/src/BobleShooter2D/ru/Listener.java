package BobleShooter2D.ru;

import java.awt.event.*;

public class Listener  implements KeyListener, MouseMotionListener, MouseListener {


	public void keyTyped(KeyEvent e) {


	}

	//Если кнопка нажата
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP) {
			Player.setUp(true);
		}
		if (key == KeyEvent.VK_DOWN) {
			Player.setDown(true);
		}
		if (key == KeyEvent.VK_LEFT) {
			Player.setLeft(true);
		}
		if (key == KeyEvent.VK_RIGHT) {
			Player.setRight(true);
		}
		if (key == KeyEvent.VK_O) {
			System.exit(0);
		}
		if (key == KeyEvent.VK_SPACE){
			Player.setFiring(true);
		}
		if (key == KeyEvent.VK_ESCAPE){
			GamePanel.state = GamePanel.State.MENUE;
		}
		if (key == KeyEvent.VK_1){
			GamePanel.rightmouse = true;
		}
		if (key == KeyEvent.VK_2){
			GamePanel.rightmouse2 = true;
		}
		if (key == KeyEvent.VK_3){
			GamePanel.rightmouse1 = true;
		}


	}



	//Если кнопка опущена
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP) {
			Player.setUp(false);
		}
		if (key == KeyEvent.VK_DOWN) {
			Player.setDown(false);
		}
		if (key == KeyEvent.VK_LEFT) {
			Player.setLeft(false);
		}
		if (key == KeyEvent.VK_RIGHT) {
			Player.setRight(false);
		}
		if (key == KeyEvent.VK_SPACE){
			Player.setFiring(false);
		}
		if (key == KeyEvent.VK_1){
			GamePanel.rightmouse = false;
		}
		if (key == KeyEvent.VK_2){
			GamePanel.rightmouse2 = false;
		}
		if (key == KeyEvent.VK_3){
			GamePanel.rightmouse1 = false;
		}


	}


	public void mouseClicked(MouseEvent e) {

	}


	//Если левая мышка нажата
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1){
			GamePanel.leftmouse = true;
		}
		if (e.getButton() == MouseEvent.BUTTON2){
			GamePanel.rightmouse = true;
		}
	}

	//Если левая мышка опущена
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1){
			GamePanel.leftmouse = false;
		}
		if (e.getButton() == MouseEvent.BUTTON2){
			GamePanel.rightmouse = false;
		}
	}


	public void mouseEntered(MouseEvent e) {

	}


	public void mouseExited(MouseEvent e) {

	}

	//Передаем координаты мыши когда нажата
	public void mouseDragged(MouseEvent e) {
		GamePanel.mouseX = e.getX();
		GamePanel.mouseY = e.getY();


	}

	//Передаем координаты мыши когда опущена
	public void mouseMoved(MouseEvent e) {
		GamePanel.mouseX = e.getX();
		GamePanel.mouseY = e.getY();
	}
}

