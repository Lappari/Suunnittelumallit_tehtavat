package main;

public class Main {
	public static void main(String[] args) {

		Valkokangas valkokangas = new Valkokangas();
		ICommand alasPainike = new ValkokangasAlas(valkokangas);
		ICommand ylosPainike = new ValkokangasYlos(valkokangas);
		SeinaPainike alas = new SeinaPainike(alasPainike);
		SeinaPainike ylos = new SeinaPainike(ylosPainike);

		alas.paina();
		ylos.paina();
		ylos.paina();
		alas.paina();
		alas.paina();

		/* Ohjelman ajon tulostukset:
		 * 
		 * Valkokangas lasketaan alas. 
		 * Valkokangas nostetaan ylös. 
		 * Valkokangas on jo ylhäällä. 
		 * Valkokangas lasketaan alas. 
		 * Valkokangas on jo alhaalla.
		 */

	}
}
