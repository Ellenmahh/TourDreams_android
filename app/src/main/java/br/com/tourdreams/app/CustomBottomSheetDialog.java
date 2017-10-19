package br.com.tourdreams.app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ellen on 09/10/2017.
 */

public class CustomBottomSheetDialog extends BottomSheetDialog{
    List<BuscaAvancada> lst_sheet;
    ListView lst_espandida;
    BuscaAvancadaAdapter adapter;
    private Context context;
    public CustomBottomSheetDialog (Context context ){
        super(context);
        this.context = context;
    }
     @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
        View layout = getLayoutInflater().inflate(R.layout.bottom_sheet_dialog,null);
        setContentView(layout);
        GridView gv = (GridView) layout.findViewById(R.id.gv_sheet);
        lst_sheet = new ArrayList<>();

        lst_sheet.add(new BuscaAvancada(R.drawable.ic_wifi_black_24dp));
        lst_sheet.add(new BuscaAvancada(R.drawable.ic_spa_black_24dp));
        lst_sheet.add(new BuscaAvancada(R.drawable.ic_fitness_center_black_24dp));
        lst_sheet.add(new BuscaAvancada(R.drawable.ic_wifi_black_24dp));
        lst_sheet.add(new BuscaAvancada(R.drawable.ic_wifi_black_24dp));
        lst_sheet.add(new BuscaAvancada(R.drawable.ic_wifi_black_24dp));
        lst_sheet.add(new BuscaAvancada(R.drawable.ic_wifi_black_24dp));
        lst_sheet.add(new BuscaAvancada(R.drawable.ic_wifi_black_24dp));
        lst_sheet.add(new BuscaAvancada(R.drawable.ic_wifi_black_24dp));
        lst_sheet.add(new BuscaAvancada(R.drawable.ic_wifi_black_24dp));
        lst_sheet.add(new BuscaAvancada(R.drawable.ic_wifi_black_24dp));
        lst_sheet.add(new BuscaAvancada(R.drawable.ic_wifi_black_24dp));
        lst_sheet.add(new BuscaAvancada(R.drawable.ic_wifi_black_24dp));
        lst_sheet.add(new BuscaAvancada(R.drawable.ic_wifi_black_24dp));
        lst_sheet.add(new BuscaAvancada(R.drawable.ic_wifi_black_24dp));
        lst_sheet.add(new BuscaAvancada(R.drawable.ic_wifi_black_24dp));
        lst_sheet.add(new BuscaAvancada(R.drawable.ic_wifi_black_24dp));
        lst_sheet.add(new BuscaAvancada(R.drawable.ic_wifi_black_24dp));
        lst_sheet.add(new BuscaAvancada(R.drawable.ic_wifi_black_24dp));
        lst_sheet.add(new BuscaAvancada(R.drawable.ic_wifi_black_24dp));
        lst_sheet.add(new BuscaAvancada(R.drawable.ic_wifi_black_24dp));
        lst_sheet.add(new BuscaAvancada(R.drawable.ic_wifi_black_24dp));
        lst_sheet.add(new BuscaAvancada(R.drawable.ic_wifi_black_24dp));
         adapter = new BuscaAvancadaAdapter(context,R.layout.bottom_sheet_dialog,lst_sheet);
        gv.setAdapter(adapter);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(context,"Pos"+position,Toast.LENGTH_SHORT).show();

            }
        });
    }
}
