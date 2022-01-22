package lifegame.model.util;

import lifegame.model.Cell;

import java.util.Random;

public final class Filler
{
	private Filler(){}

	public static void random(Cell[][] cells)
	{
		Random random = new Random();

		for (int l = 1; l < cells.length - 1; l++)
			for (int c = 1; c < cells[l].length - 1; c++)
				cells[l][c].setState(random.nextBoolean());
	}

	public static void randomS(Cell[][] cells)
	{
		Random random = new Random();

		for (int l = 1; l < cells.length - 1; l++)
		{
			for (int c = 1; c < cells[l].length / 2; c++)
			{
				boolean b = random.nextBoolean();
				cells[l][c].setState(b);
				cells[l][cells[l].length - 1 - c].setState(b);
			}
		}
	}

	public static void randomDS(Cell[][] cells)
	{
		Random random = new Random();

		for (int l = 1; l < cells.length / 2; l++)
		{
			for (int c = 1; c < cells[l].length / 2; c++)
			{
				boolean b = random.nextBoolean();
				cells[l][c].setState(b);
				cells[l][cells[l].length - 1 - c].setState(b);
				cells[cells.length - 1 - l][c].setState(b);
				cells[cells.length - 1 - l][cells[l].length - 1 - c].setState(b);
			}
		}
	}
}
