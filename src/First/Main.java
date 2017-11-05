package First;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.io.File;
//import java.io.IOException;

//import javax.imageio.ImageIO;
import javax.swing.*;
public class Main extends Applet implements Runnable, KeyListener {
    public static final long serialVersionUID = 1L;
    public static final Dimension SCREEN_SIZE = new Dimension(800, 800);//the screen size
    public static final Dimension GAME_SIZE = new Dimension(200, 200);//the amount of pixels
    public static JFrame frame;//the frame for setting everything up
    
    boolean isRunning = true;//if the program is running or not
    
    boolean[] keys = new boolean[100];//used to sense key inputs
    
    Image screen;//the screen image that makes the pixels larger
    
    int menu = 0;//used to control where you are in the menu
    int intro = 0;//frameCount for how long the intro is
    
    int exitCount = 0;//makes it wait to exit
    
    Font serif = new Font("serif", Font.PLAIN, 30);//font serif
    Font secret = new Font("serif", Font.PLAIN, 5);//font serif
    Font small = new Font("serif", Font.PLAIN, 15);
    Font tiny = new Font("serif", Font.PLAIN, 10);
    public Enemy y;
    public Sprite ortni = new Sprite("ortni.png");
    public Sprite dchar0 = new Sprite("dchar0.png");
    public Sprite dchar1 = new Sprite("dchar1.png");
    public Sprite dchar2 = new Sprite("dchar2.png");
    public Sprite dchar3 = new Sprite("dchar3.png");
    public Sprite lchar0 = new Sprite("lchar0.png");
    public Sprite lchar1 = new Sprite("lchar1.png");
    public Sprite lchar2 = new Sprite("lchar2.png");
    public Sprite lchar3 = new Sprite("lchar3.png");
    public Sprite rchar0 = new Sprite("dchar0.png");
    public Sprite rchar1 = new Sprite("dchar1.png");
    public Sprite rchar2 = new Sprite("dchar2.png");
    public Sprite rchar3 = new Sprite("dchar3.png");
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
    public Sprite turtleman = new Sprite("Turtle Man.png");
    public Sprite turtlestack = new Sprite("Turtle Stack.png");
    

    public void centerString(Graphics g, String text, Rectangle rect, Font font) {
        // Get the FontMetrics
        FontMetrics metrics = g.getFontMetrics(font);
        // Determine the X coordinate for the text
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        // Set the font
        g.setFont(font);
        // Draw the String
        g.drawString(text, x, y);
    }
    
    public static void main(String[] args){
        Main main = new Main();
        frame.setSize(SCREEN_SIZE);
        frame.setTitle("Othurworld");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(main);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        main.start();
    }
    public Main() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        setPreferredSize(SCREEN_SIZE);
        frame = new JFrame();
        
        ortni.loadFile();
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
    }
    public void start() {
        init();
        new Thread(this).start();
    }
    public void init() {
        screen = createVolatileImage(GAME_SIZE.width, GAME_SIZE.height);
        

        
    }
    
    public void paint(){//draw loop
        Graphics g = screen.getGraphics();
        //
        
        g.setFont(serif);
        g.setColor(Color.black);
        g.fillRect(0,  0,  200, 200);//background
        
        if(menu == 0) {//intro
            if(intro < 300){
                intro ++;
                g.setColor(new Color(255,255,255,Math.min(305-intro,255)));
                centerString(g, "There is a story in an old", new Rectangle(0,80,320,40), serif);
                centerString(g, "children's book.", new Rectangle(0,120,320,40), serif);
            }
            if(intro >= 300 && intro < 400){
                intro ++;
            }
            if(intro >= 400 && intro <= 700){
                intro ++;
                g.setColor(new Color(255,255,255,Math.min(705-intro,255)));
                centerString(g, "It speaks of a world of", new Rectangle(0,70,320,40), serif);
                centerString(g, "\"othurs\" and a world of", new Rectangle(0,110,320,40), serif);
                centerString(g, "humans...", new Rectangle(0,150,320,40), serif);
            }
            if(intro >= 700 && intro < 800){
                intro ++;
            }
            if(intro >= 800 && intro < 1100){
                intro ++;
                g.setColor(new Color(255,255,255,Math.min(1105-intro,255)));
                centerString(g, "But the humans did not", new Rectangle(0,70,320,40), serif);
                centerString(g, "know of the othurs'", new Rectangle(0,110,320,40), serif);
                centerString(g, "existance...", new Rectangle(0,150,320,40), serif);
            }
            if(intro >= 1100 && intro < 1200){
                intro ++;
            }
            if(intro >= 1200 && intro < 1500){
                intro ++;
                g.setColor(new Color(255,255,255,Math.min(1505-intro,255)));
                centerString(g, "In this story, a young", new Rectangle(0,60,320,40), serif);
                centerString(g, "boy lived in a small", new Rectangle(0,100,320,40), serif);
                centerString(g, "village next to a mysterious", new Rectangle(0,140,320,40), serif);
                centerString(g, "cave.", new Rectangle(0,180,320,40), serif);
            }
            if(intro >= 1500 && intro < 1700){
                intro ++;
            }
            if(intro >= 1700 && intro < 2100){
                intro ++;
                g.setColor(new Color(255,255,255,Math.max(Math.min(2005-intro,255),0)));
                centerString(g, "No one had ever come out", new Rectangle(0, 80, 320, 40), serif);
                centerString(g, "of the cave alive...", new Rectangle(0, 120, 320, 40), serif);
            }
            if(intro == 2100){
                g.setColor(new Color(255,255,255));
                centerString(g, "Othurworld", new Rectangle(0, 80, 320, 40), serif);
                centerString(g, "Press z", new Rectangle(0, 120, 320, 40), serif);
            }
            if(keys[90]) {
                menu = 1;
            }
        }
        
        if(menu == 1) {
            g.setFont(secret);
            g.setColor(new Color(255,255,255));
            ortni.draw(g, -100, -100, 400, 400);
            
        }
        
        
        
        if(exitCount != 0) {//shows the "Exiting game.." text
            g.setColor(new Color(255, 255, 255, exitCount * 3));
            g.setFont(small);
            g.drawString("Exiting game...", 10, 15);
            g.drawRect(10, 20, 85, 10);
            g.fillRect(11, 21, exitCount, 9);
        }
        if(keys[27]) {
            exitCount ++;
        } else {
            if( exitCount > 0) {
                exitCount --;
            }
        }
        if(exitCount > 85) {
            System.exit(0);
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
                Thread.sleep(10);
            }
            catch(InterruptedException ie) {
                
            }
        }
    }
    public void stop() {
        isRunning = false;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }
    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
}
