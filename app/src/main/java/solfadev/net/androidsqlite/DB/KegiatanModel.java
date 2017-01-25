package solfadev.net.androidsqlite.DB;

import android.database.Cursor;

/**
 * Created by Ratri on 1/25/2017.
 */

public class KegiatanModel {
    int id;
    String nama;
    String tempat;

    public KegiatanModel(Cursor c){
        id = c.getInt(0);
        nama = c.getString(1);
        tempat = c.getString(2);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }




}
