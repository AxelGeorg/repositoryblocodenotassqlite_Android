package br.ifsc.edu.myblocodenotassqlite;

import android.content.Context;

public class NotaController {

    NotasDAO notasdao;
    Context context;

    public NotaController(Context context1) {
        this.context =  context1;
        notasdao = new NotasDAO(context);
    }

    public void salvarNota(Nota nota) {
        notasdao.inserirNota(nota);
    }

    public String recuperaNota(){
        return notasdao.retornaNota();
    }

    public boolean VeSeIdExiste(int i) {
        if(notasdao.veId(i)>0){
            return true;
        }else{
            return false;
        }
    }

    public void updateNota(Nota nota) {
        notasdao.atualizaNota(nota);
    }
}
