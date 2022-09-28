package BobleShooter2D.ru;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static BobleShooter2D.ru.Player.powerLevel;


public class GamePanel extends JPanel implements Runnable {//���������� �� JPanel � ��������� ��������� ������ Runnable

	//Fields
	public static int WIDTH = 600;//������������� ������  �� 600
	public static int HEIGHT = 600;//������������� ������  �� 600



	private Thread thread;//������������� �����
	public static boolean running = true;//������� ���������� running � ����������� ��� true

	private BufferedImage image;//������������� ����� ��� ��������
	private Graphics2D g;//������������� ��������

	private int FPS = 30;//������������� ������� ������
	private double averageFPS;//������� ������� ������

	//�������������� ������
	public static Player player;
	public static ArrayList<Bullet> bullets;
	public static ArrayList<Enemy> enemies;
	public static Wave wave;
	public static ArrayList<PowerUp> powerUps;
	public static ArrayList<Explosion> explosions;
	public static ArrayList<Text> texts;
	public static Menue menu;
	public static SpeedAndBullet menus;

	Image img = new ImageIcon("E:\\Program/154.ru.png").getImage();



	//
	private long slowDownTime;//�������������  ����� ���������
	private long slowDownTimeDiff;//������� �� ������� ���������
	private int slowDownLength = 6000;//������� ����� ���������� ��������� �������

	public static boolean slowStop = false;

	public double startBoss;



	public static State state = State.MENUE;//������������� ���������� � ������ � �������������� ��������� ����
	public static States states = States.MENUES;

	public static int mouseX;//��������� ���� �� x
	public static int mouseY;//��������� ���� �� y
	public static boolean leftmouse;//����� ����
	public static boolean rightmouse;
	public static boolean rightmouse1;
	public static boolean rightmouse2;



	//Constuctor

