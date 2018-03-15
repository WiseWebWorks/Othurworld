package inventory;

import java.io.Serializable;

public class Collected implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8073375583665823608L;
	
	public boolean Carrot;
	
	public Collected() {
		Carrot = false;
	}
	
	public Collected(boolean carrot) {
		Carrot = carrot;
	}
	
	public void collect(Item item) {
		switch(item) {
			case Carrot:
				this.Carrot = true;
			
			default:
				break;
		}
	}
}
