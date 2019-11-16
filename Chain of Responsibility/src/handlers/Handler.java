package handlers;

public abstract class Handler {
	
	private Handler successor;
	protected Boolean onnistuikoKasittely = false;
	
	public Handler(Handler s) {
		successor = s;
	}
	
	public void nextHandler(float oldPay, float newPay) {
		if(successor!=null) {
			successor.handleRase(oldPay, newPay);
		}
	}
	
	public Boolean handleRase(float oldPay, float newPay) {
		return false;
	}
}
