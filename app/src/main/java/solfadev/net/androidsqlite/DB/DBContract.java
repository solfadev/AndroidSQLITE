package solfadev.net.androidsqlite.DB;

import android.provider.BaseColumns;

/**
 * Created by Ratri on 1/25/2017.
 */

public class DBContract {

    public static class Kegiatan implements BaseColumns {
        public static final String TABLE_NAME = "kegiatan";
        public static final String COLUMN_NAME_NAMA = "nama";
        public static final String COLUMN_NAME_TEMPAT = "tempat";
    }
}