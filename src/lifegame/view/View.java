package lifegame.view;

import lifegame.Controller;
import lifegame.model.Grid;
import lifegame.view.action.PanelUser;
import lifegame.view.display.PanelDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class View extends JFrame
{
	// Attributes
	private PanelDisplay panelDisplay;
	private PanelUser    panelUser;


	// Constructor
	public View(Controller ctrl, Grid grid)
	{
		// Creation and positioning
		this.panelDisplay = new PanelDisplay(grid);
		this.panelUser    = new PanelUser(ctrl, grid);

		this.add(this.panelDisplay, BorderLayout.CENTER);
		this.add(this.panelUser   , BorderLayout.EAST  );

		// Component dimensioning
		this.pack();
		this.majDimension();

		// Listen for Frame resizing
		this.addComponentListener(new ComponentAdapter()
		{
			public void componentResized(ComponentEvent e)
			{
				View.this.panelDisplay.majDimension();
			}
		});

		// Parameters
		this.setTitle("Game of Life");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void maj()
	{
		this.panelDisplay.repaint();
	}

	public void majAction()
	{
		this.panelUser.majAction();
	}
	public void majDimension()
	{
		this.panelDisplay.majDimension();
	}

	public int getMaxLine()
	{
		return this.panelDisplay.getMaxLine();
	}
	public int getMaxCol ()
	{
		return this.panelDisplay.getMaxCol();
	}
}
