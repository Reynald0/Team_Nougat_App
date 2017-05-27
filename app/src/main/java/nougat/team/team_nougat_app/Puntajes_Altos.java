package nougat.team.team_nougat_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

public class Puntajes_Altos extends AppCompatActivity
{
    TableLayout tabla_jugadores;
    private final int CANTIDAD_TOP_JUGADORES = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntajes__altos);
        tabla_jugadores = (TableLayout)findViewById(R.id.tl_tabla_jugadores);

        DatabaseHandler db = new DatabaseHandler(this);
        List<Jugador> top_jugadores = db.getTopJugadores(CANTIDAD_TOP_JUGADORES);

        for(Jugador jugador : top_jugadores)
        {
            TableRow tr = new TableRow(this);
            tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
            tr.setPadding(0,0,0,50);
            tr.setGravity(Gravity.CENTER_HORIZONTAL);
            TextView tv_nick = new TextView(this);
            tv_nick.setText(jugador.getNick());
            tv_nick.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            tr.addView(tv_nick);
            TextView tv_puntaje = new TextView(this);
            tv_puntaje.setText("" + jugador.getPuntuacion());
            tv_puntaje.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            tr.addView(tv_puntaje);
            tabla_jugadores.addView(tr);
        }
    }
}
