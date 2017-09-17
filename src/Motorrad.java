import java.util.ArrayList;

/**
 * Diese Klasse speichert Informationen eines Motorrads.
 * @author Marc Rennhard
 */
public class Motorrad 
{
  private String modell;
  private int preis;
  private int stueckzahl;
  private int leistung;
  private boolean abs;
  ArrayList<Verkauf> verkaeufe;
  
  /**
   * Konstruktor, um ein Motorrad zu erzeugen.
   * @param modell Das Modell 
   * @param preis Der Preis
   * @param stueckzahl Die verfuegbare Stueckzahl
   * @param leistung Die Leistung in PS
   * @param abs Ob das Motorrad ABS hat
   */
  public Motorrad(String modell, int preis, int stueckzahl, int leistung, boolean abs)
  {
    this.modell = modell;
    this.preis = preis;
    this.stueckzahl = stueckzahl;
    this.leistung = leistung;
    this.abs = abs;
    verkaeufe = new ArrayList<Verkauf>();
  }
  
  /**
   * Kaufe das Motorrad in der gewuenschten Stueckzahl.
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
   * Liefert das Modell des Motorrads.
   * @return Das Modell
   */
  public String gibModell() 
  {
    return modell;
  }
  
  /**
   * Setzt den Preis des Motorrads.
   * @param preis Der Preis
   */
  public void setzePreis(int preis) 
  {
    if (preis > 0) {
      this.preis = preis;
    }
  }
  
  /**
   * Setze die verfuegbare Stueckzahl des Motorrads.
   * @param stueckzahl Die Stueckzahl
   */
  public void setzeStueckzahl(int stueckzahl) 
  {
    if (stueckzahl >= 0) {
      this.stueckzahl = stueckzahl;
    }
  }
  
  /**
   * Liefert die Leistung des Motorrads.
   * @return Die Leistung
   */
  public int gibLeistung()
  {
    return leistung;
  }
  
  /**
   * Liefert ob das Motorrad ABS hat.
   * @return Ob das Motorrad ABS hat (true) oder nicht
   */
  public boolean gibAbs()
  {
    return abs;
  }
  
  /**
   * Gibt Informationen des Motorrads zurueck.
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
