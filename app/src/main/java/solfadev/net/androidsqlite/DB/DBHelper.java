package solfadev.net.androidsqlite.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ratri on 1/25/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_KEGIATAN =
            "CREATE TABLE " + DBContract.Kegiatan.TABLE_NAME + " (" +
                    DBContract.Kegiatan._ID + " INTEGER PRIMARY KEY," +
                    DBContract.Kegiatan.COLUMN_NAME_NAMA + TEXT_TYPE + COMMA_SEP +
                    DBContract.Kegiatan.COLUMN_NAME_TEMPAT + TEXT_TYPE  +
                    " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DBContract.Kegiatan.TABLE_NAME;
    public static final int DATABASE_VERSION = 7;
    public static final String DATABASE_NAME = "Kegiatan.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_KEGIATAN);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public void inputKegiatan(String nama, String tempat){
        System.out.println("input kegiatan result : db");
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBContract.Kegiatan.COLUMN_NAME_NAMA, nama);
        values.put(DBContract.Kegiatan.COLUMN_NAME_TEMPAT, tempat);

        long newRowId = db.insert(DBContract.Kegiatan.TABLE_NAME, null, values);
        System.out.println("input kegiatan result : "+newRowId);
    }

    public List<KegiatanModel> getAllKegiatan(){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                DBContract.Kegiatan._ID,
                DBContract.Kegiatan.COLUMN_NAME_NAMA,
                DBContract.Kegiatan.COLUMN_NAME_TEMPAT,
        };
        String sortOrder = DBContract.Kegiatan._ID + " DESC";
        Cursor c = db.query(
                DBContract.Kegiatan.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );
        c.moveToFirst();
        System.out.println("data size : "+c.getCount());
        List<KegiatanModel> list = new ArrayList<>();
        for (int i = 0; i < c.getCount(); i++){
            System.out.println("data ke-"+i+" : "+c.getString(1));
            list.add(new KegiatanModel(c));
            c.moveToNext();
        }

        return list;
    }
}
