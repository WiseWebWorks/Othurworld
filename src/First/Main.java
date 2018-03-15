package First;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import audio.AudioPlayer;
import audio.MusicBox;
import battle.Battle;
import game.Sprite;
import inventory.Collected;
import inventory.Inventory;
import inventory.Item;
import inventory.KeyItem;
import inventory.Weapon;
import saves.SaveFile;
import game.Animation;

import world.Event;
import world.World;

public class Main extends Applet implements Runnable, KeyListener {
	public static final long serialVersionUID = 1L;
	public static final Dimension SCREEN_SIZE = new Dimension(800, 800);//the screen size
	public static final Dimension GAME_SIZE = new Dimension(200, 200);//the amount of pixels
	
	public static final Font serif = new Font("serif", Font.PLAIN, 20);//font serif
	public static final Font small = new Font("serif", Font.PLAIN, 15);
	public static final Font average = new Font("serif", Font.PLAIN, 11);
	public static final Font tiny = new Font("serif", Font.PLAIN, 10);
	public static final Font secret = new Font("serif", Font.PLAIN, 5);
	
	
	AudioPlayer menum;//sd
	AudioPlayer eeggsong;
	AudioPlayer music;//The real music playing
	
	MusicBox song = new MusicBox();
	
	public boolean initMusic = true;
	
	
	public JFrame frame;//the frame for setting everything up
	
	boolean isRunning = true;//if the program is running or not
	
	public boolean updateNow = true;
	public int updateDelayNow = 0;
	
	public boolean[] keys = new boolean[200];//used to sense key inputs
	
	Image screen;//the screen image that makes the pixels larger
	
	public boolean frameSpeak = false;
	public String[] frameSpeakString = new String[]{};
	
	int menu = 0;//used to control where you are in the menu
	int intro = 0;//frameCount for how long the intro is
	int select = 1;//What you are choosing in the main menu
	
	public SaveFile save = new SaveFile("save.savo");//The main save file
	public SaveFile reset1 = new SaveFile("reset1.savo");
	public SaveFile reset2 = new SaveFile("reset2.savo");
	public SaveFile reset3 = new SaveFile("reset3.savo");
	
	public boolean inv = false;
	public int invSelect = 1;
	public int invType = 0;
	
	public boolean moving = true;
	
	int exitCount = 0;//makes it wait to exit
	
	public int[] run = {0,0,0,0};//how long you are holding each down
	public int runFrame = 0;//which frame of running you are in
	public int lastRun = 3;//the last direction you have faced
	
	private int translateX;//Moves the screen x to follow the player
	private int translateY;//Moves the screen y to follow the player
	
	public int areaName = 50;
	
	public static final Sprite iconImage = new Sprite("Othurworld.png");//The icon image
	
	//images
	public static final Sprite ortni = new Sprite("maps/ortni.png");//places
	public static final Sprite ortni1 = new Sprite("maps/ortni1.png");
	public static final Sprite ortni2 = new Sprite("maps/ortni2.png");
	public static final Sprite ortni3 = new Sprite("maps/ortni3.png");
	public static final Sprite ortnipath = new Sprite("maps/ortnipath.png");
	public static final Sprite incave = new Sprite("maps/cave.png");
	public static final Sprite forPath = new Sprite("maps/forestpath.png");
	//sprites
	public Sprite dchar0 = new Sprite("char/dchar0.png");
	public Sprite dchar1 = new Sprite("char/dchar1.png");
	public Sprite dchar2 = new Sprite("char/dchar2.png");
	public Sprite dchar3 = new Sprite("char/dchar3.png");
	public Sprite lchar0 = new Sprite("char/lchar0.png");
	public Sprite lchar1 = new Sprite("char/lchar1.png");
	public Sprite lchar2 = new Sprite("char/lchar2.png");
	public Sprite lchar3 = new Sprite("char/lchar3.png");
	public Sprite rchar0 = new Sprite("char/rchar0.png");
	public Sprite rchar1 = new Sprite("char/rchar1.png");
	public Sprite rchar2 = new Sprite("char/rchar2.png");
	public Sprite rchar3 = new Sprite("char/rchar3.png");
	public Sprite uchar0 = new Sprite("char/uchar0.png");
	public Sprite uchar1 = new Sprite("char/uchar1.png");
	public Sprite uchar2 = new Sprite("char/uchar2.png");
	public Sprite uchar3 = new Sprite("char/uchar3.png");
	
