package battle;

import java.awt.Rectangle;

import game.Sprite;

/* Name
 * HP
 * Attacks -- connect to seperate attack class
 * Movement (Pattern(s))
 * Sparing ways-things
 * Dialogue
 * (sprite)
 */

public class Enemy {
	Rectangle hitbox;
	String name;
	int hp;
	String attack; 
	//sparing, attacks, and dialogue are going to be a bit harder
	Sprite sprite;
	
	Enemy(int x, int y, int width, int height, int hp, String name, String attack, Sprite sprite) {
		this.hitbox = new Rectangle(x, y, width, height);
		
		this.hp = hp;
		
		this.name= name;
		
		this.attack = attack;
		
		this.sprite = sprite;
	}
}


