package com.example.trabajopracticon3;

import android.text.Editable;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<String>resultado;

    public LiveData<String> getResultado() {
        if (resultado == null) {
            resultado = new MutableLiveData<String>();
        }
        return resultado;
    }

    public void DolarAEuro(String nro1) {
        float res = 0;
        float nro = 0;
        Log.d("salida", "calculando");

        if (nro1.length() > 0  ) {
            nro = Float.parseFloat(nro1);
            res = (float) (nro * 0.85);
            resultado.setValue(res + "  Euro");
        }
        else resultado.setValue("No se puede");

    }

     public void EuroADolar(String nro2){
         float res = 0;
         float nro = 0;
        if(nro2 != null){
           nro = Float.parseFloat(nro2);
           res = (float) (nro*1.18);
           resultado.setValue(res + " Dolares");
        }
        else resultado.setValue("No se puede");
    }


}


