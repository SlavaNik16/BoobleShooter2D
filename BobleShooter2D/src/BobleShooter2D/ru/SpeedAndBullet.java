package BobleShooter2D.ru;

import java.awt.*;

import static BobleShooter2D.ru.Player.powerLevel;

public class SpeedAndBullet {


	private int buttonWidths;
	private int buttonHeights;

	private Color color;

	private String s;
	private String s1;
	private String a;
	private String a1;
	private String d;
	private String d1;

	private int transps = 0;

	private boolean one1 = true;


	public SpeedAndBullet() {
		buttonWidths = 100;
		buttonHeights = 100;
		color = Color.WHITE;
		s = "SPEED++";
		s1 = "1+Space";
		d = "Damage++";
		d1 = "2+Space";
		a = "BULLETS++";
		a1 = "3+Space";
	}

	public void update() {

		if (GamePanel.mouseX > GamePanel.WIDTH / 10 - buttonWidths / 2 &&//����� �������
				GamePanel.mouseX < GamePanel.WIDTH / 10 + buttonWidths / 2 &&//������ �������
				GamePanel.mouseY > GamePanel.HEIGHT / 12 - buttonHeights / 2 &&//������� �������
				GamePanel.mouseY < GamePanel.HEIGHT / 12 + buttonHeights / 2) {//������ �������
			transps = 64;//������ ����� ������ �� 1/4 ���������� ������
			if (GamePanel.rightmouse) {
				GamePanel.states = GamePanel.States.MENUES;//���� ����� ������ �� �������� ����(������ ���������)
			} else {
				transps = 128;
				///������ �� ����� ������ ���������� ������
			}
		}
	}


