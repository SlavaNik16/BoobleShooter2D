package BobleShooter2D.ru;

import java.awt.*;

public class PowerUp {

	//Координаты бонуса
	private  double x;
	private  double y;
	private int r;

	//Тип бонуса
	private int type;

	//Цвет бонса
	private Color color1;


	public  PowerUp(int type, double x, double y) {//тип бонуса, и его координаты

		this.type = type;
		this.x = x;
		this.y = y;
		if (type == 1) {
			color1 = Color.RED;
			r = 6;
		}
		if (type == 2) {
			color1 = Color.YELLOW;
			r = 6;
		}
		if (type == 3) {
			color1 = Color.YELLOW.darker();
			r = 6;
		}
		if (type == 4){
			color1 = Color.WHITE;
			r = 6;
		}
		if (type == 5){
			color1 = Color.BLACK;
			r = 6;
		}

	}
	public  double getX(){ return x; }
	public  double getY(){ return y; }
	public int getR(){ return r; }

	public int getType(){ return type;}
	public boolean update(){
		if (GamePanel.slowStop){
			y += 0;
		}else {
			y += 2;
		}
		if(y > GamePanel.HEIGHT + r){
			return true;
		}
		return false;

	}
	public void draw(Graphics2D g){
		//Создаем бонус
		g.setColor(color1);
		g.fillRect((int) x - r, (int) y - r, 2 * r, 2 * r);
		g.setStroke(new BasicStroke(3));
		g.setColor(color1.darker());
		g.drawRect((int) x - r, (int) y - r, 2 * r, 2 * r);
		g.setStroke(new BasicStroke(1));

	}
}
