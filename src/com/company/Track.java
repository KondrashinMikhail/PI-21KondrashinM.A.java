package com.company;

import java.awt.*;

public class Track extends Wheels {
    @Override
    public void DrawTrack(Graphics g, Color dopColor, int x, int y) {
        super.DrawTrack(g, dopColor, x, y);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(dopColor);

        switch (numOfWheels) {
            case five:
                g2d.fillOval(x + 25, y + 20, 10, 10);
                break;
            case six:
                g2d.fillOval(x + 20, y + 20, 10, 10);
                g2d.fillOval(x + 30, y + 20, 10, 10);
                break;
        }
    }
}
