package game;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import First.Main;

public class Sprite {
	String src;
	private Image image;
	
	public Sprite(String src) {
		this.src = src;
	}
	
	public void loadFile() {
		try {
			this.image = ImageIO.read(new File("src/Sprites/" + this.src));
		} catch(IOException e) {
			JOptionPane.showMessageDialog(null, "The file \"" + this.src + "\" is missing from the src/Sprites folder.");
			System.exit(1);
		}
	}
	
	public void draw(Graphics g, int x, int y) {
		g.drawImage(this.image, x, y, null);
	}
	
	public void draw(Graphics g, int x, int y, int w, int h) {
		g.drawImage(this.image, x, y, w, h, null);
	}
	
	public void drawBackground(Graphics g, int x, int y) {
		if(Main.INSTANCE.save.y + 24 >= y + this.getImage().getHeight(null)) {
			g.drawImage(this.image, x, y, null);
		}
	}
	
	public void drawForeground(Graphics g, int x, int y) {
		if(Main.INSTANCE.save.y + 24 < y + this.getImage().getHeight(null)) {
			g.drawImage(this.image, x, y, null);
		}
	}
	
	public Image getImage() {
		return this.image;
	}
}
