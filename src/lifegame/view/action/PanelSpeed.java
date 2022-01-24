package lifegame.view.action;

import lifegame.Controller;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class PanelSpeed extends JPanel implements ChangeListener
{
	// Attributes
	private Controller ctrl;

	private JSlider    sldSpeed;


	// Constructor
	PanelSpeed(Controller ctrl)
	{
		// Parameters
		this.ctrl = ctrl;
		this.setLayout(new GridLayout(2, 1, 5, 5));
		this.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));

		// Creation
		this.sldSpeed = new JSlider();

		this.sldSpeed.setSnapToTicks(true);

		// Listen event
		this.sldSpeed.addChangeListener(this);

		// Positioning
		this.add(new JLabel("Speed (1s -> 1ms delay) : "));
		this.add(this.sldSpeed);

		// Init speed
		this.ctrl.changeSpeed(this.sldSpeed.getValue());
	}


	// Methods
	public void stateChanged(ChangeEvent e)
	{
		this.ctrl.changeSpeed(this.sldSpeed.getValue());
	}
}
