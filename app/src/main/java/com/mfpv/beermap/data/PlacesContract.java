package com.mfpv.beermap.data;

import android.provider.BaseColumns;

public class PlacesContract {

    public static final class LocationEntry implements BaseColumns {

        public static final String TABLE_NAME = "places";
        public static final String COLUMN_PLACE_ID = "place_id";
        public static final String COLUMN_PLACE_NAME = "place_name";

    }
}
