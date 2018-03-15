package collide;

import java.awt.Rectangle;

public class Collide {
	public static boolean collide(Rectangle a, Rectangle b) {
		return a.x + a.width > b.x && a.x < b.x + b.width && a.y + a.height > b.y && a.x < b.y + b.height;
	}
}