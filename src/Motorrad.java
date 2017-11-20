import java.util.ArrayList;

/**
 * Diese Klasse speichert Informationen eines Motorrads.
 * @author Marc Rennhard
 */
public class Motorrad extends Fahrzeug
{
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
	super(modell, preis);
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
      Verkauf verkauf = new Verkauf(kunde, stueckzahlKaufen, stueckzahlKaufen * gibPreis());
      verkaeufe.add(verkauf);
      return kunde.gibInfo() + " hat " + stueckzahlKaufen + " Stueck des Modells " + gibModell() +
             " zu insgesamt CHF " + (stueckzahlKaufen * gibPreis()) + " gekauft";
      
    } else {
      return "Es hat leider nur noch " + stueckzahl + " Stueck des Modells " + gibModell() + " an Lager";
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
    String resultat = "Modell " + gibModell() + ", " + stueckzahl + " Fahrzeuge zu je CHF " + gibPreis() + " an Lager.\n";
    resultat += "Bereits erfolgte Verkaeufe:\n";
    for (Verkauf verkauf : verkaeufe) {
      resultat += verkauf.gibInfo() + "\n";
    }
    return resultat;
  }
}