	public Sprite larry0 = new Sprite("overworld/TOK_0.png");
	public Sprite larry1 = new Sprite("overworld/TOK_1.png");
	public Sprite larry2 = new Sprite("overworld/TOK_2.png");
	
	public Sprite oldguy = new Sprite("overworld/oldguy.png");
	
	public Sprite turtleman = new Sprite("overworld/turtleman.png");
	
	public Sprite turtlestack = new Sprite("overworld/turtlestack.png");
	
	public Sprite gard0 = new Sprite("overworld/guard0.png");
	public Sprite gard1 = new Sprite("overworld/guard1.png");
	public Sprite gard2 = new Sprite("overworld/guard2.png");
	public Sprite gard3 = new Sprite("overworld/guard3.png");
	
	public Sprite gard4 = new Sprite("overworld/guard4.png");
	public Sprite gard5 = new Sprite("overworld/guard5.png");
	public Sprite gard6 = new Sprite("overworld/guard6.png");
	public Sprite gard7 = new Sprite("overworld/guard7.png");
	
	public Sprite stone = new Sprite("overworld/stone.png");
	
	public Sprite brokenSword = new Sprite("overworld/brokensword.png");
	
	public Sprite cat = new Sprite("overworld/cat.png");
	
	public Sprite oSign = new Sprite("overworld/Sign.png");
	
	public Sprite eeggsil = new Sprite("overworld/eeggsil.png");
	
	public Sprite carrot = new Sprite("overworld/carrot.png");
	//sprites
	
	//item sprites
	public Sprite carrotI = new Sprite("items/carrotI.png");
	public Sprite pancakeI = new Sprite("items/pancakes.png");
	public Sprite bpancakeI = new Sprite("items/burntpancakes.png");
	public Sprite energyplantI = new Sprite("items/energy.png");
	public Sprite eturtleI = new Sprite("items/evilturtle.png");
	public Sprite ghostplantI = new Sprite("items/ghost.png");
	public Sprite glitchI = new Sprite("items/glitch.png");
	public Sprite heartI = new Sprite("items/heart.png");
	public Sprite rockI = new Sprite("items/rock.png");
	public Sprite turtleI = new Sprite("items/turtle.png");
	
	public Sprite bboneI = new Sprite("items/brokenbone.png");//
	public Sprite bghI = new Sprite("items/bunnygoat.png");
	public Sprite chtI = new Sprite("items/childhorsetoy.png");
	public Sprite wsI = new Sprite("items/wouldshroom.png");
	public Sprite eeggI = new Sprite("items/eegg.png");//
	//item sprites
	
	//battle sprites
	public Sprite battleRChar0 = new Sprite("battle/char/battleRChar0.png");
	public Sprite battleRChar1 = new Sprite("battle/char/battleRChar1.png");
	public Sprite battleLChar0 = new Sprite("battle/char/battleLChar0.png");
	public Sprite battleLChar1 = new Sprite("battle/char/battleLChar1.png");
	
	public Sprite tu_0 = new Sprite("battle/enemies/tu/tu_0.png");
	public Sprite tu_1 = new Sprite("battle/enemies/tu/tu_1.png");
	public Sprite tu_2 = new Sprite("battle/enemies/tu/tu_2.png");
	public Sprite tu_3 = new Sprite("battle/enemies/tu/tu_3.png");
	public Sprite tu_4 = new Sprite("battle/enemies/tu/tu_4.png");
	public Sprite tu_5 = new Sprite("battle/enemies/tu/tu_5.png");
	public Sprite tu_6 = new Sprite("battle/enemies/tu/tu_6.png");
	public Sprite tu_7 = new Sprite("battle/enemies/tu/tu_7.png");
	public Sprite tu_stand_0 = new Sprite("battle/enemies/tu/tu_stand_0.png");
	public Sprite tu_stand_1 = new Sprite("battle/enemies/tu/tu_stand_1.png");
	public Sprite tu_stand_2 = new Sprite("battle/enemies/tu/tu_stand_2.png");
	public Sprite tu_stand_3 = new Sprite("battle/enemies/tu/tu_stand_3.png");
	
