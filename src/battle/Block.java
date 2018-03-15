package battle;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.Sprite;

public class Block {
	Rectangle hitbox;
	
	Sprite sprite;
	/**
	 * A Block with a sprite
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param sprite
	 */
	Block(int x, int y, int width, int height, Sprite sprite) {
		this.hitbox = new Rectangle(x, y, width, height);
		this.sprite = sprite;
	}
	
	/**
	 * A Block
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	Block(int x, int y, int width, int height) {
		this.hitbox = new Rectangle(x, y, width, height);
	}
	
	public void draw(Graphics g) {
		if(this.sprite != null) {
			this.sprite.draw(g, this.hitbox.x, this.hitbox.y);
		} else {
			g.fillRect(this.hitbox.x, this.hitbox.y, this.hitbox.width, this.hitbox.height);
		}
	}
}
