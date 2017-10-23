package br.com.tourdreams.app;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LugaresActivity extends BaseActivity {
    TextView txt_nomee_hotel, txt_preco_hotel, txt_local_hotel;
    ImageView img_hotel;
    ListView lst_lugares;
    List<Hotel> lstLugares= new ArrayList<>();
    HotelAdapter adapter;
    Context context;
    SearchView.OnQueryTextListener listennerBusca = new SearchView.OnQueryTextListener() {

        @Override
        // é executado quando termina a busca e clica em pesquisar
        public boolean onQueryTextSubmit(String query) {
            small.setVisibility(View.VISIBLE);
            return false;
        }
        @Override
        // é executado a cada letra clicada
        public boolean onQueryTextChange(String newText) {
            Log.d("OnQueryTextListener",newText);
            // filtragem do adapter
            adapter.getFilter().filter(newText);
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        definirConteudo(R.layout.activity_lugares);
        context = this;

        img_hotel = (ImageView) findViewById(R.id.img_hotel);
        txt_nomee_hotel =(TextView) findViewById(R.id.txt_nomee_hotel);
        txt_preco_hotel = (TextView) findViewById(R.id.txt_preco_hotel);
        txt_local_hotel = (TextView) findViewById(R.id.txt_local_hotel);
        lst_lugares = (ListView) findViewById(R.id.lst_lugares);

        preencherAdapter();

        lst_lugares.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(context,"clicoou"+position,Toast.LENGTH_SHORT).show();
                startActivity(new Intent(context,QuartoAllActivity.class));
            }
        });
    }
    private void preencherAdapter() {

        // adicionando hoteis a lista

        lstLugares.add(new Hotel("hotel do joãozinho", 299.00, "São Paulo", R.drawable.hotel));
        lstLugares.add(new Hotel("hotel do pedrinho", 299.00, "Goiânia", R.drawable.quarto));
        lstLugares.add(new Hotel("hotel do zezinho", 299.00, "Rio de Janero", R.drawable.hotel));
        lstLugares.add(new Hotel("hotel da LALALA", 299.00, "Rio de Janero", R.drawable.quarto));
        lstLugares.add(new Hotel("hotel da lulu", 299.00, "Rio de Janero", R.drawable.hotel));

        adapter = new HotelAdapter(this, R.layout.list_view_hotel, lstLugares);
        lst_lugares.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        //id do icone
        SearchView searchView = (SearchView) menu.findItem(R.id.busca).getActionView();
        searchView.setQueryHint("Pesquisar..");
        searchView.setOnQueryTextListener(listennerBusca);

        return true;
    }
}
