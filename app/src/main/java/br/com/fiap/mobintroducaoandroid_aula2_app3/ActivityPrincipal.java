package br.com.fiap.mobintroducaoandroid_aula2_app3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ActivityPrincipal extends AppCompatActivity {


    private TextView txtNumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtNumero = (TextView) findViewById(R.id.txtNumero);

        if (savedInstanceState != null){
            txtNumero.setText(savedInstanceState.getString("valor"));
        }
        else
        {
            txtNumero.setText(R.string.txtZero);

        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("valor", txtNumero.getText().toString());
        super.onSaveInstanceState(outState);
    }

    public void mais(View v) {

        //obtém o texto atual do txtNumero
        Integer val = Integer.parseInt(txtNumero.getText().toString());
        val++;
        // define dinamicamente o valor de txtNumero com o valor atualizado
        txtNumero.setText(String.valueOf(val));
    }

    public void menos(View v) {

        Integer val = Integer.parseInt(txtNumero.getText().toString());
        val--;
        txtNumero.setText(String.valueOf(val));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menuSobre) {
            Intent toActivity2 = new Intent(this, ActivitySobre.class);
            startActivity(toActivity2);
        }

        return super.onOptionsItemSelected(item);
    }
}
