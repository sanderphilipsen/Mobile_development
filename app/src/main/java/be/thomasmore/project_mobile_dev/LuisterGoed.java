package be.thomasmore.project_mobile_dev;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class LuisterGoed extends AppCompatActivity {
    public long gebruikerId;
    public long paarId;
    public  long speltypeId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luister_goed);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle bundle = getIntent().getExtras();
        gebruikerId =  bundle.getLong("gebruikerId");
        paarId =  bundle.getLong("paarId");
        speltypeId =  bundle.getLong("speltypeId");
    }

}
