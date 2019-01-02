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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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

        Bundle bundle = getIntent().getExtras();
        gebruikerId =  bundle.getLong("gebruikerId");
        klankId =  bundle.getLong("doelklankId");
        speltypes = db.getSpelTypes();
        vulListView();
    }
    private void vulListView(){
        final ListView listspeltypes=
                (ListView) findViewById(R.id.listViewSpelType);
        CustomAdapter2 customAdapter = new CustomAdapter2();
        listspeltypes.setAdapter(customAdapter);
        listspeltypes.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parentView,
                                            View childView, int position, long id) {
                        gaVerder(speltypes.get(position).getId());
                    }
                });
    }
    class CustomAdapter2 extends BaseAdapter {
        @Override
        public int getCount() {
            return speltypes.size();
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
           // ImageView imageView = (ImageView) view.findViewById(R.id.fotokeuzeid);
            textView.setText(speltypes.get(i).toString());
           // imageView.setImageResource(R.drawable.eend);
            return view;
        }
    }

    private void gaVerder(long id)
    {
        Bundle bundle = new Bundle();
        bundle.putLong("speltypeId", id);
        bundle.putLong("gebruikerId" , gebruikerId);
        bundle.putLong("doelklankId" , klankId);
        Intent intent;
        if (id == 1){
            intent = new Intent(this, LuisterGoedUitleg.class);
        }
        else {
            intent = new Intent(this, ZegHetZelfEens.class);
        }
        intent.putExtras(bundle);
        startActivity(intent);
    }


}
