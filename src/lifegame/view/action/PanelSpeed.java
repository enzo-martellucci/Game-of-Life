package lifegame.view.action;

import lifegame.Controller;

import javax.swing.*;
import java.awt.*;

public class PanelSpeed extends JPanel
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

		// Positioning
		this.add(new JLabel("Speed (1ms - 5s delay) : "));
		this.add(this.sldSpeed);
	}
}
