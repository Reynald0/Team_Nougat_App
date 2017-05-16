package nougat.team.team_nougat_app;

import android.content.Intent;
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

    public void puntaje(View v)
    {
       /*mp = MediaPlayer.create(this,R.raw.victoria);
        mp.start();*/
    }

    public void play(View v)
    {
        /*mp = MediaPlayer.create(this,R.raw.bm);
        mp.start();*/
        Intent i = new Intent(this, Juego.class);
        startActivity(i);
    }
    public void conf(View v)
    {
       /* mp = MediaPlayer.create(this,R.raw.bm);
        mp.start();*/
    }

    public void configuraciones(View V)
    {
        Intent intent =new Intent(this,Configuraciones.class);
        startActivity(intent);
    }
}
