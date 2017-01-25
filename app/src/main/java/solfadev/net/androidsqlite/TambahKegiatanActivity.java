package solfadev.net.androidsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import solfadev.net.androidsqlite.DB.DBHelper;

/**
 * Created by Ratri on 1/25/2017.
 */

public class TambahKegiatanActivity extends AppCompatActivity {
    EditText EtNama;
    EditText EtTempat;
    Button BtnSimpan;

    DBHelper mDbHelper;

    String Nama, Tempat;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tambah);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Tambah Kegiatan");
        setSupportActionBar(toolbar);

        mDbHelper = new DBHelper(getApplicationContext());

        EtNama = (EditText) findViewById(R.id.nama);
        EtTempat = (EditText) findViewById(R.id.tempat);
        BtnSimpan = (Button) findViewById(R.id.btn_save);


        BtnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Nama = EtNama.getText().toString();
                Tempat = EtTempat.getText().toString();

                Log.d("a", Nama+Tempat);


                if (!Nama.isEmpty() && !Tempat.isEmpty()){
                    mDbHelper.inputKegiatan(Nama, Tempat);
                    Intent i = new Intent(TambahKegiatanActivity.this, MainActivity.class);
                    startActivity(i);

                } else {
                    Toast.makeText(getApplication(), "Isi belum lengkap!", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}
