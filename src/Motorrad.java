
/**
 * Diese Klasse speichert Informationen eines Motorrads.
 * @author Marc Rennhard
 */
public class Motorrad extends Fahrzeug
{
  private int leistung;
  private boolean abs;
  
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
    super(modell, preis, stueckzahl);
    this.leistung = leistung;
    this.abs = abs;
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
}
