package Lab5CabreraE;

/***********************************************
 * SE1021
 * Purpose: Sets background, displays score,
 *          assigns keys or movement
 * @author CabreraE
 * @version 1.0 Created on 4/29/2015 at 3:35 PM
 ***********************************************/

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PongPanel extends JPanel implements ActionListener, KeyListener{
    private static Pong game;
    private static Ball ball;
    private static Racket player1;
    private static Racket player2;
    private static int score1;
    private static int score2;
    private String answer;
    private Display dis;
    private ImageIcon bgImage;

    public PongPanel(Pong game){
        answer= JOptionPane.showInputDialog("What would you like your background to be?");
        if(answer == null){
            JOptionPane.showMessageDialog(null,"Red it is!");
            setBackground(Color.RED);
        }
        else
        {
            answer=answer.toLowerCase();
            switch(answer)
            {
                case "basketball":
                    bgImage=new ImageIcon("src/Lab5CabreraE/"+answer+".png");
                    break;
                case "soccer":
                    bgImage=new ImageIcon("src/Lab5CabreraE/"+answer+".png");
                    break;
                case "football":
                    bgImage=new ImageIcon("src/Lab5CabreraE/"+answer+".png");
                    break;
                default:
                    bgImage = new ImageIcon("src/Lab5CabreraE/stars.png");
                    break;
            }
        }
        this.game = game;
        ball = new Ball(game);
        player2 = new Racket(game, KeyEvent.VK_W, KeyEvent.VK_S, 0);
        player1 = new Racket(game, KeyEvent.VK_UP, KeyEvent.VK_DOWN, game.getWidth() - 20);
        if(answer!=null)
        {
            game.setVisible(false);
            dis=new Display(ball,player1,player2,game,bgImage);
            add(dis);
            game.setVisible(true);

        }
        Timer timer = new Timer(5, this);
        timer.start();
        setFocusable(true);
    }

    public Racket getPlayer(int player){
        if (player == 1)
            return player1;
        else
            return player2;
    }

    /**
     * increaseScore()
     * Determines who gets the point
     * @param player
     */

    public void increaseScore(int player){
        if (player == 1)
            score1++;
        else
            score2++;
    }

    /**
     * getScore()
     * Gets score so it can be displayed
     * @param player
     * @return score1, score 2
     */

    public int getScore(int player){
        if (player == 1)
            return score1;
        else
            return score2;
    }

    /**
     * update()
     * Updates positioning for ball,
     * player1, and player 2
     */

    private void update(){
        ball.update();
        player1.update();
        player2.update();
    }

    /**
     * actionPerformed()
     * Updates and repaints panel according
     * to the action you decided to make
     * @param e
     */

    public void actionPerformed(ActionEvent e){
        update();
        revalidate();
        repaint();
    }

    /**
     * keyPressed()
     * Reads when you press a key for movement
     * @param e
     */

    public void keyPressed(KeyEvent e){
        player1.pressed(e.getKeyCode());
        player2.pressed(e.getKeyCode());
    }

    /**
     * Reads when you release the pressed
     * key for movement
     * @param e
     */

    public void keyReleased(KeyEvent e){
        player1.released(e.getKeyCode());
        player2.released(e.getKeyCode());
    }

    public void keyTyped(KeyEvent e){
    }

    /**
     * paintComponent()
     * Paints the two rackets, ball, and score
     * on Pong panel
     * @param g
     */

    @Override
    public void paintComponent(Graphics g){
        if(dis!=null)
            dis.paintComponent(g);
        else if (answer==null){
            Font f = new Font("Verdana",Font.BOLD,30);
            g.setFont(f);
            super.paintComponent(g);
            g.drawString(game.getPanel().getScore(2) + " : " + game.getPanel().getScore(1), game.getWidth() / 2, 30);
            ball.paint(g);
            player1.paint(g);
            player2.paint(g);
        }
    }

    private class Display extends JLabel{
        private Ball ball;
        private Racket player1;
        private Racket player2;
        private Pong game;

        public Display(Ball b,Racket p1, Racket p2, Pong game,ImageIcon image){
            super(image);
            this.ball=b;
            this.player1=p1;
            this.player2=p2;
            this.game=game;
        }

        @Override
        public void paintComponent(Graphics g){
            Font f = new Font("Verdana",Font.BOLD,30);
            g.setFont(f);
            super.paintComponent(g);
            g.drawString(game.getPanel().getScore(2) + " : " + game.getPanel().getScore(1), game.getWidth() /2, 30);
            ball.paint(g);
            player1.paint(g);
            player2.paint(g);
        }
    }
}
