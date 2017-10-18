package br.com.tourdreams.app;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.Timer;
import java.util.TimerTask;


public class QuartosActivity extends BaseActivity {
    TextView txt_nome_do_hotel,txt_nome_quarto,txt_preco_quarto,txt_caracteristicas;
    ViewPager img_quarto;
   // ImageView img_quarto;

    Context context;

    LinearLayout sliderDots;
    private int dotscount;
    private ImageView [] dots;
    Toolbar small;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        definirConteudo(R.layout.activity_quartos);
        context = this;
        txt_nome_do_hotel = (TextView) findViewById(R.id.txt_nome_do_hotel);
        txt_nome_quarto = (TextView) findViewById(R.id.txt_nome_quarto);
        txt_preco_quarto = (TextView) findViewById(R.id.txt_preco_quarto);
        txt_caracteristicas = (TextView) findViewById(R.id.txt_caracteristicas);
        img_quarto = (ViewPager) findViewById(R.id.img_quarto);

        sliderDots = (LinearLayout) findViewById(R.id.sliderDots);
        small = (Toolbar) findViewById(R.id.small);

        small.setVisibility(View.GONE);

        // imagens do slide
        viewPagerAdapter viewPagerAdapter = new viewPagerAdapter(this);
        img_quarto.setAdapter(viewPagerAdapter);

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

        img_quarto.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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

    public class MyTimeTask extends TimerTask {

        @Override
        public void run() {
            QuartosActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(img_quarto.getCurrentItem()==0){
                        img_quarto.setCurrentItem(1);
                    }else if (img_quarto.getCurrentItem()==1){
                        img_quarto.setCurrentItem(2);

                    }else{
                        img_quarto.setCurrentItem(0);
                    }
                }
            });
        }
    }

    public void reservar(View view){
        startActivity(new Intent(this,ReservaActivity.class));
    }
}
