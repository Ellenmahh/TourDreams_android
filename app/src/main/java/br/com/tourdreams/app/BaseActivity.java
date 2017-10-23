package br.com.tourdreams.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import static br.com.tourdreams.app.R.id.small;

/**
 * Created by 15251365 on 11/09/2017.
 */

public class BaseActivity  extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar small;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        small = (Toolbar) findViewById(R.id.small);


        small.setVisibility(View.GONE);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void definirConteudo(int layout){
        RelativeLayout r = (RelativeLayout) findViewById(R.id.layout_conteudo);
        View v = LayoutInflater.from(this).inflate(layout, null);
        r.addView(v);

    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.home) {
            startActivity( new Intent(this,MainActivity.class));
        }  else if (id == R.id.faleConosco) {
            startActivity (new Intent(this,FaleConoscoActivity.class));
        } else if (id == R.id.sobre) {
            startActivity(new Intent(this, SobreActivity.class));
        } else if (id == R.id.entrar) {
            startActivity(new Intent(this, LoginActivity.class));
        }else if (id == R.id.conheca_seu_destino) {
            startActivity(new Intent(this, ConhecaSeuDestinoActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void perfilUser(View view){

        startActivity(new Intent(this,PerfilActivity.class));
    }


}
