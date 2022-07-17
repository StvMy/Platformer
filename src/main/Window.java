package main;
import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class Window{

    public Window(Panels panels){
        JFrame jframe = new JFrame();
        jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
        jframe.add(panels);
        jframe.setResizable(false);
        jframe.pack();
        jframe.setVisible(true);
        jframe.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {

            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                panels.getGame().windowFocuslost();
            }
        });
    }
}

