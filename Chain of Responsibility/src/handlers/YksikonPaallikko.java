package handlers;

public class YksikonPaallikko extends Handler{

	public YksikonPaallikko(Handler s) {
		super(s);
	}
	
	public Boolean handleRase(float oldPay, float newPay) {
		
		if(newPay / oldPay > 1.2 && newPay / oldPay <= 1.5) {
			System.out.println("Yksikön päällikkö käsitteli pyynnön");
			onnistuikoKasittely = true;
		}else {
			super.nextHandler(oldPay, newPay);
		}
		return onnistuikoKasittely;
	}

}
