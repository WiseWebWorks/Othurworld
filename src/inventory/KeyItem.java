package inventory;

import java.io.Serializable;

@SuppressWarnings("serial")
public class KeyItem implements Serializable {
	boolean map;
	boolean combatBook;
	
	public KeyItem() {
		this.map = false;
		this.combatBook = false;
	}
}
