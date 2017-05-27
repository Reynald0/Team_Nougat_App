package nougat.team.team_nougat_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hug0Albert0 on 25/05/2017.
 */

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "juego_db";
    private static final String TABLE_SCORE = "puntajes";

    private static final String KEY_ID = "id";
    private static final String KEY_NICK = "nick";
    private static final String KEY_PUNTUACION = "puntuacion";

    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String tabla_puntaje = "CREATE TABLE " + TABLE_SCORE + "("
                + KEY_ID + " INTEGER PRIMARY KEY PRIMARY KEY AUTOINCREMENT,"
                + KEY_NICK + " TEXT,"
                + KEY_PUNTUACION + " INTEGER" + ")";
        db.execSQL(tabla_puntaje);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORE);
        onCreate(db);
    }

    public void addJugador(Jugador jugador)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NICK, jugador.getNick());
        values.put(KEY_PUNTUACION, jugador.getPuntuacion());

        db.insert(TABLE_SCORE, null, values);
        db.close();
    }

    public Jugador getJugador(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_SCORE, new String[] { KEY_ID,
                        KEY_NICK, KEY_PUNTUACION }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Jugador jugador = new Jugador(cursor.getInt(0),
                cursor.getString(1), cursor.getInt(2));

        return jugador;
    }

    public List<Jugador> getTodosLosJugadores()
    {
        List<Jugador> lista_jugadores = new ArrayList<Jugador>();
        String selectQuery = "SELECT * FROM " + TABLE_SCORE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst())
        {
            do
            {
                Jugador jugador = new Jugador();
                jugador.setId(cursor.getInt(0));
                jugador.setNick(cursor.getString(1));
                jugador.setPuntuacion(cursor.getInt(2));
                lista_jugadores.add(jugador);
            }
            while (cursor.moveToNext());
        }
        return lista_jugadores;
    }

    public int getTotalJugadores()
    {
        String countQuery = "SELECT  * FROM " + TABLE_SCORE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

    public int updateJugador(Jugador jugador)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NICK, jugador.getNick());
        values.put(KEY_PUNTUACION, jugador.getPuntuacion());

        return db.update(TABLE_SCORE, values, KEY_ID + " = ?",
                new String[] { String.valueOf(jugador.getId()) });

    }

    public void deleteJugador(Jugador jugador)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SCORE, KEY_ID + " = ?",
                new String[] { String.valueOf(jugador.getId()) });
        db.close();
    }
}
