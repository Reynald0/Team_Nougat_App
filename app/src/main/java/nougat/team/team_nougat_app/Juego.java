package nougat.team.team_nougat_app;

import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Juego extends AppCompatActivity implements View.OnClickListener
{
    private ImageView vista_bandera;
    private BanderaAleatoria bandera_azar;
    private String nombre_bandera ="";
    private int ruta_bandera =0;
    private List<String> opciones;
    private Button opcion_1;
    private Button opcion_2;
    private Button opcion_3;
    private Button opcion_4;
    private Button boton_presionado;
    private int VIDAS=3;
    private int PUNTAJE=0;//Puntaje del juego
    private ImageView vida1,vida2,vida3;
    private TextView puntaje;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        MediaPlayer mediaPlayer;
        mediaPlayer = MediaPlayer.create(this,R.raw.midnightidea);
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(100,100);
        mediaPlayer.start();
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
        vida1=(ImageView)findViewById(R.id.vida1);
        vida2=(ImageView)findViewById(R.id.vida2);
        vida3=(ImageView)findViewById(R.id.vida3);
        puntaje=(TextView)findViewById(R.id.lblPuntaje);
        puntaje.setText("Puntaje: 0");//Iniciamos el puntaje en 0
        crearNuevaRonda();
    }

    private void crearNuevaRonda()
    {
        //Si hay banderas disponibles
        if(bandera_azar.hayBanderas())
        {
            bandera_azar.obtenerBanderaAleatoria();
           // System.out.println("BANDERA ESCOGIDA AZAR " + bandera_azar.getNombre());
            opciones = bandera_azar.getOpciones(4);
           // System.out.println("OPCIONES ELEGIDAS " + opciones.toString());
            opcion_1.setText(opciones.get(0));
           // System.out.println("OPCION 1 : "+  opciones.get(0));
            opcion_2.setText(opciones.get(1));
           // System.out.println("OPCION 2 : "+  opciones.get(1));
            opcion_3.setText(opciones.get(2));
           // System.out.println("OPCION 3 : "+  opciones.get(2));
            opcion_4.setText(opciones.get(3));
           // System.out.println("OPCION 4 : "+  opciones.get(3));
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
        //System.out.println("CLIC BANDERA NOMBRE ES : "+ nombre_bandera);
        if (v instanceof  Button)
        {
            boton_presionado = (Button)v;
          // System.out.println("CLIC EN BOTON CON TEXTO :"+boton_presionado.getText().toString()  +" ---- " + nombre_bandera);
            //Si la opcion es la corecta
            if(boton_presionado.getText().toString().equalsIgnoreCase(nombre_bandera))
            {
                PUNTAJE=PUNTAJE+10;//Aunmenta el puntaje en 10 si aciertas
                puntaje.setText("Puntaje: "+PUNTAJE);
                crearNuevaRonda();
                MediaPlayer mp = MediaPlayer.create(this, R.raw.correcto);
                mp.start();
            }
            //Si nos equivocamos de pais
            else if(boton_presionado.getText().toString()!=nombre_bandera)
            {
                PUNTAJE=PUNTAJE-10;//Si fallas pierdes una vida y 10 puntos ;)
                puntaje.setText("Puntaje: "+PUNTAJE);
                MediaPlayer rp = MediaPlayer.create(this, R.raw.buttondiez);
                rp.start();

                //Empieza el control de las vidas, un corazon gris por cada vida perdida
                if(VIDAS==0)
                {///Cuando llega a 0 el numero de vidas, se termina el juego

                    Toast.makeText(this,"Perdiste!!! Suerte la próxima!!!",Toast.LENGTH_SHORT).show();
                    this.finish();

                }
                else if (VIDAS==3)
                {
                    VIDAS--;
                    vida1.setImageResource(R.drawable.muerte);
                    crearNuevaRonda();
                }
                else if (VIDAS==2)
                {
                    VIDAS--;
                    vida2.setImageResource(R.drawable.muerte);
                    crearNuevaRonda();
                }
                else if (VIDAS==1)
                {
                    VIDAS--;
                    vida3.setImageResource(R.drawable.muerte);
                    crearNuevaRonda();

                }
            }
        }
    }

}
