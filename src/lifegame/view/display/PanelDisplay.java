package lifegame.view.display;

import lifegame.model.Cell;
import lifegame.model.Grid;

import javax.swing.*;
import java.awt.*;

public class PanelDisplay extends JPanel
{
	// Constants
	private static final Color BORDER = Color.GRAY;
	private static final Color ALIVE  = Color.BLACK;
	private static final Color DEAD   = Color.WHITE;


	// Attributes
	private Cell[][] cells;

	private Point origin;
	private int   cellSize;
	private int   innerWidth;
	private int   innerHeight;


	// Constructor
	public PanelDisplay(Grid grid, Dimension screen)
	{
		this.cells = grid.getCells();

		this.origin = new Point();
		this.setMinimumSize(new Dimension(106, 106));
		this.setPreferredSize(new Dimension((int) (0.75 * screen.width), (int) (0.95 * screen.height)));
	}


	// Methods
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		// Draw border
		g.setColor(BORDER);
		g.fillRect(this.origin.x, this.origin.y, this.innerWidth + 6, this.innerHeight + 6);

		// Draw dead cells
		g.setColor(DEAD);
		g.fillRect(this.origin.x + 3, this.origin.y + 3, this.innerWidth, this.innerHeight);

		// Draw alive cells
		g.setColor(ALIVE);
		Point cellOrigin = new Point(this.origin.x + 3, this.origin.y + 3);
		for (int l = 1; l < this.cells.length - 1; l++, cellOrigin.y += this.cellSize, cellOrigin.x = this.origin.x + 3)
			for (int c = 1; c < this.cells[l].length - 1; c++, cellOrigin.x += this.cellSize)
				if (this.cells[l][c].getState())
					g.fillRect(cellOrigin.x, cellOrigin.y, this.cellSize, this.cellSize);
	}

	public void majDimension()
	{
		Dimension size = this.getSize();

		// Cells size calculation
		int nbCellH = this.cells[0].length - 2;
		int nbCellV = this.cells   .length - 2;

		this.cellSize = Math.min((size.width  - 6) / nbCellH, (size.height - 6) / nbCellV);

		// Inner size calculation
		this.innerWidth  = nbCellH * this.cellSize;
		this.innerHeight = nbCellV * this.cellSize;

		// Drawing origin calculation
		this.origin.x = (size.width  - this.innerWidth  - 6) / 2;
		this.origin.y = (size.height - this.innerHeight - 6) / 2;
	}
}
