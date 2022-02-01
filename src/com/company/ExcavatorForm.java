package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ExcavatorForm extends JPanel {
    public JButton left;
    public JButton right;
    public JButton up;
    public JButton down;
    private Vehicle excavator;
    private final Container container;

    public ExcavatorForm() throws IOException {
        JFrame frame = new JFrame("Excavator form");
        frame.setSize(910, 550);

        container = frame.getContentPane();

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

        buttonPanel.add(left);
        buttonPanel.add(down);
        buttonPanel.add(right);
        buttonPanel.add(up);

        container.add(buttonPanel);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    public void Draw() {
        excavator.getGraphics().clearRect(0, 0, 910, 400);
        excavator.DrawExcavator(excavator.getGraphics());
    }

    public void setExcavator(Vehicle newExcavator) {
        this.excavator = newExcavator;
        this.excavator.setBounds(0, 0, 910, 400);
        this.excavator.setLayout(null);
        this.excavator.SetPosition(100, 100, 910, 400);
        container.add(this.excavator);
        Draw();
    }
}
