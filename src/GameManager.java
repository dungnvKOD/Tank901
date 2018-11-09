import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameManager {

    MyTank myTank;
    ArrayList<BossTank> arrBoss = new ArrayList<>();
    ArrayList<Bullet> arrBulletBoss = new ArrayList<>();
    ArrayList<Bullet> arrBulletPlayer = new ArrayList<>();
    ArrayList<MapTank> arrMap = new ArrayList<>();

    int[][] arr = {
            {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5},
            {5, 0, 0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0, 0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0, 0, 5},
            {5, 0, 0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0, 0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0, 0, 5},
            {5, 4, 4, 4, 4, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 4, 4, 4, 4, 5},
            {5, 4, 4, 4, 4, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 4, 4, 4, 4, 5},
            {5, 4, 4, 4, 4, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 4, 4, 4, 4, 5},
            {5, 4, 4, 4, 4, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 4, 4, 4, 4, 5},
            {5, 4, 4, 4, 4, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 4, 4, 4, 4, 5},
            {5, 4, 4, 4, 4, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 4, 4, 4, 4, 5},
            {5, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 4, 4, 4, 4, 5},
            {5, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 4, 4, 4, 4, 5},
            {5, 4, 4, 4, 4, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 4, 4, 4, 4, 5},
            {5, 4, 4, 4, 4, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 4, 4, 4, 4, 5},
            {5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5},
            {5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5},
            {5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5},
            {5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5},
            {5, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 5},
            {5, 2, 2, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 2, 2, 5},
            {5, 2, 2, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 2, 2, 5},
            {5, 2, 2, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 2, 2, 5},
            {5, 2, 2, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 2, 2, 5},
            {5, 2, 2, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 2, 2, 5},
            {5, 2, 2, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 2, 2, 5},
            {5, 2, 2, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 3, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 2, 2, 5},
            {5, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 5},
            {5, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 5},
            {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}
    };

    void initGame() {
        arrBulletPlayer.clear();
        arrBulletBoss.clear();
        arrBoss.clear();
        arrMap.clear();
        myTank = new MyTank(1, 190, 480, 1);
        initBoss();
        readMap();
        SoundManager.play("enter_game.wav");
    }

    void readMap() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (arr[i][j] != 0) {
                    int x = j * 19;
                    int y = i * 19;
                    MapTank mapTank = new MapTank(arr[i][j], x, y);
                    arrMap.add(mapTank);
                }
            }
        }
    }

    void initBoss() {
        BossTank bossTank = new BossTank(1, 20, 20);
        arrBoss.add(bossTank);
        BossTank bossTank1 = new BossTank(1, 250, 20);
        arrBoss.add(bossTank1);
        BossTank bossTank2 = new BossTank(1, 478, 20);
        arrBoss.add(bossTank2);
    }

    void draw(Graphics2D g2d) {
        try {
            for (MapTank mapTank : arrMap) {
                mapTank.draw(g2d);
            }
            for (Bullet b : arrBulletBoss) {
                b.draw(g2d);
            }
            for (Bullet b : arrBulletPlayer) {
                b.draw(g2d);
            }

            myTank.draw(g2d);
            for (BossTank boss : arrBoss) {
                boss.draw(g2d);
            }
        } catch (Exception ex) {
        }
    }

    void moveMyTank(int newOrient) {
        myTank.changeOrient(newOrient);
        myTank.move(arrMap);
    }

    void fireMyTank() {
        myTank.fire(arrBulletPlayer);
    }

    void AI() {
        for (int i = arrBoss.size() - 1; i >= 0; i--) {
            arrBoss.get(i).randomOrient();
            arrBoss.get(i).move(arrMap);
            arrBoss.get(i).fire(arrBulletBoss);
            boolean check = arrBoss.get(i).checkDie(arrBulletPlayer);
            if (check == true) {
                arrBoss.remove(i);
                if (arrBoss.size() <= 2) {
                    initBoss();
                }
            }
        }
        boolean checkDie = myTank.checkDie(arrBulletBoss);
        if (checkDie == true) {
            myTank.mang = myTank.mang - 1;
            if (myTank.mang < 0) {
                gameOver();
                return;
            }
        }
        boolean check = moveBullet(arrBulletBoss);
        if (check == false) {
            moveBullet(arrBulletPlayer);
        }
    }

    boolean moveBullet(ArrayList<Bullet> arr) {
        for (int i = arr.size() - 1; i >= 0; i--) {
            arr.get(i).move();
            int bit = checkMap(arr.get(i));
            if (bit == 3) {
                return true;
            }
            if (bit == 1 || bit == 3 || bit == 5) {
                arr.remove(i);
            }
        }
        return false;
    }

    void gameOver() {
        int result = JOptionPane.showConfirmDialog
                (null, "Do you want replay?"
                        , "Game over", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            initGame();
        } else {
            System.exit(0);
        }
    }

    int checkMap(Bullet bullet) {
        for (int i = arrMap.size() - 1; i >= 0; i--) {
            int bit = arrMap.get(i).bit;
            Rectangle rectangle = bullet.getRect()
                    .intersection(arrMap.get(i).getRect());
            if (rectangle.isEmpty() == false) {
                if (bit == 3) {
                    arrMap.remove(i);
                    gameOver();
                }
                if (bit == 1) {
                    arrMap.remove(i);
                }
                return bit;
            }
        }
        return 0;
    }
}
