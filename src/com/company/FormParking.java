package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class FormParking extends JPanel {
    private JButton createUsualExcavator;
    private JButton createBucketExcavator;
    private JButton deleteExcavator;
    private JFormattedTextField textField;
    private JPanel actions;
    private Container container;
    private Parking<ITransport, ITrack> parking;
    private Vehicle excavator;
    private int index;

    public FormParking() {
        JFrame frame = new JFrame("Parking");
        frame.setSize(920, 550);
        container = frame.getContentPane();
        actions = new JPanel();
        actions.setLayout(null);

        parking = new Parking<>(700, 500);
        parking.setBounds(0, 0, 700, 500);
        parking.setLayout(null);

        createUsualExcavator = new JButton("Create usual excavator");
        createUsualExcavator.setBounds(700, 10, 200, 30);
        createUsualExcavator.addActionListener(e -> {
            excavator = new Excavator(new Random().nextInt(100), new Random().nextInt(2000),
                    JColorChooser.showDialog(null, "Choose main color", null));
            excavator.setLayout(null);
            index = parking.plus(parking, excavator);
            if (index != -1) {
                excavator.SetPosition(index % (700 / parking.getPlaceSizeWidth()) * parking.getPlaceSizeWidth() + 40, index / (700 / parking.getPlaceSizeWidth()) * parking.getPlaceSizeHeight() + 40, 700, 500);
            } else {
                JOptionPane.showMessageDialog(null, "Parking is full", "OVERFLOW ERROR!", JOptionPane.ERROR_MESSAGE);
            }

            Draw();
        });

        createBucketExcavator = new JButton("Create bucket excavator");
        createBucketExcavator.setBounds(700, 50, 200, 30);
        createBucketExcavator.addActionListener(e -> {
            excavator = new BucketExcavator(new Random().nextInt(100), new Random().nextInt(2000),
                    JColorChooser.showDialog(null, "Choose main color", null),
                    JColorChooser.showDialog(null, "Choose dop color", null),
                    true, true);
            excavator.setLayout(null);
            index = parking.plus(parking, excavator);
            if (index != -1) {
                excavator.SetPosition(index % (700 / parking.getPlaceSizeWidth()) * parking.getPlaceSizeWidth() + 40, index / (700 / parking.getPlaceSizeWidth()) * parking.getPlaceSizeHeight() + 40, 700, 500);

            } else {
                JOptionPane.showMessageDialog(null, "Parking is full", "OVERFLOW ERROR!", JOptionPane.ERROR_MESSAGE);
            }

            Draw();
        });

        JLabel labelTakeExcavator = new JLabel("Pick up excavator from parking lot");
        labelTakeExcavator.setBounds(700, 100, 200, 20);

        JLabel labelPlace = new JLabel("Parking lot:");
        labelPlace.setBounds(700, 120, 70, 20);

        textField = new JFormattedTextField();
        textField.setBounds(770, 120, 50, 20);

        deleteExcavator = new JButton("Delete excavator");
        deleteExcavator.setBounds(700, 150, 200, 30);
        deleteExcavator.addActionListener(e -> {
            Excavator newExcavator = (Excavator) parking.minus(parking, Integer.parseInt(textField.getText()));
            if (newExcavator != null) {
                ExcavatorForm deletedExcavatorForm = null;
                try {
                    deletedExcavatorForm = new ExcavatorForm();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                assert deletedExcavatorForm != null;
                deletedExcavatorForm.setExcavator(newExcavator);
            } else {
                JOptionPane.showMessageDialog(null, "Parking lot is empty!", "EMPTY LOT ERROR!", JOptionPane.ERROR_MESSAGE);
            }

            Draw();
        });

        actions.add(createUsualExcavator);
        actions.add(createBucketExcavator);
        actions.add(labelTakeExcavator);
        actions.add(labelPlace);
        actions.add(textField);
        actions.add(deleteExcavator);

        container.add(parking);
        container.add(actions);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void Draw() {
        parking.Draw(parking.getGraphics());
    }
}
