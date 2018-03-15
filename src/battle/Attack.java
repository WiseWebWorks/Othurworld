package battle;

import java.awt.Rectangle;

import game.Sprite;

/*
 * attack
 * element
 * x
 * y
 * sprite
 */

public class Attack {
	Rectangle hitbox;
	
	int attack;//the attack's damage dealt
	
	Sprite sprite;
	
	Attack(int x, int y, int width, int height, int attack, Sprite sprite) {
		this.hitbox = new Rectangle(x, y, width, height);
		this.attack = attack;
		this.sprite = sprite;
	}
}
