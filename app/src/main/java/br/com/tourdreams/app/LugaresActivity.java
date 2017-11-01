package br.com.tourdreams.app;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
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

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class LugaresActivity extends BaseActivity {
    TextView txt_nomee_hotel, txt_preco_hotel, txt_local_hotel;
    ImageView img_hotel;
    ListView lst_lugares;
    List<Hotel> lstLugares = new ArrayList<>();
    HotelAdapter adapter;
    Context context;

    int categoria;
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
            Log.d("OnQueryTextListener", newText);
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
        txt_nomee_hotel = (TextView) findViewById(R.id.txt_nomee_hotel);
        txt_preco_hotel = (TextView) findViewById(R.id.txt_preco_hotel);
        txt_local_hotel = (TextView) findViewById(R.id.txt_local_hotel);
        lst_lugares = (ListView) findViewById(R.id.lst_lugares);

        //preencherAdapter();

        new categoria().execute();

        lst_lugares.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(context, "clicoou" + position, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(context, QuartoAllActivity.class));
            }
        });
    }



    private class categoria extends AsyncTask<Void,Void,Void> {
        MelhoresDestinos[] melhoresDestinos_lst;
        @Override
        protected Void doInBackground(Void... voids) {
            Intent intent = getIntent();
            categoria = getIntent().getExtras().getInt("idCategoria");

            String praia = LugaresActivity.this.getString(R.string.endServidor)+"home.php?id_categoria="+categoria;
            String jsonPraia = HttpConnection.get(praia);
            Gson gson = new Gson();
            melhoresDestinos_lst = gson.fromJson(jsonPraia,MelhoresDestinos[].class);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            MelhoresDestinosAdapter adapter = new MelhoresDestinosAdapter(LugaresActivity.this.context, R.layout.list_view_hotel, melhoresDestinos_lst);
            lst_lugares.setAdapter(adapter);
        }
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
