package br.ifsc.edu.myblocodenotassqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class NotasDAO {

    private static final String NOME_BANCO = "meubd";
    private SQLiteDatabase bd;
    private Context contexto;

    public NotasDAO(Context context){
        this.contexto = context;
        bd = contexto.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);
        criaTabela();
    }

    private void criaTabela() {
        bd.execSQL("CREATE TABLE IF NOT EXISTS textosNota(" +
                "id integer primary key," +
                "texto varchar);");
    }

    public void inserirNota(Nota nota){
        ContentValues values =  new ContentValues();
        values.put("id",nota.getId());
        values.put("texto", nota.getTexto());
        bd.insert("textosNota", null, values);
        Toast.makeText(contexto, "Nota adicionada!", Toast.LENGTH_SHORT).show();
    }

    public String retornaNota() {
        Cursor cursor;
        cursor = bd.rawQuery("SELECT texto FROM textosNota WHERE id=1;", null);
        cursor.moveToFirst();

        if(cursor.getCount()>0) {
            String txt = cursor.getString(cursor.getColumnIndex("texto"));
            return txt;
        }else{
            return null;
        }
    }

    public void atualizaNota(Nota nota) {
        ContentValues values =  new ContentValues();
        values.put("id",nota.getId());
        values.put("texto", nota.getTexto());
        bd.update("textosNota",  values,null,null);
    }

    public int veId(int i) {
        Cursor cursor;
        cursor = bd.rawQuery("SELECT * FROM textosNota WHERE id='"+i+"';", null);
        cursor.moveToFirst();

        int volta = cursor.getCount();
        return volta;
    }
}
