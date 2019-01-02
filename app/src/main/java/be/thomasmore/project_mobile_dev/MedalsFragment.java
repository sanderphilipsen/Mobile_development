package be.thomasmore.project_mobile_dev;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import be.thomasmore.project_mobile_dev.classes.Gebruiker;

public class MedalsFragment extends Fragment {
    @Nullable
    @Override
    public  View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_medals,container,false);
        Gebruiker gebruiker = new Gebruiker();
        gebruiker =  ((Home) getActivity()).getGebruiker();
        this.Set_MedailleMuur(gebruiker, view  );
     return  view;
    }
    public void Set_MedailleMuur(Gebruiker gebruiker, View view){
        final ImageView smedailleluistergoed = (ImageView) view.findViewById(R.id.supermedailleluistergoed);
        final TextView  sluistergoedlabel =(TextView) view.findViewById(R.id.supermedailleluistergoedlabel);
        final ImageView mmedailleluistergoed = (ImageView) view.findViewById(R.id.minimedailleluistergoed);
        final TextView  mmluistergoedlabel =(TextView) view.findViewById(R.id.minimedailleluistergoedlabel);
        if (Integer.parseInt(String.valueOf(gebruiker.getGrotemedaillesluistergoed()))>0) {
            smedailleluistergoed.setImageResource(R.drawable.supermedaille1);
            sluistergoedlabel.setText(String.valueOf(gebruiker.getGrotemedaillesluistergoed()));
        }
        else {
            smedailleluistergoed.setImageResource(R.drawable.supermedaillegrijs);
            sluistergoedlabel.setText("Nog geen supermedaille");
        }
        if (Integer.parseInt(String.valueOf(gebruiker.getMinimedaillesluistergoed()))>0) {
            mmedailleluistergoed.setImageResource(R.drawable.minimedaille1);
            sluistergoedlabel.setText(String.valueOf(gebruiker.getMinimedaillesluistergoed()));
        }
        else {
            mmedailleluistergoed.setImageResource(R.drawable.minimedaillegrijs);
            sluistergoedlabel.setText("Nog geen minimedaille");
    }
    }
}
