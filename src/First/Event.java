package First;

import java.awt.Rectangle;

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
		this.path = null;
		this.xPath = 0;
		this.yPath = 0;
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
		this.path = path;
		this.xPath = xPath;
		this.yPath = yPath;
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
		this.path = null;
		this.xPath = 0;
		this.yPath = 0;
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
	}
	void run() {//sets this.event to the entire world's event (Also runs shortcut events like teleporting)
		event = this.eventNum;
		if(event == 1) {
			Main.INSTANCE.save.area = this.path;//Makes you go to the path
			Main.INSTANCE.save.x = this.xPath;
			Main.INSTANCE.save.y = this.yPath;
			Main.INSTANCE.updateNow = true;
		}
		if(event == 2) {
			//Say this.talk[]
			//Speak.speak(g, this.talk);
			Main.INSTANCE.frameSpeak = true;
			Main.INSTANCE.frameSpeakString = this.talk;
			event = this.type;
		}
		if(event == 3) {
			Main.INSTANCE.updateNow = true;
			Main.INSTANCE.save.sOEvents = Main.INSTANCE.save.sOEvents.getNext();
		}
		
		/*if(this.eventNum == 2) {
			event = this.type;
		}
		if(event == 3) {
			Main.INSTANCE.updateNow = true;
			Main.INSTANCE.save.sOEvents = Main.INSTANCE.save.sOEvents.getNext();
		}*/
	}
	
	static int event = 0;
	
	static void playEvent() {//runs events
		if(event == 1) {//going somewhere
			event = 0;//resets the event to nothing after it is done
		}
		
		if(event == 2) {//talking
			event = 0;
		}
		if(event == 3) {//making the plot continue by talking
			event = 0;
		}
	}
}
