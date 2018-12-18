package be.thomasmore.project_mobile_dev;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import be.thomasmore.project_mobile_dev.classes.Spel;

public class ZegHetZelfEensKaarten extends AppCompatActivity {
    public Spel spel;
    public long spelId;
    public boolean[] kaarten = new boolean[9];
    public int teller;
    public String[] minimaalPaar = {"Buig", "Buis"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zeg_het_zelf_eens_kaarten);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spel = new Spel();

        Bundle bundle = getIntent().getExtras();
        spel.setGebruikerId(bundle.getLong("gebruikerId"));
    }

    public void image_onClick(View v) {
        ImageView kaart = (ImageView)findViewById(v.getId());

        int id;
        id = Integer.parseInt(kaart.getTag().toString());

        kaarten[id] = true;

        teller = 0;
        for(int i = 0; i < kaarten.length; i++) {
            if(kaarten[i]) {
                teller++;
            }
        }

        if(teller == 9) {
            terug_Naar_Home();
        }
    }

    private void speelKaart() {

    }

    private void testWoorden() {

    }

    public void terug_Naar_Home() {
        Bundle bundle = new Bundle();
        bundle.putLong("gebruikerId", spel.getGebruikerId());
        Intent intent = new Intent(this, Home.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
