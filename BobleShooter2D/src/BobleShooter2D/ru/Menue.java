package BobleShooter2D.ru;

import java.awt.*;

public class Menue {

	//������ � ������ ������
	private int buttonWidth;
	private int buttonHeight;

	//���� ������
	private Color color1;
	//������
	private String s;

	//������������ ������ ��� ��������� ����
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
		if (GamePanel.mouseX > GamePanel.WIDTH / 2 - buttonWidth / 2 &&//����� �������
				GamePanel.mouseX < GamePanel.WIDTH / 2 + buttonWidth / 2 &&//������ �������
				GamePanel.mouseY > GamePanel.HEIGHT / 2 - buttonHeight / 2 &&//������� �������
				GamePanel.mouseY < GamePanel.HEIGHT / 2 + buttonHeight / 2) {//������ �������
			transp = 128;//������ ����� ������ �� 1/4 ���������� ������

			if (GamePanel.leftmouse) {
				GamePanel.state = GamePanel.State.PLAY;//���� ����� ������ �� �������� ����(������ ���������)
			} else {
				transp = 0;
				///������ �� ����� ������ ���������� ������
			}
		}
	}




	public  void draw(Graphics2D g){



		g.setColor(color1);
		g.setStroke(new BasicStroke(3));
		g.drawRect(GamePanel.WIDTH/2 - buttonWidth/2,GamePanel.HEIGHT/2 - buttonHeight/2,
				buttonWidth , buttonHeight);//������ ����� ������
		g.setColor(new Color(255,255,255, transp));//���������� ����
		g.fillRect(GamePanel.WIDTH/2 - buttonWidth/2,GamePanel.HEIGHT/2 - buttonHeight/2,
				buttonWidth , buttonHeight);//����� ������ ������
		g.setStroke(new BasicStroke(1));

		g.setColor(color1);
		g.setFont(new Font("Century Gothic", Font.BOLD, 40));//������������� �����
		int length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
		g.drawString(s, (int)(GamePanel.WIDTH/2 - length/2), (int)(GamePanel.HEIGHT/2 + buttonHeight/4));//�������� ������


	}

}
