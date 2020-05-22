package br.ifsc.edu.myblocodenotassqlite;

public class Nota {

    String texto;
    int id;

    public Nota(int i, String texto) {
        this.texto = texto;
        this.id= i;
    }

    public String getTexto() {
        return texto;
    }

    public int getId() {
        return id;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setId(int id) {
        this.id = id;
    }

}
