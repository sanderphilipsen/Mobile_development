package be.thomasmore.project_mobile_dev;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import be.thomasmore.project_mobile_dev.classes.Spel;

public class GoedGedaan extends AppCompatActivity {

    private DatabaseHelper db;

    private Long gebruikerId;
    private Long spelId;

    private Long speltypeId;
    private Long doelklankId;
    private Spel spel;

    private MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goed_gedaan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db = new DatabaseHelper(this);

        Bundle bundle = getIntent().getExtras();
        gebruikerId = bundle.getLong("gebruikerId");
        spelId = bundle.getLong("spelId");

        speelGeluid("applaus");
    }

    public void terugNaarHome(View v) {
        Bundle bundle = new Bundle();
        bundle.putLong("gebruikerId" , gebruikerId);
        Intent intent = new Intent(this, Home.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void speelOpnieuw(View v) {
        spel = db.getSpel(spelId);

        speltypeId = spel.getSpeltypeId();
        doelklankId = spel.getDoelklankId();

        Bundle bundle = new Bundle();
        bundle.putLong("gebruikerId" , gebruikerId);
        bundle.putLong("speltypeId", speltypeId);
        bundle.putLong("doelklankId", doelklankId);

        Intent intent = new Intent(this, ZegHetZelfEensUitleg.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void speelGeluid(String geluid) {
        player = MediaPlayer.create(this, getResourceId(geluid, "raw", getPackageName()));
        player.start();
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                player.stop();
                player = null;
            }
        });
    }

    private int getResourceId(String pVariableName, String pResourcename, String pPackageName)
    {
        try {
            return getResources().getIdentifier(pVariableName, pResourcename, pPackageName);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
