package com.company;

import java.awt.*;

public class CircleTrack extends Wheels
{
    @Override
    public void DrawTrack(Graphics g, Color dopColor, int x, int y){

        super.DrawTrack(g, dopColor, x, y);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.BLACK);

        g2d.fillOval(x + 4, y + 24, 12, 12);
        g2d.fillOval(x + 44, y + 24, 12, 12);

        g2d.fillOval(x + 22, y + 32, 6, 6);
        g2d.fillOval(x + 32, y + 32, 6, 6);

        switch(numOfWheels)
        {
            case five:
                g2d.setPaint(dopColor);
                g2d.fillOval(x + 25, y + 20, 10, 10);
                g2d.setPaint(Color.BLACK);
                g2d.fillOval(x + 27, y + 22, 6, 6);
                break;
            case six:
                g2d.setPaint(dopColor);
                g2d.fillOval(x + 20, y + 20, 10, 10);
                g2d.fillOval(x + 30, y + 20, 10, 10);
                g2d.setPaint(Color.BLACK);
                g2d.fillOval(x + 22, y + 22, 6, 6);
                g2d.fillOval(x + 32, y + 22, 6, 6);
                break;
        }
    }
}
