package com.example.carlos.u3_a_teacher;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class Secundaria extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onPecharClick (View v){
        EditText et_Cadea = (EditText) findViewById(R.id.etCadea);
        EditText et_Telf  = (EditText) findViewById(R.id.etTelf);

        Intent intenteDeVolta = new Intent();
        intenteDeVolta.putExtra("CADEA", et_Cadea.getText().toString());
        intenteDeVolta.putExtra("TELEFONO", et_Telf.getText().toString());
        setResult(RESULT_OK, intenteDeVolta);
        finish();

    }
}
