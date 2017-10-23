package br.com.tourdreams.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
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


public class ReservaActivity extends AppCompatActivity {
    TextView txt_nome_do_hotel,txt_nome_quarto,txt_preco_reserva,txt_caracteristicas, dt_check_in, dt_check_out,total_dias,total_valor;
    ImageView img_quarto,img_contem_caracteristica;
    Button btn_reservar;
    ViewPager slide_quartos;
    Context context;
    ListView lst_caract;
    CaracteristicasAdapter adapter;
    List <Caracteristicas> lst_caracteristica = new ArrayList<>();
    LinearLayout linear_reserva;
    LinearLayout linear_reserva_finalizar;
    LinearLayout sliderDots;
    private int dotscount;
    private ImageView [] dots;
    MagicButton conheca_seu_destino_magic,chat_magic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);
        context = this;
        findView();

        conheca_seu_destino_magic.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(context,ConhecaSeuDestinoActivity.class));
            }
        });

        chat_magic.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(context,Chat.class));
            }
        });

        lst_caracteristica.add(new Caracteristicas("Wifi",true,R.drawable.ic_wifi_black_24dp));
        lst_caracteristica.add(new Caracteristicas("Academia",true,R.drawable.ic_fitness_center_black_24dp));
        lst_caracteristica.add(new Caracteristicas("Spa",true,R.drawable.ic_spa_black_24dp));
        adapter = new CaracteristicasAdapter(context,R.layout.listview,lst_caracteristica);
        lst_caract.setAdapter(adapter);

        // imagens do slide
        viewPagerAdapter viewPagerAdapter = new viewPagerAdapter(this);
        slide_quartos.setAdapter(viewPagerAdapter);

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


        slide_quartos.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                for(int i = 0; i < dotscount; i++) {
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

    private void findView() {
        txt_nome_do_hotel = (TextView) findViewById(R.id.txt_nome_do_hotel);
        txt_nome_quarto = (TextView) findViewById(R.id.txt_nome_quarto);
        txt_preco_reserva = (TextView) findViewById(R.id.txt_preco_reserva);
        txt_caracteristicas = (TextView) findViewById(R.id.txt_caracteristicas);
        lst_caract = (ListView) findViewById(R.id.lst_caract);
        dt_check_in =(TextView) findViewById(R.id.data);
        dt_check_out =(TextView) findViewById(R.id.data2);
        total_dias =(TextView) findViewById(R.id.total_dias);
        total_valor =(TextView) findViewById(R.id.total_valor);
        slide_quartos = (ViewPager) findViewById(R.id.slide_quartos);
        sliderDots = (LinearLayout) findViewById(R.id.sliderDots);
        img_contem_caracteristica = (ImageView) findViewById(R.id.img_contem_caracteristica);
        linear_reserva = (LinearLayout) findViewById(R.id.linear_reserva);
        linear_reserva_finalizar = (LinearLayout) findViewById(R.id.linear_reserva_finalizar);
        btn_reservar = (Button) findViewById(R.id.btn_reservar);
        conheca_seu_destino_magic = (MagicButton) findViewById(R.id.conheca_seu_destino_magic);
        chat_magic = (MagicButton) findViewById(R.id.chat_magic);
    }

    public void checkIn(View view) {
        //Abrir o calendario
        DialogFragment calendario = new Calendario( dt_check_in );
        calendario.show(getSupportFragmentManager(), "datepicker");

    }
    public void checkOut(View view) {
        //Abrir o calendario
        DialogFragment calendario = new Calendario( dt_check_out );
        calendario.show(getSupportFragmentManager(), "datepicker");
    }
    public void reservar(View view) {
        linear_reserva.setVisibility(View.GONE);
        linear_reserva_finalizar.setVisibility(View.VISIBLE);
        btn_reservar.setText("FINALIZAR RESERVA");
        btn_reservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,PerfilActivity.class));
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {return false;}

    public class MyTimeTask extends TimerTask {

        @Override
        public void run() {
            ReservaActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(slide_quartos.getCurrentItem()==0){
                        slide_quartos.setCurrentItem(1);
                    }else if (slide_quartos.getCurrentItem()==1){
                        slide_quartos.setCurrentItem(2);

                    }else{
                        slide_quartos.setCurrentItem(0);
                    }
                }
            });
        }
    }

}
