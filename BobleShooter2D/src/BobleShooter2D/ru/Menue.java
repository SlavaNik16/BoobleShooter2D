package BobleShooter2D.ru;

import java.awt.*;

public class Menue {

	//Высота и ширина кнопки
	private int buttonWidth;
	private int buttonHeight;

	//Цвет строки
	private Color color1;
	//Строка
	private String s;

	//Прозрачность строки при наведение мыши
	private int transp = 0;


	//Constructor

	public Menue() {

		buttonWidth = 120;
		buttonHeight = 60;

		color1 = Color.WHITE;
		s = "Play!";

	}


	//Functions

	public void update() {
		if (GamePanel.mouseX > GamePanel.WIDTH / 2 - buttonWidth / 2 &&//Левая граница
				GamePanel.mouseX < GamePanel.WIDTH / 2 + buttonWidth / 2 &&//Правая граница
				GamePanel.mouseY > GamePanel.HEIGHT / 2 - buttonHeight / 2 &&//Верхняя граница
				GamePanel.mouseY < GamePanel.HEIGHT / 2 + buttonHeight / 2) {//Нижняя граница
			transp = 128;//Кнопка будет залито на 1/4 прозрачным цветом

			if (GamePanel.leftmouse) {
				GamePanel.state = GamePanel.State.PLAY;//Если мышка нажата то включаем игру(меняем состояние)
			} else {
				transp = 0;
				///Кнопка не будет залито прозрачным цветом
			}
		}
	}




	public  void draw(Graphics2D g){



		g.setColor(color1);
		g.setStroke(new BasicStroke(3));
		g.drawRect(GamePanel.WIDTH/2 - buttonWidth/2,GamePanel.HEIGHT/2 - buttonHeight/2,
				buttonWidth , buttonHeight);//Рисуем внизу кнопка
		g.setColor(new Color(255,255,255, transp));//Прозрачный цвет
		g.fillRect(GamePanel.WIDTH/2 - buttonWidth/2,GamePanel.HEIGHT/2 - buttonHeight/2,
				buttonWidth , buttonHeight);//Чтобы кнопка мегала
		g.setStroke(new BasicStroke(1));

		g.setColor(color1);
		g.setFont(new Font("Century Gothic", Font.BOLD, 40));//Устанавливаем шрифт
		int length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//Изменили ширина
		g.drawString(s, (int)(GamePanel.WIDTH/2 - length/2), (int)(GamePanel.HEIGHT/2 + buttonHeight/4));//Изменили высоту


	}

}
