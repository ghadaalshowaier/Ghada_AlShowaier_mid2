package com.example.ghada_alshowaier_mid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        final DatabaseHelper d = new DatabaseHelper(this);

        TextView tv = (TextView) findViewById(R.id.textView);
        EditText search = (EditText) findViewById(R.id.editTextNumber3);
        final SharedPreferences s = PreferenceManager.getDefaultSharedPreferences(this);
        Button find = (Button) findViewById(R.id.button6);
        Button go2a3 = (Button) findViewById(R.id.button7);

        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id_val = Integer.parseInt(search.getText().toString());
                if(id_val > 0){
                    SharedPreferences.Editor editor = s.edit();
                    editor.putInt("key 1", id_val);
                }
                else{
                    tv.setText("empty");
                }
            }
        });

        go2a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity3.this, MainActivity4.class));
            }
        });


    }
}