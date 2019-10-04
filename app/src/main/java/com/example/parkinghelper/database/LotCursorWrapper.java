package com.example.parkinghelper.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.parkinghelper.models.Lot;


public class LotCursorWrapper extends CursorWrapper {

    public LotCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Lot getLot() {
        String name = getString(getColumnIndex(LotDbSchema.LotTable.Cols.LOTNAME));
        int isFavorite = getInt(getColumnIndex(LotDbSchema.LotTable.Cols.FAVORITE));
        int maxCapacity = getInt(getColumnIndex(LotDbSchema.LotTable.Cols.MAXCAPACITY));
        int currentCapacity = getInt(getColumnIndex(LotDbSchema.LotTable.Cols.CURRENTCAPACITY));

        Lot lot = new Lot(name);
        lot.setMaxCapacity(maxCapacity);
        lot.setCurrentCapacity(currentCapacity);
        lot.setFavorite(isFavorite != 0);

        return lot;
    }
}
