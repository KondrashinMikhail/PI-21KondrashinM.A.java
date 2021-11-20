package com.company;

import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;

public class Excavator extends JPanel
{
    private int startPosX;
    private int startPosY;

    private int _pictureWidth;
    private int _pictureHeight;

    private final int excavatorWidth = 110;
    private final int excavatorHeight = 60;

    public int MaxSpeed;
    public int Weight;
    public Color MainColor;
    public Color DopColor;
    public boolean FrontBucket;
    public boolean BackBucket;
    public int NumOfWheels;
    Track track;

    public void Init(int maxSpeed, int weight, Color mainColor, Color dopColor, boolean frontBucket, boolean backBucket, int numOfWheels)
    {
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
        DopColor = dopColor;
        FrontBucket = frontBucket;
        BackBucket = backBucket;
        NumOfWheels = numOfWheels;
    }

    public void setPosition(int x, int y, int width, int height)
    {
        startPosX = x;
        startPosY = y;
        _pictureWidth = width;
        _pictureHeight = height;
    }

    public void MoveExcavator(Direction direction)
    {
        int step = MaxSpeed * 100 / Weight;
        switch(direction)
        {
            case Up:
                if (startPosY > 0)
                    startPosY -= step;
                break;
            case Down:
                if (startPosY + step < _pictureHeight - excavatorHeight)
                    startPosY += step;
                break;
            case Left:
                if (startPosX > 0)
                    startPosX -= step;
                break;
            case Right:
                if (startPosX + step < _pictureWidth - excavatorWidth)
                    startPosX += step;
                break;
        }

        super.repaint();
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(_pictureWidth, _pictureHeight);
    }

    public int getExcavatorWidth(){
        return excavatorWidth;
    }

    public int getExcavatorHeight(){
        return excavatorHeight;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        Color mainCol = MainColor;
        Color dopCol = DopColor;
        Color blue = new Color(0, 255, 255);

        track = new Track(dopCol, startPosX, startPosY);
        track.setNumOfWheels(NumOfWheels);

        if (FrontBucket)
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

        if (BackBucket)
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

        //Кузов
        g2d.setPaint(dopCol);
        g2d.fillRect(startPosX + 40, startPosY, 20, 20);
        g2d.setPaint(mainCol);
        g2d.fillRect(startPosX, startPosY, 40, 20);

        //Кабина
        g2d.setPaint(blue);
        g2d.fillRect(startPosX + 40, startPosY - 20, 20, 20);

        track.paintComponent(g);
    }
}
