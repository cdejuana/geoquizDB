package com.daw2.geoquiz;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class PreguntasDB extends SQLiteOpenHelper {

    //creamos contexto, necesario para
    private Context context;

    //creamos bbdd
    public PreguntasDB(Context context){
        super(context, "PreguntasBD", null, 1);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreate = "CREATE TABLE preguntas (" +
                "idPregunta INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "imagen TEXT, " +
                "textoPregunta TEXT, " +
                "opcionA TEXT, " +
                "opcionB TEXT, " +
                "opcionC TEXT, " +
                "respuesta INTEGER, " +
                "pista TEXT" + ")";
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void instertarPregunta(Pregunta pregunta){
        // ponemos bbd paraescritura
        SQLiteDatabase db = getWritableDatabase();
        //
        String SQLInsert = "INSERT INTO preguntas (imagen, textoPregunta, opcionA, opcionB, opcionC," +
                "respuesta, pista) VALUES ("+
                "'" + pregunta.getImagen() +
                "', '" + pregunta.getTexto_pregunta() +
                "', '" + pregunta.getOpcion1() +
                "', '" + pregunta.getOpcion2() +
                "', '" + pregunta.getOpcion3() +
                "', " + pregunta.getResultado() +
                ", '" + pregunta.getPista() + "')";
        db.execSQL(SQLInsert);
        db.close();
    }

    public void instertarListaPreguntas(ArrayList<Pregunta> listaPreguntas){
        SQLiteDatabase db = getWritableDatabase();
        for (int i = 0; i < listaPreguntas.size(); i++) {
            Pregunta pregunta = listaPreguntas.get(i);
            String SQLInsert =
                    "INSERT INTO pregunta (imagen, textoPregunta, opcionA, opcionB, opcionC," +
                    "respuesta, pista)" +
                    "VALUES (" +
                    "'" + pregunta.getImagen() +
                    "', '" + pregunta.getTexto_pregunta() +
                    "', '" + pregunta.getOpcion1() +
                    "', '" + pregunta.getOpcion2() +
                    "', '" + pregunta.getOpcion3() +
                    "', " + pregunta.getResultado() +
                    ", '" + pregunta.getPista() + "')";

            db.execSQL(SQLInsert);
        }
        db.close();
    }

    public ArrayList<Pregunta> cargarListaPreguntas(){
        ArrayList<Pregunta> listaPreguntas = new ArrayList<>();
        String[] CAMPOS = {"idPregunta", "imagen", "textoPregunta",
                            "opcionA", "opcionB", "opcionC", "respuesta", "pista"};
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("preguntas", CAMPOS, null,
                                null, null, null, null);
        while(cursor.moveToNext()){
            Pregunta pregunta = new Pregunta(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getInt(6),
                    cursor.getString(7));
            listaPreguntas.add(pregunta);
        }
        cursor.close();
        db.close();
        return listaPreguntas;
    }

}