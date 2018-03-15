package First;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Speak {
	
	/**
	 * Makes it wait before starting another speach
	 */
	public static int endCount = 0;
	
	/**
	 * Variables that check when to move to the next speach frame [1] or end the frame [0]
	 */
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
	public static int talkFrame = 0;
	/**
	 * What letter the speach is on.
	 */
	public static int talking = 0;
	
	/**
	 * Color of text
	 */
	public static Color textColor = new Color(0, 0, 0);
	
	/**
	 * Color of background
	 */
	public static Color backgroundColor = new Color(150, 150, 150);
	
	/**
	 * Color of border
	 */
	public static Color borderColor = new Color(0, 0, 0);
	
	/**
	 * Variable that is true when you answer yes
	 */
	public static boolean decision = true;
	
	private static int choice = 0;
	
	private static int wait = 16;
	
	/**
	 * Makes speach in-game.
	 * @param g
	 * @param text
	 */
	public static void speak(Graphics g, String[] text) {
		g.setFont(Main.small);
		
		if(speaking == false && (talkFrame != text.length - 1 || (text.length == 1 && talkFrame == 0)) && endCount > 16 && talkFrame < text.length) {
			speaking = true;
			talkFrame = 0;
			talking = 0;
			Main.INSTANCE.moving = false;
			Main.INSTANCE.runFrame = 0;
		}
		
		if(talkFrame >= text.length) {
			talkFrame = 0;
		}
		
		if(speaking == false && endCount > 16 && Main.INSTANCE.keys[90]) {
			talkFrame = 0;
			talking = 0;
		}
		
		check[0] = talkFrame == text.length - 1 && talking == text[talkFrame].length();//end speach
		check[1] = talking == text[talkFrame].length() && talkFrame < text.length - 1;//next frame
		
		if(speaking == true) {
			g.setColor(backgroundColor);
			g.fillRect(1,150,197,48);
			g.setColor(borderColor);
			g.drawRect(1, 150, 197, 48);
			count ++;
			if(Main.INSTANCE.keys[88] && talking != 0) {
				count = 0;
			}
			/*if(Main.INSTANCE.keys[KeyEvent.VK_C] && talking != 0) {
				talking = text[talkFrame].length();
			}*///debug
			g.setColor(textColor);
			drawString(g, text[talkFrame].substring(0,talking), 3, 150);
		}
		
		if(count % 3 == 0 && talking < text[talkFrame].length()) {
			talking ++;
		}
	}
	
	public static void setTextColor(Color text, Color background, Color border) {
		textColor = text;
		backgroundColor = background;
		borderColor = border;
	}
	
	public static void setTextColor() {
		textColor = new Color(0, 0, 0);
		backgroundColor = new Color(150, 150, 150);
		borderColor = new Color(0, 0, 0);
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
	
	public static void choice(Graphics g) {
		g.setColor(new Color(150, 150, 150));
		g.fillRect(160, 160, 39, 39);
		g.setColor(Color.black);
		g.drawRect(160, 160, 39, 39);
		
		g.drawRect(162, 163 + choice, 35, 13);
		
		g.setFont(Main.small);
		g.drawString("Yes", 163, 175);
		g.drawString("No", 163, 195);
		
		wait ++;
		
		if(Main.INSTANCE.keys[90]) {
			if(choice == 0) {
				decision = true;
			} else {
				decision = false;
			}
		}
		
		if((Main.INSTANCE.keys[38] || Main.INSTANCE.keys[40]) && wait > 10) {
			wait = 0;
			if(choice == 0) {
				choice = 20;
			} else {
				choice = 0;
			}
		}
	}
	
	public static void initChoice() {
		choice = 0;
	}
}
