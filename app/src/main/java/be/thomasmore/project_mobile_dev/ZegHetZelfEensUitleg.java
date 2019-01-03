package be.thomasmore.project_mobile_dev;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import be.thomasmore.project_mobile_dev.classes.Paar;
import be.thomasmore.project_mobile_dev.classes.Spel;

public class ZegHetZelfEensUitleg extends AppCompatActivity {

    private DatabaseHelper db;
    List<Paar> paren = new ArrayList<Paar>();

    public Spel spel;
    public Long spelId;
    public Long gebruikerId;
    public Long doelklankId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DatabaseHelper(this);
        setContentView(R.layout.activity_zeg_het_zelf_eens_uitleg);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nieuwSpel();

        getParen();
        vulListView();
    }

    private void nieuwSpel() {
        spel = new Spel();
        Bundle bundle = getIntent().getExtras();
        spel.setDoelklankId(bundle.getLong("doelklankId"));
        spel.setGebruikerId(bundle.getLong("gebruikerId"));
        spel.setSpeltypeId(bundle.getLong("speltypeId"));

        gebruikerId = bundle.getLong("gebruikerId");

        spelId = db.insertSpel(spel);
    }

    private void getParen() {
        doelklankId = spel.getDoelklankId();
        paren = db.getParenByDoelklank(doelklankId);
    }

    private void vulListView() {
        final ListView listViewParen = (ListView) findViewById(R.id.listViewMinPaar);
        CustomAdapter adapter = new CustomAdapter();
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
        bundle.putLong("spelId", spelId);
        bundle.putLong("gebruikerId", gebruikerId);
        Intent intent = new Intent(this, ZegHetZelfEens.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return paren.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int i)  {
            return 0;
        }
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.custom_list_item, null);
            TextView textView = (TextView) view.findViewById(R.id.customlistid);
            textView.setText(paren.get(i).toString());
            return view;
        }
    }
}
