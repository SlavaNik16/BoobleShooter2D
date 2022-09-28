/*package BobleShooter2D.ru;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.jar.JarException;

import javax.sound.sampled.*;

public class Sound {
	 
	
	private String track; // адрес трека(файла)
	private Clip clip = null;// ссылка на объект класса
	private FloatControl volumeC = null;// контролер громкости
	private double wt; //уровень громкости

	//конструктор (адрес файла, уровень громкости)
	public Sound( String track, double w){
		this.track = track;
		this.wt =wt;
	}


	public void sound() {
		File f = new File(this.track);// передаем звуковой файл в f
		//поток для записи и считывания
		AudioInputStream tr = null; // обьект потока AudioInputStream пуст
		try {
			tr = AudioSystem.getAudioInputStream(f); // Получаем AudioInputStream (нужный файл)
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			clip = AudioSystem.getClip();//Получаем реализацию интерфейса Clip
			clip.open(tr); //Загружаем наш звуковой поток в Clip
			//Получаем контроллер громкости
			volumeC = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

			clip.setFramePosition(0); //устанавливаем указатель на старт
			clip.start(); //Поехали!!!

		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	//уровень громкости
	public void setVolume() {
		if (wt<0) wt = 0;
		if (wt>1) wt = 1;
		float min = volumeC.getMinimum();
		float max = volumeC.getMaximum();
		volumeC.setValue((max-min)*(float)wt+min);
	}
}

*/
