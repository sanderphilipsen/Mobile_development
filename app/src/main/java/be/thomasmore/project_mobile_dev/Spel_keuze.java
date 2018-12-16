package be.thomasmore.project_mobile_dev;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import be.thomasmore.project_mobile_dev.classes.SpelType;

public class Spel_keuze extends AppCompatActivity {
    public DatabaseHelper db;
    List<SpelType> speltypes = new ArrayList<SpelType>();
    public long gebruikerId;
    public long klankId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DatabaseHelper(this);
        setContentView(R.layout.activity_spel_keuze);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle bundle = getIntent().getExtras();
        gebruikerId =  bundle.getLong("gebruikerId");
        klankId =  bundle.getLong("doelklankId");
        speltypes = db.getSpelTypes();
        vulListView();
    }

    private void vulListView(){
        ArrayAdapter<SpelType> adapter =
                new ArrayAdapter<SpelType>(this,
                        android.R.layout.simple_list_item_1, speltypes);

        final ListView listspeltypes=
                (ListView) findViewById(R.id.listViewSpelType);
        listspeltypes.setAdapter(adapter);

        listspeltypes.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parentView,
                                            View childView, int position, long id) {
                        gaVerder(speltypes.get(position).getId());
                    }
                });
    }


    private void gaVerder(long id)
    {
        Bundle bundle = new Bundle();
        bundle.putLong("speltypeId", id);
        bundle.putLong("gebruikerId" , gebruikerId);
        bundle.putLong("doelklankId" , klankId);
        Intent intent;
        if (id == 1){
            intent = new Intent(this, LuisterGoed.class);
        }
        else {
            intent = new Intent(this, ZegHetZelfEens.class);
        }
        intent.putExtras(bundle);
        startActivity(intent);
    }


}
