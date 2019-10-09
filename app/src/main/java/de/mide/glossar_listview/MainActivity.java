package de.mide.glossar_listview;


import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import de.mide.glossar_listview.daten.GlossarDaten;
import de.mide.glossar_listview.daten.MeinArrayAdapter;


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


    /** Markierung für alle Log-Nachrichten, die von dieser App geschrieben werden. */
    public static final String TAG4LOGGING = "ListViewDemo";


    /**
     * Lifecycle-Methode, richtet UI ein. Erzeugt auch Adapter-Objekt und
     * übergibt es an ein ListView-Element.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = findViewById(R.id.begriffe_listview);

        MeinArrayAdapter meinArrayAdapter = new MeinArrayAdapter(this );
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

        String begriff            = begriffsTextView.getText().toString();

        String erklaerungStr      = GlossarDaten.getErklaerung(begriff);

        if (erklaerungStr == null || erklaerungStr.trim().length() == 0) {

            Log.w(TAG4LOGGING, "Keine Definition für Begriff \"" + begriff + "\" erhalten.");

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

};
