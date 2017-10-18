package br.com.tourdreams.app;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;

public class Chat extends AppCompatActivity {
    FloatingActionMenu materialDesignFAM;
    FloatingActionButton msg_recente, msg_nova;
    List<Parceiro> lst_parceiro = new ArrayList<>();
    ListView list_msg;
    LinearLayout linear_msg,linear_chat;
    ParceiroAdapter adapter;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);
        context = this;
        floatingButton();

        linear_chat = (LinearLayout) findViewById(R.id.linear_chat);
        linear_msg = (LinearLayout) findViewById(R.id.linear_msg);
        linear_msg.setVisibility(View.INVISIBLE);
        list_msg = (ListView) findViewById(R.id.list_msg);

        lst_parceiro.add(new Parceiro("Francisco","Dono do Hotel LALAALA",R.drawable.account));
        lst_parceiro.add(new Parceiro("Francisco","Dono do Hotel LALAALA",R.drawable.carinha));
        lst_parceiro.add(new Parceiro("Francisco","Dono do Hotel LALAALA",R.drawable.carinha2));

        adapter = new ParceiroAdapter(context,R.layout.modelo,lst_parceiro);
        list_msg.setAdapter(adapter);
    }

    public void floatingButton(){
        materialDesignFAM = (FloatingActionMenu) findViewById(R.id.floating_menu);
        msg_recente = (FloatingActionButton) findViewById(R.id.msg_recente);
        msg_nova = (FloatingActionButton) findViewById(R.id.msg_nova);

        msg_recente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                linear_chat.setVisibility(View.GONE);
                linear_msg.setVisibility(View.VISIBLE);
            }
        });
        msg_nova.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(context,LoginActivity.class));
            }
        });
    }
    public void enviar(View view) {
        Toast.makeText(context,"Menssagem enviada",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(context,PerfilActivity.class));
    }
}
