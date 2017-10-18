package br.com.tourdreams.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import br.com.bloder.magic.view.MagicButton;

public class MainActivity extends BaseActivity {
    TextView txt_nomee_hotel, txt_preco_hotel, txt_local_hotel;
    ImageView img_hotel, img_logo;
    Context context;
    MagicButton chat_usuario;
    ViewPager banner_promocao;
    LinearLayout sliderDots;
    private int dotscount;
    private ImageView[] dots;
    ListView lst_main;
    List<Hotel> lstHotel = new ArrayList<>();
    HotelAdapter adapter;

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
            banner_promocao.setVisibility(View.GONE);
            sliderDots.setVisibility(View.GONE);
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        definirConteudo(R.layout.content_main);
        context = this;

        txt_nomee_hotel = (TextView) findViewById(R.id.txt_nomee_hotel);
        txt_local_hotel = (TextView) findViewById(R.id.txt_local_hotel);
        txt_preco_hotel = (TextView) findViewById(R.id.txt_preco_hotel);
        img_hotel = (ImageView) findViewById(R.id.img_hotel);
        img_logo = (ImageView) findViewById(R.id.img_logo);
        banner_promocao = (ViewPager) findViewById(R.id.banner_promocao);
        sliderDots = (LinearLayout) findViewById(R.id.sliderDots);
        lst_main = (ListView) findViewById(R.id.lst_main);

        chat_usuario = (MagicButton) findViewById(R.id.chat_usuario);

        chat_usuario.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"conversa",Toast.LENGTH_SHORT).show();
                startActivity(new Intent (context,Chat.class));
            }
        });

        LayoutInflater inflate = LayoutInflater.from(context);
        inflate.inflate(R.layout.small_bar,null);

        preencherAdapter();
        CliqueDaLista();

        // imagens do slide
         viewPagerAdapter viewPagerAdapter = new viewPagerAdapter(this);
                banner_promocao.setAdapter(viewPagerAdapter);

                        // definindo os pontos de passagem do slide_promocao
                               dotscount = viewPagerAdapter.getCount();
                dots = new ImageView[dotscount];

                        // definingo a imagem dos pontos do slide_promocao
                                for(int i = 0; i <dotscount; i++){
                        dots[i] = new ImageView(this);
                        dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactive_dot));

                                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                                       LinearLayout.LayoutParams.WRAP_CONTENT,
                                        LinearLayout.LayoutParams.WRAP_CONTENT);
                        params.setMargins(8,0,8,0);
                        sliderDots.addView(dots[i],params);
                    }
                dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));

        banner_promocao.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i = 0; i <dotscount; i++) {

                    dots[i].setImageDrawable(ContextCompat.getDrawable(context, R.drawable.nonactive_dot));
                    dots[position].setImageDrawable(ContextCompat.getDrawable(context, R.drawable.active_dot));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        // definindo o tempo de passagem das imagens do slide_promocao
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimeTask(), 2000, 4000);
    }

    public void btn_filtro_sheet(View view) {
        Toast.makeText(this,"bottom sheet",Toast.LENGTH_SHORT).show();
        CustomBottomSheetDialog dialog = new CustomBottomSheetDialog(this);
        dialog.show();
       /*Bundle bundle = new Bundle();
        bundle.putStringArray();
       CustomBottomSheetDialog fragment = new CustomBottomSheetDialog();
*/
    }
    public class MyTimeTask extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(banner_promocao.getCurrentItem()==0){
                        banner_promocao.setCurrentItem(1);
                    }else if (banner_promocao.getCurrentItem()==1){
                        banner_promocao.setCurrentItem(2);

                    }else{
                        banner_promocao.setCurrentItem(0);
                    }
                }
            });
        }

    }
    private void CliqueDaLista() {
        lst_main.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(context,"clicoou"+position,Toast.LENGTH_SHORT).show();
                startActivity(new Intent(context,QuartosActivity.class));

            }
        });
    }
    public void verQuarto(View view){
        startActivity(new Intent(this,QuartosActivity.class));
    }
    private void preencherAdapter() {

        // adicionando hoteis a lista
        lstHotel.add(new Hotel("hotelLALALA", 299.00, "Sao sao sao", R.drawable.hotel));
        lstHotel.add(new Hotel("hotelLULULU", 299.00, "Sao sao sao", R.drawable.quarto));
        lstHotel.add(new Hotel("hotelLALALA", 299.00, "Sao sao sao", R.drawable.hotel));

        adapter = new HotelAdapter(this, R.layout.list_view_hotel, lstHotel);
        lst_main.setAdapter(adapter);
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
