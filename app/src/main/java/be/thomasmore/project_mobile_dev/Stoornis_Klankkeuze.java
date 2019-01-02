package be.thomasmore.project_mobile_dev;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;
import android.widget.Toast;
import be.thomasmore.project_mobile_dev.classes.Gebruiker;
import be.thomasmore.project_mobile_dev.classes.Klank;
import be.thomasmore.project_mobile_dev.classes.Stoornis;
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
    public Gebruiker gebruiker = new Gebruiker();
    public long gebruikerId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stoornis__klankkeuze);;
        Bundle bundle = getIntent().getExtras();
        gebruikerId = bundle.getLong("gebruikerId");
        db = new DatabaseHelper(this);
        final RadioGroup rg = (RadioGroup) findViewById(R.id.klankgroep);
        final RadioButton rb_klank1 = (RadioButton) findViewById(R.id.klank1);
        final RadioButton rb_klank2 = (RadioButton) findViewById(R.id.klank2);
        rb_klank2.setBackgroundColor(Color.GRAY);
        rb_klank2.setTextColor(Color.WHITE);
        rb_klank1.setBackgroundColor(Color.GRAY);
        rb_klank1.setTextColor(Color.WHITE);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (rb_klank1.isChecked()) {
                    rb_klank1.setBackgroundColor(Color.parseColor("#F5EE33"));
                    rb_klank1.setTextColor(Color.BLACK);
                    rb_klank2.setBackgroundColor(Color.GRAY);
                    rb_klank2.setTextColor(Color.WHITE);
                }
                if (rb_klank2.isChecked()){
                    rb_klank2.setBackgroundColor(Color.parseColor("#F5EE33"));
                    rb_klank2.setTextColor(Color.BLACK);
                    rb_klank1.setBackgroundColor(Color.GRAY);
                    rb_klank1.setTextColor(Color.WHITE);
                }
            }
        });
        final RadioGroup rg2 = (RadioGroup) findViewById(R.id.stoornisgroep);
        final RadioButton rb_stoornis1 = (RadioButton) findViewById(R.id.stoor1);
        final RadioButton rb_stoornis2 = (RadioButton) findViewById(R.id.stoor2);
        rb_stoornis1.setBackgroundColor(Color.GRAY);
        rb_stoornis1.setTextColor(Color.WHITE);
        rb_stoornis2.setBackgroundColor(Color.GRAY);
        rb_stoornis2.setTextColor(Color.WHITE);
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (rb_stoornis1.isChecked()) {
                    rb_stoornis1.setBackgroundColor(Color.parseColor("#F5EE33"));
                    rb_stoornis1.setTextColor(Color.BLACK);
                    rb_stoornis2.setBackgroundColor(Color.GRAY);
                    rb_stoornis2.setTextColor(Color.WHITE);
                }
                if (rb_stoornis2.isChecked()){
                    rb_stoornis2.setBackgroundColor(Color.parseColor("#F5EE33"));
                    rb_stoornis2.setTextColor(Color.BLACK);
                    rb_stoornis1.setBackgroundColor(Color.GRAY);
                    rb_stoornis1.setTextColor(Color.WHITE);
                }
            }
        });
    }
    public void  geefKeuzedoor_onClick(View v){


        try {
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
            bundle.putLong("gebruikerId", gebruikerId);
            bundle.putLong("klankId", klank.getId());
            bundle.putLong("stoornisId", stoornis.getId());

            intent.putExtras(bundle);
            startActivity(intent);
        } catch (Exception e){
            Toast.makeText(v.getContext(), "Je moet een klank en stoornis selecteren", Toast.LENGTH_LONG);
        }

    }
}
