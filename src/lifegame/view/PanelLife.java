package lifegame.view;

import lifegame.Controller;
import lifegame.model.Cell;
import lifegame.model.Grid;

import javax.swing.*;
import java.awt.*;

public class PanelLife extends JPanel
{
	// Attributes
	private Cell[][] cells;


	// Constructor
	PanelLife(Grid grid)
	{
		this.cells = grid.getCells();

		this.setPreferredSize(new Dimension(1000, 1000));
	}


	// Methods
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		g.setColor(Color.BLACK);
		for (int l = 1; l < this.cells.length - 1; l++)
			for (int c = 1; c < this.cells[l].length - 1; c++)
				if (this.cells[l][c].getState())
					g.fillRect(c * 10, l * 10, 10, 10);
	}
}
