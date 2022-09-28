package BobleShooter2D.ru;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static BobleShooter2D.ru.Player.powerLevel;


public class GamePanel extends JPanel implements Runnable {//Унаследуем от JPanel и применяем интерфейс потока Runnable

	//Fields
	public static int WIDTH = 600;//Устанавливаем ширину  на 600
	public static int HEIGHT = 600;//Устанавливаем высоту  на 600



	private Thread thread;//Устанавливаем поток
	public static boolean running = true;//Создаем переменную running и присваеваем ему true

	private BufferedImage image;//Устанавливаем холст для кисточки
	private Graphics2D g;//Устанавливаем кисточку

	private int FPS = 30;//Устанавливаем частоту кадров
	private double averageFPS;//Средняя частота кадров

	//Инициализируем классы
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
	private long slowDownTime;//Устанавливаем  время заморозки
	private long slowDownTimeDiff;//Разница во времени заморозки
	private int slowDownLength = 6000;//Сколько всего продлиться заморозка времени

	public static boolean slowStop = false;

	public double startBoss;



	public static State state = State.MENUE;//Устанавливаем переменную и вводим в первоначальное положение Меню
	public static States states = States.MENUES;

	public static int mouseX;//Кординаты мыши по x
	public static int mouseY;//Кординаты мыши по y
	public static boolean leftmouse;//Левую мышь
	public static boolean rightmouse;
	public static boolean rightmouse1;
	public static boolean rightmouse2;



	//Constuctor

