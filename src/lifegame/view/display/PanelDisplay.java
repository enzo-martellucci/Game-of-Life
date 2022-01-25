package lifegame.view.display;

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
	private Grid grid;

	private Point origin;
	private int   cellSize;
	private int   innerWidth;
	private int   innerHeight;


	// Constructor
	public PanelDisplay(Grid grid)
	{
		this.grid = grid;

		this.origin = new Point();
		this.setPreferredSize(new Dimension(5000, 5000));
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
		boolean[][] cells = this.grid.getCells();

		g.setColor(ALIVE);
		Point cellOrigin = new Point(this.origin.x + 3, this.origin.y + 3);
		for (int l = 1; l < cells.length - 1; l++, cellOrigin.y += this.cellSize, cellOrigin.x = this.origin.x + 3)
			for (int c = 1; c < cells[l].length - 1; c++, cellOrigin.x += this.cellSize)
				if (cells[l][c])
					g.fillRect(cellOrigin.x, cellOrigin.y, this.cellSize, this.cellSize);
	}

	public void majDimension()
	{
		// Cells size calculation
		int nbCellH = this.grid.getNbCol ();
		int nbCellV = this.grid.getNbLine();

		this.cellSize = Math.min((this.getWidth()  - 6) / nbCellH, (this.getHeight() - 6) / nbCellV);

		// Inner size calculation
		this.innerWidth  = nbCellH * this.cellSize;
		this.innerHeight = nbCellV * this.cellSize;

		// Drawing origin calculation
		this.origin.x = (this.getWidth()  - this.innerWidth  - 6) / 2;
		this.origin.y = (this.getHeight() - this.innerHeight - 6) / 2;
	}

	public int getMaxLine()
	{
		return this.getHeight() - 6;
	}
	public int getMaxCol()
	{
		return this.getWidth() - 6;
	}
}
