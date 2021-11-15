package br.com.senaimt.fuelcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Componentes de tela
    TextView txtValorAlcool;
    TextView txtValorGasolina;
    Button btnVerificar;
    TextView txtResultado;
    String mensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtValorAlcool = findViewById(R.id.txtValorAlcool);
        txtValorGasolina = findViewById(R.id.txtValorGasolina);
        btnVerificar = findViewById(R.id.btnVerificar);
        txtResultado = findViewById(R.id.txtResultado);

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String valorAlcool = txtValorAlcool.getText().toString().replace(",", ".");
                    String valorGasolina = txtValorGasolina.getText().toString().replace(",", ".");
                    ;
                    float convertAlcool = Float.parseFloat(valorAlcool);
                    float convertGasolina = Float.parseFloat(valorGasolina);

                    float resultado = convertAlcool / convertGasolina;
                    if (resultado < 0.7) {
                        mensagem = "É melhor abastecer com Álcool!";
                    } else {
                        mensagem = "É melhor abastecer com Gasolina!";
                    }
                    txtResultado.setText(mensagem);
                    txtResultado.setVisibility(View.VISIBLE);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Valor incorreto!", Toast.LENGTH_LONG);
                }
            }
        });
    }
}