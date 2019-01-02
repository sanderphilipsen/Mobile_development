package be.thomasmore.project_mobile_dev;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import be.thomasmore.project_mobile_dev.classes.Gebruiker;

public class Home extends AppCompatActivity {


    private DatabaseHelper db;
  public Gebruiker gebruiker = new Gebruiker();
  public long gebruikerId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        db = new DatabaseHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Bundle bundle = getIntent().getExtras();
        gebruikerId = bundle.getLong("gebruikerId");
        gebruiker = db.getGebruiker(gebruikerId);
    /*    Set_Token(gebruiker);*/
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
     /*   TextView editTextNaam = (TextView) findViewById(R.id.naam);
        editTextNaam.setText("Hallo "+gebruiker.welkom());*/
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.fragment_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.fragment_medals:
                    selectedFragment = new MedalsFragment();
                    break;
                case R.id.fragment_account:
                    selectedFragment = new SettingsFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container, selectedFragment).commit();
            return true;
        }
    };
    public void Speel_onClick(View v){
        Bundle bundle = new Bundle();
        bundle.putLong("gebruikerId", gebruikerId);
        Intent intent = new Intent(this, Stoornis_Klankkeuze.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void Resultaten_onClick(View v){

    }
    public String getGebruikerNaam() {
       return gebruiker.welkom();
    }
    public Gebruiker getGebruiker() {
        return gebruiker;
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
    public void Set_MedailleMuur(Gebruiker gebruiker){
        final ImageView smedailleluistergoed = (ImageView) findViewById(R.id.supermedailleluistergoed);
        final ImageView mmedailleluistergoed = (ImageView) findViewById(R.id.minimedailleluistergoed);
        if (Integer.parseInt(String.valueOf(this.gebruiker.getGrotemedailleszeg()))>0) {
            smedailleluistergoed.setImageResource(R.drawable.supermedaillegrijs);
        }
        else {
            smedailleluistergoed.setImageResource(R.drawable.supermedaille1);
        }
    }
}
