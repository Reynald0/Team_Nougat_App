package nougat.team.team_nougat_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class Juego extends AppCompatActivity
{
    private ImageView vista_bandera;
    private BanderaAleatoria bandera_azar;
    private String nombre_bandera ="";
    int ruta_bandera =0;
    Button refrescar;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        bandera_azar = new BanderaAleatoria();
        vista_bandera = (ImageView) findViewById(R.id.iv_Bandera);
        refrescar=(Button)findViewById(R.id.bRefrescar) ;
        refrescar.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                generar();
            }
        });
        generar();
    }

    private void generar ()
    {
        if(bandera_azar.hayBanderas())
        {
            bandera_azar.obtenerBanderaAleatoria();
            nombre_bandera = bandera_azar.getNombre();
            ruta_bandera = bandera_azar.getRuta();
            //Toast.makeText(this, nombre_bandera + " - " + ruta_bandera, Toast.LENGTH_SHORT).show();
            vista_bandera.setImageResource(ruta_bandera);
        }
    }

}
