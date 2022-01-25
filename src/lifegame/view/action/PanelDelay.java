package lifegame.view.action;

import lifegame.Controller;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class PanelDelay extends JPanel implements ChangeListener
{
	// Attributes
	private Controller ctrl;

	private JSlider sldDelay;


	// Constructor
	PanelDelay(Controller ctrl)
	{
		// Parameters
		this.ctrl = ctrl;
		this.setLayout(new BorderLayout(0, 5));
		this.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

		// Creation
		this.sldDelay = new JSlider();
		this.sldDelay.setSnapToTicks(true);
		this.sldDelay.setPreferredSize(new Dimension(150, 20));

		// Listen event
		this.sldDelay.addChangeListener(this);

		// Positioning
		this.add(new JLabel("Delay (1s -> 1ms) :"), BorderLayout.NORTH);
		this.add(this.sldDelay, BorderLayout.SOUTH);

		// Init speed
		this.ctrl.changeSpeed(this.sldDelay.getValue());
	}


	// Methods
	public void stateChanged(ChangeEvent e)
	{
		this.ctrl.changeSpeed(this.sldDelay.getValue());
	}
}
