package br.com.tourdreams.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 15251365 on 03/10/2017.
 */

public class CaracteristicasAdapter extends ArrayAdapter<Caracteristicas> {
        int resource;
   // public CaracteristicasAdapter(Context context, int listview, Caracteristicas[] lstCarateristicas) {
    public CaracteristicasAdapter(Context context, int resource, List<Caracteristicas> objects) {
       //super(context, 0,lstCarateristicas);
        super(context, resource, objects);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if(v == null){

            LayoutInflater inflater = LayoutInflater.from(getContext());
            v = inflater.inflate(R.layout.listview, null);
        }

        Caracteristicas item = getItem(position);

        if(item != null){
            TextView txt_caracteristicas = (TextView) v.findViewById(R.id.txt_caracteristicas);
            ImageView img_contem_caracteristica = (ImageView) v.findViewById(R.id.img_contem_caracteristica);
            ImageView img_caracteristica = (ImageView) v.findViewById(R.id.img_caracteristica);

            txt_caracteristicas.setText(item.getDescricao());
            Picasso.with(getContext())
                    .load(item.getImagem()) // pega a imagem e carrega ela na image view
                    .into(img_contem_caracteristica); // a imgview q vai carregar a imagem


        }




        return v;
    }
}
