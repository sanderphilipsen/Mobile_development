package be.thomasmore.project_mobile_dev;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import be.thomasmore.project_mobile_dev.classes.Spel;

public class ZegHetZelfEens extends AppCompatActivity {
    public Spel spel;
    private DatabaseHelper db;
    public long spelId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zeg_het_zelf_eens);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        db = new DatabaseHelper(this);
        setSupportActionBar(toolbar);
        spel = new Spel();
        Bundle bundle = getIntent().getExtras();
        
        spel.setDoelklankId( bundle.getLong("doelklankId"));
        spel.setGebruikerId(bundle.getLong("gebruikerId"));
        spel.setSpeltypeId(bundle.getLong("speltypeId"));
       spelId = db.insertSpel(spel);

    }

    private void speel_onClick(View v) {

    }
    }

