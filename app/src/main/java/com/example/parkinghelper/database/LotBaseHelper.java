package com.example.parkinghelper.database;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LotBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "testaf.db";

    public LotBaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table " + LotDbSchema.LotTable.NAME + "(" +
                " varchar primary key UNIQUE, " +
                LotDbSchema.LotTable.Cols.LOTNAME + ", " +
                LotDbSchema.LotTable.Cols.MAXCAPACITY + ", " +
                LotDbSchema.LotTable.Cols.CURRENTCAPACITY + ", " +
                LotDbSchema.LotTable.Cols.FAVORITE + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
