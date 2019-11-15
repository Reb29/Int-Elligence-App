package com.example.parkinghelper.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.parkinghelper.database.LotBaseHelper;
import com.example.parkinghelper.database.LotCursorWrapper;
import com.example.parkinghelper.database.LotDbSchema;
import com.example.parkinghelper.utils.ParkingLotLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LotList {
    private static LotList sLotList;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static LotList get(Context context) {
       if(sLotList == null)
       {
            sLotList = new LotList(context);
       }

        List<Lot> initialLots = ParkingLotLoader.initializeLots();
        for (Lot lot  : initialLots) {
            sLotList.addLot(lot);
        }

        return sLotList;
    }

    public void addLot(Lot l) {
        ContentValues values = getContentValues(l);

        if (getLot(l.getName()) == null)
        mDatabase.insert(LotDbSchema.LotTable.NAME, null, values);
        else
        updateLot(l);
    }

    private LotList(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new LotBaseHelper(mContext).getWritableDatabase();
    }

    public List<Lot> getLots() {
        List<Lot> lots = new ArrayList<>();
        LotCursorWrapper cursor = queryLots(null, null);

        try
        {
            cursor.moveToFirst();
            while(!cursor.isAfterLast())
            {
                lots.add(cursor.getLot());
                cursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }

        return lots;
    }

    public List<Lot> getFavorites() {
        List<Lot> lots = new ArrayList<>();
        LotCursorWrapper cursor = queryLots(null, null);

        try
        {
            cursor.moveToFirst();
            while(!cursor.isAfterLast())
            {
                if (cursor.getLot().isFavorite())
                lots.add(cursor.getLot());

                cursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }

        return lots;
    }

    public Lot getLot(String name) {
        LotCursorWrapper cursor = queryLots(LotDbSchema.LotTable.Cols.LOTNAME + "=?",
                new String[] { name});
        try{
            if(cursor.getCount() == 0)
            {
                return null;
            }

            cursor.moveToFirst();
            return cursor.getLot();
        }finally {
            cursor.close();
        }
    }


    public void updateLot(Lot lot) {
        String name = lot.getName();
        ContentValues values = getContentValues(lot);
        values.remove(LotDbSchema.LotTable.Cols.FAVORITE);

        mDatabase.update(LotDbSchema.LotTable.NAME, values,
                LotDbSchema.LotTable.Cols.LOTNAME + "=?",
                new String[] { name });
    }

    private static ContentValues getContentValues(Lot lot) {
        ContentValues values = new ContentValues();
        values.put(LotDbSchema.LotTable.Cols.LOTNAME, lot.getName());
        values.put(LotDbSchema.LotTable.Cols.MAXCAPACITY, lot.getMaxCapacity());
        values.put(LotDbSchema.LotTable.Cols.CURRENTCAPACITY, lot.getCurrentCapacity());
        values.put(LotDbSchema.LotTable.Cols.FAVORITE, lot.isFavorite() ? 1 : 0);

        return values;
    }

    public File getImageFile(Lot lot){
        File dir = mContext.getFilesDir();
        return new File(dir, lot.getImageFilename());
    }

    private LotCursorWrapper queryLots(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(LotDbSchema.LotTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null);

        return new LotCursorWrapper(cursor);
    }
}