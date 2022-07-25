package HumansVsGoblins;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.print("Key was pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
