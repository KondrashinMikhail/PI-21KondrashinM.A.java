package com.company;

import java.awt.*;

public class DoubleLineTrack extends Wheels {
    @Override
    public void DrawTrack(Graphics g, Color dopColor, int x, int y) {

        super.DrawTrack(g, dopColor, x, y);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.BLACK);

        g2d.drawLine(x + 10, y + 20, x + 10, y + 40);
        g2d.drawLine(x, y + 30, x + 20, y + 30);

        g2d.drawLine(x + 50, y + 20, x + 50, y + 40);
        g2d.drawLine(x + 40, y + 30, x + 60, y + 30);

        g2d.drawLine(x + 25, y + 30, x + 25, y + 40);
        g2d.drawLine(x + 20, y + 35, x + 30, y + 35);

        g2d.drawLine(x + 35, y + 40, x + 35, y + 30);
        g2d.drawLine(x + 30, y + 35, x + 40, y + 35);

        switch (numOfWheels) {
            case five:
                g2d.setPaint(dopColor);
                g2d.fillOval(x + 25, y + 20, 10, 10);
                g2d.setPaint(Color.BLACK);
                g2d.drawLine(x + 30, y + 20, x + 30, y + 30);
                g2d.drawLine(x + 25, y + 25, x + 35, y + 25);
                break;
            case six:
                g2d.setPaint(dopColor);
                g2d.fillOval(x + 20, y + 20, 10, 10);
                g2d.fillOval(x + 30, y + 20, 10, 10);
                g2d.setPaint(Color.BLACK);
                g2d.drawLine(x + 25, y + 20, x + 25, y + 30);
                g2d.drawLine(x + 20, y + 25, x + 30, y + 25);

                g2d.drawLine(x + 35, y + 20, x + 35, y + 30);
                g2d.drawLine(x + 30, y + 25, x + 40, y + 25);
                break;
        }
    }
}

