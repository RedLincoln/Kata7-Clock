package View;

import Clock.Point;

import javax.swing.*;
import java.awt.*;

public class ModelDisplay extends JPanel {
    private static final double secLength = 150;
    private static final double minLength = 120;
    private static final double houLength = 100;
    private int ox;
    private int oy;
    private Point[] timeCoors =  new Point[3];

    public ModelDisplay() {
        this.setFocusable(true);
    }
    
    public void updateTime(Point[] time){
        System.arraycopy(time, 0, this.timeCoors, 0, time.length);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0,0,getWidth(), getHeight());
        g.setColor(Color.WHITE);
        ox = getWidth() / 2;
        oy = getHeight() / 2;
        try {
            g.drawLine(ox, oy, (int) (ox + secLength * timeCoors[0].getX())
                    , (int) (oy + secLength * timeCoors[0].getY()));
            g.setColor(Color.RED);
            g.drawLine(ox, oy, ox + (int) (minLength * timeCoors[1].getX()),
                    oy + (int) (minLength * timeCoors[1].getY()));
            g.setColor(Color.BLUE);
            g.drawLine(ox, oy, ox + (int) (houLength * timeCoors[2].getX()),
                    oy + (int) (houLength * timeCoors[2].getY()));
        }catch(Exception e){ }
    }
}