	public GamePanel() {
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));//Устанавливаем высоту и ширину окна
		setFocusable(true);//Фокусируем мышку в окне
		requestFocus();//Фокусируем мышку в окне

	}


	//Functions


	public void addNotify() {
		super.addNotify();
		if (thread == null) {//Если поток  равекн 0 то
			thread = new Thread(this);//Создаем поток и присваеваем ему this
			thread.start();//Запускаем поток
		}
		addKeyListener(new Listener());//Обьявляем слушателю об клавиатуре в классе Listener
		addMouseMotionListener(new Listener());//Обьявляем слушателю об мыши в классе Listener
		addMouseListener(new Listener());//Обьявляем слушателю об клавиатуре в классе Listener
	}

	public static enum State {//Создаем класс enum
		MENUE,//Включаем два состояния 1) Меню 2 ) Игра
		PLAY;

	}
	public static enum States {//Создаем класс enum
		MENUES;

	}




	public void run() {
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);//Настраиваем холст
		g = (Graphics2D) image.getGraphics();//Устанавливаем на кисточке этот холст

		g.setRenderingHint(//Сглаживаем объект
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(//Сглаживаем текст
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



		long startTime;//Создаем переменную старт времени
		long URDTime;//Разница во времени
		long waitTime ;//Сколько стоит ждать
		long totalTime = 0;//Все время

		int FrameCount = 0;//Сколько кадров/в сек минимум
		int maxFrameCount = 30;//Сколько кадров/в сек максимум

		long targetTime = 1000/ FPS;//Общее время





		while(running){//Цикл игры
			startTime = System.nanoTime();	

			if(state.equals(State.MENUE)) {//Если состояние меню
				g.drawImage(img, 0,0,null);//Рисунок
				menu.update();//Обьявляем метод меню и рисуем  метод меню, обьявляем метод Draw
				menu.draw(g);
				Draw();
				if (powerLevel == 2 || powerLevel == 4 || powerLevel == 6 || powerLevel == 8 || powerLevel == 10 ||
						powerLevel == 12 || powerLevel == 14 || powerLevel == 16 || powerLevel == 18 || powerLevel == 20){
					States states = States.MENUES;
				}
			}
			if (state.equals(State.PLAY)) {//Если сотсояние игры

				Update();//Обьявляем 3 метода
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



		//Рисуем надпись на окне в состояние меню
		if(!running && Wave.waveNumber >= 51) {
			g.drawImage(img, 0,0,null);//Рисунок

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
			
			g.drawImage(img, 0,0,null);//Рисунок

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
	private void Update(){//Обновляем игру

		wave.update();//Обновляем волны

		player.update();//Обновляем игрока

		//Обновляем пули и удаляем их
		for (int i = 0; i < bullets.size(); i++){
			boolean remove = bullets.get(i).update();
			if (remove){
				bullets.remove(i);
				i--;
			}
		}

		//Обновляем монстров
		for (int i = 0; i < enemies.size(); i++){
			enemies.get(i).update();
		}

		//Обновляем бонусы и удаляем их
		for (int i = 0; i < powerUps.size(); i++){
			boolean remove =  powerUps.get(i).update();
			if (remove){
				powerUps.remove(i);
				i--;
			}
		}

		//Устанавливаем если пули и монстры прикоснулись, то пули удаляем а монстры получают урон и завершаем циклы
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

		//Устанавливаем убит ли монстр?Если убит то появляеться шанс на бонус, очки .Удаляем монстра и делаем взрыв
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
		//Обновляем взрыв и удаляем его
		for (int i =0; i < explosions.size(); i++){
			boolean remove =  explosions.get(i).update();
			if (remove){
				explosions.remove(i);
				i--;

			}
		}

		//Если игрок и монстр соприкоснулись то игрок получает урон
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

		//Если игрок и бонус соприкоснулись то пишем текст и добавляем бонус, потом удаляем бонус
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



		//Если время не равно 0 то сравниваем с разнице во времени и выключаем заморозку времени если разница превышает лимит времени
		if (slowDownTime != 0 ){
			slowDownTimeDiff = (System.nanoTime() - slowDownTime)/1000000;
			if (slowDownTimeDiff > slowDownLength){
				slowDownTime = 0;
				for (int j = 0; j < enemies.size(); j++){
					enemies.get(j).setSlow(false);
				}
			}
		}

		//Обновляем текст и удаляем его
		for (int i = 0; i < texts.size(); i++){
			boolean remove = texts.get(i).update();
			if (remove){
				texts.remove(i);
				i--;
			}
		}

		//Если у игрока заканчиваеться жизни(игрко умер), то  выключаем цикл игры
		if (player.isDead()){
			running = false;
		}

	}
	private void Render() {//Рисуем все на окне
		g.setColor(Color.BLUE);
		g.fillRect(0,0,WIDTH,HEIGHT);
		g.drawImage(img, 0,0,null);//Рисунок
		//Если игрок подобрал бонус заморозки то делаем экран чуть прозрачнее
		if (slowDownTime != 0) {
			g.setColor(new Color(255, 255, 255, 64));
			g.fillRect(0, 0, WIDTH, HEIGHT);
		}
		wave.draw(g);//Рисуем волны
		player.draw(g);//Рисуем игрок


		//Рисуем каждую пулю
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).draw(g);
		}

		//Рисуем каждого монстра
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).draw(g);
		}

		//Ричсуем каждый бонус
		for (int i = 0; i < powerUps.size(); i++) {
			powerUps.get(i).draw(g);
		}

		//Рисуем каждый взрыв
		for (int i = 0; i < explosions.size(); i++) {
			explosions.get(i).draw(g);
		}

		//Рисуем мощь игрока(благодаря бонусам) на верхнем левом углу
		g.setColor(Color.YELLOW);
		g.fillRect(20, 40, player.getPower() * 8, 8);
		g.setColor(Color.YELLOW.darker());
		g.setStroke(new BasicStroke(2));
		for (int i = 0; i < player.getRequestPower(); i++) {
			g.drawRect(20 + 8 * i, 40, 8, 8);
		}
		g.setStroke(new BasicStroke(1));

		//Рисуем очки на верхнем правом углу
		g.setColor(Color.WHITE);
		g.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		g.drawString("Score " + Player.getScore(), WIDTH - 100, 30);

		//Рисуем дамаг по середине внизу
		g.setColor(Color.WHITE);
		g.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		g.drawString("Damage = " + Player.PlayersUpsDamage()+ "("+ Enemy.damage + ")",  240, HEIGHT - 10);

		//Рисуем пули в правом нижнем углу
		g.setColor(Color.WHITE);
		g.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		g.drawString("Bullet = " + Player.PlayersUpsBullet(),  460, HEIGHT - 10);

		//Рисуем скорость в левом нижнем углу
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


		//Рисуем белую полоску которая потихоньку уменьшаеться
		if (slowDownTime != 0) {
			g.setColor(Color.WHITE);
			g.drawRect(20, 60, 100, 8);
			g.fillRect(20, 60, (int) (100 - 100.0 * slowDownTimeDiff / slowDownLength), 8);
		}

		//Жизнь монстра босса
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

		//Рисуем текст
		for (int i = 0; i < texts.size(); i++) {
			texts.get(i).draw(g);

		}


	}

	private void Draw(){//Передаем изображение в окно
		Graphics g2 = this.getGraphics();
		g2.drawImage(image,0,0,null);
		g2.dispose();



	}
}





