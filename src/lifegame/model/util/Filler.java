package lifegame.model.util;

import java.io.FileInputStream;
import java.util.Random;
import java.util.Scanner;

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
			for (int c = 1; c < cells[l].length / 2 + 1; c++)
				cells[l][c] = cells[l][cells[l].length-1-c] = random.nextBoolean();
	}

	public static void randomDS(boolean[][] cells)
	{
		Random random = new Random();

		for (int l = 1; l < cells.length / 2 + 1; l++)
			for (int c = 1; c < cells[l].length / 2 + 1; c++)
				cells[l               ][c                  ] =
				cells[l               ][cells[l].length-1-c] =
				cells[cells.length-1-l][c                  ] =
				cells[cells.length-1-l][cells[l].length-1-c] =
				random.nextBoolean();
	}

	public static void file(boolean[][] cells, String file)
	{
		try (Scanner sc = new Scanner(new FileInputStream(file)))
		{
			String line;
			for (int l = 0; sc.hasNextLine(); l++)
			{
				line = sc.nextLine();
				if (line.isBlank()) continue;
				for (int c = 0, cMax = line.length(); c < cMax; c++)
					cells[l+1][c+1] = line.charAt(c) == 'O';
			}
		}
		catch (Exception e){ e.printStackTrace(); }
	}
}
