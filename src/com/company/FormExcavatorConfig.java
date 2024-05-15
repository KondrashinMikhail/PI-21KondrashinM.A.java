package com.company;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;

public class FormExcavatorConfig extends JFrame {
    private JFrame frame;
    private FormParking parentFrame;
    private JLabel pictureMask, excavator, bucketExcavator, mainColor, dopColor, speedLabel, weightLabel, trackType,
            doubleLineTrack, circleTrack;
    private MouseReaction mouseType, mouseColor;
    private ITransport pictureExcavator;
    private JPanel confPanel, grayColor, yellowColor, greenColor, blueColor, redColor, blackColor, orangeColor, pinkColor;
    private DrawPanel drawPanel;
    private JSpinner chooseSpeed, chooseWeight, numOfWheelsCount;
    private JCheckBox setFrontBucket, setBackBucket;
    private JButton createExcavator;

    public FormExcavatorConfig (FormParking parentFrame) {
        this.parentFrame = parentFrame;
        frame = new JFrame("Choose configurations");
        Init();
    }

    public void Init() {
        mouseColor = new MouseReaction();
        mouseType = new MouseReaction();

        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLayout(null);

        confPanel = new JPanel();
        confPanel.setLayout(null);
        confPanel.setBounds(0, 0, frame.getWidth(), frame.getHeight());

        pictureMask = new JLabel();
        pictureMask.setBounds(150, 10, 200, 150);
        pictureMask.setBorder(new LineBorder(new Color(0, 0, 0)));
        pictureMask.setTransferHandler(new TransferHandler("text"));
        confPanel.add(pictureMask);

        drawPanel = new DrawPanel();
        drawPanel.setLayout(null);
        drawPanel.setBounds(150, 10, 200, 150);
        drawPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        confPanel.add(drawPanel);

        excavator = new JLabel("Usual excavator");
        excavator.setBounds(10, 10, 130, 50);
        excavator.setBorder(new BevelBorder(0));
        excavator.setTransferHandler(new TransferHandler("text"));
        excavator.addMouseListener(mouseType);
        excavator.setDropTarget(null);
        confPanel.add(excavator);

        bucketExcavator = new JLabel("Bucket excavator");
        bucketExcavator.setBounds(10, 70, 130, 50);
        bucketExcavator.setBorder(new BevelBorder(0));
        bucketExcavator.setTransferHandler(new TransferHandler("text"));
        bucketExcavator.addMouseListener(mouseType);
        bucketExcavator.setDropTarget(null);
        confPanel.add(bucketExcavator);

        mainColor = new JLabel("Main Color");
        mainColor.setBounds(400, 10, 90, 30);
        mainColor.setBorder(new LineBorder(Color.BLACK));
        mainColor.setHorizontalAlignment(JLabel.CENTER);
        mainColor.setBackground(Color.GRAY);
        mainColor.setTransferHandler(new TransferHandler("background"));
        confPanel.add(mainColor);

        grayColor = new JPanel();
        grayColor.setLayout(null);
        grayColor.setBounds(400, 50, 40,40);
        grayColor.setBackground(Color.GRAY);
        grayColor.setTransferHandler(new TransferHandler("background"));
        grayColor.addMouseListener(mouseColor);
        grayColor.setDropTarget(null);
        confPanel.add(grayColor);

        redColor = new JPanel();
        redColor.setLayout(null);
        redColor.setBounds(450, 50, 40,40);
        redColor.setBackground(Color.RED);
        redColor.setTransferHandler(new TransferHandler("background"));
        redColor.addMouseListener(mouseColor);
        redColor.setDropTarget(null);
        confPanel.add(redColor);

        blueColor = new JPanel();
        blueColor.setLayout(null);
        blueColor.setBounds(400, 100, 40,40);
        blueColor.setBackground(Color.BLUE);
        blueColor.setTransferHandler(new TransferHandler("background"));
        blueColor.addMouseListener(mouseColor);
        blueColor.setDropTarget(null);
        confPanel.add(blueColor);

        blackColor = new JPanel();
        blackColor.setLayout(null);
        blackColor.setBounds(450, 100, 40,40);
        blackColor.setBackground(Color.BLACK);
        blackColor.setTransferHandler(new TransferHandler("background"));
        blackColor.addMouseListener(mouseColor);
        blackColor.setDropTarget(null);
        confPanel.add(blackColor);

        dopColor = new JLabel("Additional Color");
        dopColor.setBounds(600, 10, 90, 30);
        dopColor.setBorder(new LineBorder(Color.BLACK));
        dopColor.setHorizontalAlignment(JLabel.CENTER);
        dopColor.setBackground(Color.CYAN);
        dopColor.setTransferHandler(new TransferHandler("background"));
        confPanel.add(dopColor);

        yellowColor = new JPanel();
        yellowColor.setLayout(null);
        yellowColor.setBounds(600, 50, 40,40);
        yellowColor.setBackground(Color.YELLOW);
        yellowColor.setTransferHandler(new TransferHandler("background"));
        yellowColor.addMouseListener(mouseColor);
        yellowColor.setDropTarget(null);
        confPanel.add(yellowColor);

        orangeColor = new JPanel();
        orangeColor.setLayout(null);
        orangeColor.setBounds(650, 50, 40,40);
        orangeColor.setBackground(Color.ORANGE);
        orangeColor.setTransferHandler(new TransferHandler("background"));
        orangeColor.addMouseListener(mouseColor);
        orangeColor.setDropTarget(null);
        confPanel.add(orangeColor);

        greenColor = new JPanel();
        greenColor.setLayout(null);
        greenColor.setBounds(600, 100, 40,40);
        greenColor.setBackground(Color.GREEN);
        greenColor.setTransferHandler(new TransferHandler("background"));
        greenColor.addMouseListener(mouseColor);
        greenColor.setDropTarget(null);
        confPanel.add(greenColor);

        pinkColor = new JPanel();
        pinkColor.setLayout(null);
        pinkColor.setBounds(650, 100, 40,40);
        pinkColor.setBackground(Color.PINK);
        pinkColor.setTransferHandler(new TransferHandler("background"));
        pinkColor.addMouseListener(mouseColor);
        pinkColor.setDropTarget(null);
        confPanel.add(pinkColor);

        speedLabel = new JLabel("Speed:");
        speedLabel.setBounds(30, 270, 60, 20);
        confPanel.add(speedLabel);

        chooseSpeed = new JSpinner();
        chooseSpeed.setBounds(30, 290, 60, 20);
        chooseSpeed.setModel(new SpinnerNumberModel(100, 1, 200, 1));
        confPanel.add(chooseSpeed);

        weightLabel = new JLabel("Weight:");
        weightLabel.setBounds(30, 320, 60, 20);
        confPanel.add(weightLabel);

        chooseWeight = new JSpinner();
        chooseWeight.setBounds(30, 340, 60, 20);
        chooseWeight.setModel(new SpinnerNumberModel(100, 1, 200, 1));
        confPanel.add(chooseWeight);

        setFrontBucket = new JCheckBox("Set front bucket");
        setFrontBucket.setSelected(true);
        setFrontBucket.setBounds(180, 280, 120, 30);
        confPanel.add(setFrontBucket);

        setBackBucket = new JCheckBox("Set back bucket");
        setBackBucket.setSelected(true);
        setBackBucket.setBounds(180, 310, 120, 30);
        confPanel.add(setBackBucket);

        trackType = new JLabel("Usual type");
        trackType.setBounds(400,220, 100, 50);
        trackType.setBorder(new BevelBorder(0));
        trackType.setTransferHandler(new TransferHandler("text"));
        trackType.addMouseListener(mouseType);
        trackType.setDropTarget(null);
        confPanel.add(trackType);

        doubleLineTrack = new JLabel("Circle type");
        doubleLineTrack.setBounds(400,280, 100, 50);
        doubleLineTrack.setBorder(new BevelBorder(0));
        doubleLineTrack.setTransferHandler(new TransferHandler("text"));
        doubleLineTrack.addMouseListener(mouseType);
        doubleLineTrack.setDropTarget(null);
        confPanel.add(doubleLineTrack);

        circleTrack = new JLabel("Double line type");
        circleTrack.setBounds(400,340, 100, 50);
        circleTrack.setBorder(new BevelBorder(0));
        circleTrack.setTransferHandler(new TransferHandler("text"));
        circleTrack.addMouseListener(mouseType);
        circleTrack.setDropTarget(null);
        confPanel.add(circleTrack);

        numOfWheelsCount = new JSpinner();
        numOfWheelsCount.setBounds(400, 410, 60, 20);
        numOfWheelsCount.setModel(new SpinnerNumberModel(4, 4, 6, 1));
        confPanel.add(numOfWheelsCount);

        createExcavator = new JButton("Create excavator");
        createExcavator.setBounds(600, 250, 140, 50);
        confPanel.add(createExcavator);

        PropertyChangeListener colorChangeListener = PropertyChangeEvent ->{
            if (pictureExcavator == null) return;
            if (pictureExcavator.getClass().equals(Excavator.class) || pictureExcavator.getClass().equals(BucketExcavator.class)){
                setMainColor();
            }
            if (pictureExcavator.getClass().equals(BucketExcavator.class)){
                setDopColor();
            }
        };
        PropertyChangeListener typeChangeListener = PropertyChangeEvent ->{
            if (pictureMask.getText().equals("Usual excavator")){
                setTrackTypeE(0);
            }
            else if(pictureMask.getText().equals("Bucket excavator")){
                setTrackTypeBE(0);
            }
            if (pictureExcavator != null && pictureExcavator.getClass().equals(BucketExcavator.class)){
                if(pictureMask.getText().equals("Usual type")){
                    setTrackTypeBE(0);
                }
                else if(pictureMask.getText().equals("Circle type")){
                    setTrackTypeBE(1);
                }
                else if(pictureMask.getText().equals("Double line type")){
                    setTrackTypeBE(2);
                }
            }
            if (pictureExcavator != null && pictureExcavator.getClass().equals(Excavator.class)){
                if(pictureMask.getText().equals("Usual type")){
                    setTrackTypeE(0);
                }
                else if(pictureMask.getText().equals("Circle type")){
                    setTrackTypeE(1);
                }
                else if(pictureMask.getText().equals("Double line type")){
                    setTrackTypeE(2);
                }
            }
            pictureMask.setText("");
        };
        createExcavator.addActionListener(ActionEvent -> {
            parentFrame.addExcavator((Vehicle) pictureExcavator);
            frame.setVisible(false);
            frame.dispose();
        });

        mainColor.addPropertyChangeListener(colorChangeListener);
        dopColor.addPropertyChangeListener(colorChangeListener);
        pictureMask.addPropertyChangeListener(typeChangeListener);
        pictureMask.addPropertyChangeListener(colorChangeListener);
        frame.add(confPanel);
        frame.setVisible(true);
    }

