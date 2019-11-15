package com.example.parkinghelper.database;

public class LotDbSchema {
    public static final class LotTable {
        public static final String NAME = "LOT_DATA";

        public static final class Cols {

            public static final String FAVORITE = "favorite";
            public static final String LOTNAME = "lot_name";
            public static final String MAXCAPACITY = "max_capacity";
            public static final String CURRENTCAPACITY = "current_capacity";

        }
    }
}
