package solfadev.net.androidsqlite.Adapter;

import android.view.ViewGroup;

import solfadev.net.androidsqlite.DB.DBHelper;
import solfadev.net.androidsqlite.DB.KegiatanModel;
import solfadev.net.androidsqlite.Holder.KegiatanHolder;
import solfadev.net.androidsqlite.MainActivity;

/**
 * Created by Ratri on 1/25/2017.
 */

public class KegiatanAdapter extends ListAdapter<KegiatanModel, KegiatanHolder> {
    DBHelper helper;
    MainActivity activity;

    public KegiatanAdapter(MainActivity activity){
        this.activity = activity;
        helper = new DBHelper(activity);
    }

    @Override
    public KegiatanHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new KegiatanHolder(parent);
    }

    @Override
    public void onBindViewHolder(KegiatanHolder holder, int position) {
        final KegiatanModel model = get(position);
        holder.txtNama.setText(model.getNama());
        holder.txtTempat.setText(model.getTempat());

    }

    public void refresh(){
        clearAll();
        init();
    }

    public void init(){
        add(helper.getAllKegiatan());
    }
}