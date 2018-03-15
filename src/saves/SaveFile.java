package saves;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JOptionPane;

import First.GameSequence;
import inventory.Collected;
import inventory.Inventory;
import inventory.Item;
import inventory.KeyItem;
import inventory.Weapon;

public class SaveFile implements Serializable {
	private static final long serialVersionUID = -5685830782251303228L;
	
	public String source;
	
	public String name;
	
	public int health;
	
	public String area;
	
	public int exp;
	
	public int level;
	
	public int x;
	
	public int y;
	
	public int frame;
	
	public Inventory inv;
	
	public Collected collect;
	
	public GameSequence sOEvents;
	
	public SaveFile(String source, String name, String area, int health, int exp, int level, int x, int y, int frame, Inventory inv, Collected collect, GameSequence sOEvents) {
		this.source = source;
		this.name = name;
		this.area = area;
		this.health = health;
		this.exp = exp;
		this.level = level;
		this.x = x;
		this.y = y;
		this.frame = frame;
		this.inv = inv;
		this.collect = collect;
		this.sOEvents = sOEvents;
	}
	
	public SaveFile(String source) {
		this.source = source;
		this.name = "Eeggman";
		this.area = "Ortni Town";
		this.health = 32;
		this.exp = 0;
		this.level = 1;
		this.x = 200;
		this.y = 200;
		this.frame = 0;
		this.inv = new Inventory(new Item[5], new KeyItem(), Weapon.ChippedKnife);
		this.collect = new Collected();
		this.sOEvents = GameSequence.Start;//debug
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
	        
	        out.writeObject(this.level);
	        
	        out.writeObject(this.x);
	        
	        out.writeObject(this.y);
	        
	        out.writeObject(this.frame);
	        
	        out.writeObject(this.inv);
	        
	        out.writeObject(this.collect);
	        
	        out.writeObject(this.sOEvents);
	        
	        out.close();
		} catch(NotSerializableException e) {
			e.printStackTrace();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "There was an error writing to your save file.");
			e.printStackTrace();
			System.exit(1);
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
	        
	        this.level = (int) in.readObject();
	        
	        this.x = (int) in.readObject();
	        
	        this.y = (int) in.readObject();
	        
	        this.frame = (int) in.readObject();
	        
	        this.inv = (Inventory) in.readObject();
	        
	        this.collect = (Collected) in.readObject();
	        
	        this.sOEvents = (GameSequence) in.readObject();
	        
	        in.close();
    	} catch(Exception e) {
    		e.printStackTrace();
    		JOptionPane.showMessageDialog(null, "There was an error loading the save file");
    		System.exit(1);
    	}
    }
}
