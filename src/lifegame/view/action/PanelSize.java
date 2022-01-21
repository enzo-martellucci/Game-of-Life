package lifegame.view.action;

import lifegame.Controller;
import lifegame.model.Grid;

import javax.swing.*;
import java.awt.*;

public class PanelSize extends JPanel
{
	// Attributes
	private Controller ctrl;

	private JSlider sldLine;
	private JSlider sldCol;
	private JTextField txtLine;
	private JTextField txtCol;
	private JButton btnLinked;


	// Constructor
	PanelSize(Controller ctrl)
	{
		// Parameters
		this.ctrl = ctrl;
//		this.setLayout(new GridLayout(2, 3, 5, 5));
		this.setLayout(new BorderLayout(5, 5));
		this.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));

		// Creation and parameters
		this.sldLine   = new JSlider();
		this.sldCol    = new JSlider();
		this.txtLine   = new JTextField(5);
		this.txtCol    = new JTextField(5);
		this.btnLinked = new JButton("|");

		this.sldLine.setPreferredSize(new Dimension(100, 20));
		this.sldCol .setPreferredSize(new Dimension(100, 20));

		// Positioning
		JPanel panelLbl = new JPanel(new GridLayout(2, 1, 5, 5));
		JPanel panelTxt = new JPanel(new GridLayout(2, 1, 5, 5));
		JPanel panelSld = new JPanel(new GridLayout(2, 1, 5, 5));

		panelLbl.add(new JLabel("Lines : "));
		panelLbl.add(new JLabel("Columns : "));

		panelTxt.add(this.txtLine);
		panelTxt.add(this.txtCol);

		panelSld.add(this.sldLine);
		panelSld.add(this.sldCol);

		this.add(panelLbl, BorderLayout.WEST);
		this.add(panelTxt, BorderLayout.CENTER);
		this.add(panelSld, BorderLayout.EAST);
	}
}
