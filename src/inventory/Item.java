package inventory;

import First.Main;
import battle.Battle;
import game.Sprite;

public enum Item {
	Carrot(new String[]{"A delicious carrot grown\nfrom the ground.\nHeals 7 health."}),
	Pancakes(new String[]{"These ancakes are amazing!\nHeals 15 health."}),
	BurntPancake("Burnt Pancakes", new String[]{"These pancakes are burnt...\nHeals 7 health and +1 ATK."}),
	Rock(new String[]{"Rock"}),
    Heart(new String[]{"It's a human heart.\nYou can feel it beating.\nYou can hear it beating.","If you were to eat it,\nyou could probably taste\nit beating.","Eat it?"}),
    EnergyPlant("Energy Plant", new String[]{"It's an energy plant.\nHeals 7 health\nand +2 ATK and +2 DEF"}),
    GhostPlant("Ghost Plant", new String[]{"It's a ghost plant.\nHeals 3 health and\n-1 ATK and +5 DEF"}),
    Turtle(new String[]{"It's a turtle."}),
    EvilTurtle("Evil Turtle", new String[]{"It's an angry turtle! \n It wishes you were dead."}),
    Glitch(new String[]{"#@!QASDZXC#@!QASDZ\nXC&^%RFVBNJUY$RF","V%T^&UJMXDR%TG\nBF%TGB^YJMKI("}),
    
    EasterEgg("Easter Egg", new String[]{"It's an easter egg.","It shouldn't be here"}),
    ChildHorseToy("Child Horse Toy", new String[]{"It's a childish toy.\nIt has a picture of a horse on it.", "Along with the word 'NAY'","It shouldn't be here"}),
    BunnyGoatHead("Bunny Goat Head", new String[]{"It's a stuffed animal head.","It shouldn't be here"}),
    BrokenBone("Broken Bone", new String[]{"It's a broken bone.","It shouldn't be here"}),
    Wouldshroom(new String[]{"It's a wooden mushroom.\nWhat Would you do?","It shouldn't be here"});
	
	private String name;
	
	private String[] desc;
	
	private Item(String[] desc) {
		this.name = this.name();
		this.desc = desc;
	}
	
	private Item(String name, String[] desc) {
		this.name = name;
		this.desc = desc;
	}
	
	public String[] description() {
		return this.desc;
	}
	
	public String getName() {
		return this.name;
	}
	
	/*public static String[] description(Item item) {
		switch(item) {
			case Carrot: return new String[]{"A delicious carrot grown\nfrom the ground.\nHeals 7 health."};
			
			case Pancake: return new String[]{"Pancakes are amazing!\nHeals 15 health."};
			
			default: return new String[]{"What is this?"};
		}
	}*/
	
	public void playEffect(int index) {
		switch(this) {
			case Carrot:
				Main.INSTANCE.save.health += 7;
				Main.INSTANCE.save.inv.useItem(index);
				Battle.INSTANCE.capHealth();
				break;
				
			case Pancakes:
				Main.INSTANCE.save.health += 15;
				Main.INSTANCE.save.inv.useItem(index);
				Battle.INSTANCE.capHealth();
				break;
				
			case BurntPancake:
				Main.INSTANCE.save.health += 7;
				//Add temp attack boost
				Main.INSTANCE.save.inv.useItem(index);
				Battle.INSTANCE.capHealth();
				break;
				
			case Heart:
				Main.INSTANCE.save.health --;
				Main.INSTANCE.save.inv.useItem(index);
				Battle.INSTANCE.capHealth();
				break;
				
			case EnergyPlant:
				Main.INSTANCE.save.health += 7;
				//affect ATK and DEF
				Main.INSTANCE.save.inv.useItem(index);
				Battle.INSTANCE.capHealth();
				break;
				
			case GhostPlant:
				Main.INSTANCE.save.health += 3;
				//affect DEF and ATK
				Main.INSTANCE.save.inv.useItem(index);
				Battle.INSTANCE.capHealth();
				break;
				
			default:
				Main.INSTANCE.save.inv.useItem(index);
				break;
		}
	}
	
	/*public Sprite getImage() {
		return this.sprite;
	}*/
	
	public Sprite getImage() {
		switch(this) {
			case Carrot:
				return Main.INSTANCE.carrotI;
				
			case Pancakes:
				return Main.INSTANCE.pancakeI;
				
			case BurntPancake:
				return Main.INSTANCE.bpancakeI;
				
			case Heart:
				return Main.INSTANCE.heartI;
				
			case Rock:
				return Main.INSTANCE.rockI;
				
			case EnergyPlant:
				return Main.INSTANCE.energyplantI;
				
			case GhostPlant:
				return Main.INSTANCE.ghostplantI;
				
			case Turtle:
				return Main.INSTANCE.turtleI;
				
			case Glitch:
				return Main.INSTANCE.glitchI;
				
			case EasterEgg:
				return Main.INSTANCE.eeggI;
				
			case ChildHorseToy:
				return Main.INSTANCE.chtI;
				
			case BunnyGoatHead:
				return Main.INSTANCE.bghI;
				
			case Wouldshroom:
				return Main.INSTANCE.wsI;
				
			case EvilTurtle:
				return Main.INSTANCE.eturtleI;
			
			default:
				return null;
		}
	}
}
