package be.thomasmore.project_mobile_dev;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    private DatabaseHelper db;
  public   Gebruiker gebruiker = new Gebruiker();
  public long gebruikerId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        db = new DatabaseHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getExtras();
        gebruikerId = bundle.getLong("gebruikerId");
        Gebruiker gebruiker = new Gebruiker();
        gebruiker = db.getGebruiker(gebruikerId);
        Set_Token(gebruiker);
        TextView editTextNaam = (TextView) findViewById(R.id.naam);
        editTextNaam.setText("Hallo "+gebruiker.welkom());
    }

    public void Speel_onClick(View v){
        Bundle bundle = new Bundle();
        bundle.putLong("gebruikerId", gebruikerId);
        Intent intent = new Intent(this, Stoornis_Klankkeuze.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void Resultaten_onClick(View v){

    }
    public void Terug_onClick(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void Set_Token(Gebruiker gebruiker){
        final ImageView imageViewToken = (ImageView) findViewById(R.id.token);
        switch (gebruiker.getToken()){
            case  "Spongebob" :
                imageViewToken.setImageResource(R.drawable.spongebob);
                break;
            case  "Patrick" :
                imageViewToken.setImageResource(R.drawable.patrick);
                break;
            case  "Octo" :
                imageViewToken.setImageResource(R.drawable.octo);
                break;
            case  "Krab" :
                imageViewToken.setImageResource(R.drawable.krabs);
                break;

        }
    }
}
