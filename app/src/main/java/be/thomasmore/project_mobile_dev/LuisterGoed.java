package be.thomasmore.project_mobile_dev;

import java.util.Random;
import android.os.Bundle;
import android.content.Intent;
import android.view.Gravity;
import android.widget.ImageView;
import android.os.Bundle;
import android.util.Log;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.media.AudioManager;
import android.widget.TextView;
import android.media.MediaPlayer;
import android.widget.PopupWindow;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;
import be.thomasmore.project_mobile_dev.classes.Spel;
import be.thomasmore.project_mobile_dev.classes.Gebruiker;

public class LuisterGoed extends AppCompatActivity {
    public Spel spel;
    public MediaPlayer player;
    public MediaPlayer player2;
    public DatabaseHelper db;
    public long spelId;
    public  PopupWindow popupWindow;
    public  LinearLayout layout;
    public TextView tv;
    public ImageView medaille;
    public   LayoutParams params;
    public LinearLayout mainLayout;
    public  Random rand ;
    public Gebruiker gebruiker;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luister_goed);
        db = new DatabaseHelper(this);
        spel = new Spel();
        Bundle bundle = getIntent().getExtras();
        spel.setDoelklankId(bundle.getLong("doelklankId"));
        spel.setGebruikerId(bundle.getLong("gebruikerId"));
        spel.setSpeltypeId(bundle.getLong("speltypeId"));
        spelId = db.insertSpel(spel);
        this.gebruiker = db.getGebruiker(bundle.getLong("gebruikerId"));
        popupWindow = new PopupWindow(this);
        layout = new LinearLayout(this);
        mainLayout = new LinearLayout(this);
        medaille = new ImageView(this);
        tv = new TextView(this);
        params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        layout.setOrientation(LinearLayout.VERTICAL);
        tv.setText("Je hebt een minimedaille verdiend!");
     //   medaille.setImageResource(R.drawable.minimedaille2);
        layout.addView(medaille,params);
        layout.addView(tv,params);
        popupWindow.setContentView(layout);
        speel_instructie();
    }
    public void speel_instructie() {
        player = MediaPlayer.create(this, R.raw.spel1bis);
        player.start();
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
            player.stop();
            player = null;
            }
        });
    }
    public void speel_onClick(View v) {
        if (player == null) {
            switch (Integer.parseInt(String.valueOf(spel.getDoelklankId()))) {
                case 1:
                    Log.i("1","gaat creeren");
                    player = MediaPlayer.create(this, R.raw.reeks1);
                    break;
                case 2:
                    Log.i("1","gaat creeren");

                    player = MediaPlayer.create(this, R.raw.reeks5);
                    break;
                case 3:
                    Log.i("1","gaat creeren");

                    player = MediaPlayer.create(this, R.raw.reeks3);
                    break;
                case 4:
                    Log.i("1","gaat creeren");

                    player = MediaPlayer.create(this, R.raw.reeks2);
                    break;
                case 5:
                    Log.i("1","gaat creeren");

                    player = MediaPlayer.create(this, R.raw.reeks4);
                    break;
                case 6:
                    Log.i("1","gaat creeren");

                    player = MediaPlayer.create(this, R.raw.reeks6);
                    break;
                case 7:
                    Log.i("1","gaat creeren");

                    player = MediaPlayer.create(this, R.raw.reeks3);
                    break;
                case 8:
                    Log.i("1","gaat creeren");

                    player = MediaPlayer.create(this, R.raw.reeks4);
                    break;
                case 9:
                    Log.i("1","gaat creeren");

                    player = MediaPlayer.create(this, R.raw.reeks8);
                    break;
                case 10:
                    Log.i("1","gaat creeren");

                    player = MediaPlayer.create(this, R.raw.reeks9);
            }
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                goedGedaan();
                }
            });
            Log.i("d","wilt starten");
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
     /*   popupWindow.showAtLocation(layout, Gravity.CENTER,10,10);
            popupWindow.update(0,0,1000,1000);*/
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
        AddMedaille();
        bundle.putLong("gebruikerId", spel.getGebruikerId());
        Intent intent = new Intent(this, Home.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void AddMedaille() {
        if (this.gebruiker.getMinimedaillesluistergoed()==5){
            this.gebruiker.setGrotemedaillesluistergoed(this.gebruiker.getGrotemedaillesluistergoed()+1);
            this.gebruiker.setMinimedaillesluistergoed(Long.parseLong("0"));
        }
        else{
            this.gebruiker.setMinimedaillesluistergoed(this.gebruiker.getMinimedaillesluistergoed()+1);
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }
}


