package mtz.fernando.edu.mx.ipn.com.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Inicio extends AppCompatActivity {

    TextView saludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        saludo = (TextView)findViewById(R.id.saludo);
        String sal = getIntent().getExtras().getString("nombre");
        saludo.setText("BIENVENIDO " + sal);
    }
}
