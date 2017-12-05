package First;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class World {
	static List<Event> event = new ArrayList<>();
	static void update() {
		event.clear();
		//sets the background Sprite according to the area on the save file
		if(Main.INSTANCE.save.area.equals("Ortni Town")) {//Ortni Town
			Main.INSTANCE.world = Main.ortni;
			event.addAll(Arrays.asList(
				new Event(69, 75, 19, 31, true, new String[]{"The moss on the door has glued\nit shut.", "Is someone in there?"}),//door 1
				new Event(42, 59, 75, 46, true, 0),//house 1
				new Event(310, 108, 19, 30, true, "EmptyShack1", 68, 65),//door 2
				new Event(283, 92, 75, 46, true, 0),//house 2
				new Event(144, 198, 19, 30, true, "Home", 68, 65),//door 3
				new Event(117, 182, 75, 46, true, 0),//house 3
				new Event(311, 272, 19, 30, true, "TurtleCave", 68, 65),//door 4
				new Event(284, 256, 75, 46, true, 0),//house 4
			    new Event(56, 287, 19, 31, true, "EmptyShack2", 68, 65),//door 5
				new Event(29, 271, 75, 47, true, 0),//house 5
				new Event(7, 4, 177, 14, true, 0),//fence top left
				new Event(211, 4, 177, 14, true, 0),//fence top right
				new Event(7, 4, 7, 374, true, 0),//fence left
				new Event(7, 364, 381, 14, true, 0),//fence bottom
				new Event(381, 4, 7, 374, true, 0),//fence right
				new Event(271, 291, 5, 10, true, 0),//flower
				new Event(270,290,7,12,true, new String[]{"It's a flower.","It doesn't seem very interesting..."}),
				new Event(291, 251, 10, 5, true, 0),//turtle3
				new Event(33,335,25,15,true,new String[]{"Meow!","It's an incredibly clean cat"}),
				new Event(34,336,23,13,true,0),
				new Event(190,0,20,10,true,"OrtniPath", 100, 400)
			));
			if (Main.INSTANCE.save.sOEvents == GameSequence.Start) {
				event.addAll(Arrays.asList(
					new Event(82,294,16,31,true, 0),//the old dude
					new Event(81,293,18,33,true, new String[]{"Hello.","You must be bursting to get out \nof here, aren't you?", "Well, tell you what, I'll help you.","I've gotten bored of lording over \nthe dust motes in the shack most\ncall my house.", "Anyway, all you need to do is\nrun.","Again, when I scream and send\nthe men down here, you should\nflee to the giant waterbuffalo", "in the sky.", "AAUUGHHH! \nMY KIDNEY IS DYING!\n(Flee! Go, flee')"},3),//the old dude's speech
					new Event(171,20,51,40,true, 0),//the two gaurds blocking the path
					new Event(170,20,25,42,true, new String[]{"Hey, Kid.","You ain't allowed out of here."}),//the left gaurd's talk
					new Event(200,20,25,42,true, new String[]{"I'm sorry,","you are not allowed past."}) //the left gaurd's talk
				));
			}
			if(Main.INSTANCE.save.sOEvents == GameSequence.OldDudeDies) {
				event.addAll(Arrays.asList(
					new Event(82,294,16,31,true, 0),//the old dude
					new Event(81,293,18,33,true, new String[]{"(Flee!)","AAUUUGGH!"}),
					new Event(171,20,51,40,true, 0),//the two gaurds blocking the path
					new Event(170,20,25,42,true, new String[]{"What in  tarnation was that?","Don't you go anywhere."},3),//the left gaurd's talk
					new Event(200,20,25,42,true, new String[]{"Was that a scream I heard?","Please do not leave."},3) //the left gaurd's talk				
				));
			}
		}
		
		if(Main.INSTANCE.save.area.equals("Home")) {//your home (house 4 of Ortni Town)
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
		if(Main.INSTANCE.save.area.equals("TurtleCave")) {//the turtle dude's home (house 5 of Ortni Town)
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
		if(Main.INSTANCE.save.area.equals("EmptyShack1")) {//the empty home (empty houses of Ortni Town)
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
		if(Main.INSTANCE.save.area.equals("EmptyShack2")) {//the empty home (empty houses of Ortni Town)
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
		if(Main.INSTANCE.save.area.equals("OrtniPath")) {//the empty home (empty houses of Ortni Town)
			Main.INSTANCE.world = Main.ortnipath;
			/*event.addAll(Arrays.asList(
				new Event(66, 90, 19, 2, true, "Ortni Town", 58, 304),//exit door
				new Event(0,0,150,23,true,0),//the back wall
				new Event(148,23,2,69,true,0),//the left wall
				new Event(0,23,2,69,true,0),//the right wall
				new Event(2,90,64,2,true,0),//the front left wall
				new Event(85,90,63,2,true,0) //the front right wall
			));*/
		}
	}
	static void collide() {
		for(int i = 0;i < event.size();i ++){
			if(Main.INSTANCE.save.x + 14 > event.get(i).rect.x && Main.INSTANCE.save.x < event.get(i).rect.x + event.get(i).rect.width && Main.INSTANCE.save.y + 25 > event.get(i).rect.y && Main.INSTANCE.save.y + 14 < event.get(i).rect.y + event.get(i).rect.height) {
				if(event.get(i).collide) {
					if(Main.INSTANCE.save.x >= event.get(i).rect.x + event.get(i).rect.width - 1) {
						Main.INSTANCE.save.x ++;
						Main.INSTANCE.run[2] = 1;
					}
					if(Main.INSTANCE.save.x + 14 <= event.get(i).rect.x + 1) {
						Main.INSTANCE.save.x --;
						Main.INSTANCE.run[0] = 1;
					}
					if(Main.INSTANCE.save.y + 14 >= event.get(i).rect.y + event.get(i).rect.height - 1) {
						Main.INSTANCE.save.y ++;
						Main.INSTANCE.run[1] = 1;
					}
					if(Main.INSTANCE.save.y + 25 <= event.get(i).rect.y + 1) {
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
	static void draw(Graphics g) {//debug
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
