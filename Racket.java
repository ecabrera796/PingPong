package Lab5CabreraE;

/***********************************************
 * SE1021
 * Purpose: Sets up the Racket that is used and
 *          dictates the movement when key is
 *          pressed
 * @author CabreraE
 * @version 1.0 Created on 4/29/2015 at 3:36 PM
 ***********************************************/

import java.awt.Rectangle;
import java.awt.Graphics;

public class Racket{
    private static final int WIDTH = 10;
    private static final int HEIGHT = 100;
    private Pong game;
    private boolean bup;
    private boolean bdown;
    private int up;
    private int down;
    private int x;
    private int y;

    public Racket(Pong game, int up, int down, int x){
        this.game = game;
        this.x = x;
        y = game.getHeight() / 2;
        this.up = up;
        this.down = down;
    }

    public void update() {
        if (y > 0 && y < game.getHeight() - HEIGHT - 29){
            if(bup) y += Pong.RACKET_UP;
            if(bdown) y += Pong.RACKET_DOWN;}
        else if (y <= 0)
            y = 1;
        else if(y >= 360)
            y = game.getHeight() - 130;
        else if (y >= game.getHeight() - HEIGHT - 29)
            y = game.getHeight() - HEIGHT/2;
    }

    public void pressed(int keyCode){
        if (keyCode == up)
            bup = true;
        else if (keyCode == down)
            bdown = true;
    }

    public void released(int keyCode){
        if (keyCode == up)
            bup = false;
        else if (keyCode == down)
            bdown = false;
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public void paint(Graphics g){
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
}