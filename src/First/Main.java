package First;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Main extends Applet implements Runnable, KeyListener {
	public static final long serialVersionUID = 1L;
	public static final Dimension SCREEN_SIZE = new Dimension(800, 800);//the screen size
	public static final Dimension GAME_SIZE = new Dimension(200, 200);//the amount of pixels
	static final Font serif = new Font("serif", Font.PLAIN, 20);//font serif
	static final Font small = new Font("serif", Font.PLAIN, 15);
	static final Font tiny = new Font("serif", Font.PLAIN, 10);
	static final Font secret = new Font("serif", Font.PLAIN, 5);

	public JFrame frame;//the frame for setting everything up
	
	boolean isRunning = true;//if the program is running or not
	
	boolean updateNow = true;
	
	boolean[] keys = new boolean[100];//used to sense key inputs
	
	Image screen;//the screen image that makes the pixels larger
	
	public boolean frameSpeak = false;
	public String[] frameSpeakString = new String[]{};
	
	int menu = 0;//used to control where you are in the menu
	int intro = 0;//frameCount for how long the intro is
	int select = 1;//What you are choosing in the main menu
	
	public SaveFile save = new SaveFile("save.savo");//The main save file
	public boolean moving = true;
	
	int exitCount = 0;//makes it wait to exit
	
	public int[] run = {0,0,0,0};//how long you are holding each down
	public int runFrame = 0;//which frame of running you are in
	public int lastRun = 3;//the last direction you have faced
	
	//images
	public static final Sprite ortni = new Sprite("ortni.png");//places
	public static final Sprite ortni1 = new Sprite("ortni1.png");
	public static final Sprite ortni2 = new Sprite("ortni2.png");
	public static final Sprite ortni3 = new Sprite("ortni3.png");
	public static final Sprite ortnipath = new Sprite("ortnipath.png");
	public static final Sprite incave = new Sprite("cave.png");
	//spritessss
	public Sprite dchar0 = new Sprite("dchar0.png");
	public Sprite dchar1 = new Sprite("dchar1.png");
	public Sprite dchar2 = new Sprite("dchar2.png");
	public Sprite dchar3 = new Sprite("dchar3.png");
	public Sprite lchar0 = new Sprite("lchar0.png");
	public Sprite lchar1 = new Sprite("lchar1.png");
	public Sprite lchar2 = new Sprite("lchar2.png");
	public Sprite lchar3 = new Sprite("lchar3.png");
	public Sprite rchar0 = new Sprite("rchar0.png");
	public Sprite rchar1 = new Sprite("rchar1.png");
	public Sprite rchar2 = new Sprite("rchar2.png");
	public Sprite rchar3 = new Sprite("rchar3.png");
	public Sprite uchar0 = new Sprite("uchar0.png");
	public Sprite uchar1 = new Sprite("uchar1.png");
	public Sprite uchar2 = new Sprite("uchar2.png");
	public Sprite uchar3 = new Sprite("uchar3.png");
	public Sprite larry0 = new Sprite("TOK_0.png");
	public Sprite larry1 = new Sprite("TOK_1.png");
	public Sprite larry2 = new Sprite("TOK_2.png");
	public Sprite brokenbone = new Sprite("brokenbone.png");
	public Sprite bunnygoathead = new Sprite("bunnygoathead.png");
	public Sprite childhorsetoy = new Sprite("childhorsetoy.png");
	public Sprite wouldshroom = new Sprite("wouldshroom.png");
	public Sprite eegg = new Sprite("eegg.png");
	public Sprite oldguy = new Sprite("oldguy.png");
	public Sprite orb_0 = new Sprite("orb_0.png");
	public Sprite orb_1 = new Sprite("orb_1.png");
	public Sprite orb_2 = new Sprite("orb_2.png");
	public Sprite orb_3 = new Sprite("orb_3.png");
	public Sprite orb_4 = new Sprite("orb_4.png");
	public Sprite tu_0 = new Sprite("tu_0.png");
	public Sprite tu_1 = new Sprite("tu_1.png");
	public Sprite tu_2 = new Sprite("tu_2.png");
	public Sprite tu_3 = new Sprite("tu_3.png");
	public Sprite tu_4 = new Sprite("tu_4.png");
	public Sprite tu_5 = new Sprite("tu_5.png");
	public Sprite tu_6 = new Sprite("tu_6.png");
	public Sprite tu_7 = new Sprite("tu_7.png");
	public Sprite tu_stand_0 = new Sprite("tu_stand_0.png");
	public Sprite tu_stand_1 = new Sprite("tu_stand_1.png");
	public Sprite tu_stand_2 = new Sprite("tu_stand_2.png");
	public Sprite tu_stand_3 = new Sprite("tu_stand_3.png");
	public Sprite turtleman = new Sprite("turtleman.png");
	public Sprite turtlestack = new Sprite("turtlestack.png");
	public Sprite garda = new Sprite("gaurd_1.png");
	public Sprite gardb = new Sprite("gaurd_2.png");
	public Sprite cat = new Sprite("cat.png");
	
	//images
	
	public Sprite world = ortni;//world sprite; Where you walk

	public void centerString(Graphics g, String text, Rectangle rect, Font font) {
	    
	    FontMetrics metrics = g.getFontMetrics(font);
	    
	    int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
	    
	    int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
	    
	    g.setFont(font);
	    
	    g.drawString(text, x, y);
	}
	public GameSequence sOEvents = GameSequence.Start;
	
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
		
		save.readObject();//load save file
		
		//loading the images
		ortni.loadFile();//places
		ortni1.loadFile();
		ortni2.loadFile();
		ortni3.loadFile();
		ortnipath.loadFile();
		incave.loadFile();
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
		brokenbone.loadFile();
		bunnygoathead.loadFile();
		childhorsetoy.loadFile();
		wouldshroom.loadFile();
		eegg.loadFile();
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
		garda.loadFile();
		gardb.loadFile();
		cat.loadFile();
		//loading the images

		frame.setSize(SCREEN_SIZE);
		frame.setTitle("Othurworld");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
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
		init();
		new Thread(this).start();
	}
	
	public void init() {
		screen = createVolatileImage(GAME_SIZE.width, GAME_SIZE.height);
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
	
	public void paint(){//draw loop
		Graphics g = screen.getGraphics();
		//
		
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
			World.collide();
			if(updateNow) {
				World.update();
				updateNow = false;
			}
			Event.playEvent();
			g.translate(100 - save.x, 100 - save.y);
			world.draw(g, 0, 0);//draw the background
			World.draw(g);//debug
			if(world == ortni) {
			if(Main.INSTANCE.sOEvents == GameSequence.Start) {
			garda.draw(g, 200, 20);
			gardb.draw(g, 170, 20);
			}
			oldguy.draw(g, 81, 297);
			cat.draw(g, 32, 332);
			}
			if(world == ortni2) {
			turtlestack.draw(g, 28, 20);
			turtlestack.draw(g, 18, 23);
			turtlestack.draw(g, 22, 22);
			turtleman.draw(g, 85, 34);
			}
			drawPlayer(g);
			g.translate(save.x - 100, save.y - 100);
			if(moving == true) {
				movePlayer();
			}
			g.setColor(new Color(255, 255, 255));
			mainSpeak(g);
			Speak.waitSpeak();
			System.out.println(Speak.endCount);
		}
		
		if(menu == 4) {//name select
			g.setColor(new Color(255, 255, 255));
			g.setFont(serif);
			g.drawString("Name: " + save.name, 5, 90);
			g.setFont(small);
			if(save.name.length() >= 1 && !save.name.equals("Eeggman") && !save.name.equals("Dwindow")) {
				g.drawString("Press space to start", 50, 140);
				if(keys[32]) {
					save.writeObject();
					menu = 3;
				}
			}
		}
		
		if(exitCount != 0) {//shows the "Exiting game.." text
			g.setColor(new Color(255, 255, 255, exitCount * 3));
			g.setFont(small);
			g.drawString("Exiting game...", 5, 15);
			g.drawRect(5, 20, 85, 10);
			g.fillRect(6, 21, exitCount, 9);
		}
		if(keys[27]) {
			exitCount ++;
		} else {
			if( exitCount > 0) {
				exitCount --;
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
	public void play(){
		
	}
	
	public void run() {
		init();
		while(isRunning) {
			
			paint();
			play();
			try {
				Thread.sleep(16);
			}
			catch(InterruptedException ie) {
				
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
		if(menu == 4) {
			if(save.name.length() < 8) {
				if(keys[16]) {
					for(int i = 65;i <= 90;i ++) {
						if(keys[i]) {
							save.name += "ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(i - 65, i - 64);
						}
					}
				} else {
					for(int i = 65;i <= 90;i ++) {
						if(keys[i]) {
							save.name += "abcdefghijklmnopqrstuvwxyz".substring(i - 65, i - 64);
						}
					}
				}
			}
			if(save.name.length() > 0 && keys[8]) {
				save.name = save.name.substring(0, save.name.length()-1);
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
				if(select == 1 && save.name != "Eeggman") {
					menu = 3;//game
					save.readObject();
				}
				if(select == 2) {
					menu = 4;//new game
					save = new SaveFile("save.savo", "", "Ortni Town", 20, 1, 200, 200, 1, GameSequence.Start);
				}
			}
		}
		
		if(menu == 0) {
			if(keys[90]) {
				menu = 1;
			}
		}
		
		if(Speak.speaking) {
			if(Speak.check[0] && keys[90]) {
				moving = true;
				Speak.endSpeak();
				Event.event = 0;
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
	public void keyTyped(KeyEvent e) {
		
	}
	
	public void mainSpeak(Graphics g) {
		if(frameSpeak) {
			Speak.speak(g, frameSpeakString);
		}
		
		if(!Speak.speaking) {
			frameSpeak = false;
		}
	}
}
