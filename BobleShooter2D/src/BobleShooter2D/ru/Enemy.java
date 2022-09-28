package BobleShooter2D.ru;

import java.awt.*;

public class Enemy {

	//Fields
	private  double x;
	private  double y;
	private  int r;

	private double dx;
	private double dy;

	private Color color1;

	private double rad;
	public static double speed;

	public static int health;
	private int type;
	private int rang;

	private boolean ready;
	public boolean dead;

	private boolean hit;
	public static int damage;
	private long hitTime;

	private boolean slow;




	//Constructor
	public Enemy(int type, int rang) {
		this.type = type;
		this.rang = rang;
		if (type == 1) {
			color1 = Color.GREEN.darker();
			if (rang == 1) {
				speed = 4;
				r = 10;
				health = 1;

			}
			if (rang == 2) {
				speed = 4;
				r = 12;
				health = 2;
			}
			if (rang == 3) {
				speed = 4;
				r = 14;
				health = 3;
			}
			if (rang == 4) {
				speed = 4;
				r = 16;
				health = 4;
			}
			if (rang == 5) {
				speed = 5;
				r = 18;
				health = 5;
			}
			if (rang == 6) {
				speed = 4;
				r = 20;
				health = 6;
			}
			if (rang == 7) {
				speed = 5;
				r = 22;
				health = 6;
			}
			if (rang == 8){
				speed = 2;
				r = 24;
				health = 6;
			}
			if (rang == 9) {
				speed = 24;
				r = 6;
				health = 5;
			}
			if (rang == 10){
				speed = 30;
				r = 80;
				health = 1575;

			}
		}


		if (type == 2) {
			color1 = Color.YELLOW;
			if (rang == 1) {
				speed = 6;
				r = 8;
				health = 6;
			}
			if(rang == 2){
				speed = 7;
				r  = 10;
				health = 7;
			}
			if(rang == 3){
				speed = 8;
				r  = 12;
				health = 8;
			}
			if(rang == 4){
				speed = 9;
				r  = 14;
				health = 9;
			}

			if (rang == 5) {
				speed = 9;
				r = 16;
				health = 10;
			}
			if (rang == 6) {
				speed = 9;
				r = 18;
				health = 10;
			}
			if (rang == 7) {
				speed = 9;
				r = 20;
				health = 11;
			}
			if (rang == 8){
				speed = 11;
				r = 22;
				health = 12;
			}
			if (rang == 9) {
				speed = 30;
				r = 24;
				health = 40;
			}
			if (rang == 10){
				speed = 40;
				r = 150;
				health = 4725;

			}

		}
		if (type == 3) {
			color1 = Color.RED;
			if (rang == 1) {
				speed = 11;
				r = 15;
				health = 11;
			}
			if(rang == 2){
				speed = 12;
				r  = 18;
				health = 12;
			}
			if(rang == 3){
				speed = 13;
				r  = 21;
				health = 14;
			}
			if(rang == 4){
				speed = 13;
				r  = 24;
				health = 16;
			}

			if (rang == 5) {
				speed = 13;
				r = 26;
				health = 18;
			}
			if (rang == 6) {
				speed = 13;
				r = 28;
				health = 20;
			}
			if (rang == 7) {
				speed = 13;
				r = 30;
				health = 22;
			}
			if (rang == 8){
				speed = 13;
				r = 32;
				health = 24;
			}
			if (rang == 9) {
				speed = 35;
				r = 20;
				health = 70;
			}
			if (rang == 10){
				speed = 60;
				r = 100;
				health = 6825;

			}
		}

		if (type == 4) {
			color1 = Color.BLACK;
			if (rang == 1) {
				speed = 15;
				r = 10;
				health = 25;
			}
			if(rang == 2){
				speed = 15;
				r  = 18;
				health = 28;
			}
			if(rang == 3){
				speed = 15;
				r  = 21;
				health = 31;
			}
			if(rang == 4){
				speed = 15;
				r  = 24;
				health = 34;
			}

			if (rang == 5) {
				speed = 15;
				r = 26;
				health = 37;
			}
			if (rang == 6) {
				speed = 15;
				r = 28;
				health = 40;
			}
			if (rang == 7) {
				speed = 15;
				r = 30;
				health = 43;
			}
			if (rang == 8){
				speed = 15;
				r = 32;
				health = 46;
			}
			if (rang == 9) {
				speed = 70;
				r = 30;
				health = 50;
			}
			if (rang == 10){
				speed = 50;
				r = 150;
				health = 15750;

			}
		}




		x = Math.random() * GamePanel.WIDTH / 2 + GamePanel.WIDTH / 4;
		y = -r;

		double angle = Math.random() * 140 + 20;
		rad = Math.toRadians(angle);

		dx = Math.cos(rad) * speed;
		dy = Math.sin(rad) * speed;

		ready = false;
		dead = false;

		hit = false;
		damage = 1;
		hitTime = 0;
	}
	//Functiond
	public double setX () {
		return x;
	}
	public double setY () {
		return y;
	}
	public int setR () {
		return r;
	}
	public boolean isDead () {
		return dead;
	}

