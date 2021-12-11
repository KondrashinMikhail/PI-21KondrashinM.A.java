package com.company;

import javax.swing.*;
import java.awt.*;

public abstract class Wheels extends JPanel implements ITrack {
    public DopEnum numOfWheels;

    @Override
    public void setNumOfWheels(int num) {
        switch (num) {
            case 4:
                this.numOfWheels = DopEnum.four;
                break;
            case 5:
                this.numOfWheels = DopEnum.five;
                break;
            case 6:
                this.numOfWheels = DopEnum.six;
                break;
        }
    }

    public void DrawTrack(Graphics g, Color dopColor, int x, int y) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(Color.BLACK);
        g2d.fillOval(x, y + 20, 60, 20);
        g2d.setPaint(dopColor);
        g2d.fillOval(x, y + 20, 20, 20);
        g2d.fillOval(x + 40, y + 20, 20, 20);

        g2d.fillOval(x + 20, y + 30, 10, 10);
        g2d.fillOval(x + 30, y + 30, 10, 10);
    }
}
