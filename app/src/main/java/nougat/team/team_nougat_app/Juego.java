package nougat.team.team_nougat_app;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Juego extends AppCompatActivity implements View.OnClickListener
{
    private ImageView vista_bandera;
    private BanderaAleatoria bandera_azar;
    private String nombre_bandera = "";
    private int ruta_bandera = 0;
    private List<String> opciones;
    private Button opcion_1;
    private Button opcion_2;
    private Button opcion_3;
    private Button opcion_4;
    private Button boton_presionado;
    private int vidas = 3;
    private int puntaje = 0;
    private ImageView vida1;
    private ImageView vida2;
    private ImageView vida3;
    private TextView tv_puntaje;
    private MediaPlayer sonido_fondo;
    private MediaPlayer correcto;
    private MediaPlayer incorrecto;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        sonido_fondo = MediaPlayer.create(this,R.raw.midnightidea);
        sonido_fondo.setLooping(true);
        sonido_fondo.setVolume(100,100);
        sonido_fondo.start();
        incorrecto = MediaPlayer.create(this, R.raw.buttondiez);
        correcto = MediaPlayer.create(this, R.raw.correcto);
        opcion_1 = (Button) findViewById(R.id.btn_opcion_1);
        opcion_1.setOnClickListener(this);
        opcion_2 = (Button) findViewById(R.id.btn_opcion_2);
        opcion_2.setOnClickListener(this);
        opcion_3 = (Button) findViewById(R.id.btn_opcion_3);
        opcion_3.setOnClickListener(this);
        opcion_4 = (Button) findViewById(R.id.btn_opcion_4);
        opcion_4.setOnClickListener(this);
        bandera_azar = new BanderaAleatoria();
        vista_bandera = (ImageView) findViewById(R.id.iv_Bandera);
        vida1 = (ImageView)findViewById(R.id.vida1);
        vida2 = (ImageView)findViewById(R.id.vida2);
        vida3 = (ImageView)findViewById(R.id.vida3);
        tv_puntaje = (TextView)findViewById(R.id.lblPuntaje);
        tv_puntaje.setText("Puntaje: 0");
        crearNuevaRonda();
    }

    private void crearNuevaRonda()
    {
        //Si hay banderas disponibles
        if(bandera_azar.hayBanderas())
        {
            bandera_azar.obtenerBanderaAleatoria();
            opciones = bandera_azar.getOpciones(4);
            opcion_1.setText(opciones.get(0));
            opcion_2.setText(opciones.get(1));
            opcion_3.setText(opciones.get(2));
            opcion_4.setText(opciones.get(3));
            nombre_bandera = bandera_azar.getNombre();
            ruta_bandera = bandera_azar.getRuta();
            vista_bandera.setImageResource(ruta_bandera);
        }
        else //Si no hay banderas, es que llegaste al final del juego sin morir
        {
            Toast.makeText(this,"GANASTE,SOS LOCO!",Toast.LENGTH_SHORT).show();
            this.finish();
        }
    }

    @Override
    public void onClick(View v)
    {
        if (v instanceof  Button)
        {
            boton_presionado = (Button)v;
            //Si la opcion es la correcta
            if(boton_presionado.getText().toString().equalsIgnoreCase(nombre_bandera))
            {
                puntaje = puntaje + 10;//Aumenta el puntaje en 10 si aciertas
                tv_puntaje.setText("Puntaje: "+ puntaje);
                correcto.start();
                crearNuevaRonda();
            }
            //Si no si es la opcion incorrecta
            else if(boton_presionado.getText().toString()!= nombre_bandera)
            {
                if(puntaje > 1)
                    puntaje = puntaje - 10;// Si fallas pierdes una vida y 10 puntos ;)

                tv_puntaje.startAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
                tv_puntaje.setText("Puntaje: "+ puntaje);
                incorrecto.start();

                // Empieza el control de las vidas, un corazon gris por cada vida perdida
                if(vidas == 0)
                {
                    // Cuando llega a 0 el numero de vidas, se termina el juego
                    Toast.makeText(this,"Perdiste!!! Suerte la próxima!!!",Toast.LENGTH_SHORT).show();
                    this.finish();
                }
                else if (vidas == 3)
                {
                    vidas--;
                    vida1.startAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));
                    vida1.setImageResource(R.drawable.muerte);
                    crearNuevaRonda();
                }
                else if (vidas == 2)
                {
                    vidas--;
                    vida2.startAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));
                    vida2.setImageResource(R.drawable.muerte);
                    crearNuevaRonda();
                }
                else if (vidas == 1)
                {
                    vidas--;
                    vida3.startAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));
                    vida3.setImageResource(R.drawable.muerte);
                    crearNuevaRonda();
                }
            }
        }
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

    //Metodo experimental para solicitar el puntaje
    public void solicitar()
    {
        LayoutInflater layoutInflater = LayoutInflater.from(Juego.this);
        View promptView = layoutInflater.inflate(R.layout.puntaje_alto, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Juego.this);
        alertDialogBuilder.setView(promptView);
        alertDialogBuilder.setTitle("Felicidades!!!");
        final EditText game_targ = (EditText)promptView.findViewById(R.id.txtNick);
        // setup a dialog window
        alertDialogBuilder.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                try
                {
                    //Accion
                } catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(), "Mensaje no enviado", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });// create an alert dialog
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }
}
