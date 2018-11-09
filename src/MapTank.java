import javax.swing.*;
import java.awt.*;

public class MapTank {
    int bit;
    int x;
    int y;
    Image[] img = {
            new ImageIcon(getClass()
                    .getResource("/images/brick.png")).getImage(),
            new ImageIcon(getClass()
                    .getResource("/images/water.png")).getImage(),
            new ImageIcon(getClass()
                    .getResource("/images/bird.png")).getImage(),
            new ImageIcon(getClass()
                    .getResource("/images/tree.png")).getImage(),
            new ImageIcon(getClass()
                    .getResource("/images/rock.png")).getImage()
    };

    public MapTank(int bit, int x, int y) {
        this.bit = bit;
        this.x = x;
        this.y = y;
    }

    void draw(Graphics2D g2d) {
        g2d.drawImage(img[bit - 1], x, y, null);
    }

    Rectangle getRect() {
        int w = img[bit - 1].getWidth(null);
        int h = img[bit - 1].getHeight(null);
        Rectangle rect = new Rectangle(x, y, w, h);
        return rect;
    }

}