	public Sprite orb_0 = new Sprite("battle/attacks/orb_0.png");
	public Sprite orb_1 = new Sprite("battle/attacks/orb_1.png");
	public Sprite orb_2 = new Sprite("battle/attacks/orb_2.png");
	public Sprite orb_3 = new Sprite("battle/attacks/orb_3.png");
	public Sprite orb_4 = new Sprite("battle/attacks/orb_4.png");
	//battle sprites
	
	//Animations
	public Animation tuAN = new Animation(0, 0, 0, new Sprite[]{tu_4, tu_5}, new Sprite[]{tu_6, tu_7}, new Sprite[]{tu_2, tu_3}, new Sprite[]{tu_0, tu_1}, 18);
	public Animation gardaAN = new Animation(201, 20, 3, null, null, null, new Sprite[]{gard0, gard1, gard2, gard3}, 36);
	public Animation gardbAN = new Animation(171, 20, 3, null, null, null, new Sprite[]{gard4, gard5, gard6, gard7}, 36);
	//Animations
	
	public Sprite world = ortni;//world sprite; Where you walk
	
	public void centerString(Graphics g, String text, Rectangle rect, Font font) {
	    
	    FontMetrics metrics = g.getFontMetrics(font);
	    
	    int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
	    
	    int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
	    
	    g.setFont(font);
	    
	    g.drawString(text, x, y);
	}
	//public GameSequence sOEvents = GameSequence.Start;
	
	public static final Main INSTANCE = new Main();
	
	public static void main(String[] args){
		Main.INSTANCE.start();
	}
	
	public Main() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		setPreferredSize(SCREEN_SIZE);
		frame = new JFrame();
		
		//save.writeObject();//debug
		save.readObject();//load save file
		reset1.readObject();
		reset2.readObject();
		reset3.readObject();
		
		iconImage.loadFile();
		
		//loading the images
		ortni.loadFile();//places
		ortni1.loadFile();
		ortni2.loadFile();
		ortni3.loadFile();
		ortnipath.loadFile();
		incave.loadFile();
		forPath.loadFile();//Add this when we have the file ready
		//sprites
		dchar0.loadFile();
		dchar1.loadFile();
		dchar2.loadFile();
		dchar3.loadFile();
		lchar0.loadFile();
		lchar1.loadFile();
		lchar2.loadFile();
		lchar3.loadFile();
		rchar0.loadFile();
		rchar1.loadFile();
		rchar2.loadFile();
		rchar3.loadFile();
		uchar0.loadFile();
		uchar1.loadFile();
		uchar2.loadFile();
		uchar3.loadFile();
		larry0.loadFile();
		larry1.loadFile();
		larry2.loadFile();
		oldguy.loadFile();
		orb_0.loadFile();
		orb_1.loadFile();
		orb_2.loadFile();
		orb_3.loadFile();
		orb_4.loadFile();
		tu_0.loadFile();
		tu_1.loadFile();
		tu_2.loadFile();
		tu_3.loadFile();
		tu_4.loadFile();
		tu_5.loadFile();
		tu_6.loadFile();
		tu_7.loadFile();
		tu_stand_0.loadFile();
		tu_stand_1.loadFile();
		tu_stand_2.loadFile();
		tu_stand_3.loadFile();
		turtleman.loadFile();
		turtlestack.loadFile();
		gard0.loadFile();
		gard1.loadFile();
		gard2.loadFile();
		gard3.loadFile();
		gard4.loadFile();
		gard5.loadFile();
		gard6.loadFile();
		gard7.loadFile();
		cat.loadFile();
		oSign.loadFile();
		eeggsil.loadFile();
		carrot.loadFile();
		brokenSword.loadFile();
		stone.loadFile();
		
