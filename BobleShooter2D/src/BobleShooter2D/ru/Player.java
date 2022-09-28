package BobleShooter2D.ru;

import java.awt.*;


public class Player {


	//Fields

	private static int x;//Создаем переменные  координат x y r
	private  static int y;
	private static int r;


	private double dx;//Переменные диоганалей
	private double dy;

	public static double speed;//Скорость

	//Переаменные движения
	private static boolean up;
	private static boolean down;
	private static boolean left;
	private static boolean right;

	//Переменные огня из пуль
	private static boolean firing;
	private long firingTime;//Время вылета пули
	private long firingDelay;//Задержка между пулями

	private static boolean recovering;//Раняли ли игрока поставим на false
	private static long recoveringTime;//Время бесмертия игрока при ранении

	public static int powerLevel;//Левел игрока
	private int power;//Мощь игрока
	private int[] requestPower = {//Уровень игрока назначаем
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23 ,24 ,25, 26, 27, 28 ,29 ,30, 31,32,33,34,35,36,37,38,39,40
	};


	//Цвет
	private Color color1;
	private Color color2;

	//Жизни игрока
	public static int lives;

	//Очки игрока
	private static int score;

	private static int PlayerUpSpeed;

	private static int PlayerUpBullet;

	private static int PlayerUpDamage;


	private boolean pressed1 = true;
	private boolean pressed2 = true;
	private boolean pressed3 = true;
	private boolean pressed4 = true;
	private boolean pressed5 = true;
	private boolean pressed6 = true;
	private boolean pressed7 = true;
	private boolean pressed8 = true;
	private boolean pressed9 = true;
	private boolean pressed10 = true;
	private boolean pressed11 = true;
	private boolean pressed12 = true;
	private boolean pressed13 = true;
	private boolean pressed14 = true;
	private boolean pressed15 = true;




	//Constuctor

	public Player() {
		x = GamePanel.WIDTH / 2;
		y = GamePanel.HEIGHT / 2;
		r = 5;

		dx = 0;
		dy = 0;

		speed = 7;

		color1 = Color.WHITE;
		color2 = Color.RED;

		lives = 5;
		//lives = 50;

		firing = false;
		firingTime = System.nanoTime();
		firingDelay = 200;

		recovering = false;
		recoveringTime = 0;

		score = 0;

		PlayerUpSpeed = 0;
		PlayerUpBullet = 0;
		PlayerUpDamage = 0;


	}

	public static int getX() {
		return x;
	}

	public static int getY() {
		return y;
	}

	public static int getR() {
		return r;
	}

	public static int getLives() {
		return lives;
	}

	//если игрока ранят то уменьшаем житзнь и включаем бессмертия а обозначенное время
	public static void loseLive() {
		lives--;
		recovering = true;
		recoveringTime = System.nanoTime();
	}

	//Назначам движение слушателю
	public static void setUp(boolean b) {
		up = b;
	}

	public static void setDown(boolean b) {
		down = b;
	}

	public static void setLeft(boolean b) {
		left = b;
	}

	public static void setRight(boolean b) {
		right = b;
	}

	public static void setFiring(boolean b) {
		firing = b;
	}


	public boolean isRecovering() {
		return recovering;
	}

	//Возвращаем очки
	public static int getScore() {
		return score;
	}

	//Добавляем очки
	public static void addScore(int i) {
		score += i;
	}

	//Если игрок умер , то возвращаем жизни на нуле
	public boolean isDead() {
		return lives <= 0;
	}

	public void DEAD() {
		GamePanel.enemies.clear();
	}

	//Если игрок подобрал бонус жизни то возвращаем ему жизнь
	public void gainLive() {
		lives++;
	}

	public static int PlayersUpsSpeed() {
		return PlayerUpSpeed;
	}

	public static int PlayersUpsBullet() {
		return PlayerUpBullet;
	}

	public static int PlayersUpsDamage(){ return PlayerUpDamage;}


	//Бонус силы, если сила равна 50(мах) то больше не будет набираться, если сила равна назначенному уровню, то уровень подымаеться а сила переходит к нулю
	public void increase(int i) {
		power += i;
		if (power == 50) {
			if (power >= requestPower[powerLevel]) {
				power = requestPower[powerLevel];
			}
			return;
		}
		if (power >= requestPower[powerLevel]) {
			power -= requestPower[powerLevel];
			powerLevel++;
		}
	}


