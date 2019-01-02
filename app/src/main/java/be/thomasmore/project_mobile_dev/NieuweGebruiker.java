package be.thomasmore.project_mobile_dev;

import android.content.Intent;
import android.graphics.Color;
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
        final RadioGroup rg = (RadioGroup) findViewById(R.id.token);
        final RadioButton rb_spongebob = (RadioButton) findViewById(R.id.spongebob);
        final RadioButton rb_octo = (RadioButton) findViewById(R.id.octo);
        final RadioButton rb_patrick = (RadioButton) findViewById(R.id.patrick);
        final RadioButton rb_krabs = (RadioButton) findViewById(R.id.krab);
        db = new DatabaseHelper(this);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb_octo.setBackgroundColor(Color.TRANSPARENT);
                rb_patrick.setBackgroundColor(Color.TRANSPARENT);
                rb_krabs.setBackgroundColor(Color.TRANSPARENT);
                rb_spongebob.setBackgroundColor(Color.TRANSPARENT);
                if (rb_spongebob.isChecked()) {
                    rb_spongebob.setBackgroundResource(R.drawable.spongebob);
                }
                if (rb_octo.isChecked()) {
                    rb_octo.setBackgroundResource(R.drawable.octo);
                }
                if (rb_patrick.isChecked()) {
                    rb_patrick.setBackgroundResource(R.drawable.patrick);
                }
                if (rb_krabs.isChecked()) {
                    rb_krabs.setBackgroundResource(R.drawable.krabs);
                }
            }
        });
    }
    public void knopAdd_onClick(View v){
        EditText editVoornaam = (EditText) findViewById(R.id.voornaam);
        tokenGroup = (RadioGroup) findViewById(R.id.token);
        int selectedToken = tokenGroup.getCheckedRadioButtonId();
        radioButtonToken = (RadioButton) findViewById(selectedToken);
        String voornaam = editVoornaam.getText().toString();
        String token ="";
        switch (radioButtonToken.getId()) {
            case R.id.spongebob:
                token = "Spongebob";
                break;
            case R.id.patrick:
                token = "Patrick";
                break;
            case R.id.krab:
                token= "Krab";
                break;
            case R.id.octo:
                token= "Octo";
                break;
        }

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


}
