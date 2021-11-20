package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ExcavatorForm
{
    public JButton left;
    public JButton right;
    public JButton up;
    public JButton down;
    public JButton create;
    Graphics g;

    public ExcavatorForm() throws IOException {
        Excavator excavator = new Excavator();
        Random random = new Random();

        JFrame frame = new JFrame("Excavator form");
        frame.setSize(1000, 600);
        JPanel panel = new JPanel();
        panel.setLayout(null);

        BufferedImage leftIcon = ImageIO.read(new File("/F:/img/arrowLeft.jpg"));
        left = new JButton(new ImageIcon(leftIcon));
        left.setBounds(780, 440, 30, 30);
        left.setBorder(BorderFactory.createEmptyBorder());
        left.addActionListener(e -> {
            excavator.MoveExcavator(Direction.Left);
            panel.repaint();
        });


        BufferedImage downIcon = ImageIO.read(new File("/F:/img/arrowDown.jpg"));
        down = new JButton(new ImageIcon(downIcon));
        down.setBounds(820, 440, 30, 30);
        down.setBorder(BorderFactory.createEmptyBorder());
        down.addActionListener(e -> {
            excavator.MoveExcavator(Direction.Down);
            panel.repaint();
        });

        BufferedImage rightIcon = ImageIO.read(new File("/F:/img/arrowRight.jpg"));
        right = new JButton(new ImageIcon(rightIcon));
        right.setBounds(860, 440, 30, 30);
        right.setBorder(BorderFactory.createEmptyBorder());
        right.addActionListener(e -> {
            excavator.MoveExcavator(Direction.Right);
            panel.repaint();
        });

        BufferedImage upIcon = ImageIO.read(new File("/F:/img/arrowUp.jpg"));
        up = new JButton(new ImageIcon(upIcon));
        up.setBounds(820, 400, 30, 30);
        up.setBorder(BorderFactory.createEmptyBorder());
        up.addActionListener(e -> {
            excavator.MoveExcavator(Direction.Up);
            panel.repaint();
        });

        create = new JButton("Create");
        create.setBounds(10, 440, 100, 30);
        create.addActionListener(e -> {
            int numOfWheels = random.nextInt(3) + 4;
            excavator.Init(100, 2000, Color.ORANGE, Color.BLACK, true, true, numOfWheels);
            excavator.setPosition(random.nextInt(frame.getWidth()), random.nextInt(frame.getHeight()), frame.getWidth(), frame.getHeight());

            excavator.setSize(excavator.getPreferredSize());
            panel.add(excavator);
            panel.repaint();
        });

        panel.add(left);
        panel.add(down);
        panel.add(right);
        panel.add(up);
        panel.add(create);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
