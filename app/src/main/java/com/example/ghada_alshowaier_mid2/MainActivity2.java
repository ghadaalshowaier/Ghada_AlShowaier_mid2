package com.example.ghada_alshowaier_mid2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        EditText id = (EditText) findViewById(R.id.editTextNumber);
        EditText name = (EditText) findViewById(R.id.editTextTextPersonName);
        EditText email = (EditText) findViewById(R.id.editTextTextEmailAddress);
        EditText phone = (EditText) findViewById(R.id.editTextNumber2);

        Button add = (Button) findViewById(R.id.button);
        Button view = (Button) findViewById(R.id.button2);
        Button delete = (Button) findViewById(R.id.button3);

        Button go2a2 = (Button) findViewById(R.id.button4);

        final DatabaseHelper d = new DatabaseHelper(this);

        final SharedPreferences s = PreferenceManager.getDefaultSharedPreferences(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id_val = id.getText().toString();
                String name_val = name.getText().toString();
                String email_val = email.getText().toString();


                d.Add(id_val, name_val, email_val);
                Toast.makeText(MainActivity2.this, "successful add", Toast.LENGTH_LONG).show();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = d.View();
                StringBuffer sb = new StringBuffer();
                while(c.moveToNext()){
                    sb.append("ID " +c.getString(0) +"\n");
                    sb.append("name " +c.getString(1) +"\n");
                    sb.append("email " +c.getString(2) +"\n");
                }

                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity2.this);
                b.setCancelable(true);
                b.setTitle("my database");
                b.setMessage(sb.toString());
                b.show();
                Toast.makeText(MainActivity2.this, "successful view", Toast.LENGTH_LONG).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id_d = id.getText().toString();
                d.Delete(id_d);
                Toast.makeText(MainActivity2.this, "successful delete", Toast.LENGTH_LONG).show();
            }
        });

        go2a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity2.this, MainActivity3.class));
            }
        });
    }
}