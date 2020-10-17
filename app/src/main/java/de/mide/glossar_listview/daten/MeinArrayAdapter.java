package de.mide.glossar_listview.daten;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import de.mide.glossar_listview.R;


/**
 * Adapter-Objekt, dass das von der Methode {@link GlossarDaten#getGlossarBegriffe()}
 * zurückgegebene {@link java.util.List<String>}-Objekt mit den Glossar-Begriffen
 * für ein ListView-Objekt bereitstellt.
 * <br><br>
 *
 * This project is licensed under the terms of the BSD 3-Clause License.
 */
public class MeinArrayAdapter extends ArrayAdapter<String> {

    /**
     * Konstruktor, der Konstruktor der Oberklasse aufruft und dabei Liste aller
     * Glossar-Begriffe übergibt.
     *
     * @param context  App-Kontext der aufrufenden Activity.
     */
    public MeinArrayAdapter(Context context) {

        super(  context,
                R.layout.listview_eintrag,
                R.id.textview_begriff,
                GlossarDaten.getGlossarBegriffe()
             );
    }


    /**
     * Laufende Nummer in ein Element mit einem Glossar-Begriff schreiben.
     * <br>
     *
     * Wenn diese Methode auskommentiert wird, dann haben alle ListView-Einträge die
     * Nummer "1" (was der Default-Wert in der Layout-Datei ist).
     *
     * @param position  0-basierter Index des Listen-Elements; wir addieren +1,
     *                  um die laufende Nummer für das Listen-Element zu erhalten.
     *
     * @return  Darzustellendes {@link TextView}-Element.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = super.getView(position, convertView, parent);

        TextView nummerTextView = view.findViewById(R.id.textview_nummer);

        int nummer = position + 1;
        nummerTextView.setText( nummer + "" );

        return view;
    }

}
