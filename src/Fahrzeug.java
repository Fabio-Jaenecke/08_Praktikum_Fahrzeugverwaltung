/** Modelliert die Superklasse aller Fahrzeuge
 *  
 *  Bietet die Datenfelder modell und preis an.
 * 
 *
 * @author daniellerch
 *
 */

public class Fahrzeug {
	private String modell;
	private int preis;
	
	public Fahrzeug(String modell, int preis) {
		this.modell = modell;
		this.preis = preis;
	}
	
	 /**
	   * Liefert das Modell des Fahrzeugs.
	   * @return Das Modell
	   */
	  public String gibModell() 
	  {
	    return modell;
	  }
	  
	  /**
	   * Setzt den Preis des Fahrzeugs.
	   * @param preis Der Preis
	   */
	  public void setzePreis(int preis) 
	  {
	    if (preis > 0) {
	      this.preis = preis;
	    }
	  }
	  
	  /**
	   * Gibt den Preis des Fahrzeugs.
	   */
	  public int gibPreis() 
	  {
	    return preis;
	  }
	  
	  
}
