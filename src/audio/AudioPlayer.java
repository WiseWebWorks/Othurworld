package audio;

import javax.sound.sampled.*;

public class AudioPlayer {
	
	public Clip clip;
	
	public AudioPlayer(String src) {
		
		try {
			
			AudioInputStream ais = 
				AudioSystem.getAudioInputStream(
					getClass().getResourceAsStream(
						"/Music/" + src
					)
				);
			AudioFormat baseFormat = ais.getFormat();
			AudioFormat decodeFormat = new AudioFormat(
				AudioFormat.Encoding.PCM_SIGNED,
				baseFormat.getSampleRate(),
				16,
				baseFormat.getChannels(),
				baseFormat.getChannels() * 2,
				baseFormat.getSampleRate(),
				false
			);
			AudioInputStream dais =
				AudioSystem.getAudioInputStream(decodeFormat, ais);
			clip = AudioSystem.getClip();
			clip.open(dais);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isPlaying() {
		return clip.isRunning();
	}
	
	public void rewind() {
		stop();
		clip.setFramePosition(0);
	}
	
	public void play() {
		if(clip == null) return;
		clip.start();
	}
	
	public void stop() {
		if(clip.isRunning()) clip.stop();
	}
	
	public void close() {
		stop();
		clip.close();
	}
}