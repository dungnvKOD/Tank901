import javax.swing.*;

public class MyTank extends Tank{
    int mang;

    public MyTank(int speed, int x, int y, int mang) {
        super(UP, speed, x, y);
        this.mang = mang;
        timeFire = 500;
        arrImg[0] = new ImageIcon(getClass()
                .getResource("/images/tangta_left.png")).getImage();
        arrImg[1] = new ImageIcon(getClass()
                .getResource("/images/tangta_right.png")).getImage();
        arrImg[2] = new ImageIcon(getClass()
                .getResource("/images/tangta_up.png")).getImage();
        arrImg[3] = new ImageIcon(getClass()
                .getResource("/images/tangta_down.png")).getImage();

    }


    void changeOrient(int newOrient){
        orient = newOrient;
    }
}
