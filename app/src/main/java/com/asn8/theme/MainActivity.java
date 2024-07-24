package com.asn8.theme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    MaterialButton button,buttonIVI;
    MainActivity mainActivity;
    int colick;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPreferences = getSharedPreferences("themesp",MODE_PRIVATE);
        SharedPreferences.Editor editorsp = sharedPreferences.edit();
        colick = sharedPreferences.getInt("number",0);

        if (colick == 1){
            setTheme(R.style.ThemeOrange);
        }
        else{
            setTheme(R.style.ThemeNardovvt);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.change_ee);
        buttonIVI =findViewById(R.id.changeIVI);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editorsp.putInt("number", 1);
                editorsp.apply();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
        buttonIVI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editorsp.putInt("number", 0);
                editorsp.apply();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
    }
}