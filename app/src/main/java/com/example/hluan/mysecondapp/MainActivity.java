package com.example.hluan.mysecondapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Button mybutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mybutton = (Button) findViewById(R.id.begin);
        mybutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Spinner choices=(Spinner) findViewById(R.id.choice);
                String choice=String.valueOf(choices.getSelectedItem());
                if(choice.equals("2048")) {
                    Intent i = new Intent(MainActivity.this, GamePage.class);
                    startActivity(i);

                }    }
        });
    }
}
