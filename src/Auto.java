import java.util.ArrayList;

/**
 * Diese Klasse speichert Informationen eines Autos.
 * @author Marc Rennhard
 */
public class Auto extends Fahrzeug
{
  private int stueckzahl;
  private int leistung;
  private int plaetze;
  private boolean vierradantrieb;
  ArrayList<Verkauf> verkaeufe;
  
  /**
   * Konstruktor, um ein Auto zu erzeugen.
   * @param modell Das Modell 
   * @param preis Der Preis
   * @param stueckzahl Die verfuegbare Stueckzahl
   * @param leistung Die Leistung in PS
   * @param plaetze Die Sitzplaetze
   * @param abs Ob das Auto Vierradantrieb hat
   */
  public Auto(String modell, int preis, int stueckzahl, int leistung, int plaetze, boolean vierradantrieb)
  {
	super(modell, preis);
    this.stueckzahl = stueckzahl;
    this.leistung = leistung;
    this.plaetze = plaetze;
    this.vierradantrieb = vierradantrieb;
    verkaeufe = new ArrayList<Verkauf>();
  }
  
  /**
   * Kaufe das Auto in der gewuenschten Stueckzahl.
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
   * Setze die verfuegbare Stueckzahl des Autos.
   * @param stueckzahl Die Stueckzahl
   */
  public void setzeStueckzahl(int stueckzahl) 
  {
    if (stueckzahl >= 0) {
      this.stueckzahl = stueckzahl;
    }
  }
  
  /**
   * Liefert die Leistung des Autos.
   * @return Die Leistung
   */
  public int gibLeistung()
  {
    return leistung;
  }
  
  /**
   * Liefert die Anzahl Sitzplaetze des Autos.
   * @return Die Anzahl Plaetze
   */
  public int gibPlaetze()
  {
    return plaetze;
  }
  
  /**
   * Liefert ob das Auto Vierradantrieb hat.
   * @return Ob das Auto Vierradantrieb hat (true) oder nicht
   */
  public boolean gibVierradantrieb()
  {
    return vierradantrieb;
  }
  
  /**
   * Gibt Informationen des Autos zurueck.
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
