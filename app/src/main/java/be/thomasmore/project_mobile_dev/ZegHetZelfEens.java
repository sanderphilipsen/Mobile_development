package be.thomasmore.project_mobile_dev;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import java.util.Random;

import be.thomasmore.project_mobile_dev.classes.Paar;

public class ZegHetZelfEens extends AppCompatActivity {

    private DatabaseHelper db;

    private Long gebruikerId;
    private Long minimaalPaarId;
    private Paar minimaalPaar;

    String[] oplossingen = new String[9];

    private Boolean juist;
    private int positie;
    private int counter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zeg_het_zelf_eens);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        db = new DatabaseHelper(this);

        Bundle bundle = getIntent().getExtras();
        gebruikerId = bundle.getLong("gebruikerId");
        minimaalPaarId = bundle.getLong("paarId");
        minimaalPaar = db.getPaar(minimaalPaarId);
        maakOplossingenArray(minimaalPaar.getEerstepaar(), minimaalPaar.getTweedepaar());

        vulGridView();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Bundle bundle = intent.getExtras();
                juist = bundle.getBoolean("juist");
                positie = bundle.getInt("positie");

                if(juist) {
                    counter++;
                    pasAfbeeldingAan(positie);
                }

                if(counter >= 9 ) {
                    eindeSpel();
                }
            }
        }
    }

    private void vulGridView() {
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new KaartAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putString("eersteWoord", minimaalPaar.getEerstepaar());
                bundle.putString("tweedeWoord", minimaalPaar.getTweedepaar());
                bundle.putString("oplossing", oplossingen[position]);
                bundle.putInt("positie", position);

                Intent intent = new Intent(ZegHetZelfEens.this, ZegHetZelfEensKaart.class);
                intent.putExtras(bundle);

                startActivityForResult(intent, 1);
            }
        });
    }

    public void maakOplossingenArray(String eersteWoord, String tweedeWoord) {
        Random rand = new Random();
        int willekeurigGetal;

        for (int i=0; i < 9; i++) {
            willekeurigGetal = rand.nextInt(2);

            if (willekeurigGetal == 0) {
                oplossingen[i] = eersteWoord;
            } else {
                oplossingen[i] = tweedeWoord;
            }
        }
    }

    private void pasAfbeeldingAan(int positie) {
        String woord = oplossingen[positie];

        ImageView imageView = (ImageView) findViewById(positie);

        imageView.setImageResource(getResources().getIdentifier(woord, "drawable", getPackageName()));

    }

    private void eindeSpel() {
        counter = 0;

        Bundle bundle = new Bundle();
        bundle.putLong("gebruikerId" , gebruikerId);
        Intent intent = new Intent(this, Home.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}