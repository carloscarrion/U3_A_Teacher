package com.example.carlos.u3_a_teacher;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class U3_A_Teacher extends AppCompatActivity {

    String cadea;
    String telefono;
    AlertDialog.Builder venta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3__a__teacher);
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

        cadea = "";
        telefono = "";

        Button btn_DatosTelefonoBuscador = (Button) findViewById(R.id.btnDatosTelefonoBuscador);

        btn_DatosTelefonoBuscador.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showDialog(1);
                return true;
            }
        });
    }


    public void onDatosTelfBuscadorClick(View v) {
        Intent i = new Intent(this, Secundaria.class);
        startActivityForResult(i, 111);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 111) {
            if (resultCode == RESULT_OK) {
                cadea = data.getStringExtra("CADEA");
                telefono = data.getStringExtra("TELEFONO");
            } else
                Toast.makeText(this, "Saíches da actividade secundaria sen premer o botón Pechar", Toast.LENGTH_SHORT).show();
        }
    }


    public void onDatosClick(View v) {
        Toast.makeText(U3_A_Teacher.this, "Cadea: "+cadea + ". Teléfono: " + telefono, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("CADEA", cadea);
        outState.putString("TELEFONO", telefono);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        cadea = savedInstanceState.getString("CADEA");
        telefono = savedInstanceState.getString("TELEFONO");
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        venta = new AlertDialog.Builder(this);
        venta.setIcon(android.R.drawable.ic_dialog_info);
        venta.setTitle("Que desexas facer:?");
        final CharSequence[] accion = {"Buscar cadea", "Chamar"};
        venta.setSingleChoiceItems(accion, 0, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int opcion) {
                Intent intent = new Intent();
                if (opcion == 0) {
                    if (cadea.equals(""))
                        cadea = "casa";
                    //intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://google.es/search?q="+cadea));
                    intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    intent.putExtra(SearchManager.QUERY, cadea);
                }
                if (opcion == 1) {
                    if (telefono.equals(""))
                        Toast.makeText(U3_A_Teacher.this, "Debes introducir un número de teléfono", Toast.LENGTH_SHORT).show();
                    else
                        intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono));
                }
                startActivity(intent);
                dialog.dismiss();
            }
        });
        venta.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int boton) {
            }
        });
        return venta.create();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_u3__a__teacher, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
