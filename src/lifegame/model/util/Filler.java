package lifegame.model.util;

import lifegame.model.Cell;

import java.util.Random;

public final class Filler
{
	private Filler(){}

	public static void random(Cell[][] cells)
	{
		Random random = new Random((long)(Math.random() * Long.MAX_VALUE));

		for (int l = 1; l < cells.length - 1; l++)
			for (int c = 1; c < cells[l].length - 1; c++)
				cells[l][c].setState(random.nextBoolean());
	}
}
