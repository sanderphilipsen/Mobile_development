package be.thomasmore.project_mobile_dev;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class ZegHetZelfEensKaart extends AppCompatActivity {

    private String eersteWoord;
    private String tweedeWoord;
    private String oplossing;
    private Boolean juist;
    private int positie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zeg_het_zelf_eens_kaart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getExtras();
        eersteWoord = bundle.getString("eersteWoord");
        tweedeWoord = bundle.getString("tweedeWoord");
        oplossing = bundle.getString("oplossing");
        positie = bundle.getInt("positie");

        pasImagesAan(eersteWoord, tweedeWoord, oplossing);
    }

    private void pasImagesAan(String eersteWoord,String tweedeWoord,String oplossing) {
        ImageView oplossingImage = (ImageView) findViewById(R.id.oplossingKaart);
        oplossingImage.setImageResource(getResources().getIdentifier(oplossing, "drawable", getPackageName()));

        ImageView eersteWoordImage = (ImageView) findViewById(R.id.eersteWoordKaart);
        eersteWoordImage.setImageResource(getResources().getIdentifier(eersteWoord, "drawable", getPackageName()));

        ImageView tweedeWoordImage = (ImageView) findViewById(R.id.tweedeWoordKaart);
        tweedeWoordImage.setImageResource(getResources().getIdentifier(tweedeWoord, "drawable", getPackageName()));
    }

    public void image1_onClick(View v) {
        if(oplossing.equals(eersteWoord)) {
            juist = true;
        } else {
            juist = false;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("juist", juist);
        bundle.putInt("positie", positie);

        Intent intent = new Intent();
        intent.putExtras(bundle);

        setResult(RESULT_OK, intent);

        eersteWoord = null;
        tweedeWoord = null;
        oplossing = null;
        finish();
    }

    public void image2_onClick(View v) {
        if(oplossing.equals(tweedeWoord)) {
            juist = true;
        } else {
            juist = false;
        }

        Bundle bundle = new Bundle();
        bundle.putBoolean("juist", juist);
        bundle.putInt("positie", positie);

        Intent intent = new Intent();
        intent.putExtras(bundle);

        setResult(RESULT_OK, intent);

        eersteWoord = null;
        tweedeWoord = null;
        oplossing = null;
        finish();
    }

}
