package com.company;

import java.awt.*;

public class BucketExcavator extends Excavator
{
    public Color DopColor;
    public boolean frontBucket;
    public boolean backBucket;

    public BucketExcavator(int maxSpeed, float weight, Color mainColor, Color dopColor,
                           boolean frontBucket, boolean backBucket)
    {
        super(maxSpeed, weight, mainColor);
        this.DopColor = dopColor;
        this.frontBucket = frontBucket;
        this.backBucket = backBucket;
    }

    @Override
    public void DrawExcavator(Graphics g)
    {
        super.DrawExcavator(g);
        Graphics2D g2d = (Graphics2D) g;

        Color mainCol = MainColor;
        Color dopCol = DopColor;

        if (frontBucket)
        {
            //Ковш
            g2d.setPaint(dopCol);
            g2d.drawLine(startPosX + 100, startPosY, startPosX + 110, startPosY + 10);
            g2d.drawLine(startPosX + 110, startPosY + 10, startPosX + 110, startPosY + 20);
            g2d.drawLine(startPosX + 110, startPosY + 20, startPosX + 100, startPosY + 30);
            g2d.drawLine(startPosX + 105, startPosY + 25, startPosX + 100, startPosY + 10);
            g2d.drawLine(startPosX + 100, startPosY, startPosX + 100, startPosY + 10);

            //Рычаг
            g2d.setPaint(mainCol);
            g2d.drawLine(startPosX + 60, startPosY + 5, startPosX + 80, startPosY - 10);
            g2d.drawLine(startPosX + 80, startPosY - 10, startPosX + 90, startPosY - 10);
            g2d.drawLine(startPosX + 90, startPosY - 10, startPosX + 100, startPosY);

            g2d.drawLine(startPosX + 60, startPosY + 5 + 15, startPosX + 80, startPosY - 10 + 10);
            g2d.drawLine(startPosX + 80, startPosY - 10 + 10, startPosX + 90, startPosY - 10 + 10);
            g2d.drawLine(startPosX + 90, startPosY - 10 + 10, startPosX + 100, startPosY + 10);

            g2d.drawLine(startPosX + 70, startPosY, startPosX + 70, startPosY + 10);
            g2d.drawLine(startPosX + 80, startPosY - 10, startPosX + 80, startPosY);
            g2d.drawLine(startPosX + 90, startPosY - 10, startPosX + 90, startPosY);
        }

        if (backBucket)
        {
            //Ковш
            g2d.setPaint(dopCol);
            g2d.drawLine(startPosX - 30, startPosY, startPosX - 40, startPosY + 10);
            g2d.drawLine(startPosX - 40, startPosY + 10, startPosX - 40, startPosY + 20);
            g2d.drawLine(startPosX - 40, startPosY + 20, startPosX - 30, startPosY + 30);
            g2d.drawLine(startPosX - 35, startPosY + 25, startPosX - 30, startPosY + 10);
            g2d.drawLine(startPosX - 30, startPosY + 10, startPosX - 30, startPosY);

            //Рычаг
            g2d.setPaint(mainCol);
            g2d.drawLine(startPosX, startPosY, startPosX - 10, startPosY - 10);
            g2d.drawLine(startPosX - 10, startPosY - 10, startPosX - 20, startPosY - 10);
            g2d.drawLine(startPosX - 20, startPosY - 10, startPosX - 30, startPosY);

            g2d.drawLine(startPosX, startPosY + 10, startPosX - 10, startPosY - 10 + 10);
            g2d.drawLine(startPosX - 10, startPosY - 10 + 10, startPosX - 20, startPosY - 10 + 10);
            g2d.drawLine(startPosX - 20, startPosY - 10 + 10, startPosX - 30, startPosY + 10);

            g2d.drawLine(startPosX - 10, startPosY - 10, startPosX - 10, startPosY);
            g2d.drawLine(startPosX - 20, startPosY - 10, startPosX - 20, startPosY);
        }
    }
}
