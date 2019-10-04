package com.example.parkinghelper.utils;
import com.example.parkinghelper.models.Lot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotConfig {
    public static List<Lot> initializeLots() {
        List<Lot> initialList = new ArrayList<>();
        initialList.add(new Lot("A", 125, 100));
        initialList.add(new Lot("B", 100, 70));
        initialList.add(new Lot("C", 155, 50));

        return initialList;
    }
}
