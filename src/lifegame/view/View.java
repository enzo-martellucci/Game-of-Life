package lifegame.view;

import lifegame.Controller;
import lifegame.model.Grid;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame
{
	// Attributes
	private JPanel panelLife;


	// Constructor
	public View(Controller ctrl, Grid grid)
	{
		this.panelLife = new PanelLife(grid);
		this.add(this.panelLife);


		// Parameters
		this.setTitle("Game of Life");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}


	// Methods
	public void maj()
	{
		this.panelLife.repaint();
	}
}
