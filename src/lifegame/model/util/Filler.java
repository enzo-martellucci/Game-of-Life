package lifegame.model.util;

import java.util.Random;

public final class Filler
{
	private Filler(){}

	public static void random(boolean[][] cells)
	{
		Random random = new Random();

		for (int l = 1; l < cells.length - 1; l++)
			for (int c = 1; c < cells[l].length - 1; c++)
				cells[l][c] = random.nextBoolean();
	}

	public static void randomS(boolean[][] cells)
	{
		Random random = new Random();

		for (int l = 1; l < cells.length - 1; l++)
			for (int c = 1; c < cells[l].length / 2; c++)
				cells[l][c] = cells[l][cells[l].length-1-c] = random.nextBoolean();
	}

	public static void randomDS(boolean[][] cells)
	{
		Random random = new Random();

		for (int l = 1; l < cells.length / 2; l++)
			for (int c = 1; c < cells[l].length / 2; c++)
				cells[l][c] =
				cells[l][cells[l].length-1-c] =
				cells[cells.length-1-l][c] =
				cells[cells.length-1-l][cells[l].length-1-c] =
				random.nextBoolean();
	}
}
