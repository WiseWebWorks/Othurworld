package First;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SaveFile implements Serializable {
	private static final long serialVersionUID = -5685830782251303228L;
	
	String source;
	
	String name;
	
	int health;
	
	String area;
	
	int exp;
	
	int x;
	
	int y;
	
	int frame;
	
	GameSequence sOEvents;
	
	SaveFile(String source, String name, String area, int health, int exp, int x, int y, int frame, GameSequence sOEvents) {
		this.source = source;
		this.name = name;
		this.area = area;
		this.health = health;
		this.exp = exp;
		this.x = x;
		this.y = y;
		this.frame = frame;
		this.sOEvents = sOEvents;
	}
	
	SaveFile(String source) {
		this.source = source;
		this.name = "Eeggman";
		this.area = "Ortni Town";
		this.health = 20;
		this.exp = 0;
		this.x = 200;
		this.y = 200;
		this.frame = 0;
		this.sOEvents = GameSequence.Start;
	}
	
	public void writeObject() {
		try {
			FileOutputStream saveFile = new FileOutputStream("src/" + this.source);
			
			ObjectOutputStream out = new ObjectOutputStream(saveFile);
			
	        //out.defaultWriteObject();
			
			out.writeObject(this.name);
	        
	        out.writeObject(this.health);
	        
	        out.writeObject(this.area);
	        
	        out.writeObject(this.exp);
	        
	        out.writeObject(this.x);
	        
	        out.writeObject(this.y);
	        
	        out.writeObject(this.frame);
	        
	        out.writeObject(this.sOEvents);
	        
	        out.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
	
	
    public void readObject() {
    	try {
	    	FileInputStream saveFile = new FileInputStream("src/" + this.source);
			
			ObjectInputStream in = new ObjectInputStream(saveFile);
	    	
	        //in.defaultReadObject();
			
			this.name = (String) in.readObject();
	        
	        this.health = (int) in.readObject();
	        
	        this.area = (String) in.readObject();
	        
	        this.exp = (int) in.readObject();
	        
	        this.x = (int) in.readObject();
	        
	        this.y = (int) in.readObject();
	        
	        this.frame = (int) in.readObject();
	        
	        this.sOEvents = (GameSequence) in.readObject();
	        
	        in.close();
    	} catch(Exception e) {
    		e.printStackTrace();
    		System.exit(1);
    	}
    }
}
