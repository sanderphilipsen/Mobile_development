package be.thomasmore.project_mobile_dev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.util.Log;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper db;
    List<Gebruiker> gebruikers = new ArrayList<Gebruiker>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);
        gebruikers = db.getGebruikers();
        useCustomAdapter();
    }
    public void  NieuweGebruiker_onClick(View v){
    Intent intent = new Intent(this, NieuweGebruiker.class);
    startActivity(intent);
    }

    private void useCustomAdapter()
    {
        GebruikerAdapter platformAdapter =
                new GebruikerAdapter(getApplicationContext(), gebruikers);

        final ListView listViewGebruikers =
                (ListView) findViewById(R.id.listViewGebruikers);
        listViewGebruikers.setAdapter(platformAdapter);

        listViewGebruikers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parentView, View childView, int position, long id) {
                login(gebruikers.get(position).getId());
            }
        });
    }
    private void login(long id)
    {
        Bundle bundle = new Bundle();
        bundle.putLong("gebruikerId", id);
        Intent intent = new Intent(this, Home.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
