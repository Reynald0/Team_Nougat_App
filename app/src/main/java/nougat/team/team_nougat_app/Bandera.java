package nougat.team.team_nougat_app;

/**
 * Created by Reynald0 on 01/05/2017.
 * USO
 * Bandera banderita_mexico = Bandera.MEXICO;
 * System.out.println(banderita_mexico.getContinente());
 */

public enum Bandera
{
    ANTIGUA("Antigua y Barbuda", R.drawable.antigua_barbuda),
    ARGENTINA("Argentina", R.drawable.argentina),
    BAHAMAS("Bahamas", R.drawable.bahamas),
    BARBADOS("Barbados", R.drawable.barbados),
    BELICE("Belice", R.drawable.belize),
    BOLIVIA("Bolivia", R.drawable.bolivia),
    BRASIL("Brasil", R.drawable.brazil),
    CANADA("Canada",R.drawable.canada),
    CHILE("Chile", R.drawable.chile),
    COLOMBIA("Colombia", R.drawable.colombia),
    COSTA_RICA("Costa Rica", R.drawable.costa_rica),
    CUBA("Cuba", R.drawable.cuba),
    DOMINICA("Dominica", R.drawable.dominica),
    DOMINICANA("Republica Dominicana", R.drawable.dominican_republic),
    ECUADOR("Ecuador", R.drawable.ecuador),
    EL_SALVADOR("El Salvador", R.drawable.el_salvador),
    GRANADA("Granada", R.drawable.grenada),
    GUATEMALA("Guatemala", R.drawable.guatemala),
    GUYANA("Guyana", R.drawable.guyana),
    HAITI("Haiti", R.drawable.haiti),
    HONDURAS("Honduras", R.drawable.honduras),
    JAMAICA("Jamaica", R.drawable.jamaica),
    MEXICO("Mexico", R.drawable.mexico),
    NICARAGUA("Nicaragua", R.drawable.nicaragua),
    PANAMA("Panama", R.drawable.panama),
    PARAGUAY("Paraguay", R.drawable.paraguay),
    PERU("Peru", R.drawable.peru),
    SAINT_KITTS("Saint Kitts y Nevis", R.drawable.saint_kitts_and_nevis),
    SAN_VICENTE("San Vicente y las Granadinas", R.drawable.saint_vincent_and_the_grenadines),
    SANTA_LUCIA("Santa Lucia", R.drawable.saint_lucia),
    SURINAME("Suriname", R.drawable.suriname),
    TRINIDAD_TOBAGO("Trinidad y Tobago", R.drawable.trinidad_and_tobago),
    URUGUAY("Uruguay", R.drawable.uruguay),
    USA("Estados Unidos", R.drawable.united_states_of_america),
    VENEZUELA("Venezuela", R.drawable.venezuela);

    private final String nombre;
    private final int ruta; //El tipo de dato para R.drawable.mexico es INT

    Bandera(String nombre, int ruta)
    {
        this.nombre = nombre;
        this.ruta = ruta;
    }

    public String getNombre()
    {
        return nombre;
    }

    public int getRuta()
    {
        return ruta;
    }
}
