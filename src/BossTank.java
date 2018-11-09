import javax.swing.*;
import java.util.Random;

public class BossTank extends Tank{

    public BossTank(int speed, int x, int y) {
        super(DOWN, speed, x, y);
        timeFire = 1000;
        arrImg[0] = new ImageIcon(getClass().getResource("/images/tangta_left.png")).getImage();
        arrImg[1] = new ImageIcon(getClass().getResource("/images/tangta_right.png")).getImage();
        arrImg[2] = new ImageIcon(getClass().getResource("/images/tangta_up.png")).getImage();
        arrImg[3] = new ImageIcon(getClass().getResource("/images/tangta_down.png")).getImage();

    }


    void randomOrient(){
        Random random = new Random();
        int percent = random.nextInt(101);
        if (percent > 98) {
            orient = random.nextInt(4);
        }
    }
}
