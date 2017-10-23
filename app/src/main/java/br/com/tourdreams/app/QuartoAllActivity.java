package br.com.tourdreams.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QuartoAllActivity extends BaseActivity {
    TextView txt_modelo,preco_modelo;
    ImageView img_quarto_modelo;
    GridView gridView;
    Context context;
    List<DadosQuarto> lst_quarto = new ArrayList<>();
    QuartoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        definirConteudo(R.layout.activity_quarto_all);
        context = this;

        img_quarto_modelo = (ImageView) findViewById(R.id.img_quarto_modelo);
        txt_modelo = (TextView) findViewById(R.id.txt_modelo);
        preco_modelo = (TextView) findViewById(R.id.preco_modelo);
        gridView = (GridView) findViewById(R.id.gridView);

        lst_quarto.add(new DadosQuarto("quarto tal",399.99,"asd",R.drawable.quarto));
        lst_quarto.add(new DadosQuarto("quartohaha",299.99,"asd",R.drawable.hotel));
        lst_quarto.add(new DadosQuarto("quarto tal",399.99,"asd",R.drawable.quarto));
        lst_quarto.add(new DadosQuarto("quatal",199.90,"asd",R.drawable.hotel));

        adapter = new QuartoAdapter(context,R.layout.modelo,lst_quarto);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(context,"Quarto "+i,Toast.LENGTH_SHORT).show();
                startActivity(new Intent(context, ReservaActivity.class));
            }
        });



    }
}
