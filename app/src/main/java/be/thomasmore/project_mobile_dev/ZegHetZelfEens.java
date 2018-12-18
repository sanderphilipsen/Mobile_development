package be.thomasmore.project_mobile_dev;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.lang.reflect.Array;

import be.thomasmore.project_mobile_dev.classes.Spel;

public class ZegHetZelfEens extends AppCompatActivity {
    public Spel spel;
    private DatabaseHelper db;
    public long spelId;
    public boolean[] kaarten = new boolean[9];
    public int teller;
    public Context Kaarten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zeg_het_zelf_eens);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        db = new DatabaseHelper(this);
        setSupportActionBar(toolbar);
        spel = new Spel();
        Bundle bundle = getIntent().getExtras();

        spel.setDoelklankId(bundle.getLong("doelklankId"));
        spel.setGebruikerId(bundle.getLong("gebruikerId"));
        spel.setSpeltypeId(bundle.getLong("speltypeId"));
        //spelId = db.insertSpel(spel);
    }

    public void speel_onClick(View v) {
        Bundle bundle = new Bundle();
        bundle.putLong("gebruikerId", spel.getGebruikerId());
        Intent intent = new Intent(this, ZegHetZelfEensKaarten.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void terug_Naar_Home() {
        Bundle bundle = new Bundle();
        bundle.putLong("gebruikerId", spel.getGebruikerId());
        Intent intent = new Intent(this, Home.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public Dialog showDialog() {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(Kaarten);
        builder.setMessage(R.string.app_name)
                .setPositiveButton(R.string.app_titel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                    }
                })
                .setNegativeButton(R.string.annuleer, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}