/*package BobleShooter2D.ru;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.jar.JarException;

import javax.sound.sampled.*;

public class Sound {
	 
	
	private String track; // ����� �����(�����)
	private Clip clip = null;// ������ �� ������ ������
	private FloatControl volumeC = null;// ��������� ���������
	private double wt; //������� ���������

	//����������� (����� �����, ������� ���������)
	public Sound( String track, double w){
		this.track = track;
		this.wt =wt;
	}


	public void sound() {
		File f = new File(this.track);// �������� �������� ���� � f
		//����� ��� ������ � ����������
		AudioInputStream tr = null; // ������ ������ AudioInputStream ����
		try {
			tr = AudioSystem.getAudioInputStream(f); // �������� AudioInputStream (������ ����)
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			clip = AudioSystem.getClip();//�������� ���������� ���������� Clip
			clip.open(tr); //��������� ��� �������� ����� � Clip
			//�������� ���������� ���������
			volumeC = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

			clip.setFramePosition(0); //������������� ��������� �� �����
			clip.start(); //�������!!!

		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	//������� ���������
	public void setVolume() {
		if (wt<0) wt = 0;
		if (wt>1) wt = 1;
		float min = volumeC.getMinimum();
		float max = volumeC.getMaximum();
		volumeC.setValue((max-min)*(float)wt+min);
	}
}

*/
