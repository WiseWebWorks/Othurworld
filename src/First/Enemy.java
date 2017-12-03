package First;

/* Name
 * HP
 * Attacks -- connect to seperate attack class
 * Movement (Pattern(s))
 * Sparing ways-things
 * Dialogue
 * (sprite)
 */

public class Enemy {
	String name;
	int hp;
	String attack; 
	//sparing, attacks, and dialogue are going to be a bit harder
	Sprite sprite;
	
	Enemy(int hp, String name, String attack, Sprite sprite) {
		this.hp = hp;
		this.name= name;
		this.attack = attack;
		this.sprite = sprite;
	}
}


