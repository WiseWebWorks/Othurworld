package saves;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JOptionPane;

public class Achieve implements Serializable {
	private static final long serialVersionUID = -5685830782251303226L;
	
	public String source;
	
	public Achieve(String source) {
		this.source = source;
	}
	
	public void writeObject() {
		try {
			FileOutputStream saveFile = new FileOutputStream("src/" + this.source);
			
			ObjectOutputStream out = new ObjectOutputStream(saveFile);
			
	        //out.defaultWriteObject();
			
			//out.writeObject(this.something);
	        
	        out.close();
		} catch(NotSerializableException e) {
			e.printStackTrace();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "There was an error writing to your achievements file.");
			e.printStackTrace();
			System.exit(1);
		}
    }
	
	
    public void readObject() {
    	try {
	    	FileInputStream saveFile = new FileInputStream("src/" + this.source);
			
			ObjectInputStream in = new ObjectInputStream(saveFile);
	    	
	        //in.defaultReadObject();
			
			//this.something = (boolean) in.readObject();
	        
	        in.close();
    	} catch(Exception e) {
    		e.printStackTrace();
    		JOptionPane.showMessageDialog(null, "There was an error loading the achievements file");
    		System.exit(1);
    	}
    }
}
