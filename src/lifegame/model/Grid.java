package lifegame.model;

import lifegame.model.util.Filler;

public class Grid
{
	// Constants
	private static final int INITIAL_HEIGHT = 100;
	private static final int INITIAL_WIDTH  = 100;


	// Attributes
	private boolean[][] cells;


	// Constructor / Initialisation
	public Grid()
	{
		this.initGrid(INITIAL_HEIGHT, INITIAL_WIDTH);
		this.random();
	}

	private void initGrid(int line, int col)
	{
		this.cells = new boolean[line + 2][col + 2];
	}

	private boolean calcNext(int l, int c)
	{
		int aliveNeighbors = 0;

		if (this.cells[l-1][c-1]) aliveNeighbors++;
		if (this.cells[l-1][c  ]) aliveNeighbors++;
		if (this.cells[l-1][c+1]) aliveNeighbors++;

		if (this.cells[l  ][c-1]) aliveNeighbors++;
		if (this.cells[l  ][c+1]) aliveNeighbors++;

		if (this.cells[l+1][c-1]) aliveNeighbors++;
		if (this.cells[l+1][c  ]) aliveNeighbors++;
		if (this.cells[l+1][c+1]) aliveNeighbors++;

		return this.cells[l][c] && (aliveNeighbors == 2 || aliveNeighbors == 3) || !this.cells[l][c] && aliveNeighbors == 3;
	}


	// Getters
	public int getNbLine()
	{
		return this.cells   .length - 2;
	}
	public int getNbCol ()
	{
		return this.cells[0].length - 2;
	}

	public boolean[][] getCells()
	{
		return this.cells;
	}


	// Methods
	public void next()
	{
		boolean[][] nextCells = new boolean[this.cells.length][this.cells[0].length];

		for (int l = 1, lMax = this.cells.length - 1, cMax = this.cells[0].length - 1; l < lMax; l++)
			for (int c = 1; c < cMax; c++)
				nextCells[l][c] = this.calcNext(l, c);

		this.cells = nextCells;
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
