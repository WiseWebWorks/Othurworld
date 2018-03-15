package battle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import First.Main;
import collide.Collide;
import game.Sprite;
import game.Animation;

public class Battle {
	public static Battle INSTANCE = new Battle();
	
	public int momentum = 0;
	public int jump = 5;
	
	public Animation player = new Animation(100, 190, 0, new Sprite[]{Main.INSTANCE.battleRChar0, Main.INSTANCE.battleRChar1}, null, new Sprite[]{Main.INSTANCE.battleLChar0, Main.INSTANCE.battleLChar1}, null,  18);
	
	public List<Enemy> enemies = new ArrayList<>();
	
	public List<Attack> attacks = new ArrayList<>();
	
	public List<Block> blocks = new ArrayList<>();
	
	public int frameCount = 0;
	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, 200, 200);
		
		g.setColor(Color.red);
		g.fillRect(5, 190 - (30 + 2*(Main.INSTANCE.save.level)), 10, 30 + 2*(Main.INSTANCE.save.level));//max health is 30 + 2*(Main.INSTANCE.save.level)
		g.setColor(Color.green);
		g.fillRect(5, 190 - Main.INSTANCE.save.health, 10, Main.INSTANCE.save.health);//health
		g.setColor(Color.black);
		g.fillRect(15, 190 - 3*Main.INSTANCE.save.level, 10, 3*Main.INSTANCE.save.level);//exp needed 
		g.setColor(new Color(0, 255, 255));
		g.fillRect(15, 190 - Main.INSTANCE.save.exp/10*3, 10, Main.INSTANCE.save.exp/10*3);
		if(30 + 2*(Main.INSTANCE.save.level) < 90) {//Needs to be changed to fit type
			//Main.INSTANCE.save.exp += 1;
			if(Main.INSTANCE.save.exp >= 10 * Main.INSTANCE.save.level) {
				Main.INSTANCE.save.exp -= Main.INSTANCE.save.level*10;
				Main.INSTANCE.save.level ++;
				Main.INSTANCE.save.health += 2;
			}
		}
		g.drawString(Main.INSTANCE.save.exp+"", 1, 30);
		g.drawString(Main.INSTANCE.save.level+"", 1, 60);
		g.drawString(Main.INSTANCE.save.health+"/ "+ (30 + 2*(Main.INSTANCE.save.level)), 1, 90);
		
		if(!(Main.INSTANCE.keys[39] || Main.INSTANCE.keys[37])) {
			player.reset();
		}
		player.draw(g);
		
		if(Main.INSTANCE.keys[39]) {
			player.move(0);
		} else {
			if(Main.INSTANCE.keys[37]) {
				player.move(2);
			}
		}
		
		//gravity
		gravity();
		collideBlock(g);
		blocks.addAll(Arrays.asList(
			new Block(50, 190, 10, 10),
			new Block(60, 190, 10, 10),
			new Block(65, 180, 3, 10)
		));
	}
	
	private void gravity() {
		if(momentum > -3 && player.y < 190) {
			frameCount ++;
			if(frameCount % 24 % 4 == 0) {
				momentum -= 1;
			}
		}
		if(!Main.INSTANCE.keys[90] && jump > 0) {
			jump = 0;
		}
		if(Main.INSTANCE.keys[90] && jump > 0) {
			momentum = 2;
			jump --;
			player.y --;
		}
		if(player.y == 190) {
			jump = 5;
			frameCount = 0;
		}
		if(player.y < 190) {
			player.y -= momentum;
		} else {
			player.y = 190;
			momentum = 0;
		}
		if(player.y > 190) {
			player.y = 190;
		}
	}
	
	private void collideBlock(Graphics g) {
		for(int i = 0;i < blocks.size();i ++) {
			blocks.get(i).draw(g);
			if(Collide.collide(new Rectangle(player.x, player.y, 5, 10), blocks.get(i).hitbox)) {
				if(player.x >= blocks.get(i).hitbox.x + blocks.get(i).hitbox.width - 1) {
					player.x ++;
				}
				if(player.x + 5 <= blocks.get(i).hitbox.x + 1) {
					player.x --;
				}
				if(player.y + 10 <= blocks.get(i).hitbox.y + 3) {
					player.y --;
					momentum = 0;
					jump = 5;
					frameCount = 0;
				}
			}
		}
	}
	
	public void capHealth() {
		Main.INSTANCE.save.health = Math.min(30 + 2*(Main.INSTANCE.save.level), Main.INSTANCE.save.health);
	}
}
