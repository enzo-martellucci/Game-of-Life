package lifegame.view.action;

import lifegame.Controller;
import lifegame.model.Grid;
import lifegame.view.util.UIFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelSize extends JPanel implements ActionListener
{
	// Attributes
	private Controller ctrl;
	private Grid grid;

	private boolean linked;

	private JTextField txtLine;
	private JTextField txtCol;
	private JButton btnLinked;


	// Constructor
	PanelSize(Controller ctrl, Grid grid)
	{
		// Parameters
		this.ctrl = ctrl;
		this.grid = grid;

		this.linked = true;

		this.setLayout(new BorderLayout(10, 0));
		this.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

		// Creation and parameters
		this.txtLine   = new JTextField("" + this.grid.getNbLine());
		this.txtCol    = new JTextField("" + this.grid.getNbCol ());
		this.btnLinked = UIFactory.createBtn("link.png");

		this.txtLine.setHorizontalAlignment(JTextField.RIGHT);
		this.txtCol .setHorizontalAlignment(JTextField.RIGHT);

		// Listen event
		this.txtLine  .addActionListener(this);
		this.txtCol   .addActionListener(this);
		this.btnLinked.addActionListener(this);

		// Positioning
		JPanel panelLbl = new JPanel(new GridLayout(2, 1, 0, 10));
		JPanel panelTxt = new JPanel(new GridLayout(2, 1, 0, 10));

		panelLbl.add(UIFactory.createLbl("height.png"));
		panelLbl.add(UIFactory.createLbl("width.png"));
		panelTxt.add(this.txtLine);
		panelTxt.add(this.txtCol);

		JPanel panelTmp = new JPanel(new BorderLayout(10, 0));

		panelTmp.add(panelLbl, BorderLayout.WEST);
		panelTmp.add(panelTxt, BorderLayout.CENTER);

		this.add(panelTmp, BorderLayout.CENTER);
		this.add(this.btnLinked, BorderLayout.EAST);
	}


	// Methods
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == this.btnLinked)
		{
			this.linked = !this.linked;
			UIFactory.useDesign(this.btnLinked, this.linked ? "link.png" : "no-link.png");
			return;
		}

		if (this.linked)
		{
			if (e.getSource() == this.txtLine)
			{
				double ratio = Integer.parseInt(this.txtLine.getText()) / (double) this.grid.getNbLine();
				int    nbCol = (int) (ratio * this.grid.getNbCol());
				this.txtCol.setText("" + nbCol);
			}
			else
			{
				double ratio  = Integer.parseInt(this.txtCol.getText()) / (double) this.grid.getNbCol();
				int    nbLine = (int) (ratio * this.grid.getNbLine());
				this.txtLine.setText("" + nbLine);
			}
		}

		this.ctrl.changeSize(Integer.parseInt(this.txtLine.getText()), Integer.parseInt(this.txtCol.getText()));
	}

	public void majDimension()
	{
		this.txtLine.setText("" + this.grid.getNbLine());
		this.txtCol .setText("" + this.grid.getNbCol ());
	}
}
