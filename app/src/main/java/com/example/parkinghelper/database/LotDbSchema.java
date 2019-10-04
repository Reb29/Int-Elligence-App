package com.example.parkinghelper.database;

public class LotDbSchema {
    public static final class LotTable {
        public static final String NAME = "lotdata";

        public static final class Cols {

            public static final String FAVORITE = "favorite";
            public static final String LOTNAME = "lotname";
            public static final String MAXCAPACITY = "maxcapacity";
            public static final String CURRENTCAPACITY = "currentcapacity";

        }
    }
}
