package handlers;

public class LahiEsimies extends Handler {

	public LahiEsimies(Handler s) {
		super(s);
	}

	public Boolean handleRase(float oldPay, float newPay) {

		if (newPay/oldPay<=1.2) {
			System.out.println("Lähiesimies käsitteli pyynnön");
			onnistuikoKasittely = true;
		} else {
			super.nextHandler(oldPay, newPay);
		}
		return onnistuikoKasittely;
	}
}
