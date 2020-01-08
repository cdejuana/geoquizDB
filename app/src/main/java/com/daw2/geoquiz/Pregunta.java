package com.daw2.geoquiz;

import android.widget.ImageView;

public class Pregunta {
    private int id;
    private String imagen;
    private String texto_pregunta;
    private String opcion1;
    private String opcion2;
    private String opcion3;
    private int resultado;
    private String pista;

    public Pregunta(int id, String imagen, String texto_pregunta, String opcion1, String opcion2, String opcion3, int resultado, String pista) {
        this.id = id;
        this.imagen = imagen;
        this.texto_pregunta = texto_pregunta;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.resultado = resultado;
        this.pista = pista;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTexto_pregunta() {
        return texto_pregunta;
    }

    public void setTexto_pregunta(String texto_pregunta) {
        this.texto_pregunta = texto_pregunta;
    }

    public String getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(String opcion3) {
        this.opcion3 = opcion3;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public String getPista() {
        return pista;
    }

    public void setPista(String pista) {
        this.pista = pista;
    }

    @Override
    public String toString() {
        return "Pregunta{" +
                "imagen=" + imagen +
                ", texto_pregunta=" + texto_pregunta +
                ", opcion1=" + opcion1 +
                ", opcion2=" + opcion2 +
                ", opcion3=" + opcion3 +
                ", resultado=" + resultado +
                ", pista=" + pista +
                '}';
    }
}

