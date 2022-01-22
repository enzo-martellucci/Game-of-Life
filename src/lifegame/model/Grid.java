package lifegame.model;

import lifegame.model.util.Filler;

public class Grid
{
	// Constants
	private static final int INITIAL_HEIGHT = 100;
	private static final int INITIAL_WIDTH  = 100;


	// Attributes
	private Cell[][] cells;


	// Constructor / Initialisation
	public Grid()
	{
		this.initGrid(INITIAL_HEIGHT, INITIAL_WIDTH);
		this.random();
	}

	private void initGrid(int line, int col)
	{
		this.cells = new Cell[INITIAL_HEIGHT + 2][INITIAL_WIDTH + 2];

		for (int l = 0; l < this.cells.length; l++)
			for (int c = 0; c < this.cells[l].length; c++)
				this.cells[l][c] = new Cell();

		for (int l = 1, lMax = this.cells.length - 1, cMax = this.cells[0].length - 1; l < lMax; l++)
			for (int c = 1; c < cMax; c++)
				this.cells[l][c].initNeighbors(this.getNeighbors(l, c));
	}

	private Cell[] getNeighbors(int l, int c)
	{
		return new Cell[]
		{
			this.cells[l-1][c-1], this.cells[l-1][c  ], this.cells[l-1][c+1],
			this.cells[l  ][c-1],                       this.cells[l  ][c+1],
			this.cells[l+1][c-1], this.cells[l+1][c  ], this.cells[l+1][c+1]
		};
	}


	// Getters
	public Cell[][] getCells()
	{
		return this.cells;
	}


	// Methods
	public void next()
	{
		for (int l = 1, lMax = this.cells.length - 1, cMax = this.cells[0].length - 1; l < lMax; l++)
			for (int c = 1; c < cMax; c++)
				this.cells[l][c].calcNext();

		for (int l = 1, lMax = this.cells.length - 1, cMax = this.cells[0].length - 1; l < lMax; l++)
			for (int c = 1; c < cMax; c++)
				this.cells[l][c].next();
	}

	public void random  ()
	{
		Filler.random  (this.cells);
	}
	public void randomS ()
	{
		Filler.randomS (this.cells);
	}
	public void randomDS()
	{
		Filler.randomDS(this.cells);
	}
}
