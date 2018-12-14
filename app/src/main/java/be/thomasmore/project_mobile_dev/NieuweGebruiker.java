package be.thomasmore.project_mobile_dev;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import be.thomasmore.project_mobile_dev.classes.Gebruiker;

public class NieuweGebruiker extends AppCompatActivity {
    private DatabaseHelper db;
    private RadioGroup tokenGroup;
    private RadioButton radioButtonToken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nieuwe_gebruiker);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        db = new DatabaseHelper(this);
      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
       /*     }
        });*/
    }
    public void knopAdd_onClick(View v){
        EditText editVoornaam = (EditText) findViewById(R.id.voornaam);
        tokenGroup = (RadioGroup) findViewById(R.id.token);
        int selectedToken = tokenGroup.getCheckedRadioButtonId();
        radioButtonToken = (RadioButton) findViewById(selectedToken);
        String voornaam = editVoornaam.getText().toString();
        String token = radioButtonToken.getText().toString();
        EditText editFamilienaam = (EditText) findViewById(R.id.familienaam);
        String familienaam = editFamilienaam.getText().toString();
        Gebruiker gebruiker = new Gebruiker();
        gebruiker.setVoornaam(voornaam);
        gebruiker.setToken(token);
        gebruiker.setFamilienaam(familienaam);
        db.insertGebruiker(gebruiker);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void knopBack_onClick(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
