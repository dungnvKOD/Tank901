import java.awt.*;
import java.util.ArrayList;

public class Tank {

    static final int LEFT = 0;
    static final int RIGHT = 1;
    static final int UP = 2;
    static final int DOWN = 3;

    Image[] arrImg = new Image[4];
    Image img;
    int orient;
    int speed;
    int x;
    int y;
    long t = 0;
    int timeFire;

    public Tank(int orient, int speed, int x, int y) {
        this.orient = orient;
        this.speed = speed;
        this.x = x;
        this.y = y;
    }

    void draw(Graphics2D g2d) {
        img = arrImg[orient];
        g2d.drawImage(img, x, y, null);
    }

    void move(ArrayList<MapTank> arrMap) {
        img = arrImg[orient];
        int xRaw = x;
        int yRaw = y;
        switch (orient) {
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
        }

        boolean check = checkMap(arrMap);
        if (check == false){
            x = xRaw;
            y = yRaw;
        }

        if (x<0 || y<0){
            x = xRaw;
            y = yRaw;
        }
        if (x > MyFrame.W_FRAME - img.getWidth(null)-15){
            x = MyFrame.W_FRAME - img.getWidth(null)-15;
        }
        if (y > MyFrame.H_FRAME - img.getHeight(null)-37){
            y = MyFrame.H_FRAME - img.getHeight(null)-37;
        }
    }


    boolean checkMap(ArrayList<MapTank> arrMap){
        for (MapTank map:arrMap) {
            if (map.bit == 5 || map.bit == 1){
                Rectangle rectangle =
                        getRect().intersection(map.getRect());
                if (rectangle.isEmpty() == false){
                    return false;
                }
            }
        }
        return true;
    }

    void fire(ArrayList<Bullet> arrBullet){
        long currentTime = System.currentTimeMillis();
        if (currentTime - t >= timeFire) {
            int xB = x + img.getWidth(null) / 2;
            int yB = y + img.getHeight(null) / 2;
            Bullet bullet = new Bullet(xB, yB, orient);
            arrBullet.add(bullet);
            t = currentTime;
        }
    }
    Rectangle getRect(){
        img = arrImg[orient];
        int w = img.getWidth(null);
        int h = img.getHeight(null);
        if (orient == UP || orient == DOWN){
            w-=5;
        }else{
            h -=5;
        }
        Rectangle rect = new Rectangle(x,y,w,h);
        return rect;
    }

    boolean checkDie(ArrayList<Bullet> arrBullet){
        for (int i = arrBullet.size()-1; i >= 0; i--) {
            Rectangle rect = getRect().
                    intersection(arrBullet.get(i).getRect());
            if (rect.isEmpty() == false){
                arrBullet.remove(i);
                return true;
            }
        }
        return false;
    }
}
