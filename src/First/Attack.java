package First;


/*
 * attack
 * element
 * x
 * y
 * sprite
 */

public class Attack {
	int element;//the attack's element; 0 earth 1 fire 2 air 3 water
	int attack;//the attack's damage dealt
	Sprite sprite;
	
	Attack(int element, int attack, Sprite sprite) {
		this.element = element;
		this.attack = attack;
		this.sprite = sprite;
	}
}
