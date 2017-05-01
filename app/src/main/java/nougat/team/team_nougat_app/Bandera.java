package nougat.team.team_nougat_app;

/**
 * Created by Reynald0 on 01/05/2017.
 */

public enum Bandera {
    MEXICO ("México",R.drawable.mexico, "América");

    private final String nombre;
    private final int ruta; //El tipo de dato para R.drawable.mexico es INT
    private final String continente;

    Bandera(String nombre, int ruta, String continente) {
        this.nombre = nombre;
        this.ruta = ruta;
        this.continente = continente;
    }

    public String getNombre() {
        return nombre;
    }

    public int getRuta() {
        return ruta;
    }

    public String getContinente() {
        return continente;
    }


    // DEMO
    // Bandera banderita_mexico = Bandera.MEXICO;
    // System.out.println(banderita_mexico.getContinente());
}
