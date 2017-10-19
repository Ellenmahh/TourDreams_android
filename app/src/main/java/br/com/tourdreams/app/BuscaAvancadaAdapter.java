package br.com.tourdreams.app;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Ellen on 19/10/2017.
 */

public class BuscaAvancadaAdapter extends ArrayAdapter<BuscaAvancada> {
    int resource;

    public BuscaAvancadaAdapter(Context context, int resource, List<BuscaAvancada> objects) {
        //super(context, 0,lstCarateristicas);
        super(context, resource, objects);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if(v == null){

            LayoutInflater inflater = LayoutInflater.from(getContext());
            v = inflater.inflate(R.layout.bottom_sheet_dialog, null);
        }

        BuscaAvancada item = getItem(position);

        if(item != null){
            GridView gv = (GridView) v.findViewById(R.id.gv_sheet);
            gv.setNumColumns(3);
            gv.setBackgroundResource(item.getImagem());


        }
        return v;
    }
}