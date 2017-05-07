package nougat.team.team_nougat_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class Juego extends AppCompatActivity {
    private ImageView vista_bandera;
    private BanderaAleatoria bandera_azar;
    private String nombre_bandera ="";
    int ruta_bandera =0;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        vista_bandera = (ImageView) findViewById(R.id.iv_Bandera);
        bandera_azar = new BanderaAleatoria();
        bandera_azar.obtenerBanderaAleatoria();
        nombre_bandera = bandera_azar.getNombre();
        ruta_bandera = bandera_azar.getRuta();
        Toast.makeText(this, nombre_bandera + " - " + ruta_bandera, Toast.LENGTH_LONG).show();
        vista_bandera.setImageResource(ruta_bandera);
    }

}