	public GamePanel() {
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));//������������� ������ � ������ ����
		setFocusable(true);//���������� ����� � ����
		requestFocus();//���������� ����� � ����

	}


	//Functions


	public void addNotify() {
		super.addNotify();
		if (thread == null) {//���� �����  ������ 0 ��
			thread = new Thread(this);//������� ����� � ����������� ��� this
			thread.start();//��������� �����
		}
		addKeyListener(new Listener());//��������� ��������� �� ���������� � ������ Listener
		addMouseMotionListener(new Listener());//��������� ��������� �� ���� � ������ Listener
		addMouseListener(new Listener());//��������� ��������� �� ���������� � ������ Listener
	}

	public static enum State {//������� ����� enum
		MENUE,//�������� ��� ��������� 1) ���� 2 ) ����
		PLAY;

	}
	public static enum States {//������� ����� enum
		MENUES;

	}




	public void run() {
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);//����������� �����
		g = (Graphics2D) image.getGraphics();//������������� �� �������� ���� �����

		g.setRenderingHint(//���������� ������
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(//���������� �����
				RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);


		player = new Player();
		bullets = new ArrayList<Bullet>();
		enemies = new ArrayList<Enemy>();
		wave = new Wave();
		powerUps = new ArrayList<PowerUp>();
		explosions = new ArrayList<Explosion>();
		texts = new ArrayList<Text>();
		menu = new Menue();
		menus = new SpeedAndBullet();
		leftmouse = false;
		rightmouse = false;
		rightmouse1 = false;
		rightmouse2 = false;



		long startTime;//������� ���������� ����� �������
		long URDTime;//������� �� �������
		long waitTime ;//������� ����� �����
		long totalTime = 0;//��� �����

		int FrameCount = 0;//������� ������/� ��� �������
		int maxFrameCount = 30;//������� ������/� ��� ��������

		long targetTime = 1000/ FPS;//����� �����





		while(running){//���� ����
			startTime = System.nanoTime();	

			if(state.equals(State.MENUE)) {//���� ��������� ����
				g.drawImage(img, 0,0,null);//�������
				menu.update();//��������� ����� ���� � ������  ����� ����, ��������� ����� Draw
				menu.draw(g);
				Draw();
				if (powerLevel == 2 || powerLevel == 4 || powerLevel == 6 || powerLevel == 8 || powerLevel == 10 ||
						powerLevel == 12 || powerLevel == 14 || powerLevel == 16 || powerLevel == 18 || powerLevel == 20){
					States states = States.MENUES;
				}
			}
			if (state.equals(State.PLAY)) {//���� ��������� ����

				Update();//��������� 3 ������
				Render();
				Draw();


			}

			if (powerLevel == 2 || powerLevel == 4 || powerLevel == 6 || powerLevel == 8 || powerLevel == 10 ||
					powerLevel == 12 || powerLevel == 14 || powerLevel == 16 || powerLevel == 18 || powerLevel == 20){
				States states = States.MENUES;
			}


			if (states.equals(States.MENUES)) {
				if (!(Player.powerLevel == 0)) {
					menus.update();
					menus.draw(g);
					Draw();

				}
			}


			URDTime = (System.nanoTime() - startTime)/ 1000000;
			waitTime = targetTime - URDTime;
			try{
				Thread.sleep(waitTime);
			}catch(Exception e){

			}
			totalTime += System.nanoTime() - startTime;
			FrameCount++;
			if (FrameCount == maxFrameCount){
				averageFPS = 1000.0 / ((totalTime / FrameCount )/ 1000000);
				FrameCount = 0;
				totalTime = 0;
			}
		}



		//������ ������� �� ���� � ��������� ����
		if(!running && Wave.waveNumber >= 51) {
			g.drawImage(img, 0,0,null);//�������

			g.setColor(Color.WHITE);
			g.setFont(new Font("Century Gothic", Font.PLAIN, 16));
			String s = "G A M E  O V E R";
			int length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
			g.drawString(s, (WIDTH - length) / 2, HEIGHT / 2);
			String as = "Y O U  W I N";
			length = (int) g.getFontMetrics().getStringBounds(as, g).getWidth();
			g.drawString(as, (WIDTH - length) / 2, HEIGHT / 2 + 30);
			String a = "Score: " + player.getScore();
			length = (int) g.getFontMetrics().getStringBounds(a, g).getWidth();
			g.drawString(a, (WIDTH - length) / 2, HEIGHT / 2 + 60);
			String b = "Wave: " + Wave.waveNumber;
			length = (int) g.getFontMetrics().getStringBounds(b, g).getWidth();
			g.drawString(b, (WIDTH - length) / 2, HEIGHT / 2 + 90);
			//String d = "Record: " + rec;
			//length = (int) g.getFontMetrics().getStringBounds(d, g).getWidth();
			//g.drawString(d, (WIDTH - length) / 2, HEIGHT / 2 + 120);
			Draw();
		}
		if(!running && Wave.waveNumber < 51) {
			
			g.drawImage(img, 0,0,null);//�������

			g.setColor(Color.RED);
			g.setFont(new Font("Century Gothic", Font.PLAIN, 16));
			String s = "Y O U  L O S E";
			int length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
			g.drawString(s, (WIDTH - length) / 2, HEIGHT / 2);
			g.setColor(Color.WHITE);
			String a = "Score: " + player.getScore();
			length = (int) g.getFontMetrics().getStringBounds(a, g).getWidth();
			g.drawString(a, (WIDTH - length) / 2, HEIGHT / 2 + 30);
			String b = "Wave: " + Wave.waveNumber;
			length = (int) g.getFontMetrics().getStringBounds(b, g).getWidth();
			g.drawString(b, (WIDTH - length) / 2, HEIGHT / 2 + 60);
			Draw();
		}
	}
	//
	private void Update(){//��������� ����

		wave.update();//��������� �����

		player.update();//��������� ������

		//��������� ���� � ������� ��
		for (int i = 0; i < bullets.size(); i++){
			boolean remove = bullets.get(i).update();
			if (remove){
				bullets.remove(i);
				i--;
			}
		}

		//��������� ��������
		for (int i = 0; i < enemies.size(); i++){
			enemies.get(i).update();
		}

		//��������� ������ � ������� ��
		for (int i = 0; i < powerUps.size(); i++){
			boolean remove =  powerUps.get(i).update();
			if (remove){
				powerUps.remove(i);
				i--;
			}
		}

		//������������� ���� ���� � ������� ������������, �� ���� ������� � ������� �������� ���� � ��������� �����
		for(int i = 0; i < bullets.size(); i++){
			Bullet b = bullets.get(i);
			double bx = b.setX();
			double by = b.setY();
			double br = b.setR();
			for (int j = 0; j < enemies.size(); j++){
				Enemy e = enemies.get(j);
				double ex = e.setX();
				double ey = e.setY();
				double er = e.setR();

				double dx = bx - ex;
				double dy = by - ey;
				double dist = Math.sqrt(dx * dx + dy * dy);
				if (dist < br + er){

					if(Wave.waveNumber == 10 || Wave.waveNumber == 20 || Wave.waveNumber == 30 || Wave.waveNumber == 50) {
						startBoss =  Enemy.health -= Enemy.damage;
						if(Enemy.health <= 0) {
							e.hit();
						}
					}else if(Wave.waveNumber != 10|| Wave.waveNumber != 20 || Wave.waveNumber != 30 || Wave.waveNumber != 50) {
						e.hit();
					}
					bullets.remove(i);
					i--;
					break;
				}
			}
		}

		//������������� ���� �� ������?���� ���� �� ����������� ���� �� �����, ���� .������� ������� � ������ �����
		for (int i = 0; i < enemies.size(); i++){
			if (enemies.get(i).isDead()){
				Enemy e = enemies.get(i);
				double rang = Math.random();
				if (rang < 0.005){
					powerUps.add(new PowerUp(5,e.getX(), e.getY()));
				}else if(rang < 0.020) {
					powerUps.add(new PowerUp(1, e.getX(), e.getY()));
				}else  if (rang < 0.030){
					powerUps.add(new PowerUp(4, e.getX(), e.getY()));
				}else if (rang < 0.050) {
					powerUps.add(new PowerUp(3, e.getX(), e.getY()));
				} else if (rang < 0.120){
					powerUps.add(new PowerUp(2, e.getX(), e.getY()));
				}else {}

				player.addScore(e.getType() + e.getRang());
				enemies.remove(i);
				i--;
				e.explode();
				explosions.add(new Explosion(e.getX(), e.getY(), e.getR(), e.getR() + 20));

			}
		}			    	
		//��������� ����� � ������� ���
		for (int i =0; i < explosions.size(); i++){
			boolean remove =  explosions.get(i).update();
			if (remove){
				explosions.remove(i);
				i--;

			}
		}

		//���� ����� � ������ �������������� �� ����� �������� ����
		if (!player.isRecovering()){
			int px = Player.getX();
			int py = Player.getY();
			int pr = Player.getR();
			for (int i = 0; i < enemies.size(); i++){
				Enemy e = enemies.get(i);
				double ex = e.setX();
				double ey = e.setY();
				int er = e.setR();

				double dx = px - ex;
				double dy = py - ey;
				double dist = Math.sqrt(dx * dx + dy * dy);
				if (dist < pr + er){
					Player.loseLive();
				}

			}
		}

		//���� ����� � ����� �������������� �� ����� ����� � ��������� �����, ����� ������� �����
		int px = Player.getX();
		int py = Player.getY();
		int pr = Player.getR();
		for (int i = 0 ; i < powerUps.size(); i++){
			PowerUp p = powerUps.get(i);
			double x = p.getX();
			double y = p.getY();
			int r = p.getR();

			double dx = px - x;
			double dy = py - y;
			double dust = Math.sqrt(dx * dx + dy * dy);
			if (dust < pr + r){
				int type = p.getType();
				if (type == 1){
					player.gainLive();
					texts.add(new Text(player.getX(), player.getY(), 100, "Love + 1"));
				}
				if (type == 2){
					player.increase(1);
					texts.add(new Text(player.getX(), player.getY(), 1000, "Power + 1"));
				}
				if (type == 3){
					player.increase(2);
					texts.add(new Text(player.getX(), player.getY(), 1000, "Power + 2"));
				}
				if(type == 4){
					slowDownTime = System.nanoTime();
					for (int j = 0; j < enemies.size(); j++){
						enemies.get(j).setSlow(true);
					}
					texts.add(new Text(player.getX(), player.getY(), 1000, "Slow Down +6 c"));
				}
				if (type == 5){
					player.DEAD();
					texts.add(new Text(player.getX(), player.getY(), 2000, "DEAD Monster"));

				}
				powerUps.remove(i);
				i--;
			}
		}



		//���� ����� �� ����� 0 �� ���������� � ������� �� ������� � ��������� ��������� ������� ���� ������� ��������� ����� �������
		if (slowDownTime != 0 ){
			slowDownTimeDiff = (System.nanoTime() - slowDownTime)/1000000;
			if (slowDownTimeDiff > slowDownLength){
				slowDownTime = 0;
				for (int j = 0; j < enemies.size(); j++){
					enemies.get(j).setSlow(false);
				}
			}
		}

		//��������� ����� � ������� ���
		for (int i = 0; i < texts.size(); i++){
			boolean remove = texts.get(i).update();
			if (remove){
				texts.remove(i);
				i--;
			}
		}

		//���� � ������ �������������� �����(����� ����), ��  ��������� ���� ����
		if (player.isDead()){
			running = false;
		}

	}
	private void Render() {//������ ��� �� ����
		g.setColor(Color.BLUE);
		g.fillRect(0,0,WIDTH,HEIGHT);
		g.drawImage(img, 0,0,null);//�������
		//���� ����� �������� ����� ��������� �� ������ ����� ���� ����������
		if (slowDownTime != 0) {
			g.setColor(new Color(255, 255, 255, 64));
			g.fillRect(0, 0, WIDTH, HEIGHT);
		}
		wave.draw(g);//������ �����
		player.draw(g);//������ �����


		//������ ������ ����
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).draw(g);
		}

		//������ ������� �������
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).draw(g);
		}

		//������� ������ �����
		for (int i = 0; i < powerUps.size(); i++) {
			powerUps.get(i).draw(g);
		}

		//������ ������ �����
		for (int i = 0; i < explosions.size(); i++) {
			explosions.get(i).draw(g);
		}

		//������ ���� ������(��������� �������) �� ������� ����� ����
		g.setColor(Color.YELLOW);
		g.fillRect(20, 40, player.getPower() * 8, 8);
		g.setColor(Color.YELLOW.darker());
		g.setStroke(new BasicStroke(2));
		for (int i = 0; i < player.getRequestPower(); i++) {
			g.drawRect(20 + 8 * i, 40, 8, 8);
		}
		g.setStroke(new BasicStroke(1));

		//������ ���� �� ������� ������ ����
		g.setColor(Color.WHITE);
		g.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		g.drawString("Score " + Player.getScore(), WIDTH - 100, 30);

		//������ ����� �� �������� �����
		g.setColor(Color.WHITE);
		g.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		g.drawString("Damage = " + Player.PlayersUpsDamage()+ "("+ Enemy.damage + ")",  240, HEIGHT - 10);

		//������ ���� � ������ ������ ����
		g.setColor(Color.WHITE);
		g.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		g.drawString("Bullet = " + Player.PlayersUpsBullet(),  460, HEIGHT - 10);

		//������ �������� � ����� ������ ����
		g.setColor(Color.WHITE);
		g.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		g.drawString("Speed = " + Player.PlayersUpsSpeed(),  40, HEIGHT - 10);

		if(Player.PlayersUpsSpeed() >= 15) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("Century Gothic", Font.PLAIN, 16));
			g.drawString("(MAX)",  125, HEIGHT - 10);
		}
		if(Player.PlayersUpsDamage() >= 15) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("Century Gothic", Font.PLAIN, 16));
			g.drawString("(MAX)",  WIDTH/ 2 + 75, HEIGHT - 10);
		}
		if(Player.PlayersUpsBullet() >= 12) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("Century Gothic", Font.PLAIN, 16));
			g.drawString("(MAX)",  540, HEIGHT - 10);
		}


		//������ ����� ������� ������� ���������� ������������
		if (slowDownTime != 0) {
			g.setColor(Color.WHITE);
			g.drawRect(20, 60, 100, 8);
			g.fillRect(20, 60, (int) (100 - 100.0 * slowDownTimeDiff / slowDownLength), 8);
		}

		//����� ������� �����
		if (Wave.waveNumber == 10) {
			g.setColor(Color.RED);
			g.fillRect(20, 60, (int) (startBoss/3), 10);
		}
		if (Wave.waveNumber == 20) {
			g.setColor(Color.RED);
			g.fillRect(20, 60, (int) (startBoss/9), 15);
		}
		if (Wave.waveNumber == 30) {
			g.setColor(Color.RED);
			g.fillRect(20, 60, (int) (startBoss/13), 19);
		}
		if (Wave.waveNumber == 50) {
			g.setColor(Color.RED);
			g.fillRect(20, 60, (int) (startBoss/30), 36);
		}

		//������ �����
		for (int i = 0; i < texts.size(); i++) {
			texts.get(i).draw(g);

		}


	}

	private void Draw(){//�������� ����������� � ����
		Graphics g2 = this.getGraphics();
		g2.drawImage(image,0,0,null);
		g2.dispose();



	}
}





