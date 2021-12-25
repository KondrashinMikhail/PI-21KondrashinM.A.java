package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

public class FormParking extends JPanel {
    private JButton createExcavator;
    private JButton deleteExcavator;
    private JFormattedTextField removeIndex;
    private JPanel actions;
    private Container container;
    private Parking<ITransport, ITrack> parking;
    private Vehicle excavator;
    private int index;
    private JTextField parkingName;
    private JList<Parking<ITransport, ITrack>> listBoxParking;
    private ParkingCollection parkingCollection;
    private LinkedList<ITransport> removedStages;
    private JButton createParking;
    private JButton deleteParking;
    private JButton getRemovedExcavator;

    public FormParking() {
        JFrame frame = new JFrame("Parking");
        frame.setSize(920, 700);
        container = frame.getContentPane();
        actions = new JPanel();
        actions.setLayout(null);

        parkingCollection = new ParkingCollection(700, 650);
        removedStages = new LinkedList<>();

        parkingName = new JTextField();
        parkingName.setBounds(700, 10, 200, 20);

        createParking = new JButton("Create parking");
        createParking.setBounds(700, 30, 200, 30);
        createParking.addActionListener(e->{
            parking = parkingCollection.AddParking(parkingName.getText());
            if (parking != null){
                parking.setBounds(0, 0, 820, 650);
                parking.setBackground(new Color(0, 0, 0, 0));
                actions.add(parking);
                parking.setLayout(null);
                Draw();
            }
        });

        listBoxParking = new JList<>();
        listBoxParking.setModel(parkingCollection.modelList);
        listBoxParking.setBounds(700, 60, 200, 300);
        listBoxParking.setVisibleRowCount(-1);

        listBoxParking.getSelectionModel().addListSelectionListener(e -> {
            parking = listBoxParking.getSelectedValue();
            if (parking == null) frame.getGraphics().clearRect(0, 0, 700, 650);
            else Draw();
        });

        deleteParking = new JButton("Delete parking");
        deleteParking.setBounds(700, 370, 200, 30);
        deleteParking.addActionListener(e->{
            if (parkingCollection.modelList.indexOf(parking) > -1) {
                parkingCollection.DelParking(parkingCollection.modelList.get(parkingCollection.modelList.indexOf(parking)).getName());
            }
            else {
                JOptionPane.showMessageDialog(null, "Collection of parkings is empty");
            }
        });

        createExcavator = new JButton("Create excavator");
        createExcavator.setBounds(700, 400, 200, 30);
        createExcavator.addActionListener(e -> {
            createConfWindow();
        });

        JLabel labelTakeExcavator = new JLabel("Pick up excavator from parking lot");
        labelTakeExcavator.setBounds(700, 490, 200, 20);

        JLabel labelPlace = new JLabel("Parking lot:");
        labelPlace.setBounds(700, 510, 70, 20);

        removeIndex = new JFormattedTextField();
        removeIndex.setBounds(770, 510, 50, 20);

        deleteExcavator = new JButton("Delete excavator");
        deleteExcavator.setBounds(700, 540, 200, 30);
        deleteExcavator.addActionListener(e -> {
            Excavator newExcavator = (Excavator) parking.minus(parking, Integer.parseInt(removeIndex.getText()));
            if (newExcavator != null) {
                removedStages.add(newExcavator);
            } else {
                JOptionPane.showMessageDialog(null, "Parking lot is empty!", "EMPTY LOT ERROR!", JOptionPane.ERROR_MESSAGE);
            }

            Draw();
        });

        getRemovedExcavator = new JButton("Get removed excavator");
        getRemovedExcavator.setBounds(700, 570, 200, 30);
        getRemovedExcavator.addActionListener(e -> {
            excavator = null;
            if (!removedStages.isEmpty()) {
                    excavator = (Excavator) removedStages.remove();
            }

            if (excavator != null) {
                ExcavatorForm removedExcavator = null;
                try {
                    removedExcavator = new ExcavatorForm();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                removedExcavator.setExcavator(excavator);
            }
            else {
                JOptionPane.showMessageDialog(null, "The LinkedList of removed excavators is empty");
            }
            Draw();
        });

        actions.add(parkingName);
        actions.add(createParking);
        actions.add(listBoxParking);
        actions.add(deleteParking);
        actions.add(createExcavator);
        actions.add(labelTakeExcavator);
        actions.add(labelPlace);
        actions.add(removeIndex);
        actions.add(deleteExcavator);

        container.add(getRemovedExcavator);
        container.add(actions);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void addExcavator (Vehicle excavator) {
        if (excavator != null) {
            int index = parking.plus(parking, excavator);
            if (index > -1) {
                parking.add(excavator);
            }
            else {
                JOptionPane.showMessageDialog(null, "Parking is full");
            }
            parking.Draw(parking.getGraphics());
        }
    }

    public void Draw() {
        parking.Draw(parking.getGraphics());
    }

    public void createConfWindow() {
        new FormExcavatorConfig(this);
    }
}
