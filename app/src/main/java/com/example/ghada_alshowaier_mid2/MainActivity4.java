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

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        final DatabaseHelper d = new DatabaseHelper(this);

        EditText search = (EditText) findViewById(R.id.editTextNumber4);
        final SharedPreferences s = PreferenceManager.getDefaultSharedPreferences(this);

        Button getdata = (Button) findViewById(R.id.button5);
        Button getinput = (Button) findViewById(R.id.button8);
        Button go2a1 = (Button) findViewById(R.id.button9);

        getdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id_val = Integer.parseInt(search.getText().toString());
                SharedPreferences.Editor editor = s.edit();
                editor.putInt("key 1", id_val);

                Cursor c = d.View();
                StringBuffer sb = new StringBuffer();
                while(c.moveToNext()){
                    sb.append("ID " +c.getString(0) +"\n");
                    sb.append("name " +c.getString(1) +"\n");
                    sb.append("email " +c.getString(2) +"\n");
                }

                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity4.this);
                b.setCancelable(true);
                b.setTitle("my database");
                b.setMessage(sb.toString());
                b.show();
            }
        });

        getinput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id_val = Integer.parseInt(search.getText().toString());
                SharedPreferences.Editor editor = s.edit();
                editor.putInt("key 1", id_val);

                Cursor c = d.View();
                StringBuffer sb = new StringBuffer();
                while(c.moveToNext()){
                    sb.append("ID " +c.getString(0) +"\n");
                    sb.append("name " +c.getString(1) +"\n");
                    sb.append("email " +c.getString(2) +"\n");
                }

                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity4.this);
                b.setCancelable(true);
                b.setTitle("my database");
                b.setMessage(sb.toString());
                b.show();

            }
        });


        go2a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity4.this, MainActivity2.class));
            }
        });
    }
}