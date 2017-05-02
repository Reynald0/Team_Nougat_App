package nougat.team.team_nougat_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaPlayer mediaPlayer;
        mediaPlayer = MediaPlayer.create(this,R.raw.fondo);
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(100,100);
        mediaPlayer.start();
    }


    public void Puntajesaltos(View v) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.bm);
        mp.start();
    }

    public void Jugar(View v) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.bm);
        mp.start();
    }
    public void Configuracion(View v) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.bm);
        mp.start();
    }
}
