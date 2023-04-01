
package test;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio {
	AudioInputStream audioIn;
	String audioName;
	Clip clip;
	boolean isPlay;

	public Audio(String audioName) {
		this.audioName = audioName;
		this.isPlay = false;
		try {
			audioIn = AudioSystem.getAudioInputStream(new File(audioName + ".wav"));
			clip = AudioSystem.getClip();
			clip.open(audioIn);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Audio() {

		this.isPlay = false;
		try {
			audioIn = AudioSystem.getAudioInputStream(new File("./data/sound/" + audioName + ".wav"));
			clip = AudioSystem.getClip();
			clip.open(audioIn);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void change(String audioName) {
		this.audioName = audioName;
		stop();
		try {
			audioIn = AudioSystem.getAudioInputStream(new File("./data/sound/" + audioName + ".wav"));
			clip = AudioSystem.getClip();
			clip.open(audioIn);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void play() {
		this.isPlay = true;
		clip.start();

	}

	public void stop() {
		this.isPlay = false;
		clip.stop();
	}
}