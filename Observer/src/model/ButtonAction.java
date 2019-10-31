package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonAction implements ActionListener {

	private Clock clock = new Clock();
	@Override
	public void actionPerformed(ActionEvent e) {
		if (clock.timer.isRunning()){
			clock.stopClock();
		} else {
			clock.restartClock();
		}
	}	
}