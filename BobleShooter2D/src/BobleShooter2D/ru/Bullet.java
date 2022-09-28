package BobleShooter2D.ru;

import java.awt.*;

public class Bullet {

	//Fields


	//Переменные кордината пуль
	private double x;
	private double y;
	private int r;

	//Угол пуль от игрока
	private double dx;
	private double dy;
	private double rad;

	//Скорость пуль
	private double speed;


	//Цвет
	private static Color color1;


	//Constructor
	public Bullet(double angle, int x, int y) {//Где будут пули(градусы, x y их продолжение от игрока
		this.x = x;
		this.y = y;
		r = 2;

		rad = Math.toRadians(angle);
		speed = 10;
		dx = Math.cos(rad) * speed;
		dy = Math.sin(rad) * speed;

		color1 = Color.WHITE;
	}

	public double setX() {
		return x;
	}

	public double setY() {
		return y;
	}

	public double setR() {
		return r;
	}

	//Functions
	public boolean update() {
		if (GamePanel.slowStop){
			x += dx * 0;
			y += dy * 0;
		}else {
			x += dx;
			y += dy;
		}
		//Если пули заходят за экран то возвращаем истинну
		if (x < -r || x > GamePanel.WIDTH + r ||
				y < -r || y > GamePanel.HEIGHT + r) {
			return true;
		}
		return false;
	}

	public void draw(Graphics2D g) {

		if(Player.PlayersUpsDamage() >= 5 && Player.PlayersUpsDamage() <= 10) {
			color1 = Color.ORANGE;
		}else if(Player.PlayersUpsDamage() >= 11) {
			color1 = Color.RED;
		}

		g.setColor(color1);
		g.fillOval((int) x - r, (int) y - r, 2 * r, 2 * r);



	}
}