	public void draw(Graphics2D g) {
		if (powerLevel == 2) {
			if (one1) {
				GamePanel.slowStop = true;
				g.setColor(Color.WHITE);
				g.drawRect((int) (GamePanel.WIDTH / 15), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(3));
				g.setColor(new Color(255, 255, 255, transps));//���������� ����);
				g.fillRect((int) (GamePanel.WIDTH / 15), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(1));

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				int length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(s, (int) (GamePanel.WIDTH / 12 - length / 16), (int) (GamePanel.HEIGHT / 1.3 + buttonHeights / 1.8));//�������� ������

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(s1, (int) (GamePanel.WIDTH / 12 - length / 15), (int) (GamePanel.HEIGHT / 1.2 + buttonHeights / 1.8));


				g.setColor(Color.WHITE);
				g.drawRect((int) (GamePanel.WIDTH / 1.3), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(3));
				g.setColor(new Color(255, 255, 255, transps));//���������� ����);
				g.fillRect((int) (GamePanel.WIDTH / 1.3), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(1));

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				int lengths = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(a, (int) (GamePanel.WIDTH / 1.2 - lengths / 2), (int) (GamePanel.HEIGHT / 1.3 + buttonHeights / 1.8));//�������� ������

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				lengths = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(a1, (int) (GamePanel.WIDTH / 1.2 - lengths / 2)+5, (int) (GamePanel.HEIGHT / 1.2 + buttonHeights / 1.8));


				g.setColor(Color.WHITE);
				g.drawRect((int) (GamePanel.WIDTH / 2.3), (int) (GamePanel.HEIGHT / 1.3), 110, 100);
				g.setStroke(new BasicStroke(3));
				g.setColor(new Color(255, 255, 255, transps));//���������� ����);
				g.fillRect((int) (GamePanel.WIDTH / 2.3), (int) (GamePanel.HEIGHT / 1.3), 110, 100);
				g.setStroke(new BasicStroke(1));

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				int lengthss = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(d, (int) (GamePanel.WIDTH / 2 - lengthss / 2), (int) (GamePanel.HEIGHT / 1.3 + buttonHeights / 1.8));//�������� ������

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				lengthss = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(d1, (int) (GamePanel.WIDTH / 2 - lengthss / 2) + 10, (int) (GamePanel.HEIGHT / 1.2 + buttonHeights / 1.8));

				if (GamePanel.rightmouse2 && one1 || GamePanel.rightmouse1 && one1 || GamePanel.rightmouse && one1) {
					one1 = false;
					GamePanel.slowStop = false;
				}
			}
		} else if (powerLevel == 4) {
			if (!one1) {
				GamePanel.slowStop = true;
				g.setColor(Color.WHITE);
				g.drawRect((int) (GamePanel.WIDTH / 15), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(3));
				g.setColor(new Color(255, 255, 255, transps));//���������� ����);
				g.fillRect((int) (GamePanel.WIDTH / 15), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(1));

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				int length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(s, (int) (GamePanel.WIDTH / 12 - length / 16), (int) (GamePanel.HEIGHT / 1.3 + buttonHeights / 1.8));//�������� ������

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(s1, (int) (GamePanel.WIDTH / 12 - length / 15), (int) (GamePanel.HEIGHT / 1.2 + buttonHeights / 1.8));


				g.setColor(Color.WHITE);
				g.drawRect((int) (GamePanel.WIDTH / 1.3), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(3));
				g.setColor(new Color(255, 255, 255, transps));//���������� ����);
				g.fillRect((int) (GamePanel.WIDTH / 1.3), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(1));

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				int lengths = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(a, (int) (GamePanel.WIDTH / 1.2 - lengths / 2), (int) (GamePanel.HEIGHT / 1.3 + buttonHeights / 1.8));//�������� ������

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				lengths = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(a1, (int) (GamePanel.WIDTH / 1.2 - lengths / 2)+5, (int) (GamePanel.HEIGHT / 1.2 + buttonHeights / 1.8));


				g.setColor(Color.WHITE);
				g.drawRect((int) (GamePanel.WIDTH / 2.3), (int) (GamePanel.HEIGHT / 1.3), 110, 100);
				g.setStroke(new BasicStroke(3));
				g.setColor(new Color(255, 255, 255, transps));//���������� ����);
				g.fillRect((int) (GamePanel.WIDTH / 2.3), (int) (GamePanel.HEIGHT / 1.3), 110, 100);
				g.setStroke(new BasicStroke(1));

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				int lengthss = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(d, (int) (GamePanel.WIDTH / 2 - lengthss / 2), (int) (GamePanel.HEIGHT / 1.3 + buttonHeights / 1.8));//�������� ������

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				lengthss = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(d1, (int) (GamePanel.WIDTH / 2 - lengthss / 2)+10, (int) (GamePanel.HEIGHT / 1.2 + buttonHeights / 1.8));

				if (GamePanel.rightmouse2 && !one1 || GamePanel.rightmouse1 && !one1 || GamePanel.rightmouse && !one1) {
					one1 = true;
					GamePanel.slowStop = false;
				}
			}
		} else if (powerLevel == 6) {
			if (one1) {
				GamePanel.slowStop = true;
				g.setColor(Color.WHITE);
				g.drawRect((int) (GamePanel.WIDTH / 15), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(3));
				g.setColor(new Color(255, 255, 255, transps));//���������� ����);
				g.fillRect((int) (GamePanel.WIDTH / 15), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(1));

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				int length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(s, (int) (GamePanel.WIDTH / 12 - length / 16), (int) (GamePanel.HEIGHT / 1.3 + buttonHeights / 1.8));//�������� ������

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(s1, (int) (GamePanel.WIDTH / 12 - length / 15), (int) (GamePanel.HEIGHT / 1.2 + buttonHeights / 1.8));


				g.setColor(Color.WHITE);
				g.drawRect((int) (GamePanel.WIDTH / 1.3), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(3));
				g.setColor(new Color(255, 255, 255, transps));//���������� ����);
				g.fillRect((int) (GamePanel.WIDTH / 1.3), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(1));

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				int lengths = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(a, (int) (GamePanel.WIDTH / 1.2 - lengths / 2), (int) (GamePanel.HEIGHT / 1.3 + buttonHeights / 1.8));//�������� ������

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				lengths = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(a1, (int) (GamePanel.WIDTH / 1.2 - lengths / 2)+5, (int) (GamePanel.HEIGHT / 1.2 + buttonHeights / 1.8));


				g.setColor(Color.WHITE);
				g.drawRect((int) (GamePanel.WIDTH / 2.3), (int) (GamePanel.HEIGHT / 1.3), 110, 100);
				g.setStroke(new BasicStroke(3));
				g.setColor(new Color(255, 255, 255, transps));//���������� ����);
				g.fillRect((int) (GamePanel.WIDTH / 2.3), (int) (GamePanel.HEIGHT / 1.3), 110, 100);
				g.setStroke(new BasicStroke(1));

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				int lengthss = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(d, (int) (GamePanel.WIDTH / 2 - lengthss / 2), (int) (GamePanel.HEIGHT / 1.3 + buttonHeights / 1.8));//�������� ������

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				lengthss = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(d1, (int) (GamePanel.WIDTH / 2 - lengthss / 2)+10, (int) (GamePanel.HEIGHT / 1.2 + buttonHeights / 1.8));

				if (GamePanel.rightmouse2 && one1 || GamePanel.rightmouse1 && one1 || GamePanel.rightmouse && one1) {
					one1 = false;
					GamePanel.slowStop = false;
				}
			}
		} else if (powerLevel == 8) {
			if (!one1) {
				GamePanel.slowStop = true;
				g.setColor(Color.WHITE);
				g.drawRect((int) (GamePanel.WIDTH / 15), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(3));
				g.setColor(new Color(255, 255, 255, transps));//���������� ����);
				g.fillRect((int) (GamePanel.WIDTH / 15), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(1));

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				int length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(s, (int) (GamePanel.WIDTH / 12 - length / 16), (int) (GamePanel.HEIGHT / 1.3 + buttonHeights / 1.8));//�������� ������

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(s1, (int) (GamePanel.WIDTH / 12 - length / 15), (int) (GamePanel.HEIGHT / 1.2 + buttonHeights / 1.8));


				g.setColor(Color.WHITE);
				g.drawRect((int) (GamePanel.WIDTH / 1.3), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(3));
				g.setColor(new Color(255, 255, 255, transps));//���������� ����);
				g.fillRect((int) (GamePanel.WIDTH / 1.3), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(1));

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				int lengths = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(a, (int) (GamePanel.WIDTH / 1.2 - lengths / 2), (int) (GamePanel.HEIGHT / 1.3 + buttonHeights / 1.8));//�������� ������

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				lengths = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(a1, (int) (GamePanel.WIDTH / 1.2 - lengths / 2)+5, (int) (GamePanel.HEIGHT / 1.2 + buttonHeights / 1.8));


				g.setColor(Color.WHITE);
				g.drawRect((int) (GamePanel.WIDTH / 2.3), (int) (GamePanel.HEIGHT / 1.3), 110, 100);
				g.setStroke(new BasicStroke(3));
				g.setColor(new Color(255, 255, 255, transps));//���������� ����);
				g.fillRect((int) (GamePanel.WIDTH / 2.3), (int) (GamePanel.HEIGHT / 1.3), 110, 100);
				g.setStroke(new BasicStroke(1));

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				int lengthss = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(d, (int) (GamePanel.WIDTH / 2 - lengthss / 2), (int) (GamePanel.HEIGHT / 1.3 + buttonHeights / 1.8));//�������� ������

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				lengthss = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(d1, (int) (GamePanel.WIDTH / 2 - lengthss / 2)+10, (int) (GamePanel.HEIGHT / 1.2 + buttonHeights / 1.8));

				if (GamePanel.rightmouse2 && !one1 || GamePanel.rightmouse1 && !one1 || GamePanel.rightmouse && !one1) {
					one1 = true;
					GamePanel.slowStop = false;
				}
			}
		} else if (powerLevel == 10) {
			if (one1) {
				GamePanel.slowStop = true;
				g.setColor(Color.WHITE);
				g.drawRect((int) (GamePanel.WIDTH / 15), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(3));
				g.setColor(new Color(255, 255, 255, transps));//���������� ����);
				g.fillRect((int) (GamePanel.WIDTH / 15), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(1));

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				int length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(s, (int) (GamePanel.WIDTH / 12 - length / 16), (int) (GamePanel.HEIGHT / 1.3 + buttonHeights / 1.8));//�������� ������

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(s1, (int) (GamePanel.WIDTH / 12 - length / 15), (int) (GamePanel.HEIGHT / 1.2 + buttonHeights / 1.8));


				g.setColor(Color.WHITE);
				g.drawRect((int) (GamePanel.WIDTH / 1.3), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(3));
				g.setColor(new Color(255, 255, 255, transps));//���������� ����);
				g.fillRect((int) (GamePanel.WIDTH / 1.3), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(1));

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				int lengths = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(a, (int) (GamePanel.WIDTH / 1.2 - lengths / 2), (int) (GamePanel.HEIGHT / 1.3 + buttonHeights / 1.8));//�������� ������

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				lengths = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(a1, (int) (GamePanel.WIDTH / 1.2 - lengths / 2)+5, (int) (GamePanel.HEIGHT / 1.2 + buttonHeights / 1.8));


				g.setColor(Color.WHITE);
				g.drawRect((int) (GamePanel.WIDTH / 2.3), (int) (GamePanel.HEIGHT / 1.3), 110, 100);
				g.setStroke(new BasicStroke(3));
				g.setColor(new Color(255, 255, 255, transps));//���������� ����);
				g.fillRect((int) (GamePanel.WIDTH / 2.3), (int) (GamePanel.HEIGHT / 1.3), 110, 100);
				g.setStroke(new BasicStroke(1));

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				int lengthss = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(d, (int) (GamePanel.WIDTH / 2 - lengthss / 2), (int) (GamePanel.HEIGHT / 1.3 + buttonHeights / 1.8));//�������� ������

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				lengthss = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(d1, (int) (GamePanel.WIDTH / 2 - lengthss / 2)+10, (int) (GamePanel.HEIGHT / 1.2 + buttonHeights / 1.8));

				if (GamePanel.rightmouse2 && one1 || GamePanel.rightmouse1 && one1 || GamePanel.rightmouse && one1) {
					one1 = false;
					GamePanel.slowStop = false;
				}
			}
		} else if (powerLevel == 12) {
			if (!one1) {
				GamePanel.slowStop = true;
				g.setColor(Color.WHITE);
				g.drawRect((int) (GamePanel.WIDTH / 15), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(3));
				g.setColor(new Color(255, 255, 255, transps));//���������� ����);
				g.fillRect((int) (GamePanel.WIDTH / 15), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(1));

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				int length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(s, (int) (GamePanel.WIDTH / 12 - length / 16), (int) (GamePanel.HEIGHT / 1.3 + buttonHeights / 1.8));//�������� ������

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(s1, (int) (GamePanel.WIDTH / 12 - length / 15), (int) (GamePanel.HEIGHT / 1.2 + buttonHeights / 1.8));


				g.setColor(Color.WHITE);
				g.drawRect((int) (GamePanel.WIDTH / 1.3), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(3));
				g.setColor(new Color(255, 255, 255, transps));//���������� ����);
				g.fillRect((int) (GamePanel.WIDTH / 1.3), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(1));

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				int lengths = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(a, (int) (GamePanel.WIDTH / 1.2 - lengths / 2), (int) (GamePanel.HEIGHT / 1.3 + buttonHeights / 1.8));//�������� ������

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				lengths = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(a1, (int) (GamePanel.WIDTH / 1.2 - lengths / 2)+5, (int) (GamePanel.HEIGHT / 1.2 + buttonHeights / 1.8));


				g.setColor(Color.WHITE);
				g.drawRect((int) (GamePanel.WIDTH / 2.3), (int) (GamePanel.HEIGHT / 1.3), 110, 100);
				g.setStroke(new BasicStroke(3));
				g.setColor(new Color(255, 255, 255, transps));//���������� ����);
				g.fillRect((int) (GamePanel.WIDTH / 2.3), (int) (GamePanel.HEIGHT / 1.3), 110, 100);
				g.setStroke(new BasicStroke(1));

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				int lengthss = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(d, (int) (GamePanel.WIDTH / 2 - lengthss / 2), (int) (GamePanel.HEIGHT / 1.3 + buttonHeights / 1.8));//�������� ������

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				lengthss = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(d1, (int) (GamePanel.WIDTH / 2 - lengthss / 2)+10, (int) (GamePanel.HEIGHT / 1.2 + buttonHeights / 1.8));

				if (GamePanel.rightmouse2 && !one1 || GamePanel.rightmouse1 && !one1 || GamePanel.rightmouse && !one1) {
					one1 = true;
					GamePanel.slowStop = false;
				}
			}
		} else if (powerLevel == 14) {
			if (one1) {
				GamePanel.slowStop = true;
				g.setColor(Color.WHITE);
				g.drawRect((int) (GamePanel.WIDTH / 15), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(3));
				g.setColor(new Color(255, 255, 255, transps));//���������� ����);
				g.fillRect((int) (GamePanel.WIDTH / 15), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(1));

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				int length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(s, (int) (GamePanel.WIDTH / 12 - length / 16), (int) (GamePanel.HEIGHT / 1.3 + buttonHeights / 1.8));//�������� ������

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(s1, (int) (GamePanel.WIDTH / 12 - length / 15), (int) (GamePanel.HEIGHT / 1.2 + buttonHeights / 1.8));


				g.setColor(Color.WHITE);
				g.drawRect((int) (GamePanel.WIDTH / 1.3), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(3));
				g.setColor(new Color(255, 255, 255, transps));//���������� ����);
				g.fillRect((int) (GamePanel.WIDTH / 1.3), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(1));

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				int lengths = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(a, (int) (GamePanel.WIDTH / 1.2 - lengths / 2), (int) (GamePanel.HEIGHT / 1.3 + buttonHeights / 1.8));//�������� ������

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				lengths = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(a1, (int) (GamePanel.WIDTH / 1.2 - lengths / 2)+5, (int) (GamePanel.HEIGHT / 1.2 + buttonHeights / 1.8));


				g.setColor(Color.WHITE);
				g.drawRect((int) (GamePanel.WIDTH / 2.3), (int) (GamePanel.HEIGHT / 1.3), 110, 100);
				g.setStroke(new BasicStroke(3));
				g.setColor(new Color(255, 255, 255, transps));//���������� ����);
				g.fillRect((int) (GamePanel.WIDTH / 2.3), (int) (GamePanel.HEIGHT / 1.3), 110, 100);
				g.setStroke(new BasicStroke(1));

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				int lengthss = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(d, (int) (GamePanel.WIDTH / 2 - lengthss / 2), (int) (GamePanel.HEIGHT / 1.3 + buttonHeights / 1.8));//�������� ������

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				lengthss = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(d1, (int) (GamePanel.WIDTH / 2 - lengthss / 2)+10, (int) (GamePanel.HEIGHT / 1.2 + buttonHeights / 1.8));

				if (GamePanel.rightmouse2 && one1 || GamePanel.rightmouse1 && one1 || GamePanel.rightmouse && one1) {
					one1 = false;
					GamePanel.slowStop = false;
				}
			}
		} else if (powerLevel == 16) {
			if (!one1) {
				GamePanel.slowStop = true;
				g.setColor(Color.WHITE);
				g.drawRect((int) (GamePanel.WIDTH / 15), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(3));
				g.setColor(new Color(255, 255, 255, transps));//���������� ����);
				g.fillRect((int) (GamePanel.WIDTH / 15), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(1));

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				int length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(s, (int) (GamePanel.WIDTH / 12 - length / 16), (int) (GamePanel.HEIGHT / 1.3 + buttonHeights / 1.8));//�������� ������

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(s1, (int) (GamePanel.WIDTH / 12 - length / 15), (int) (GamePanel.HEIGHT / 1.2 + buttonHeights / 1.8));


				g.setColor(Color.WHITE);
				g.drawRect((int) (GamePanel.WIDTH / 1.3), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(3));
				g.setColor(new Color(255, 255, 255, transps));//���������� ����);
				g.fillRect((int) (GamePanel.WIDTH / 1.3), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(1));

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				int lengths = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(a, (int) (GamePanel.WIDTH / 1.2 - lengths / 2), (int) (GamePanel.HEIGHT / 1.3 + buttonHeights / 1.8));//�������� ������

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				lengths = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(a1, (int) (GamePanel.WIDTH / 1.2 - lengths / 2)+5, (int) (GamePanel.HEIGHT / 1.2 + buttonHeights / 1.8));


				g.setColor(Color.WHITE);
				g.drawRect((int) (GamePanel.WIDTH / 2.3), (int) (GamePanel.HEIGHT / 1.3), 110, 100);
				g.setStroke(new BasicStroke(3));
				g.setColor(new Color(255, 255, 255, transps));//���������� ����);
				g.fillRect((int) (GamePanel.WIDTH / 2.3), (int) (GamePanel.HEIGHT / 1.3), 110, 100);
				g.setStroke(new BasicStroke(1));

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				int lengthss = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(d, (int) (GamePanel.WIDTH / 2 - lengthss / 2), (int) (GamePanel.HEIGHT / 1.3 + buttonHeights / 1.8));//�������� ������

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				lengthss = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(d1, (int) (GamePanel.WIDTH / 2 - lengthss / 2)+10, (int) (GamePanel.HEIGHT / 1.2 + buttonHeights / 1.8));

				if (GamePanel.rightmouse2 && !one1 || GamePanel.rightmouse1 && !one1 || GamePanel.rightmouse && !one1) {
					one1 = true;
					GamePanel.slowStop = false;
				}
			}
		} else if (powerLevel == 18) {
			if (one1) {
				GamePanel.slowStop = true;
				g.setColor(Color.WHITE);
				g.drawRect((int) (GamePanel.WIDTH / 15), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(3));
				g.setColor(new Color(255, 255, 255, transps));//���������� ����);
				g.fillRect((int) (GamePanel.WIDTH / 15), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(1));

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				int length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(s, (int) (GamePanel.WIDTH / 12 - length / 16), (int) (GamePanel.HEIGHT / 1.3 + buttonHeights / 1.8));//�������� ������

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(s1, (int) (GamePanel.WIDTH / 12 - length / 15), (int) (GamePanel.HEIGHT / 1.2 + buttonHeights / 1.8));


				g.setColor(Color.WHITE);
				g.drawRect((int) (GamePanel.WIDTH / 1.3), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(3));
				g.setColor(new Color(255, 255, 255, transps));//���������� ����);
				g.fillRect((int) (GamePanel.WIDTH / 1.3), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(1));

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				int lengths = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(a, (int) (GamePanel.WIDTH / 1.2 - lengths / 2), (int) (GamePanel.HEIGHT / 1.3 + buttonHeights / 1.8));//�������� ������

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				lengths = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(a1, (int) (GamePanel.WIDTH / 1.2 - lengths / 2)+5, (int) (GamePanel.HEIGHT / 1.2 + buttonHeights / 1.8));


				g.setColor(Color.WHITE);
				g.drawRect((int) (GamePanel.WIDTH / 2.3), (int) (GamePanel.HEIGHT / 1.3), 110, 100);
				g.setStroke(new BasicStroke(3));
				g.setColor(new Color(255, 255, 255, transps));//���������� ����);
				g.fillRect((int) (GamePanel.WIDTH / 2.3), (int) (GamePanel.HEIGHT / 1.3), 110, 100);
				g.setStroke(new BasicStroke(1));

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				int lengthss = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(d, (int) (GamePanel.WIDTH / 2 - lengthss / 2), (int) (GamePanel.HEIGHT / 1.3 + buttonHeights / 1.8));//�������� ������

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				lengthss = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(d1, (int) (GamePanel.WIDTH / 2 - lengthss / 2)+10, (int) (GamePanel.HEIGHT / 1.2 + buttonHeights / 1.8));

				if (GamePanel.rightmouse2 && one1 || GamePanel.rightmouse1 && one1 || GamePanel.rightmouse && one1) {
					one1 = false;
					GamePanel.slowStop = false;
				}
			}
		} else if (powerLevel == 20) {
			if (!one1) {
				GamePanel.slowStop = true;
				g.setColor(Color.WHITE);
				g.drawRect((int) (GamePanel.WIDTH / 15), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(3));
				g.setColor(new Color(255, 255, 255, transps));//���������� ����);
				g.fillRect((int) (GamePanel.WIDTH / 15), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(1));

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				int length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(s, (int) (GamePanel.WIDTH / 12 - length / 16), (int) (GamePanel.HEIGHT / 1.3 + buttonHeights / 1.8));//�������� ������

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(s1, (int) (GamePanel.WIDTH / 12 - length / 15), (int) (GamePanel.HEIGHT / 1.2 + buttonHeights / 1.8));


				g.setColor(Color.WHITE);
				g.drawRect((int) (GamePanel.WIDTH / 1.3), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(3));
				g.setColor(new Color(255, 255, 255, transps));//���������� ����);
				g.fillRect((int) (GamePanel.WIDTH / 1.3), (int) (GamePanel.HEIGHT / 1.3), 100, 100);
				g.setStroke(new BasicStroke(1));

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				int lengths = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(a, (int) (GamePanel.WIDTH / 1.2 - lengths / 2), (int) (GamePanel.HEIGHT / 1.3 + buttonHeights / 1.8));//�������� ������

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				lengths = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(a1, (int) (GamePanel.WIDTH / 1.2 - lengths / 2)+5, (int) (GamePanel.HEIGHT / 1.2 + buttonHeights / 1.8));


				g.setColor(Color.WHITE);
				g.drawRect((int) (GamePanel.WIDTH / 2.3), (int) (GamePanel.HEIGHT / 1.3), 110, 100);
				g.setStroke(new BasicStroke(3));
				g.setColor(new Color(255, 255, 255, transps));//���������� ����);
				g.fillRect((int) (GamePanel.WIDTH / 2.3), (int) (GamePanel.HEIGHT / 1.3), 110, 100);
				g.setStroke(new BasicStroke(1));

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				int lengthss = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(d, (int) (GamePanel.WIDTH / 2 - lengthss / 2), (int) (GamePanel.HEIGHT / 1.3 + buttonHeights / 1.8));//�������� ������

				g.setColor(color);
				g.setFont(new Font("Century Gothic", Font.BOLD, 20));//������������� �����
				lengthss = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();//�������� ������
				g.drawString(d1, (int) (GamePanel.WIDTH / 2 - lengthss / 2)+10, (int) (GamePanel.HEIGHT / 1.2 + buttonHeights / 1.8));

				if (GamePanel.rightmouse2 && !one1 || GamePanel.rightmouse1 && !one1 || GamePanel.rightmouse && !one1) {
					one1 = true;
					GamePanel.slowStop = false;
				}
			}
		}
	}
}
