    public class MouseReaction extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getSource().getClass().equals(JLabel.class)) {
                JLabel element = (JLabel) e.getSource();
                TransferHandler handler = element.getTransferHandler();
                handler.exportAsDrag(element, e, TransferHandler.COPY);
            }
            else if (e.getSource().getClass().equals(JPanel.class)) {
                JPanel element = (JPanel) e.getSource();
                TransferHandler handler = element.getTransferHandler();
                handler.exportAsDrag(element, e, TransferHandler.COPY);
            }
        }
    }

    public class DrawPanel extends JPanel {
        private ITransport excavator;
        public void setExcavator(ITransport excavator) {
            this.excavator = excavator;
        }
        public void paintComponent(Graphics g) {
            if (excavator != null) {
                excavator.DrawExcavator(g);
            }
        }
    }

    public void setTrackTypeBE(int ID){
        pictureExcavator = new BucketExcavator((int)chooseSpeed.getValue(), (int)chooseWeight.getValue(), Color.GRAY, Color.ORANGE, setFrontBucket.isSelected(), setBackBucket.isSelected(), ID, (int) numOfWheelsCount.getValue());
        pictureExcavator.SetPosition(65, 60, confPanel.getWidth(),  confPanel.getHeight());
        drawPanel.setExcavator(pictureExcavator);
        drawPanel.repaint();
    }

    public void setTrackTypeE(int ID){
        pictureExcavator = new Excavator((int)chooseSpeed.getValue(), (int)chooseWeight.getValue(), Color.GRAY, ID, (int) numOfWheelsCount.getValue());
        pictureExcavator.SetPosition(65, 60, confPanel.getWidth(),  confPanel.getHeight());
        drawPanel.setExcavator(pictureExcavator);
        drawPanel.repaint();
    }

    public void setMainColor(){
        Excavator excavator = (Excavator) pictureExcavator;
        excavator.setMainColor(mainColor.getBackground());
        drawPanel.setExcavator(pictureExcavator);
        drawPanel.repaint();
        pictureMask.repaint();
    }

    public void setDopColor(){
        BucketExcavator bucketExcavator = (BucketExcavator) pictureExcavator;
        bucketExcavator.setDopColor(dopColor.getBackground());
        drawPanel.setExcavator(pictureExcavator);
        drawPanel.repaint();
        pictureMask.repaint();
    }
}