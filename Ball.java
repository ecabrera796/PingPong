package Lab5CabreraE;

/***********************************************
 * SE1021
 * Purpose: Creates the ball used in the game,
 *          dictates the movement of ball and
 *          how score is kept
 * @author CabreraE
 * @version 1.0 Created on 4/29/2015 at 3:36 PM
 ***********************************************/

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JOptionPane;

public class Ball{
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;
    private Pong game;
    private int x;
    private int y;
    private int xa = 2;
    private int ya = 2;

    /**
     * Ball()
     * Constructor to set up grid for
     * movement
     * @param game
     */

    public Ball(Pong game){
        this.game = game;
        x = game.getWidth() / 2;
        y = game.getHeight() / 2;
    }

    /**
     * update()
     * Dictates ball movement and when
     * scoring happens
     */

    public void update(){
        x += xa;
        y += ya;
        if (x < 0){
            game.getPanel().increaseScore(1);
            x = game.getWidth() / 2;
            xa = -xa;
        }
        else if (x > game.getWidth() - WIDTH - 7){
            game.getPanel().increaseScore(2);
            x = game.getWidth() / 2;
            xa = -xa;
        }
        else if (y < 0 || y > game.getHeight() - HEIGHT - 29)
            ya = -ya;
        if (game.getPanel().getScore(2) == 10){
            JOptionPane.showMessageDialog(null, "Player 1 wins", "Pong", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }
        else if (game.getPanel().getScore(1) == 10){
            JOptionPane.showMessageDialog(null, "Player 2 wins", "Pong", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }
        checkCollision();
    }

    /**
     * checkCollision()
     * Checks if ball has collided on edges
     * of screen
     */

    public void checkCollision(){
        if (game.getPanel().getPlayer(1).getBounds().intersects(getBounds()) ||
                game.getPanel().getPlayer(2).getBounds().intersects(getBounds()))
            xa = -xa;
    }

    /**
     * getBounds()
     * Calls to get the "inbound" area
     * of the Pong panel
     * @return x, y, WIDTH, HEIGTH
     */

    public Rectangle getBounds(){
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    /**
     * paint()
     * Sets boundaries for the graphics in
     * Pong panel
     * @param g
     */

    public void paint(Graphics g){
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
}