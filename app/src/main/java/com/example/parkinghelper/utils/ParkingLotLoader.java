package com.example.parkinghelper.utils;
import com.example.parkinghelper.models.Lot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotLoader {
    public static List<Lot> initializeLots() {
        List<Lot> initialList = new ArrayList<>();
        initialList.add(new Lot("J", 155, 50));
        initialList.add(new Lot("H", 125, 80));
        initialList.add(new Lot("B", 100, 80));
        initialList.add(new Lot("I", 155, 80));

        return initialList;
    }
}
