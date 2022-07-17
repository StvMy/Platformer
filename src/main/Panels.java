package main;

import input.Mouse;
import input.Keyboard;
import java.awt.*;
import javax.swing.*;


public class Panels extends JPanel{
    private Game game;
    public Panels(Game game){
        this.game=game;
        setPanelsize();
        Keyboard keyboard = new Keyboard(this);
        addKeyListener(keyboard);
        Mouse mouse = new Mouse(this);
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
    }
    private void setPanelsize(){
        Dimension size = new Dimension(1600,600);
        setPreferredSize(size);
    }
    public void paint(Graphics g){
        super.paintComponent(g);
        game.render(g);
    }

    public Game getGame() {
        return game;
    }
}
