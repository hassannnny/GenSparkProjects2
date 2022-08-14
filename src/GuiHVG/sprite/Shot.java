package GuiHVG.sprite;

import javax.swing.*;
import javax.swing.ImageIcon;

public class Shot extends Sprite{

    public Shot() {
    }

    public Shot(int x, int y) {

        initShot(x, y);
    }

    private void initShot(int x, int y) {

        var shotImg = "src/Images/44-446143_number-3-png-black-number-3-transparent-png.png";
        var ii = new ImageIcon(shotImg);
        setImage(ii.getImage());

        int H_SPACE = 6;
        setX(x + H_SPACE);

        int V_SPACE = 1;
        setY(y - V_SPACE);
    }

}
