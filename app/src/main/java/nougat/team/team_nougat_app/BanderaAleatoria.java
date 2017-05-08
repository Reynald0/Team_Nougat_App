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
    List<String> lista_nombre_banderas;
    private boolean banderas_disponibles = true;

    public BanderaAleatoria()
    {
        rnd = new Random();
        banderas = new ArrayList<Bandera>();
        lista_nombre_banderas = new ArrayList<String>();
        for (Bandera banderita : Bandera.values())
        {
            banderas.add(banderita);
            lista_nombre_banderas.add(banderita.getNombre());
        }
    }

    public void obtenerBanderaAleatoria()
    {
        if (banderas.isEmpty())
        {
            banderas_disponibles = false;
            return; //No hay nada se acaba
        }


        int posicion_elegida = rnd.nextInt(banderas.size()); // Obtiene una posicion al azar de la lista
        bandera_elegida = banderas.get(posicion_elegida);    // la asigna a la variable global
        banderas.remove(posicion_elegida); //Como ya se eleigio esa bandera se remueve de la LISTA
    }

    /**
     * @param numero_opciones : Cantidad de  opciones a elegir de manera aleatoria.
     */
    public List<String> getOpciones(int numero_opciones)
    {
        int semaforo = numero_opciones;
        if (numero_opciones > lista_nombre_banderas.size())
            semaforo = lista_nombre_banderas.size();

        String nombre_elegido = "";
        int posicion_elegida = 0;
        int contador = 0;
        List<String> opciones = new ArrayList<String>();


        while(contador < semaforo && opciones.size() < semaforo)
        {
            posicion_elegida = rnd.nextInt(lista_nombre_banderas.size());
            nombre_elegido = lista_nombre_banderas.get(posicion_elegida);

            if(opciones.contains(nombre_elegido))
            {
                System.out.println("SE REPITE");
                continue;
            }


            opciones.add(nombre_elegido);
            contador++;
        }
        return opciones;
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

    public boolean hayBanderas()
    {
        return banderas_disponibles;
    }
}
