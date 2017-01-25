package solfadev.net.androidsqlite.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import solfadev.net.androidsqlite.R;

/**
 * Created by Ratri on 1/25/2017.
 */

public class KegiatanHolder extends RecyclerView.ViewHolder {
    public TextView txtNama, txtTempat;
    public View card;
    public KegiatanHolder(View itemView) {
        super(itemView);
        txtNama = (TextView) itemView.findViewById(R.id.txt_nama);
        txtTempat = (TextView) itemView.findViewById(R.id.txt_tempat);
        card = (View) itemView.findViewById(R.id.card);
    }
    public KegiatanHolder(ViewGroup parent){
        this(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kegiatan, parent, false));
    }
}
