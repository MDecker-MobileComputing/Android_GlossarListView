package de.mide.glossar_listview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


/**
 * Diese Klasse stellt die anzuzeigenden Glossar-Begriffe zur Verfügung.
 */
public class GlossarDaten {

    /** Hashmap, bildet Glossar-Eintrag auf Erklärungs-Text ab. */
	protected static HashMap<String,String> sHashMap = null;


	/**
	 * Schreibt die Glossar-Einträge als Paare "Begriff -- Erklärung" in eine Hashmap
	 * (Begriff ist der Key).
	 * Begriffe werden in alphabetischer Reihenfolge hinzugefügt, damit man im Quellcode
	 * schnell erkennt, ob ein Begriff schon vorhanden ist.
	 */
	protected static void initDaten() {

		sHashMap = new HashMap<String, String>();

		sHashMap.put("AAPT",
					 "Android Asset Packaging Tool. Programm aus dem Android-SDK, welches u.a. die APK-Datei Installations-Datei) erzeugt.");

		sHashMap.put("ADB",
				     "Android Debug Bridge");

		sHashMap.put("ADT",
			     	 "Android Development Tools");

		sHashMap.put("AIDL",
					 "Android Interface Description Language");

		sHashMap.put("ANR",
					 "Application not Responsing. Kurzbezeichnung für Fehlermeldung, wenn der Main-Thread einer App zu lange (z.B. länger als 5 Sekunden) blockiert wird.");

		sHashMap.put("AOSP",
				 	 "Android Open Source Projekt; pflegt Android-Quelltexte.");

		sHashMap.put("APK",
				     "Android Package; Dateiformat, in dem eine Android-App auf einem Gerät installiert werden muss.");

		sHashMap.put("ART",
			     	 "Android Runtime; Nachfolger für DVM.");

		sHashMap.put("AVD",
		     	 	 "Android Virtual Device; Instanz eines Android-Gerätes im Emulator.");

		sHashMap.put("Bionic",
			     	 "Unter Android verwendeter Ersatz für die Linux-Standard-C-Bibliothek glib.");

		sHashMap.put("C2DM",
				     "Android Cloud to Device Messaging Service; Push-Dienst seit Android 2.2.");

		sHashMap.put("Cupcake",
	     	 	 	 "Codename für Android-Version 1.5 (API-Level 3).");

		sHashMap.put("CustomROM",
	 	     	 	 "Inoffizielle Android-Version, Gegenteil von StockROM. Beispiele: CyanogenMod, Replicant, AOKP.");

		sHashMap.put("CyanogenMod",
	 	 	     	 "Beispiel für ein CustomROM, also eine inoffizielle Android-Version.");

		sHashMap.put("Daydream",
			         "Interaktiver Bildschirmschoner");

		sHashMap.put("DDMS",
		             "Dalvik Debug Monitor Service, SDK-Werkzeug und Perspektive in ADT/Eclipse, u.a. für Anzeige Logcat, Zugriff auf Dateisystem und Anzeige Prozesse der Emulator-Instanz.");

		sHashMap.put("DEX",
					 "Dalvik Executable. Binärformat für die Virtual Machine von Android. Alle Class-Dateien einer App befinden sich in EINER DEX-Datei.");

		sHashMap.put("Donut",
    	 	 	 	 "Codename für Android-Version 1.6 (API-Level 4).");

		sHashMap.put("DVM",
				 	 "Dalvik Virtual Machine. Virtuelle Maschine zur Ausführung des Byte-Codes im DEX-Format auf einem Android-Gerät.");

		sHashMap.put("Eclair",
	 	 	 	 	 "Codename für Android-Version 2.0 bis 2.1.x (API-Level 5 bis 7).");

		sHashMap.put("Froyo",
	 	 	 	 	 "Frozen Yogurt; Codename für Android-Version 2.2.x (API-Level 8).");

		sHashMap.put("Gingerbread",
	 	 	 	 	 "Codename für Android-Versionen 2.3 bis 2.3.4 (API-Level 9 & 10).");

		sHashMap.put("Honeycomb",
	 	 	 	 	 "Codename für Android-Versionen 3.0.x bis 3.2 (API-Level 11 bis 13).");

		sHashMap.put("ICS",
					 "Abkürzung für \"Ice Cream Sandwich\", Codename für Android-Versionen von 4.0 bis 4.0.4 (API-Level 14 & 15)");

		sHashMap.put("Java ME",
				     "Java MicroEdition, \"Handy-Java\", nicht mit Android kompatibel.");

		sHashMap.put("Jelly Bean",
			     	 "Codename für Android-Versionen 4.1 bis 4.3.3  (API-Level 16 bis 18).");

		sHashMap.put("KitKat",
		     	 	 "Codename für Android-Version 4.3 (API-Level 19).");

		sHashMap.put("Key Lime Pie",
	     	 	 	 "Ursprünglich vermuteter Codename für Android-Version mit API-Level 19.");

		sHashMap.put("MIPS",
				 	 "CPU-Architektur für embedded Devices, auf die Android auch portiert wurde.");

		sHashMap.put("MR",
	 	 	 	 	 "Milestone Release; Zusatz für Codename mancher Android-Versionen, z.B. \"Honeycomb_MR2\" für Version 3.2 (API-Level 13).");

		sHashMap.put("NDK",
					 "Native Development Kit, um mit C/C++ Funktionen zu entwickeln, die aus Android heraus aufgerufen werden, z.B. für besonders rechenintensive Operationen.");

		sHashMap.put("Nine-Patch-Grafiken",
				 	 "Erweiterung für das Grafikformat \"PNG\"; durch einen Rand von einem Pixel Breite kann definiert werden, wie sich die Grafik bei unterschiedlichen Größen verhält, z.B. welche Bereiche gedehnt werden können.");

		sHashMap.put("OHA",
	 	 	 	 	 "Open Handset Alliance; Organisation von über 80 Technologie-Firmen (z.B. Mobilfunkprovider, Smartphone-Hersteller), die hinter Android steht.");

		sHashMap.put("Rooten",
	 	 	 	 	 "Android-Gerät z.B. durch Flashen der Firmware so manipulieren, dass dem normalen Endnutzer volle (Admin-)Rechte (Root-Rechte) zur Verfügung stehen.");

		sHashMap.put("SQLite",
			 	 	 "Kleines relationales Datenbank-System, das auch in Android zur Verfügung steht.");

		sHashMap.put("StockROM",
		 	 	     "Original-ROM von Hersteller, Gegenteil von inoffiziellem CustomROM wie CyanogenMod.");

		sHashMap.put("WebKit",
		 	 	 	 "HTML-Rendering-Engine, wird von Standard-Webbrowser von Android und WebView-Element verwendet.");

		sHashMap.put("Widget",
	 	 	 	 	 "Kurzform für \"Homescreen Widgets\", auch \"AppWidgets\"; UI auf Homescreen.");
	}


	/**
	 * Liefert sortierte Liste mit allen Glossar-Begriffen
	 * zurück (nur die Begriffe, nicht die Erklärung).
	 *
	 * @return List mit den Glossar-Begriffe, z.B. "ADB" oder "Daydream".
	 */
	public static List<String> getGlossarBegriffe() {

		if (sHashMap == null) initDaten();

		List<String> begriffsListe = new ArrayList<String>( sHashMap.keySet() );
		Collections.sort(begriffsListe);

		return begriffsListe;
	}


	/**
	 * Abfragen des Erklärungstextes für einen Glossar-Begriff.
	 *
	 * @param glossarBegriff Begriff, für den die Erklärung benötigt wird.
	 * @return Erklärung oder <tt>null</tt>, wenn nicht gefunden.
	 */
	public static String getErklaerung(String glossarBegriff) {

		return sHashMap.get(glossarBegriff);
	}

};
