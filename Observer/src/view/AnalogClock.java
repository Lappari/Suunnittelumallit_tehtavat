package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.time.LocalTime;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model.Clock;

public class AnalogClock  {

	public AnalogClock(Clock clock) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException ex) {
					ex.printStackTrace();
				}

				JFrame frame = new JFrame("AnalogClock");
				frame.setLocation(100,100);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.add(new ClockFace(clock));
				frame.pack();
				frame.setVisible(true);
			}
		});
	}

	@SuppressWarnings("serial")
	public class ClockFace extends JPanel implements Observer{
		
		public ClockFace(Clock clock) {
			clock.addObserver(this);
		}

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(600, 600);
		}

		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D) g.create();

			LocalTime now = LocalTime.now();
			int seconds = now.getSecond();
			int minutes = now.getMinute();
			int hours = now.getHour();

			g2d.setColor(Color.BLACK);
			g2d.fillRect(0, 0, 600, 600);
			g2d.setColor(Color.WHITE);
			g2d.translate(300, 300);

			// Drawing the hour markers
			for (int i = 0; i < 12; i++) {

				g2d.drawLine(0, -260, 0, -300);
				g2d.rotate(Math.PI / 6);

			}

			g2d.rotate(seconds * Math.PI / 30);
			g2d.drawLine(0, 0, 0, -290);

			g2d.rotate(2 * Math.PI - seconds * Math.PI / 30);
			g2d.rotate(minutes * Math.PI / 30);
			g2d.setStroke(new BasicStroke(3));
			g2d.drawLine(0, 0, 0, -250);

			g2d.rotate(2 * Math.PI - minutes * Math.PI / 30);
			g2d.rotate(hours * Math.PI / 6);
			g2d.setStroke(new BasicStroke(6));
			g2d.drawLine(0, 0, 0, -200);

			g2d.dispose();
		}

		@Override
		public void update(Observable o, Object arg) {
			repaint();	
		}

	}

}
