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
    private List<String> lista_nombre_banderas;

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
        int contador = 1;
        List<String> opciones = new ArrayList<String>();
        try
        {
            opciones.add(bandera_elegida.getNombre());
        }
        catch (Exception e)
        {
            System.out.println("Debes generar una bandera primero antes de pedir los valores");
            opciones.add("Revisa la clase");
            return opciones;
        }


        while(contador < semaforo && opciones.size() < lista_nombre_banderas.size()) //Rellena las opciones
        {
            posicion_elegida = rnd.nextInt(lista_nombre_banderas.size());
            nombre_elegido = lista_nombre_banderas.get(posicion_elegida);

            if(opciones.contains(nombre_elegido))
                continue;


            opciones.add(nombre_elegido);
            contador++;
        }

        List<String> opciones_azar = new ArrayList<String>();

        while(!opciones.isEmpty()) // Agarra al azar y los deja en una nueva lista (opciones_azar)
        {
            int posicion = rnd.nextInt(opciones.size());
            opciones_azar.add(opciones.get(posicion));
            opciones.remove(posicion);
        }

        return opciones_azar;
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
        if (banderas.isEmpty())
            return false;
        return true;
    }
}