	public int getPower() {
		return power;
	}

	public int getRequestPower() {
		return requestPower[powerLevel];
	}

	//Functions
	public void update() {
		//если игрок движеться наверх то мы замедляем ему скорость
		if (up) {
			dy = -speed;
		}
		//если игрок движеться вниз то мы увеличиваем ему скорость
		if (down) {
			dy = speed;
		}
		//если игрок движеться налево то мы замедляем ему скорость
		if (left) {
			dx = -speed;
		}
		//если игрок движеться направо то мы увеличиваем ему скорость
		if (right) {
			dx = speed;
		}
		//Присваиваем кординатам скорость углов
		if (GamePanel.slowStop){
			x += dx * 0;
			y += dy * 0;
		}else {
			x += dx;
			y += dy;
		}
		//Если игрок выходит за рамки радиуса то останавливаем его на нем
		if (x < r) x = r;
		if (y < r) y = r;
		if (x > GamePanel.WIDTH - r) x = GamePanel.WIDTH - r;
		if (y > GamePanel.HEIGHT - r) y = GamePanel.HEIGHT - r;

		//Потом обнуляем диоганали
		dx = 0;
		dy = 0;

		//Если игрок начал палить то делаем ему задержку, и если игрок повышает уровеь то добавляем новые пули
		if (firing) {
			long elapsed = (System.nanoTime() - firingTime) / 1000000;

			if (elapsed > firingDelay) {

				firingTime = System.nanoTime();

				if (powerLevel < 2) {
					GamePanel.bullets.add(new Bullet(270, x, y));
				} else if (powerLevel == 2 || powerLevel == 3) {

					if (GamePanel.rightmouse && pressed1) {
						pressed1 = false;
						PlayerUpSpeed++;
					} else if (GamePanel.rightmouse1 && pressed1) {
						pressed1 = false;
						PlayerUpBullet++;
					} else if (GamePanel.rightmouse2 && pressed1) {
						pressed1 = false;
						PlayerUpDamage++;
					}
				} else if (powerLevel == 4 || powerLevel == 5) {

					if (GamePanel.rightmouse && pressed2) {
						pressed2 = false;
						PlayerUpSpeed++;
					} else if (GamePanel.rightmouse1 && pressed2) {
						pressed2 = false;
						PlayerUpBullet++;
					} else if (GamePanel.rightmouse2 && pressed2) {
						pressed2 = false;
						PlayerUpDamage++;
					}

				} else if (powerLevel == 6 || powerLevel == 7) {

					if (GamePanel.rightmouse && pressed3) {
						pressed3 = false;
						PlayerUpSpeed++;
					} else if (GamePanel.rightmouse1 && pressed3) {
						pressed3 = false;
						PlayerUpBullet++;
					} else if (GamePanel.rightmouse2 && pressed3) {
						pressed3 = false;
						PlayerUpDamage++;
					}

				} else if (powerLevel == 8 || powerLevel == 9) {

					if (GamePanel.rightmouse && pressed4) {
						pressed4 = false;
						PlayerUpSpeed++;
					} else if (GamePanel.rightmouse1 && pressed4) {
						pressed4 = false;
						PlayerUpBullet++;
					} else if (GamePanel.rightmouse2 && pressed4) {
						pressed4 = false;
						PlayerUpDamage++;
					}

				} else if (powerLevel == 10 || powerLevel == 11) {

					if (GamePanel.rightmouse && pressed5) {
						pressed5 = false;
						PlayerUpSpeed++;
					} else if (GamePanel.rightmouse1 && pressed5) {
						pressed5 = false;
						PlayerUpBullet++;
					} else if (GamePanel.rightmouse2 && pressed5) {
						pressed5 = false;
						PlayerUpDamage++;
					}

				} else if (powerLevel == 12 || powerLevel == 13) {

					if (GamePanel.rightmouse && pressed6) {
						pressed6 = false;
						PlayerUpSpeed++;
					} else if (GamePanel.rightmouse1 && pressed6) {
						pressed6 = false;
						PlayerUpBullet++;
					} else if (GamePanel.rightmouse2 && pressed6) {
						pressed6 = false;
						PlayerUpDamage++;
					}

				} else if (powerLevel == 14 || powerLevel == 15) {

					if (GamePanel.rightmouse && pressed7) {
						pressed7 = false;
						PlayerUpSpeed++;
					} else if (GamePanel.rightmouse1 && pressed7) {
						pressed7 = false;
						PlayerUpBullet++;
					} else if (GamePanel.rightmouse2 && pressed7) {
						pressed7 = false;
						PlayerUpDamage++;
					}

				} else if (powerLevel == 16 || powerLevel == 17) {

					if (GamePanel.rightmouse && pressed8) {
						pressed8 = false;
						PlayerUpSpeed++;
					} else if (GamePanel.rightmouse1 && pressed8) {
						pressed8 = false;
						PlayerUpBullet++;
					} else if (GamePanel.rightmouse2 && pressed8) {
						pressed8 = false;
						PlayerUpDamage++;
					}

				} else if (powerLevel == 18 || powerLevel == 19) {

					if (GamePanel.rightmouse && pressed9) {
						pressed9 = false;
						PlayerUpSpeed++;
					} else if (GamePanel.rightmouse1 && pressed9) {
						pressed9 = false;
						PlayerUpBullet++;
					} else if (GamePanel.rightmouse2 && pressed9) {
						pressed9 = false;
						PlayerUpDamage++;
					}

				} else if (powerLevel == 20) {


					if (GamePanel.rightmouse && pressed10) {
						pressed10 = false;
						PlayerUpSpeed++;
					} else if (GamePanel.rightmouse1 && pressed10) {
						pressed10 = false;
						PlayerUpBullet++;
					} else if (GamePanel.rightmouse2 && pressed10) {
						pressed10 = false;
						PlayerUpDamage++;
					}

				}else if (powerLevel == 21 || powerLevel == 22 ) {
					if (GamePanel.rightmouse && pressed11) {
						pressed11 = false;
						PlayerUpSpeed++;
					} else if (GamePanel.rightmouse1 && pressed11) {
						pressed11 = false;
						PlayerUpBullet++;
					} else if (GamePanel.rightmouse2 && pressed11) {
						pressed11 = false;
						PlayerUpDamage++;
					}
				}else if((powerLevel == 23 )) {
					if (GamePanel.rightmouse && pressed12) {
						pressed12 = false;
						PlayerUpSpeed++;
					} else if (GamePanel.rightmouse1 && pressed12) {
						pressed12 = false;
						PlayerUpBullet++;
					} else if (GamePanel.rightmouse2 && pressed12) {
						pressed12 = false;
						PlayerUpDamage++;
					} 
				} else if((powerLevel == 24 )) {
					if (GamePanel.rightmouse && pressed13) {
						pressed13 = false;
						PlayerUpSpeed++;
					} else if (GamePanel.rightmouse1 && pressed13) {
						pressed13 = false;
						PlayerUpBullet++;
					} else if (GamePanel.rightmouse2 && pressed13) {
						pressed13 = false;
						PlayerUpDamage++;
					}
				} else if((powerLevel == 25 )) {
					if (GamePanel.rightmouse && pressed14) {
						pressed14 = false;
						PlayerUpSpeed++;
					} else if (GamePanel.rightmouse1 && pressed14) {
						pressed14 = false;
						PlayerUpBullet++;
					} else if (GamePanel.rightmouse2 && pressed14) {
						pressed14 = false;
						PlayerUpDamage++;
					}
				}else if((powerLevel == 26 )) {
					if (GamePanel.rightmouse && pressed15) {
						pressed15 = false;
						PlayerUpSpeed++;
					} else if (GamePanel.rightmouse1 && pressed15) {
						pressed15 = false;
						PlayerUpBullet++;
					} else if (GamePanel.rightmouse2 && pressed15) {
						pressed15 = false;
						PlayerUpDamage++;
					}
				}



				if (PlayerUpSpeed == 1) {
					firingDelay = 180;
					GamePanel.bullets.add(new Bullet(270, x, y));
				}
				if (PlayerUpSpeed == 2) {
					firingDelay = 160;
					GamePanel.bullets.add(new Bullet(270, x, y));
				}
				if (PlayerUpSpeed == 3) {
					firingDelay = 140;
					GamePanel.bullets.add(new Bullet(270, x, y));
				}
				if (PlayerUpSpeed == 4) {
					firingDelay = 120;
					GamePanel.bullets.add(new Bullet(270, x, y));
				}
				if (PlayerUpSpeed == 5) {
					firingDelay = 100;
					GamePanel.bullets.add(new Bullet(270, x, y));
				}
				if (PlayerUpSpeed == 6) {
					firingDelay = 80;
					GamePanel.bullets.add(new Bullet(270, x, y));
				}
				if (PlayerUpSpeed == 7) {
					firingDelay = 60;
					GamePanel.bullets.add(new Bullet(270, x, y));
				}
				if (PlayerUpSpeed == 8) {
					firingDelay = 40;
					GamePanel.bullets.add(new Bullet(270, x, y));
				}
				if (PlayerUpSpeed == 9) {
					firingDelay = 20;
					GamePanel.bullets.add(new Bullet(270, x, y));
				}
				if (PlayerUpSpeed == 10) {
					firingDelay = 10;
					GamePanel.bullets.add(new Bullet(270, x, y));
				}
				if(PlayerUpSpeed == 11) {
					firingDelay = 1;
					GamePanel.bullets.add(new Bullet(270, x, y));
				}
				if(PlayerUpSpeed == 12) {
					firingDelay = 1;
					Enemy.speed = 12;
					GamePanel.bullets.add(new Bullet(270, x, y));
				}
				if(PlayerUpSpeed == 13) {
					firingDelay = 1;
					Enemy.speed = 14;
					GamePanel.bullets.add(new Bullet(270, x, y));
				}
				if(PlayerUpSpeed == 14) {
					firingDelay = 1;
					Enemy.speed = 16;
					GamePanel.bullets.add(new Bullet(270, x, y));
				}
				if(PlayerUpSpeed >= 15) {
					firingDelay = 1;
					Enemy.speed = 18;
					GamePanel.bullets.add(new Bullet(270, x, y));
				}
				//--------------------------------------------------------------------------------------------------------------------
				if (PlayerUpDamage == 1) {
					Enemy.damage = 2;
					GamePanel.bullets.add(new Bullet(270, x, y));
				}
				if (PlayerUpDamage == 2) {
					Enemy.damage = 3;
					GamePanel.bullets.add(new Bullet(270, x, y));
				}
				if (PlayerUpDamage == 3) {
					Enemy.damage = 4;
					GamePanel.bullets.add(new Bullet(270, x, y));
				}
				if (PlayerUpDamage == 4) {
					Enemy.damage = 5;
					GamePanel.bullets.add(new Bullet(270, x, y));
				}
				if (PlayerUpDamage == 5) {
					Enemy.damage = 6;
					GamePanel.bullets.add(new Bullet(270, x, y));
				}
				if (PlayerUpDamage == 6) {
					Enemy.damage = 7;
					GamePanel.bullets.add(new Bullet(270, x, y));
				}
				if (PlayerUpDamage == 7) {
					Enemy.damage = 8;
					GamePanel.bullets.add(new Bullet(270, x, y));
				}
				if (PlayerUpDamage == 8) {
					Enemy.damage = 9;
					GamePanel.bullets.add(new Bullet(270, x, y));
				}
				if (PlayerUpDamage == 9) {
					Enemy.damage = 10;
					GamePanel.bullets.add(new Bullet(270, x, y));
				}
				if (PlayerUpDamage == 10) {
					Enemy.damage = 11;
					GamePanel.bullets.add(new Bullet(270, x, y));
				}
				if (PlayerUpDamage == 11) {
					Enemy.damage = 12;
					GamePanel.bullets.add(new Bullet(270, x, y));
				}
				if (PlayerUpDamage == 12) {
					Enemy.damage = 13;
					GamePanel.bullets.add(new Bullet(270, x, y));
				}
				if (PlayerUpDamage == 13) {
					Enemy.damage = 14;
					GamePanel.bullets.add(new Bullet(270, x, y));
				}
				if (PlayerUpDamage == 14) {
					Enemy.damage = 15;
					GamePanel.bullets.add(new Bullet(270, x, y));
				}
				if (PlayerUpDamage >= 15) {
					Enemy.damage = 16;
					GamePanel.bullets.add(new Bullet(270, x, y));
				}
				//--------------------------------------------------------------------------------------------------

				if (PlayerUpBullet == 1) {
					GamePanel.bullets.add(new Bullet(270, x, y));
					GamePanel.bullets.add(new Bullet(270, x - 5, y));
					GamePanel.bullets.add(new Bullet(270, x + 5, y));
				}
				if (PlayerUpBullet == 2) {
					GamePanel.bullets.add(new Bullet(270, x, y));
					GamePanel.bullets.add(new Bullet(275, x + 5, y));
					GamePanel.bullets.add(new Bullet(265, x - 5, y));
					GamePanel.bullets.add(new Bullet(280, x + 5, y));
					GamePanel.bullets.add(new Bullet(260, x - 5, y));
				}
				if (PlayerUpBullet == 3) {
					GamePanel.bullets.add(new Bullet(270, x, y));
					GamePanel.bullets.add(new Bullet(275, x + 5, y));
					GamePanel.bullets.add(new Bullet(265, x - 5, y));
					GamePanel.bullets.add(new Bullet(280, x + 5, y));
					GamePanel.bullets.add(new Bullet(260, x - 5, y));

					GamePanel.bullets.add(new Bullet(285, x + 5, y));
					GamePanel.bullets.add(new Bullet(255, x - 5, y));
				}
				if (PlayerUpBullet == 4) {
					GamePanel.bullets.add(new Bullet(270, x, y));
					GamePanel.bullets.add(new Bullet(275, x + 5, y));
					GamePanel.bullets.add(new Bullet(265, x - 5, y));
					GamePanel.bullets.add(new Bullet(280, x + 5, y));
					GamePanel.bullets.add(new Bullet(260, x - 5, y));

					GamePanel.bullets.add(new Bullet(285, x + 5, y));
					GamePanel.bullets.add(new Bullet(255, x - 5, y));

					GamePanel.bullets.add(new Bullet(290, x + 5, y));
					GamePanel.bullets.add(new Bullet(250, x - 5, y));
				}
				if (PlayerUpBullet == 5) {
					GamePanel.bullets.add(new Bullet(270, x, y));
					GamePanel.bullets.add(new Bullet(275, x + 5, y));
					GamePanel.bullets.add(new Bullet(265, x - 5, y));
					GamePanel.bullets.add(new Bullet(280, x + 5, y));
					GamePanel.bullets.add(new Bullet(260, x - 5, y));

					GamePanel.bullets.add(new Bullet(285, x + 5, y));
					GamePanel.bullets.add(new Bullet(255, x - 5, y));

					GamePanel.bullets.add(new Bullet(290, x + 5, y));
					GamePanel.bullets.add(new Bullet(250, x - 5, y));

					GamePanel.bullets.add(new Bullet(295, x + 5, y));
					GamePanel.bullets.add(new Bullet(245, x - 5, y));
				}
				if (PlayerUpBullet == 6) {
					GamePanel.bullets.add(new Bullet(270, x, y));
					GamePanel.bullets.add(new Bullet(275, x + 5, y));
					GamePanel.bullets.add(new Bullet(265, x - 5, y));
					GamePanel.bullets.add(new Bullet(280, x + 5, y));
					GamePanel.bullets.add(new Bullet(260, x - 5, y));

					GamePanel.bullets.add(new Bullet(285, x + 5, y));
					GamePanel.bullets.add(new Bullet(255, x - 5, y));

					GamePanel.bullets.add(new Bullet(290, x + 5, y));
					GamePanel.bullets.add(new Bullet(250, x - 5, y));

					GamePanel.bullets.add(new Bullet(295, x + 5, y));
					GamePanel.bullets.add(new Bullet(245, x - 5, y));

					GamePanel.bullets.add(new Bullet(300, x + 5, y));
					GamePanel.bullets.add(new Bullet(240, x - 5, y));
				}
				if (PlayerUpBullet == 7) {
					GamePanel.bullets.add(new Bullet(270, x, y));
					GamePanel.bullets.add(new Bullet(275, x + 5, y));
					GamePanel.bullets.add(new Bullet(265, x - 5, y));
					GamePanel.bullets.add(new Bullet(280, x + 5, y));
					GamePanel.bullets.add(new Bullet(260, x - 5, y));

					GamePanel.bullets.add(new Bullet(285, x + 5, y));
					GamePanel.bullets.add(new Bullet(255, x - 5, y));

					GamePanel.bullets.add(new Bullet(290, x + 5, y));
					GamePanel.bullets.add(new Bullet(250, x - 5, y));

					GamePanel.bullets.add(new Bullet(295, x + 5, y));
					GamePanel.bullets.add(new Bullet(245, x - 5, y));

					GamePanel.bullets.add(new Bullet(300, x + 5, y));
					GamePanel.bullets.add(new Bullet(240, x - 5, y));

					GamePanel.bullets.add(new Bullet(90, x + 5, y));
					GamePanel.bullets.add(new Bullet(90, x - 5, y));
				}
				if (PlayerUpBullet == 8) {
					GamePanel.bullets.add(new Bullet(270, x, y));
					GamePanel.bullets.add(new Bullet(275, x + 5, y));
					GamePanel.bullets.add(new Bullet(265, x - 5, y));
					GamePanel.bullets.add(new Bullet(280, x + 5, y));
					GamePanel.bullets.add(new Bullet(260, x - 5, y));

					GamePanel.bullets.add(new Bullet(285, x + 5, y));
					GamePanel.bullets.add(new Bullet(255, x - 5, y));

					GamePanel.bullets.add(new Bullet(290, x + 5, y));
					GamePanel.bullets.add(new Bullet(250, x - 5, y));

					GamePanel.bullets.add(new Bullet(295, x + 5, y));
					GamePanel.bullets.add(new Bullet(245, x - 5, y));

					GamePanel.bullets.add(new Bullet(300, x + 5, y));
					GamePanel.bullets.add(new Bullet(240, x - 5, y));

					GamePanel.bullets.add(new Bullet(90, x + 5, y));
					GamePanel.bullets.add(new Bullet(90, x - 5, y));
				}
				if (PlayerUpBullet == 9) {
					GamePanel.bullets.add(new Bullet(270, x, y));
					GamePanel.bullets.add(new Bullet(275, x + 5, y));
					GamePanel.bullets.add(new Bullet(265, x - 5, y));
					GamePanel.bullets.add(new Bullet(280, x + 5, y));
					GamePanel.bullets.add(new Bullet(260, x - 5, y));

					GamePanel.bullets.add(new Bullet(285, x + 5, y));
					GamePanel.bullets.add(new Bullet(255, x - 5, y));

					GamePanel.bullets.add(new Bullet(290, x + 5, y));
					GamePanel.bullets.add(new Bullet(250, x - 5, y));

					GamePanel.bullets.add(new Bullet(295, x + 5, y));
					GamePanel.bullets.add(new Bullet(245, x - 5, y));

					GamePanel.bullets.add(new Bullet(300, x + 5, y));
					GamePanel.bullets.add(new Bullet(240, x - 5, y));

					GamePanel.bullets.add(new Bullet(90, x + 5, y));
					GamePanel.bullets.add(new Bullet(90, x - 5, y));

					GamePanel.bullets.add(new Bullet(95, x + 5, y));
					GamePanel.bullets.add(new Bullet(85, x - 5, y));

				}
				if (PlayerUpBullet == 10) {
					GamePanel.bullets.add(new Bullet(270, x, y));
					GamePanel.bullets.add(new Bullet(275, x + 5, y));
					GamePanel.bullets.add(new Bullet(265, x - 5, y));
					GamePanel.bullets.add(new Bullet(280, x + 5, y));
					GamePanel.bullets.add(new Bullet(260, x - 5, y));

					GamePanel.bullets.add(new Bullet(285, x + 5, y));
					GamePanel.bullets.add(new Bullet(255, x - 5, y));

					GamePanel.bullets.add(new Bullet(290, x + 5, y));
					GamePanel.bullets.add(new Bullet(250, x - 5, y));

					GamePanel.bullets.add(new Bullet(295, x + 5, y));
					GamePanel.bullets.add(new Bullet(245, x - 5, y));

					GamePanel.bullets.add(new Bullet(300, x + 5, y));
					GamePanel.bullets.add(new Bullet(240, x - 5, y));

					GamePanel.bullets.add(new Bullet(90, x + 5, y));
					GamePanel.bullets.add(new Bullet(90, x - 5, y));

					GamePanel.bullets.add(new Bullet(95, x + 5, y));
					GamePanel.bullets.add(new Bullet(85, x - 5, y));

					GamePanel.bullets.add(new Bullet(95, x + 10, y));
					GamePanel.bullets.add(new Bullet(85, x - 10, y));

				}
				if (PlayerUpBullet == 11) {
					GamePanel.bullets.add(new Bullet(270, x, y));
					GamePanel.bullets.add(new Bullet(275, x + 5, y));
					GamePanel.bullets.add(new Bullet(265, x - 5, y));
					GamePanel.bullets.add(new Bullet(280, x + 5, y));
					GamePanel.bullets.add(new Bullet(260, x - 5, y));

					GamePanel.bullets.add(new Bullet(285, x + 5, y));
					GamePanel.bullets.add(new Bullet(255, x - 5, y));

					GamePanel.bullets.add(new Bullet(290, x + 5, y));
					GamePanel.bullets.add(new Bullet(250, x - 5, y));

					GamePanel.bullets.add(new Bullet(295, x + 5, y));
					GamePanel.bullets.add(new Bullet(245, x - 5, y));

					GamePanel.bullets.add(new Bullet(300, x + 5, y));
					GamePanel.bullets.add(new Bullet(240, x - 5, y));

					GamePanel.bullets.add(new Bullet(90, x + 5, y));
					GamePanel.bullets.add(new Bullet(90, x - 5, y));

					GamePanel.bullets.add(new Bullet(95, x + 5, y));
					GamePanel.bullets.add(new Bullet(85, x - 5, y));

					GamePanel.bullets.add(new Bullet(95, x + 10, y));
					GamePanel.bullets.add(new Bullet(85, x - 10, y));

					GamePanel.bullets.add(new Bullet(95, x + 15, y));
					GamePanel.bullets.add(new Bullet(85, x - 15, y));

				}
				if (PlayerUpBullet >= 12) {
					GamePanel.bullets.add(new Bullet(270, x, y));
					GamePanel.bullets.add(new Bullet(275, x + 5, y));
					GamePanel.bullets.add(new Bullet(265, x - 5, y));
					GamePanel.bullets.add(new Bullet(280, x + 5, y));
					GamePanel.bullets.add(new Bullet(260, x - 5, y));

					GamePanel.bullets.add(new Bullet(285, x + 5, y));
					GamePanel.bullets.add(new Bullet(255, x - 5, y));

					GamePanel.bullets.add(new Bullet(290, x + 5, y));
					GamePanel.bullets.add(new Bullet(250, x - 5, y));

					GamePanel.bullets.add(new Bullet(295, x + 5, y));
					GamePanel.bullets.add(new Bullet(245, x - 5, y));

					GamePanel.bullets.add(new Bullet(300, x + 5, y));
					GamePanel.bullets.add(new Bullet(240, x - 5, y));

					GamePanel.bullets.add(new Bullet(90, x + 5, y));
					GamePanel.bullets.add(new Bullet(90, x - 5, y));

					GamePanel.bullets.add(new Bullet(95, x + 5, y));
					GamePanel.bullets.add(new Bullet(85, x - 5, y));

					GamePanel.bullets.add(new Bullet(100, x + 5, y));
					GamePanel.bullets.add(new Bullet(80, x - 5, y));

					GamePanel.bullets.add(new Bullet(105, x + 5, y));
					GamePanel.bullets.add(new Bullet(75, x - 5, y));

					GamePanel.bullets.add(new Bullet(110, x + 5, y));
					GamePanel.bullets.add(new Bullet(70, x - 5, y));

				}
			}
		}



		if (recovering) {
			long elapsed = (System.nanoTime() - recoveringTime) / 1000000;
			if (elapsed > 2000) {
				recoveringTime = 0;
				recovering = false;
			}

		}
	}






	public void draw (Graphics2D g){
		//Если игрок в бессмертном состоянии то разукрашиваем его в красный цвет,если нет т в обычный(белаый)
		if (recovering) {
			g.setColor(color2);
			g.fillOval(x - r, y - r, 2 * r, 2 * r);
		} else {
			g.setColor(color1);
			g.fillOval(x - r, y - r, 2 * r, 2 * r);
		}
	}


}


