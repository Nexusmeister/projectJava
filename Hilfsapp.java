package hilfsAppMethode;
/**
 * 
 */


import apck_IO.IO;


/**
 * @author rk
 * @version 1.0
 *
 */

public class Hilfsapp {
	
	public static int HR_LAGERPLATZ = 1000;
		
		public enum StatusHrLagerplatz {
			FREI, BELEGT, GESPERRT;
		}
	

	public static void testeErsteApplikation() {
		// Test Enum
				Hauptschleife:
				while(true) {
				StatusHrLagerplatz lhmStatus;
				int artikelStückzahl;
				boolean wareneingang = IO.promptAndReadBoolean("Neue Ware im WE: ");
				if(wareneingang == true) {
					artikelStückzahl = IO.promptAndReadInteger("Stückzahl der Ware auf LHM: " );
					HR_LAGERPLATZ++;
					IO.writeln("Belege HR-Lagerplatz HR" + HR_LAGERPLATZ);
				} else {
					IO.writeln("Warte auf neues Ereignis.");
					continue;
				}
				boolean qm = IO.promptAndReadBoolean("Laborüberprüfung der Ware: ");
				
				if (qm == true) {
					lhmStatus = StatusHrLagerplatz.GESPERRT;
					IO.writeln("LHM-Status: " + lhmStatus.toString());
					IO.writeln("Warte auf Abschluss der QM-Prüfung...");
					boolean qmPrüfung = IO.promptAndReadBoolean("Ware hat Prüfung bestanden: ");
					if (qmPrüfung == false) {
						IO.writeln("Schicke Ware an Zulieferer zurück.");
					} else {
						lhmStatus = StatusHrLagerplatz.FREI;
						IO.writeln("Einlagerung der Ware erfolgt.");
						IO.writeln("LHM-Status: " + lhmStatus.toString());
					}
					
				} else {
					lhmStatus = StatusHrLagerplatz.FREI;
				}
			
				
				if (artikelStückzahl > 0) {
					lhmStatus = StatusHrLagerplatz.BELEGT;
				} else if (artikelStückzahl == 0) {
					lhmStatus = StatusHrLagerplatz.FREI;
					IO.writeln("Warenbestand auf LHM in HR" + HR_LAGERPLATZ + " ist bei 0!");
					boolean neueWareAnfordern = IO.promptAndReadBoolean("Neue Ware bei Zulieferer anfordern: ");
					
					if(neueWareAnfordern == true) {
						IO.writeln("Bestellung an Zulieferer wird versendet.");
						MethodeFürBestellung.gebeBestellungAuf();
					}
				}
				
				}
	}
}
