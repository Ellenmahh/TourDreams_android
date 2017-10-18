package br.com.tourdreams.app;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Ellen on 27/09/2017.
 */

public class viewPagerAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private Integer [] imagensStr = {R.drawable.bannerpromocao,R.drawable.bannerpromocao2,R.drawable.bannerpromocao3};
    //private String[] imagensStr;

    public viewPagerAdapter(Context context /*String[] imagensStr*/) {
        this.context = context;
        //this.imagensStr = imagensStr;
    }

    @Override
    public int getCount() {
        return imagensStr.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.custom_layout,null);
        ImageView imageView = (ImageView) view.findViewById(R.id.img_custom);
        imageView.setImageResource(imagensStr[position]);

        //String imagem = "http://10.107.134.16/20172sem/Andrey/TourDreams/" +imagensStr[position];
        //String imagem = "http://10.107.134.26/inf4t/Andrey/TourDreams/" +imagensStr[position];
      //  String imagem = "http://10.107.144.17/inf4t/TourDreams/" +imagensStr[position];
        //String imagem = "http://localhost/Projetos/TourDreams/API/"+imagensStr[position];

        //Log.d("instantiateItem", imagem);

        //Picasso.with(context).load(imagem).into(imageView);

        ViewPager vp = (ViewPager) container;
        vp.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }

}
