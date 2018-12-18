package be.thomasmore.project_mobile_dev;
import java.util.Random;
import android.os.Bundle;
import android.content.Intent;
import android.view.Gravity;
import android.widget.ImageView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.media.MediaPlayer;
import android.widget.PopupWindow;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;
import be.thomasmore.project_mobile_dev.classes.Spel;

public class LuisterGoed extends AppCompatActivity {
    public Spel spel;
    public MediaPlayer player;
    public MediaPlayer player2;
    private DatabaseHelper db;
    public long spelId;
    PopupWindow popupWindow;
    LinearLayout layout;
    TextView tv;
    ImageView medaille;
    LayoutParams params;
    LinearLayout mainLayout;
    Random rand ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        popupWindow = new PopupWindow(this);
        layout = new LinearLayout(this);
        mainLayout = new LinearLayout(this);
        tv = new TextView(this);
        medaille = new ImageView(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luister_goed);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        db = new DatabaseHelper(this);
        spel = new Spel();
        Bundle bundle = getIntent().getExtras();
        spel.setDoelklankId(bundle.getLong("doelklankId"));
        spel.setGebruikerId(bundle.getLong("gebruikerId"));
        spel.setSpeltypeId(bundle.getLong("speltypeId"));
        spelId = db.insertSpel(spel);
        params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        layout.setOrientation(LinearLayout.VERTICAL);
        tv.setText("Je hebt een minimedaille verdiend!");
        medaille.setImageResource(R.drawable.minimedaille1);
        layout.addView(medaille,params);
        layout.addView(tv,params);
        popupWindow.setContentView(layout);
    }
    public void speel_onClick(View v) {
        player = null;
        if (player == null) {
            switch (Integer.parseInt(String.valueOf(spel.getDoelklankId()))) {
                case 1:
                    player = MediaPlayer.create(this, R.raw.reeks1);
                    break;
                case 2:
                    player = MediaPlayer.create(this, R.raw.reeks5);
                    break;
                case 3:
                    player = MediaPlayer.create(this, R.raw.reeks3);
                    break;
                case 4:
                    player = MediaPlayer.create(this, R.raw.reeks2);
                    break;
                case 5:
                    player = MediaPlayer.create(this, R.raw.reeks4);
                    break;
                case 6:
                    player = MediaPlayer.create(this, R.raw.reeks6);
                    break;
                case 7:
                    player = MediaPlayer.create(this, R.raw.reeks3);
                    break;
                case 8:
                    player = MediaPlayer.create(this, R.raw.reeks4);
                    break;
                case 9:
                    int randomNum = rand.nextInt((1 - 0) + 1);
                    if (randomNum == 1) {
                        player = MediaPlayer.create(this, R.raw.reeks7);
                    }
                    else {
                        player = MediaPlayer.create(this, R.raw.reeks8);
                    }
                    break;
                case 10:
                    player = MediaPlayer.create(this, R.raw.reeks9);
            }
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                goedGedaan();
                }
            });
            player.start();
        }
    }
    public void Stop_onClick(View v)
    {
        stopPlayer();
    }
    private void stopPlayer() {
        if (player != null) {
            player.release();
            player = null;
        }
        if (player2 != null) {
            player2.release();
            player2 = null;
        }
    }
    private void goedGedaan() {
      /*  final ImageView imageView = (ImageView) findViewById(R.id.medaille_popup);
        imageView.setImageResource(R.drawable.minimedaille1);*/
        popupWindow.showAtLocation(layout, Gravity.CENTER,10,10);
        popupWindow.update(0,0,1000,1000);
        if (player != null) {
            player = MediaPlayer.create(this, R.raw.goed_gedaan);
            player.start();
            player2 = MediaPlayer.create(this, R.raw.applaus);
            player2.start();
            player2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                   terug_Naar_Home();
                }
            });
        }
    }
    public void Pause_onClick(View v) {
        if (player != null) {
            player.pause();
        }
    }
    public void terug_Naar_Home() {
        Bundle bundle = new Bundle();
        bundle.putLong("gebruikerId", spel.getGebruikerId());
        Intent intent = new Intent(this, Home.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }
}


