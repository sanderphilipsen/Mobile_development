package be.thomasmore.project_mobile_dev;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class Stoornis_Klankkeuze extends AppCompatActivity {
    private DatabaseHelper db;
    List<Klank> klanken = new ArrayList<Klank>();
    List<Stoornis> stoornissen = new ArrayList<Stoornis>();
    private RadioGroup stoornisGroup;
    private RadioButton radioButtonStoornis;
    private RadioButton radioButtonKlank;
    private RadioGroup klankGroup;
    private Klank klank = new Klank();
    private Stoornis stoornis = new Stoornis();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stoornis__klankkeuze);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        db = new DatabaseHelper(this);
      //  klanken = db.getKlanken();
       // stoornissen = db.getStoornissen();

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

    }
    public void  geefKeuzedoor_onClick(View v){
        stoornisGroup = (RadioGroup) findViewById(R.id.stoornisgroep);
        klankGroup = (RadioGroup) findViewById(R.id.klankgroep);
        int selectedStoornis = stoornisGroup.getCheckedRadioButtonId();
        int selectedKlank = klankGroup.getCheckedRadioButtonId();

        radioButtonStoornis = (RadioButton) findViewById(selectedStoornis);
        radioButtonKlank = (RadioButton) findViewById(selectedKlank);
        klank  = db.getKlankByKlank(radioButtonKlank.getText().toString());
        stoornissen= db.getStoornissen();
        String test = radioButtonStoornis.getText().toString();
        stoornis = db.getStoornisByStoornis(test);

           Intent intent = new Intent(this, Doelklankkeuze.class);
        Bundle bundle = new Bundle();
        bundle.putLong("klankid", klank.getId());
        bundle.putLong("stoornisid", stoornis.getId());
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
