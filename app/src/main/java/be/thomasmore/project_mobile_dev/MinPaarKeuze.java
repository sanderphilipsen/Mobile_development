package be.thomasmore.project_mobile_dev;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MinPaarKeuze extends AppCompatActivity {
    private DatabaseHelper db;
    List<Paar> paren = new ArrayList<Paar>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        db = new DatabaseHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_min_paar_keuze);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle bundle = getIntent().getExtras();
        long doelklankid = bundle.getLong("doelklankid");
        paren = db.getParen();
        paren = db.getParenByDoelklankid(doelklankid);
        vulListView();
      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }
    private void vulListView(){
        ArrayAdapter<Paar> adapter =
                new ArrayAdapter<Paar>(this,
                        android.R.layout.simple_list_item_1, paren);

        final ListView listViewParen =
                (ListView) findViewById(R.id.listViewPaar);
        listViewParen.setAdapter(adapter);

        // listViewPresidents.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

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
        bundle.putLong("paarid", id);
        Intent intent = new Intent(this, Spel_keuze.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
