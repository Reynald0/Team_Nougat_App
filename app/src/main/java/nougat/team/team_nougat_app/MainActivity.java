package nougat.team.team_nougat_app;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{
    private MediaPlayer sonido_fondo;
    private ImageView sonido;
    int pos=0;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sonido=(ImageView)findViewById(R.id.iv_sonido);
        sonido.setImageResource(R.drawable.sonidoon);
        sonido_fondo = MediaPlayer.create(this,R.raw.fondo);
        sonido_fondo.setLooping(true);
        sonido_fondo.setVolume(100,100);
        sonido_fondo.start();
    }

    public void reproducirSonido(int sonido)
    {
        MediaPlayer mp = MediaPlayer.create(this, sonido);
        mp.start();
    }

    public void play(View v)
    {
        if (sonido_fondo != null)
        {
            sonido_fondo.setLooping(false);
            sonido_fondo.stop();
            sonido_fondo.reset();
            sonido_fondo.release();
            sonido_fondo = null;
        }
        Intent i = new Intent(this, Juego.class);
        startActivity(i);
        reproducirSonido(R.raw.boton);
    }

    public void verPuntajesAltos(View view)
    {
        if (sonido_fondo != null)
        {
            sonido_fondo.setLooping(false);
            sonido_fondo.stop();
            sonido_fondo.reset();
            sonido_fondo.release();
            sonido_fondo = null;
        }
        Intent i = new Intent(this, Puntajes_Altos.class);
        startActivity(i);
        reproducirSonido(R.raw.boton);
    }

    public void sonido(View V)
    {

        if (sonido_fondo.isPlaying())
        {
            sonido.setImageResource(R.drawable.sonidooff);
            sonido_fondo.pause();
            pos=sonido_fondo.getCurrentPosition();


        }
        else if (!sonido_fondo.isPlaying())
        {
            sonido.setImageResource(R.drawable.sonidoon);
            sonido_fondo.seekTo(pos);
            sonido_fondo.start();

        }

    }
    public void ver_informacion(View view)
    {
        Intent i = new Intent(this, Instrucciones.class);
        startActivity(i);
        reproducirSonido(R.raw.boton);
    }

    public void salir(View v)
    {
        this.finish();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        if(sonido_fondo != null)
            return;

        sonido_fondo = MediaPlayer.create(this,R.raw.fondo);
        sonido_fondo.setLooping(true);
        sonido_fondo.setVolume(100,100);
        sonido_fondo.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (sonido_fondo != null){
            sonido_fondo.pause();
            if (isFinishing()){
                sonido_fondo.stop();
                sonido_fondo.release();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (sonido_fondo != null){
            sonido_fondo.start();
        }
    }
}
