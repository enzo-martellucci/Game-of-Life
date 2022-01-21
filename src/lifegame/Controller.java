package lifegame;

import lifegame.model.Grid;
import lifegame.view.View;

import javax.swing.*;

public class Controller
{
	// Attributes
	private Grid grid;
	private View view;


	// Constructor
	private Controller()
	{
		this.grid = new Grid();
		this.view = new View(this, this.grid);

		this.view.maj();
		for (int i = 0; i < 10000; i++)
		{
			try
			{
				Thread.sleep(1);
			}
			catch (Exception e){ e.printStackTrace(); }
			this.grid.next();
			this.view.maj();
		}
	}


	// Methods
	public void playPause()
	{
		System.out.println("Play Pause");
	}

	public void next()
	{
		System.out.println("Next");
	}

	public void previous()
	{
		System.out.println("Previous");
	}

	public void restart()
	{
		System.out.println("Restart");
	}

	public void load()
	{
		System.out.println("Load");
	}

	public void save()
	{
		System.out.println("Save");
	}


	// Main
	public static void main(String[] args)
	{
		new Controller();
	}
}
