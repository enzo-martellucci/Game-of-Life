package lifegame.model;

public class Cell
{
	// Attributes
	private Cell[] neighbors;

	private boolean cState;
	private boolean nState;


	// Constructor / Initialisation
	Cell()
	{
		this.neighbors = new Cell[8];

		this.cState = false;
		this.nState = false;
	}

	void initNeighbors(Cell[] neighbors)
	{
		this.neighbors = neighbors;
	}


	// Getters
	public boolean getState()
	{
		return this.cState;
	}


	// Setters
	public void setState(boolean state)
	{
		this.cState = state;
	}


	// Methods
	void calcNext()
	{
		int aliveNeighbors = 0;

		for (Cell c : this.neighbors)
			if (c.cState)
				aliveNeighbors++;

		this.nState = ( this.cState && (aliveNeighbors == 2 || aliveNeighbors == 3)) || (!this.cState && aliveNeighbors == 3);
	}

	void next()
	{
		this.cState = this.nState;
	}
}
