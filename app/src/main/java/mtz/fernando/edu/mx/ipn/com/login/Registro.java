package mtz.fernando.edu.mx.ipn.com.login;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    EditText usuario, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        usuario =(EditText)findViewById(R.id.usuario);
        pass = (EditText)findViewById(R.id.pass);
    }

    public void registro(View v){
        String us = usuario.getText().toString();
        String psw = pass.getText().toString();

        if(!us.isEmpty() && !psw.isEmpty()) {
            DataBase d = new DataBase(this, "Users", null, 1);
            SQLiteDatabase db = d.getWritableDatabase();
            ContentValues registro = new ContentValues();

            registro.put("usuario", us);
            registro.put("pass", psw);

            db.insert("usuarios", null, registro);
            db.close();
            Toast.makeText(this, "Usuario registrado", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, MainActivity.class);
            finish();
            startActivity(i);
        }else{
            Toast.makeText(this, "Ingrese todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void regresar(View v){
        Intent i = new Intent(this, MainActivity.class);
        finish();
        startActivity(i);
    }
}
