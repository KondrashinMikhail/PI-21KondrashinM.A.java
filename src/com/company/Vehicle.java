package com.company;

import javax.swing.*;
import java.awt.*;

public abstract class Vehicle extends JPanel implements ITransport {
    protected int startPosX;
    protected int startPosY;
    protected int pictureWidth;
    protected int pictureHeight;
    public int MaxSpeed;
    public float Weight;
    public Color MainColor;

    @Override
    public void SetPosition(int x, int y, int width, int height) {
        startPosX = x;
        startPosY = y;
        pictureWidth = width;
        pictureHeight = height;
    }

    public abstract void MoveExcavator(Direction direction);

    public abstract void DrawExcavator(Graphics g);
}
