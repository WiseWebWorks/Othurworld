package world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import First.GameSequence;
import First.Main;
import First.Speak;
import inventory.Item;

public class Event {
	/**
	 * The rectangle of the event collision.
	 */
	Rectangle rect;
	
	/**
	 * If the event stops you from moving or not.
	 */
	boolean collide;
	
	/**
	 * True if you have to press z to activate the event.
	 */
	boolean activate;
	
	/**
	 * What event activates when you touch the event.
	 */
	int eventNum;
	
	/**
	 * Where touching the event will take you.
	 */
	String path;
	
	/**
	 * What x will become from a teleport
	 */
	int xPath;
	
	/**
	 * What y will become from a teleport
	 */
	int yPath;
	
	/**
	 * What an event says
	 */
	String[] talk;
	
	/**
	 * Where a talking event takes you
	 */
	int type;
	
	/**
	 * Getting an item from an event
	 */
	Item item;
	
	Color textColor;
	
	Color backgroundColor;
	
	Color borderColor;

	private boolean music;
	
	/**
	 * Normal collide event
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param collide true for walls
	 * @param eventNum 0 for walls
	 */
	Event(int x, int y, int width, int height, boolean collide, int eventNum) {//normal collide event
		this.rect = new Rectangle(x, y, width, height);
		this.collide = collide;
		this.activate = false;
		this.eventNum = eventNum;
		this.type = 0;
		this.path = null;
		this.xPath = 0;
		this.yPath = 0;
		this.item = null;
		this.music = false;
	}
	/**
	 * Event that makes you talk to something
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param activate true if you must press z
	 * @param talk
	 */
	Event(int x, int y, int width, int height, boolean activate, String[] talk) {//
		this.rect = new Rectangle(x, y, width, height);
		this.collide = false;
		this.activate = activate;
		this.eventNum = 2;
		this.type = 0;
		this.path = null;
		this.xPath = 0;
		this.yPath = 0;
		this.talk = talk;
		this.textColor = Color.black;
		this.backgroundColor = new Color(150, 150, 150);
		this.borderColor = Color.black;
		this.item = null;
		this.music = false;
	}
	/**
	 * Event that talks and then fires another event
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param activate
	 * @param talk
	 * @param type
	 */
	Event(int x, int y, int width, int height, boolean activate, String[] talk, int type) {//
		this.rect = new Rectangle(x, y, width, height);
		this.collide = false;
		this.activate = activate;
		this.eventNum = 2;
		this.type = type;
		this.path = null;
		this.xPath = 0;
		this.yPath = 0;
		this.talk = talk;
		this.textColor = Color.black;
		this.backgroundColor = new Color(150, 150, 150);
		this.borderColor = Color.black;
		this.item = null;
		this.music = false;
	}
	
	/**
	 * Event that talks and then gives you an item
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param activate
	 * @param talk
	 * @param type
	 */
	Event(int x, int y, int width, int height, boolean activate, String[] talk, Item item) {//
		this.rect = new Rectangle(x, y, width, height);
		this.collide = false;
		this.activate = activate;
		this.eventNum = 2;
		this.type = 6;
		this.path = null;
		this.xPath = 0;
		this.yPath = 0;
		this.talk = talk;
		this.textColor = Color.black;
		this.backgroundColor = new Color(150, 150, 150);
		this.borderColor = Color.black;
		this.item = item;
		this.music = false;
	}
	
	/**
	 * Event that makes you talk to something with specific colors
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param activate true if you must press z
	 * @param talk
	 */
	Event(int x, int y, int width, int height, boolean activate, String[] talk, Color text, Color background, Color border) {//
		this.rect = new Rectangle(x, y, width, height);
		this.collide = false;
		this.activate = activate;
		this.eventNum = 2;
		this.type = 0;
		this.path = null;
		this.xPath = 0;
		this.yPath = 0;
		this.talk = talk;
		this.textColor = text;
		this.backgroundColor = background;
		this.borderColor = border;
		this.item = null;
		this.music = false;
	}
	/**
	 * Event that talks and then fires another event with specific colors
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param activate
	 * @param talk
	 * @param type
	 */
	Event(int x, int y, int width, int height, boolean activate, String[] talk, int type, Color text, Color background, Color border) {//
		this.rect = new Rectangle(x, y, width, height);
		this.collide = false;
		this.activate = activate;
		this.eventNum = 2;
		this.type = type;
		this.path = null;
		this.xPath = 0;
		this.yPath = 0;
		this.talk = talk;
		this.textColor = text;
		this.backgroundColor = background;
		this.borderColor = border;
		this.item = null;
		this.music = false;
	}
	
	/**
	 * Teleport event
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param collide
	 * @param path
	 * @param xPath
	 * @param yPath
	 */
	Event(int x, int y, int width, int height, boolean collide, String path, int xPath, int yPath) {//teleport event
		this.rect = new Rectangle(x, y, width, height);
		this.collide = collide;
		this.activate = false;
		this.eventNum = 1;
		this.type = 0;
		this.path = path;
		this.xPath = xPath;
		this.yPath = yPath;
		this.item = null;
		this.music = false;
	}
	
	/**
	 * Teleport event with a music change
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param collide
	 * @param path
	 * @param xPath
	 * @param yPath
	 */
	Event(int x, int y, int width, int height, boolean collide, String path, int xPath, int yPath, boolean music) {//teleport event
		this.rect = new Rectangle(x, y, width, height);
		this.collide = collide;
		this.activate = false;
		this.eventNum = 1;
		this.type = 0;
		this.path = path;
		this.xPath = xPath;
		this.yPath = yPath;
		this.item = null;
		this.music = music;
	}
	
