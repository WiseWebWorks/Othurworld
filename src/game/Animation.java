package game;

import java.awt.Graphics;

public class Animation {
	private Sprite[] down;
	
	private Sprite[] up;
	
	private Sprite[] left;
	
	private Sprite[] right;
	
	public int x;
	
	public int y;
	
	public int dir;
	
	private int runFrame;
	
	private int fpr;
	
	/**
	 * An Animation with 32 frames per repeat
	 * @param x
	 * @param y
	 * @param dir
	 * @param rsprite
	 * @param usprite
	 * @param lsprite
	 * @param dsprite
	 */
	public Animation(int x, int y, int dir, Sprite[] rsprite, Sprite[] usprite, Sprite[] lsprite, Sprite[] dsprite) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.right = rsprite;
		this.up = usprite;
		this.left = lsprite;
		this.down = dsprite;
		this.runFrame = 0;
		this.fpr = 32;
	}
	
	/**
	 * An Animation
	 * @param x
	 * @param y
	 * @param dir
	 * @param rsprite
	 * @param usprite
	 * @param lsprite
	 * @param dsprite
	 * @param fpr
	 */
	public Animation(int x, int y, int dir, Sprite[] rsprite, Sprite[] usprite, Sprite[] lsprite, Sprite[] dsprite, int fpr) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.right = rsprite;
		this.up = usprite;
		this.left = lsprite;
		this.down = dsprite;
		this.runFrame = 0;
		this.fpr = fpr;
	}
	
	public void reset() {
		runFrame = 0;
	}
	
	public void draw(Graphics g) {
		if(this.dir == 3) {
			for(int i = 0;i < this.down.length;i ++) {
				if(this.runFrame % this.fpr < this.fpr/this.down.length*(i+1) && this.runFrame % this.fpr >= this.fpr/this.down.length*i) {
					this.down[i].draw(g, this.x, this.y);
				}
			}
		} else {
			if(this.dir == 1) {
				for(int i = 0;i < this.up.length;i ++) {
					if(this.runFrame % this.fpr < this.fpr/this.up.length*(i+1) && this.runFrame % this.fpr >= this.fpr/this.up.length*i) {
						this.up[i].draw(g, this.x, this.y);
					}
				}
			} else {
				if(this.dir == 0) {
					for(int i = 0;i < this.right.length;i ++) {
						if(this.runFrame % this.fpr < this.fpr/this.right.length*(i+1) && this.runFrame % this.fpr >= this.fpr/this.right.length*i) {
							this.right[i].draw(g, this.x, this.y);
						}
					}
				}else {
					if(this.dir == 2) {
						for(int i = 0;i < this.left.length;i ++) {
							if(this.runFrame % this.fpr < this.fpr/this.left.length*(i+1) && this.runFrame % this.fpr >= this.fpr/this.left.length*i) {
								this.left[i].draw(g, this.x, this.y);
							}
						}
					}
				}
			}
		}
	}
	
	public void move(int dir) {
		this.runFrame ++;
		this.dir = dir;
		
		if(dir == 0) {
			this.x ++;
		}
		if(dir == 1) {
			this.y --;
		}
		if(dir == 2) {
			this.x --;
		}
		if(dir == 3) {
			this.y ++;
		}
	}
	
	public void move(int dir, int x, int y) {
		this.runFrame ++;
		this.dir = dir;
		
		this.x += x;
		this.y += y;
	}
}
