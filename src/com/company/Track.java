package com.company;

import javax.swing.*;
import java.awt.*;

public class Track extends JPanel
{
    private DopEnum numOfWheels;
    private final Color DopColor;
    private final int startPosX;
    private final int startPosY;

    public Track (Color dopCol, int StartPosX, int StarPosY)
    {
        DopColor = dopCol;
        startPosX = StartPosX;
        startPosY = StarPosY;
    }

    public void setNumOfWheels(int num)
    {
        switch(num)
        {
            case 4:
                numOfWheels = DopEnum.four;
                break;
            case 5:
                numOfWheels = DopEnum.five;
                break;
            case 6:
                numOfWheels = DopEnum.six;
                break;
        }
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        Color grey = Color.GRAY;

        g2d.setPaint(DopColor);
        g2d.fillOval(startPosX, startPosY + 20, 60, 20);
        g2d.setPaint(grey);
        g2d.fillOval(startPosX, startPosY + 20, 20, 20);
        g2d.fillOval(startPosX + 40, startPosY + 20, 20, 20);

        g2d.fillOval(startPosX + 20, startPosY + 30, 10, 10);
        g2d.fillOval(startPosX + 30, startPosY + 30, 10, 10);

        switch(numOfWheels)
        {
            case five:
                g2d.fillOval(startPosX + 25, startPosY + 20, 10, 10);
                break;
            case six:
                g2d.fillOval(startPosX + 20, startPosY + 20, 10, 10);
                g2d.fillOval(startPosX + 30, startPosY + 20, 10, 10);
                break;
        }

    }
}
