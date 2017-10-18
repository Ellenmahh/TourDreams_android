package br.com.tourdreams.app;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import br.com.bloder.magic.view.MagicButton;
import br.com.tourdreams.app.cmlibrary.CircleMenu;
import br.com.tourdreams.app.cmlibrary.OnMenuSelectedListener;

public class PerfilActivity extends BaseActivity {
    Context context;
    MagicButton chat_usuario;
    TextView adquirir, oqMtf;
    EditText edit_avaliacao;
    RatingBar avalacao_estrelas;
    Button avaliar;
    String arrayCicle[] = {"Editar","transacoes","sair"};
    private LayoutInflater linear_chat ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        definirConteudo(R.layout.activity_perfil);
        context = this;
        adquirir =(TextView) findViewById(R.id.adquirir);
        oqMtf =(TextView) findViewById(R.id.oqMtf);
        edit_avaliacao= (EditText) findViewById(R.id.edit_avaliacao);
        avalacao_estrelas = (RatingBar) findViewById(R.id.avalacao_estrelas);
        avaliar = (Button) findViewById(R.id.avaliar);

        chat_usuario = (MagicButton) findViewById(R.id.chat_usuario);
        chat_usuario.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"conversa",Toast.LENGTH_SHORT).show();
                startActivity(new Intent (context,Chat.class));
            }
        });

       CircleMenu circleMenu = (CircleMenu) findViewById(R.id.cicle_menu);
        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"),R.drawable.ic_add_black_24dp,R.drawable.ic_remove_black_24dp);
        circleMenu.addSubMenu(Color.parseColor("#258CFF"),R.drawable.ic_mode_edit_black_24dp)
                .addSubMenu(Color.parseColor("#cd4c41"),R.drawable.ic_reorder_black_24dp)
                .addSubMenu(Color.parseColor("#CDCDCD"),R.drawable.ic_settings_power_black_24dp)
               .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                   @Override
                   public void onMenuSelected(int i) {

                       switch (i){
                           case 1:
                               Toast.makeText(context,"transações",Toast.LENGTH_SHORT).show();
                               break;
                           case 2:
                               Toast.makeText(context,"sair",Toast.LENGTH_SHORT).show();
                               break;
                           case 3:
                               Toast.makeText(getApplicationContext(),"editar",Toast.LENGTH_SHORT).show();
                               break;
                       }
                       if(i==2){
                           startActivity(new Intent(context,LoginActivity.class));
                       }else if (i==3){
                           startActivity(new Intent(context,CadastrarUserActivity.class));
                       }
                   }
               });
    }
    public void adquirir(View view) {
        Toast.makeText(this,"aquirir",Toast.LENGTH_SHORT).show();
        CustomBottomSheetDialog dialog = new CustomBottomSheetDialog(this);
        dialog.show();
    }
    public void oqMtf(View view) {
        Toast.makeText(this,"mtf",Toast.LENGTH_SHORT).show();
        CustomBottomSheetDialog dialog = new CustomBottomSheetDialog(this);
        dialog.lst_sheet.add("Milhas trevel Fidelidade");

        dialog.show();
    }

    public void avaliacao(View view) {
        Toast.makeText(this,"Faça um comentário/Avaliação",Toast.LENGTH_SHORT).show();
        edit_avaliacao.setVisibility(View.VISIBLE);
        avalacao_estrelas.setVisibility(View.VISIBLE);
        avaliar.setVisibility(View.VISIBLE);
    }
    public void avaliar (View view) {
        Toast.makeText(this,"Obrigado! Sua avaliação é muito importante pra nós",Toast.LENGTH_LONG).show();
        edit_avaliacao.setVisibility(View.GONE);
        avalacao_estrelas.setVisibility(View.GONE);
        avaliar.setVisibility(View.GONE);
    }

}
