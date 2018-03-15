package audio;

import First.Main;

public class MusicBox {
	//songs
	private AudioPlayer ortni;
	private AudioPlayer cave;
	//songs
	
	public AudioPlayer music;
	
	public boolean loop = true;
	
	public void playMusic() {
		if(Main.INSTANCE.save.area.equals("Ortni Town") || Main.INSTANCE.save.area.equals("Home") || Main.INSTANCE.save.area.equals("Empty Shack") || Main.INSTANCE.save.area.equals("Empty Shack ") || Main.INSTANCE.save.area.equals("Turtle House")) {
			initMusic();
			
			if(ortni == null) ortni = new AudioPlayer("Ortni.mp3");
			
			startMusic(ortni, true);
			/*music = ortni;
			music.rewind();
			music.play();
			loop = true;*/
		}
		
		if(Main.INSTANCE.save.area.equals("Ortni Path")) {
			initMusic();
			loop = false;
		}
		
		if(Main.INSTANCE.save.area.equals("Mysterious Cave")) {
			initMusic();
			
			if(cave == null) cave = new AudioPlayer("Cave.mp3");
			
			startMusic(cave, true);
		}
		
		if(Main.INSTANCE.save.area.equals("Forest Path")) {
			initMusic();
			
			if(cave == null) cave = new AudioPlayer("Cave.mp3");
			
			startMusic(cave, true);
		}
	}
	
	private void initMusic() {
		if(music != null) {
			music.stop();
		}
	}
	
	private void startMusic(AudioPlayer song, boolean wantLoop) {
		music = song;
		music.rewind();
		music.play();
		loop = wantLoop;
	}
}
