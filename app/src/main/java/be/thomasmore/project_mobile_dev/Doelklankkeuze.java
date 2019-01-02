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

import be.thomasmore.project_mobile_dev.classes.Doelklank;
import be.thomasmore.project_mobile_dev.classes.Spel;

public class Doelklankkeuze extends AppCompatActivity {
    private DatabaseHelper db;
    List<Doelklank> doelklanken = new ArrayList<Doelklank>();
    public long gebruikerId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DatabaseHelper(this);
        setContentView(R.layout.activity_doelklankkeuze);
        Bundle bundle = getIntent().getExtras();
        long klankid = bundle.getLong("klankId");
        long stoornisid = bundle.getLong("stoornisId");
        gebruikerId = bundle.getLong("gebruikerId");
        doelklanken = db.getDoelklankenByKlankAndStoornis(klankid,stoornisid);
        vulListView();
    }

private void vulListView(){
   /* ArrayAdapter<Doelklank> adapter =
            new ArrayAdapter<Doelklank>(this,
                    android.R.layout.simple_list_item_1, doelklanken);
*/
    final ListView listViewDoelklanken =
            (ListView) findViewById(R.id.listViewDoelKlank);
    CustomAdapter customAdapter = new CustomAdapter();
    listViewDoelklanken.setAdapter(customAdapter);

    listViewDoelklanken.setOnItemClickListener(
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parentView,
                                        View childView, int position, long id) {
                    gaVerder(doelklanken.get(position).getId());
                }
            });

}
    class CustomAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return doelklanken.size();
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
            textView.setText(doelklanken.get(i).toString());
            return view;
        }
    }

        private void gaVerder(long id)
        {
            Bundle bundle = new Bundle();
            bundle.putLong("doelklankId", id);
            bundle.putLong("gebruikerId" , gebruikerId);
            Intent intent = new Intent(this, Spel_keuze.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }


}
