package nougat.team.team_nougat_app;

/**
 * Created by Reynald0 on 01/05/2017.
 */

public enum Bandera {
    MEXICO ("México","RUTA_BANDERA", "América");

    private final String nombre;
    private final String ruta;
    private final String continente;

    Bandera(String nombre, String ruta, String continente) {
        this.nombre = nombre;
        this.ruta = ruta;
        this.continente = continente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public String getContinente() {
        return continente;
    }


    // DEMO
    // Bandera banderita_mexico = Bandera.MEXICO;
    // System.out.println(banderita_mexico.getContinente());
}
