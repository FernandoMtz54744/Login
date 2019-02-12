package mtz.fernando.edu.mx.ipn.com.login;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usuario, contra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = (EditText)findViewById(R.id.usuario);
        contra = (EditText)findViewById(R.id.contra);
    }

    public void irRegistro(View v){
        Intent i = new Intent(this, Registro.class);
        finish();
        startActivity(i);
    }

    public void login(View v){
        String us = usuario.getText().toString();
        String psw = contra.getText().toString();

        DataBase d = new DataBase(this, "Users",  null, 1);
        SQLiteDatabase db = d.getWritableDatabase();

        Cursor fila = db.rawQuery("select * from usuarios where usuario='"+us+"' and pass='"+psw+"'",null);

        if(fila.moveToFirst()){
            Intent i = new Intent(this, Inicio.class);
            i.putExtra("nombre", us);
            finish();
            startActivity(i);
        }else{
            Toast.makeText(this, "Usuario no registrado", Toast.LENGTH_SHORT).show();
        }
    }

}
