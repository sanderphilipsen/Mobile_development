package be.thomasmore.project_mobile_dev;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import be.thomasmore.project_mobile_dev.classes.Paar;

public class MinPaarKeuze extends AppCompatActivity {
    private DatabaseHelper db;
    List<Paar> paren = new ArrayList<Paar>();
    public long gebruikerId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        db = new DatabaseHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_min_paar_keuze);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle bundle = getIntent().getExtras();
        long doelklankid = bundle.getLong("doelklankId");
        gebruikerId = bundle.getLong("gebruikerId");
        paren = db.getParen();
        paren = db.getParenByDoelklankid(doelklankid);
        vulListView();

    }
    private void vulListView(){
    ArrayAdapter<Paar> adapter =
                new ArrayAdapter<Paar>(this,
                        android.R.layout.simple_list_item_2, paren);

        final GridView listViewParen = (GridView) findViewById(R.id.listViewPaar);
        listViewParen.setAdapter(adapter);

        listViewParen.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parentView,
                                            View childView, int position, long id) {
                        gaVerder(paren.get(position).getId());
                    }
                });
    }
    private void gaVerder(long id)
    {
        Bundle bundle = new Bundle();
        bundle.putLong("paarId", id);
        bundle.putLong("gebruikerId" ,gebruikerId);
        Intent intent = new Intent(this, Spel_keuze.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
