package input;
import main.Panels;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Keyboard implements KeyListener {
    private final Panels panels;
    public Keyboard(Panels panels){
        this.panels = panels;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W -> panels.getGame().getPlayer().setUp(true);
            case KeyEvent.VK_A -> panels.getGame().getPlayer().setLeft(true);
            case KeyEvent.VK_S -> panels.getGame().getPlayer().setDown(true);
            case KeyEvent.VK_D -> panels.getGame().getPlayer().setRight(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> panels.getGame().getPlayer().setUp(false);
            case KeyEvent.VK_A -> {
                panels.getGame().getPlayer().setLeft(false);
                panels.getGame().getPlayer().setIdl(true);
            }
            case KeyEvent.VK_S -> panels.getGame().getPlayer().setDown(false);
            case KeyEvent.VK_D -> {
                panels.getGame().getPlayer().setRight(false);
                panels.getGame().getPlayer().setIdr(true);
            }
        }
    }
}
