import javax.swing.*;
import java.awt.*;

public class Bullet {
    int x;
    int y;
    int orient;
    Image img = new ImageIcon(getClass()
            .getResource("/images/tree.png")).getImage();


    public Bullet(int x, int y, int orient) {
        this.x = x - img.getWidth(null) / 2;
        this.y = y - img.getHeight(null) / 2;
        this.orient = orient;
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(img, x, y, null);
    }

    boolean move() {
        switch (orient) {
            case Tank.LEFT:
                x -= 2;
                break;
            case Tank.RIGHT:
                x += 2;
                break;
            case Tank.UP:
                y -= 2;
                break;
            case Tank.DOWN:
                y += 2;
                break;
        }
        if (x < 0 || y < 0 || x > MyFrame.W_FRAME || y > MyFrame.H_FRAME) {
            return true;
        } else {
            return false;
        }
    }

    Rectangle getRect(){
        int w = img.getWidth(null);
        int h = img.getHeight(null);
        Rectangle rect = new Rectangle(x,y,w,h);
        return rect;
    }
}
