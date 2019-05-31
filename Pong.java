package Lab5CabreraE;

/*********************************************************
 * SE1021
 * Purpose: Creates the box where the game will be played
 *          and puts it all together
 * @author CabreraE
 * @version 1.0 Created on 4/29/2015 at 3:35 PM
 *********************************************************/

import java.awt.*;
import javax.swing.*;

public class Pong extends JFrame{
    private final static int WIDTH = 1000;
    private final static int HEIGHT = 600;
    public final static int RACKET_UP = -5;
    public final static int RACKET_DOWN = 5;
    private PongPanel panel;

    /**
     * Pong()
     * Sets up window where Pong will
     * be played
     */

    public Pong(){
        setSize(WIDTH, HEIGHT);
        setTitle("Pong");
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new PongPanel(this);
        addKeyListener(panel);
        if(panel == null)
            System.exit(-1);
        add(panel);

    }

    /**
     * getPanel()
     * Calls panel where Pong is being
     * played
     * @return panel
     */

    public PongPanel getPanel(){
        return panel;
    }

    /**
     * paint()
     * Calls in Graphics library to paint
     * pong panel
     * @param g
     */

    public void paint(Graphics g){
        try {
            super.paint(g);
            panel.revalidate();
            panel.repaint();
        }
        catch(Exception e){
        }
    }

    public static void main(String[] args) {
        Banner welcome = new Banner ("Welcome to Pong! \n" + "Goal of the game is to " +
                                     "not let the ball touch your side of the screen. \n" +
                                     "You can prevent this by hitting the ball to the " +
                                     "opposite side with the your racket.\n" + "If ball hits " +
                                     "your side then opponent gets point and vice versa. \n" +
                                     "Games are up to 10!\n" + "\nBut first, you must answer " +
                                     "one question. \n" + "Your answer will decide the background " +
                                     "of the game." + "\nFailure to answer or improper grammar " +
                                     "will result in punishment!\n" + "You have been warned. Good " +
                                     "luck Gamer!\n" + "\n(Hint: If you want red " + "background " +
                                     "then simply hit cancel or the 'X' button.)\n");
        JOptionPane.showMessageDialog(null, welcome.getMessage());
        new Pong();
    }
}