package nougat.team.team_nougat_app;

import java.util.Random;

/**
 * Created by Reynald0 on 06/05/2017.
 */

public class BanderaAleatoria
{
    Bandera[] banderas;
    Random rnd;
    Bandera bandera_elegida;

    public BanderaAleatoria()
    {
        rnd = new Random();
        banderas = Bandera.values();
    }

    public void obtenerBanderaAleatoria() // Obtiene una posicion al azar del ENUM y la asigna a la variable global
    {
        int posicion_bandera_elegida = rnd.nextInt(banderas.length);
        bandera_elegida = banderas[posicion_bandera_elegida];
    }

    public String getNombre()
    {
        return bandera_elegida.getNombre();
    }

    public int getRuta()
    {
        return bandera_elegida.getRuta();
    }
}
