package nougat.team.team_nougat_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private BanderaAleatoria bandera_azar;
    private MediaPlayer musica_fondo;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bandera_azar = new BanderaAleatoria();
        /*musica_fondo = MediaPlayer.create(this,R.raw.fondo3);
        musica_fondo.setLooping(true);
        musica_fondo.setVolume(100,100);
        musica_fondo.start();*/
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        musica_fondo.stop();
        mp.stop();
    }

    public void puntaje(View v)
    {
       /*mp = MediaPlayer.create(this,R.raw.victoria);
        mp.start();*/
    }

    public void play(View v)
    {
        /*mp = MediaPlayer.create(this,R.raw.bm);
        mp.start();*/
    }
    public void conf(View v)
    {
       /* mp = MediaPlayer.create(this,R.raw.bm);
        mp.start();*/
    }

    public void elegirBanderaAlAzar(View v)
    {
        // Este metodo imprime en pantalla el NOMBRE y RUTA (R.drawable.XXXXX) de la bandera
        // OJO las variables estan arriba de manera global y se inicializa en el ONCREATE del activity

        bandera_azar.obtenerBanderaAleatoria();
        String nombre_bandera = bandera_azar.getNombre();
        int ruta_bandera = bandera_azar.getRuta();
        Toast.makeText(this, nombre_bandera + " - " +  ruta_bandera, Toast.LENGTH_LONG).show();
    }
}
