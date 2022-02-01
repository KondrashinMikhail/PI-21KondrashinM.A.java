package com.company;

import java.util.*;
import javax.swing.*;

public class ParkingCollection {
    final HashMap<String, Parking<ITransport, ITrack>> parkingStages;
    public DefaultListModel<Parking<ITransport, ITrack>> modelList;

    private final int pictureWidth;
    private final int pictureHeight;

    public ParkingCollection(int pictureWidth, int pictureHeight){
        parkingStages = new HashMap<>();
        this.pictureHeight = pictureHeight;
        this.pictureWidth = pictureWidth;
        modelList = new DefaultListModel<>();
    }

    public Parking<ITransport, ITrack> AddParking(String name) {
        if (!parkingStages.containsKey(name)){
            Parking<ITransport, ITrack> parking = new Parking<>(pictureWidth, pictureHeight);
            parking.setName(name);
            parkingStages.put(name, parking);
            modelList.addElement(parking);
            return parking;
        }
        return null;
    }

    public void DelParking(String name) {
        if (parkingStages.containsKey(name)) {
            Parking parking = parkingStages.get(name);
            parkingStages.remove(name);
            modelList.removeElement(parking);
        }
    }

    public Parking<ITransport, ITrack> index(String ind){
        return parkingStages.getOrDefault(ind, null);
    }

    public ITransport index(String key, int index){
        if (parkingStages.containsKey(key)){
            return parkingStages.get(key).indexator(index);
        }
        return null;
    }
}
