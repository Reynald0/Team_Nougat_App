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
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mediaPlayer = MediaPlayer.create(this,R.raw.fondo);
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(100,100);
        mediaPlayer.start();

    }

    public void puntaje(View v)
    {
       /*mp = MediaPlayer.create(this,R.raw.victoria);
        mp.start();*/
        MediaPlayer mp = MediaPlayer.create(this, R.raw.buttoncerodos);
        mp.start();
    }

    public void play(View v)
    {
        /*mp = MediaPlayer.create(this,R.raw.bm);
        mp.start();*/
        if (mediaPlayer != null)
        {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        Intent i = new Intent(this, Juego.class);
        startActivity(i);
        MediaPlayer mp = MediaPlayer.create(this, R.raw.buttoncerodos);
        mp.start();
    }
    public void salir(View v)
    {
        this.finish();
    }

      @Override
    protected void onRestart() {
        super.onRestart();
        mediaPlayer = MediaPlayer.create(this,R.raw.fondo);
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(100,100);
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null)
        {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }
}
