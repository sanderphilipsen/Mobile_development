package be.thomasmore.project_mobile_dev;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.media.AudioManager;
import be.thomasmore.project_mobile_dev.classes.Spel;

public class LuisterGoedUitleg extends AppCompatActivity {
    public Spel spel;
    public long spelId;
    public  DatabaseHelper db;
    public AudioManager audioManager ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_luister_goed_uitleg);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        newSpel();
    }
public void speel_onClick(View v) {
        if (this.oortjesStekenIn(v)){
            Bundle bundle = new Bundle();
            bundle.putLong("spelId", spelId);
            bundle.putLong("doelklankId" , spel.getDoelklankId());
            bundle.putLong("gebruikerId" , spel.getGebruikerId());
            bundle.putLong("speltypeId" , spel.getSpeltypeId());
            Intent intent = new Intent(this, LuisterGoed.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    else {
            TextView uitleg = (TextView) findViewById(R.id.luistergoeduitleg);
            uitleg.setTextColor(Color.RED);
            uitleg.setAllCaps(true);
            Toast.makeText(v.getContext(),"Steek oortjes in, voor je verder gaat!", Toast.LENGTH_LONG);
        }
}
public  boolean oortjesStekenIn(View v) {
    this.audioManager = (AudioManager)getSystemService(v.getContext().AUDIO_SERVICE);
    if (audioManager.isWiredHeadsetOn()) {
        return true;
    }
    else {
        return false;
    }
}
public void newSpel() {
        spel = new Spel();
        Bundle bundle = getIntent().getExtras();
        spel.setDoelklankId(bundle.getLong("doelklankId"));
        spel.setGebruikerId(bundle.getLong("gebruikerId"));
        spel.setSpeltypeId(bundle.getLong("speltypeId"));
    }
}
