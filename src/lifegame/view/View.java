package lifegame.view;

import lifegame.Controller;
import lifegame.model.Grid;
import lifegame.view.display.PanelDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class View extends JFrame
{
	// Attributes
	private PanelDisplay panelDisplay;
//	private PanelAction  panelAction ;


	// Constructor
	public View(Controller ctrl, Grid grid)
	{
		// Calculate screen size
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

		// Creation and positioning
		this.panelDisplay = new PanelDisplay(grid, screen);
//		this.panelAction  = new PanelAction (grid, ctrl, screen);

		this.add(this.panelDisplay, BorderLayout.CENTER);
//		this.add(this.panelAction , BorderLayout.EAST  );

		// Component dimension maj
		this.pack();
		this.panelDisplay.majDimension();

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
}
