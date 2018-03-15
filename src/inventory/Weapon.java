package inventory;

public enum Weapon {
	ChippedKnife(1);
	
	int attack;
	
	int type;
	
	private Weapon(int attack, int type) {
		this.attack = attack;
		this.type = type;
	}
	
	private Weapon(int attack) {
		this.attack = attack;
		this.type = 0;
	}
	
	public final static int KNIFE = 0;
	public final static int BOW = 1;
	public final static int SWORD = 2;
	public final static int STAFF = 3;
	public final static int SHIELD = 4;
}
