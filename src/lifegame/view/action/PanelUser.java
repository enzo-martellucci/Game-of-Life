package lifegame.view.action;

import lifegame.Controller;
import lifegame.model.Grid;

import javax.swing.*;
import java.awt.*;

public class PanelUser extends JPanel
{
	// Attributes
	private PanelAction     panelAction;
	private PanelGeneration panelGeneration;
	private PanelSize       panelSize;
	private PanelDelay      panelDelay;


	// Constructor
	public PanelUser(Controller ctrl, Grid grid)
	{
		// Parameters
		this.setLayout(new BorderLayout());

		// Creation
		this.panelAction     = new PanelAction    (ctrl);
		this.panelGeneration = new PanelGeneration(ctrl);
		this.panelSize       = new PanelSize      (ctrl, grid);
		this.panelDelay      = new PanelDelay     (ctrl);

		// Positioning
		JPanel panelTmp = new JPanel();
		panelTmp.setLayout(new BoxLayout(panelTmp, BoxLayout.Y_AXIS));

		panelTmp.add(this.panelAction);
		panelTmp.add(new JSeparator());
		panelTmp.add(this.panelGeneration);
		panelTmp.add(new JSeparator());
		panelTmp.add(this.panelSize);
		panelTmp.add(new JSeparator());
		panelTmp.add(this.panelDelay);
		panelTmp.add(new JSeparator());

		this.add(panelTmp, BorderLayout.NORTH);
	}

	public void majAction()
	{
		this.panelAction.maj();
	}
}
