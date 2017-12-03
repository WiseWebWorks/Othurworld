package First;

import java.awt.Color;
import java.awt.Graphics;

public class Speak {
	
	public static int endCount = 0;
	
	public static boolean[] check = new boolean[2];
	/**
	 * If the text is being said
	 */
	public static boolean speaking = false;
	/**
	 * Allows you to speed up
	 */
	private static int count = 0;
	/**
	 * What "slide" you are on.
	 */
	private static int talkFrame = 0;
	/**
	 * What letter the speach is on.
	 */
	private static int talking = 0;
	/**
	 * Makes speach in-game.
	 * @param g
	 * @param text
	 */
	static void speak(Graphics g, String[] text) {
		check[0] = talkFrame == text.length - 1 && talking == text[talkFrame].length();//end speach
		check[1] = talking == text[talkFrame].length() && talkFrame < text.length - 1;//next frame
		g.setFont(Main.small);
		
		if(speaking == false && talkFrame != text.length - 1) {
			speaking = true;
			talkFrame = 0;
			talking = 0;
			Main.INSTANCE.moving = false;
			Main.INSTANCE.runFrame = 0;
		}
		
		if(speaking == false && endCount > 16 && Main.INSTANCE.keys[90]) {
			talkFrame = 0;
			talking = 0;
		}
		
		if(speaking == true) {
			g.setColor(new Color(150,150,150));
			g.fillRect(1,150,197,48);
			g.setColor(new Color(0, 0, 0));
			g.drawRect(1, 150, 197, 48);
			count ++;
			if(Main.INSTANCE.keys[88]) {
				count = 0;
			}
			drawString(g, text[talkFrame].substring(0,talking), 3, 150);
		}
		
		if(count % 3 == 0 && talking < text[talkFrame].length()) {
			talking ++;
		}
	}
	
	private static void drawString(Graphics g, String text, int x, int y) {
        for (String line : text.split("\n")) {
            g.drawString(line, x, y += (g.getFontMetrics().getHeight()) * 2/3);
        }
    }
	
	public static void nextFrame() {
		talkFrame ++;
		talking = 0;
	}
	
	public static void endSpeak() {
		speaking = false;
		
		//talkFrame = 0;
		//talking = 0;
	}
	
	public static void waitSpeak() {
		if(speaking == false) {
			if(endCount < 21) {
				endCount ++;
			}
		} else {
			endCount = 0;
		}
	}
}
