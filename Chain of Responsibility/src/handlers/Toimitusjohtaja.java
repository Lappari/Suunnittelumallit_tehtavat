package handlers;

public class Toimitusjohtaja extends Handler {
	
	public Toimitusjohtaja(Handler s) {
		super(s);
	}

	public Boolean handleRase(float oldPay, float newPay) {

		if (newPay / oldPay >= 1.5) {
			System.out.println("Toimitusjohtaja käsitteli pyynnön");
			onnistuikoKasittely = true;
		} else {
			super.nextHandler(oldPay, newPay);
		}
		return onnistuikoKasittely;
	}
}
