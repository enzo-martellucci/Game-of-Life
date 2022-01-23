package lifegame.model;

import lifegame.model.util.Filler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.BitSet;

public class Grid
{
	// Constants
	private static final int INITIAL_HEIGHT = 100;
	private static final int INITIAL_WIDTH  = 100;


	// Attributes
	private boolean[][] cells;
	private BitSet [][] history;
	private int         counter;


	// Constructor / Initialisation
	public Grid()
	{
		this.initGrid(INITIAL_HEIGHT, INITIAL_WIDTH);
		this.random();
	}

	private void initGrid(int line, int col)
	{
		this.cells   = new boolean[line + 2][col + 2];
		this.history = new BitSet [line + 2][col + 2];

		for (int l = 0; l < this.history.length; l++)
			for (int c = 0; c < this.history[l].length; c++)
				this.history[l][c] = new BitSet();
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


	// Generation methods
	public void random()
	{
		Filler.random(this.cells);
		this.initMemory();
	}

	public void randomS()
	{
		Filler.randomS(this.cells);
		this.initMemory();
	}

	public void randomDS()
	{
		Filler.randomDS(this.cells);
		this.initMemory();
	}


	// Action methods
	public void next()
	{
		this.counter++;

		// go to next step and store it in history
		boolean[][] nextCells = new boolean[this.cells.length][this.cells[0].length];

		for (int l = 1, lMax = this.cells.length - 1, cMax = this.cells[0].length - 1; l < lMax; l++)
			for (int c = 1; c < cMax; c++)
				nextCells[l][c] = this.next(l, c);

		this.cells = nextCells;

		// clear a part of history if necessary
		if (this.counter == 512)
			this.majMemory();
	}

	private boolean next(int l, int c)
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

		boolean next = this.cells[l][c] && (aliveNeighbors == 2 || aliveNeighbors == 3) || !this.cells[l][c] && aliveNeighbors == 3;
		this.history[l][c].set(this.counter, next);
		return next;
	}

	public void previous()
	{
		if (this.counter == 0)
			return;

		this.counter--;
		for (int l = 1, lMax = this.cells.length - 1, cMax = this.cells[0].length - 1; l < lMax; l++)
			for (int c = 1; c < cMax; c++)
				this.cells[l][c] = this.history[l][c].get(this.counter);
	}

	public void restart()
	{

	}

	public void save(String name)
	{
		File directory = new File("./saved");
		if (!directory.exists())
			directory.mkdir();

		try (PrintWriter pw = new PrintWriter("./saved/" + name + ".cells"))
		{
			for (int l = 1, lMax = this.cells.length - 1, cMax = this.cells[0].length - 1; l < lMax; l++, pw.println())
				for (int c = 1; c < cMax; c++)
					pw.print(this.cells[l][c] ? 'O' : '.');
		}
		catch (Exception e){ e.printStackTrace(); }
	}

	public void load()
	{

	}

	// Memory methods
	private void initMemory()
	{
		for (int l = 1, lMax = this.history.length - 1, cMax = this.history[0].length - 1; l < lMax; l++)
			for (int c = 1; c < cMax; c++)
				this.history[l][c].set(0, this.cells[l][c]);
		this.counter = 0;
	}

	private void majMemory()
	{
		for (int l = 1, lMax = this.history.length - 1, cMax = this.history[0].length - 1; l < lMax; l++)
			for (int c = 1; c < cMax; c++)
				this.history[l][c] = this.history[l][c].get(256, 513);
		this.counter = 256;
	}
}
