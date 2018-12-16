package be.thomasmore.project_mobile_dev;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import be.thomasmore.project_mobile_dev.classes.Spel;
import be.thomasmore.project_mobile_dev.classes.SpelType;

public class LuisterGoed extends AppCompatActivity {
    public Spel spel;
    private DatabaseHelper db;
    public long spelId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luister_goed);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        db = new DatabaseHelper(this);
        spel = new Spel();
        Bundle bundle = getIntent().getExtras();

        spel.setDoelklankId( bundle.getLong("doelklankId"));
        spel.setGebruikerId(bundle.getLong("gebruikerId"));
        spel.setSpeltypeId(bundle.getLong("speltypeId"));
        spelId = db.insertSpel(spel);

            }
    }


