package hilfsAppMethode;
/**
 * 
 */


import apck_IO.IO;


/**
 * @author rk
 * @versio 1.0
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
				boolean wareneingang = IO.promptAndReadBoolean("Neue Ware im WE: ");
				if(wareneingang == true) {
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
				int bestandArtikelNr12345 = 25;
				
				if (bestandArtikelNr12345 > 0) {
					lhmStatus = StatusHrLagerplatz.BELEGT;
				} else if (bestandArtikelNr12345 == 0) {
					lhmStatus = StatusHrLagerplatz.FREI;
				}
				
				}
	}
}
