package view;

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.ButtonAction;
import model.Clock;

public class DigitalClock implements Observer {

	private JLabel label = new JLabel();
	private JButton button = new JButton("Start/Stop");
	private static JFrame frame = new JFrame("Clock");
	
	public DigitalClock(Clock clock){
		this.mountDisplay();
		clock.addObserver(this);
	}

	public void mountDisplay(){  
		JPanel panel = new JPanel();   

		panel.add(label);
		panel.add(button);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));

		label.setFont(new Font("Arial", Font.ITALIC, 25));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   

		frame.getContentPane().add(panel);   

		frame.setResizable(false);   
		frame.setBounds(200, 200, 500, 110);
		frame.setLocationRelativeTo(null);  
		frame.setVisible(true); 
		button.addActionListener(new ButtonAction());
	}   

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("Kello: " + arg1);
		label.setText((String)arg1);
	}
}
