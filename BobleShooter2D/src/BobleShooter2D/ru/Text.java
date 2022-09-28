package BobleShooter2D.ru;

import java.awt.*;

public class Text {


	//Координаты текста
	private double x;
	private double y;

	//Время появления текста
	private long time;

	//Сам текст
	private String s;

	//Старст времени
	private long start;

	public Text(double x ,double y, long time, String s){//Координаты + время +  текст
		this.x = x;
		this.y = y;
		this.time = time;
		this.s = s;
		start = System.nanoTime();
	}
	public boolean update(){
		long elapsed = (System.nanoTime() - start)/1000000;//Если разница между временем и началом времени будет превышать время то возвращаем истинну
		if (elapsed > time){
			return true;
		}
		return false;
	}

	//Настьраиваем шрифт и делаем текст постепенно прозрачным
	public void draw(Graphics2D g){

		g.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		/*long elapsed = (System.nanoTime() - start)/1000000;
		int alpha = (int) (255 * Math.sin(3.14 * elapsed / time));
		if (alpha > 255) alpha = 255;
		 */
		g.setColor(new Color(255,255,255,128));
		int length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
		g.drawString(s,(int) (x - length / 2), (int) y);

	}
}
