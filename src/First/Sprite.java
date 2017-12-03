package First;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	String src;
	private Image image;
	
	Sprite(String src) {
		this.src = src;
	}
	
	void loadFile() {
		try {
			this.image = ImageIO.read(new File("src/" + this.src));
		} catch(IOException e) {
			System.exit(1);
		}
	}
	
	void draw(Graphics g, int x, int y) {
		g.drawImage(this.image, x, y, null);
	}
	
	void draw(Graphics g, int x, int y, int w, int h) {
		g.drawImage(this.image, x, y, w, h, null);
	}
}
