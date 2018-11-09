import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.BitSet;

import javax.swing.JPanel;


public class MyPanel extends JPanel {
    BitSet bitSet = new BitSet(256);
    GameManager manager = new GameManager();

    public MyPanel(){
        setBackground(Color.BLACK);
        manager.initGame();

        setFocusable(true);
        addKeyListener(keyListener);

        Thread thread = new Thread(runnable);
        thread.start();

    }

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        super.paintComponent(g2d);

        manager.draw(g2d);
    }

    KeyListener keyListener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e){

        }

        @Override
        public void keyPressed(KeyEvent e){
            bitSet.set(e.getKeyCode());
        }

        @Override
        public void keyReleased(KeyEvent e){
            bitSet.clear(e.getKeyCode());
        }
    };

    Runnable runnable = new Runnable() {
        @Override
        public void run(){
            while (true) {
                if (bitSet.get(KeyEvent.VK_LEFT) == true) {
                    manager.moveMyTank(Tank.LEFT);
                } else if (bitSet.get(KeyEvent.VK_RIGHT) == true) {
                    manager.moveMyTank(Tank.RIGHT);
                } else if (bitSet.get(KeyEvent.VK_UP) == true) {
                    manager.moveMyTank(Tank.UP);
                } else if (bitSet.get(KeyEvent.VK_DOWN) == true) {
                    manager.moveMyTank(Tank.DOWN);
                }
                if (bitSet.get(KeyEvent.VK_SPACE) == true) {
                    manager.fireMyTank();
                }
                manager.AI();
                repaint();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

}
