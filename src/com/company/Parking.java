package com.company;

import javax.swing.*;
import java.awt.*;

public class Parking<T extends ITransport, W extends ITrack> extends JPanel {
    private final T[] places;

    private final int pictureWidth;
    private final int pictureHeight;

    private final int placeSizeWidth = 210;
    private final int placeSizeHeight = 80;

    public Parking(int picWidth, int picHeight) {
        int width = picWidth / placeSizeWidth;
        int height = picHeight / placeSizeHeight;
        places = (T[]) new ITransport[width * height];
        pictureHeight = picHeight;
        pictureWidth = picWidth;
    }

    public int getPlaceSizeHeight() {
        return placeSizeHeight;
    }

    public int getPlaceSizeWidth() {
        return placeSizeWidth;
    }

    //==
    public boolean Same(Parking<T, W> parking, BucketExcavator bucketExcavator) {
        for (int i = 0; i < parking.places.length; i++) {
            if (parking.places[i] != bucketExcavator) {
                return false;
            }
        }
        return true;
    }

    //!=
    public boolean NotSame(Parking<T, W> parking, BucketExcavator bucketExcavator) {


        for (int i = 0; i < parking.places.length; i++) {
            if (parking.places[i] == bucketExcavator) {
                return false;
            }
        }
        return true;
    }

    public int plus(Parking<T, W> parking, T excavator) {
        for (int i = 0; i < parking.places.length; i++) {
            if (parking.places[i] == null) {
                parking.places[i] = excavator;
                return i;
            }
        }
        return -1;
    }

    public T minus(Parking<T, W> parking, int index) {
        T deletedExcavator;

        if (index > -1 && index < parking.places.length && parking.places[index] != null) {
            deletedExcavator = parking.places[index];
            parking.places[index] = null;
            return deletedExcavator;
        }
        return null;
    }

    public void Draw(Graphics g) {
        g.clearRect(0, 0, 900, 400);
        DrawMarking(g);
        for (T place : places) {
            if (place != null)
                place.DrawExcavator(g);
        }
    }

    public void DrawMarking(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(Color.BLACK);
        for (int i = 0; i < pictureWidth / placeSizeWidth; i++) {
            for (int j = 0; j < pictureHeight / placeSizeHeight + 1; ++j)
                g.drawLine(i * placeSizeWidth, j * placeSizeHeight, i * placeSizeWidth + placeSizeWidth / 2, j * placeSizeHeight);
            g.drawLine(i * placeSizeWidth, 0, i * placeSizeWidth, (pictureHeight / placeSizeHeight) * placeSizeHeight);
        }
    }
}