	/**
	 * Activate event only when touching and pressing z if activate is true
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param collide
	 * @param activate
	 * @param eventNum
	 */
	Event(int x, int y, int width, int height, boolean collide, boolean activate, int eventNum) {//activate event only when touching and pressing z if activate is true
		this.rect = new Rectangle(x, y, width, height);
		this.collide = collide;
		this.activate = activate;
		this.eventNum = eventNum;
		this.type = 0;
		this.path = null;
		this.xPath = 0;
		this.yPath = 0;
		this.item = null;
		this.music = false;
	}
	/**
	 * Teleport when pressing z if activate is true
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param collide
	 * @param activate
	 * @param path
	 * @param xPath
	 * @param yPath
	 */
	Event(int x, int y, int width, int height, boolean collide, boolean activate, String path, int xPath, int yPath) {//teleport when pressing z if activate is true
		this.rect = new Rectangle(x, y, width, height);
		this.collide = collide;
		this.activate = activate;
		this.eventNum = 1;
		this.path = path;
		this.xPath = xPath;
		this.yPath = yPath;
		this.item = null;
		this.music = false;
	}
	void run() {//sets this.event to the entire world's event (Also runs shortcut events like teleporting)
		event = this.eventNum;
		eventWait = 16;
		if(event == 2) {
			//Say this.talk[]
			//Speak.speak(g, this.talk);
			Speak.setTextColor(this.textColor, this.backgroundColor, this.borderColor);
			Main.INSTANCE.frameSpeak = true;
			Main.INSTANCE.frameSpeakString = this.talk;
			event = this.type;
		}
		if(event == 1) {
			Main.INSTANCE.save.area = this.path;//Makes you go to the path
			Main.INSTANCE.save.x = this.xPath;
			Main.INSTANCE.save.y = this.yPath;
			Main.INSTANCE.updateNow = true;
			Main.INSTANCE.areaName = 70;
			Main.INSTANCE.initMusic = this.music;
		}
		if(event == 4) {
			Main.INSTANCE.gardaAN.x = 201;
			Main.INSTANCE.gardaAN.y = 20;
			Main.INSTANCE.gardbAN.x = 171;
			Main.INSTANCE.gardbAN.y = 20;
			progVent = 0;
		}
		if(event == 6) {//Getting an item
			if(Speak.endCount > 16) {
				Main.INSTANCE.save.inv.addItem(this.item);
			}
		}
	}
	
	/**
	 * Variables for events
	 */
	public static int[] progVents;
	
	/**
	 * Event transitioning from one thing to another
	 */
	public static int progVent = 0;
	
	/**
	 * The event running right now
	 */
	public static int event = 0;
	
	/**
	 * Makes the game wait to play an event until after talking has started
	 */
	public static int eventWait;
	
	/**
	 * Events that draw things
	 * @param g
	 */
	public static void drawEvent(Graphics g) {
		
	}
	
	/**
	 * Runs the current event
	 */
	public static void playEvent() {//runs events
		if(eventWait > 0) {
			eventWait --;
		} else {
			if(event == 1) {//going somewhere
				end();//resets the event to nothing after it is done
			}
			
			if(event == 2) {//talking
				end();
			}
			
			if(event == 3) {//making the plot continue by talking
				Main.INSTANCE.updateNow = true;
				Main.INSTANCE.save.sOEvents = Main.INSTANCE.save.sOEvents.getNext();
				end();
			}
			
			if(event == 4) {//gaurds walking down to the old man
				Main.INSTANCE.moving = false;
				Main.INSTANCE.runFrame = 0;
				if(progVent == 0 && Main.INSTANCE.frameSpeak) {
					progVents = null;
					progVent = 1;
				}
				if(progVent != 0 && !Main.INSTANCE.frameSpeak/* && Main.INSTANCE.save.area.equals("Ortni Town")*/) {
					if(progVent == 1) {
						if(Main.INSTANCE.save.x <= 185 && Main.INSTANCE.save.x > 158) {
							Main.INSTANCE.save.x -= 2;
						} else {
							if(Main.INSTANCE.save.x > 185 && Main.INSTANCE.save.x < 223) {
								Main.INSTANCE.save.x += 2;
							} else {
								progVent = 2;
							}
						}
					}
					if(progVent == 2) {
						Main.INSTANCE.lastRun = 3;
						Main.INSTANCE.gardaAN.move(3);
						Main.INSTANCE.gardbAN.move(3);
						if(Main.INSTANCE.gardaAN.x < 230 && Main.INSTANCE.gardaAN.y > 100) {
							Main.INSTANCE.gardaAN.x ++;
							Main.INSTANCE.gardbAN.x ++;
						}
					}
					if(Main.INSTANCE.gardaAN.y > 200) {
						Main.INSTANCE.updateNow = true;
						Main.INSTANCE.save.sOEvents = GameSequence.GoToCave;
						Main.INSTANCE.moving = true;
						end();
					}
				}
			}
			
			if(event == 5) {//Talking to Eeggman in the Cave
				if(Main.INSTANCE.frameSpeak != true && Main.INSTANCE.save.area.equals("Mysterious Cave")) {
					Main.INSTANCE.save.sOEvents = GameSequence.End;
					Main.INSTANCE.save.area = "Forest Path";
					Main.INSTANCE.save.x = 230;
					Main.INSTANCE.save.y = 400;
					Main.INSTANCE.save.writeObject();
					Main.INSTANCE.stop();
					end();
				}
			}
			
			if(event == 6) {//Getting an item
				end();
			}
		}
	}
	
	
	/**
	 * End the event
	 */
	private static void end() {
		progVent = 0;
		progVents = null;
		event = 0;
	}
}
