package lifegame.view.action;

import lifegame.Controller;
import lifegame.view.util.UIFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelGeneration extends JPanel implements ActionListener
{
	// Attributes
	Controller ctrl;

	private JButton btnRandom;
	private JButton btnRandomS;
	private JButton btnRandomDS;


	// Construtor
	PanelGeneration(Controller ctrl)
	{
		// Parameters
		this.ctrl = ctrl;
		this.setLayout(new GridLayout(1, 3, 30, 30));
		this.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

		// Creation
		this.btnRandom   = UIFactory.createBtn("random.png");
		this.btnRandomS  = UIFactory.createBtn("randomS.png");
		this.btnRandomDS = UIFactory.createBtn("randomDS.png");

		// Listen event
		this.btnRandom  .addActionListener(this);
		this.btnRandomS .addActionListener(this);
		this.btnRandomDS.addActionListener(this);

		// Positioning
		this.add(this.btnRandom);
		this.add(this.btnRandomS);
		this.add(this.btnRandomDS);
	}

	public void actionPerformed(ActionEvent e)
	{
		Object src = e.getSource();

		if      (src == this.btnRandom  ){ this.ctrl.random  (); }
		else if (src == this.btnRandomS ){ this.ctrl.randomS (); }
		else if (src == this.btnRandomDS){ this.ctrl.randomDS(); }
	}
}
