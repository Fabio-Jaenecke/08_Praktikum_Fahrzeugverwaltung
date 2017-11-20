import java.util.ArrayList;

/**
 * Diese Klasse speichert Informationen eines Fahrrads.
 * @author Marc Rennhard
 */
public class Fahrrad extends Fahrzeug
{
  private int stueckzahl;
  private int gaenge;
  ArrayList<Verkauf> verkaeufe;
  
  /**
   * Konstruktor, um ein Fahrrad zu erzeugen.
   * @param modell Das Modell 
   * @param preis Der Preis
   * @param stueckzahl Die verfuegbare Stueckzahl
   * @param gaenge Die Anzah der Gaenge
   */
  public Fahrrad(String modell, int preis, int stueckzahl, int gaenge)
  {
	super(modell, preis);
    this.stueckzahl = stueckzahl;
    this.gaenge = gaenge;
    verkaeufe = new ArrayList<Verkauf>();
  }
  
  /**
   * Kaufe das Fahrrad in der gewuenschten Stueckzahl.
   * @param stueckzahlKaufen Die gewuenschte Stueckzahl
   * @param kunde Der Kunde
   * @return Informationen ueber das Ergebnis des Kaufs
   */
  public String kaufen(int stueckzahlKaufen, Kunde kunde)
  {
    if (stueckzahlKaufen <= stueckzahl) {
      stueckzahl -= stueckzahlKaufen;
      Verkauf verkauf = new Verkauf(kunde, stueckzahlKaufen, stueckzahlKaufen * gibPreis());
      verkaeufe.add(verkauf);
      return kunde.gibInfo() + " hat " + stueckzahlKaufen + " Stueck des Modells " + gibModell() +
             " zu insgesamt CHF " + (stueckzahlKaufen * gibPreis()) + " gekauft";
      
    } else {
      return "Es hat leider nur noch " + stueckzahl + " Stueck des Modells " + gibModell() + " an Lager";
    }
  }
  
  /**
   * Setze die verfuegbare Stueckzahl des Fahrrads.
   * @param stueckzahl Die Stueckzahl
   */
  public void setzeStueckzahl(int stueckzahl) 
  {
    if (stueckzahl >= 0) {
      this.stueckzahl = stueckzahl;
    }
  }
  
  /**
   * Liefert die Anzahl Gaenge des Fahrrads.
   * @return Die Anzahl Gaenge
   */
  public int gibGaenge()
  {
    return gaenge;
  }
  
  /**
   * Gibt Informationen des Fahrrads zurueck.
   * @return Informationen des Verkaufs
   */
  public String gibInfo() {
    String resultat = "Modell " + gibModell() + ", " + stueckzahl + " Fahrzeuge zu je CHF " + gibPreis() + " an Lager.\n";
    resultat += "Bereits erfolgte Verkaeufe:\n";
    for (Verkauf verkauf : verkaeufe) {
      resultat += verkauf.gibInfo() + "\n";
    }
    return resultat;
  }
}