		//item sprites
		carrotI.loadFile();
		bboneI.loadFile();
		bghI.loadFile();
		chtI.loadFile();
		wsI.loadFile();
		eeggI.loadFile();
		pancakeI.loadFile();
		heartI.loadFile();
		turtleI.loadFile();
		eturtleI.loadFile();
		ghostplantI.loadFile();
		energyplantI.loadFile();
		glitchI.loadFile();
		bpancakeI.loadFile();
		
		//loading the images
		//battle sprites
		battleRChar0.loadFile();
		battleRChar1.loadFile();
		battleLChar0.loadFile();
		battleLChar1.loadFile();

		frame.setSize(SCREEN_SIZE);
		frame.setTitle("Othurworld");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setIconImage(iconImage.getImage());
	}
	
	public void paint(){//draw loop
		Graphics g = screen.getGraphics();
		//
		//if(keys[KeyEvent.VK_SLASH]) save.health--;;//debug
		
		g.setFont(serif);
		g.setColor(Color.black);
		g.fillRect(0,  0,  200, 200);//background
		
		if(menu == 0) {//intro
			playIntro(g);
		}
		
		if(menu == 1) {//select new game or continue
			drawMenu(g);
		}
		
		if(menu == 3) {//Overworld
			Event.playEvent();
			
			if(initMusic || (!song.music.isPlaying() && song.loop)) {
				song.playMusic();
				initMusic = false;
			}
			
			World.collide();
			//Event.playEvent();
			//System.out.println(frameSpeak);
			if(updateNow) {
				if(updateDelayNow > 0) {
					updateDelayNow --;
				} else {
					World.update();
					updateNow = false;
				}
			}
			if(world.getImage().getWidth(null) >= 200) {
				translateX = constrain(100 - save.x, -(world.getImage().getWidth(null)) + 200, 0);
			} else {
				translateX = 100 - save.x;
			}
			if(world.getImage().getHeight(null) >= 200) {
				translateY = constrain(100 - save.y, -(world.getImage().getHeight(null)) + 200, 0);
			} else {
				translateY = 100 - save.y;
			}
			g.translate(translateX, translateY);
			
			world.draw(g, 0, 0);//draw the background
			//World.draw(g);//debug
			drawBackground(g);
			
			Event.drawEvent(g);
			
			drawPlayer(g);
			
			drawForeground(g);
			
			g.translate(-translateX, -translateY);
			
			if(moving == true) {
				movePlayer();
			}
			g.setColor(new Color(255, 255, 255));
			mainSpeak(g);
			Speak.waitSpeak();
			
			drawAreaName(g);
			
			if(inv == true) {//If your inventory is up
				moving = false;
				g.setColor(new Color(150, 150, 150));
				g.fillRect(1, 1, 85, 100);
				g.setColor(new Color(0, 0, 0));
				g.drawRect(1, 1, 85, 100);
				g.drawRect(3, invSelect + 2, 81, 16);
				g.setFont(small);
				g.drawString("Inventory", 4, 15);
				g.drawString("Key Items", 4, 31);
				g.drawString("Stats", 4, 47);
				g.drawString("Profile", 4, 64);
				
				g.setFont(average);
				g.drawString(Main.INSTANCE.save.name, 4, 85);
				g.setFont(small);
				g.drawString(Main.INSTANCE.save.health + "/" + (30 + 2*(Main.INSTANCE.save.level)), 4, 100);
				
				if(invType != 0) {
					Inventory.drawInvBox(g);
				}
				
				if(invType == 1) {//inventory
					save.inv.drawItems(g);
				}
				
				if(invType == 2) {//key items
					save.inv.drawKeyItems(g);
				}
				
				if(invType == 3) {//stats
					save.inv.drawStats(g);
				}
				
				if(invType == 4) {//profile
					save.inv.drawProfile(g);
				}
			}
			//save.writeObject();//debug
		}
		
		if(menu == 4) {//name select
			g.setColor(new Color(255, 255, 255));
			g.setFont(serif);
			g.drawString("Name: " + save.name, 5, 90);
			g.setFont(small);
			if(save.name.equalsIgnoreCase("Name")) {
				dchar0.draw(g, 20, 120);
			}
			if(save.name.length() >= 1 && !save.name.equalsIgnoreCase("Eeggman") && !save.name.equalsIgnoreCase("Dwindow")) {
				g.drawString("Press enter to start", 50, 140);
				if(keys[KeyEvent.VK_ENTER]) {
					save.writeObject();
					reset1.writeObject();
					reset2.writeObject();
					reset3.writeObject();
					menu = 3;
					music.stop();
					music.close();
					eeggsong.close();
					menum.close();
				}
			} else if (save.name.length() >= 1 && save.name.equalsIgnoreCase("Eeggman") || save.name.length() >= 1 &&!save.name.equalsIgnoreCase("Dwindow")) {
				music = eeggsong;
				menum.stop();
				music.play();
			}
		}

		if(menu == 4 || menu == 1) {
			if(!music.isPlaying()) {
				music.rewind();
				music.play();
			}
		}
		
		//menu = 5;//debug
		if(menu == 5) {//Battle
			Battle.INSTANCE.draw(g);
		}
		
		/*tu.draw(g);
		tu.move(3);//Animation physics
		tu.move(0);*/
		
		if(exitCount != 0) {//shows the "Exiting game.." text
			g.setColor(new Color(255, 255, 255, exitCount * 3));
			g.setFont(small);
			g.drawString("Exiting game...", 5, 15);
			g.drawRect(5, 20, 85, 10);
			g.fillRect(6, 21, exitCount, 9);
		}
		if(keys[27]) {
			exitCount += 2;
		} else {
			if( exitCount > 0) {
				exitCount -= 2;
			}
		}
		if(exitCount > 85) {
			stop();
		}
		
		//
		g = getGraphics();
		g.drawImage(screen, 0, 0, SCREEN_SIZE.width+10, SCREEN_SIZE.height+10, 0, 0, GAME_SIZE.width, GAME_SIZE.height, null);
		
		g.dispose();
	}
	
	public void loadScreen() {
		Graphics g = screen.getGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, 200, 200);
		centerString(g, "Loading...", new Rectangle(0, 0, 200, 200), serif);
		
		g = getGraphics();
		g.drawImage(screen, 0, 0, SCREEN_SIZE.width+10, SCREEN_SIZE.height+10, 0, 0, GAME_SIZE.width, GAME_SIZE.height, null);
		
		g.dispose();
	}
	
	public void run() {
		init();
		while(isRunning) {
			paint();
			try {
				Thread.sleep(16);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.exit(0);
	}
	
	public void stop() {
		isRunning = false;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() < 100) {
			keys[e.getKeyCode()] = true;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(menu == 3) {
			if((keys[88] || keys[67]) && frameSpeak == false && Event.event == 0) {
				if(inv == false && !keys[88]) {
					inv = true;
					moving = false;
					invSelect = 1;
				} else {
					if(invType == 0) {
						inv = false;
						moving = true;
					}
				}
			}
			if(inv == true) {
				if(invType == 0) {
					if(keys[40] && invSelect < 40) {
						invSelect += 16;
					}
					if(keys[38] && invSelect > 15) {
						invSelect -= 16;
					}
					
					if(keys[90]) {
						if(invSelect == 1) {
							//inventory
							invType = 1;
							save.inv.select = 38;
						}
						if(invSelect == 17) {
							//key items
							invType = 2;
						}
						if(invSelect == 33) {
							//Stats
							invType = 3;
						}
						if(invSelect == 49) {
							//Profile
							invType = 4;
						}
					}
				}
				
				if(Speak.speaking == false) {
					if(invType == 1) {
						if(keys[88] && Speak.endCount > 16) {
							invType = 0;
						}
						
						if(keys[40] && save.inv.select < 110) {
							save.inv.select += 20;
						}
						if(keys[38] && save.inv.select > 50) {
							save.inv.select -= 20;
						}
					}
					
					if(invType == 2) {
						if(keys[88] && Speak.endCount > 16) {
							invType = 0;
						}
					}
					
					if(invType == 3) {
						if(keys[88] && Speak.endCount > 16) {
							invType = 0;
						}
					}
					
					if(invType == 4) {
						if(keys[88] && Speak.endCount > 16) {
							invType = 0;
						}
					}
				}
			}
			
		}
		
		if(menu == 4) {
			if(save.name.length() > 0 && keys[8]) {
				save.name = save.name.substring(0, save.name.length() - 1);
			}
			if(e.getKeyCode() >= 65 && e.getKeyCode() <= 90 && save.name.length() < 8) {
				if(!keys[16]) {
					save.name = save.name + "abcdefghijklmnopqrstuvwxyz".substring(e.getKeyCode()-65, e.getKeyCode()-64);
				} else {
					save.name = save.name + "ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(e.getKeyCode()-65, e.getKeyCode()-64);
				}
			}
		}
		
		if(menu == 1) {
			if(keys[37] || keys[39]) {
				if(select == 1) {
					select = 2;
				} else {
					select = 1;
				}
			}
			if(keys[90]) {
				if(select == 1 && !save.name.equals("Eeggman")) {
					menu = 3;//game
					menum.stop();
					menum.close();
					save.readObject();
				}
				if(select == 2) {
					menu = 4;//new game
					reset3 = reset2;
					reset2 = reset1;
					reset1 = save;
					save = new SaveFile("save.savo", "", "Ortni Town", 32, 0, 1, 200, 200, 1, new Inventory(new Item[5], new KeyItem(), Weapon.ChippedKnife), new Collected(), GameSequence.Start);
					/*reset3.writeObject();
					reset2.writeObject();
					reset1.writeObject();
					save.writeObject();*/
				}
			}
		}
		
		if(menu == 0) {
			if(keys[90] && intro > 2) {
				menu = 1;
				music.play();
			}
		}
		
		if(Speak.speaking) {
			if(Speak.check[0] && keys[90]) {
				moving = true;
				Speak.endSpeak();
				frameSpeak = false;
				//Event.event = 0;
			}
			
			if(Speak.check[1] && keys[90]) {
				Speak.nextFrame();
			}
		}
		
		if(e.getKeyCode() < 100) {
			keys[e.getKeyCode()] = false;
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	
	public void mainSpeak(Graphics g) {
		if(frameSpeak) {
			Speak.speak(g, frameSpeakString);
		}
		
		if(!Speak.speaking) {
			frameSpeak = false;
		}
	}
	
	public void drawBackground(Graphics g) {
		if(world == ortni) {
			if(save.sOEvents == GameSequence.Start) {
				gardaAN.draw(g);
				gardbAN.draw(g);
			}
			if(save.sOEvents == GameSequence.OldDudeDies) {
				gardaAN.draw(g);
				gardbAN.draw(g);
			}
			if(save.sOEvents != GameSequence.GoToCave) {
				oldguy.draw(g, 81, 297);
			}
			if(save.y > 334) {
				cat.draw(g, 32, 332);
			}
			if(!save.collect.Carrot) {
				carrot.draw(g, 39, 217);
			}
		}
		if(world == ortni2) {
			turtlestack.draw(g, 28, 20);
			turtlestack.draw(g, 18, 23);
			turtlestack.draw(g, 22, 22);
			turtleman.draw(g, 85, 34);
		}
		if(world == ortnipath) {
			if(save.y > 425) {
				oSign.draw(g, 37, 424);
			}
		}
		if(world == incave) {
			eeggsil.draw(g, 85, 25);
		}
		if(world == forPath) {
			brokenSword.drawBackground(g, 227,66);
			stone.drawBackground(g, 208, 78);
		}
	}
	
	public void drawForeground(Graphics g) {
		if(world == ortni) {
			if(save.y < 335) {
				cat.draw(g, 32, 332);
			}
		}
		if(world == ortnipath) {
			if(save.y <= 425) {
				oSign.draw(g, 37, 424);
			}
		}
		if(world == forPath) {
			brokenSword.drawForeground(g, 227,66);
			stone.drawForeground(g, 208, 78);
		}
	}
	
	public void playIntro(Graphics g) {
		if(intro < 300){
			intro ++;
			g.setColor(new Color(255,255,255,Math.min(305-intro,255)));
			centerString(g, "There is a story in an old", new Rectangle(0,60,200,40), serif);
			centerString(g, "children's book.", new Rectangle(0,90,200,40), serif);
		}
		if(intro >= 300 && intro < 400){
			intro ++;
		}
		if(intro >= 400 && intro <= 700){
			intro ++;
			g.setColor(new Color(255,255,255,Math.min(705-intro,255)));
			centerString(g, "It speaks of a world of", new Rectangle(0,40,200,40), serif);
			centerString(g, "\"othurs\" and a world of", new Rectangle(0,70,200,40), serif);
			centerString(g, "humans...", new Rectangle(0,100,200,40), serif);
		}
		if(intro >= 700 && intro < 800){
			intro ++;
		}
		if(intro >= 800 && intro < 1100){
			intro ++;
			g.setColor(new Color(255,255,255,Math.min(1105-intro,255)));
			centerString(g, "But the humans did not", new Rectangle(0,40,200,40), serif);
			centerString(g, "know of the othurs'", new Rectangle(0,70,200,40), serif);
			centerString(g, "existance...", new Rectangle(0,100,200,40), serif);
		}
		if(intro >= 1100 && intro < 1200){
			intro ++;
		}
		if(intro >= 1200 && intro < 1500){
			intro ++;
			g.setColor(new Color(255,255,255,Math.min(1505-intro,255)));
			centerString(g, "In this story, a young", new Rectangle(0,30,200,40), serif);
			centerString(g, "boy lived in a small", new Rectangle(0,60,200,40), serif);
			centerString(g, "village next to a", new Rectangle(0,90,200,40), serif);
			centerString(g, "mysterious cave.", new Rectangle(0,120,200,40), serif);
		}
		if(intro >= 1500 && intro < 1700){
			intro ++;
		}
		if(intro >= 1700 && intro < 2100){
			intro ++;
			g.setColor(new Color(255,255,255,Math.max(Math.min(2005-intro,255),0)));
			centerString(g, "No one had", new Rectangle(0, 40, 200, 40), serif);
			centerString(g, "ever come out of", new Rectangle(0, 70, 200, 40), serif);
			centerString(g, "the cave alive...", new Rectangle(0, 100, 200, 40), serif);
		}
		if(intro == 2100){
			g.setColor(new Color(255,255,255));
			centerString(g, "Othurworld", new Rectangle(0, 70, 200, 40), serif);
			centerString(g, "Press z", new Rectangle(0, 90, 200, 40), small);
		}
	}
	
	public void drawMenu(Graphics g) {
		g.setFont(serif);
		g.setColor(new Color(255,255,255));
		centerString(g, "Othurworld", new Rectangle(0, 40, 200, 1), serif);
		centerString(g, "Copyright Justin and Benjamin Wise 2017", new Rectangle(0, 190, 200, 1), tiny);
		if(save.name.equals("Eeggman")) {
			centerString(g, "Arrows to move and z to select", new Rectangle(0, 150, 200, 1), small);
		}
		if(select == 1) {
			g.setColor(new Color(0, 255, 255));
		}
		centerString(g, "Continue", new Rectangle(0, 100, 100, 1), small);
		g.setColor(new Color(255,255,255));
		if(select == 2) {
			g.setColor(new Color(0, 255, 255));
		}
		centerString(g, "New Game", new Rectangle(100, 100, 100, 1), small);
	}
	
	public void start() {
		//init();
		new Thread(this).start();
	}
	
	public void init() {
		screen = createVolatileImage(GAME_SIZE.width, GAME_SIZE.height);
		
		loadScreen();
		
		menum = new AudioPlayer("Menu.mp3");
		eeggsong = new AudioPlayer("Eegg.mp3");
		music = menum;
	}
	
	public void movePlayer() {
		if(keys[40]) {
			save.y ++;
			run[3] ++;
			run[1] = 0;
		} else {
			if(keys[38]) {
				save.y --;
				run[1] ++;
				run[3] = 0;
			}
		}
		if(keys[39]) {
			save.x ++;
			run[0] ++;
			run[2] = 0;
		} else {
			if(keys[37]) {
				save.x --;
				run[2] ++;
				run[0] = 0;
			}
		}
		if(keys[40] || keys[39] || keys[38] || keys[37]) {
			runFrame ++;
		}
		if(!keys[40]) {
			run[3] = 0;
		}
		if(!keys[39]) {
			run[0] = 0;
		}
		if(!keys[38]) {
			run[1] = 0;
		}
		if(!keys[37]) {
			run[2] = 0;
		}
		if(!keys[37] && !keys[38] && !keys[39] && !keys[40]) {
			runFrame = 0;
		}
	}
	
	public void drawPlayer(Graphics g) {
		if(!(Math.max(run[3], Math.max(run[2], Math.max(run[1], run[0]))) == 0)) {
			if(Math.max(run[3], Math.max(run[2], Math.max(run[1], run[0]))) == run[3]) {
				if(runFrame % 32 < 8) {
					dchar0.draw(g, save.x, save.y);
				}
				if(runFrame % 32 >= 8 & runFrame % 32 < 16) {
					dchar1.draw(g, save.x, save.y);
				}
				if(runFrame % 32 >= 16 & runFrame % 32 < 24) {
					dchar2.draw(g, save.x, save.y);
				}
				if(runFrame % 32 >= 24) {
					dchar3.draw(g, save.x, save.y);
				}
				lastRun = 3;
			} else {
				if(Math.max(run[3], Math.max(run[2], Math.max(run[1], run[0]))) == run[1]) {
					if(runFrame % 32 < 8) {
						uchar0.draw(g, save.x, save.y);
					}
					if(runFrame % 32 >= 8 & runFrame % 32 < 16) {
						uchar1.draw(g, save.x, save.y);
					}
					if(runFrame % 32 >= 16 & runFrame % 32 < 24) {
						uchar2.draw(g, save.x, save.y);
					}
					if(runFrame % 32 >= 24) {
						uchar3.draw(g, save.x, save.y);
					}
					lastRun = 1;
				} else {
					if(Math.max(run[3], Math.max(run[2], Math.max(run[1], run[0]))) == run[0]) {
						if(runFrame % 32 < 8) {
							rchar0.draw(g, save.x, save.y);
						}
						if(runFrame % 32 >= 8 & runFrame % 32 < 16) {
							rchar1.draw(g, save.x, save.y);
						}
						if(runFrame % 32 >= 16 & runFrame % 32 < 24) {
							rchar2.draw(g, save.x, save.y);
						}
						if(runFrame % 32 >= 24) {
							rchar3.draw(g, save.x, save.y);
						}
						lastRun = 0;
					}else {
						if(Math.max(run[3], Math.max(run[2], Math.max(run[1], run[0]))) == run[2]) {
							if(runFrame % 32 < 8) {
								lchar0.draw(g, save.x, save.y);
							}
							if(runFrame % 32 >= 8 & runFrame % 32 < 16) {
								lchar1.draw(g, save.x, save.y);
							}
							if(runFrame % 32 >= 16 & runFrame % 32 < 24) {
								lchar2.draw(g, save.x, save.y);
							}
							if(runFrame % 32 >= 24) {
								lchar3.draw(g, save.x, save.y);
							}
							lastRun = 2;
						}
					}
				}
			}
		}else {
			if(lastRun == 0) {
				rchar0.draw(g, save.x, save.y);
			}
			if(lastRun == 1) {
				uchar0.draw(g, save.x, save.y);
			}
			if(lastRun == 2) {
				lchar0.draw(g, save.x, save.y);
			}
			if(lastRun == 3) {
				dchar0.draw(g, save.x, save.y);
			}
		}
	}
	
	public int constrain(int num, int low, int high) {
		return Math.min(high, Math.max(num, low));
	}
	
	private void drawAreaName(Graphics g) {
		if(areaName > -50) {
			g.setColor(new Color(150, 150, 150));
			g.fillRect(50, Math.min(areaName, 0), 100, 30);
			g.setColor(Color.black);
			g.drawRect(50, Math.min(areaName, 0), 100, 30);
			g.setColor(Color.black);
			centerString(g, save.area, new Rectangle(50, Math.min(areaName, 0), 100, 29), small);
			areaName --;
		}
	}
}