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
        View view =  inflater.inflate(R.layout.fragment_medals, container,false);
        Gebruiker gebruiker = new Gebruiker();
        gebruiker =  ((Home) getActivity()).getGebruiker();
        this.Set_MedailleMuur(gebruiker, view  );
     return  view;
    }
   public void Set_MedailleMuur(Gebruiker gebruiker, View view) {
       final ImageView smedailleluistergoed = (ImageView) view.findViewById(R.id.supermedailleluistergoed);
        final TextView sluistergoedlabel = (TextView) view.findViewById(R.id.supermedailleluistergoedlabel);
       final ImageView mmedailleluistergoed = (ImageView) view.findViewById(R.id.minimedailleluistergoed);
       final ImageView mmedaillezeg = (ImageView) view.findViewById(R.id.minimedaillezeg);
       final ImageView smedaillezeg = (ImageView) view.findViewById(R.id.supermedaillezeg);
      final TextView mmluistergoedlabel = (TextView) view.findViewById(R.id.minimedailleluistergoedlabel);
       final TextView mmzeglabel = (TextView) view.findViewById(R.id.minimedaillezeglabel);
       final TextView szeglabel = (TextView) view.findViewById(R.id.supermedaillezeglabel);

     if (Integer.parseInt(String.valueOf(gebruiker.getGrotemedaillesluistergoed())) > 0) {
         sluistergoedlabel.setText("Je hebt al " + String.valueOf(gebruiker.getGrotemedaillesluistergoed()) + " minimedaille!");
       } else {
           smedailleluistergoed.setImageResource(R.drawable.supermedaillegrijs);
      sluistergoedlabel.setText("Nog geen supermedaille");
       }
       if (Integer.parseInt(String.valueOf(gebruiker.getMinimedaillesluistergoed())) > 0) {

           mmedailleluistergoed.setImageResource(R.drawable.minimedaille1);
             mmluistergoedlabel.setText("Je hebt al " + String.valueOf(gebruiker.getMinimedaillesluistergoed()) + " minimedailles!");
       } else {
            mmedailleluistergoed.setImageResource(R.drawable.minimedaillegrijs);
          mmluistergoedlabel.setText("Nog geen minimedaille");
       }
       if (Integer.parseInt(String.valueOf(gebruiker.getGrotemedailleszeg()))>0) {
           smedaillezeg.setImageResource(R.drawable.supermedaille2);
            szeglabel.setText("je hebt al " + String.valueOf(gebruiker.getGrotemedailleszeg()) + " supermedailles!");
       }else{
           smedaillezeg.setImageResource(R.drawable.supermedaillegrijs);
           szeglabel.setText("Nog geen suppermedailles");
       }
       if (Integer.parseInt(String.valueOf(gebruiker.getMinimedailleszeg()))>0) {
           mmedaillezeg.setImageResource(R.drawable.minimedaille2);
          mmzeglabel.setText("je hebt al " + String.valueOf(gebruiker.getMinimedailleszeg()) + " minimedailles!");
       }
       else {
           mmedaillezeg.setImageResource(R.drawable.minimedaillegrijs);
           mmzeglabel.setText("Nog geen minimedailles");
       }

   }
}
