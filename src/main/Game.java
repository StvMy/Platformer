package main;

import entities.Player;

import java.awt.*;

public class Game implements Runnable {
    private final Panels panels;
    private Player player;

    public Game(){
        initClasses();
        panels = new Panels(this);
        Window window = new Window(panels);
        panels.setFocusable(true);
        panels.requestFocus();
        startGame();
    }

    private void initClasses() {
        player = new Player(200,200);
    }

    private void startGame(){
        Thread gameThread = new Thread(this);
        gameThread.start();
    }
    public void update(){
        player.update();
    }
    public void render(Graphics g){
        player.render(g);
    }

    @Override
    public void run() {

        int FPS_SET = 120;
        double tpf = 1000000000.0 / FPS_SET;
        double tpu = 1000000000.0 / FPS_SET;
        long previousTime = System.nanoTime();
        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;

        while(true){
            long currentTime = System.nanoTime();

            deltaU+=(currentTime - previousTime) / tpu;
            deltaF+=(currentTime - previousTime) / tpf;
            previousTime = currentTime;

            if(deltaU>=1){
                update();
                updates++;
                deltaU--;
            }
            if (deltaF>=1){
                panels.repaint();
                frames++;
                deltaF--;
            }
            if (System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: "+frames +"|UPS: "+ updates);
                updates=0;
                frames=0;
            }

        }
    }
    public Player getPlayer(){
        return player;
    }

    public void windowFocuslost() {
        player.resetBool();
    }
}
