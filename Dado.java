/**
 * @author Aresu Matteo 4Cinf
 * @version 0.1, Last Update 31/01/2020
 */

/*Dado

  //attributi variabili
  - num : int
  - tip : int

  //attributi costanti
  + D4 = 4 : int
  + D6 = 6 : int
  + D8 = 8 : int
  + D10 = 10 : int
  + D12 = 12 : int
  + D20 = 20 : int
  + D100 = 100 : int

  //metodi costruttori
  + Dado (in num, tip : int) 
  + Dado (in d : Dado) 

  //metodi accessori
  + getNum() : int
  + getTip() : int
  
  //metodi modificatori
  + setNum(in x : int) : boolean
  + setTip(in x : int) : boolean
  + lancia() : int
  
  //altri metodi
  + toString () : String
  + equals (in o : Object) : boolean

*/

//import
import java.util.Random;

//definizione classe
public class Dado {

    //attributi variabili
    private int num, tip;

    //attributi costanti
    public static final int D4 = 4;
    public static final int D6 = 6;
    public static final int D8 = 8;
    public static final int D10 = 10;
    public static final int D12 = 12;
    public static final int D20 = 20;
    public static final int D100 = 100;

    //metodi costruttori
    /**
     * Metodo Costruttore Dado
     * @param n Il numero di dadi
     * @param t Il tipo di dado
     */
    public Dado (int n, int t) {
	if (n < 0) num = 1;
	else num = n;

	if (t != D4 &&
	    t != D6 &&
	    t != D8 &&
	    t != D10 &&
	    t != D12 &&
	    t != D20 &&
	    t != D100) tip = 6;
	else tip = t;
    }

    /**
     * Metodo Costruttore di copia Dado
     * @param d Il dado da copiare
     */
    public Dado (Dado d) {
	if (d == null) {
	    num = 1;
	    tip = 6;
	} else {
	    num = d.getNum();
	    tip = d.getTip();
	}
    }

    //metodi accessori
    /**
     * Metodo Accessorio num
     * @return Il numero di dadi
     */
    public int getNum() { return num; }

    /**
     * Metodo Accessorio tip
     * @return Il tipo di dadi
     */
    public int getTip() { return tip; }

    //metodi modificatori
    /**
     * Metodo Modificatore num
     * @param Il nuovo numero di dadi
     */
    public boolean setNum(int x) {
	boolean result = true;
	if (x<0) result = false;
	else num = x;
	return result;
    }

    /**
     * Metodo Modificatore tip
     * @param Il nuovo tipo di dadi
     */
    public boolean setTip(int x) {
	boolean result = true;
	if (x != D4 &&
	    x != D6 &&
	    x != D8 &&
	    x != D10 &&
	    x != D12 &&
	    x != D20 &&
	    x != D100) result = false;
	else tip = x;
	return result;
    }

    /**
     * Metodo Modificatore per lanciare i dadi
     * @return Il risultato
     */
    public int lancia() {
	int x = 0;
	Random r = new Random();
	for (int cont = 0; cont<num; cont++) {
	    x = x + r.nextInt(tip)+1;
	}
	return x;
    }

    //altri metodi
    /**
     * Metodo Stringa che restituisce lo stato dell'oggetto
     */
    public String toString() {
	return num + "D" + tip;
    }

    /**
     * Metodo di confronto tra due oggetti
     * @param o L'oggetto da confrontare
     */
    public boolean equals(Object o) {
	boolean result = true;

	if ( o == null ||
	     !(o instanceof Dado) ||
	     num != ((Dado)o).getNum() ||
	     tip != ((Dado)o).getTip() ) result = false;

	return result;

    }

}
  
