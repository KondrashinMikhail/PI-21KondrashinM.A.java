package com.company;

import java.awt.*;
import java.awt.Graphics;
import java.util.Random;

public class Excavator extends Vehicle {
    private int excavatorWidth = 110;
    private int excavatorHeight = 60;
    ITrack track;

    public Excavator(int maxSpeed, float weight, Color mainColor) {
        this.MaxSpeed = maxSpeed;
        this.Weight = weight;
        this.MainColor = mainColor;
        int ID = new Random().nextInt(3);
        int numOfWheels = new Random().nextInt(3) + 4;
        setTrackType(ID, numOfWheels);
    }

    public Excavator(int maxSpeed, float weight, Color mainColor, int ID, int numOfWheels) {
        this.MaxSpeed = maxSpeed;
        this.Weight = weight;
        this.MainColor = mainColor;
        setTrackType(ID, numOfWheels);
    }

    public void setTrackType(int ID, int numOfWheels) {
        switch (ID) {
            case 0:
                track = new Track();
                break;
            case 1:
                track = new CircleTrack();
                break;
            case 2:
                track = new DoubleLineTrack();
                break;
        }
        track.setNumOfWheels(numOfWheels);
    }

    @Override
    public void DrawExcavator(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        //Color mainCol = MainColor;
        Color blue = new Color(0, 255, 255);

        //Кузов
        g2d.fillRect(startPosX + 40, startPosY, 20, 20);
        g2d.setPaint(MainColor);
        g2d.fillRect(startPosX, startPosY, 40, 20);

        //Кабина
        g2d.setPaint(blue);
        g2d.fillRect(startPosX + 40, startPosY - 20, 20, 20);

        track.DrawTrack(g, Color.GRAY, startPosX, startPosY);
    }

    @Override
    public void MoveExcavator(Direction direction) {
        float step = MaxSpeed * 100 / Weight;
        switch (direction) {
            case Up:
                if (startPosY > 0) {
                    startPosY -= step;
                }
                break;
            case Down:
                if (startPosY + step < pictureHeight - excavatorHeight) {
                    startPosY += step;
                }
                break;
            case Left:
                if (startPosX > 0) {
                    startPosX -= step;
                }
                break;
            case Right:
                if (startPosX + step < pictureWidth - excavatorWidth) {
                    startPosX += step;
                }
                break;
        }
    }

    public void setMainColor(Color mainColor) {
        MainColor = mainColor;
    }

    public Dimension getPreferredSize() {
        return new Dimension(pictureWidth, pictureHeight);
    }
}
