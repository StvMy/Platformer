package entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import static util.Constants.PlayerConstants.*;

public class Player extends Entity{
    private double x = 40;
    private double y = 50;
    private boolean left,right,up,down,move,idl,idr;
    private boolean attack=false,jump=false;
    int playeract;
    BufferedImage[][] ani = new BufferedImage[14][8];
    int aniTick,aniIndex,speed = 15;

    public Player(double x, double y) {
        super(x, y);
        loadAni();
    }
    public void update(){
        updatePos();
        updateTick();
        setAni();
    }
    public void render(Graphics g){
        g.drawImage(ani[playeract][aniIndex], (int) x-15,(int) y-35,60,68,null);
    }
    private void loadAni()  {
        InputStream is = getClass().getResourceAsStream("/resos/mergev_reverse_run_idle.png");
        assert is != null;
        try {
            BufferedImage img = ImageIO.read(is);
            for (int i = 0; i < ani.length; i++) {
                for (int j = 0; j < ani[i].length ; j++) {
                    ani[i][j] = img.getSubimage(j*48,i*48,48,48);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void updateTick() {
        aniTick++;
        if (aniTick>=speed){
            aniTick=0;
            aniIndex++;
            if (aniIndex >= GetSpriteAmount(playeract)){
                aniIndex=0;
                attack=false;
                jump=false;
            }
        }
    }

    public void setIdl(boolean idl) {
        this.idl = idl;
    }

    public void setIdr(boolean idr) {
        this.idr = idr;
    }

    public void setJump(boolean jump) {
        this.jump = jump;
    }

    private void setAni(){
        if ((up&&!down)||(down&&!up)){
            playeract =CLIMB;
            idl=false;
            idr=false;
        }
        else if (left&&!right){
            playeract =RUNNINGL;
            idl=false;
            idr=false;
        }
        else if (right&&!left){
            playeract =RUNNINGR;
            idl=false;
            idr=false;
        }
        else if (!move&&idl){
            playeract =IDLEL;
        }
        else if(!move&&idr){
            playeract=IDLER;
        }
        else{
            playeract=IDLER;
        }
        if (attack){
            playeract=PUNCH;
        }
        if (jump){
            playeract=JUMP;
            noAni();
        }

    }

    public boolean isJump() {
        return jump;
    }

    private void noAni() {
        left=false;
        up=false;
        down=false;
        right=false;
    }

    public void updatePos(){
        move=false;
        if (left&&!right){
            x-=3;
            move=true;
        }
        else if (!left&&right){
            x+=3;
            move=true;
        }
        if (up&&!down){
            y-=1;
            move=true;
        }
        else if (!up&&down){
            y+=1;
            move=true;
        }
    }
    public void rectpos(int x, int y){
        this.x=x;
        this.y=y;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }
    public void setMove(boolean move){
        this.move=move;
    }
    public void resetBool(){
        left=false;
        up=false;
        down=false;
        right=false;
        move=false;
    }
    public void setAttack(boolean attack){
        this.attack=attack;
    }
}
