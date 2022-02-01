package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Parking<T extends ITransport, W extends ITrack> extends JPanel {
    private final ArrayList<T> places;

    private final int maxCount = 24;

    private final int pictureWidth;
    private final int pictureHeight;

    private final int placeSizeWidth = 210;
    private final int placeSizeHeight = 80;

    private final int parkPlacesWidth = 5;

    private String name;

    public Parking(int picWidth, int picHeight) {
        int width = picWidth / placeSizeWidth;
        int height = picHeight / placeSizeHeight;
        places = new ArrayList<>();
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
        for (int i = 0; i < parking.places.size(); i++) {
            if (parking.places.get(i) != bucketExcavator) {
                return false;
            }
        }
        return true;
    }

    //!=
    public boolean NotSame(Parking<T, W> parking, BucketExcavator bucketExcavator) {


        for (int i = 0; i < parking.places.size(); i++) {
            if (parking.places.get(i) == bucketExcavator) {
                return false;
            }
        }
        return true;
    }

    public int plus(Parking<T, W> parking, T excavator) {
        if (parking.maxCount <= parking.places.size())
            return -1;

        for (int i = 0; i < parking.places.size() + 1; i++) {
            parking.places.add(excavator);
            return parking.places.indexOf(excavator);
        }
        return -1;
    }

    public T minus(Parking<T, W> parking, int index) {
        T deletedExcavator;

        if (index > -1 && index < parking.places.size() && parking.places.get(index) != null) {
            deletedExcavator = parking.places.get(index);
            parking.places.remove(index);
            return deletedExcavator;
        }
        return null;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name){
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }

    public void Draw(Graphics g) {
        g.clearRect(0, 0, 700, 600);
        for (int i = 0; i < places.size(); i++){
            if (places.get(i) != null){
                places.get(i).SetPosition(i / 8 * placeSizeWidth + 45, i % 8 * placeSizeHeight + 30, pictureWidth, pictureHeight);
                places.get(i).DrawExcavator(g);
            }
        }
        DrawMarking(g);
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
    public T indexator(int index){
        if (index > -1 && index < places.size())
            return places.get(index);
        return null;
    }
}
