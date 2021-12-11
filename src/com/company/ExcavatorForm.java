package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ExcavatorForm extends JPanel {
    public JButton left;
    public JButton right;
    public JButton up;
    public JButton down;
    public JButton createUsualExcavator;
    public JButton createBucketExcavator;
    private Vehicle excavator;

    public ExcavatorForm() throws IOException {
        Random random = new Random();

        JFrame frame = new JFrame("Excavator form");
        frame.setSize(910, 550);

        Container container = frame.getContentPane();

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null);

        BufferedImage leftIcon = ImageIO.read(new File("./src/img/arrowLeft.png"));
        left = new JButton(new ImageIcon(leftIcon));
        left.setBounds(780, 440, 30, 30);
        left.setBorder(BorderFactory.createEmptyBorder());
        left.addActionListener(e -> {
            excavator.MoveExcavator(Direction.Left);
            Draw();
        });


        BufferedImage downIcon = ImageIO.read(new File("./src/img/arrowDown.png"));
        down = new JButton(new ImageIcon(downIcon));
        down.setBounds(820, 440, 30, 30);
        down.setBorder(BorderFactory.createEmptyBorder());
        down.addActionListener(e -> {
            excavator.MoveExcavator(Direction.Down);
            Draw();
        });

        BufferedImage rightIcon = ImageIO.read(new File("./src/img/arrowRight.png"));
        right = new JButton(new ImageIcon(rightIcon));
        right.setBounds(860, 440, 30, 30);
        right.setBorder(BorderFactory.createEmptyBorder());
        right.addActionListener(e -> {
            excavator.MoveExcavator(Direction.Right);
            Draw();
        });

        BufferedImage upIcon = ImageIO.read(new File("./src/img/arrowUp.png"));
        up = new JButton(new ImageIcon(upIcon));
        up.setBounds(820, 400, 30, 30);
        up.setBorder(BorderFactory.createEmptyBorder());
        up.addActionListener(e -> {
            excavator.MoveExcavator(Direction.Up);
            Draw();
        });

        createUsualExcavator = new JButton("Create usual excavator");
        createUsualExcavator.setBounds(10, 410, 200, 30);
        createUsualExcavator.addActionListener(e -> {
            excavator = new Excavator(random.nextInt(100), random.nextInt(2000), Color.ORANGE);
            excavator.setBounds(0, 0, 910, 400);
            excavator.SetPosition(random.nextInt(frame.getWidth() - 100), random.nextInt(frame.getHeight() - 200), frame.getWidth(), frame.getHeight() - 120);
            container.add(excavator);
            Draw();
        });

        createBucketExcavator = new JButton("Create bucket excavator");
        createBucketExcavator.setBounds(10, 450, 200, 30);
        createBucketExcavator.addActionListener(e -> {
            excavator = new BucketExcavator(random.nextInt(100), random.nextInt(2000), Color.ORANGE, Color.GRAY, true, true);
            excavator.setBounds(0, 0, 910, 400);
            excavator.SetPosition(random.nextInt(frame.getWidth() - 100), random.nextInt(frame.getHeight() - 200), frame.getWidth(), frame.getHeight() - 120);
            container.add(excavator);
            Draw();
        });


        buttonPanel.add(left);
        buttonPanel.add(down);
        buttonPanel.add(right);
        buttonPanel.add(up);
        buttonPanel.add(createUsualExcavator);
        buttonPanel.add(createBucketExcavator);

        container.add(buttonPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void Draw() {
        excavator.getGraphics().clearRect(0, 0, 910, 550);
        excavator.DrawExcavator(excavator.getGraphics());
    }
}
