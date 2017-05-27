package nougat.team.team_nougat_app;

/**
 * Created by Reynaldo on 27/05/2017.
 */

public class Jugador
{

    private int id;
    private String nick;
    private int puntuacion;

    public Jugador()
    {
    }

    public Jugador(int id, String nick, int puntuacion)
    {
        this.id = id;
        this.nick = nick;
        this.puntuacion = puntuacion;
    }

    public Jugador(String nick, int puntuacion)
    {
        this.nick = nick;
        this.puntuacion = puntuacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}
