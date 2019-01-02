package be.thomasmore.project_mobile_dev;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import be.thomasmore.project_mobile_dev.classes.Gebruiker;

public class HomeFragment extends Fragment {
    public String gebruikerNaam;
    public Gebruiker gebruiker;

    @Nullable
    @Override
    public  View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view =  inflater.inflate(R.layout.fragment_home,container,false);
      gebruikerNaam =  ((Home) getActivity()).getGebruikerNaam();
         TextView editTextNaam = (TextView) view.findViewById(R.id.welkom);
         editTextNaam.setText("Hallo "+ gebruikerNaam + "! Speel je met mij mee?");
         Gebruiker gebruiker = new Gebruiker();
         gebruiker =  ((Home) getActivity()).getGebruiker();
         Set_Token(gebruiker, view);
        return view;
    }
    public void Set_Token(Gebruiker gebruiker ,View view){
        final ImageView imageViewToken = (ImageView) view.findViewById(R.id.token);
        switch (gebruiker.getToken()){
            case  "Spongebob" :
                imageViewToken.setImageResource(R.drawable.spongebob);
                break;
            case  "Patrick" :
                imageViewToken.setImageResource(R.drawable.patrick);
                break;
            case  "Octo" :
                imageViewToken.setImageResource(R.drawable.octo);
                break;
            case  "Krab" :
                imageViewToken.setImageResource(R.drawable.krabs);
                break;

        }

    }
}


