package nougat.team.team_nougat_app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Reynald0 on 06/05/2017.
 */

public class BanderaAleatoria
{
    private List<Bandera> banderas;
    private Random rnd;
    private Bandera bandera_elegida;

    public BanderaAleatoria()
    {
        rnd = new Random();
        banderas = new ArrayList<Bandera>();
        for (Bandera banderita : Bandera.values())
        {
            banderas.add(banderita);
        }
    }

    public void obtenerBanderaAleatoria()
    {
        if (banderas.isEmpty())
            return; //No hay nada se acaba

        int posicion_elegida = rnd.nextInt(banderas.size()); // Obtiene una posicion al azar de la lista
        bandera_elegida = banderas.get(posicion_elegida);    // la asigna a la variable global
        banderas.remove(posicion_elegida); //Como ya se eleigio esa bandera se remueve de la LISTA
    }

    public String getNombre()
    {
        return bandera_elegida.getNombre();
    }

    public int getRuta()
    {
        return bandera_elegida.getRuta();
    }

    public Bandera getBandera()
    {
        return bandera_elegida;
    }
}
