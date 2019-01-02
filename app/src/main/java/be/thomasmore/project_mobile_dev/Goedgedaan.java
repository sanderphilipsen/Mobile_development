package be.thomasmore.project_mobile_dev;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import be.thomasmore.project_mobile_dev.classes.Gebruiker;

public class Goedgedaan extends AppCompatActivity {
    public DatabaseHelper db;
    public Gebruiker gebruiker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goedgedaan);
        final ImageView goedgedaanImage = (ImageView) findViewById(R.id.goedgedaaan);
        final TextView goedgedaanlabel = (TextView) findViewById(R.id.goedgedaanlabel);
        Bundle bundle = getIntent().getExtras();
       long gebruikerId = bundle.getLong("gebruikerId");
        db = new DatabaseHelper(this);
       gebruiker = db.getGebruiker(gebruikerId);
        if (gebruiker.getMinimedaillesluistergoed()==0) {
            goedgedaanImage.setImageResource(R.drawable.supermedaille3);
            goedgedaanlabel.setText("Je hebt een supermedaille verdient!");
        }
        else {
            goedgedaanImage.setImageResource(R.drawable.minimedaille3);
            goedgedaanlabel.setText("Je hebt een minimedaille verdient!");
        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }
    public void klaar(View v) {
            Bundle bundle = new Bundle();
            bundle.putLong("gebruikerId", this.gebruiker.getId());
            Intent intent = new Intent(this, Home.class);
            intent.putExtras(bundle);
            startActivity(intent);
    }
}
