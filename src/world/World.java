package world;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import First.GameSequence;
import First.Main;
import inventory.Item;

public class World {
	static List<Event> event = new ArrayList<>();
	public static void update() {
		event.clear();
		//sets the background Sprite according to the area on the save file
		if(Main.INSTANCE.save.area.equals("Ortni Town")) {//Ortni Town
			Main.INSTANCE.world = Main.ortni;
			event.addAll(Arrays.asList(
				new Event(69, 75, 19, 31, true, new String[]{"The moss on the door has glued\nit shut.", "Is someone in there?"}),//door 1
				new Event(42, 59, 75, 46, true, 0),//house 1
				new Event(310, 108, 19, 30, true, "Empty Shack", 68, 65),//door 2
				new Event(283, 92, 75, 46, true, 0),//house 2
				new Event(144, 198, 19, 30, true, "Home", 68, 65),//door 3
				new Event(117, 182, 75, 46, true, 0),//house 3
				new Event(311, 272, 19, 30, true, "Turtle House", 68, 65),//door 4
				new Event(284, 256, 75, 46, true, 0),//house 4
			    new Event(56, 287, 19, 30, true, "Empty Shack ", 68, 65),//door 5
				new Event(29, 271, 75, 46, true, 0),//house 5
				new Event(7, 4, 177, 14, true, 0),//fence top left
				new Event(211, 4, 177, 14, true, 0),//fence top right
				new Event(7, 4, 7, 374, true, 0),//fence left
				new Event(7, 364, 381, 14, true, 0),//fence bottom
				new Event(381, 4, 7, 374, true, 0),//fence right
				new Event(271, 291, 5, 10, true, 0),//flower
				new Event(270,290,7,12,true, new String[]{"It's a flower.","It doesn't seem very interesting..."}),
				new Event(291, 251, 10, 5, true, 0),//turtle3
				new Event(33, 335, 25, 15, true, new String[]{"Meow!"}),//Kidney
				new Event(34, 336, 23, 13, true, 0),//Kidney
				new Event(184, 4, 27, 14, true, "Ortni Path", 100, 444, true)//teleport to OrtniPath
			));
			if(!Main.INSTANCE.save.collect.Carrot) {//Carrot item
				event.addAll(Arrays.asList(
					new Event(42, 217, 7 ,13, true, new String[]{"It's a carrot in the ground.", "Got the Carrot!"}, Item.Carrot),//The carrot
					new Event(43, 218, 5 , 11, true, 0)
				));
			}
			if(Main.INSTANCE.save.sOEvents == GameSequence.Start) {
				event.addAll(Arrays.asList(
					new Event(82, 294, 17, 31, true, 0),//the old dude
					new Event(81, 293, 19, 33, true, new String[]{"Hello.","You must be bursting to get out \nof here, aren't you?", "Well, tell you what, I'll help you.","I've gotten bored of lording over \nthe dust motes in the shack most\ncall my house.", "Anyway, all you need to do is\nrun.","Again, when I scream and send\nthe men down here, you should\nflee to the giant waterbuffalo", "in the sky.", "AAUUGHHH! \nMY KIDNEY IS DYING!\n(Flee! Go, flee!)"},3),//the old dude's speech
					new Event(171, 20, 51, 40, true, 0),//the two gaurds blocking the path
					new Event(170, 20, 23, 41, false, new String[]{"Hey, Kid.","You ain't allowed out of here."}),//the left gaurd's talk
					new Event(200, 20, 23, 41, false, new String[]{"I'm sorry,","you are not allowed past."}) //the left gaurd's talk
				));
			}
			if(Main.INSTANCE.save.sOEvents == GameSequence.OldDudeDies) {
				event.addAll(Arrays.asList(
					new Event(82,294,17,31,true, 0),//the old dude
					new Event(81,293,19,33,true, new String[]{"(Flee!)","AAUUUGGH!"}),
					new Event(171,20,51,40,true, 0),//the two gaurds blocking the path
					new Event(170,20,23,41,true, new String[]{"What in tarnation was that?","Don't you go anywhere."},4),//the left gaurd's talk
					new Event(200,20,23,41,true, new String[]{"Was that a scream I heard?","Please do not leave."},4) //the left gaurd's talk				
				));
			}
		}
		
		if(Main.INSTANCE.save.area.equals("Home")) {//your home (house 3 of Ortni Town)
			Main.INSTANCE.world = Main.ortni1;
			event.addAll(Arrays.asList(
				new Event(66, 90, 19, 2, true, "Ortni Town", 146, 214),//exit door
				new Event(0,0,150,23,true,0),//the back wall
				new Event(28,5,8,19,true, new String[]{"It's a stick.","It's your best and only friend."},0),//the stick
				new Event(148,23,2,69,true,0),//the left wall
				new Event(0,23,2,69,true,0),//the right wall
				new Event(2,90,64,2,true,0),//the front left wall
				new Event(85,90,63,2,true,0) //the front right wall
			));
		}
		if(Main.INSTANCE.save.area.equals("Turtle House")) {//the turtle dude's home (house 5 of Ortni Town)
			Main.INSTANCE.world = Main.ortni2;
			event.addAll(Arrays.asList(
				new Event(66, 90, 19, 2, true, "Ortni Town", 313, 288),//exit door
				new Event(0,0,150,23,true,0),//the back wall
				new Event(148,23,2,69,true,0),//the left wall
				new Event(0,23,2,69,true,0),//the right wall
				new Event(2,90,64,2,true,0),//the front left wall
				new Event(85,90,63,2,true,0), //the front right wall
				new Event(18,24,30,30,true, new String[]{"It's a glorious stack of stacks of \nturtles.","You can hardly believe its \nmajesty."},0), //the turtle stacks description
				new Event(19,25,28,28,true,0), //the turtle stacks
				new Event(88,35,13,27,true,0), //the turtle man
				new Event(87,34,15,29,true,new String[]{"...","Are you here to admire my \nturtles?"},0) //the turtle man's speaking stuff
			));
		}
		if(Main.INSTANCE.save.area.equals("Empty Shack")) {//the empty home (empty houses of Ortni Town)
			Main.INSTANCE.world = Main.ortni3;
			event.addAll(Arrays.asList(
				new Event(66, 90, 19, 2, true, "Ortni Town", 312, 125),//exit door
				new Event(0,0,150,23,true,0),//the back wall
				new Event(148,23,2,69,true,0),//the left wall
				new Event(0,23,2,69,true,0),//the right wall
				new Event(2,90,64,2,true,0),//the front left wall
				new Event(85,90,63,2,true,0) //the front right wall
			));
		}
		if(Main.INSTANCE.save.area.equals("Empty Shack ")) {//the empty home (empty houses of Ortni Town)
			Main.INSTANCE.world = Main.ortni3;
			event.addAll(Arrays.asList(
				new Event(66, 90, 19, 2, true, "Ortni Town", 58, 304),//exit door
				new Event(0,0,150,23,true,0),//the back wall
				new Event(148,23,2,69,true,0),//the left wall
				new Event(0,23,2,69,true,0),//the right wall
				new Event(2,90,64,2,true,0),//the front left wall
				new Event(85,90,63,2,true,0) //the front right wall
			));
		}
		if(Main.INSTANCE.save.area.equals("Ortni Path")) {//The path to the cave
			Main.INSTANCE.world = Main.ortnipath;
			event.addAll(Arrays.asList(
				new Event(32, 0, 168, 87, true, 0),//Part of the cave
				new Event(22, 12, 10, 41, true, 0),//Part of cave
				new Event(26, 53, 6, 15, true, 0),//Part of cave
				new Event(24, 68, 8, 19, true, 0),//Part of cave
				new Event(46, 88, 22, 40, true, 0),//Part of cave
				new Event(39, 87, 7, 12, true, 0),//Part of cave
				new Event(56, 122, 22, 18, true, 0),//Part of cave
				new Event(148, 81, 34, 27, true, 0),//Part of cave
				new Event(183, 80, 8, 23, true, 0),//Part of cave
				new Event(69, 97, 74, 7, true, "Mysterious Cave", 100, 974, true),//Part of cave
				new Event(90, 469, 27, 1, true, "Ortni Town", 194, 5, true),//Teleport to Ortni Town
				new Event(0, 469, 200, 1, true, 0),//Bottom wall
				new Event(0, 0, 1, 670, true, 0),//Left Wall
				new Event(199, 0, 1, 670, true, 0),//Right Wall
				new Event(0, 0, 200, 14, true, 0),//Top wall
				new Event(38, 433, 25, 7, true, 0),//The sign
				new Event(38, 433, 25, 8, true, new String[]{"         Ortni Insane Asylum \n                       |\n                      V"}, new Color(0,0,0), new Color(89,41,0), new Color(64,29,0))//The sign
			));
		}
		if(Main.INSTANCE.save.area.equals("Mysterious Cave")) {//The path to the cave
			Main.INSTANCE.world = Main.incave;
			event.addAll(Arrays.asList(
				new Event(90, 998, 27, 1, true, new String[]{"You can't go back.", "The memories are too painful."}),//Teleport to Ortni Path
				new Event(0, 0, 200, 14, true, 0),//Top wall
				new Event(0, 999, 200, 1, true, 0),//Bottom wall
				new Event(0, 0, 1, 1000, true, 0),//Left wall
				new Event(199, 0, 1, 1000, true, 0),//Right wall
				new Event(0, 100, 200, 10, false, new String[]{"Hello.","I am D.r. D.","I am here to take you to another\nworld.","This world possesses thousands\nof the many sentient species\nin existance.","You possibly have heard tales\nand myths of ancient creatures,\nsuch as unicorns,", "and dragons.", "Contrary to popular belief,\nthese stories are true.","...","I am hesitant to receive\nsuch a young child into this world,\nbut precautions have been", "taken to ensure your progress,\nand that you will never truly be in\ndanger...","...","Good Luck."}, 5, Color.white, Color.black, Color.black),//Talking to Eeggman in the Cave
				new Event(0, 101, 200, 8, true, 0),//Talking to Eeggman
				new Event(85, 25,32,65,true, 0),//Eegg
				new Event(29,870,32,5,true,0),//stalagm?t?ite
                new Event(38,858,13,21,true,0),//stalagm?t?ite
                new Event(34,863,23,14,true,0),//stalagm?t?ite
                new Event(42,854,7,4,true,0),//stalagm?t?ite
                new Event(26,875,8,3,true,0),//stalagm?t?ite
                new Event(145,918,11,3,true,0),//stalagm?t?ite
                new Event(153,912,1,12,true,0),//stalagm?t?ite
                new Event(149,916,7,8,true,0),//stalagm?t?ite
                new Event(149,782,15,31,true,0),//stalagm?t?ite
                new Event(155,767,3,15,true,0),//stalagm?t?ite
                new Event(152,775,10,7,true,0),//stalagm?t?ite
                new Event(144,793,25,9,true,0),//stalagm?t?ite
                new Event(140,805,31,5,true,0),//stalagm?t?ite
                new Event(94,720,7,8,true,0),//stalagm?t?ite
                new Event(96,716,2,12,true,0),//stalagm?t?ite
                new Event(21,650,9,30,true,0),//stalagm?t?ite
                new Event(25,644,3,36,true,0),//stalagm?t?ite
                new Event(16,661,19,18,true,0),//stalagm?t?ite
                new Event(11,672,28,6,true,0),//stalagm?t?ite
                new Event(44,511,6,4,true,0),//stalag
				new Event(42,515,11,7,true,0),//stalag
				new Event(138,471,3,13,true,0),//stalag
				new Event(142,467,32,20,true,0),//stalag
				new Event(149,459,23,8,true,0),//stalag
				new Event(153,453,16,14,true,0),//stalag
				new Event(160,446,9,7,true,0),//stalag
				new Event(25,394,5,4,true,0),//stalag
				new Event(24,394,11,18,true,0),//stalag
				new Event(35,405,6,11,true,0),//stalag
				new Event(69,273,6,7,true,0),//stalag
				new Event(60,280,12,13,true,0),//stalag
	            new Event(160,244,8,15,true,0),//stalag
				new Event(156,259,13,10,true,0),//stalag
				new Event(48,142,5,4,true,0),//stalag
				new Event(45,146,8,8,true,0),//stalag
				new Event(38,154,18,8,true,0),//stalag
				new Event(143,141,9,6,true,0),//stalag
				new Event(146,138,4,3,true,0),//stalag
				new Event(159,86,5,3,true,0),//stalag
				new Event(155,90,10,9,true,0)//stalag
			));
		}
		
		if(Main.INSTANCE.save.area.equals("Forest Path")) {//The path to the cave
			Main.INSTANCE.world = Main.forPath;
			event.addAll(Arrays.asList(
				new Event(114, 99, 12, 11, true, 0),
				new Event(90, 259, 7, 11, true, 0),
				new Event(162, 253, 5, 11, true, 0),
				new Event(161, 365, 9, 9, true, 0),
				new Event(261, 417, 9, 12, true, 0),
				new Event(320, 303, 15, 34, true, 0),
				new Event(386, 312, 8, 12, true, 0),
				new Event(380, 185, 17, 21, true, 0),
				new Event(339, 134, 13, 19, true, 0)
			));
		}
	}
	public static void collide() {
		for(int i = 0;i < event.size();i ++){
			if(Main.INSTANCE.save.x + 12 > event.get(i).rect.x && Main.INSTANCE.save.x < event.get(i).rect.x + event.get(i).rect.width && Main.INSTANCE.save.y + 24 > event.get(i).rect.y && Main.INSTANCE.save.y + 14 < event.get(i).rect.y + event.get(i).rect.height) {
				if(event.get(i).collide) {
					if(Main.INSTANCE.save.x >= event.get(i).rect.x + event.get(i).rect.width - 1) {
						Main.INSTANCE.save.x ++;
						Main.INSTANCE.run[2] = 1;
					}
					if(Main.INSTANCE.save.x + 12 <= event.get(i).rect.x + 1) {
						Main.INSTANCE.save.x --;
						Main.INSTANCE.run[0] = 1;
					}
					if(Main.INSTANCE.save.y + 14 >= event.get(i).rect.y + event.get(i).rect.height - 1) {
						Main.INSTANCE.save.y ++;
						Main.INSTANCE.run[1] = 1;
					}
					if(Main.INSTANCE.save.y + 24 <= event.get(i).rect.y + 1) {
						Main.INSTANCE.save.y --;
						Main.INSTANCE.run[3] = 1;
					}
				}
				
				if(Main.INSTANCE.moving) {
					if(!event.get(i).activate) {
						event.get(i).run();
					} else {
						if(Main.INSTANCE.keys[90]) {
							event.get(i).run();
						}
					}
				}
			}
		}
	}
	public static void draw(Graphics g) {//debug
		for(int i = 0;i < event.size();i ++){
			g.setColor(new Color(255, 0, 0, 100));
			if(event.get(i).eventNum == 1) {
				g.setColor(new Color(0, 0, 255, 100));
			}
			if(event.get(i).eventNum == 2) {
				g.setColor(new Color(0, 255, 0, 100));
			}
			if(event.get(i).eventNum == 3) {
				g.setColor(new Color(0, 255, 255, 100));
			}
			g.fillRect(event.get(i).rect.x, event.get(i).rect.y, event.get(i).rect.width, event.get(i).rect.height);//debug
		}
	}
}
