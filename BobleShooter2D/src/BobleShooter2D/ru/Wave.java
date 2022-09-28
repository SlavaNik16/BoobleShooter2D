package BobleShooter2D.ru;

import java.awt.*;
import java.io.IOException;


public class Wave {


	public long waveStartTime;//Начало времени волны
	public long waveStartTimeDiff;//Разница между началом времени волны и концом
	public static int waveNumber;//Номер волны
	public boolean waveStart;//Началась ли новая волна
	public static int waveDelay = 2000;//Промежуток между появлением волны при всех выолненных условиях


	public Wave() {
		waveStartTime = 0;
		waveStartTimeDiff = 0;
		waveNumber = 0;
		waveStart = true;

	}

	//Создание новыч Монстров
	public void createNewEnemies() {
		GamePanel.enemies.clear();//Очищаем все окно
		if (waveNumber == 1) {
			for (int i = 0 ; i < 4 ; i++){
				GamePanel.enemies.add(new Enemy(1, 1));
			}
		}
		if(waveNumber == 2){
			for (int i = 0; i < 4; i++) {
				GamePanel.enemies.add(new Enemy(1, 2));
			}
		}
		if (waveNumber == 3) {
			for (int i = 0 ; i < 4 ; i++){
				GamePanel.enemies.add(new Enemy(1, 3));

			}
		}
		if(waveNumber == 4){
			for (int i = 0; i < 4; i++) {
				GamePanel.enemies.add(new Enemy(1, 4));

			}
		}
		if(waveNumber == 5) {
			for (int i = 0; i < 4; i++) {
				GamePanel.enemies.add(new Enemy(1, 5));
			}
		}
		if(waveNumber == 6) {
			for (int i = 0; i < 4; i++) {
				GamePanel.enemies.add(new Enemy(1, 6));
			}
		}
		if(waveNumber == 7) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(1, 7));
			}
		}
		if(waveNumber == 8) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(1, 8));
			}
		}
		if(waveNumber == 9) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(1, 9));
			}
		}
		if(waveNumber == 10) {
			for (int i = 0; i < 1; i++) {
				GamePanel.enemies.add(new Enemy(1, 10));
			}
		}


		if (waveNumber == 11){
			for (int i = 0; i < 4; i++) {
				GamePanel.enemies.add(new Enemy(2, 1));
			}
		}
		if(waveNumber == 12){
			for (int i = 0; i < 4; i++) {
				GamePanel.enemies.add(new Enemy(2, 2));
			}
		}
		if (waveNumber == 13) {
			for (int i = 0 ; i < 4 ; i++){
				GamePanel.enemies.add(new Enemy(2, 3));

			}
		}
		if(waveNumber == 14){
			for (int i = 0; i < 4; i++) {
				GamePanel.enemies.add(new Enemy(2, 4));

			}
		}
		if(waveNumber == 15) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(2, 5));
			}
		}
		if(waveNumber == 16) {
			for (int i = 0; i < 4; i++) {
				GamePanel.enemies.add(new Enemy(2, 6));
			}
		}
		if(waveNumber == 17) {
			for (int i = 0; i < 1; i++) {
				GamePanel.enemies.add(new Enemy(2, 7));
			}
		}
		if(waveNumber == 18) {
			for (int i = 0; i < 1; i++) {
				GamePanel.enemies.add(new Enemy(2, 8));
			}
		}
		if(waveNumber == 19) {
			for (int i = 0; i < 15; i++) {
				GamePanel.enemies.add(new Enemy(2, 9));
			}
		}
		if(waveNumber == 20) {
			for (int i = 0; i < 1; i++) {
				GamePanel.enemies.add(new Enemy(2, 10));
			}
		}
		if(waveNumber == 21) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(3, 1));
			}
		}
		if (waveNumber == 22){
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(3, 2));
			}
		}
		if(waveNumber == 23){
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(3, 3));
			}
		}
		if (waveNumber == 24) {
			for (int i = 0 ; i < 2 ; i++){
				GamePanel.enemies.add(new Enemy(3, 4));

			}
		}
		if(waveNumber == 25){
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(3, 5));

			}
		}
		if(waveNumber == 26) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(3, 6));
			}
		}
		if(waveNumber == 27) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(3, 7));
			}
		}
		if(waveNumber == 28) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(3, 8));
			}
		}
		if(waveNumber == 29) {
			for (int i = 0; i < 15; i++) {
				GamePanel.enemies.add(new Enemy(3, 9));
			}
		}
		if(waveNumber == 30) {
			for (int i = 0; i < 1; i++) {
				GamePanel.enemies.add(new Enemy(3, 10));
			}
		}
		if(waveNumber == 31) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(1, 6));
				GamePanel.enemies.add(new Enemy(2, 3));
				GamePanel.enemies.add(new Enemy(3, 1));
			}
		}
		if(waveNumber == 32) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(1, 7));
				GamePanel.enemies.add(new Enemy(2, 4));
				GamePanel.enemies.add(new Enemy(3, 2));
			}
		}
		if (waveNumber == 33){
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(1, 8));
				GamePanel.enemies.add(new Enemy(2, 4));
				GamePanel.enemies.add(new Enemy(3, 3));
			}
		}
		if(waveNumber == 34){
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(2, 1));
				GamePanel.enemies.add(new Enemy(2, 5));
				GamePanel.enemies.add(new Enemy(3, 4));
			}
		}
		if (waveNumber == 35) {
			for (int i = 0 ; i < 2 ; i++){
				GamePanel.enemies.add(new Enemy(2, 2));
				GamePanel.enemies.add(new Enemy(2, 6));
				GamePanel.enemies.add(new Enemy(3, 5));

			}
		}
		if(waveNumber == 36){
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(2, 3));
				GamePanel.enemies.add(new Enemy(2, 7));
				GamePanel.enemies.add(new Enemy(3, 6));

			}
		}
		if(waveNumber == 37) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(2, 8));
				GamePanel.enemies.add(new Enemy(3, 7));
			}
		}
		if(waveNumber == 38) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(2, 9));
				GamePanel.enemies.add(new Enemy(3, 8));
			}
		}
		if(waveNumber == 39) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(3, 1));
				GamePanel.enemies.add(new Enemy(3, 8));
			}
		}
		if(waveNumber == 40) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(1, 10));
				GamePanel.enemies.add(new Enemy(2, 10));
				GamePanel.enemies.add(new Enemy(3, 9));

			}
		}
		if(waveNumber == 41) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(4, 1));

			}
		}
		if(waveNumber == 42){
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(4, 2));

			}
		}
		if(waveNumber == 43) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(4, 3));
			}
		}
		if(waveNumber == 44) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(4, 4));
			}
		}
		if(waveNumber == 45) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(4, 5));
			}
		}
		if(waveNumber == 46) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(4, 6));

			}
		}
		if(waveNumber == 47){
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(4, 7));

			}
		}
		if(waveNumber == 48) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(4, 8));
			}
		}
		if(waveNumber == 49) {
			for (int i = 0; i < 2; i++) {
				GamePanel.enemies.add(new Enemy(4, 9));
			}
		}
		if(waveNumber == 50) {
			for (int i = 0; i < 1; i++) {
				GamePanel.enemies.add(new Enemy(4, 10));
			}
		}
		if (waveNumber == 51){
			GamePanel.running = false;
		}
	}
	public void update() {


		//Добавляем волну(НОМЕР) если время равно 0 и монстром не осталось(равно 0)
		if(waveStartTime == 0 && GamePanel.enemies.size() == 0 ){
			waveNumber++;
			waveStart = false;
			waveStartTime = System.nanoTime();
		}else{//Если же одно из требоваенй не выполнено то делаем разницу  между временем и проверяем больше разница чем  промежуток,если да то обнуляем времЯ до 0
			//и  включаем в ожиданию новую волну
			waveStartTimeDiff = (System.nanoTime() - waveStartTime)/1000000;
			if (waveStartTimeDiff > waveDelay){
				waveStart = true;
				waveStartTime = 0;
				waveStartTimeDiff = 0;

			}
		}
		//Если монстры убитфы  и время начало волны истинно то создаем монстров
		if (waveStart && GamePanel.enemies.size() == 0){
			createNewEnemies();
		}
	}
	public void draw(Graphics2D g){
		//Если время не равно 0, то пишем надпись , которая  постепенно изчезает
		if (waveStartTime != 0) {
			g.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			String s = "- В О Л Н А " + waveNumber + " - ";
			int length = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
			int alpha = (int) (255 * Math.sin(3.14 * waveStartTimeDiff / waveDelay));
			if (alpha > 255) alpha = 255;
			g.setColor(new Color(255, 255, 255, alpha));
			g.drawString(s, GamePanel.WIDTH / 2 - length + 60, GamePanel.HEIGHT / 2);
		}

		//Делаем жизни игроку, который возвращает жизни игрока
		for (int i = 0; i < Player.getLives(); i++){
			g.setColor(Color.RED);
			g.fillOval(20+(20 * i), 20, Player.getR() * 2, Player.getR() * 2);
			g.setStroke(new BasicStroke(3));
			g.setColor(Color.RED.darker());
			g.drawOval(20+(20 * i), 20, Player.getR() * 2, Player.getR() * 2);
			g.setStroke(new BasicStroke(1));

		}



	}
}
