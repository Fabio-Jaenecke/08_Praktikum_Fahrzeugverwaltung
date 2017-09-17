import java.util.ArrayList;

/**
 * Diese Klasse speichert Informationen eines Fahrrads.
 * @author Marc Rennhard
 */
public class Fahrrad 
{
  private String modell;
  private int preis;
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
    this.modell = modell;
    this.preis = preis;
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
      Verkauf verkauf = new Verkauf(kunde, stueckzahlKaufen, stueckzahlKaufen * preis);
      verkaeufe.add(verkauf);
      return kunde.gibInfo() + " hat " + stueckzahlKaufen + " Stueck des Modells " + modell +
             " zu insgesamt CHF " + (stueckzahlKaufen * preis) + " gekauft";
      
    } else {
      return "Es hat leider nur noch " + stueckzahl + " Stueck des Modells " + modell + " an Lager";
    }
  }
  
  /**
   * Liefert das Modell des Fahrrads.
   * @return Das Modell
   */
  public String gibModell() 
  {
    return modell;
  }
  
  /**
   * Setzt den Preis des Fahrrads.
   * @param preis Der Preis
   */
  public void setzePreis(int preis) 
  {
    if (preis > 0) {
      this.preis = preis;
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
    String resultat = "Modell " + modell + ", " + stueckzahl + " Fahrzeuge zu je CHF " + preis + " an Lager.\n";
    resultat += "Bereits erfolgte Verkaeufe:\n";
    for (Verkauf verkauf : verkaeufe) {
      resultat += verkauf.gibInfo() + "\n";
    }
    return resultat;
  }
}
