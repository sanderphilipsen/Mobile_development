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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Doelklankkeuze extends AppCompatActivity {
    private DatabaseHelper db;
    List<Doelklank> doelklanken = new ArrayList<Doelklank>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DatabaseHelper(this);
        setContentView(R.layout.activity_doelklankkeuze);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle bundle = getIntent().getExtras();
        long klankid = bundle.getLong("klankid");
        long stoornisid = bundle.getLong("stoornisid");
        doelklanken = db.getDoelklankenByKlankAndStoornis(klankid,stoornisid);
        vulListView();
    }
    /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

private void vulListView(){
    ArrayAdapter<Doelklank> adapter =
            new ArrayAdapter<Doelklank>(this,
                    android.R.layout.simple_list_item_1, doelklanken);

    final ListView listViewPresidents =
            (ListView) findViewById(R.id.listViewDoelKlank);
    listViewPresidents.setAdapter(adapter);

    // listViewPresidents.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

    listViewPresidents.setOnItemClickListener(
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parentView,
                                        View childView, int position, long id) {
                    gaVerder(doelklanken.get(position).getId());
                }
            });
}


        private void gaVerder(long id)
        {
            Bundle bundle = new Bundle();
            bundle.putLong("doelklankid", id);
            Intent intent = new Intent(this, MinPaarKeuze.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }


}
