package de.mide.glossar_listview;


import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * App demonstriert Verwendung der Klasse ListView, die von einem ArrayAdapter
 * mit Daten für die einzelnen Zeilen (Listen-Einträge) versorgt wird.
 * Die einzelnen Listen-Einträge stellen Begriffe aus einem Glossar zum Thema
 * "Android" dar.<br><br>
 *
 * This project is licensed under the terms of the BSD 3-Clause License.
 */
public class MainActivity extends Activity 
                          implements AdapterView.OnItemClickListener {

    public static final String TAG4LOGGING = "ListViewDemo";


    /**
     * Lifecycle-Methode, richtet UI ein. Erzeugt auch Adapter-Objekt und
     * übergibt es an ein ListView-Element.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = findViewById(R.id.listview_1);

        List<String> begriffsListe = GlossarDaten.getGlossarBegriffe();
        Log.i(TAG4LOGGING, "Anzahl der Glossar-Einträge: " + begriffsListe.size() );

        MeinArrayAdapter meinArrayAdapter = new MeinArrayAdapter(this, begriffsListe);
        listView.setAdapter(meinArrayAdapter);

        listView.setOnItemClickListener(this);

        Toast.makeText(this, "Klick auf einen Eintrag öffnet Beschreibung.",
                       Toast.LENGTH_LONG).show();
    }


    /**
     * Einzige Methode aus Interface OnItemClickListener.
     * Wird aufgerufen, wenn auf einen Eintrage im ListView-Element geklickt wird.
     * Öffnet einen Dialog mit der zugehörigen Erklären für den Glossar-Eintrag.
     *
     * @param view  View-Element (Listen-Zeile), auf die geklickt wurde.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        TextView begriffsTextView = view.findViewById(R.id.textview_begriff);
        String begriff = begriffsTextView.getText().toString();

        String erklaerungStr = GlossarDaten.getErklaerung(begriff);
        if (erklaerungStr == null || erklaerungStr.trim().length() == 0) {

            Toast.makeText(this,
                           "INTERNER FEHLER: Keine Erklärung für \"" + begriff + "\" verfügbar.",
                           Toast.LENGTH_LONG).show();
            return;
        }


        // Dialog mit Erklärung Glossar-Eintrag erstellen & anzeigen
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle(begriff + ":");
        dialogBuilder.setMessage(erklaerungStr);
        dialogBuilder.setPositiveButton("Weiter", null);
        dialogBuilder.setCancelable(false); // wir brauchen keinen "Cancel"-Button

        AlertDialog dialog = dialogBuilder.create();
        dialog.show();
    }


    /* *************************** */
    /* *** Start innere Klasse *** */
    /* *************************** */
    protected class MeinArrayAdapter extends ArrayAdapter<String> {

        public MeinArrayAdapter(Context context, List<String>listeDerBegriffe) {

            super(context, R.layout.list_view_item, R.id.textview_begriff, listeDerBegriffe);
            // R.layout.list_view_item: Layout für EINE Zeile
            // R.id.textview_begriff:   TextView-Element im Layout für eine Zeile,
            //                          wird von der Super-Implementierung automatisch mit einem Eintrag
            //                          aus listeDerBegriffe befüllt.
        }


        /**
         * Methode liefert View-Element für EINE Listen-Zeile zurück.
         * Die Super-Implementierung befüllt schon das TextView-Element für den Begriff
         * anhand des im Konstruktor übergebenen List-Objekts. Die durchlaufende Nummer
         * für das zweite TextView-Element müssen wir in dieser Methode selbst bestimmt.
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = super.getView(position, convertView, parent);

            // Laufende Nummer (1...anzBegriffe) in TextView schreiben
            TextView nummerTextView = view.findViewById(R.id.textview_nummer);

            nummerTextView.setText( position + 1 + "" );

            return view;
        }
    }

    /* *************************** */
    /* *** Ende innere Klasse  *** */
    /* *************************** */

};
