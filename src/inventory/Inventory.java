package inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

import First.Main;
import First.Speak;

public class Inventory implements Serializable {
	private static final long serialVersionUID = -699359932011335459L;
	public Item[] items;
	public KeyItem keyItems;
	public Weapon weapon;
	
	public int select;
	
	public int selectX;
	
	public int describe = 6;
	
	public Inventory(Item[] items, KeyItem keyItems, Weapon weapon) {
		this.items = items;
		this.keyItems = keyItems;
		this.weapon = weapon;
		
		this.select = 38;
		this.selectX = 50;
	}
	
	public static void drawInvBox(Graphics g) {
		g.setColor(new Color(150, 150, 150));
		g.fillRect(40, 35, 125, 125);
		g.setColor(Color.black);
		g.drawRect(40, 35, 125, 125);
	}
	
	public void drawItems(Graphics g) {//And weapons
		drawInvBox(g);
		
		g.setColor(Color.black);
		g.drawRect(61, select, 98, 15);
		
		for(int i = 0;i < items.length;i ++) {
			if(items[i] != null) {
				items[i].getImage().draw(g, 45, 39 + 20*i);
				g.setFont(Main.average);
				g.drawString(items[i].getName(), 63, 50 + 20*i);
				if(describe == i) {
					Speak.speak(g, items[i].description());
					if(Speak.check[0]) {
						Speak.choice(g);
					} else {
						Speak.initChoice();
					}
					if(Speak.speaking == false && Speak.check[0]) {
						if(Speak.decision) {
							items[i].playEffect(i);
						}
						describe = 6;
					}
				}
				if(select == 38 + 20*i && Main.INSTANCE.keys[90]) {
					describe = i;
				}
			}
		}
	}
	
	public void addItem(Item item) {
		if(itemLength() < items.length) {
			items[itemLength()] = item;
		}
		
		Main.INSTANCE.save.collect.collect(item);
		Main.INSTANCE.updateDelayNow = 5;
		Main.INSTANCE.updateNow = true;
	}
	
	public int itemLength() {
		int i = 0;
		while(items[i] != null) {
			i ++;
			if(i >= items.length) return 0;
		}
		return i;
	}
	
	public void drawKeyItems(Graphics g) {
		drawInvBox(g);
		
	}
	
	public void drawStats(Graphics g) {
		drawInvBox(g);
		
	}
	
	public void drawProfile(Graphics g) {
		drawInvBox(g);
		
		
	}
	
	public void useItem(int index) {
		Main.INSTANCE.save.inv.items[index] = null;
		for(int i = index+1;i < Main.INSTANCE.save.inv.items.length;i ++) {
			Main.INSTANCE.save.inv.items[i-1] = Main.INSTANCE.save.inv.items[i];
		}
	}
}