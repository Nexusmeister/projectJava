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
				int artikelSt�ckzahl;
				boolean wareneingang = IO.promptAndReadBoolean("Neue Ware im WE: ");
				if(wareneingang == true) {
					artikelSt�ckzahl = IO.promptAndReadInteger("St�ckzahl der Ware auf LHM: " );
					HR_LAGERPLATZ++;
					IO.writeln("Belege HR-Lagerplatz HR" + HR_LAGERPLATZ);
				} else {
					IO.writeln("Warte auf neues Ereignis.");
					continue;
				}
				boolean qm = IO.promptAndReadBoolean("Labor�berpr�fung der Ware: ");
				
				if (qm == true) {
					lhmStatus = StatusHrLagerplatz.GESPERRT;
					IO.writeln("LHM-Status: " + lhmStatus.toString());
					IO.writeln("Warte auf Abschluss der QM-Pr�fung...");
					boolean qmPr�fung = IO.promptAndReadBoolean("Ware hat Pr�fung bestanden: ");
					if (qmPr�fung == false) {
						IO.writeln("Schicke Ware an Zulieferer zur�ck.");
					} else {
						lhmStatus = StatusHrLagerplatz.FREI;
						IO.writeln("Einlagerung der Ware erfolgt.");
						IO.writeln("LHM-Status: " + lhmStatus.toString());
					}
					
				} else {
					lhmStatus = StatusHrLagerplatz.FREI;
				}
			
				
				if (artikelSt�ckzahl > 0) {
					lhmStatus = StatusHrLagerplatz.BELEGT;
				} else if (artikelSt�ckzahl == 0) {
					lhmStatus = StatusHrLagerplatz.FREI;
					IO.writeln("Warenbestand auf LHM in HR" + HR_LAGERPLATZ + " ist bei 0!");
					boolean neueWareAnfordern = IO.promptAndReadBoolean("Neue Ware bei Zulieferer anfordern: ");
					
					if(neueWareAnfordern == true) {
						IO.writeln("Bestellung an Zulieferer wird versendet.");
						MethodeF�rBestellung.gebeBestellungAuf();
					}
				}
				
				}
	}
}
