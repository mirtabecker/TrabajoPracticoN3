package com.example.trabajopracticon3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText dolares, euros;
    private RadioButton rbEuroaDolares, rbDolaresaEuros;
    private TextView tvResultado;
    private Button btConvertir;
    private MainViewModel vm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainViewModel.class);
        iniciarVista();


        vm.getResultado().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String resultado) {
                tvResultado.setText(resultado);
            }
        });
    }

    private void iniciarVista() {
        dolares = findViewById(R.id.etDolares);
        euros = findViewById(R.id.etEuros);
        rbDolaresaEuros = findViewById(R.id.rbDolaresaEuros);
        rbEuroaDolares = findViewById(R.id.rbEuroaDolares);
        tvResultado = findViewById(R.id.tvResultado);
        btConvertir=findViewById(R.id.btConvertir);
        btConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(rbDolaresaEuros.isChecked())
                   vm.DolarAEuro(dolares.getText().toString());
               if (rbEuroaDolares.isChecked())
                   vm.EuroADolar(euros.getText().toString());

               dolares.setText("");
               euros.setText("");

            }
        });
        rbEuroaDolares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dolares.setEnabled(false);
                euros.setEnabled(true);
                tvResultado.setText("");
                euros.findFocus();
            }
        });
        rbDolaresaEuros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                euros.setEnabled(false);
                dolares.setEnabled(true);
                tvResultado.setText("");
                dolares.findFocus();
            }
        });
    }
}