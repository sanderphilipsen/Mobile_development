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

public class Doelklankkeuze extends AppCompatActivity {
    private DatabaseHelper db;
    List<Doelklank> doelklanken = new ArrayList<Doelklank>();
    public long gebruikerId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DatabaseHelper(this);
        setContentView(R.layout.activity_doelklankkeuze);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle bundle = getIntent().getExtras();
        long klankid = bundle.getLong("klankId");
        long stoornisid = bundle.getLong("stoornisId");
        gebruikerId = bundle.getLong("gebruikerId");
        doelklanken = db.getDoelklankenByKlankAndStoornis(klankid,stoornisid);
        vulListView();
    }

private void vulListView(){
    ArrayAdapter<Doelklank> adapter =
            new ArrayAdapter<Doelklank>(this,
                    android.R.layout.simple_list_item_1, doelklanken);

    final ListView listViewDoelklanken =
            (ListView) findViewById(R.id.listViewDoelKlank);
    listViewDoelklanken.setAdapter(adapter);

    listViewDoelklanken.setOnItemClickListener(
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
            bundle.putLong("doelklankId", id);
            bundle.putLong("gebruikerId" , gebruikerId);
            Intent intent = new Intent(this, MinPaarKeuze.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }


}