	public int getType () {
		return type;
	}
	public int getRang () {
		return rang;
	}

	public double getX () {
		return x;
	}
	public double getY () {
		return y;
	}
	public int getR () {
		return r;
	}

	public void setSlow(boolean b){ slow = b;}



	public void hit() {
		health -= damage;
		if (health <= 0) {
			dead = true;
		}

		hit = true;
		hitTime = System.nanoTime();
	}
	public void explode(){
		if (rang > 1) {
			int amount = 0;
			if (type == 1) {
				if (rang < 9 && rang > 1) {
					amount = 2;
				}else if (rang == 10 || rang == 9){
					amount = 0;
				}
			}

			if (type == 2) {
				if (rang < 9 && rang > 1) {
					amount = 2;
				}else if (rang == 10 || rang == 9){
					amount = 0;
				}
			}
			if (type == 3) {
				if (rang <= 9 && rang > 1) {
					amount = 2;
				}else if (rang == 10){
					amount = 0;
				}
			}
			if (type == 4) {
				if (rang < 10 && rang > 1) {
					amount = 2;
				}else if (rang == 10){
					amount = 0;
				}
			}

			for (int i = 0; i < amount; i++) {
				Enemy e = new Enemy(getType(), getRang() - 1);
				e.setSlow(slow);
				e.x = this.x;
				e.y = this.y;
				double angle = 0;
				if (!ready) {
					angle = Math.random() * 140 + 20;
				} else {
					angle = Math.random() * 360;
				}
				e.rad = Math.toRadians(angle);
				GamePanel.enemies.add(e);
			}
		}

	}
	public void update () {
		if (GamePanel.slowStop){
			x += dx * 0;
			y += dy * 0;
		}else if (slow){
			x += dx * 0.3;
			y += dy * 0.3;
		}else {
			x += dx;
			y += dy;
		}
		if (!ready) {
			if (x > r && x < GamePanel.WIDTH - r &&
					y > r && y < GamePanel.HEIGHT - r) {
				ready = true;
			}
		}
		if (x < r && dx < 0) {
			dx = -dx;
		}
		if (y < r && dy < 0) {
			dy = -dy;
		}
		if (x > GamePanel.WIDTH - r && dx > 0) {
			dx = -dx;
		}
		if (y > GamePanel.HEIGHT - r && dy > 0) {
			dy = -dy;
		}
		if (hit){
			long elapsed = (System.nanoTime() - hitTime )/ 1000000;
			if (elapsed > 50 ){
				hit = false;
				hitTime = 0;
			}
		}

	}
	public void draw (Graphics2D g){
		if (hit) {
			g.setColor(Color.WHITE);
			g.fillOval((int) x - r, (int) y - r, 2 * r, 2 * r);
			g.setStroke(new BasicStroke(3));
			g.setColor(Color.WHITE.darker());
			g.fillOval((int) x - r, (int) y - r, 2 * r, 2 * r);
			g.setStroke(new BasicStroke(1));
		}else {
			g.setColor(color1);
			g.fillOval((int) x - r, (int) y - r, 2 * r, 2 * r);
			g.setStroke(new BasicStroke(3));
			g.setColor(color1.darker());
			g.fillOval((int) x - r, (int) y - r, 2 * r, 2 * r);
			g.setStroke(new BasicStroke(1));
		}

	}


}

