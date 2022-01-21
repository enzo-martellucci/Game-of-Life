package lifegame.view.action;

import lifegame.Controller;
import lifegame.view.util.UIFactory;

import javax.swing.*;
import java.awt.*;

public class PanelGeneration extends JPanel
{
	// Attributes
	Controller ctrl;

	private JButton btnRandom;
	private JButton btnRandomSymmetric;
	private JButton btnRandomDoubleSymmetric;


	// Construtor
	PanelGeneration(Controller ctrl)
	{
		// Parameters
		this.ctrl = ctrl;
		this.setLayout(new GridLayout(1, 3, 5, 5));
		this.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));

		// Creation
		this.btnRandom                = UIFactory.createBtn("random.png");
		this.btnRandomSymmetric       = UIFactory.createBtn("randomS.png");
		this.btnRandomDoubleSymmetric = UIFactory.createBtn("randomDS.png");

		// Positioning
		this.add(this.btnRandom);
		this.add(this.btnRandomSymmetric);
		this.add(this.btnRandomDoubleSymmetric);
	}
}
