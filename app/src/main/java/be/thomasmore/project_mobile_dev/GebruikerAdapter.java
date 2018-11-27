package be.thomasmore.project_mobile_dev;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import java.util.List;

public class GebruikerAdapter extends ArrayAdapter<Gebruiker> {

    private final Context context;
    private final List<Gebruiker> values;

    public GebruikerAdapter(Context context, List<Gebruiker> values) {
        super(context, R.layout.gebruikerlistviewitem, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.gebruikerlistviewitem, parent, false);

        final TextView textViewVoornaam= (TextView) rowView.findViewById(R.id.voornaam);
        final TextView textViewFamilienaam = (TextView) rowView.findViewById(R.id.familienaam);
        final ImageView imageViewToken = (ImageView) rowView.findViewById(R.id.token);

        textViewVoornaam.setText(values.get(position).getVoornaam());
        textViewFamilienaam.setText(values.get(position).getFamilienaam());
        switch (values.get(position).getToken()){
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

        return rowView;
    }

}
